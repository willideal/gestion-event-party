import { Component, OnInit } from '@angular/core';
import {NotificationEvent} from "../models/notificationEvent.model";
import {NotifService} from "../services/notif.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {

  }

}
