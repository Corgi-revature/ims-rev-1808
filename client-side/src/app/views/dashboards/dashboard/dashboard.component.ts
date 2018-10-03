import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../../../class';
import { CoreService } from '../../../core/core.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  userType: any;
  user: User;
  public chart1Type = 'bar';

  public chartDatasets: Array<any> = [
    { data: [50, 40, 60, 51, 56, 55, 40], label: 'Coffee' },
    { data: [28, 80, 40, 69, 36, 37, 60], label: 'Salt' },
    { data: [48, 58, 60, 88, 45, 65, 60], label: 'Meat' }
  ];

  public chartLabels: Array<any> = [
    'Jan',
    'Feb',
    'Mar',
    'Apr',
    'May',
    'Jun',
    'Jul'
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

  constructor(private coreService: CoreService) {}

  ngOnInit() {
    const l = this.coreService.getLStorage('user');
    this.user  = JSON.parse(l);
    this.userType = this.user.userType.id;
  }
}
