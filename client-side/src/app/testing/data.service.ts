import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest } from '@angular/common/http';

@Injectable()
export class DataService {
  url = 'https://jsonplaceholder.typicode.com/users';

  constructor(private http: HttpClient) {}

  getData() {
    const req = new HttpRequest('GET', this.url, {
      reportProgress: true
    });

    return this.http.request(req);
  }
}