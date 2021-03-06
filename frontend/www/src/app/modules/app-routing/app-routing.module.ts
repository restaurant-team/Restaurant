import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ReservationsComponent} from '../reservations/reservations/reservations.component';
import {HomeComponent} from '../landing/home/home.component';
import {MenuComponent} from '../menu/menu/menu.component';
import {ReservforpersComponent} from '../reservforpers/reservforpers/reservforpers.component'


const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'reservations',
    component: ReservationsComponent
  },
  {
    path: 'menu',
    component : MenuComponent
  },
  {
    path: 'reservforpers',
    component : ReservforpersComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
