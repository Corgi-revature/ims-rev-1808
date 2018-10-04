import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { User } from '../../class';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users: User[];
  error: any;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getUser().subscribe(
      resp => {
        console.log(resp);
        if (resp !== null) {
          this.users = resp;
          console.log(this.users)
        }
      },
      error => (this.error = error)
    );
  }
}

