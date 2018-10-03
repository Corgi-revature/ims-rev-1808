import { Component, OnInit, Input} from '@angular/core';
import { CoreService } from '../../core/core.service';
import {AuthService} from '../../login/auth.service';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
  @Input() email: string;
  constructor(private coreService: CoreService, private authService: AuthService) { }

  ngOnInit() {
  }
  // expected return will have to change depending on requirements.
  initForgetPass(): void {
    this.authService.getForgotten(this.email);
   }
}
