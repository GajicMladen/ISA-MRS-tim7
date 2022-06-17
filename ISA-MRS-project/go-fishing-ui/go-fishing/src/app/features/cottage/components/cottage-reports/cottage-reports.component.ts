import { Component, Input, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/shared/services/reservation-service/reservation.service';

@Component({
  selector: 'app-cottage-reports',
  templateUrl: './cottage-reports.component.html',
  styleUrls: ['./cottage-reports.component.css']
})
export class CottageReportsComponent implements OnInit {

  constructor(private reservationService:ReservationService) { }

  dataForChar:any=[];

  title:string;
  x_axis:string;
  y_axis:string;

  displayChartPie:boolean = false;
  displayChart:boolean = true;

  @Input() ownerId:number;
  
  ngOnInit(): void {
  }

  displayCottagesBussy(){

    this.displayChart = true;
    this.displayChartPie= false;

    this.title = "Zauzetost vikendica";
    
    this.dataForChar = [
      { name: "Vikendica Kosmaj", value: 100 },
      { name: "Vila Raj", value: 55 },
      { name: "Selo Tur", value: 150 },
      { name: "Vrhpolje", value: 500 },
      { name: "Rocevic", value: 200 }
    ];

  }


  displayCottagesIncome(){
    this.displayChart = false;
    this.displayChartPie= true;


    this.title = "Prihodi od vikendica";
    this.reservationService.getProfitChartDataForReservations(this.ownerId,'C').subscribe(
      data =>{
        this.dataForChar = data;
      }
    );
  }

  displayCottagesGrades(){

    this.displayChart = true;
    this.displayChartPie= false;


    this.title = "Prosecne ocene vikendica";
    this.dataForChar = [
      { name: "Vikendica Kosmaj", value: 5.0 },
      { name: "Vila Raj", value: 3.5 },
      { name: "Selo Tur", value: 4.0 },
      { name: "Vrhpolje", value: 2.0 },
      { name: "Rocevic", value: 4.7 }
    ];
  }

}
