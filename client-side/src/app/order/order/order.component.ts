import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../../class/order';
import { Item } from '../../class/item';
import { User } from '../../class/user';
import { Txact } from '../../class/txact';
import { ItemService } from '../../core/item.service';
import { OrderService } from '../../order/order/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  @Input()
  curOrder: Order;
  @Input()
  curTxact: Txact;
  @Input()
  curUser: User;
  @Input()
  amount: number;
  @Input()
  sessionId: string;
  public orders: Order[];
  public items: Item[];

  constructor(
    private itemService: ItemService,
    private orderService: OrderService
  ) {}

  ngOnInit() {
    this.fillItemList();
  }

  fillItemList() {
    this.itemService.getItems().subscribe(itemList => (this.items = itemList));
  }

  add(ite: Item): void {
    this.orderService.addItem(this.curOrder, ite).subscribe(
      add => (this.curOrder = add)
    );
  }

  checkout(): void {}

  // This should check for a transaction is open
  isOpen(): boolean {
    return this.curTxact != null;
  }

  empty(): void {}
}
