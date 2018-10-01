import { RouterModule, Route, CanActivate } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

import { ProfileComponent } from './views/profile/profile/profile.component';
import { NotFoundComponent } from './views/errors/not-found/not-found.component';
import { DashboardComponent } from './views/dashboards/dashboard/dashboard.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './login/register/register.component';
import { ForgetPasswordComponent } from './login/forget-password/forget-password.component';
import { EmployeeComponent } from './views/employee/employee.component';
import { AuthGuard } from './core/_guards';
import { OrderComponent } from './order/order/order.component';

const routes: Route[] = [
  { path: '', pathMatch: 'full', redirectTo: 'dashboard' },
  { path: 'login', component: LoginComponent },
  // { path: 'orders', component: OrderComponent },
  { path: 'register', component: RegisterComponent, canActivate: [AuthGuard]},
  { path: 'forget', component: ForgetPasswordComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  {
    path: 'profile',
    children: [{ path: ':id', component: ProfileComponent }],
    canActivate: [AuthGuard]
  },
  {
    path: 'employee',
    children: [{ path: 'inventory', component: EmployeeComponent }],
    canActivate: [AuthGuard]
  },
  { path: '**', component: NotFoundComponent }
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
