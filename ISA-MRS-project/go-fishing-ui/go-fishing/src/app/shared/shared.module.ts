import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MaterialModule } from './material/material.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RouterModule } from '@angular/router';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { MessageComponent } from './services/message-service/message.service';
import { NewFreePeriodComponent } from './components/new-free-period/new-free-period.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CalendarComponent } from './components/calendarPage/calendar.component';
import { DemoModule } from './components/MyCalendar/demo/module';
import { DemoComponent } from './components/MyCalendar/demo/component';
import { OfferInfoComponent } from './components/offer-info/offer-info.component';
import { NewActionComponent } from './components/new-action/new-action.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [NavbarComponent, EditProfileComponent, MessageComponent, NewFreePeriodComponent, CalendarComponent, OfferInfoComponent, NewActionComponent],
  imports: [CommonModule, RouterModule, MaterialModule, FontAwesomeModule,NgbModule,DemoModule,FormsModule],
  exports: [NavbarComponent, MaterialModule, EditProfileComponent,DemoComponent,OfferInfoComponent],
})
export class SharedModule {}
