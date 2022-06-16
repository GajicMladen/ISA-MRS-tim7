import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { ActionService } from 'src/app/shared/services/action-service/action.service';
import {
  MessageService,
  MessageType,
} from 'src/app/shared/services/message-service/message.service';
import { Cottage } from 'src/models/cottage';
import { ActionDTO } from 'src/models/reservation';
import { CottageService } from '../../services/cottage.service';
import { CottageClientReservationDialogComponent } from '../cottage-client-reservation-dialog/cottage-client-reservation-dialog.component';
import { CottageReservationService } from '../cottage-client-reservation-dialog/cottage-reservation.service';

@Component({
  selector: 'app-cottage-profilepage',
  templateUrl: './cottage-profilepage.component.html',
  styleUrls: ['./cottage-profilepage.component.css'],
})
export class CottageProfilepageComponent implements OnInit {
  cottageId: number;
  cottage: Cottage;

  actions: ActionDTO[];

  constructor(
    private route: ActivatedRoute,
    private cottageService: CottageService,
    private actionService: ActionService,
    private dialog: MatDialog,
    private reservationService: CottageReservationService,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.cottageId = Number(this.route.snapshot.paramMap.get('id'));
    if (!isNaN(this.cottageId)) {
      this.cottageService
        .findCottageById(this.cottageId)
        .subscribe((cottage) => {
          this.cottage = cottage;
        });
    }

    this.actionService
      .getActionsForOffer(this.cottageId)
      .subscribe((actions) => {
        this.actions = actions;
      });
  }

  public openReservationDialog() {
    this.reservationService
      .getFreePeriodsById(this.cottage.id)
      .subscribe((res: any) => {
        let dateRangeArray: any = [];
        for (let i of res) dateRangeArray.push(this.convertDateRangeString(i));
        let rangeFilter = function (date: Date) {
          for (let range of dateRangeArray) {
            date.setMilliseconds(0);
            range[0].setMilliseconds(0);
            if (date >= range[0] && date <= range[1]) return true;
          }
          return false;
        };

        let data = {
          id: this.cottage.id,
          name: this.cottage.name,
          startDate: localStorage.getItem('startDate'),
          endDate: localStorage.getItem('endDate'),
          pricePerDay: this.cottage.price,
          rangeFilter: rangeFilter,
          dateRangeArray: dateRangeArray,
        };
        const dialogRef = this.dialog.open(
          CottageClientReservationDialogComponent,
          {
            data: data,
          }
        );

        dialogRef.afterClosed().subscribe((res: any) => {
          if (res !== undefined) {
            localStorage.removeItem('startDate');
            localStorage.removeItem('endDate');
            this.reservationService
              .createReservation(
                res.startDate,
                res.endDate,
                res.totalPrice,
                this.cottage.id
              )
              .subscribe((res: any) => {
                this.messageService.showMessage(
                  res.status,
                  MessageType.SUCCESS
                );
              });
          }
        });
      });
  }

  convertDateRangeString(str: string): any {
    let date1String = str.split(' ')[0];
    let date2String = str.split(' ')[1];

    let date1Tokens = date1String.split('-');
    let date2Tokens = date2String.split('-');

    let date1: Date = new Date();
    let date2: Date = new Date();

    date1.setDate(+date1Tokens[0]);
    date1.setMonth(+date1Tokens[1] - 1);
    date1.setFullYear(+date1Tokens[2]);
    date1.setHours(0);
    date1.setMinutes(0);
    date1.setSeconds(0);

    date2.setDate(+date2Tokens[0]);
    date2.setMonth(+date2Tokens[1] - 1);
    date2.setFullYear(+date2Tokens[2]);
    date2.setHours(0);
    date2.setMinutes(0);
    date2.setSeconds(0);

    return [date1, date2];
  }
}
