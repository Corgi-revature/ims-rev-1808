import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../../../class';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['../user.component.css']
})
export class CustomerComponent implements OnInit {
  users: User[];
  error: any;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getCust().subscribe(
      resp => {
        console.log(resp);
        if (resp !== null) {
          this.users = resp;
          console.log(this.users);
        }
      },
      error => (this.error = error)
    );
  }
}

