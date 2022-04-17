import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartpageLoginComponent } from './features/startpage/components/startpage-login/startpage-login.component';
import { StartpagePreviewListComponent } from './features/startpage/components/startpage-preview-list/startpage-preview-list.component';
import { StartpageRegisterComponent } from './features/startpage/components/startpage-register/startpage-register.component';

const routes: Routes = [
  { path: '', component: StartpagePreviewListComponent },
  { path: 'login', component: StartpageLoginComponent },
  { path: 'register', component: StartpageRegisterComponent },
  //Ubaciti komponentu za not found
  { path: '**', component: StartpagePreviewListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
