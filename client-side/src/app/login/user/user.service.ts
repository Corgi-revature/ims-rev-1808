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
  private head = this.coreService.getHeader();
  private admin = new BehaviorSubject<boolean>(false); // {1}

  constructor(private http: HttpClient, private coreService: CoreService, private userService: UserService) {}

  get isAdmin() {
    return this.admin.asObservable(); // {2}
  }

  getAll(): Observable<User[]> {
    this.admin.next(true);
    return this.http.get<User[]>(`${this.appUrl}/all`);
  }

  getById(id: number) {
    return this.http.get(`${this.appUrl}/` + id);
  }

  register(user: User) {
    return this.http.post(`${this.appUrl}/new`, user, {headers: this.head});
  }

  update(user: User) {
    return this.http.put(`${this.appUrl}/users/` + user.id, user);
  }

  delete(id: number) {
    return this.http.delete(`${this.appUrl}/users/` + id);
  }
}
