import { RouterModule, Route, CanActivate } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

import { Map1Component } from './views/maps/map1/map1.component';
import { ModalsComponent } from './views/modals/modals.component';
import { BasicTableComponent } from './views/tables/basic-table/basic-table.component';
import { ProfileComponent } from './views/profile/profile/profile.component';
import { NotFoundComponent } from './views/errors/not-found/not-found.component';
import { DashboardComponent } from './views/dashboards/dashboard/dashboard.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './login/register/register.component';
import { ForgetPasswordComponent } from './login/forget-password/forget-password.component';
import { EmployeeComponent } from './views/employee/employee.component';
import { OrderComponent } from './order/order/order.component';

import { AuthGuard } from './core/_guards';

const routes: Route[] = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LoginComponent },
  { path: 'order', component: OrderComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'forget', component: ForgetPasswordComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  {
    path: 'profile',
    children: [{ path: ':id', component: ProfileComponent }]
  },
  { path: 'employee', children: 
    [
      { path: 'inventory', component: EmployeeComponent }
    ]
  },
  // {
  //   path: 'orders', component: OrderComponent
  // },
  { path: 'profiles', children:
    [
      { path: 'profile1', component: ProfileComponent },
    ]
  },
  { path: 'tables', children:
    [
      { path: 'table1', component: BasicTableComponent },
    ]
  },
  { path: 'maps', children:
    [
      { path: 'map1', component: Map1Component},
    ]
  },

  { path: 'modals', component: ModalsComponent},
  { path: '**', component: NotFoundComponent },

];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);