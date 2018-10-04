import { Component, OnInit, Input } from '@angular/core';
// import { ItemService } from '../../core/item.service';
// import { Item } from '../../class/item';
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
    this.inventoryService.getInventories().subscribe(invList => (this.inventories = invList));
  }
}
