import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from '../core/core.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Item, Inventory } from '../class';
import { ItemService } from 'src/app/core/item.service';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
  private appUrl = this.coreService.getURL() + '/inventory';
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  private header = this.coreService.getHeader();

  constructor(
    private http: HttpClient,
    private coreService: CoreService,
    private itemService: ItemService
  ) { }

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
  
  getInventory(): Observable<Inventory[]> {
    const url = this.appUrl + '/all';
    return this.http.get(url, { withCredentials: true }).pipe(
    map(
        resp => resp as Inventory[]
    ));
  }

  getInventoryById(id: string): Observable<Inventory> {
    const url = this.appUrl + '/' + id;
    return this.http.get(url, { withCredentials: true }).pipe(
      map(
      resp => resp as Inventory
    ));
  }

  // These affect the items in the database
  updateInventoryItem(inv: Inventory) {
    const url = this.appUrl + '/' + inv.id;
    const body = JSON.stringify(inv);
    return this.http.put(url,body,{headers: this.header}).pipe(
      map(resp => resp as Inventory )
    );
  }

  createInventoryItem(inv: Inventory): Observable<Inventory> {
    const body = JSON.stringify(inv);
    return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true }).pipe(
      map(
      resp => resp as Inventory
    ));
  }

  deleteInventoryItem(inv: Inventory) {
    const url = this.appUrl + '/'+inv.id;
    return this.http.delete(url,{headers: this.header}).pipe(
      map(resp=> resp as Inventory)
    );
  }
}
