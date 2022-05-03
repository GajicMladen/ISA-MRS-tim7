import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {
  MessageService,
  MessageType,
} from 'src/app/shared/services/message-service/message.service';

@Component({
  selector: 'app-startpage-login',
  templateUrl: './startpage-login.component.html',
  styleUrls: ['./startpage-login.component.css'],
})
export class StartpageLoginComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    let activationStatus = this.route.snapshot.paramMap.get('status');

    switch (activationStatus) {
      case 'success': {
        this.messageService.showMessage(
          'Account activated successfully!',
          MessageType.SUCCESS
        );
        break;
      }
      case 'alreadyactive': {
        this.messageService.showMessage(
          'Account is already active!',
          MessageType.WARNING
        );
        break;
      }
      case 'invalidactivation': {
        this.messageService.showMessage(
          'Invalid activation attempt!',
          MessageType.ERROR
        );
        break;
      }
    }
  }
}
