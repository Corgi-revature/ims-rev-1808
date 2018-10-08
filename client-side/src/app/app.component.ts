import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Auth0Service } from './shared/services/auth0/auth0.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Corgi-IMS';

  constructor(public auth: Auth0Service) {
    auth.handleAuthentication();
  }
}
