import { Component, OnInit } from '@angular/core';
import { Supplier } from '../class/supplier';
import { SupplierService } from '../supplier/supplier.service';
import { Item } from '../class/item';
import { FormControl, Validators } from '@angular/forms';
import { ItemService } from '../core/item.service';

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.css']
})
export class SupplierComponent implements OnInit {


  public suppliers: Supplier[];
  public items: Item[];
  private optionSelect: Array<any>;

  sup : Supplier = {id: 0, name: '', itemsup: {id: 0, name: '', price: 0.00}, email: ''}
  constructor(
    private supplierservice: SupplierService,
    private itemservice: ItemService
    
    ) {}

  ngOnInit() {
    this.optionSelect = new Array<any>();
    this.fillSups();
    this.fillItems();
    
  }

  fillSups(){
    this.supplierservice.getSuppliers().subscribe(supplierList => (this.suppliers = supplierList));
  }
  editSup(){
  }
  deleteSup(){

    //this.supplierservice.deleteSupplier(id);
  }
  fillItems(){
    this.itemservice.getItems().subscribe(itemList => (this.items = itemList));
    
  }
  submitModal(){
    this.supplierservice.addSupplier(this.sup).subscribe(value=>{console.log('Got it: ',value)},
    error=>{console.log('Did not get it')},
    ()=>{console.log('finsihed')});
  }
}
