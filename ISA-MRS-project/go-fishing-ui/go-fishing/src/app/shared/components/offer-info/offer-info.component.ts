import { Component, Input, OnInit } from '@angular/core';
import { OfferService } from '../../services/offer-service/offer.service';
import { Offer } from 'src/models/offer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-offer-info',
  templateUrl: './offer-info.component.html',
  styleUrls: ['./offer-info.component.css']
})
export class OfferInfoComponent implements OnInit {

  @Input() offerId: number;
  offer: Offer;
  offerType: string;

  constructor(private offerService:OfferService,private router:Router) { }

  ngOnInit(): void {
    
    this.offerService.getOfferById(this.offerId).subscribe(data =>{
      this.offer = <Offer>data;
      console.log(data);
      this.offerType = this.getOfferType(data);
    });
  }

  getOfferType(offer:Object):string{
    console.log(offer.hasOwnProperty("ownerId"));
    if(offer.hasOwnProperty("ownerId")) 
      return "C";
    if(offer.hasOwnProperty("maxSpeed"))
      return "B";
    if(offer.hasOwnProperty("biography"))
      return "I";
    
    return "N";
  }

  openProfile(){
    switch(this.offerType){
      case "C":
        this.router.navigate(["cottageProfile/"+this.offerId])
        break;
      case "B":
        this.router.navigate(["boatProfile/"+this.offerId])
        break;
      case "I":
        this.router.navigate(["instructorProfile/"+this.offerId])
        break;
    }
  }
}
