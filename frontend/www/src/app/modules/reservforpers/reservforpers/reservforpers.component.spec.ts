import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservforpersComponent } from './reservforpers.component';

describe('ReservforpersComponent', () => {
  let component: ReservforpersComponent;
  let fixture: ComponentFixture<ReservforpersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservforpersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservforpersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
