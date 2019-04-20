import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Follow} from "../../../models/follow.model";
import {FollowService} from "../../../services/follow.service";
import {User} from "../../../models/user.model";

@Component({
  selector: 'app-single-user-follow',
  templateUrl: './single-user-follow.component.html',
  styleUrls: ['./single-user-follow.component.scss']
})
export class SingleUserFollowComponent implements OnInit {

  friend: Follow;
  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(public userService : UserService,
              private friendService: FollowService,
              private router: Router,
              private route: ActivatedRoute) { }

  singleUser: User;

  ngOnInit() {
    this.singleUser = new User('','','','','')

    const pseudo = this.route.snapshot.params['pseudo'];
    this.userService.getUser(pseudo).then(
      (user: User) => {
        this.singleUser = user;
      }
    );
    /*alert(this.pseudo);
    this.firstName = this.userService.getUser(pseudo).firstName;
    this.lastName = this.userService.getUser(pseudo).lastName;
    this.email = this.userService.getUser(pseudo).email;*/
  }

  onFollow(pseudoUser: string) {
    this.friend = new Follow(this.sessionPseudo, pseudoUser)

    this.friendService.follow(this.friend).then(
      () => {
        console.log('Tu as follow !');
        //this.friendService.addFollow(this.friend);
        this.router.navigate(['/dashboard']);
      }
    )
  }

}
