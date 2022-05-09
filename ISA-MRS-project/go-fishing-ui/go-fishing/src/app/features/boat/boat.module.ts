import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BoatProfilepageComponent } from './components/boat-profilepage/boat-profilepage.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    BoatProfilepageComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class BoatModule { }
