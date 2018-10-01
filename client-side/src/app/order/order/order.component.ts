import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../../class/order';
import { Item } from '../../class/item';
import { Inventory } from '../../class/inventory';
import { User } from '../../class/user';
import { Txact } from '../../class/txact';
import { ItemService } from '../../core/item.service';
import { InventoryService } from '../../order/inventory/inventory.service'
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
  //public invents: Inventory[];

  constructor(
    private inventoryService: InventoryService,
    private itemService: ItemService,
    private orderService: OrderService
  ) {}

  ngOnInit() {
    this.fillItemList();
    this.openTransaction();
   // this.fillInventory();
  }


  fillItemList() {
    this.itemService.getItems().subscribe(itemList => (this.items = itemList));
  }
  // fillInventory() {
  //   this.inventoryService.getInventory().subscribe(inventList => (this.invents = inventList));
  // }

  add(inv: Inventory, amount: Number): void {
    this.orderService.addItem(this.curOrder, inv).subscribe(
      add => (this.curOrder = add)
    );
   // document.getElementById("").innerHTML = amount.toString;
  }

  checkout(): void {}

  // This should check for a transaction is open
  isOpen(): boolean {
    return this.curTxact != null;
  }

  empty(): void {}

  openTransaction(){

  }
}
