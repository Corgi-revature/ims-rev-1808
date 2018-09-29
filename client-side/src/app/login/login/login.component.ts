import { Component, OnInit, Input } from '@angular/core';
import { Login } from '../../class/login';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input() email: string;
  @Input() password: string;
  @Input() login: Login;
  sessionId: string;
  result: object;

  constructor(private authService: AuthService) {}

  ngOnInit() {
    if (this.sessionId) {
      this.authService.getLogin(this.sessionId).subscribe(result => {
        this.login = result;
      });
    }
    // testing purpose
    this.authService.postLogin('user', 'password').subscribe(result => {
      this.login = result;
    });
  }
  initLogin() {
    this.authService
      .postLogin(this.email, this.password)
      .subscribe(resp => (this.login = resp));
  }
}
