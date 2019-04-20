import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {NotificationEvent} from "../../models/notificationEvent.model";
import {Subscription} from "rxjs";
import {NotifService} from "../../services/notif.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  notifs: NotificationEvent[];
  notifSubscription: Subscription;
  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(private notifService: NotifService) { }

  ngOnInit() {
    this.notifService.getNotifications(this.sessionPseudo);

    this.notifSubscription = this.notifService.notifSubject.subscribe(
      (notif: NotificationEvent[]) => {
        this.notifs = notif;
        console.log('taille', this.notifs.length);
      }
    );
    this.notifService.emitNotif();
  }

  ngOnDestroy() {
    this.notifSubscription.unsubscribe();
  }

}
