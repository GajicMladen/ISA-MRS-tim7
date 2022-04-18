import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdventureProfilpageComponent } from './components/adventure-profilpage/adventure-profilpage.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { BrowserModule } from '@angular/platform-browser';
import { AdventureReservationComponent } from './components/adventure-reservation/adventure-reservation.component';
import { AdventureCardComponent } from './components/adventure-card/adventure-card.component';



@NgModule({
  declarations: [
    AdventureProfilpageComponent,
    AdventureReservationComponent,
    AdventureCardComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    BrowserModule
  ]
})
export class AdventureModule { }
