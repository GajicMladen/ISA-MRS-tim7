import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActionService } from 'src/app/shared/services/action-service/action.service';
import { ClientService } from 'src/app/shared/services/client-service/client.service';
import { Cottage } from 'src/models/cottage';
import { ActionDTO } from 'src/models/reservation';
import { CottageService } from '../../services/cottage.service';

@Component({
  selector: 'app-cottage-profilepage',
  templateUrl: './cottage-profilepage.component.html',
  styleUrls: ['./cottage-profilepage.component.css']
})
export class CottageProfilepageComponent implements OnInit {
  
  cottageId : number;
  cottage : Cottage;

  actions : ActionDTO[];

  isSuscribed:boolean;

  constructor(private route : ActivatedRoute,private cottageService:CottageService,
    private actionService: ActionService,private clientService:ClientService ) { }

  ngOnInit(): void {
    this.cottageId = Number(this.route.snapshot.paramMap.get('id'));
    console.log(this.cottageId);

    if(!isNaN(this.cottageId)){
      this.cottageService.findCottageById(this.cottageId).subscribe(cottage =>{
          this.cottage = cottage;
          console.log(this.cottage);
      })
    }

    this.actionService.getActionsForOffer(this.cottageId).subscribe(actions =>{
      this.actions = actions;
    })

    this.getIsSuscribed();
  }

  getIsSuscribed(){

    this.clientService.isSuscribedToOffer(this.cottageId).subscribe(
      data=>{
        console.log(data);
        this.isSuscribed = data;
      }
    )
  }

  addSubscription(){
    this.clientService.addSubscription(this.cottageId).subscribe(
      data=>{
        this.getIsSuscribed()
      }
    );
  }
  removeSubscription(){
    this.clientService.removeSubscription(this.cottageId).subscribe(
      data=>{
        this.getIsSuscribed();
      }
    );
  }
}
