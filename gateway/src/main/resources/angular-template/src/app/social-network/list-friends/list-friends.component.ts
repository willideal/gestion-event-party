import {Component, OnDestroy, OnInit} from '@angular/core';
import {FollowService} from "../../services/follow.service";
import {Follow} from "../../models/follow.model";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-list-friends',
  templateUrl: './list-friends.component.html',
  styleUrls: ['./list-friends.component.scss']
})
export class ListFriendsComponent implements OnInit, OnDestroy {

  users: User[];
  friends: Follow[];
  friend: Follow;
  sessionPseudo = sessionStorage.getItem("userConnected");
  userSubscription: Subscription;
  friendSubscription: Subscription

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
        console.log("amis", this.friends);
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

  onUnfollow(pseudoUser: string) {
    this.friend = new Follow(this.sessionPseudo, pseudoUser)

    this.friendService.unfollow(this.friend).then(
      () => {
        console.log('Tu as unfollow !');
        //this.friendService.addFollow(this.friend);
        this.router.navigate(['/dashboard']);
      }
    )
  }

  ngOnDestroy() {
    this.friendSubscription.unsubscribe();
  }

}
