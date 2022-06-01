import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cottage-reports',
  templateUrl: './cottage-reports.component.html',
  styleUrls: ['./cottage-reports.component.css']
})
export class CottageReportsComponent implements OnInit {

  constructor() { }

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

  ngOnInit(): void {
  }

  displayCottagesBussy(){

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
    this.title = "Prihodi od vikendica";
    this.dataForChar = [
      { name: "Vikendica Kosmaj", value: 8900 },
      { name: "Vila Raj", value: 505 },
      { name: "Selo Tur", value: 1050 },
      { name: "Vrhpolje", value: 5090 },
      { name: "Rocevic", value: 8200 }
    ];
  }
}
