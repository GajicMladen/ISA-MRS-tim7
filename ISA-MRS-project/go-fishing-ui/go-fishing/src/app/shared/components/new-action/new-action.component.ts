import { NgModel } from '@angular/forms';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbCalendar, NgbDate, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { ActionDTO, ActionSendDTO } from 'src/models/reservation';
import { ActionService } from '../../services/action-service/action.service';

@Component({
  selector: 'app-new-action',
  templateUrl: './new-action.component.html',
  styleUrls: ['./new-action.component.css']
})
export class NewActionComponent implements OnInit {
 
  offerId : number;
  totalPrice: number;

  freePeriod: ActionDTO;
  startDate: string;
  hoveredDate: NgbDate | null = null;

  fromDate: NgbDate | null;
  toDate: NgbDate | null;

  today: NgbDate ;
  offer : Object;
  offerType: string;

  constructor(private route:ActivatedRoute,
    private router:Router,
     private calendar: NgbCalendar,
     public formatter: NgbDateParserFormatter,
     private actionService:ActionService) {
      this.fromDate = calendar.getToday();
      this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);
      this.today = calendar.getToday();
  }

  ngOnInit(): void {
    this.offerId = Number(this.route.snapshot.paramMap.get('id'));
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

  addNewAction(){

    if(this.fromDate != undefined && this.toDate !=undefined){
      
      let action = new ActionSendDTO();
      action.startDate = this.format(this.fromDate);
      action.endDate = this.format(this.toDate);
      action.offerId = this.offerId;
      action.totalPrice = this.totalPrice;
      
      //console.log(this.freePeriod);
      //console.log(JSON.stringify(this.freePeriod));

      this.actionService.addNewAction(action).subscribe(response =>{
        this.router.navigate(["/calendar/"+this.offerId]);
        this._pData.callParentMethod();
      });
    }
    else{
      console.log("lepo odaberi datume");
    }
  }
  @Input() _pData !: any;

  format(date: NgbDate | null): string {
    let stringDate: string = ""; 
    if(date != null) {
      stringDate += date.year+"-";
      stringDate += date.month ? date.month<10 ? "0"+date.month +"-": date.month + "-" : "01-";
      stringDate += date.day ? date.day < 10 ? "0"+date.day : date.day : "01";
      stringDate += "T00:00:01"
    }
    return stringDate;
}
}
