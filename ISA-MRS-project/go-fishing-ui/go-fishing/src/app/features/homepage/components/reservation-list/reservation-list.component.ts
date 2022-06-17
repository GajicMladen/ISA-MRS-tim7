import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ReservationService } from 'src/app/shared/services/reservation-service/reservation.service';
import { CancelReservationDialogComponent } from './cancel-reservation-dialog/cancel-reservation-dialog.component';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css'],
})
export class ReservationListComponent implements OnInit {
  reservationList: any[] = [];

  constructor(
    private reservationService: ReservationService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.reservationService.getActiveReservations().subscribe((res: any) => {
      this.reservationList = res;
    });
  }

  get totalItems() {
    return this.reservationList.length;
  }

  public openCancelDialog(item: any) {
    let toDelete = item;
    console.log(toDelete);
    const dialogRef = this.dialog.open(CancelReservationDialogComponent);

    dialogRef.afterClosed().subscribe((res: any) => {
      if (res !== undefined) {
        if (res.delete) this.cancelReservation(toDelete.id);
      }
    });
  }

  public cancelReservation(reservation: any) {
    this.reservationService.cancelReservation(reservation).subscribe(
      (res: any) => {
        this.reservationList.splice(
          this.reservationList.findIndex((item) => item.id === reservation),
          1
        );
      },
      (err: any) => {
        console.log(err);
      }
    );
  }

  getDateString(dateArray: any): String {
    return dateArray[2] + '.' + dateArray[1] + '.' + dateArray[0] + '.';
  }
}
