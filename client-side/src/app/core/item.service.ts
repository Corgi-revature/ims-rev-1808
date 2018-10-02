import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from './core.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Item } from '../class/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
//  private appUrl = this.coreService.getURL()+'/item';
private appUrl = this.coreService.getURL()+'/item';
  private headers = new HttpHeaders({'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient,
    private coreService: CoreService
  ) { }

  getItems(): Observable<Item[]> {
    const url = this.appUrl + '/item/all';
    return this.http.get(url, { withCredentials: true }).pipe(
    map(
        resp => resp as Item[]
    ));
  }

  getItemById(id: number): Observable<Item> {
    const url = this.appUrl + '/' + id;
    return this.http.get(url, { withCredentials: true }).pipe(
      map(
      resp => resp as Item
    ));
  }

  // These affect the items in the database
  updateItem(ite: Item): Observable<Item> {
    const url = this.appUrl + '/' + ite.id;
    const body = JSON.stringify(ite);
    return this.http.put(url, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Item
    ));
  }

  createItem(): Observable<Item> {
    const body = '{}';
    return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Item
    ));
  }
}