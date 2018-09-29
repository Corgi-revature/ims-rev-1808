import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from '../../core/core.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Order } from '../../class/order';
import { Item } from '../../class/item';
import { Txact } from '../../class/txact';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private appUrl = this.CoreService.getURL()+'/orders';
  private headers = new HttpHeaders({'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient,
    private CoreService: CoreService
  ) { }

  getOrders(): Observable<Order[]> {
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
    map(
        resp => resp as Order[]
    ));
  }

  getOrdersByTxactid(txact: Txact): Observable<Order[]> {
    const url = this.appUrl + '/' + txact.id;
    return this.http.get(this.appUrl, { withCredentials: true }).pipe(
    map(
        resp => resp as Order[]
    ));
  }

  getOrder(id: number): Observable<Order> {
    const url = this.appUrl + '/' + id;
    return this.http.get(url, { withCredentials: true }).pipe(
      map(
      resp => resp as Order
    ));
  }

  createOrder(): Observable<Order> {
    const body = '{}';
    return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Order
    ));
  }

  deleteOrder(ord: Order): Observable<Order> {
      const url = this.appUrl + '/' + ord.id;
      console.log(url);
      return this.http.delete(url, { headers: this.headers, withCredentials: true})
      .pipe(map(resp => resp as Order));
  }

  addItem(ord: Order, ite: Item): Observable<Order> {
    const body = {};
    const url = this.appUrl + '/' + ord.id + '/item/' + ite.id;
    console.log(url);
    return this.http.put(url, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Order
    ));
  }

  subItem(ord: Order, ite: Item): Observable<Order> {
    const url = this.appUrl + '/' + ord.id + '/item/' + ite.id;
    console.log(url);
    return this.http.delete(url, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Order
    ));
  }

  // Deletes all Orders attached to this Txact id
  empty(ord: Order): Observable<Object> {
    const url = this.appUrl + '/' + ord.txid;
    console.log(url);
    return this.http.delete(url, { headers: this.headers, withCredentials: true}).pipe(
      map(
      resp => resp
    ));
  }
}