import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservforpersComponent } from './reservforpers/reservforpers.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {SharedModule} from '../shared/shared.module';



@NgModule({
  declarations: [ReservforpersComponent],
  imports: [
    CommonModule,
    NgbModule,
    SharedModule
  ],
  exports: [
    ReservforpersComponent,
    NgbModule,
  ]
})
export class ReservforpersModule { }
