import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryManageComponent } from './delivery.component';

describe('DeliveryComponent', () => {
  let component: DeliveryManageComponent;
  let fixture: ComponentFixture<DeliveryManageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeliveryManageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeliveryManageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
