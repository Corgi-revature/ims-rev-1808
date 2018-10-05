import { Component, OnInit, Input } from '@angular/core';
import { CoreService } from '../../core/core.service';
import { Order } from '../../class/order';
import { Router } from '@angular/router';
import { OrderService } from '../order/order.service';
import { Txact } from '../../class';
import { OrderComponent } from '../order/order.component';

@Component({
    selector: 'app-checkout',
    templateUrl: './checkout.component.html',
    styleUrls: ['./checkout.component.css']
  })
export class CheckoutComponent implements OnInit {
  @Input()
  tx:number;

  public orders: Order[]=[];

  constructor(
    private coreService: CoreService,
    private router: Router,
    private orderService: OrderService,
    ) { }

  ngOnInit() {
    this.tx = this.orderService.getTxid();
    console.log(this.tx);
    this.retrieveOrders();
  }

  retrieveOrders(){
    console.log("about to fuck shit up fam");
    console.log(this.orders);
    this.orderService.getOrdersByTxactid(this.tx).subscribe(orderList => (this.orders = orderList));
    console.log(this.orders);
  }
  purchase(){
    this.router.navigate(['/delivery']);
  }

  goBack(){
    this.router.navigate(['/orders']);
  }
}
