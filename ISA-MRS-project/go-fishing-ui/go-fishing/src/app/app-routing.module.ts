import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartpageLoginComponent } from './features/startpage/components/startpage-login/startpage-login.component';
import { StartpagePreviewListComponent } from './features/startpage/components/startpage-preview-list/startpage-preview-list.component';
import { CottageProfilepageComponent} from './features/cottage/components/cottage-profilepage/cottage-profilepage.component'
import { ReservationStartpageComponent } from './features/reservation/components/reservation-startpage/reservation-startpage.component';


const routes: Routes = [
  { path: '', component: StartpagePreviewListComponent },
  { path: 'login', component: StartpageLoginComponent },
  { path: 'cottageProfile', component: CottageProfilepageComponent },
  { path: 'reservationStart', component: ReservationStartpageComponent },
  //Ubaciti komponentu za not found
  { path: '**', component: StartpagePreviewListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
