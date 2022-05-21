import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ImageServiceService } from 'src/app/shared/services/image-service/image-service.service';
import {
  MessageService,
  MessageType,
} from 'src/app/shared/services/message-service/message.service';
import { PasswordChangeDialog } from './change-password-dialog/password-change-dialog.component';
import { LoyaltyDialogComponent } from './loyalty-dialog/loyalty-dialog.component';
import { UserprofileService } from './userprofile.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css'],
})
export class UserprofileComponent implements OnInit {
  oldForm: FormGroup = this.createProfileForm();
  form: FormGroup = this.createProfileForm();
  updatePasswordForm: FormGroup = this.createUpdatePasswordForm();

  currentLoyaltyPoints: number = 0;

  constructor(
    private profileService: UserprofileService,
    private messageService: MessageService,
    private dialog: MatDialog,
    private imageService: ImageServiceService
  ) {}

  ngOnInit(): void {
    this.getUserData().subscribe((res: any) => {
      this.oldForm.patchValue(res);
      this.form.patchValue(res);
    });

    this.getLoyaltyPoints().subscribe((res: any) => {
      this.currentLoyaltyPoints = res.loyaltyPoints;
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

  createUpdatePasswordForm(): FormGroup {
    return new FormGroup({
      newPassword: new FormControl({ value: '' }, Validators.required),
      confirmNewPassword: new FormControl({ value: '' }, Validators.required),
    });
  }

  getUserData() {
    return this.profileService.getUserData();
  }

  getLoyaltyPoints() {
    return this.profileService.getLoyaltyPoints();
  }

  updateProfileInfo() {
    let status: string = this.profileService.validateNewUserData(
      this.form.getRawValue()
    );

    if (status !== 'OK') {
      this.messageService.showMessage(status, MessageType.WARNING);
      return;
    } else {
      this.oldForm.setValue(this.form.getRawValue());
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

  changePasswordDialog() {
    this.updatePasswordForm.get('newPassword')?.setValue('');
    this.updatePasswordForm.get('confirmNewPassword')?.setValue('');
    this.dialog.open(PasswordChangeDialog, {
      data: this.updatePasswordForm,
    });
  }

  loyaltyDialog() {
    this.dialog.open(LoyaltyDialogComponent);
  }

  get loyaltyBadge() {
    return this.imageService.loyaltyBadge;
  }

  get updateButtonDisabled(): boolean {
    return (
      JSON.stringify(this.oldForm.getRawValue()) ===
      JSON.stringify(this.form.getRawValue())
    );
  }
}
