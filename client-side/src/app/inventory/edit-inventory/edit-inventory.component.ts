import { Component, OnInit, Input } from '@angular/core';
import { Inventory } from 'src/app/class/inventory';
import { Router, ActivatedRoute } from '@angular/router';
import { InventoryService } from '../../inventory/inventory.service';
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
    private InventoryService: InventoryService
  ) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    if(id) {
      this.InventoryService.getInventoryById(id).subscribe(
        inv => (this.inventory = inv)
      );
    }
  }

  addToInventory(inv) {
    console.log("click");
    inv.item.price = +(<HTMLInputElement>document.getElementById("price")).value;
    inv.stock = +(<HTMLInputElement>document.getElementById("stock")).value;
    console.log(inv);
    this.InventoryService.updateInventoryItem(inv).subscribe(
      resp => {
        inv=resp;
        this.router.navigate(['inventory']);
      });
  }

  deleteFromInventoryAlert(inv) {
    const mess = "Are you sure you want to delete the following inventory entry?\n";
    const age = "id: "+inv.id+"\nitem: "+inv.item.name;
    const conf = confirm(mess+age);
    if(conf) {
      this.InventoryService.deleteInventoryItem(inv).subscribe(
        resp => {
          inv=resp;
          this.router.navigate(['inventory']);
        }
      );
    }
  }
}
