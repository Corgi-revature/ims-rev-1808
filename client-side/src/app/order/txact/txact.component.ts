import { Component, OnInit, Input } from '@angular/core';
// import { Txact } from '../../class/txact';
import { Order } from '../../class/order';
import { CoreService } from '../../core/core.service';
import { OrderService } from '../../order/order/order.service';

@Component({
  selector: 'app-txact',
  templateUrl: './txact.component.html',
  styleUrls: ['./txact.component.css']
})
export class TxactComponent implements OnInit {
  public orders: Order[];

  constructor(
    private coreService: CoreService,
    private orderService: OrderService
    ) { }

  ngOnInit() {
    this.showOrdersOfTxact();
  }

  showOrdersOfTxact() {
    this.orderService.getOrders().subscribe(
      orderList => this.orders=orderList
    );
  }
}
