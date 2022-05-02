import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartpageLoginComponent } from './features/startpage/components/startpage-login/startpage-login.component';
import { StartpagePreviewListComponent } from './features/startpage/components/startpage-preview-list/startpage-preview-list.component';
import { StartpageRegisterComponent } from './features/startpage/components/startpage-register/startpage-register.component';
import { CottageProfilepageComponent} from './features/cottage/components/cottage-profilepage/cottage-profilepage.component'
import { ReservationStartpageComponent } from './features/reservation/components/reservation-startpage/reservation-startpage.component';
import { AdventureProfilpageComponent } from './features/adventure/components/adventure-profilpage/adventure-profilpage.component';
import { AdventureReservationComponent } from './features/adventure/components/adventure-reservation/adventure-reservation.component';
import { AdventureCardComponent } from './features/adventure/components/adventure-card/adventure-card.component';
import { CottageOwnerpageComponent } from './features/cottage/components/cottage-ownerpage/cottage-ownerpage.component';
import { AdventureInstructorpageComponent } from './features/adventure/components/adventure-instructorpage/adventure-instructorpage.component';
import { EditProfileComponent } from './shared/components/edit-profile/edit-profile.component';
import { CottageAddNewComponent } from './features/cottage/components/cottage-add-new/cottage-add-new.component';

const routes: Routes = [
  { path: '', component: StartpagePreviewListComponent },
  { path: 'login', component: StartpageLoginComponent },
  { path: 'register', component: StartpageRegisterComponent },
  { path: 'cottageProfile', component: CottageProfilepageComponent },
  { path: 'reservationStart', component: ReservationStartpageComponent },
  { path: 'adventureProfile', component: AdventureProfilpageComponent },
  { path: 'adventureReservation', component: AdventureReservationComponent },
  { path: 'adventureCard', component: AdventureCardComponent},
  { path: 'instructorProfile', component: AdventureInstructorpageComponent },
  { path: 'cottageOwner' , component: CottageOwnerpageComponent },
  { path: 'editProfile',component: EditProfileComponent},
  { path: 'addNewCottage', component: CottageAddNewComponent},
  //Ubaciti komponentu za not found
  { path: '**', component: StartpagePreviewListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
