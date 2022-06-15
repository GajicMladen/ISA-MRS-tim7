import { Component, Inject, Input, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ComplaintService } from 'src/app/shared/services/complaint-service/complaint.service';
import { ComplaintDTO } from 'src/models/complaint';
import { ClientService } from 'src/app/shared/services/client-service/client.service';
import { User } from '../../../classes/user';
import { UserService} from 'src/app/shared/services/users-services/user.service'
import { Offer } from 'src/models/offer';
import { OfferService } from 'src/app/shared/services/offer-service/offer.service';
import { NgbCalendar, NgbDate, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'reservation-add-new-with-client',
  templateUrl: './reservation-add-new-with-client.component.html',
  styleUrls: ['./reservation-add-new-with-client.component.css']
})
export class ReservationAddNewWithClientComponent implements OnInit {

  offerId:number;
  offer: Offer;

  clientId:number;
  client : User;
  
  
  hoveredDate: NgbDate | null = null;

  fromDate: NgbDate | null;
  toDate: NgbDate | null;

  today: NgbDate ;

  constructor(
    public dialogRef: MatDialogRef<ReservationAddNewWithClientComponent>,
    @Inject(MAT_DIALOG_DATA) public data: number[],
    private calendar: NgbCalendar,
    public formatter: NgbDateParserFormatter,
    private userService:UserService,
    private offerService:OfferService,
    private clientService:ClientService) { }

  ngOnInit(): void {
        this.offerId = this.data[0];
        this.clientId = this.data[1];


        this.userService.findById(this.clientId).subscribe(
          data => {
            this.client = data;
          }
        );
        
        this.offerService.getCottageById(this.offerId).subscribe(
          data=>{
            this.offer = data;
          }
        )

  }

  sendReportOwner(){
    /*
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
    */
  } 

  cancelReport(){
    this.dialogRef.close();
  }

  onDateSelection(date: NgbDate) {
    if (!this.fromDate && !this.toDate) {
      this.fromDate = date;
    } else if (this.fromDate && !this.toDate && date && date.after(this.fromDate)) {
      this.toDate = date;
    } else {
      this.toDate = null;
      this.fromDate = date;
    }
  }

  isHovered(date: NgbDate) {
    return this.fromDate && !this.toDate && this.hoveredDate && date.after(this.fromDate) &&
        date.before(this.hoveredDate);
  }

  isInside(date: NgbDate) { return this.toDate && date.after(this.fromDate) && date.before(this.toDate); }

  isRange(date: NgbDate) {
    return date.equals(this.fromDate) || (this.toDate && date.equals(this.toDate)) || this.isInside(date) ||
        this.isHovered(date);
  }

  validateInput(currentValue: NgbDate | null, input: string): NgbDate | null {
    const parsed = this.formatter.parse(input);
    return parsed && this.calendar.isValid(NgbDate.from(parsed)) ? NgbDate.from(parsed) : currentValue;
  }

}
