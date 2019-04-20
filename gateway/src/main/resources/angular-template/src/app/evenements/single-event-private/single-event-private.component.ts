import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user.model";
import {EventPrivate} from "../../models/eventPrivate.model";
import {EventService} from "../../services/event.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-single-event-private',
  templateUrl: './single-event-private.component.html',
  styleUrls: ['./single-event-private.component.scss']
})
export class SingleEventPrivateComponent implements OnInit {

  singleEventPrivate: EventPrivate;

  constructor(private eventService: EventService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.singleEventPrivate = new EventPrivate('','','','','')

    const id = this.route.snapshot.params['id'];
    this.eventService.getEventPrivate(id).then(
      (eventPrivate: EventPrivate) => {
        this.singleEventPrivate = eventPrivate;
      }
    );
  }

}
