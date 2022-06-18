import { Component, OnInit } from '@angular/core';
import { Boat } from 'src/models/boat';
import { BoatService } from '../../services/boat.service';
import { ActivatedRoute } from '@angular/router';
import { ActionService } from 'src/app/shared/services/action-service/action.service';
import { ActionDTO } from 'src/models/reservation';
import { UserService } from 'src/app/shared/services/users-services/user.service';
import { ClientService } from 'src/app/shared/services/client-service/client.service';
import { ExtraFavorsService } from 'src/app/shared/services/extra-favors-service/extra-favors.service';

@Component({
  selector: 'app-boat-profilepage',
  templateUrl: './boat-profilepage.component.html',
  styleUrls: ['./boat-profilepage.component.css']
})
export class BoatProfilepageComponent implements OnInit {

  constructor(private route:ActivatedRoute,
    private boatService:BoatService,
    private actionService:ActionService,
    private userService:UserService,
    private clientService:ClientService,
    private extraFavorService:ExtraFavorsService) { }
  boatId : number;
  boat:Boat;

  actions :ActionDTO[];
  
  clientLoggedIn:boolean;
  
  isSuscribed:boolean;

  extraFavors:string[];

  ngOnInit(): void {
    
    this.boatId = Number(this.route.snapshot.paramMap.get('id'));
    this.boatService.findBoatById(this.boatId).subscribe(data => {
      this.boat = data;
    });

    this.actionService.getActionsForOffer(this.boatId).subscribe(data =>{
      this.actions = data;
    });
    
    this.userService.isLoggedUserOnlyClient().subscribe(
      data=>{
        this.clientLoggedIn= data;
      }
    );
    this.extraFavors = this.extraFavorService.getFavorsForBoat(this.boatId);
  }
  getIsSuscribed(){

    this.clientService.isSuscribedToOffer(this.boatId).subscribe(
      data=>{
        console.log(data);
        this.isSuscribed = data;
      }
    )
  }

  addSubscription(){
    this.clientService.addSubscription(this.boatId).subscribe(
      data=>{
        this.getIsSuscribed()
      }
    );
  }
  removeSubscription(){
    this.clientService.removeSubscription(this.boatId).subscribe(
      data=>{
        this.getIsSuscribed();
      }
    );
  }
}
