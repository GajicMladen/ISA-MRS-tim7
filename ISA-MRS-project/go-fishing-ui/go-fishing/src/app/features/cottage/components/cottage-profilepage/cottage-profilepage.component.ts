import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActionService } from 'src/app/shared/services/action-service/action.service';
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

  constructor(private route : ActivatedRoute,private cottageService:CottageService,
    private actionService: ActionService ) { }

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
  }
}
