import { Component, OnInit } from '@angular/core';
import { Item } from '../class/item';
import { ItemService } from 'src/app/core/item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  public items: Item[];

  constructor(
    private itemService: ItemService
  ) { }

  ngOnInit() {
    this.fillItems();
  }

  fillItems() {
    this.itemService.getItems().subscribe(
      resp=>this.items=resp
    );
  }

  addItem() {

  }

  deleteItemAlert() {
    
  }

}
