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
    return this.http.get(url, { headers: this.headers }).pipe(map(resp => resp as Delivery[]));
  }

  getDeliveryById(id: number): Observable<Delivery> {
    const url = this.appUrl + '/' + id;
    return this.http.get(url, { withCredentials: true }).pipe(
      map(
      resp => resp as Delivery
    ));
  }

  createDelivery(del: Delivery): Observable<Number> {
    console.log(del);
    return this.http
      .post(this.appUrl, del, { headers: this.headers})
      .pipe(map(resp => resp as Number));
  }
  updateDelivery(deli: Delivery): Observable<any>{
    return this.http
        .put(this.appUrl, deli,{headers: this.headers})
        .pipe(map(resp => resp as string));
}
deleteDelivery(id: Number): Observable<any>{
    return this.http
        .delete(this.appUrl+'/'+id, {headers: this.headers})
        .pipe(map(resp => resp as string));
}
}
