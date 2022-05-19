import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {
  MessageService,
  MessageType,
} from 'src/app/shared/services/message-service/message.service';
import { UserprofileService } from './userprofile.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css'],
})
export class UserprofileComponent implements OnInit {
  form: FormGroup = this.createProfileForm();
  constructor(
    private profileService: UserprofileService,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.getUserData().subscribe((res: any) => {
      this.form.patchValue(res);
    });
  }

  createProfileForm(): FormGroup {
    return new FormGroup({
      email: new FormControl(
        { value: '', disabled: true },
        Validators.pattern('^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$')
      ),
      password: new FormControl(
        '',
        Validators.compose([Validators.minLength(8), Validators.maxLength(30)])
      ),
      confirmPassword: new FormControl(''),
      name: new FormControl(''),
      lastName: new FormControl(''),
      country: new FormControl(''),
      town: new FormControl(''),
      address: new FormControl(''),
      phoneNumber: new FormControl('', Validators.pattern('^[+][0-9]{10,12}$')),
    });
  }

  getUserData() {
    return this.profileService.getUserData();
  }

  updateProfileInfo() {
    let status: string = this.profileService.validateNewUserData(
      this.form.getRawValue()
    );

    if (status !== 'OK') {
      this.messageService.showMessage(status, MessageType.WARNING);
      return;
    } else {
      return this.profileService
        .updateProfileInfo(this.form.getRawValue())
        .pipe()
        .subscribe((res: any) => {
          this.messageService.showMessage(
            'Profile updated sucessfully!',
            MessageType.SUCCESS
          );
        });
    }
  }
}
