import { Component, OnInit } from '@angular/core';
import { User, Login } from '../../class';
import { CoreService } from '../../core/core.service';
import { AuthService } from '../auth.service';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private first: string;
  private last: string;
  private email: string;
  private password: string;
  private phone: string;
  private error: string;
  user: Login;
  constructor(
    private coreService: CoreService,
    private userService: UserService
    ) { }

  ngOnInit() {
  }

  register() {
    this.userService.register(this.user)
      .subscribe(
        (data: Login) => this.user = { ...data }, // success path
        error => this.error = error // error path
      );
  }
}
