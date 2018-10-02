import { Component, OnInit, Input } from '@angular/core';
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
  @Input() private first: string;
  @Input() private last: string;
  @Input() private email: string;
  @Input() private password: string;
  @Input() private phone: string;
  @Input() private error: string;
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
    private userService: UserService
    ) { }

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
