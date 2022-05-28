import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FreePeriodService } from 'src/app/shared/services/free-period-service/free-period.service';
import { MessageService, MessageType } from 'src/app/shared/services/message-service/message.service';
import { UserService } from 'src/app/shared/services/users-services/user.service';
import { FreePeriodDTO } from 'src/models/freePeriod';
import { AdventureService } from '../../adventure.service';

@Component({
  selector: 'app-adventure-instructor-calendar',
  templateUrl: './adventure-instructor-calendar.component.html',
  styleUrls: ['./adventure-instructor-calendar.component.css']
})
export class AdventureInstructorCalendarComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private freePeriodService: FreePeriodService,
              private adventureService: AdventureService,
              private messageService: MessageService) { }

  instructorId: number;
  freePeriods: FreePeriodDTO[] = [];
  adventureIds: number[] = [];

  ngOnInit(): void {
    this.instructorId = Number(this.route.snapshot.paramMap.get('id'));
    if(!isNaN(this.instructorId)){
      this.adventureService.getAdventureIds(this.instructorId).subscribe( ids => {
        this.adventureIds = ids as number[];
        console.log(this.adventureIds.join());
        this.freePeriodService.getFreePeriodsForOffers(this.adventureIds.join()).subscribe(data => {
          this.freePeriods = data;
        });
        console.log(this.freePeriods);
      });
    }
  }

  deletePeriod(id:number){

    console.log(id);
    this.freePeriodService.deleteFreePeriod(id).subscribe(data =>{
      this.freePeriods.forEach((element, index) => {if(element.id === id) this.freePeriods.splice(index, 1)});
      this.messageService.showMessage('Slobodan termin uspešno obrisan!', MessageType.SUCCESS);
    });
  }

}
