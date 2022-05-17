import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomepageComponent } from './components/homepage/homepage.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { UserprofileComponent } from './components/userprofile/userprofile.component';

@NgModule({
  declarations: [HomepageComponent, UserprofileComponent],
  imports: [CommonModule, SharedModule, RouterModule, ReactiveFormsModule],
})
export class HomepageModule {}
