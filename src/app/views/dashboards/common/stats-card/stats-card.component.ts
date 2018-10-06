import { Component, OnInit } from '@angular/core';
import { Report } from '../../../../class';
import { OrderService } from '../../../../order/order/order.service';

@Component({
  selector: 'app-stats-card',
  templateUrl: './stats-card.component.html',
  styleUrls: ['./stats-card.component.scss']
})
export class StatsCardComponent implements OnInit {
  report: Report;
  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.getReport();
  }

  getReport() {
    this.orderService.getReport().subscribe(
      report => this.report = report
    );
  }
}
