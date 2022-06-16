import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BoatProfilepageComponent } from './components/boat-profilepage/boat-profilepage.component';
import { RouterModule } from '@angular/router';
import { BoatOwnerpageComponent } from './components/boat-ownerpage/boat-ownerpage.component';
import { BoatGalleryOwnerComponent } from './components/boat-gallery-owner/boat-gallery-owner.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BoatAddNewComponent } from './components/boat-add-new/boat-add-new.component';
import { BoatEditComponent } from './components/boat-edit/boat-edit.component';
import { BoatReportsComponent } from './components/boat-reports/boat-reports.component';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [
    BoatProfilepageComponent,
    BoatOwnerpageComponent,
    BoatGalleryOwnerComponent,
    BoatAddNewComponent,
    BoatEditComponent,
    BoatReportsComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    SharedModule
  ]
})
export class BoatModule { }
