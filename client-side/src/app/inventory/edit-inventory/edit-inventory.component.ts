import { Component, OnInit, Input } from '@angular/core';
import { Inventory } from 'src/app/class/inventory';
import { Router, ActivatedRoute } from '@angular/router';
import { InventoryService } from '../inventory.service';

@Component({
  selector: 'app-edit-inventory',
  templateUrl: './edit-inventory.component.html',
  styleUrls: ['./edit-inventory.component.css']
})
export class EditInventoryComponent implements OnInit {
  @Input()
  inventory: Inventory;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private inventoryService: InventoryService
  ) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.inventoryService.getInventoryById(id).subscribe(
        inv => (this.inventory = inv)
      );
    }
  }

  addToInventory(inv) {
    console.log('click');
    inv.item.price = +(<HTMLInputElement>document.getElementById('price')).value;
    inv.stock = +(<HTMLInputElement>document.getElementById('stock')).value;
    console.log(inv);
    this.inventoryService.updateInventoryItem(inv).subscribe(
      resp => {
        inv=resp;
        this.router.navigate(['inventory']);
      });
  }
}
