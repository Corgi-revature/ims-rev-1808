import { Injectable } from '@angular/core';
import { Login, User } from '../class';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, pipe, BehaviorSubject } from 'rxjs';
import { CoreService } from '../core/core.service';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private appUrl = this.coreService.getURL();
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  private loggedIn = false;

  private error: any;
  constructor(private http: HttpClient, private coreService: CoreService) { }

  setToken(token: string): void {
    localStorage.setItem('token', token);
  }

  get isLoggedIn() {
    return this.loggedIn; // {2}
  }

  postLogin(email: string, password: string): Observable<Login> {
    console.log(email);
    console.log(password);
    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/x-www-form-urlencoded'
    //     // 'Authorization': 'my-auth-token'
    //   })
    // };
    return this.http
      .post(
        `${this.appUrl}/user/login`,
        {
          email: email,
          password: password
        },
        { headers: this.headers }
      )
      .pipe(
        map(
          resp => {
          if (resp !== null) {
            this.loggedIn = true;
            this.setToken('login-200-corgi');
            return resp as Login;
          }
          return this.error;
          },
          error => this.error = error)
      );
  }

  getLogin(sessionId: string): Observable<Login> {
    return this.http.get(`${this.appUrl}/user/login`).pipe(map(resp => resp as Login));
  }

  getForgotten(email: string) {
    return this.http.get(`${this.appUrl}/forget`);
  }

  postUser(user: User): Observable<any> {
    return this.http.post(`${this.appUrl}/register`, user);
  }

  logout() {                            // {4}

  }
}
