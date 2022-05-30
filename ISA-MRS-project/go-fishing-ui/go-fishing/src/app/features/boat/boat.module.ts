import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BoatProfilepageComponent } from './components/boat-profilepage/boat-profilepage.component';
import { RouterModule } from '@angular/router';
import { BoatOwnerpageComponent } from './components/boat-ownerpage/boat-ownerpage.component';
import { BoatGalleryOwnerComponent } from './components/boat-gallery-owner/boat-gallery-owner.component';

@NgModule({
  declarations: [
    BoatProfilepageComponent,
    BoatOwnerpageComponent,
    BoatGalleryOwnerComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class BoatModule { }
