import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Offer } from '../../classes/offer';
import { FreePeriodService } from '../../services/free-period-service/free-period.service';

@Component({
  selector: 'app-new-free-period',
  templateUrl: './new-free-period.component.html',
  styleUrls: ['./new-free-period.component.css']
})
export class NewFreePeriodComponent implements OnInit {

  offerId : number;
  offer: Offer;
  startDate: string;
  constructor(private freePeriodService: FreePeriodService,private route : ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.offerId = Number(this.route.snapshot.paramMap.get('id'));

  }


}
