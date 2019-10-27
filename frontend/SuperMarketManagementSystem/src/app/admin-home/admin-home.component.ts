import { Component, OnInit } from '@angular/core';
import { DataserviceService } from '../services/dataservice.service';
import { Logindetails } from '../logindetails';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  message= new Logindetails();
  
  constructor(private data : DataserviceService ) { }

  ngOnInit() {
      this.data.currentMessage.subscribe(message => this.message = message)
      console.log("updated details"+this.message)
  }

  loginAdminhome(event){
    console.log(event)
    
  }
}