import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MaterialModule } from './material/material.module';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { RouterModule } from '@angular/router';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { MessageComponent } from './services/message-service/message.service';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { NewFreePeriodComponent } from './components/new-free-period/new-free-period.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CalendarComponent } from './components/calendarPage/calendar.component';
import { DemoModule } from './components/MyCalendar/demo/module';
import { DemoComponent } from './components/MyCalendar/demo/component';
import { OfferInfoComponent } from './components/offer-info/offer-info.component';

@NgModule({
  declarations: [NavbarComponent, EditProfileComponent, MessageComponent, SidebarComponent, NewFreePeriodComponent, CalendarComponent, OfferInfoComponent],
  imports: [CommonModule, RouterModule, MaterialModule, FontAwesomeModule,NgbModule,DemoModule],
  exports: [NavbarComponent, MaterialModule, EditProfileComponent, SidebarComponent, DemoComponent,OfferInfoComponent],
})
export class SharedModule {}
