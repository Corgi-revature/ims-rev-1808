import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from '../order/order.service';
import { Order, User } from '../../class';
import { CoreService } from '../../core/core.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  orders: Order[];
  usertype: number;
  user: User;
  constructor(
    private router: Router,
    private orderService: OrderService,
    private coreService: CoreService
  ) { }

  ngOnInit() {
    const l = this.coreService.getLStorage('user');
    this.user = JSON.parse(l);
    this.usertype = this.user.usertype.id;
    this.getOrdersView();
  }

  getOrdersView() {
    this.orderService.getOrdersView().subscribe(
      orderList => this.orders = orderList
    );
  }
  getOrdersViewP() {
    this.orderService.getOrdersViewP().subscribe(
      orderList => this.orders = orderList
    );
  }
  getOrdersViewC() {
    this.orderService.getOrdersViewF().subscribe(
      orderList => this.orders = orderList
    );
  }

  getOrdersViewBy(id, s) {
    this.orderService.getOrdersViewBy(id, s).subscribe(
      orderList => this.orders = orderList
    );
  }
  getOrdersViewByNoS(id) {
    this.orderService.getOrdersViewByNoS(id).subscribe(
      orderList => this.orders = orderList
    );
  }
}
