import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomepageComponent } from './components/homepage/homepage.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { PasswordChangeDialog } from './components/userprofile/change-password-dialog/password-change-dialog.component';
import { LoyaltyDialogComponent } from './components/userprofile/loyalty-dialog/loyalty-dialog.component';
import { DeletionRequestDialogComponent } from './components/userprofile/deletion-request-dialog/deletion-request-dialog.component';
import { EntityListComponent } from './components/entity-list/entity-list.component';
import { SearchDialogComponent } from './components/entity-list/search-dialog/search-dialog.component';

@NgModule({
  declarations: [
    HomepageComponent,
    UserprofileComponent,
    PasswordChangeDialog,
    LoyaltyDialogComponent,
    DeletionRequestDialogComponent,
    EntityListComponent,
    SearchDialogComponent,
  ],
  imports: [CommonModule, SharedModule, RouterModule, ReactiveFormsModule],
})
export class HomepageModule {}
