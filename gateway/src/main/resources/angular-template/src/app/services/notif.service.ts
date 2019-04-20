import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import { Subject } from 'rxjs/Subject';
import {NotificationEvent} from "../models/notificationEvent.model";

@Injectable()
export class NotifService {

  constructor(private httpClient: HttpClient) {}


  private notifs: NotificationEvent[] = [];
  notifSubject = new Subject<NotificationEvent[]>();

  emitNotif() {
    this.notifSubject.next(this.notifs.slice());
  }

  addUser(notif: NotificationEvent) {
    this.notifs.push(notif);
    this.emitNotif()
  }

  getNotifications(pseudoUser: string) {
    let url = "http://localhost:8095/notification/" + pseudoUser;

    this.httpClient.get<any[]>(url).subscribe(
      res => {
        this.notifs = res;
        this.emitNotif();
        console.log(this.notifs);
      },
      err => {
        alert('ERROR !');
      }
    );
  }
}
