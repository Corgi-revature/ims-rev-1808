import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from '../../core/core.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Order } from '../../class/order';
import { Item } from '../../class/item';
import { Inventory } from '../../class/inventory';
import { Txact } from '../../class/txact';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private appUrl = this.coreService.getURL() + '/order';
  private headers = this.coreService.getHeader();
  public txid:number;

  constructor(private http: HttpClient, private coreService: CoreService) {}
 
  setTxid(txactId){
    console.log("service set id");
    this.txid = txactId;
    console.log(this.txid);
  }

  getTxid(){
    console.log("service get id");
    console.log(this.txid);
    return this.txid;
  }

  getOrders(): Observable<Order[]> {
    return this.http
      .get(this.appUrl, { withCredentials: true })
      .pipe(map(resp => resp as Order[]));
  }

  getOrdersByTxactid(txid: number): Observable<Order[]> {
    const url = this.appUrl + '/' + txid;
    console.log(url);
    return this.http
      .get(url, { withCredentials: true })
      .pipe(map(resp => resp as Order[]));
  }

  getOrder(id: number): Observable<Order> {
    const url = this.appUrl + '/' + id;
    return this.http
      .get(url, { withCredentials: true, headers: this.headers})
      .pipe(map(resp => resp as Order));
  }

  createOrder(ord:Order): Observable<number> {
    const body = JSON.stringify(ord);
    console.log("this is the createorder thingy");
    console.log(body);
    return this.http.post(this.appUrl,body,{ headers: this.headers, withCredentials: true }).pipe(
        map
        (resp => {
          if (resp !== null) {
            return resp as number;
        }
      }
    ));
  }

  deleteOrder(ord: Order): Observable<Order> {
    const url = this.appUrl + '/' + ord.id;
    console.log(url);
    return this.http
      .delete(url, { headers: this.headers, withCredentials: true })
      .pipe(map(resp => resp as Order));
  }

  addItem(ord: Order, ite: Item, amount: Number): Observable<Order> {
    const body = {};
    const url = this.appUrl + '/' + ord.id + '/inventory/' + ite.id;
    console.log(url);
    return this.http
      .put(url, body, { headers: this.headers, withCredentials: true })
      .pipe(map(resp => resp as Order));
  }

  subItem(ord: Order, inv: Inventory): Observable<Order> {
    const url = this.appUrl + '/' + ord.id + '/inventory/' + inv.id;
    console.log(url);
    return this.http
      .delete(url, { headers: this.headers, withCredentials: true })
      .pipe(map(resp => resp as Order));
  }

  // Deletes all Orders attached to this Txact id
  empty(ord: Order): Observable<Object> {
    const url = this.appUrl + '/' + ord.txid;
    console.log(url);
    return this.http
      .delete(url, { headers: this.headers, withCredentials: true })
      .pipe(map(resp => resp));
  }
}
