import { Component, Input, OnInit } from '@angular/core';
import { ReservationService } from 'src/app/shared/services/reservation-service/reservation.service';

@Component({
  selector: 'app-boat-reports',
  templateUrl: './boat-reports.component.html',
  styleUrls: ['./boat-reports.component.css']
})
export class BoatReportsComponent implements OnInit {

  @Input() ownerId:number;

  constructor(private reservationService:ReservationService) { }

  dataForChar:any=[
    { name: "Vikendica Kosmaj", value: 100 },
    { name: "Vila Raj", value: 55 },
    { name: "Selo Tur", value: 150 },
    { name: "Vrhpolje", value: 500 },
    { name: "Rocevic", value: 200 }
  ];

  title:string;
  x_axis:string;
  y_axis:string;

  displayChartPie:boolean = false;
  displayChart:boolean = true;
  
  ngOnInit(): void {
  }

  displayCottagesBussy(){

    this.displayChart = true;
    this.displayChartPie= false;

    this.title = "Zauzetost brodova";
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


    this.title = "Prihodi od brodova";
    this.dataForChar = [
      { name: "Vikendica Kosmaj", value: 8900 },
      { name: "Vila Raj", value: 505 },
      { name: "Selo Tur", value: 1050 },
      { name: "Vrhpolje", value: 5090 },
      { name: "Rocevic", value: 8200 }
    ];
    this.reservationService.getProfitChartDataForReservations(this.ownerId,'B').subscribe(
      data =>{
        this.dataForChar = data;
      }
    );
  }

  displayCottagesGrades(){

    this.displayChart = true;
    this.displayChartPie= false;


    this.title = "Prosecne ocene ";
    this.dataForChar = [
      { name: "Vikendica Kosmaj", value: 5.0 },
      { name: "Vila Raj", value: 3.5 },
      { name: "Selo Tur", value: 4.0 },
      { name: "Vrhpolje", value: 2.0 },
      { name: "Rocevic", value: 4.7 }
    ];
  }

}
