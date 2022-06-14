import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminProfilpageComponent } from './components/admin-profilpage/admin-profilpage.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { SharedModule } from 'src/app/shared/shared.module';
import { AdminRegistrationRequestsComponent } from './components/admin-registration-requests/admin-registration-requests.component';
import { AdminDeletionRequestsComponent } from './components/admin-deletion-requests/admin-deletion-requests.component';
import { AdminAddAdminComponent } from './components/admin-add-admin/admin-add-admin.component';
import { AdminService } from './admin.service';
import { EntityOverviewComponent } from './components/entity-overview/entity-overview.component';
import { AdminEntityOverviewComponent } from './components/admin-entity-overview/admin-entity-overview.component';



@NgModule({
  declarations: [
    AdminProfilpageComponent,
    AdminRegistrationRequestsComponent,
    AdminDeletionRequestsComponent,
    AdminAddAdminComponent,
    EntityOverviewComponent,
    AdminEntityOverviewComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    BrowserModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [AdminService]
})
export class AdminModule { }
