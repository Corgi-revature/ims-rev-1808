import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoreService } from '../../core/core.service';
import { User, Login } from '../../class';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private appUrl = this.coreService.getURL() + '/user';
  private appUrl2 = this.coreService.getURL() + '/usertype';
  private head = this.coreService.getHeader();

  constructor(private http: HttpClient, private coreService: CoreService) {}

  getAll() {
    return this.http.get<User[]>(`${this.appUrl}/users`);
  }

  getById(id: number) {
    return this.http.get(`${this.appUrl}/users/` + id);
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
