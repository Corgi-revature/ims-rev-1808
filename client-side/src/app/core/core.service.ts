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
  private url = 'http://localhost:8080/user/';

  constructor(private http: HttpClient) {}
  postLogin(email: String, password: String): Observable<Login> {
    return this.http
      .post(`${this.url}login`, {
        email: email,
        password: password
      })
      .pipe(map(resp => resp as Login));
  }

  getLogin(sessionId: string): Observable<Login> {
    return this.http.get(`${this.url}login`).pipe(map(resp => resp as Login));
  }

  getForgotten(email: string) {
    return this.http.get(`${this.url}forget`);
  }

  postUser(user: Login): Observable<any> {
    return this.http.post(`${this.url}register`, user);
  }
}
