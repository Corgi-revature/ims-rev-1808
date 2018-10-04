import { Component, OnInit, Input } from '@angular/core';
import { CoreService } from '../../core/core.service';

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.css']
})
export class DeliveryComponent implements OnInit {

  constructor(
    private coreService: CoreService,
    ) { }

  ngOnInit() {
  }

}
