import { Component, OnInit, Input } from '@angular/core';
import { User, Login } from '../../class';
import { CoreService } from '../../core/core.service';
import { AuthService } from '../auth.service';
import { UserService } from '../user/user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

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
    private fb: FormBuilder
  ) {
    this.registerForm = fb.group({
      'email': [null, Validators.email],
      'password': [null, Validators.minLength(6)],
      'first': [null, Validators.required],
      'last': [null, Validators.required],
      'phone': [null, Validators.minLength(10)],
    });
  }

  ngOnInit() {
  }

  register() {
    this.userService.register(this.user)
      .subscribe(
        (data: User) => this.user = { ...data }, // success path
        error => this.error = error // error path
      );
  }
}
