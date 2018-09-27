import { Component, OnInit } from '@angular/core';
import { Login } from '../../class/login';
import { CoreService } from '../../core/core.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private user: Login;
  private error: string;
  constructor(private coreService: CoreService) { }

  ngOnInit() {
  }

  showConfig() {
    this.coreService.postUser(this.user)
      .subscribe(
        (data: Login) => this.user = { ...data }, // success path
        error => this.error = error // error path
      );
  }
}
