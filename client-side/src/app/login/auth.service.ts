import { Injectable } from '@angular/core';
import { Login, User } from '../class';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, pipe, BehaviorSubject } from 'rxjs';
import { CoreService } from '../core/core.service';
import { map } from 'rxjs/operators';
import { UserService } from './user/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private appUrl = this.coreService.getURL();
  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' });
  private headers = new HttpHeaders();
  private loggedIn = new BehaviorSubject<boolean>(false); // {1}
  private error: any;
  constructor(private http: HttpClient, private coreService: CoreService, private userService: UserService) { }

  setToken(token: string): string {
    localStorage.setItem('token', token);
    return token;
  }

  getToken() {
    return localStorage.getItem('token');
  }

  removeToken() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
  }

  get isLoggedIn() {
    return this.loggedIn.asObservable(); // {2}
  }

  postLogin(email: string, password: string): Observable<User> {
    console.log(email);
    console.log(password);
    const head = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    });
    return this.http
      .post(
        `${this.appUrl}/user/login`,
        {
          email: email,
          password: password
        },
        { headers: head }
      ).pipe(
        map(
          resp => {
            if (resp !== null) {
              this.loggedIn.next(true);
              // this.usertype.next(resp.usertype.id);
              this.coreService.setLStorage('user', JSON.stringify(resp as User));
              console.log(resp);
              this.setToken('super-200-corgi');
              return resp as User;
            }
            return this.error;
          },
          error => this.error = error)
      );
  }

  getLogin(sessionId: string): Observable<Login> {
    return this.http.get(`${this.appUrl}/user/login`).pipe(map(resp => resp as Login));
  }

  checkLogin() {
    if (localStorage.getItem('token')) {
      this.loggedIn.next(true);
      this.userService.checkAdmin();
    }
  }

  getForgotten(email: string) {
    return this.http.get(`${this.appUrl}/forget`);
  }

  postUser(user: User): Observable<any> {
    return this.http.post(`${this.appUrl}/register`, user);
  }

  logout() {                            // {4}
    this.removeToken();
    this.loggedIn.next(false);
  }
}
