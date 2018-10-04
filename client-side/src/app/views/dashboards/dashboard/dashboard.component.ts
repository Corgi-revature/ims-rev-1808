import { Component, OnInit } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from '../../../class';
import { CoreService } from '../../../core/core.service';
import { UserService } from '../../../login/user/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  usertype: number;
  user: User;
  users: User[];
  public chart1Type = 'bar';

  public chartDatasets: Array<any> = [
    { data: [50, 40, 60, 51, 56], label: 'Coffee' },
    { data: [68, 80, 60, 69, 36], label: 'Salt' },
    { data: [48, 58, 60, 88, 45], label: 'Meat' }
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

  constructor(private coreService: CoreService, private userService: UserService) {}

  ngOnInit() {
    const l = this.coreService.getLStorage('user');
    this.user  = JSON.parse(l);
    this.usertype = this.user.usertype.id;
  }

  superPower() {
    if (this.usertype === 1) {
      this.userService.getUser();
    }
  }
}
