import { Component , ViewChild,OnInit} from '@angular/core';
import {MatPaginator, MatTableDataSource, MatSnackBar } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
import { Product } from '../product';
import { Router } from '@angular/router';
import { HttpserviceService } from '../services/httpservice.service';
import { DataserviceService } from '../services/dataservice.service';
import { Logindetails } from '../logindetails';

// export interface PeriodicElement {
//   name: string;
//   position: number;
//   weight: number;
//   symbol: string;
// }

// const ELEMENT_DATA: PeriodicElement[] = [
//   {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
//   {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
//   {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
//   {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
//   {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
//   {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
//   {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
//   {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
//   {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
//   {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
// ];

@Component({
  selector: 'app-delete-product',
  templateUrl: './delete-product.component.html',
  styleUrls: ['./delete-product.component.css']
})
export class DeleteProductComponent implements OnInit {

  displayedColumns: string[] = ['select', 'product_id', 'name', 'quantity', 'price', 'description'];
  dataSource: MatTableDataSource<Product>;
  selection = new SelectionModel<Product>(false, []);
 
  public products: Product[];
  message= new Logindetails();
  product :Product
  searchid: number;

  username = ''
  password = ''

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  
  model = new Product();
  submitted = false;
  constructor(public snackBar: MatSnackBar, private router: Router, public httpservice : HttpserviceService, public dataservice : DataserviceService ) {
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  
  onSubmit() { this.submitted = true;
    //console.log(this.model.search2)
   }

  ngOnInit() {
   
    this.dataservice.currentMessage.subscribe(message => this.message = message)
    console.log("updated details"+this.message)

    let credentials = {username: this.message.username, password: this.message.password};
    this.httpservice.getAllProducts(credentials).subscribe(
      data => {
      this.products = data;
      this.dataSource = new MatTableDataSource<Product>(data); 
      this.dataSource.paginator = this.paginator;
      console.log(this.dataSource.data);
    },
    error => alert("error while retriving")
    );
  }


  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }


  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
  }


  removeSelectedRows() {
    this.selection.selected.forEach(row => {
      console.log(row.product_id)
      let credentials = {username: this.message.username, password: this.message.password};
      this.httpservice.deleteProduct(row.product_id,credentials).subscribe(
        data => {
          let credentials = {username: this.message.username, password: this.message.password};
          this.httpservice.getAllProducts(credentials).subscribe(
            data => {
            this.products = data;
            this.dataSource = new MatTableDataSource<Product>(data); 
            this.dataSource.paginator = this.paginator;
            console.log(this.dataSource.data);
          },
          error => alert("error while retriving")
          );
     
      },
      error => alert("error while retriving")
    );
      
   });
  
 }

}

