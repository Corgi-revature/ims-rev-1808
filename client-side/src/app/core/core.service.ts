import { Injectable } from '@angular/core';
import { Login } from '../class/login';

import { HttpClient } from '@angular/common/http';
import { Observable, pipe } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CoreService {
  private String: Login;
  constructor(private http: HttpClient) {}
  postLogin(email: String, password: String): Observable<Login> {
    return this.http
      .post('http://localhost:8080/p2a/login', {
        email: email,
        password: password
      })
      .pipe(map(resp => resp as Login));
  }

  getLogin(sessionId: string): Observable<Login> {
    return this.http
      .get('http://localhost:8080/p2a/login')
      .pipe(map(resp => resp as Login));
  }

  getForgotten(email: string) {
    return this.http
      .get('http://localhost:8080/p2a/register');
  }
}
