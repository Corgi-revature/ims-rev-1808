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
  edititem: Item = {id:0, name:'',price:0}
  constructor(
    private itemService: ItemService
  ) { }

  ngOnInit() {
    this.fillItems();
  }

  fillItems() {
    this.itemService.getItems().subscribe(
      resp=>{
        resp.sort(function(a,b){return a.id-b.id});      
        this.items=resp;
      }
    );
  }

  editItem(item: Item) {
    this.itemService.getItemById(item.id).subscribe(
      resp=>{
        this.edititem=resp;
        this.fillItems();
      }
    );
  }

  deleteItem(item:Item) {
    const mess = 'Are you sure you want to delete the following item entry?';
    const age = '\nid: ' + item.id + '\nitem: ' + item.name+'\nprice: $'+item.price;
    const conf = confirm(mess + age);
    console.log(conf);
    if (conf) {
      this.itemService.deleteItem(item).subscribe(()=>this.fillItems());
    }
  }

  submitEdit() {
    this.itemService.updateItem(this.edititem).subscribe(()=>{this.fillItems()});
  }

  submitModal() {
    this.itemService.createItem(this.item).subscribe(value=>{console.log('Got it: ',value)},
    error=>{console.log('Did not get it')},
    ()=>{this.fillItems()});
  }
}
