import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { LoyaltyService } from 'src/app/shared/services/loyalty-service/loyalty.service';
import { AddLoyaltyComponent } from './add-loyalty/add-loyalty.component';
import { EditLoyaltyComponent } from './edit-loyalty/edit-loyalty.component';

@Component({
  selector: 'app-admin-loyalty-program',
  templateUrl: './admin-loyalty-program.component.html',
  styleUrls: ['./admin-loyalty-program.component.css']
})
export class AdminLoyaltyProgramComponent implements OnInit {

  adminId: number;
  loyalties: any;
  constructor(private route: ActivatedRoute,
              private loyaltyService: LoyaltyService,
              private dialog: MatDialog,) { }

  ngOnInit(): void {
    this.adminId = Number(this.route.snapshot.paramMap.get('id'));
    this.loyaltyService.getLoyalties().subscribe((res) => {
      this.loyalties = res;
    });
  }

  editLoyaltyDialog(id: number, rankName: string, minPoints: number, maxPoints: number, discountRate: number, pointsPerReservation: number) {
    this.dialog.open(EditLoyaltyComponent, {
      data: {id: id, rankName: rankName, minPoints: minPoints, maxPoints: maxPoints, discountRate: discountRate, pointsPerReservation: pointsPerReservation}
    });
  }

  addLoyaltyDialog() {
    this.dialog.open(AddLoyaltyComponent);
  }

}
