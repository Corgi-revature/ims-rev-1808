import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InventoryService } from 'src/app/inventory/inventory.service';
import { ItemService } from 'src/app/core/item.service';
import { Inventory } from 'src/app/class/inventory';
import { Item } from 'src/app/class/item';
@Component({
  selector: 'app-add-inventory',
  templateUrl: './add-inventory.component.html',
  styleUrls: ['./add-inventory.component.css']
})
export class AddInventoryComponent implements OnInit {
  private items: Item[]

  constructor(
    private inventoryService: InventoryService,
    private itemService: ItemService,
    private router: Router,
  ) { }

  ngOnInit() {
    this.fillItems();
  }

  submit() {
    let it_name = (<HTMLInputElement>document.getElementById('it_name')).value;
    let it_price = +(<HTMLInputElement>document.getElementById('it_price')).value;
    let inv_stock = +(<HTMLInputElement>document.getElementById('inv_stock')).value;
    let inv_pkgdt = this.inputToSQLDate((<HTMLInputElement>document.getElementById('inv_pkgdt')).value);
    let inv_useby = this.inputToSQLDate((<HTMLInputElement>document.getElementById('inv_useby')).value);
    let item = new Item();
    item.id=0;item.name=it_name;item.price=it_price;
    this.items.forEach(function(it) {
      if(it.name==item.name) {
        item=it;
      }
    });
    let _inv = new Inventory();
    _inv.id=0;_inv.item=item;_inv.stock=inv_stock;_inv.packagedate=inv_pkgdt;_inv.useby=inv_useby;
    this.inventoryService.createInventoryItem(_inv).subscribe(
      resp => {
        _inv=resp;
        this.router.navigate(['inventory']);
      }
    );
  }

  today() {
    const date = new Date();
    const year = date.toDateString().substring(date.toDateString().length-4);
    const month = date.getMonth()>=9 ? (date.getMonth()+1).toString() : "0"+(date.getMonth()+1).toString();
    const day = date.getDate()>9 ? (date.getMonth()).toString() : "0"+(date.getDate()).toString();
    const today = year+'-'+month+'-'+day;
    return today;
  }

  inputToSQLDate(str) {
    const year = str.substring(2,4);
    const day = str.substring(8);
    const months=['JAN','FEB','MAR','APR','MAY','JUN','JUL','AUG','SEP','OCT','NOV','DEC'];
    const month = months[parseInt(str.substring(5,7))-1];
    const date = day+'-'+month+'-'+year;
    return date;
  }
  fillItems(){
    this.itemService.getItems().subscribe(itemList => (this.items = itemList));
  }
}
