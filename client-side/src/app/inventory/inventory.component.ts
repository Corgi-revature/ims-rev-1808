import { Component, OnInit, Input } from '@angular/core';
import { Inventory } from '../class';
import { InventoryService } from './inventory.service';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {
  @Input()
  inventories: Inventory[];

  constructor(
    private inventoryService: InventoryService
  ) { }

  ngOnInit() {
    this.fillItemList();
  }

  fillItemList() {
    this.inventoryService.getInventory().subscribe(
      invList => {
        invList.sort(function(a,b){return a.id-b.id});
        this.inventories = invList
      }
    );
  }
}
