import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CottageProfilepageComponent } from './components/cottage-profilepage/cottage-profilepage.component';
import { CottageOwnerpageComponent } from './components/cottage-ownerpage/cottage-ownerpage.component';



@NgModule({
  declarations: [
    CottageProfilepageComponent,
    CottageOwnerpageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class CottageModule { }
