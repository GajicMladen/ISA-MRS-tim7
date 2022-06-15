import { Component, Input, OnInit } from '@angular/core';
import { CottageService } from 'src/app/features/cottage/services/cottage.service';
import { ReservationService } from 'src/app/shared/services/reservation-service/reservation.service';
import { Offer } from 'src/models/offer';
import { ReservationDTO } from 'src/models/reservation';

@Component({
  selector: 'app-reservations-ownerpage',
  templateUrl: './reservations-ownerpage.component.html',
  styleUrls: ['./reservations-ownerpage.component.css']
})
export class ReservationsOwnerpageComponent implements OnInit {

  constructor(private reservationService:ReservationService, private cottageService:CottageService) { }

  @Input() ownerId : number;
  @Input() ownerType : string;
  
  offers: Offer[];
  selectedOffer:Offer;

  reservations: ReservationDTO[];

  ngOnInit(): void {
    this.reservationService.getReservationsForOwner(this.ownerId,this.ownerType).subscribe(
      data=>{
        this.reservations = data;
      }
    );
    if(this.ownerType == "C"){
      this.cottageService.findCottagesByOwner(this.ownerId).subscribe(data =>{
        this.offers = data;
      });
    }
  }

  onChange(offerId:any){
    console.log(offerId);
    if(offerId == "all"){
      this.reservationService.getReservationsForOwner(this.ownerId,this.ownerType).subscribe(
        data => {
          this.reservations = data;
          console.log(data);
          console.log(this.reservations);
        }
      );
    }
    else{
      this.reservationService.getReservationsForOffer(offerId).subscribe(data=>{
        this.reservations = data;
        console.log(this.reservations);
      });
    }
  }
}
