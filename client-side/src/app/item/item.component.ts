import { Component, OnInit } from '@angular/core';
import { Item } from 'src/app/class/item';
import { ItemService } from 'src/app/core/item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {
  public items: Item[];

  item: Item = {id:0, name:'',price:0};
  constructor(
    private itemService: ItemService
  ) { }

  ngOnInit() {
    this.fillItems();
  }

  fillItems() {
    this.itemService.getItems().subscribe(
      resp=>{      
        this.items=resp;
      }
    );
  }

  addItem() {
    
  }

  editItem() {

  }

  deleteItem() {

  }

  submitModal() {

  }

}
