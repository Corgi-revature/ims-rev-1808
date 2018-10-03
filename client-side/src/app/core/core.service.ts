import { Injectable } from '@angular/core';
import { Login } from '../class/login';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CoreService {
  private login: Login;
  private url = 'http://localhost:8080/IMS';
  private head = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
    // 'Authorization': 'my-auth-token'
  });

  constructor(private http: HttpClient) {}

  // Added getURL() method for William
  public getURL() {
    return this.url;
  }

  public getHeader() {
   return this.head;
  }
}
