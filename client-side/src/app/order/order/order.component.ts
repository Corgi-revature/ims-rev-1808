import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../../class/order';
import { Item } from '../../class/item';
import { User } from '../../class/user';
import { Txact } from '../../class/txact';
import { ItemService } from '../../core/item.service';
import { OrderService } from '../../order/order/order.service';
import { TxactService } from '../../order/txact/txact.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserType } from '../../class/usertype';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})

export class OrderComponent implements OnInit {
  @Input()
  curOrder:Order=<any>{};
  @Input()
  curTxact:Txact=<any>{};
  @Input()
  txid: Number;
  @Input()
  fakeUserType:UserType={
    id: 10000,
    name:"fake",
  }
  @Input()
  curUser:User={
    id: 1,
    first: "Mr.",
    last: "Dude",
    phone: "Nah",
    email: "Nope",
    usertype: this.fakeUserType,
    password: "1234"
  };
  @Input()
  sessionId: string;
  result: object;
  public exists = false;
  public index = -1;
  public orders = [];
  public items: Item[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private itemService: ItemService,
    private orderService: OrderService,
    private txactSerivce: TxactService
  ) {}

  ngOnInit() {
    this.fillItemList();
    this.openTransaction();
  }

  fillItemList() {
    this.itemService.getItems().subscribe(itemList => (this.items = itemList));
  }

  add(ite: Item): void {
    // this.orderService.addItem(this.curOrder, ite, amount).subscribe(
    //   add => (this.curOrder = add)
    // );
    let amount:number = Number((<HTMLInputElement>document.getElementById(`item_${ite.id}`)).value);
    document.getElementById(`${ite.id}_cart`).innerText = (<HTMLInputElement>document.getElementById(`item_${ite.id}`)).value;
    this.findOrder(ite);
    if (this.index != -1){
      this.updateOrder(amount);
    }
    else {
      this.createOrder(ite, amount);
    }
  }

  createOrder(ite: Item, amount: number){
    console.log("create");
    let newOrder:Order=<any>{};
    newOrder.itemid = ite.id;
    newOrder.amount = amount;
    newOrder.txid = this.curTxact.id;
    newOrder.userid = this.curUser.id;
    this.orders.push(newOrder);
  }

  updateOrder(amount:number){
    this.curOrder.amount = amount;
    this.orders.splice(this.index, 1, this.curOrder);
  }

  findOrder(ite: Item){
    this.index =-1;
    for (var x = 0; x < this.orders.length; x++){
          if (this.orders[x].itemid == ite.id){
          this.curOrder = this.orders[x];
          let test = this.curOrder;
          this.index = x;
          this.exists = true;
          break;
        }
    }
  }

  checkout(): void {
    this.router.navigate(['/checkout']);
  }

  empty(): void {
    for (var x = 0; x < this.orders.length; x++){
    document.getElementById(`${this.orders[x].itemid}_cart`).innerText = "0";
    }
    this.orders.splice(0,this.orders.length);
  }

  openTransaction(){
    this.txactSerivce.createTransaction(this.curTxact).subscribe(
      resp => {
        if (resp !== null) {
          this.txid = resp;
        }
      }
    );
  }
}
