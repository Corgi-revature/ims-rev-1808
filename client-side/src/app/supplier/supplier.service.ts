import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from '../core/core.service';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';
import { Supplier } from '../class/supplier';
import { Item } from '../class/Item';

@Injectable({
    providedIn: 'root'
  })

  export class SupplierService {
    private appUrl = this.coreService.getURL() + '/supplier';
    private headers = this.coreService.getHeader();

    constructor(private http: HttpClient, private coreService: CoreService) {}

    getSuppliers(): Observable<Supplier[]> {
        return this.http
          .get(this.appUrl + '/all')
          .pipe(map(resp => resp as Supplier[]));
      }
    addSupplier(sup: Supplier): Observable<Supplier>{
        const body = {};
        return this.http
            .post(this.appUrl, sup,{ headers: this.headers})
            .pipe(map(resp => resp as Supplier))
    }
    updateSupplier(sup: Supplier): Observable<Supplier>{
        return this.http
            .put(this.appUrl, sup,{headers: this.headers})
            .pipe(map(resp => resp as Supplier))
    }
    deleteSupplier(id: Number): Observable<Supplier>{
        return this.http
            .delete(this.appUrl+'/'+id, {headers: this.headers})
            .pipe(map(resp => resp as Supplier))
    }
}