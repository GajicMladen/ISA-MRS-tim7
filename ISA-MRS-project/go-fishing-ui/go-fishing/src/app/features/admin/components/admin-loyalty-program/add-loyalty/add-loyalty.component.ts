import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-add-loyalty',
  templateUrl: './add-loyalty.component.html',
  styleUrls: ['./add-loyalty.component.css']
})
export class AddLoyaltyComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<AddLoyaltyComponent>) { }

  form: FormGroup = this.generateForm();

  ngOnInit(): void {
  }

  generateForm(): FormGroup {
    return new FormGroup({
      id: new FormControl(''),
      rankName: new FormControl(''),
      minPoints: new FormControl(''),
      maxPoints: new FormControl(''),
      discountRate: new FormControl(''),
      pointsPerReservation: new FormControl('')
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }


}
