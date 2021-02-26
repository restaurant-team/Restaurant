import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import {AppRoutingModule} from '../app-routing/app-routing.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ToastsComponent } from './toasts/toasts.component';



@NgModule({
  declarations: [NavBarComponent, ToastsComponent],
  imports: [
    CommonModule,
    AppRoutingModule,
    NgbModule
  ],
  exports: [
    NavBarComponent,
    ToastsComponent,
    NgbModule
  ]
})
export class SharedModule { }
