import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from './core.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Delivery } from '../class/delivery';

@Injectable({
  providedIn: 'root'
})
export class DeliveryService {
private appUrl = this.coreService.getURL() +'/delivery';
  private headers = new HttpHeaders({'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient,
    private coreService: CoreService
  ) { }

  getDeliveries(): Observable<Delivery[]> {
    const url = this.appUrl + '/all';
    return this.http.get(url, { withCredentials: true }).pipe(
    map(
        resp => resp as Delivery[]
    ));
  }

  getDeliveryById(id: number): Observable<Delivery> {
    const url = this.appUrl + '/' + id;
    return this.http.get(url, { withCredentials: true }).pipe(
      map(
      resp => resp as Delivery
    ));
  }

  // These affect the items in the database
  updateDelivery(del: Delivery): Observable<Delivery> {
    const url = this.appUrl + '/' + del.id;
    const body = JSON.stringify(del);
    return this.http.put(url, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Delivery
    ));
  }

  createDelivery(del: Delivery): Observable<Delivery> {
    const body = JSON.stringify(del);
    return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Delivery
    ));
  }
}
