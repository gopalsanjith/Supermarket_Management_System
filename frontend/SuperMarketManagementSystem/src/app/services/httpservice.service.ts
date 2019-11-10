import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Product } from './product';
import { catchError, retry } from 'rxjs/operators';
import {
  HttpEvent, HttpInterceptor, HttpHandler, HttpRequest
} from '@angular/common/http';
import { Cashier } from '../cashier';
import { DataserviceService } from './dataservice.service';
@Injectable({
  providedIn: 'root'
})

export class HttpserviceService {

  constructor( private http: HttpClient ) {
   
  }

 
  public addproduct(product: Product, credentials): Observable<Product> {

    console.log("credentials : "+credentials.username,credentials.password)
    
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password) });
   
    return this.http.post<any>('api/addproduct',product, {headers});
  }

  public getAllProducts(credentials): Observable<Product[]> {
   
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password) });
    
    return this.http.get<Product[]>('api/products/all', {headers});
  }

  public deleteProduct(pid,credentials): Observable<Product[]> {
   
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password) });
    
    return this.http.delete<Product[]>('api/deleteproduct/'+pid, {headers});
  }

  public getProductById(pid,credentials) {
   
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password) });
    return this.http.get<any>('/api/productWithId/'+pid, {headers})
  }

  public addcashier(cashier: Cashier,credentials): Observable<Cashier> {
    console.log("credentials : "+credentials.username,credentials.password)
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password) });
    return this.http.post<any>('api/addcashier',cashier, {headers});
  }

  public updateproduct(product: Product, credentials): Observable<Product> {

    console.log("credentials : "+credentials.username,credentials.password)
    
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password) });
   
    return this.http.post<any>('api/updateproduct',product, {headers});
    
  }

  
}
