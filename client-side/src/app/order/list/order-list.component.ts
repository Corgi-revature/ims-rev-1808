import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from '../order/order.service';
import { Order } from '../../class';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
  orders: Order[];
  constructor(
    private router: Router,
    private orderService: OrderService,
  ) { }

  ngOnInit() {
    this.getOrdersView();
  }

  getOrdersView() {
    this.orderService.getOrdersView().subscribe(
      orderList => this.orders = orderList
    );
  }
}
