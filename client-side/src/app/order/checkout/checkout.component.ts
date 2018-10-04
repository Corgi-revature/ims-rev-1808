import { Component, OnInit, Input } from '@angular/core';
import { CoreService } from '../../core/core.service';

@Component({
    selector: 'app-checkout',
    templateUrl: './checkout.component.html',
    styleUrls: ['./checkout.component.css']
  })
export class CheckoutComponent implements OnInit {

  constructor(
    private coreService: CoreService,
    ) { }

  ngOnInit() {
  }

}
