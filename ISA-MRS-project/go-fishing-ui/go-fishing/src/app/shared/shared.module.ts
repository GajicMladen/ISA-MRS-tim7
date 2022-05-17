import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MaterialModule } from './material/material.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RouterModule } from '@angular/router';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { MessageComponent } from './services/message-service/message.service';
import { SidebarComponent } from './components/sidebar/sidebar.component';

@NgModule({
  declarations: [
    NavbarComponent,
    EditProfileComponent,
    MessageComponent,
    SidebarComponent,
  ],
  imports: [CommonModule, RouterModule, MaterialModule, FontAwesomeModule],
  exports: [
    NavbarComponent,
    MaterialModule,
    EditProfileComponent,
    SidebarComponent,
  ],
})
export class SharedModule {}
