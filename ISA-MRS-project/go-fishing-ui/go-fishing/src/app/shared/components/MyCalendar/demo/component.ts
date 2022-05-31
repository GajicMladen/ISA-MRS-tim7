import {
  Component,
  ChangeDetectionStrategy,
  ViewEncapsulation,
  Input,
} from '@angular/core';
import { dateInputsHaveChanged } from '@angular/material/datepicker/datepicker-input-base';
import {
  CalendarEvent,
  CalendarMonthViewBeforeRenderEvent,
  CalendarView,
} from 'angular-calendar';
import { MonthViewDay } from 'calendar-utils';
import { Subject } from 'rxjs';
import { FreePeriodDTO } from 'src/models/freePeriod';
import { ActionDTO } from 'src/models/reservation';

@Component({
  selector: 'mwl-demo-component',
  changeDetection: ChangeDetectionStrategy.OnPush,
  encapsulation: ViewEncapsulation.None,
  templateUrl: 'template.html',
  styles: [
    `
      .cal-month-view .bg-green,
      .cal-week-view .cal-day-columns .bg-green,
      .cal-day-view .bg-green {
        background-color: #70be70 !important;
      }
      .cal-month-view .bg-yellow, 
      .cal-week-view .cal-day-columns .bg-yellow,
      .cal-day-view .bg-yellow{
        background-color: #f2d748 !important;
      }
    `,
  ],
})
export class DemoComponent {
  view: CalendarView = CalendarView.Month;

  viewDate: Date = new Date();

  events: CalendarEvent[] = [];

  refresh = new Subject<void>();

  @Input() freePeriods: FreePeriodDTO[];
  @Input() actions: ActionDTO[];

  beforeMonthViewRender(renderEvent: CalendarMonthViewBeforeRenderEvent): void {
    console.log(this.freePeriods.length);
    console.log(">>>>>>>");
    console.log(this.actions.length);
    
    renderEvent.body.forEach((day) => {
      const dayOfMonth = day.date.getDate();
      if ( this.freePeriods.length > 0 && this.isDayInFreePeriods(day)) {
        day.cssClass = 'bg-green';
      }
      if( this.actions.length > 0 && this.isDayInActions(day)){
        day.cssClass = 'bg-yellow';
      }
    });
  }


  refreshView(): void {
    console.log("fgas");
    this.refresh.next();

  }
  
  isDayInFreePeriods(day:MonthViewDay<any>):boolean{

    let res = false;
    let day_S = day.date.getFullYear()+"-"+this.getFullNumber(day.date.getMonth()+1)+"-"+this.getFullNumber(day.date.getDate());
  
    this.freePeriods.forEach(fp => {
      let startDate = fp.startDate.year+"-"+this.getFullNumber(fp.startDate.month)+"-"+this.getFullNumber(fp.startDate.day);
      let endDate = fp.endDate.year+"-"+this.getFullNumber(fp.endDate.month)+"-"+this.getFullNumber(fp.endDate.day);
      
      if( day_S >= startDate && day_S <= endDate){
        res = true;
      }
    });
    return res;
  }

  isDayInActions(day:MonthViewDay<any>):boolean{

    let res = false;
    let day_S = day.date.getFullYear()+"-"+this.getFullNumber(day.date.getMonth()+1)+"-"+this.getFullNumber(day.date.getDate());
  
    this.actions.forEach(action => {
      let startDate = action.startDate.year+"-"+this.getFullNumber(action.startDate.month)+"-"+this.getFullNumber(action.startDate.day);
      let endDate = action.endDate.year+"-"+this.getFullNumber(action.endDate.month)+"-"+this.getFullNumber(action.endDate.day);
      
      if( day_S >= startDate && day_S <= endDate){
        res = true;
      }
    });
    return res;
  }
  getFullNumber(x:number):string{
    if(x<10)
      return "0"+x;
    return ""+x;
  }
}
