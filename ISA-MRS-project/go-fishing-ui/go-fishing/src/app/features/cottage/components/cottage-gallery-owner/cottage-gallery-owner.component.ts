import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cottage } from '../../classes/cottage';
import { CottageService } from '../../services/cottage.service';

@Component({
  selector: 'app-cottage-gallery-owner',
  templateUrl: './cottage-gallery-owner.component.html',
  styleUrls: ['./cottage-gallery-owner.component.css']
})
export class CottageGalleryOwnerComponent implements OnInit {

  @Input() ownerId:number;

  cottages:Cottage[];

  constructor(private cottageService:CottageService,private router:Router) { }

  ngOnInit(): void {
    
      this.cottageService.findCottagesByOwner(this.ownerId).subscribe(data =>{
        this.cottages = data;
      });
    
    
  }

  deleteCottage(cottageId:number)
  {
    if(confirm("Da li ste sigurni da zelite da izbrisete vikendicu "+cottageId+"?")){
      
      this.cottageService.deleteCottage(cottageId).subscribe(
        deleted =>{
          if(deleted){
            alert("Izbrisali ste je!"); 
          
            this.cottages.splice(this.cottages.findIndex(cottage => cottage.id === cottageId),1);
          }
          else
            alert("Nismo uspeli da izbrisemo vikendicu.")
        
        }
      )
    }
  }
  

  addNewCottage(){
    this.router.navigateByUrl("/addNewCottage",{state:{ownerId: this.ownerId,cottages:this.cottages}});
  }

  
}
