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
  @Input() private first: string;
  @Input() private last: string;
  @Input() private email: string;
  @Input() private password: string;
  @Input() private phone: string;
  @Input() private error: string;
  submitted = false;
  loading = false;
  registerForm: FormGroup;
  user: User = {
    id: null,
    first: this.first,
    last: this.last,
    email: this.email,
    password: this.password,
    userType: 2,
    phone: this.phone
  };

  constructor(
    private coreService: CoreService,
    private userService: UserService,
    private router: Router,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.registerForm = this.fb.group({
      'email': [null, Validators.email],
      'password': [null, Validators.minLength(6)],
      'first': [null, Validators.required],
      'last': [null, Validators.required],
      'phone': [null, Validators.minLength(10)],
    });
  }

  get f() {
    return this.registerForm.controls;
  }

  register() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    }
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
