import { Component, OnInit } from '@angular/core';
import { Boat } from '../../classes/boat';

@Component({
  selector: 'app-boat-profilepage',
  templateUrl: './boat-profilepage.component.html',
  styleUrls: ['./boat-profilepage.component.css']
})
export class BoatProfilepageComponent implements OnInit {

  constructor() { }

  boat:Boat;
  
  ngOnInit(): void {
  }

}
