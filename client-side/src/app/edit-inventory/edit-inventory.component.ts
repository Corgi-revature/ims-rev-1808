import { Component, OnInit, Input } from '@angular/core';
import { Inventory } from 'src/app/class/inventory';
import { Router, ActivatedRoute } from '@angular/router';
import { EmployeeService } from 'src/app/views/employee/employee.service';
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
    private EmployeeService: EmployeeService
  ) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if(id) {
      this.EmployeeService.getInventoryById(id).subscribe(
        inv => (this.inventory = inv)
      );
    }
  }
}
