import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../../../class';

@Component({
  selector: 'app-employee2',
  templateUrl: './employee2.component.html',
  styleUrls: ['../user.component.css']
})
export class Employee2Component implements OnInit {
  users: User[];
  error: any;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getUser().subscribe(
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

