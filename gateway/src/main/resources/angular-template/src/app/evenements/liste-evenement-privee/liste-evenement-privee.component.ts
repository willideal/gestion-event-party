import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {EventService} from "../../services/event.service";
import {EventPrivate} from "../../models/eventPrivate.model";

@Component({
  selector: 'app-liste-evenement-privee',
  templateUrl: './liste-evenement-privee.component.html',
  styleUrls: ['./liste-evenement-privee.component.scss']
})
export class ListeEvenementPriveeComponent implements OnInit {

  eventsPrivate: EventPrivate[];
  eventSubscription: Subscription;

  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(private eventService: EventService,
              private router: Router) { }

  ngOnInit() {
    this.eventService.getAllEventPrivate(this.sessionPseudo)

    this.eventSubscription = this.eventService.eventPrivateSubject.subscribe(
      (eventsPrivate: EventPrivate[]) => {
        this.eventsPrivate = eventsPrivate;
      }
    );
    this.eventService.emitEventPrivate()

  }

  ngOnDestroy() {
    this.eventSubscription.unsubscribe();
  }

}
