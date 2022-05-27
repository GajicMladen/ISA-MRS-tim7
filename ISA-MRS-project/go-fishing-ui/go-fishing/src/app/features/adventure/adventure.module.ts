import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdventureProfilpageComponent } from './components/adventure-profilpage/adventure-profilpage.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { BrowserModule } from '@angular/platform-browser';
import { AdventureReservationComponent } from './components/adventure-reservation/adventure-reservation.component';
import { AdventureCardComponent } from './components/adventure-card/adventure-card.component';
import { AdventureInstructorpageComponent } from './components/adventure-instructorpage/adventure-instructorpage.component';
import { AdventureService } from './adventure.service';
import { AdventureAddNewComponent } from './components/adventure-add-new/adventure-add-new.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdventureInstructorEditComponent } from './components/adventure-instructor-edit/adventure-instructor-edit.component';
import { RouterModule } from '@angular/router';
import { AdventureEditComponent } from './components/adventure-edit/adventure-edit.component';
import { AdventureFreePeriodComponent } from './components/adventure-free-period/adventure-free-period.component';


@NgModule({
  declarations: [
    AdventureProfilpageComponent,
    AdventureReservationComponent,
    AdventureCardComponent,
    AdventureInstructorpageComponent,
    AdventureAddNewComponent,
    AdventureInstructorEditComponent,
    AdventureEditComponent,
    AdventureFreePeriodComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    BrowserModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule
    //ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'})
  ],
  providers: [AdventureService]
})
export class AdventureModule { }
