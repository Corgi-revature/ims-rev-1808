import { AgmCoreModule } from '@agm/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, NO_ERRORS_SCHEMA, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AppRoutes } from './app.routes.service';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { ViewsModule } from './views/views.module';
import { SharedModule } from './shared/shared.module';
import { ErrorModule } from './views/errors/error.module';

// main layout
import { NavigationModule } from './main-layout/navigation/navigation.module';

// functional components
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './login/register/register.component';
import { ForgetPasswordComponent } from './login/forget-password/forget-password.component';
// services
import { CoreService } from './core/core.service';
import { OrderComponent } from './order/order/order.component';
import { CheckoutComponent } from './order/checkout/checkout.component';
import { DeliveryComponent } from './order/delivery/delivery.component';
import { UserComponent } from './login/user/user.component';
import { AuthGuard } from './core/_guards';
import { AlertComponent } from './shared/services/alert/alert.component';
import { AlertService } from './shared/services/alert/alert.service';
import { EditInventoryComponent } from './inventory/edit-inventory/edit-inventory.component';
import { EmployeeComponent } from './login/user/employee/employee.component';
import { CustomerComponent } from './login/user/customer/customer.component';
import { PhonePipe } from './shared/pipe/phone.pipe';
import { ItemFilterPipe } from './shared/pipe/item-filter.pipe';
import { InventoryComponent } from './inventory/inventory.component';
import { AddInventoryComponent} from './inventory/add-inventory/add-inventory.component';
import { SupplierComponent } from './supplier/supplier.component';
import { ItemComponent } from './item/item.component';
import { ProfileComponent } from './login/profile/profile.component';
import { BreadcrumbsComponent } from './main-layout/breadcrumbs/breadcrumbs.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ForgetPasswordComponent,
    OrderComponent,
    SupplierComponent,
    EditInventoryComponent,
    CheckoutComponent,
    DeliveryComponent,
    EmployeeComponent,
    InventoryComponent,
    AddInventoryComponent,
    EditInventoryComponent,
    CustomerComponent,
    PhonePipe,
    ProfileComponent,
    ItemFilterPipe,
    UserComponent,
    ItemComponent,
    BreadcrumbsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    NavigationModule,
    AppRoutes,
    RouterModule,
    FormsModule,
    SharedModule,
    ViewsModule,
    ErrorModule,
    FormsModule,
    ReactiveFormsModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [
    CoreService,
    AlertService,
    AuthGuard,
  ],
  schemas: [NO_ERRORS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
