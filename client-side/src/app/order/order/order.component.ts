import { Component, OnInit, Input } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
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
  contactFormModalAddress = new FormControl('', Validators.required);
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
  public curOrder:Order={
    id: 0,
    item: null,
    amount: null,
    user: null,
    txact: null,
    address: null
  };
  public txid:number=0;
  public index;
  public curTxact:Txact={
    id: 0,
    created: null,
    token: null,
    txid: null,
    status: null
  };
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
    // let newOrder:Order=<any>{};
    // newOrder.item = ite;
    // newOrder.amount = amount;
    // console.log(this.curTxact);
    // newOrder.txact = this.curTxact;
    // newOrder.user = this.curUser;
    // console.log(newOrder);
    // this.orders.push(newOrder);
    // 
    this.curOrder.item=ite;
    this.curOrder.amount=amount;
    this.curOrder.txact=this.curTxact;
    this.curOrder.user=this.curUser;
    this.curOrder.address="";
    this.orders.push(this.curOrder);
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
    console.log("checkout");
    console.log(this.contactFormModalAddress.value);
    for (let x = 0; x < this.orders.length; x++){
      console.log(this.orders[x]);
      this.orders[x].address = this.contactFormModalAddress.value;
      this.createOrder(this.orders[x]);
    }
    this.orderService.setTxid(this.txid);
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
    console.log("Open Transaction");
    this.txactService.createTransaction().subscribe(
      resp => {
        console.log(resp);
        if (resp !== null) {
          this.txid = resp;
          this.findTransactionById(this.txid);
        }
      }
    );
  }

  findTransactionById(id:number){
    this.txactService.getTransaction(id).subscribe(
      resp => {
        console.log("response form gettransaction");
        console.log(resp);
        if (resp !== null) {
          this.curTxact = resp;
        }
      }
    );
  }
}
