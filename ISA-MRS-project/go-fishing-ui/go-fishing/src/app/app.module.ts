import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SharedModule } from './shared/shared.module';
import { StartpageModule } from './features/startpage/startpage.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RouterModule } from '@angular/router';
import { MaterialModule } from './shared/material/material.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { CottageModule } from './features/cottage/cottage.module';
import { ReservationModule } from './features/reservation/reservation.module';
import { AdventureModule } from './features/adventure/adventure.module';
import { HttpClientModule } from '@angular/common/http';
import { BoatModule } from './features/boat/boat.module';
  
@NgModule({
  declarations : [AppComponent],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    SharedModule,
    StartpageModule,
    FontAwesomeModule,
    MaterialModule,
    FormsModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    CottageModule,
    ReservationModule,
    AdventureModule,
    HttpClientModule,
    BoatModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
