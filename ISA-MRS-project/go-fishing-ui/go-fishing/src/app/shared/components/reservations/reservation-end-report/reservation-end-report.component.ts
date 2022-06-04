import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reservation-end-report',
  templateUrl: './reservation-end-report.component.html',
  styleUrls: ['./reservation-end-report.component.css']
})
export class ReservationEndReportComponent implements OnInit {

  clientShowed:boolean;

  favoriteSeason: string;
  seasons: string[] = ['Winter', 'Spring', 'Summer', 'Autumn'];

  constructor(
    public dialogRef: MatDialogRef<ReservationEndReportComponent>,
    @Inject(MAT_DIALOG_DATA) public data: FormGroup) { }

  ngOnInit(): void {
  }

  sendReport(){
    console.log(this.data.getRawValue());
    console.log(this.clientShowed);
  }

  cancelReport(){
    this.dialogRef.close();
  }

}
