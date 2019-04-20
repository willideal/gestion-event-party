export class NotificationEvent {

  constructor(public id: number,
              public message: string,
              public typeNotif: string,
              public status: string,
              public pseudoSender: string,
              public pseudoReceiver: string,
              public idSoiree: number) {

  }
}
