import { Component, OnInit } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { User, Order, Report } from '../../../class';
import { CoreService } from '../../../core/core.service';
import { UserService } from '../../../login/user/user.service';
import { OrderService } from '../../../order/order/order.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  usertype: number;
  user: User;
  users: User[];
  orders: Order[];
  report: Report;
  public chart1Type = 'bar';

  public chartDatasets: Array<any> = [
    { data: [50, 40, 38, 51, 66], label: 'Coffee' },
    { data: [68, 40, 43, 69, 56], label: 'Salt' },
    { data: [48, 58, 66, 88, 65], label: 'Meat' }
  ];

  public chartLabels: Array<any> = [
    'May',
    'Jun',
    'Jul',
    'Aug',
    'Sep',
  ];

  public chartColors: Array<any> = [];

  public dateOptionsSelect: any[];
  public bulkOptionsSelect: any[];
  public showOnlyOptionsSelect: any[];
  public filterOptionsSelect: any[];

  public chartOptions: any = {
    responsive: true,
    legend: {
      labels: {
        fontColor: '#5b5f62'
      }
    },
    scales: {
      yAxes: [
        {
          ticks: {
            fontColor: '#5b5f62'
          }
        }
      ],
      xAxes: [
        {
          ticks: {
            fontColor: '#5b5f62'
          }
        }
      ]
    }
  };

  constructor(private coreService: CoreService, private userService: UserService, private orderService: OrderService) { }

  ngOnInit() {
    const l = this.coreService.getLStorage('user');
    this.user = JSON.parse(l);
    this.usertype = this.user.usertype.id;
    this.getOrdersView();
    this.getReport();
  }

  getOrdersView() {
    let i = this.user.id;
    this.orderService.getOrdersViewByNoS(i).subscribe(
      orderList => this.orders = orderList
    );
  }

  getReport() {
    this.orderService.getReport().subscribe(
      report => this.report = report
    );
  }
  superPower() {
    if (this.usertype === 1) {
      this.userService.getUser();
    }
  }
  updateReport() {
    this.orderService.getReport().subscribe(
      report => this.report = report
    );
  }
}
