import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { InscriptionComponent } from './auth/inscription/inscription.component';
import { LoginComponent } from './auth/login/login.component';
import { HeaderComponent } from './header/header.component';
import {AuthService} from "./services/auth.service";
import {AuthGuardService} from "./services/auth-guard.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import { ListUsersComponent } from './social-network/list-users/list-users.component';
import { ListFriendsComponent } from './social-network/list-friends/list-friends.component';
import { CreateOpenDataEventComponent } from './evenements/create-open-data-event/create-open-data-event.component';
import { CreateEventPrivateComponent } from './evenements/create-event-private/create-event-private.component';
import { CreateSoireeComponent } from './soiree/create-soiree/create-soiree.component';
import { ListeParticipantSoireeComponent } from './soiree/liste-participant-soiree/liste-participant-soiree.component';
import { AjouterParticipantSoireeComponent } from './soiree/ajouter-participant-soiree/ajouter-participant-soiree.component';
import { SingleSoireeComponent } from './soiree/single-soiree/single-soiree.component';
import { AjouterEventPriveSoireeComponent } from './soiree/ajouter-event-prive-soiree/ajouter-event-prive-soiree.component';
import { AjouterEventOpendataSoireeComponent } from './soiree/ajouter-event-opendata-soiree/ajouter-event-opendata-soiree.component';
import { ListeEvenementPublicComponent } from './evenements/liste-evenement-public/liste-evenement-public.component';
import { ListeEvenementPriveeComponent } from './evenements/liste-evenement-privee/liste-evenement-privee.component';
import { DashboardComponent } from './social-network/dashboard/dashboard.component';
import { AuthentificationComponent } from './auth/authentification/authentification.component';
import {UserService} from "./services/user.service";
import {FollowService} from "./services/follow.service";
import { SingleUserFollowComponent } from './social-network/single-user/single-user-follow/single-user-follow.component';
import { SingleUserUnfollowComponent } from './social-network/single-user/single-user-unfollow/single-user-unfollow.component';
import { NotifService} from "./services/notif.service";
import { NotificationsListComponent } from './social-network/notifications-list/notifications-list.component';

import {EventService} from "./services/event.service";
import { SingleEventPrivateComponent } from './evenements/single-event-private/single-event-private.component';
import {DatePipe} from "@angular/common";

const appRoutes: Routes = [
  {path: 'auth', component: AuthentificationComponent},
  {path: 'auth/inscription', component: InscriptionComponent},
  {path: 'auth/login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},

  {path: 'users', component: ListUsersComponent},
  {path: 'friends', component: ListFriendsComponent},
  {path: 'users/follow/:pseudo', component: SingleUserFollowComponent},
  {path: 'users/unfollow/:pseudo', component: SingleUserUnfollowComponent},
  {path: 'notifications', component: NotificationsListComponent},

  {path: 'event-public', component: ListeEvenementPublicComponent},
  {path: 'create-event-public', component: CreateOpenDataEventComponent},
  {path: 'event-private', component: ListeEvenementPriveeComponent},
  {path: 'create-event-private', component: CreateEventPrivateComponent},
  {path: 'event-private/:id', component: SingleEventPrivateComponent},

  {path: 'create-soiree', component: CreateSoireeComponent},
  {path: 'list-participant-soiree', component: ListeParticipantSoireeComponent},
  {path: 'soiree/:id', component: SingleSoireeComponent},

  {path: '', component: AuthentificationComponent},
];


@NgModule({
  declarations: [
    AppComponent,
    InscriptionComponent,
    LoginComponent,
    HeaderComponent,
    ListUsersComponent,
    ListFriendsComponent,
    CreateOpenDataEventComponent,
    CreateEventPrivateComponent,
    CreateSoireeComponent,
    ListeParticipantSoireeComponent,
    AjouterParticipantSoireeComponent,
    SingleSoireeComponent,
    AjouterEventPriveSoireeComponent,
    AjouterEventOpendataSoireeComponent,
    ListeEvenementPublicComponent,
    ListeEvenementPriveeComponent,
    DashboardComponent,
    AuthentificationComponent,
    SingleUserFollowComponent,
    SingleUserUnfollowComponent,
    NotificationsListComponent,
    SingleEventPrivateComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)

  ],
  providers: [
    AuthService,
    AuthGuardService,
    UserService,
    NotifService,
    FollowService,
    EventService,
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
