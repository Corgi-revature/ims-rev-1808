import { Component, OnInit, Input } from '@angular/core';
import { Login } from '../../class/login';
import { CoreService } from '../../core/core.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input() email: string;
  @Input() password: string;
  @Input() login: Login;
  @Input() sessionId: string;
  constructor(private coreService: CoreService) { }

  ngOnInit() {
    if(this.sessionId) {
      this.coreService.getLogin(this.sessionId).subscribe(
        result => {
          this.login = result;
        });
    }
    // testing purpose
    this.coreService.postLogin('user', 'password').subscribe(
      result => {
        this.login = result;
      });
  }

  initLogin() {
    this.coreService.postLogin(this.email, this.password).subscribe(
      resp => this.login = resp
    );
  }
}
