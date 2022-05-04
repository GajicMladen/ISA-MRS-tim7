import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CottageProfilepageComponent } from './components/cottage-profilepage/cottage-profilepage.component';
import { CottageOwnerpageComponent } from './components/cottage-ownerpage/cottage-ownerpage.component';
import { CottageGalleryOwnerComponent } from './components/cottage-gallery-owner/cottage-gallery-owner.component';
import { RouterModule } from '@angular/router';
import { CottageAddNewComponent } from './components/cottage-add-new/cottage-add-new.component';
import { CottageService } from './services/cottage.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    CottageProfilepageComponent,
    CottageOwnerpageComponent,
    CottageGalleryOwnerComponent,
    CottageAddNewComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule
  ],
  providers:[CottageService]
})
export class CottageModule { }
