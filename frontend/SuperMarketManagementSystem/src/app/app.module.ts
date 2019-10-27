import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import {RouterModule} from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { CashierComponent } from './cashier/cashier.component';
import { HomeComponent } from './home/home.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AddCashierComponent } from './add-cashier/add-cashier.component';
import {
  MatSnackBar,
  MatSnackBarConfig,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
  MatSnackBarModule,
  MatSelectModule,
  MatFormFieldModule,
  MatCheckbox,
  MatCheckboxModule,
  MatInputModule,
} from '@angular/material';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AddProductComponent } from './add-product/add-product.component';
import { CashierHomeComponent } from './cashier-home/cashier-home.component';
import { AdminLogoutComponent } from './admin-logout/admin-logout.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    CashierComponent,
    HomeComponent,
    AdminHomeComponent,
    AddCashierComponent,
    AddProductComponent,
    CashierHomeComponent,
    AdminLogoutComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatSnackBarModule, BrowserAnimationsModule, MatFormFieldModule, MatSelectModule, MatCheckboxModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot([ 
{
  path:'',
  component: HomeComponent
},
{
  path:'Cashier',
  component: CashierComponent
},
{
  path:'Admin',
  component: AdminComponent
},
{
  path: 'Admin-home',
  component: AdminHomeComponent
},
{
  path: 'addProduct',
  component: AddProductComponent
},
{
  path: 'addCashier',
  component: AddCashierComponent
},
{
  path: 'Cashier-home',
  component: CashierHomeComponent
},
{
  path: 'admin-logout',
  component: AdminLogoutComponent
}

    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }