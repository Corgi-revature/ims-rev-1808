import { Component, OnInit, Input } from '@angular/core';
//import { ItemService } from '../../core/item.service';
//import { Item } from '../../class/item';
import { Inventory } from '../../class/inventory';
import { EmployeeService }  from './employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  @Input()
  inventories: Inventory[];

  constructor(
    private EmployeeService: EmployeeService
  ) { }

  ngOnInit() {
    this.fillItemList();
  }

  fillItemList() {
    this.EmployeeService.getInventories().subscribe(invList => (this.inventories = invList));
  }
}
