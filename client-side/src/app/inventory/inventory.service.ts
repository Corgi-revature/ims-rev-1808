import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from '../core/core.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Item, Inventory } from '../class';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
  private appUrl = this.coreService.getURL() + '/inventory';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  private header = this.coreService.getHeader();
  constructor(
    private http: HttpClient,
    private coreService: CoreService
  ) { }

  getInventory(): Observable<Inventory[]> {
    return this.http.get(this.appUrl + '/all', {
       withCredentials: true
      }).pipe(
      map(
        resp => resp as Inventory[]
      )
    );
  }

  getInventoryById(id: string): Observable<Inventory> {
    const url: string = this.appUrl + '/' + id;
    return this.http.get(url, {
       withCredentials: true
    }).pipe(
      map(resp => resp as Inventory)
    );
  }

  makeItemPriceString(item: Item): string {
    let price = item.price.toString();
    if (price.includes('.') &&
      price.substring(price.indexOf('.')).length < 3) {
      price = price + '0';
    } else {
      if (!price.includes('.')) {
        price = price + '.00';
      }
    }
    return price;
  }

  createInventoryItem(): Observable<Inventory> {
    const body = '{}';
    return this.http.post(this.appUrl, body,
      { headers: this.headers, withCredentials: true
      }).pipe(
      map(
      resp => resp as Inventory
    ));
  }

  // These affect the items in the database
  updateInventoryItem(inv: Inventory) {
    const url = this.appUrl + '/' + inv.id;
    const body = JSON.stringify(inv);
    console.log('url: ' + url);
    console.log('body: ' + body);
    console.log(this.header);
    // return this.http.put(url, body, { headers: this.header, withCredentials: true }).pipe(
    //   map(
    //   resp => resp as Inventory
    // ));
    return this.http.put(url, body, {headers: this.header}).pipe(
      map(resp => resp as Inventory )
    );
  }

  deleteInventoryItem(inv: Inventory) {
    const url = this.appUrl + '/' + inv.id;
    return this.http.delete(url, {headers: this.header}).pipe(
      map(resp => resp as Inventory)
    );
  }
}
