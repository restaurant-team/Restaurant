import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {Routes, RouterModule} from '@angular/router'

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ReservationsComponent } from './reservations/reservations.component';

const appRoutes: Routes = [
  {path: '', component : HomeComponent},
  {path: 'reservations', component : ReservationsComponent}

]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ReservationsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
