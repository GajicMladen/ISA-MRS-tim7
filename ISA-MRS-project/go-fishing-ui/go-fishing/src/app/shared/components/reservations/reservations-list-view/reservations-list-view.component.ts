import { Component, Input, OnInit } from '@angular/core';
import { ReservationDTO } from 'src/models/reservation';

@Component({
  selector: 'app-reservations-list-view',
  templateUrl: './reservations-list-view.component.html',
  styleUrls: ['./reservations-list-view.component.css']
})
export class ReservationListView implements OnInit {

  @Input() reservations: ReservationDTO[];
  

  constructor() { }

  ngOnInit(): void {

  }

}
