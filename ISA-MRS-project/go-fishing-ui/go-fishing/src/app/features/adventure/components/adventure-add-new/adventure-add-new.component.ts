import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { AdventureService } from '../../adventure.service';

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

  form: FormGroup = this.generateForm();

  errorMatcher: boolean = false;

  name = new FormControl('', [Validators.required]);

  constructor(private adventureService: AdventureService) 
  {
    
  }

  ngOnInit(): void {
    
  }

  getErrorMessage() {
    if (this.name.hasError('required')) {
      return 'Ovo je obavezno polje!';
    }

    return '';
  }

  generateForm(): FormGroup {
    return new FormGroup({
      name: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      promo: new FormControl('', Validators.required),
      bio: new FormControl('', Validators.required),
      maxNum: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required)
    });
  }

  addAdventure() {
    this.adventureService.addAdventure(this.adventure).subscribe(data => console.log(data));
  }

}
