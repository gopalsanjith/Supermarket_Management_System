import { Component, OnInit } from '@angular/core';
import { DataserviceService } from '../services/dataservice.service';
import { Logindetails } from '../logindetails';

@Component({
  selector: 'app-cashier-home',
  templateUrl: './cashier-home.component.html',
  styleUrls: ['./cashier-home.component.css']
})
export class CashierHomeComponent implements OnInit {

  message= new Logindetails();
  
  constructor(private data : DataserviceService ) { }

  ngOnInit() {
      this.data.currentMessage.subscribe(message => this.message = message)
      console.log("updated details"+this.message)
  }
}
