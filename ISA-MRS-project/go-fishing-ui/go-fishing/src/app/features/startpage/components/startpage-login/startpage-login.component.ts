import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {
  MessageService,
  MessageType,
} from 'src/app/shared/services/message-service/message.service';
import { StartpageLoginService } from './startpage-login.service';

@Component({
  selector: 'app-startpage-login',
  templateUrl: './startpage-login.component.html',
  styleUrls: ['./startpage-login.component.css'],
})
export class StartpageLoginComponent implements OnInit {
  form: FormGroup = this.createLoginForm();

  constructor(
    private route: ActivatedRoute,
    private messageService: MessageService,
    private loginService: StartpageLoginService,
    private router: Router
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

  createLoginForm(): FormGroup {
    return new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
    });
  }

  loginRequest(): void {
    this.loginService
      .sendLoginRequest(this.form.getRawValue())
      .pipe()
      .subscribe(
        (res) => {
          this.router.navigateByUrl('home/');
        },
        (error) => {
          this.messageService.showMessage(error, MessageType.ERROR);
        }
      );
  }
}
