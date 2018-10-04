import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from '../../core/core.service';
import { User, Login } from '../../class';
import { Observable, BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private appUrl = this.coreService.getURL() + '/user';
  private appUrl2 = this.coreService.getURL() + '/usertype';
  private head = this.coreService.getHeader();
  private admin = new BehaviorSubject<boolean>(false); // {1}

  constructor(private http: HttpClient, private coreService: CoreService, private userService: UserService) {}

  get isAdmin() {
    return this.admin.asObservable(); // {2}
  }

  getUser(): Observable<User[]> {
    this.admin.next(true);
    return this.http.get<User[]>(`${this.appUrl}/employee/all`, {headers: this.coreService.getHeader()}).pipe(map(
      resp => {
        console.log(resp);
        return resp as User[];
      },
      error => error)
    );
  }

  getCust(): Observable<User[]> {
    return this.http.get<User[]>(`${this.appUrl}/customer/all`, {headers: this.coreService.getHeader()}).pipe(map(
      resp => {
        console.log(resp);
        return resp as User[];
      },
      error => error)
    );
  }

  getById(id: number) {
    return this.http.get(`${this.appUrl}/` + id);
  }

  register(user: User) {
    return this.http.post(`${this.appUrl}/new`, user, {headers: this.head});
  }
  gettype(id: number) {
    return this.http.get(`${this.appUrl2}`+ id);
  }

  update(user: User) {
    return this.http.put(`${this.appUrl}/users/` + user.id, user);
  }

  delete(id: number) {
    return this.http.delete(`${this.appUrl}/users/` + id);
  }
}
