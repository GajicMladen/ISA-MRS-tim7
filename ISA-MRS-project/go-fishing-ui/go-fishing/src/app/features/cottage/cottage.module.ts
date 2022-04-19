import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CottageProfilepageComponent } from './components/cottage-profilepage/cottage-profilepage.component';
import { CottageOwnerpageComponent } from './components/cottage-ownerpage/cottage-ownerpage.component';
import { CottageGalleryOwnerComponent } from './components/cottage-gallery-owner/cottage-gallery-owner.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    CottageProfilepageComponent,
    CottageOwnerpageComponent,
    CottageGalleryOwnerComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class CottageModule { }
