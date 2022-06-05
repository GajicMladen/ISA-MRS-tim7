import { Component, Inject, Input, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ComplaintService } from 'src/app/shared/services/complaint-service/complaint.service';
import { ComplaintDTO } from 'src/models/complaint';

@Component({
  selector: 'app-reservation-end-report',
  templateUrl: './reservation-end-report.component.html',
  styleUrls: ['./reservation-end-report.component.css']
})
export class ReservationEndReportComponent implements OnInit {

  clientShowed:boolean;

  reservationReport : string;
  
  clientId:number;
  
  punchClient : boolean;
  
  constructor(
    public dialogRef: MatDialogRef<ReservationEndReportComponent>,
    @Inject(MAT_DIALOG_DATA) public data: number[],
    private complaintService:ComplaintService) { }

  ngOnInit(): void {
  }

  sendReport(){
    console.log(this.data);
    console.log(this.clientShowed);
    console.log(this.punchClient);
    
    if(this.clientShowed && this.punchClient){

      let newComplaint: ComplaintDTO = new ComplaintDTO();
      newComplaint.text = this.reservationReport;
      newComplaint.approvalStatus = 0;
      newComplaint.reservationId = this.data[0];
      newComplaint.punishOffender = this.punchClient;
      newComplaint.offenderId = this.data[1];
      
      this.complaintService.addNewComplaint(newComplaint).subscribe(
        data=>{
          console.log(data);
          this.dialogRef.close();
        }
      );
    }
  } 

  cancelReport(){
    this.dialogRef.close();
  }

}
