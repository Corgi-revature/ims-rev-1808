import { Component, OnInit, Input } from '@angular/core';
import { CoreService } from '../core/core.service';
import { Router } from '@angular/router';
import { SupplierService } from '../supplier/supplier.service';
import { Item } from '../class/item';
import { Supplier } from '../class/supplier';
import { Delivery } from '../class/delivery';
import { ItemService } from '../core/item.service';
import { DeliveryService } from '../core/delivery.service';
import { InventoryService } from '../inventory/inventory.service';
import { Inventory } from '../class/inventory';

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.css']
})
export class DeliveryManageComponent implements OnInit {

  public suppliers: Supplier[];
  public items: Item[];
  public deliveries: Delivery[];

  del : Delivery = {id: 0, items: {id: 0, name: '', price: 0.00}, amount: 0, supplier: {id: 0, name: '', itemsup: {id: 0, name: '', price: 0.00}, email: ''}};
  inv : Inventory = {id: 0, item: {id: 0, name: '', price: 0.00}, packagedate: '', useby: '', stock: 0};
  constructor(
    private supplierservice: SupplierService,
    private itemservice: ItemService,
    private deliveryservice: DeliveryService,
    private inventoryservice: InventoryService
    ) { }

  ngOnInit() {
    this.fillDel();
    this.fillSups();
    this.fillItems();
  }

  fillDel(){
    this.deliveryservice.getDeliveries().subscribe(delList => (this.deliveries = delList));
  }
  acceptDel(del: Delivery){
    this.inv.item = del.items;
    this.inv.packagedate = '';
    this.inv.stock = del.amount;
    this.inv.useby = '';
  }
  fillItems(){
    this.itemservice.getItems().subscribe(itemList => (this.items = itemList));
    
  }
  fillSups(){
    this.supplierservice.getSuppliers().subscribe(supplierList => (this.suppliers = supplierList));
  }
}
