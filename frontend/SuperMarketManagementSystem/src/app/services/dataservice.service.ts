import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Logindetails } from '../logindetails';

@Injectable({
  providedIn: 'root'
})
export class DataserviceService {

  defaultproduct : any
  username=''
  password=''
  credentials = {username: this.username, password: this.password};

  private messagesource = new BehaviorSubject<any>(this.credentials)
 
  currentMessage = this.messagesource.asObservable();
  
  constructor() { }

  changeMessage(message: any)
  {
    this.messagesource.next(message)
    console.log( this.messagesource.value)
  }
  
}
