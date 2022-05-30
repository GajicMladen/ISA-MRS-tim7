import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-loyalty-dialog',
  templateUrl: './loyalty-dialog.component.html',
  styleUrls: ['./loyalty-dialog.component.css'],
})
export class LoyaltyDialogComponent implements OnInit {
  constructor(public dialogRef: MatDialogRef<LoyaltyDialogComponent>) {}

  ngOnInit(): void {}

  onExitClick() {
    this.dialogRef.close();
  }
}
