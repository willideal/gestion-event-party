import {Component, OnDestroy, OnInit} from '@angular/core';
import {EventPrivate} from "../../models/eventPrivate.model";
import {Subscription} from "rxjs";
import {EventService} from "../../services/event.service";
import {Router} from "@angular/router";
import {EventOpenData} from "../../models/eventOpenData.model";

@Component({
  selector: 'app-liste-evenement-public',
  templateUrl: './liste-evenement-public.component.html',
  styleUrls: ['./liste-evenement-public.component.scss']
})
export class ListeEvenementPublicComponent implements OnInit, OnDestroy {

  eventsOpenData: EventOpenData[];
  eventOpenDataSubscription: Subscription;


  constructor(private eventService: EventService,
              private router: Router) { }

  ngOnInit() {
    this.eventService.getAllEventOpenData()

    this.eventOpenDataSubscription = this.eventService.eventOpenDataSubject.subscribe(
      (eventsOpenData: EventOpenData[]) => {
        this.eventsOpenData = eventsOpenData;
      }
    );
    this.eventService.emitEventOpenData()

  }

  ngOnDestroy() {
    this.eventOpenDataSubscription.unsubscribe();
  }

}
