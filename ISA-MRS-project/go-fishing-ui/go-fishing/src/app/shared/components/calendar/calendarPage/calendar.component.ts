import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';
import { ActionDTO } from 'src/models/reservation';
import { FreePeriodDTO } from '../../../../../models/freePeriod';
import { ActionService } from '../../../services/action-service/action.service';
import { FreePeriodService } from '../../../services/free-period-service/free-period.service';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  offerId : number;
  freePeriods: FreePeriodDTO[];
  actions: ActionDTO[];

  editPeriods = false;
  editActions = false;
  
  constructor(private route:ActivatedRoute,
    private freePeriodService:FreePeriodService,
    private actionServce:ActionService) { }

  ngOnInit(): void {
    
    this.offerId = Number(this.route.snapshot.paramMap.get('id'));
    this.getFreePeriods();
    this.getActions();
  }

  getFreePeriods(){
    this.freePeriodService.getFreePeriodsForOffer(this.offerId).subscribe(data =>{
      this.freePeriods = data;

    });
  }
  getActions(){
    this.actionServce.getActionsForOffer(this.offerId).subscribe(data =>{
      this.actions = data;
      
    });
  }

  deletePeriod(id:number){
    this.freePeriodService.deleteFreePeriod(id).subscribe(data =>{
      this.getFreePeriods();
    });
  }

  
  deleteAction(id:number){
    this.actionServce.deleteAction(id).subscribe(data =>{
      this.getActions();
    });
  }

  getParentMethod():any {
    return {
      callParentMethod: () => {
        this.getFreePeriods();
        this.getActions();
      }
    }
  }

  editPeriodsClick(){
    this.editPeriods = !this.editPeriods;
    if(this.editPeriods){
      this.editActions = false;
    }
  }

  editActionsClick(){
    this.editActions = !this.editActions;
    if(this.editActions){
      this.editPeriods = false;
    }
  }

}
