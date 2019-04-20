import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {NotifService} from "../../services/notif.service";
import {NotificationEvent} from "../../models/notificationEvent.model";

@Component({
  selector: 'app-notifications-list',
  templateUrl: './notifications-list.component.html',
  styleUrls: ['./notifications-list.component.scss']
})
export class NotificationsListComponent implements OnInit, OnDestroy {

  notifs: NotificationEvent[];
  notifSubscription: Subscription;
  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(private notifService: NotifService,
              private router: Router) { }

  ngOnInit() {
    this.notifService.getNotifications(this.sessionPseudo);

    this.notifSubscription = this.notifService.notifSubject.subscribe(
      (notif: NotificationEvent[]) => {
        this.notifs = notif;
      }
    );
    this.notifService.emitNotif();
  }

  ngOnDestroy() {
    this.notifSubscription.unsubscribe();
  }

}
