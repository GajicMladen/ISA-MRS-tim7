import { Component, Input, OnInit } from '@angular/core';
import { Cottage } from '../../classes/cottage';
import { CottageService } from '../../services/cottage.service';

@Component({
  selector: 'app-cottage-gallery-owner',
  templateUrl: './cottage-gallery-owner.component.html',
  styleUrls: ['./cottage-gallery-owner.component.css']
})
export class CottageGalleryOwnerComponent implements OnInit {

  @Input() ownerId:number;

  cottages:Cottage[];

  constructor(private cottageService:CottageService) { }

  ngOnInit(): void {
    
      this.cottageService.findCottagesByOwner(this.ownerId).subscribe(data =>{
        this.cottages = data;
      });
    
    
  }
  
}
