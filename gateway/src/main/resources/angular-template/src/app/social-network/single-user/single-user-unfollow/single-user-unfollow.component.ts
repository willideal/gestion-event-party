import { Component, OnInit } from '@angular/core';
import {Follow} from "../../../models/follow.model";
import {UserService} from "../../../services/user.service";
import {FollowService} from "../../../services/follow.service";
import {ActivatedRoute, Router} from "@angular/router";
import {User} from "../../../models/user.model";

@Component({
  selector: 'app-single-user-unfollow',
  templateUrl: './single-user-unfollow.component.html',
  styleUrls: ['./single-user-unfollow.component.scss']
})
export class SingleUserUnfollowComponent implements OnInit {

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

  onUnfollow(pseudoUser: string) {
    this.friend = new Follow(this.sessionPseudo, pseudoUser)

    this.friendService.unfollow(this.friend).then(
      () => {
        console.log('Tu as unfollow !');
        //this.friendService.addFollow(this.friend);
        this.router.navigate(['dashboard']);
      }
    )
  }

}
