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
import { CoreService } from '../../core/core.service';

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
    inventoryitem: {id: 0, name: '', price: 0},
    amount: 0,
    user: {id: 0, first: '', last: '', phone: '', email: '', password: '', usertype: {id: 0, name: ''}},
    tx: {id: 0, created: '', token: '', txid: '', status: ''},
    address: ''
  };
  public curTxact:Txact=
    {id: 0, created: '', token: '', txid: '', status: ''};
  public searchBar: string;
  public orders:Order[] = [];
  public items: Item[]; 
  public txid:number=0;
  public index;
  ord: Order = {
    id: 0, 
    inventoryitem: {id: 0, name: '', price: 0}, 
    amount: 0, 
    user: {id: 0, first: '', last: '', phone: '', email: '', password: '', usertype: {id: 0, name: ''}}, 
    tx: {id: 0, created: '', token: '', txid: '', status: ''}, 
    address: ''}

  constructor(
    private router: Router,
    private itemService: ItemService,
    private orderService: OrderService,
    private txactService: TxactService,
    private coreservice: CoreService
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
    let itemTotal: string = String(ite.price*amount);
    document.getElementById(`${ite.id}_amount`).innerText = (<HTMLInputElement>document.getElementById(`item_${ite.id}`)).value;
    document.getElementById(`${ite.id}_cost`).innerText = itemTotal;
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
    this.ord.inventoryitem.id = ite.id;
    this.ord.inventoryitem.name = ite.name;
    this.ord.inventoryitem.price = ite.price;
    this.ord.amount = amount;
    this.ord.tx.id = this.curTxact.id;
    this.ord.tx.created = this.curTxact.created;
    this.ord.tx.status = this.curTxact.status;
    this.ord.tx.token = this.curTxact.token;
    this.ord.tx.txid = this.curTxact.txid;
    this.ord.user = JSON.parse(this.coreservice.getLStorage('user'));
    this.ord.address = "";
    this.orders.push(this.ord);
    console.log(this.orders);
  }

  updateCartOrder(amount:number){
    console.log("update");
    this.curOrder.amount = amount;
    this.orders.splice(this.index, 1, this.curOrder);
  }

  findOrder(ite: Item){
    this.index =-1;
    console.log("length: " +this.orders.length);
    for (let x = 0; x < this.orders.length; x++){
      console.log("x: " +x);
      console.log(this.orders[x]);
      console.log(ite);
      if (this.orders[x].inventoryitem.id == ite.id){
        this.curOrder = this.orders[x];
        this.index = x;
        break;
      }
    }
  }

  checkout(): void {
    console.log("checkout");
    for (let x = 0; x < this.orders.length; x++){
      this.orders[x].address = this.contactFormModalAddress.value;
      this.createOrder(this.orders[x]);
    }
    this.orderService.setTxid(this.txid);
    this.router.navigate(['/delivery']);
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
    document.getElementById(`${this.orders[x].inventoryitem.id}_cart`).innerText = "0";
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
        if (resp !== null) {
          this.curTxact = resp;
        }
      }
    );
  }

  getOrderTotal(){
    var total = 0;
    for (let x = 0; x < this.orders.length; x++){
      total = total + (this.orders[x].inventoryitem.price * this.orders[x].amount);
    }
    return total;
  }

  getItemTotal(ite:Item){
    let amount: number = Number((<HTMLInputElement>document.getElementById(`item_${ite.id}`)).value);
    let total = ite.price*amount;
    return total;
  }
}
