import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservforpersComponent } from './reservforpers/reservforpers.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [ReservforpersComponent],
  imports: [
    CommonModule,
    NgbModule,
  ],
  exports: [
    ReservforpersComponent,
    NgbModule,
  ]
})
export class ReservforpersModule { }
