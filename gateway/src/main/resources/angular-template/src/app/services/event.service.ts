import {HttpClient} from "@angular/common/http";
import {User} from "../models/user.model";
import {Subject} from "rxjs";
import {EventPrivate} from "../models/eventPrivate.model";
import {Injectable} from "@angular/core";
import {EventOpenData} from "../models/eventOpenData.model";
import { DatePipe } from '@angular/common'

@Injectable()
export class EventService {
  constructor(private httpClient: HttpClient,
              public datePipe: DatePipe) {}


  eventsPrivate: EventPrivate[] = [];
  singleEventPrivate: EventPrivate;
  eventPrivateSubject = new Subject<EventPrivate[]>();

  eventsOpenData: EventOpenData[] = [];
  eventOpenDataSubject = new Subject<EventOpenData[]>();

  sessionPseudo = sessionStorage.getItem("userConnected");

  emitEventPrivate() {
    this.eventPrivateSubject.next(this.eventsPrivate.slice());
  }

  emitEventOpenData() {
    this.eventOpenDataSubject.next(this.eventsOpenData.slice());
  }


  addEventPrivate(eventPrivate: EventPrivate) {
    this.eventsPrivate.push(eventPrivate);
    this.emitEventPrivate();
  }

  addEventOpenData(eventOpenData: EventOpenData) {
    this.eventsOpenData.push(eventOpenData);
    this.emitEventOpenData()
  }

  createEventPrivate(eventPrivate: EventPrivate){

    let url = "http://localhost:8095/event";

    this.httpClient.post<any>(url, eventPrivate).subscribe(
      res => {
        console.log('OK !')
      },
      err => {
        console.log('ERROR EVENT !');
      }
    );
  }

  getAllEventPrivate(pseudoUser: string){
    let url = "http://localhost:8095/event/" + pseudoUser;

    this.httpClient.get<any[]>(url).subscribe(
      res => {
        this.eventsPrivate = res;
        this.emitEventPrivate()
        console.log(this.eventsPrivate);
      },
      err => {
        alert('ERROR !');
      }
    );
}

  getEventPrivate(id: number){

    let promise = new Promise((resolve, reject) => {
      let url = "http://localhost:8095/event/private/" + id;
      console.log("idEvent", id)
      this.httpClient.get<EventPrivate>(url)
        .toPromise()
        .then(
          res => { // Success
            this.singleEventPrivate = res;
            resolve(res);
            console.log("singleEvent", this.singleEventPrivate)
          },
          msg => { // Error
            reject(msg);
          }
        );
    });
    return promise;
  }

  getAllEventOpenData() {

    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();

    let latest_today = this.datePipe.transform(today, 'yyyy-MM-dd');



    let url = "https://data.orleans-metropole.fr/api/records/1.0/search/?dataset=evenements-publics-openagenda&facet=tags&facet=placename&facet=department&facet=region&facet=city&facet=pricing_info&facet=updated_at&facet=city_district&refine.date_start="+latest_today;

    this.httpClient.get<any[]>(url).subscribe(
      res => {
        const recupTheBall = res.records;

        for (var i = 0; i < recupTheBall.length ; i++){
          this.eventsOpenData.push(recupTheBall[i].fields);
        }

        console.log(this.eventsOpenData);
        this.emitEventOpenData();
      },
      err => {
        alert('ERROR !');
      }
    );
  }

}
