import { Component, OnInit, Input } from '@angular/core';
import { User, Login } from '../../class';
import { CoreService } from '../../core/core.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  submitted = false;
  loading = false;
  registerForm: FormGroup;
  error: string;

  constructor(
    private coreService: CoreService,
    private userService: UserService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.registerForm = this.fb.group({
      'email': [null, Validators.email],
      'password': [null, Validators.minLength(6)],
      'first': [null, [Validators.required, Validators.minLength(6)]],
      'last': [null, [Validators.required, Validators.minLength(6)]],
      'phone': [null,  [Validators.required, Validators.pattern(/^-?(0|[1-9]\d*)?$/), Validators.maxLength(10), Validators.minLength(9)]],
      'usertype': [{id: '2', usertype: 'Customer'}]
    });
  }

  get f() {
    return this.registerForm.controls;
  }

  set f(x) {
    this.registerForm.setValue(x);
  }

  register() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    // this.registerForm.patchValue({ 'usertype': this.userService.gettype(2)});
    console.log(this.f.usertype);
    this.loading = true;
    this.userService.register(this.registerForm.value)
      .pipe(first())
      .subscribe(
        (data) => {
          if (data !== 0) {
            this.router.navigate(['/login']); // success path
          }
          return false;
        },
        error => this.error = error // error path
      );
  }
}
