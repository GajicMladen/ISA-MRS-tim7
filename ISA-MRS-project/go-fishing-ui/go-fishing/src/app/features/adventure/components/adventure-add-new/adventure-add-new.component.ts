import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { AdventureService } from '../../adventure.service';
import { Adventure } from '../../classes/adventure';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-adventure-add-new',
  templateUrl: './adventure-add-new.component.html',
  styleUrls: ['./adventure-add-new.component.css']
})
export class AdventureAddNewComponent implements OnInit {

  nameError: boolean = false;
  promoError: boolean = false;
  maxNumError: boolean = false;
  addressError: boolean = false;
  bioError: boolean = false;
  priceError: boolean = false;

  adventure = {
    name: "",
    promo: "",
    address: "",
    bio: "",
    maxNum: 0,
    price: 0,
    conductRules: "",
    equipment: "",
    cancelationRules: "",
    info: ""
  }

  constructor(private adventureService: AdventureService) 
  {
    
  }

  ngOnInit(): void {
    
  }

  addAdventure() {
    if (!this.CheckForErrors()) {
      var newAdventure = new Adventure({
        name: this.adventure.name,
        promoDescription: this.adventure.promo,
        price: this.adventure.price,
        capacity: this.adventure.maxNum,
        instructorId: 4,
        instructorBiography: this.adventure.bio
      });
      console.log(newAdventure);
      this.adventureService.addAdventure(newAdventure).subscribe(data => {
        alert("Nova avantura uspešno dodata!");
        console.log(data);
      });
    }
  }

  CheckForErrors(): boolean {
    var nameErr = this.nameHasError();
    var promoErr = this.promoHasError();
    var capacityErr = this.maxNumHasError();
    var addressErr = this.addressHasError();
    var bioErr = this.bioHasError();
    var priceErr = this.priceHasError();

    if (nameErr || promoErr || capacityErr || addressErr || bioErr || priceErr) {
      return true;
    }
    else {
      return false;
    }
  }
  priceHasError(): boolean {
    if (this.adventure.price === 0) {
      this.priceError = true;
      return true;
    }
    return false;
  }
  bioHasError(): boolean {
    if (this.adventure.bio === '') {
      this.bioError = true;
      return true;
    }
    return false;
  }
  addressHasError(): boolean {
    if (this.adventure.address === '') {
      this.addressError = true;
      return true;
    }
    return false;
  }
  maxNumHasError(): boolean {
    if (this.adventure.maxNum === 0) {
      this.maxNumError = true;
      return true;
    }
    return false;
  }
  promoHasError(): boolean {
    if (this.adventure.promo === '') {
      this.promoError = true;
      return true;
    }
    return false;
  }

  nameHasError(): boolean {
    if (this.adventure.name === '') {
      this.nameError = true;
      return true;
    }
    return false;
  }
}
