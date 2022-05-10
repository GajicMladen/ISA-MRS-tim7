import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-adventure-instructor-edit',
  templateUrl: './adventure-instructor-edit.component.html',
  styleUrls: ['./adventure-instructor-edit.component.css']
})
export class AdventureInstructorEditComponent implements OnInit {

  nameError: boolean = false;
  surnameError: boolean = false;
  addressError: boolean = false;
  cityError: boolean = false;
  countryError: boolean = false;
  phoneError: boolean = false;
  passwordError: boolean = false;
  confirmPasswordError: boolean = false;

  instructor = {
    id: 4,
    name: 'Mika',
    surname: 'Mikic',
    address: 'Ribarska 5',
    city: 'Mali Zvornik',
    country: 'Srbija',
    phone: '0642298111'
  }

  password = '';
  confirmPassword = '';

  constructor() {}

  ngOnInit(): void {

  }

  UpdateData() {
    if (!this.CheckForErrors()) {

    }
  }

  CheckForErrors(): boolean {
    var nameErr = this.nameHasError();
    var surnameErr = this.surnameHasError();
    var addressErr = this.addressHasError();
    var cityErr = this.cityHasError();
    var countryErr = this.countryHasError();
    var phoneErr = this.phoneHasError();
    var passwordErr = this.passwordHasError();
    var confirmPasswordErr = this.confirmPasswordHasError();
    if (nameErr || surnameErr || cityErr || addressErr || countryErr || phoneErr || passwordErr || confirmPasswordErr) {
      return true;
    }
    else {
      return false;
    }
  }
  nameHasError(): boolean {
    if (this.instructor.name === '') {
      this.nameError = true;
      return true;
    }
    return false;
  }
  surnameHasError(): boolean {
    if (this.instructor.surname === '') {
      this.surnameError = true;
      return true;
    }
    return false;
  }
  addressHasError(): boolean {
    if (this.instructor.address === '') {
      this.addressError = true;
      return true;
    }
    return false;
  }
  cityHasError(): boolean {
    if (this.instructor.city === '') {
      this.cityError = true;
      return true;
    }
    return false;
  }
  countryHasError(): boolean {
    if (this.instructor.country === '') {
      this.countryError = true;
      return true;
    }
    return false;
  }
  phoneHasError(): boolean {
    if (this.instructor.phone === '') {
      this.phoneError = true;
      return true;
    } else if (this.instructor.phone.length < 10 || this.instructor.phone.length > 12) {
      this.phoneError = true;
      return true;
    } 
    return false;
  }
  passwordHasError(): boolean {
    if (this.password !== '') {
      if (this.password.length < 8 || this.password.length > 30) {
        this.passwordError = true;
        return true;
      }
    }
    return false;
  }
  confirmPasswordHasError(): boolean {
    if (this.password !== this.confirmPassword) {
      this.confirmPasswordError = true;
      return true;
    }
    return false;
  }
}
