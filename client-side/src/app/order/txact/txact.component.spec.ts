import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TxactComponent } from './txact.component';

describe('OrderComponent', () => {
  let component: TxactComponent;
  let fixture: ComponentFixture<TxactComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TxactComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TxactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
