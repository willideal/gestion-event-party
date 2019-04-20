import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {User} from "../../models/user.model";
import {EventService} from "../../services/event.service";
import {EventPrivate} from "../../models/eventPrivate.model";

@Component({
  selector: 'app-create-event-private',
  templateUrl: './create-event-private.component.html',
  styleUrls: ['./create-event-private.component.scss']
})
export class CreateEventPrivateComponent implements OnInit {

  eventPrivateForm: FormGroup;
  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(private formBuilder: FormBuilder,
              private eventService: EventService,
              private router: Router) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.eventPrivateForm = this.formBuilder.group( {
      name: ['', Validators.required],
      dateEvent: ['', Validators.required],
      heure: ['', Validators.required],
      lieu: ['', Validators.required],
      pseudo: [this.sessionPseudo, Validators.required]
    });
  }

  onSubmitForm() {
    const formValue = this.eventPrivateForm.value;
    const newEventPrivate = new EventPrivate(
      formValue['name'],
      formValue['dateEvent'],
      formValue['heure'],
      formValue['lieu'],
      formValue['pseudo']
    );
    this.eventService.createEventPrivate(newEventPrivate);
    console.log(newEventPrivate);
    this.eventService.addEventPrivate(newEventPrivate);
    this.router.navigate(['/dashboard']);
  }

}
