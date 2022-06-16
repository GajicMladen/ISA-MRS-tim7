import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BoatService } from 'src/app/features/boat/services/boat.service';
import { CottageService } from 'src/app/features/cottage/services/cottage.service';
import { Offer } from 'src/models/offer';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  constructor(private cottageService: CottageService,private boatService: BoatService) { }

  getCottageById(offerId:number):Observable<Object>{
    
    let offer = this.cottageService.findCottageById(offerId);
    
    return offer;
    
  }

  getBoatById(offerId:number):Observable<Object>{

    let offer = this.boatService.findBoatById(offerId);
    return offer;
  }
}
