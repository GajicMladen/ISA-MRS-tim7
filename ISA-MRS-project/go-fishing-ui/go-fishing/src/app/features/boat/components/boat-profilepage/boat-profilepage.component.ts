import { Component, OnInit } from '@angular/core';
import { Boat } from '../../classes/boat';
import { BoatService } from '../../services/boat.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-boat-profilepage',
  templateUrl: './boat-profilepage.component.html',
  styleUrls: ['./boat-profilepage.component.css']
})
export class BoatProfilepageComponent implements OnInit {

  constructor(private route:ActivatedRoute,private boatService:BoatService) { }
  boatId : number;
  boat:Boat;
  
  ngOnInit(): void {
    
    this.boatId = Number(this.route.snapshot.paramMap.get('id'));
    this.boat = this.boatService.findBoatById(this.boatId);
  }

}
