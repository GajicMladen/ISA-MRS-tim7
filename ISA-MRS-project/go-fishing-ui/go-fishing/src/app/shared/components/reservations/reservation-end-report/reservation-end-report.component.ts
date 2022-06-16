import { Component, Inject, Input, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ComplaintService } from 'src/app/shared/services/complaint-service/complaint.service';
import { ComplaintDTO } from 'src/models/complaint';
import { ClientService } from 'src/app/shared/services/client-service/client.service';

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

  reportExist : boolean = false;
  existingComplaint: ComplaintDTO;
  
  constructor(
    public dialogRef: MatDialogRef<ReservationEndReportComponent>,
    @Inject(MAT_DIALOG_DATA) public data: number[],
    private complaintService:ComplaintService,
    private clientService:ClientService) { }

  ngOnInit(): void {
    this.complaintService.getComplaintForReservationFromOwner(this.data[0]).subscribe(
      complaint => {
        this.existingComplaint = complaint;
        if(complaint != undefined){
          this.reportExist = true;
        }else{
          this.reportExist =false;
        }

      }
    )
  }

  sendReportOwner(){
    
    if(! this.clientShowed){
      this.clientService.addPenalToClient(this.data[1]).subscribe();
      
      let newComplaint: ComplaintDTO = new ComplaintDTO();
      newComplaint.text = "Klijent se nije pojavio, dobio je 1 penal";
      newComplaint.approvalStatus = 1;
      newComplaint.reservationId = this.data[0];
      newComplaint.punishOffender = this.punchClient;
      newComplaint.offenderId = this.data[1];
      newComplaint.fromOwner = true;
      
      this.complaintService.addNewComplaint(newComplaint).subscribe(
        data=>{
          console.log(data);
          this.dialogRef.close();
        }
      );
      return;
    }

    if(this.clientShowed && this.punchClient){

      let newComplaint: ComplaintDTO = new ComplaintDTO();
      newComplaint.text = this.reservationReport;
      newComplaint.approvalStatus = 0;
      newComplaint.reservationId = this.data[0];
      newComplaint.punishOffender = this.punchClient;
      newComplaint.offenderId = this.data[1];
      newComplaint.fromOwner = true;
      
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
