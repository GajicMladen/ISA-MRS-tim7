import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Boat } from 'src/models/boat';
import { BoatService } from '../../services/boat.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-boat-gallery-owner',
  templateUrl: './boat-gallery-owner.component.html',
  styleUrls: ['./boat-gallery-owner.component.css']
})
export class BoatGalleryOwnerComponent implements OnInit {

  @Input() ownerId:number;

  boats:Boat[];

  constructor(private boatService:BoatService,private router:Router) { }

  ngOnInit(): void {
    
      this.boatService.findBoatsByOwner(this.ownerId).subscribe(data =>{
        this.boats = data;
      });
    
    
  }

  deleteBoat(BoatId:number)
  {
    if(confirm("Da li ste sigurni da zelite da izbrisete brod "+BoatId+"?")){
      
      this.boatService.deleteBoat(BoatId).subscribe(
        deleted =>{
          if(deleted){
            alert("Izbrisali ste je!"); 
          
            this.boats.splice(this.boats.findIndex(Boat => Boat.id === BoatId),1);
          }
          else
            alert("Nismo uspeli da izbrisemo vikendicu.")
        
        }
      )
    }
  }
  

  addNewBoat(){
    this.router.navigateByUrl("/addNewBoat",{state:{ownerId: this.ownerId,Boats:this.boats}});
  }

  
}
