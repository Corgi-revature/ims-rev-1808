import { Component, OnInit } from '@angular/core';
import { User } from '../../class';
import { CoreService } from '../../core/core.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../../login/user/user.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  currentUser: User;
  submitted = false;
  loading = false;
  edit = false;
  isDisabled = true;
  profileForm: FormGroup;
  error: string;
  constructor(
    private coreService: CoreService,
    private userService: UserService,
    private router: Router,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.currentUser = JSON.parse(this.coreService.getLStorage('user'));
    this.profileForm = this.fb.group({
      'id': [this.currentUser.id],
      'password': [this.currentUser.password, Validators.minLength(6)],
      'email': [this.currentUser.email, Validators.email],
      'first': [this.currentUser.first, Validators.required],
      'last': [this.currentUser.last, Validators.required],
      'phone': [this.currentUser.phone, Validators.minLength(10)],
      'usertype': [this.currentUser.usertype]
    });
  }

  get f() {
    return this.profileForm.controls;
  }

  set f(x) {
    this.profileForm.setValue(x);
  }

  toggleForm() {
    this.edit = !this.edit;
    this.isDisabled = !this.isDisabled;
  }

  update() {
    this.submitted = true;
    if (this.profileForm.invalid) {
      return;
    }
    // this.profileForm.patchValue({ 'usertype': this.userService.gettype(2)});
    console.log(this.f.usertype);
    this.loading = true;
    this.userService.update(this.profileForm.value, this.currentUser.id)
      .pipe(first())
      .subscribe(
        (data) => {
          if (data !== 0) {
            this.router.navigate(['/profile']); // success path
            this.edit=false;
            this.updateC();
          }
          return false;
        },
        error => this.error = error // error path
      );
  }
  updateC() {
    this.userService.getById(this.currentUser.id).subscribe(data1 => {
      const newU = JSON.stringify(data1);
      this.coreService.setLStorage('user', newU);
      this.currentUser = JSON.parse(this.coreService.getLStorage('user'));
    });
  }
}
