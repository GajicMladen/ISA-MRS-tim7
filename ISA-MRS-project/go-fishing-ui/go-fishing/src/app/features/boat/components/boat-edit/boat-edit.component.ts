import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Boat } from 'src/models/boat';
import { BoatService } from '../../services/boat.service';
import { FormsModule } from '@angular/forms';
import { MessageService, MessageType } from 'src/app/shared/services/message-service/message.service';

@Component({
  selector: 'app-boat-edit',
  templateUrl: './boat-edit.component.html',
  styleUrls: ['./boat-edit.component.css']
})
export class BoatEditComponent implements OnInit {
  
  boatId:number;
  currentBoat:Boat;

  newBoat: Boat = new Boat();
  name :string;
  price:number;
  capacity:number;
  promoDescription : string;
  extraFavorString:string;
  
  length: number;
  numOfMotors: number;
  powerOfEngines: number;
  maxSpeed: number;
  reservationCancellationTerms?: string;

  constructor(private boatService:BoatService,
    private route: ActivatedRoute,
    private router:Router,
    private messageService:MessageService) { }

  ngOnInit(): void {
    this.boatId = Number(this.route.snapshot.paramMap.get('id'));
    this.boatService.findBoatById(this.boatId).subscribe(data=>{
      this.currentBoat = data;
      console.log(this.currentBoat);
      this.name = this.currentBoat.name;
      this.price = this.currentBoat.price;
      this.capacity = this.currentBoat.capacity;
      this.promoDescription = this.currentBoat.description;
      this.length = this.currentBoat.length;
      this.numOfMotors = this.currentBoat.numOfMotors;
      this.powerOfEngines = this.currentBoat.powerOfEngines;
      this.maxSpeed = this.currentBoat.maxSpeed;
      this.extraFavorString = this.currentBoat.extraFavors.split('|').join('\n');
    })
  }

  editBoat() {

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
    this.newBoat.id = this.boatId;
    this.newBoat.maxSpeed = this.maxSpeed;
    this.newBoat.numOfMotors = this.numOfMotors;
    this.newBoat.powerOfEngines = this.powerOfEngines;
    this.newBoat.length = this.length;
    if(this.extraFavorString != undefined){
      this.newBoat.extraFavors = this.extraFavorString
      .split(/\r?\n/)
      .join('|');
    }
    else{
      this.newBoat.extraFavors = "";
    }

    
    this.boatService.editBoat(this.newBoat).subscribe(response => {
      this.messageService.showMessage("Uspešno ste izmenili brod.",MessageType.SUCCESS);
      this.router.navigateByUrl("/boatProfile/"+this.boatId);
    },err =>{
      this.messageService.showMessage("Niste u mogucnosti da izmenite brod",MessageType.ERROR);
      
    });

  }
}
