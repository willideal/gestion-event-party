import {Component, OnDestroy, OnInit} from '@angular/core';
import {User} from "../../models/user.model";
import {Subscription} from "rxjs";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {FollowService} from "../../services/follow.service";
import {Follow} from "../../models/follow.model";
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.scss']
})
export class ListUsersComponent implements OnInit, OnDestroy {

  users: User[];
  friends: Follow[];
  friend: Follow;
  friendStatus: boolean;
  userFriends: {};

  userSubscription: Subscription;
  friendSubscription: Subscription;

  sessionPseudo = sessionStorage.getItem("userConnected");

  constructor(private userService: UserService,
              private friendService: FollowService,
              private router: Router) { }

  ngOnInit() {
    this.userService.getAllUsers();
    this.friendService.getAllAmis(this.sessionPseudo);
    //this.friendStatus = this.friendService.isFriend;

    this.userSubscription = this.userService.userSubject.subscribe(
      (users: User[]) => {
        this.users = users;
      }
    );
    this.userService.emitUsers();

   // this.userFriends  = this.isFriendNoFriend(usersss, friendsss);


    this.friendSubscription = this.friendService.friendSubject.subscribe(
      (friends: Follow[]) => {
        this.friends = friends;
        console.log("users", this.friends);
      }
    );
    this.friendService.emitFriends();

  }

  /*onViewUser(pseudoUser: string) {
    this.router.navigate(['users', pseudoUser]);
  }*/


  /*isFriendNoFriend(us, fr ) {
    var obj = [];
    var uss = {"pseudo": "", "isFriend": false};*/
    /*this.users.forEach(user => {
      this.friendService.friendString.forEach(friend =>{
        if(user.pseudo == friend){

          us.pseudo = user.pseudo;
          us.isFriend = true;


        }else {
          us.pseudo = user.pseudo;
          us.isFriend = false;
        }
      })
    });*/
    //var items: number[] = [];
   /* for(var i = 0; i < us.length; i++){
      for(var j = 0; j < fr.length; j++){
        if(us[i].pseudo == fr[j]){
          var data = {"pseudo" : fr[j], "isFriend": true};
         // uss.pseudo = fr[j];
         // uss.isFriend = true;

          obj.push(data)

        }else {
          var data = {"pseudo" : fr[j], "isFriend": false};
          for(var k = 0; k < obj.length; k++){
            if(obj[k].pseudo == fr[j]){
            //  obj.push(data)
            }

          }
        // obj.push(data)

        }
      }
    }
    console.log('commenter', obj);
    return obj;
  }*/

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
    this.friendSubscription.unsubscribe();
  }


}
