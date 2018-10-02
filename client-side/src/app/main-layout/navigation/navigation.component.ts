import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../login/auth.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {
  isLoggedIn$: Observable<boolean>;
  clicked: boolean;

  constructor(private authService: AuthService) {
    this.clicked = this.clicked === undefined ? false : true;
  }

  ngOnInit() {
    this.isLoggedIn$ = this.authService.isLoggedIn;
  }

  onLogout() {
    this.authService.logout();                      // {3}
  }

  setClicked(val: boolean): void {
    this.clicked = val;
  }
}
