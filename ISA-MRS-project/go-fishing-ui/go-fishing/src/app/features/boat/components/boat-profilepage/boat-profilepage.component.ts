import { Component, OnInit } from '@angular/core';
import { Boat } from 'src/models/boat';
import { BoatService } from '../../services/boat.service';
import { ActivatedRoute } from '@angular/router';
import { ActionService } from 'src/app/shared/services/action-service/action.service';
import { ActionDTO } from 'src/models/reservation';

@Component({
  selector: 'app-boat-profilepage',
  templateUrl: './boat-profilepage.component.html',
  styleUrls: ['./boat-profilepage.component.css']
})
export class BoatProfilepageComponent implements OnInit {

  constructor(private route:ActivatedRoute,private boatService:BoatService,private actionService:ActionService) { }
  boatId : number;
  boat:Boat;

  actions :ActionDTO[];
  
  ngOnInit(): void {
    
    this.boatId = Number(this.route.snapshot.paramMap.get('id'));
    this.boatService.findBoatById(this.boatId).subscribe(data => {
      this.boat = data;
    });

    this.actionService.getActionsForOffer(this.boatId).subscribe(data =>{
      this.actions = data;
    })
  }

}
