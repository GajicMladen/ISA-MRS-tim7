import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CottageService } from 'src/app/features/cottage/services/cottage.service';
import { Offer } from 'src/models/offer';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  constructor(private cottageService: CottageService) { }

  getOfferById(offerId:number):Observable<Object>{
    
    let offer = this.cottageService.findCottageById(offerId);

    return offer;
    
  }
}
