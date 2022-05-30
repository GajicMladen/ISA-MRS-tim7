import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cottage } from 'src/models/cottage';
import { CottageService } from '../../services/cottage.service';

@Component({
  selector: 'app-cottage-profilepage',
  templateUrl: './cottage-profilepage.component.html',
  styleUrls: ['./cottage-profilepage.component.css']
})
export class CottageProfilepageComponent implements OnInit {
  
  cottageId : number;
  cottage : Cottage;

  constructor(private route : ActivatedRoute,private cottageService:CottageService ) { }

  ngOnInit(): void {
    this.cottageId = Number(this.route.snapshot.paramMap.get('id'));
    console.log(this.cottageId);

    if(!isNaN(this.cottageId)){
      this.cottageService.findCottageById(this.cottageId).subscribe(cottage =>{
          this.cottage = cottage;
          console.log(this.cottage);
      })
    }

  }
}
