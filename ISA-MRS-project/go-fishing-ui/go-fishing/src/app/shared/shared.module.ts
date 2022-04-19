import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MaterialModule } from './material/material.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RouterModule } from '@angular/router';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';

@NgModule({
  declarations: [NavbarComponent, EditProfileComponent],
  imports: [CommonModule, RouterModule, MaterialModule, FontAwesomeModule],
  exports: [NavbarComponent, MaterialModule,EditProfileComponent],
})
export class SharedModule {}
