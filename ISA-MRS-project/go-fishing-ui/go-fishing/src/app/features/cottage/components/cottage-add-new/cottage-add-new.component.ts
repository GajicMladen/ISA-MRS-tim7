import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cottage } from 'src/models/cottage';
import { CottageService } from '../../services/cottage.service';

@Component({
  selector: 'app-cottage-add-new',
  templateUrl: './cottage-add-new.component.html',
  styleUrls: ['./cottage-add-new.component.css']
})
export class CottageAddNewComponent implements OnInit {

  @Input() ownerId:number;
  @Input() cottages:Cottage[];

  newCottage: Cottage ;
  name :string;
  price:number;
  capacity:number;
  promoDescription : string;
  bedCount:number;

  constructor(private cottageService:CottageService,private router: Router) { }

  ngOnInit(): void {
    this.ownerId = history.state.ownerId;
  }

  addNewCottage() {
    this.newCottage.name = this.name;
    this.newCottage.price = this.price;
    this.newCottage.capacity = this.capacity;
    this.newCottage.description = this.promoDescription;
    this.newCottage.bedCount = this.bedCount;
    this.newCottage.ownerId = this.ownerId;

    console.log(this.newCottage);
    
    this.cottageService.addNewCottage(this.newCottage).subscribe(data =>{
      console.log(data);
    });
    this.cottages.push(this.newCottage);
    this.router.navigate(["/cottageOwner/"+this.ownerId]);

  }
}
