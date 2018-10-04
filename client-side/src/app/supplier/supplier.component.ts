import { Component, OnInit } from '@angular/core';
import { Supplier } from '../class/supplier';
import { SupplierService } from '../supplier/supplier.service';

@Component({
  selector: 'app-supplier',
  templateUrl: './supplier.component.html',
  styleUrls: ['./supplier.component.css']
})
export class SupplierComponent implements OnInit {


  public suppliers: Supplier[];


  constructor(private supplierservice: SupplierService
    
    ) {}

  ngOnInit() {
    this.fillSups();
  }

  fillSups(){
    this.supplierservice.getSuppliers().subscribe(supplierList => (this.suppliers = supplierList));
  }
  addSup(){

  }
  deleteSup(){

  }
}
