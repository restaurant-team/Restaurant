import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {ReservationsModule} from './modules/reservations/reservations.module';
import {HttpClientModule} from '@angular/common/http';
import {SharedModule} from './modules/shared/shared.module';
import {CoreModule} from './modules/core/core.module';
import {AppRoutingModule} from './modules/app-routing/app-routing.module';
import {LandingModule} from './modules/landing/landing.module';
import {MenuModule} from './modules/menu/menu.module'
import {ReservforpersModule} from './modules/reservforpers/reservforpers.module'

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReservationsModule,
    LandingModule,
    MenuModule,
    ReservforpersModule,
    SharedModule,
    CoreModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
