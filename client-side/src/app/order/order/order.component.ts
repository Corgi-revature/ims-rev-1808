import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../../class/order';
import { Item } from '../../class/item';
import { User } from '../../class/user';
import { Txact } from '../../class/txact';
import { ItemService } from '../../core/item.service';
import { TxactService } from '../../order/txact/txact.service';
import { OrderService } from '../../order/order/order.service';
import { Router } from '@angular/router';
import { UserType } from '../../class/usertype';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})

export class OrderComponent implements OnInit {
  @Input()
  fakeUserType:UserType={
     name: "fake",
     id: 10000,
  }
  @Input()
  curUser: User = {
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
  public curOrder:Order=<any>{};
  public txid:number=0;
  public index;
  public curTxact:Txact;
  public searchBar: string;
  public orders:Order[] = [];
  public items: Item[];

  constructor(
    private router: Router,
    private itemService: ItemService,
    private orderService: OrderService,
    private txactService: TxactService
  ) {}

  ngOnInit() {
    this.searchBar = '';
    this.fillItemList();
    this.openTransaction();
  }

  fillItemList() {
    this.itemService.getItems().subscribe(itemList => (this.items = itemList));
  }

  add(ite: Item): void {
    let amount: number = Number((<HTMLInputElement>document.getElementById(`item_${ite.id}`)).value);
    document.getElementById(`${ite.id}_cart`).innerText = (<HTMLInputElement>document.getElementById(`item_${ite.id}`)).value;
    this.findOrder(ite);
    if (this.index != -1){
      this.updateCartOrder(amount);
    }
    else {
      this.createCartOrder(ite, amount);
    }
  }

  createCartOrder(ite: Item, amount: number){
    console.log("create");
    let newOrder:Order=<any>{};
    newOrder.item = ite;
    newOrder.amount = amount;
    console.log(this.curTxact);
    newOrder.txact = this.curTxact;
    newOrder.user = this.curUser;
    console.log(newOrder);
    this.orders.push(newOrder);
    console.log(this.orders);
  }

  updateCartOrder(amount:number){
    console.log("update");
    this.curOrder.amount = amount;
    this.orders.splice(this.index, 1, this.curOrder);
  }

  findOrder(ite: Item){
    this.index =-1;
    for (let x = 0; x < this.orders.length; x++){
      if (this.orders[x].item == ite){
        this.curOrder = this.orders[x];
        this.index = x;
        break;
      }
    }
  }

  checkout(): void {
    console.log("checkout")
    for (let x = 0; x < this.orders.length; x++){
      console.log("checkout loop");
      console.log(this.orders[x]);
      this.createOrder(this.orders[x]);
    }
    this.orderService.setTxid(this.txid);
    this.router.navigate(['/checkout']);
  }

  createOrder(ord:Order){
    console.log("create order");
    this.orderService.createOrder(ord).subscribe(
      resp => {
        if(resp !== null) {
          ord.id = resp;
        }
      }
    );
  }

  empty(): void {
    for (let x = 0; x < this.orders.length; x++){
    document.getElementById(`${this.orders[x].item.id}_cart`).innerText = "0";
    }
    this.orders.splice(0, this.orders.length);
  }

  goBack(){
    this.router.navigate(['/dashboard']);
  }

  openTransaction(){
    this.txactService.createTransaction().subscribe(
      resp => {
        if (resp !== null) {
          this.txid = resp;
        }
      }
    );
    console.log("Txid");
    console.log(this.txid);
    this.txactService.getTransaction(this.txid).subscribe(
      resp => {
        if (resp !== null) {
          console.log("in the thingy");
          console.log(resp);
          this.curTxact = resp;
          console.log(this.curTxact);
        }
      }
    );
    console.log("out of open transaction");
  }
}
