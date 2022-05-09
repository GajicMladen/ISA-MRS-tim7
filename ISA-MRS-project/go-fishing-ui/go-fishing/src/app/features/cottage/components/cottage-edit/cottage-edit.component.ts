import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cottage } from '../../classes/cottage';
import { CottageService } from '../../services/cottage.service';

@Component({
  selector: 'app-cottage-edit',
  templateUrl: './cottage-edit.component.html',
  styleUrls: ['./cottage-edit.component.css']
})
export class CottageEditComponent implements OnInit {
  
  cottageId:number;
  currentCottage:Cottage;

  newCottage: Cottage = new Cottage;
  name :string;
  price:number;
  capacity:number;
  promoDescription : string;
  bedCount:number;
  roomCount:number;

  constructor(private cottageService:CottageService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.cottageId = Number(this.route.snapshot.paramMap.get('id'));
    this.cottageService.findCottageById(this.cottageId).subscribe(data=>{
      this.currentCottage = data;
      console.log(this.currentCottage);
      this.name = this.currentCottage.name;
      this.price = this.currentCottage.price;
      this.capacity = this.currentCottage.capacity;
      this.promoDescription = this.currentCottage.promoDescription;
      this.bedCount = this.currentCottage.bedCount;
      this.roomCount = this.currentCottage.roomCount;
    })
  }

  editCottage() {
    this.newCottage.name = this.name;
    this.newCottage.price = this.price;
    this.newCottage.capacity = this.capacity;
    this.newCottage.promoDescription = this.promoDescription;
    this.newCottage.bedCount = this.bedCount;
    this.newCottage.id = this.cottageId;
    this.newCottage.roomCount = this.roomCount;

    //console.log(this.newCottage);
    
    this.cottageService.editCottage(this.newCottage).subscribe(response => {console.log(response)} );

    window.location.href = "http://localhost:4200/cottageProfile/"+this.cottageId;
  }
}
