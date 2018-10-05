import { Component, OnInit, Input } from '@angular/core';
import { Inventory } from '../class';
import { InventoryService } from './inventory.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {
  @Input()
  inventories: Inventory[];

  constructor(
    private inventoryService: InventoryService,
    private router: Router
  ) { }

  ngOnInit() {
    this.fillItemList();
  }

  deleteInventoryAlert(inv: Inventory) {
    const mess = 'Are you sure you want to delete the following inventory entry?';
    const age = '\nid: ' + inv.id + '\nitem: ' + inv.item.name
              +'\npackage date: '+inv.packagedate+"\nuse by: "+inv.useby;
    const conf = confirm(mess + age);
    console.log(conf);
    if (conf) {
      this.inventoryService.deleteInventoryItem(inv).subscribe(
        resp => {
          console.log(inv);
          inv=resp;
          this.fillItemList();
        }
      );
    }
  }

  fillItemList() {
    this.inventoryService.getInventory().subscribe(
      invList => {
        invList.sort(function(a,b){return a.id-b.id});
        this.inventories = invList;
      }
    );
  }
}
