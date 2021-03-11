import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './menu/menu.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {SharedModule} from '../shared/shared.module';



@NgModule({
  declarations: [MenuComponent],
  imports: [
    CommonModule,
    NgbModule,
    SharedModule
  ],
  exports: [
     MenuComponent,
    NgbModule
  ]
})
export class MenuModule { }
