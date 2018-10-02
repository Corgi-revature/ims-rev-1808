import { Injectable } from '@angular/core';
import {
  Router,
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot
} from '@angular/router';
import { AuthService } from '../../login/auth.service';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private authService: AuthService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    console.log(localStorage.getItem('token'));
    if (localStorage.getItem('token')) {
      // logged in so return true
      return this.authService.isLoggedIn
        .pipe(
          take(1),                              // {2}
          map((isLoggedIn: boolean) => {         // {3}
            if (!isLoggedIn) {
              this.router.navigate(['/login']);  // {4}
              return false;
            }
            return true;
          })
        );
    }
  }
}
    // not logged in so redirect to login page with the return url
//     this.router.navigate(['/login']);
// return false;
//   }

