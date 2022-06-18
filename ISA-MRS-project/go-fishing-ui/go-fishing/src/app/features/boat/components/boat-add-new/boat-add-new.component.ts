import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Boat } from 'src/models/boat';
import { BoatService } from '../../services/boat.service';

@Component({
  selector: 'app-boat-add-new',
  templateUrl: './boat-add-new.component.html',
  styleUrls: ['./boat-add-new.component.css']
})
export class BoatAddNewComponent implements OnInit {

  @Input() ownerId:number;
  @Input() boats:Boat[];

  newBoat: Boat = new Boat();
  name :string;
  price:number;
  capacity:number;
  promoDescription : string;
  bedCount:number;

  extraFavorsString:String;

  constructor(private boatService:BoatService,private router: Router) { }

  ngOnInit(): void {
    this.ownerId = history.state.ownerId;
  }

  addNewBoat() {
    this.newBoat.name = this.name;
    this.newBoat.price = this.price;
    this.newBoat.capacity = this.capacity;
    this.newBoat.description = this.promoDescription;
    this.newBoat.ownerId = this.ownerId;

    this.newBoat.extraFavors = this.extraFavorsString.split(/\r?\n/).join("|");
    
    this.boatService.addNewBoat(this.newBoat).subscribe(data =>{
      console.log(data);
    });
    //this.boats.push(this.newBoat);
    this.router.navigate(["/boatOwner/"+this.ownerId]);

  }
}
