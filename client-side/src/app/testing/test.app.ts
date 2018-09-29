import { Component, OnInit } from '@angular/core';
import { HttpEvent, HttpEventType } from '@angular/common/http';

import { DataService } from './data.service';

@Component({})
export class AppComponent implements OnInit {
  users: any;

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.populateUsers();
  }

  private populateUsers() {
    this.dataService.getData().subscribe((event: HttpEvent<any>) => {
      switch (event.type) {
        case HttpEventType.Sent:
          console.log('Request sent!');
          break;
        case HttpEventType.ResponseHeader:
          console.log('Response header received!');
          break;
        case HttpEventType.DownloadProgress:
          const kbLoaded = Math.round(event.loaded / 1024);
          console.log(`Download in progress! ${kbLoaded}Kb loaded`);
          break;
        case HttpEventType.Response:
          console.log('😺 Done!', event.body);
          this.users = event.body;
      }
    });
  }
}