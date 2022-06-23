import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {
  MessageService,
  MessageType,
} from 'src/app/shared/services/message-service/message.service';
import { Boat } from 'src/models/boat';
import { BoatService } from '../../services/boat.service';

@Component({
  selector: 'app-boat-add-new',
  templateUrl: './boat-add-new.component.html',
  styleUrls: ['./boat-add-new.component.css'],
})
export class BoatAddNewComponent implements OnInit {
  @Input() ownerId: number;
  @Input() boats: Boat[];

  newBoat: Boat = new Boat();
  name: string;
  price: number;
  capacity: number;
  promoDescription: string;
  bedCount: number;

  boatType: string;
  length: number;
  numOfMotors: number;
  powerOfEngines: number;
  maxSpeed: number;
  reservationCancellationTerms?: string;

  extraFavorString:String;


  constructor(
    private boatService: BoatService,
    private router: Router,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('user-role') !== 'ROLE_BOAT_OWNER') {
      this.router.navigateByUrl('');
    }
    this.ownerId = history.state.ownerId;
  }

  addNewBoat() {


    if(this.name == undefined || this.name.length == 0 ||
      this.price == undefined || this.price == 0 ||
      this.capacity == undefined || this.capacity == 0 ||
      this.promoDescription == undefined || this.promoDescription.length == 0 ||
      this.length == undefined || this.length == 0 ||
      this.maxSpeed == undefined || this.maxSpeed == 0 ||
      this.numOfMotors == undefined || this.numOfMotors == 0 ||
      this.powerOfEngines == undefined || this.powerOfEngines == 0 ||
      this.extraFavorString == undefined || this.extraFavorString.length == 0)
      {
        this.messageService.showMessage("Popunite polja",MessageType.ERROR);
        return;
      }



    
    this.newBoat.name = this.name;
    this.newBoat.price = this.price;
    this.newBoat.capacity = this.capacity;
    this.newBoat.description = this.promoDescription;
    this.newBoat.ownerId = this.ownerId;

    this.newBoat.boatType = this.boatType;
    this.newBoat.length = this.length;
    this.newBoat.numOfMotors = this.numOfMotors;
    this.newBoat.powerOfEngines = this.powerOfEngines;
    this.newBoat.reservationCancellationTerms = this.reservationCancellationTerms;
    if(this.extraFavorString != undefined){
    this.newBoat.extraFavors = this.extraFavorString.split(/\r?\n/).join("|");
    }
    else{
      this.newBoat.extraFavors = "";
    }
    this.newBoat.maxSpeed = this.maxSpeed;

    
    this.boatService.addNewBoat(this.newBoat).subscribe((data) => {
      this.messageService.showMessage(
        'Uspešno ste dodali novi brod.',
        MessageType.SUCCESS
      );
    });

    this.router.navigate(['/boatOwner/' + this.ownerId]);
  }
}
