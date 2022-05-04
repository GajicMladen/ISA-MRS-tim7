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

  constructor(private cottageService:CottageService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.cottageId = Number(this.route.snapshot.paramMap.get('id'));
    this.cottageService.findCottageById(this.cottageId).subscribe(data=>{
      this.currentCottage = data;
    })
  }

  editCottage() {
    this.newCottage.name = this.name;
    this.newCottage.price = this.price;
    this.newCottage.capacity = this.capacity;
    this.newCottage.promoDescription = this.promoDescription;
    this.newCottage.bedCount = this.bedCount;

    console.log(this.newCottage);
    
    this.cottageService.editCottage(this.cottageId,this.newCottage);
  }
}
