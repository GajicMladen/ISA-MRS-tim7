import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';
import { FreePeriodDTO } from '../../classes/freePeriod';
import { FreePeriodService } from '../../services/free-period-service/free-period.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  offerId : number;
  freePeriods: FreePeriodDTO[];
  constructor(private route:ActivatedRoute,private freePeriodService:FreePeriodService) { }

  ngOnInit(): void {
    
    this.offerId = Number(this.route.snapshot.paramMap.get('id'));
    this.freePeriodService.getFreePeriodsForOffer(this.offerId).subscribe(data =>{
      console.log(data);
      this.freePeriods = data;
    });
    
  }


}
