import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import {AppRoutingModule} from '../app-routing/app-routing.module';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ToastsComponent } from './toasts/toasts.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';


@NgModule({
  declarations: [NavBarComponent, ToastsComponent],
  imports: [
    CommonModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule
  ],
  exports: [
    NavBarComponent,
    ToastsComponent,
    NgbModule,
    FontAwesomeModule
  ]
})
export class SharedModule { }
