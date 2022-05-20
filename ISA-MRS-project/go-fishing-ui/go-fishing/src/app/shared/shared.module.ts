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

@NgModule({
  declarations: [NavbarComponent, EditProfileComponent, MessageComponent, NewFreePeriodComponent, CalendarComponent],
  imports: [CommonModule, RouterModule, MaterialModule, FontAwesomeModule,NgbModule,DemoModule],
  exports: [NavbarComponent, MaterialModule, EditProfileComponent,DemoComponent],
})
export class SharedModule {}
