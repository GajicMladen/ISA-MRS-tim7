import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import {
  MessageService,
  MessageType,
} from 'src/app/shared/services/message-service/message.service';
import { ReservationService } from 'src/app/shared/services/reservation-service/reservation.service';
import { CancelReservationDialogComponent } from './cancel-reservation-dialog/cancel-reservation-dialog.component';
import { ReviewReservationDialogComponent } from './review-reservation-dialog/review-reservation-dialog.component';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css'],
})
export class ReservationListComponent implements OnInit {
  reservationList: any[] = [];

  // 'active' or 'past'
  mode: string = '';
  constructor(
    private reservationService: ReservationService,
    private dialog: MatDialog,
    private router: Router,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.setMode();
    if (this.mode === 'active') {
      this.reservationService.getActiveReservations().subscribe((res: any) => {
        this.reservationList = res;
      });
    } else if (this.mode === 'past') {
      this.reservationService.getPastReservations().subscribe((res: any) => {
        this.reservationList = res;
      });
    }
  }

  setMode(): void {
    switch (this.router.url) {
      case '/home/activeReservations':
        this.mode = 'active';
        break;
      case '/home/pastReservations':
        this.mode = 'past';
        break;
      default:
        break;
    }
  }

  get totalItems() {
    return this.reservationList.length;
  }

  public openCancelDialog(item: any) {
    let toDelete = item;
    const dialogRef = this.dialog.open(CancelReservationDialogComponent);

    dialogRef.afterClosed().subscribe((res: any) => {
      if (res !== undefined) {
        if (res.delete) {
          this.cancelReservation(toDelete.id);
          this.messageService.showMessage(
            'Reservation cancelled successfully!',
            MessageType.SUCCESS
          );
        }
      }
    });
  }

  public openReviewDialog(item: any) {
    let data = 'review';
    const dialogRef = this.dialog.open(ReviewReservationDialogComponent, {
      data: data,
    });

    dialogRef.afterClosed().subscribe((res: any) => {
      if (res !== undefined) {
        res.id = item.id;
        this.addReview(res);
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

  public openComplaintDialog(item: any) {
    let data = 'complaint';

    const dialogRef = this.dialog.open(ReviewReservationDialogComponent, {
      data: data,
    });

    dialogRef.afterClosed().subscribe((res: any) => {
      if (res !== undefined) {
        res.id = item.id;
        this.addComplaint(res);
      }
    });
  }

  public addReview(data: any) {
    this.reservationService.addReview(data).subscribe((res: any) => {
      let index = this.reservationList.findIndex((item) => item.id === data.id);
      this.reservationList[index].canCancel = false;
      this.messageService.showMessage(
        'Review sent successfully!',
        MessageType.SUCCESS
      );
    });
  }

  public addComplaint(data: any) {
    this.reservationService.addComplaint(data).subscribe((res: any) => {
      let index = this.reservationList.findIndex((item) => item.id === data.id);
      this.reservationList[index].canComplain = false;
      this.messageService.showMessage(
        'Complaint sent successfully!',
        MessageType.SUCCESS
      );
    });
  }

  getDateString(dateArray: any): String {
    return dateArray[2] + '.' + dateArray[1] + '.' + dateArray[0] + '.';
  }
}
