import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../../class/order';
import { Item } from '../../class/item';
import { Inventory } from '../../class/inventory';
import { User } from '../../class/user';
import { Txact } from '../../class/txact';
import { ItemService } from '../../core/item.service';
import { InventoryService } from '../../order/inventory/inventory.service'
import { OrderService } from '../../order/order/order.service';
import { TxactService } from '../../order/txact/txact.service';

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
    private orderService: OrderService,
    private txactSerivce: TxactService
  ) {}

  ngOnInit() {
    this.fillItemList();
    this.openTransaction();
   // this.fillInventory();
  }


  fillItemList() {
    this.itemService.getItems().subscribe(itemList => (this.items = itemList));
  }

  add(ite: Item): void {
    // this.orderService.addItem(this.curOrder, ite, amount).subscribe(
    //   add => (this.curOrder = add)
    // );
   document.getElementById(`${ite.name}_cart`).innerText = (<HTMLInputElement>document.getElementById(`item_${ite.id}`)).value;
  }
  
  checkout(): void {
    this.txactSerivce.updateTransaction;
  }

  // This should check for a transaction is open
  isOpen(): boolean {
    return this.curTxact != null;
  }

  empty(): void {}

  openTransaction(){
    this.txactSerivce.createTransaction();
    this.curTxact.id = 1;
    this.curTxact.token = `Token ${this.curTxact.id}`;
    this.curTxact.created = "Now";
    this.curTxact.txid = "012854 0415";
  }
}
