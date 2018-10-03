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
export class EmployeeService {
  private appUrl = this.CoreService.getURL()+'/inventory';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(
    private http: HttpClient,
    private CoreService: CoreService
  ) { }

  getInventories(): Observable<Inventory[]> {
    return this.http.get(this.appUrl+'/all', {withCredentials: true}).pipe(
      map(
        resp => resp as Inventory[]
      )
    );
  }

  getInventoryById(id: string): Observable<Inventory> {
    const url: string = this.appUrl+'/'+id;
    return this.http.get(url, {withCredentials: true}).pipe(
      map(resp=>resp as Inventory)
    );
  }

  makeItemPriceString(item: Item): string {
    let price = item.price.toString();
    if( price.includes(".") && 
        price.substring(price.indexOf(".")).length<3) {
      price=price+"0";
    } else {
      if(!price.includes(".")) {
        price=price+".00";
      }
    }
    return price;
  }

  editInventory(inv: Inventory): void {
    this.http.put(this.appUrl+"/"+inv.id, inv);
  }

  deleteInventory(inv: Inventory): void {
    this.http.delete(this.appUrl+"/"+inv.id);
  }
}
