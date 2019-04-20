import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Subject} from "rxjs";
import {Follow} from "../models/follow.model";

@Injectable()
export class FollowService {

  constructor(private httpClient: HttpClient) {}


  private friends: Follow[] = [];
  friendSubject = new Subject<Follow[]>();

  emitFriends() {
    this.friendSubject.next(this.friends.slice());
  }


  /*addFollow(friend: Follow) {
    this.friends.push(friend);
    this.emitFriends();
  }*/

  getAllAmis(pseudo: string){

    // Setup log namespace query parameter
    let params = new HttpParams().set('pseudo', pseudo);

    let url = "http://localhost:8095/users/friends";

    this.httpClient.get<any[]>(url, {params: params}).subscribe(
      res => {
        this.friends = res;
        this.emitFriends();
      },
      err => {
        alert('ERROR !');
      }
    );
  }

  follow(friend: Follow){

    let promise = new Promise((resolve, reject) => {
      let url = "http://localhost:8095/follow";
      let formData = new FormData();
      formData.append('pseudo', friend.pseudo);
      formData.append('amis', friend.pseudoAmi);

      this.httpClient.post<any>(url, formData)
        .toPromise()
        .then(
          res => {
            setTimeout(
              () => {
                //this.isFriend = true;
                resolve(true);
              }, 2000
            )
          },
        );
    });
    return promise;
  }

  unfollow(friend: Follow){

    let promise = new Promise((resolve, reject) => {
      let url = "http://localhost:8095/unfollow";
      let formData = new FormData();
      formData.append('pseudo', friend.pseudo);
      formData.append('amis', friend.pseudoAmi);

      this.httpClient.post<any>(url, formData)
        .toPromise()
        .then(
          res => {
            setTimeout(
              () => {
                //this.isFriend = true;
                resolve(true);
              }, 2000
            )
          },
        );
    });
    return promise;
  }

}
