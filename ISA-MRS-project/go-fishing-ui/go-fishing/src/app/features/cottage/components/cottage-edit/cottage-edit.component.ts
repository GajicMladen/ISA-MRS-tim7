import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService, MessageType } from 'src/app/shared/services/message-service/message.service';
import { Cottage } from 'src/models/cottage';
import { CottageService } from '../../services/cottage.service';

@Component({
  selector: 'app-cottage-edit',
  templateUrl: './cottage-edit.component.html',
  styleUrls: ['./cottage-edit.component.css']
})
export class CottageEditComponent implements OnInit {
  
  cottageId:number;
  currentCottage:Cottage;

  newCottage: Cottage= new Cottage();
  name :string;
  price:number;
  capacity:number;
  promoDescription : string;
  bedCount:number;
  roomCount:number;

  extraFavorString:string;

  constructor(private cottageService:CottageService,
    private route: ActivatedRoute,
    private router:Router,
    private messageService:MessageService) { }

  ngOnInit(): void {
    this.cottageId = Number(this.route.snapshot.paramMap.get('id'));
    this.cottageService.findCottageById(this.cottageId).subscribe(data=>{
      this.currentCottage = data;
      console.log(this.currentCottage);
      this.name = this.currentCottage.name;
      this.price = this.currentCottage.price;
      this.capacity = this.currentCottage.capacity;
      this.promoDescription = this.currentCottage.description;
      this.bedCount = this.currentCottage.bedCount;
      this.roomCount = this.currentCottage.roomCount;
      this.extraFavorString = this.currentCottage.extraFavors.split('|').join('\n');
    })
  }

  editCottage() {

    if(this.name == undefined || this.name.length == 0 ||
      this.price == undefined || this.price == 0 ||
      this.capacity == undefined || this.capacity == 0 ||
      this.promoDescription == undefined || this.promoDescription.length == 0 ||
      this.bedCount == undefined || this.bedCount == 0 ||
      this.roomCount == undefined || this.roomCount == 0 ||
      this.extraFavorString == undefined || this.extraFavorString.length == 0)
      {
        this.messageService.showMessage("Popunite polja",MessageType.ERROR);
        return;
      }
    if(this.price < 10 ){
      this.messageService.showMessage("Minimalna cena je 10!",MessageType.ERROR);
      return;
    }

    this.newCottage.name = this.name;
    this.newCottage.price = this.price;
    this.newCottage.capacity = this.capacity;
    this.newCottage.description = this.promoDescription;
    this.newCottage.bedCount = this.bedCount;
    this.newCottage.id = this.cottageId;
    this.newCottage.roomCount = this.roomCount;
    if (this.extraFavorString != undefined) {
    this.newCottage.extraFavors = this.extraFavorString
    .split(/\r?\n/)
    .join('|') ;
    }
    else{
      this.newCottage.extraFavors = "";
    }

    //console.log(this.newCottage);
    
    this.cottageService.editCottage(this.newCottage).subscribe(response => {
      this.messageService.showMessage("Uspešno ste izmenili vikendicu",MessageType.SUCCESS);
      this.router.navigateByUrl("/cottageProfile/"+this.cottageId);
      },
      err =>{
        this.messageService.showMessage("Niste u mogućnosti da izmenite vikendicu.",MessageType.ERROR);
      },
    );

  }
}
