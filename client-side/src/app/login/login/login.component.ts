import { Component, OnInit, Input } from '@angular/core';
import { Login } from '../../class/login';
import { AuthService } from '../auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AlertService } from '../../shared/services/alert/alert.service';

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
  loginForm: FormGroup;
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
    private alertService: AlertService
  ) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      // email: ['', Validators.email],
      // password: ['', Validators.required]
    });
    // if (this.sessionId) {
    //   this.authService.getLogin(this.sessionId).subscribe(result => {
    //     this.login = result;
    //     console.log('you are not in session');
    //   });
    // }
    // // testing purpose
    // this.authService.postLogin('user', 'password').subscribe(result => {
    //   this.login = result;
    //   console.log(`testLogin = ${this.login}`);
    // });

    // this just check the token and redirect
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    if (localStorage.getItem('token')) {
      this.router.navigate([this.returnUrl]);
    }
  }

  get val() {
    console.log(this.loginForm.controls);
    return this.loginForm.controls;
  }

  initLogin() {
    this.submitted = true;

    if (this.loginForm.invalid) {
      return 'try again';
    }
    this.loading = true;
    this.authService.postLogin(this.email, this.password).subscribe(
      resp => {
        localStorage.setItem('token', 'running amok');
        this.login = resp;
        this.router.navigate([this.returnUrl]);
      },
      error => (this.error = error)
    );
  }
}
