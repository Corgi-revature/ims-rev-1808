import { Component, OnInit } from '@angular/core';
import { User } from '../../class';
import { CoreService } from '../../core/core.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private user: User;
  private error: string;
  constructor(private coreService: CoreService, private authService: AuthService) { }

  ngOnInit() {
  }

  register() {
    this.authService.postUser(this.user)
      .subscribe(
        (data: User) => this.user = { ...data }, // success path
        error => this.error = error // error path
      );
  }
}
