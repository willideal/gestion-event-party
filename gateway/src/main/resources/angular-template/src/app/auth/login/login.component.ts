import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {User} from "../../models/user.model";
import {Login} from "../../models/login.model";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit() {
    this.initForm()
  }

  initForm() {
    this.loginForm = this.formBuilder.group( {
      pseudo: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmitForm() {
    const formValue = this.loginForm.value;
    const newLogin = new Login(
      formValue['pseudo'],
      formValue['password'],
    );
    this.authService.connectUser(newLogin);
    this.router.navigate(['/dashboard']);
  }

}
