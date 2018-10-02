import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from '../../core/core.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Item } from '../../class/item';
import { Inventory } from '../../class/inventory';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
//  private appUrl = this.coreService.getURL()+'/item';
private appUrl = this.coreService.getURL()+'/inventory';
  private headers = new HttpHeaders({'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient,
    private coreService: CoreService
  ) { }

  getInventory(): Observable<Inventory[]> {
    const url = this.appUrl + '/inventory/all';
    return this.http.get(url, { withCredentials: true }).pipe(
    map(
        resp => resp as Inventory[]
    ));
  }

  getInventoryById(id: number): Observable<Inventory> {
    const url = this.appUrl + '/' + id;
    return this.http.get(url, { withCredentials: true }).pipe(
      map(
      resp => resp as Inventory
    ));
  }

  // These affect the items in the database
  updateInventoryItem(inv: Inventory): Observable<Inventory> {
    const url = this.appUrl + '/' + inv.id;
    const body = JSON.stringify(inv);
    return this.http.put(url, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Inventory
    ));
  }

  createInventoryItem(): Observable<Inventory> {
    const body = '{}';
    return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Inventory
    ));
  }
}