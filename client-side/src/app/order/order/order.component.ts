import { Component, OnInit, Input } from '@angular/core';
import { Order } from '../../class/order';
import { Item } from '../../class/item';
import { User } from '../../class/user';
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
    id: 10000,
    name: "fake",
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
  public txid: number;
  public index;
  public searchBar: string;
  public orders: Order[] = [];
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
    newOrder.itemid = ite.id;
    newOrder.amount = amount;
    newOrder.txid = this.txid;
    newOrder.userid = this.curUser.id;
    this.orders.push(newOrder);
  }

  updateCartOrder(amount:number){
    console.log("update");
    this.curOrder.amount = amount;
    this.orders.splice(this.index, 1, this.curOrder);
  }

  findOrder(ite: Item){
    this.index =-1;
    for (let x = 0; x < this.orders.length; x++){
      if (this.orders[x].itemid == ite.id){
        this.curOrder = this.orders[x];
        this.index = x;
        break;
      }
    }
  }

  checkout(): void {
    console.log("order from checkout")
    console.log(this.orders);
    for (let x = 0; x < this.orders.length; x++){
      console.log(this.orders[x]);
      this.createOrder(this.orders[x]);
    }
    this.orderService.setTxid(this.txid);
    this.router.navigate(['/checkout']);
  }

  createOrder(ord:Order){
    console.log("made it to create order");
    this.orderService.createOrder(ord).subscribe(
      resp => {
        if(resp !== null) {
          ord.id = resp;
          console.log("create order of resp");
          console.log(resp);
        }
      }
    );
  }

  empty(): void {
    for (let x = 0; x < this.orders.length; x++){
    document.getElementById(`${this.orders[x].itemid}_cart`).innerText = "0";
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
  }
}
