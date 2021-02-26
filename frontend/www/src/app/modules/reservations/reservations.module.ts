import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservationsComponent } from './reservations/reservations.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [ReservationsComponent],
  imports: [
    CommonModule,
    NgbModule,
    FormsModule
  ],
  exports: [
    ReservationsComponent,
    NgbModule
  ]
})
export class ReservationsModule { }
