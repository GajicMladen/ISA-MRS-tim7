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
import { CalendarComponent } from './components/calendar/calendarPage/calendar.component';
import { DemoModule } from './components/MyCalendar/demo/module';
import { DemoComponent } from './components/MyCalendar/demo/component';
import { OfferInfoComponent } from './components/offer-info/offer-info.component';
import { NewActionComponent } from './components/new-action/new-action.component';
import { FormsModule } from '@angular/forms';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { ChartComponent } from './components/chart/chart.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ChartPieComponent } from './components/calendar/chart-pie/chart-pie.component';
import { ReservationListView } from './components/reservations/reservations-list-view/reservations-list-view.component';
import { ReservationsOwnerpageComponent } from './components/reservations/reservations-ownerpage/reservations-ownerpage.component';

@NgModule({
  declarations: [
    NavbarComponent,
    EditProfileComponent,
    MessageComponent,
    NewFreePeriodComponent,
    CalendarComponent,
    OfferInfoComponent,
    NewActionComponent,
    SidebarComponent,
    ChartComponent,
    ChartPieComponent,
    ReservationListView,
    ReservationsOwnerpageComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule,
    FontAwesomeModule,
    NgbModule,
    DemoModule,
    FormsModule,
    NgxChartsModule,
    BrowserAnimationsModule
  ],
  exports: [
    NavbarComponent,
    MaterialModule,
    EditProfileComponent,
    DemoComponent,
    OfferInfoComponent,
    SidebarComponent,
    ChartComponent,
    ChartPieComponent,
    ReservationsOwnerpageComponent
  ],
})
export class SharedModule {}
