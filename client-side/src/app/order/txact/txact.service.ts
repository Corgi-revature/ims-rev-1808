import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from '../../core/core.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Txact } from '../../class/txact';


@Injectable({
  providedIn: 'root'
})
export class TxactService {
private appUrl = this.coreService.getURL()+'/txact';
private headers = new HttpHeaders({'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient,
    private coreService: CoreService
  ) { }

  updateTransaction(tx: Txact): Observable<Txact> {
    const url = this.appUrl + '/' + tx.id;
    const body = JSON.stringify(tx);
    return this.http.put(url, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Txact
    ));
  }

  createTransaction(): Observable<Number> {
    const body = '{}';
    console.log(this.appUrl);
    return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Number
    ));
  }
}
