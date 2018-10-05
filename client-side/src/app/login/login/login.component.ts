import { Component, OnInit, Input } from '@angular/core';
import { Login } from '../../class/login';
import { AuthService } from '../auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AlertService } from '../../shared/services/alert/alert.service';
import { LowerCasePipe } from '@angular/common';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input()
  email: string;
  @Input()
  password: string;
  @Input()
  login: Login;
  sessionId: string;
  loading = false;
  submitted = false;
  result: object;
  error: string;
  returnUrl: string;

  constructor(
    private authService: AuthService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/dashboard';
    // this.loginForm = this.formBuilder.group({
    // email: ['', Validators.email],
    // password: ['', Validators.required]
    // });
    console.log(this.authService.getToken());
    this.checkLogged();
  }

  // get val() {
  //   console.log(this.loginForm.controls);
  //   return this.loginForm.controls;
  // }

  initLogin() {
    this.submitted = true;

    // if (this.loginForm.invalid) {
    //   return 'try again';
    // }
    this.loading = true;
    const email = this.email.toLowerCase();
    console.log(email);
    this.authService.postLogin(email, this.password).subscribe(
      resp => {
        console.log(resp);
        if (resp !== null) {
          this.login = resp;
          this.userService.checkAdmin();
          this.router.navigate([this.returnUrl]);
        }
      },
      error => {
        this.error = error;
        this.loading = false;
      }
    );
  }

  checkLogged() {
    if (this.authService.getToken() === 'super-200-corgi') {
      console.log('test');
      console.log(this.returnUrl);
      this.router.navigate([this.returnUrl]);
    }
  }

  logOut() {
    this.router.navigate(['/login']);
  }
}
