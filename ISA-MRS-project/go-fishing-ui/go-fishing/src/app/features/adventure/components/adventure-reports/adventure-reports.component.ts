import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { MessageService, MessageType } from 'src/app/shared/services/message-service/message.service';
import { ReservationService } from 'src/app/shared/services/reservation-service/reservation.service';
import { ReservationDTO } from 'src/models/reservation';
import { AdventureService } from '../../adventure.service';
import { Adventure } from '../../classes/adventure';

@Component({
  selector: 'app-adventure-reports',
  templateUrl: './adventure-reports.component.html',
  styleUrls: ['./adventure-reports.component.css']
})
export class AdventureReportsComponent implements OnInit {

  range = new FormGroup({
    start: new FormControl(null),
    end: new FormControl(null),
  });

  instructorId: number;
  adventures: Adventure[];
  adventureIds: number[];
  reservations: ReservationDTO[];

  title:string;
  x_axis:string;
  y_axis:string;
  ratingsData: any = [];
  dataForPieChart: any = [];

  showRatings: boolean = false;
  displayPieChart: boolean = false;

  constructor(private route: ActivatedRoute,
              private adventureService: AdventureService,
              private reservationService: ReservationService,
              private messageService: MessageService) { }

  ngOnInit(): void {
    this.instructorId = Number(this.route.snapshot.paramMap.get('id'));

    if(!isNaN(this.instructorId)){
      this.adventureService.getAdventuresOfInstructor(this.instructorId).subscribe(adventures => {
        this.adventures = adventures; 
        
        for (let ii = 0; ii < this.adventures.length; ii++) {          
          this.ratingsData.push({name: this.adventures[ii].name, value: this.adventures[ii].rating});
        }
        console.log(this.ratingsData);
        this.showRating();
      });
      this.reservationService.getReservationsForOwner(this.instructorId, "I").subscribe(data => {
        this.reservations = data;
        console.log(this.reservations);
      });
    }
  }

  showRating() {
    this.title = 'Prosečne ocene';
    this.showRatings = true;
  }

  showIncomeInDateRange() {
    if (this.range.value.start !== null && this.range.value.end !== null) {
      this.dataForPieChart = [];
      let start_date = this.range.value.start.getFullYear()+"-"+this.getFullNumber(this.range.value.start.getMonth()+1)+"-"+this.getFullNumber(this.range.value.start.getDate());
      let end_date = this.range.value.end.getFullYear()+"-"+this.getFullNumber(this.range.value.end.getMonth()+1)+"-"+this.getFullNumber(this.range.value.end.getDate());
      this.reservations.forEach(reservation => {
        let reservation_start = reservation.startDate.year+"-"+this.getFullNumber(reservation.startDate.month)+"-"+this.getFullNumber(reservation.startDate.day);
        if (start_date <= reservation_start && reservation_start <= end_date) {
          this.dataForPieChart.push({name: this.getAdventureNameById(reservation.offerId), value: reservation.totalPrice});
        }
      });
      console.log(this.dataForPieChart);
      this.displayPieChart = true;
    }
    else {
      this.messageService.showMessage('Unesite opseg datuma!', MessageType.WARNING);
    }
  }

  getFullNumber(x:number):string{
    if(x<10)
      return "0"+x;
    return ""+x;
  }

  getAdventureNameById(id: number) {
   var adventure;
    this.adventures.forEach(a => {
      if (a.id === id) {
        adventure = a.name;
      }
    });
    return adventure;
  }
}
