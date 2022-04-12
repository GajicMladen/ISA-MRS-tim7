import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StartpagePreviewListComponent } from './components/startpage-preview-list/startpage-preview-list.component';
import { StartpageLoginComponent } from './components/startpage-login/startpage-login.component';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [StartpagePreviewListComponent, StartpageLoginComponent],
  imports: [CommonModule, SharedModule],
})
export class StartpageModule {}
