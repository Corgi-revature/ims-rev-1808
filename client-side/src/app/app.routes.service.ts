import { RouterModule, Route, CanActivate } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

import { Map1Component } from './views/maps/map1/map1.component';
import { ModalsComponent } from './views/modals/modals.component';
import { BasicTableComponent } from './views/tables/basic-table/basic-table.component';
import { ProfileComponent } from './login/profile/profile.component';
import { NotFoundComponent } from './views/errors/not-found/not-found.component';
import { DashboardComponent } from './views/dashboards/dashboard/dashboard.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './login/register/register.component';
import { ForgetPasswordComponent } from './login/forget-password/forget-password.component';
import { OrderComponent } from './order/order/order.component';
import { CheckoutComponent } from './order/checkout/checkout.component';
import { DeliveryComponent } from './order/delivery/delivery.component';
import { AuthGuard } from './core/_guards';
import { EditInventoryComponent } from './inventory/edit-inventory/edit-inventory.component';
import { UserComponent } from './login/user/user.component';
import { SupplierComponent } from './supplier/supplier.component';
// need to change to employee
import { EmployeeComponent } from './login/user/employee/employee.component';
import { CustomerComponent } from './login/user/customer/customer.component';
import { InventoryComponent } from './inventory/inventory.component';
import { AddInventoryComponent } from './inventory/add-inventory/add-inventory.component';
import { ItemComponent } from './item/item.component';
import { DeliveryManageComponent } from './delivery/delivery.component';
import { OrderListComponent } from './order/list/order-list.component';

const routes: Route[] = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'forget', component: ForgetPasswordComponent },
  {
    path: 'orders',
    children: [
      { path: 'list', component: OrderListComponent },
      { path: 'add', component: OrderComponent }
    ], canActivate: [AuthGuard]
  },
  { path: 'checkout', component: CheckoutComponent, canActivate: [AuthGuard] },
  { path: 'delivery', component: DeliveryComponent, canActivate: [AuthGuard] },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  {
    path: 'users',
    children: [
      { path: 'employee', component: EmployeeComponent },
      { path: 'customer', component: CustomerComponent }
    ],
    canActivate: [AuthGuard]
  },
  {
    path: 'profile', component: ProfileComponent,
    // children: [{ path: ':id', component: ProfileComponent }],
    canActivate: [AuthGuard]
  },
  {
    path: 'modals',
    children: [{ path: 'modal', component: ModalsComponent }]
  },
  {
    path: 'tables',
    children: [{ path: 'table', component: BasicTableComponent }]
  },
  {
    path: 'inventory', component: InventoryComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'inventory/add', component: AddInventoryComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'inventory/:id', component: EditInventoryComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'supplier', component: SupplierComponent, canActivate: [AuthGuard]
  },
  {
    path: 'manage/delivery', component: DeliveryManageComponent, canActivate: [AuthGuard]
  },
  {
    path: 'item', component: ItemComponent, canActivate: [AuthGuard]
  },
  { path: '**', component: NotFoundComponent },

];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
