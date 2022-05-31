import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartpageLoginComponent } from './features/startpage/components/startpage-login/startpage-login.component';
import { StartpagePreviewListComponent } from './features/startpage/components/startpage-preview-list/startpage-preview-list.component';
import { StartpageRegisterComponent } from './features/startpage/components/startpage-register/startpage-register.component';
import { CottageProfilepageComponent } from './features/cottage/components/cottage-profilepage/cottage-profilepage.component';
import { ReservationStartpageComponent } from './features/reservation/components/reservation-startpage/reservation-startpage.component';
import { AdventureProfilpageComponent } from './features/adventure/components/adventure-profilpage/adventure-profilpage.component';
import { AdventureReservationComponent } from './features/adventure/components/adventure-reservation/adventure-reservation.component';
import { CottageOwnerpageComponent } from './features/cottage/components/cottage-ownerpage/cottage-ownerpage.component';
import { AdventureInstructorpageComponent } from './features/adventure/components/adventure-instructorpage/adventure-instructorpage.component';
import { EditProfileComponent } from './shared/components/edit-profile/edit-profile.component';
import { CottageAddNewComponent } from './features/cottage/components/cottage-add-new/cottage-add-new.component';
import { CottageEditComponent } from './features/cottage/components/cottage-edit/cottage-edit.component';
import { AdventureAddNewComponent } from './features/adventure/components/adventure-add-new/adventure-add-new.component';
import { AdventureCardComponent } from './features/adventure/components/adventure-card/adventure-card.component';
import { AdventureInstructorEditComponent } from './features/adventure/components/adventure-instructor-edit/adventure-instructor-edit.component';
import { BoatProfilepageComponent } from './features/boat/components/boat-profilepage/boat-profilepage.component';
import { HomepageComponent } from './features/homepage/components/homepage/homepage.component';
import { UserprofileComponent } from './features/homepage/components/userprofile/userprofile.component';
import { EntityListComponent } from './features/homepage/components/entity-list/entity-list.component';

import { NewFreePeriodComponent } from './shared/components/new-free-period/new-free-period.component';
import { CalendarComponent } from './shared/components/calendarPage/calendar.component';

import { AdventureEditComponent } from './features/adventure/components/adventure-edit/adventure-edit.component';
import { AdventureFreePeriodComponent } from './features/adventure/components/adventure-free-period/adventure-free-period.component';
import { AdventureInstructorCalendarComponent } from './features/adventure/components/adventure-instructor-calendar/adventure-instructor-calendar.component';

import { BoatOwnerpageComponent } from './features/boat/components/boat-ownerpage/boat-ownerpage.component';
import { BoatAddNewComponent } from './features/boat/components/boat-add-new/boat-add-new.component';
import { BoatEditComponent } from './features/boat/components/boat-edit/boat-edit.component';

const routes: Routes = [
  { path: '', component: StartpagePreviewListComponent },
  { path: 'login', component: StartpageLoginComponent },
  { path: 'login/:status', component: StartpageLoginComponent },
  { path: 'register', component: StartpageRegisterComponent },
  { path: 'cottageProfile/:id', component: CottageProfilepageComponent },
  { path: 'reservationStart', component: ReservationStartpageComponent },
  { path: 'adventureProfile/:id', component: AdventureProfilpageComponent },
  { path: 'adventureReservation', component: AdventureReservationComponent },

  { path: 'adventureCard', component: AdventureCardComponent },
  { path: 'cottageOwner/:id', component: CottageOwnerpageComponent },
  { path: 'adventureAddNew', component: AdventureAddNewComponent },
  { path: 'instructorProfile', component: AdventureInstructorpageComponent },
  { path: 'editInstructor', component: AdventureInstructorEditComponent },
  { path: 'boatProfile/:id', component: BoatProfilepageComponent },

  { path: 'editProfile', component: UserprofileComponent },
  { path: 'addNewCottage', component: CottageAddNewComponent },
  { path: 'editCottage/:id', component: CottageEditComponent },
  
  { path: 'addNewBoat', component: BoatAddNewComponent },
  { path: 'editBoat/:id', component: BoatEditComponent },
  {
    path: 'home',
    component: HomepageComponent,
    children: [
      { path: 'userProfile', component: UserprofileComponent },
      { path: 'cottageList', component: EntityListComponent },
      { path: 'boatList', component: EntityListComponent },
      { path: 'adventureList', component: EntityListComponent },
      { path: '', redirectTo: 'userProfile', pathMatch: 'full' },
    ],
  },
  { path: 'adventureAddNew/:id', component: AdventureAddNewComponent },
  { path: 'instructorProfile/:id', component: AdventureInstructorpageComponent },
  { path: 'addFreePeriod/:id', component: AdventureFreePeriodComponent },
  { path: 'instructorCalendar/:id', component: AdventureInstructorCalendarComponent },

  { path: 'newFreePeriod/:id', component: NewFreePeriodComponent },
  { path: 'calendar/:id', component: CalendarComponent },

  { path: 'editInstructor/:id', component: AdventureInstructorEditComponent },
  { path: 'boatProfile/:id' , component:BoatProfilepageComponent },
  { path: 'boatOwner/:id' , component: BoatOwnerpageComponent},
  { path: 'editAdventure/:id', component:AdventureEditComponent },
    
  //Ubaciti komponentu za not found
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
