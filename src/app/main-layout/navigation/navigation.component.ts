import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../login/auth.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { UserService } from '../../login/user/user.service';


@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {
  isLoggedIn$: Observable<boolean>;
  isAdmin$: Observable<boolean>;
  clicked: boolean;

  constructor(private authService: AuthService, private userService: UserService, private router: Router) {
    this.clicked = this.clicked === undefined ? false : true;
  }

  ngOnInit() {
    this.isLoggedIn$ = this.authService.isLoggedIn;
    this.isAdmin$ = this.userService.isAdmin;
    this.authService.checkLogin();
    this.userService.checkAdmin();
  }

  onLogout() {
    this.authService.logout();
    this.router.navigate(['/login']);                   // {3}
  }

  setClicked(val: boolean): void {
    this.clicked = val;
    this.userService.checkAdmin();
  }
}
