import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/shared/classes/user';
import { MessageService, MessageType } from 'src/app/shared/services/message-service/message.service';
import { UserService } from 'src/app/shared/services/users-services/user.service';
import { AdminService } from '../../admin.service';

@Component({
  selector: 'app-admin-profilpage',
  templateUrl: './admin-profilpage.component.html',
  styleUrls: ['./admin-profilpage.component.css']
})
export class AdminProfilpageComponent implements OnInit {

  form: FormGroup = this.createProfileForm();
  oldForm: FormGroup = this.createProfileForm();
  adminId: number;
  admin: User = new User();

  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private messageService: MessageService,
    private adminService: AdminService
  ) { }

  ngOnInit(): void {
    this.adminId = Number(this.route.snapshot.paramMap.get('id'));

    if(!isNaN(this.adminId)){
      this.userService.findById(this.adminId).subscribe(user => {
        this.admin = user;
        this.form.patchValue(user);
        this.oldForm.patchValue(user);
      
        console.log(this.admin);
      })
    }
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
      city: new FormControl(''),
      street: new FormControl(''),
      phone: new FormControl('', Validators.pattern('^[+][0-9]{10,12}$')),
    });
  }

  get updateButtonDisabled(): boolean {
    return (
      JSON.stringify(this.oldForm.getRawValue()) ===
      JSON.stringify(this.form.getRawValue())
    );
  }

  UpdateAdminData() {
    this.oldForm.patchValue(this.form.getRawValue());
    var user = new User();
    user.id = this.adminId;
    user.name = this.form.get('name')?.value;
    user.lastName = this.form.get('lastName')?.value;
    user.phone = this.form.get('phone')?.value;
    user.street = this.form.get('street')?.value;
    user.city = this.form.get('city')?.value;
    user.country = this.form.get('country')?.value;
    if (this.form.valid){
      this.adminService.updateAdminData(user).subscribe(res => {
        this.messageService.showMessage('Podaci uspešno izmenjeni!', MessageType.SUCCESS);
      });
    }    
  }

}