import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { Loader } from '@googlemaps/js-api-loader';
import { CottageReservationService } from 'src/app/features/cottage/components/cottage-client-reservation-dialog/cottage-reservation.service';
import { ActionService } from 'src/app/shared/services/action-service/action.service';
import { ClientService } from 'src/app/shared/services/client-service/client.service';
import {
  MessageService,
  MessageType,
} from 'src/app/shared/services/message-service/message.service';
import { AdventureService } from '../../adventure.service';
import { Adventure } from '../../classes/adventure';
import { AdventureClientReservationDialogComponent } from '../adventure-client-reservation-dialog/adventure-client-reservation-dialog.component';

@Component({
  selector: 'app-adventure-profilpage',
  templateUrl: './adventure-profilpage.component.html',
  styleUrls: ['./adventure-profilpage.component.css'],
})
export class AdventureProfilpageComponent implements OnInit {
  adventureId: number;
  instructorId: number;
  instructorName: string;
  adventure = new Adventure({
    id: 0,
    name: '',
    promoDescription: '',
    price: 0,
    capacity: 0,

    equipment: '',
    rulesOfConduct: '',
    rulesOfCancelation: '',
    moreInfo: '',

    street: '',
    city: '',
    country: '',
    latitude: '',
    longitude: '',

    instructorId: 0,
    instructorBiography: '',
    instructorName: '',
    instructorSurname: '',
    deleted: false,
    rating: 0,
  });
  adventure1 = {
    instructor: 'Mika Mikic',
    name: 'Pecanje na Zvorničkom jezeru',
    price: 59.99,
    latitude: 44.374229,
    longitude: 19.105961,
    address: 'Mali Zvornik, Srbija',
    promoDescription:
      'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.',
    instructorBio:
      'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.',
    images: [
      'https://i.imgur.com/JJjNarK.jpeg',
      'https://i.imgur.com/4Kcv4Ha.jpeg',
      'https://i.imgur.com/AM3wZt7.jpeg',
      'https://i.imgur.com/yGw6TI2.jpeg',
    ],
    maxNumOfPeople: 10,
    rulesOfConduct: [
      'Nije dozvoljeno ostavljati smeće na plažama i u reci',
      'Nije dozvoljenu ulaziti u vodu bez dopuštanja instruktora',
      'Nije dozvoljeno pušenje',
    ],
    equipment: [
      'Stapovi za pecanje',
      'Mreže',
      'Svi tipovi mamaca i varalica',
      'Kombinezoni',
    ],
    information:
      'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.',
    cancellation:
      'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.',
  };

  hasFreePeriods: boolean = true;

  constructor(
    private route: ActivatedRoute,
    private adventureService: AdventureService,
    private actionService: ActionService,
    private dialog: MatDialog,
    private reservationService: CottageReservationService,
    private messageService: MessageService,
    private clientService: ClientService
  ) {}

  ngOnInit(): void {
    this.adventureId = Number(this.route.snapshot.paramMap.get('id'));

    if (!isNaN(this.adventureId)) {
      this.adventureService
        .getAdventureById(this.adventureId)
        .subscribe((adventure) => {
          this.adventure = adventure;
          console.log(adventure);
          let loader = new Loader({
            apiKey: 'AIzaSyAPNK7vqFqOCb5Lu1B0j--zFj4ws4czwGQ',
          });
          this.LoadMap(loader);
        });
    }

    this.reservationService
      .getFreePeriodsById(this.adventureId)
      .subscribe((res: any) => {
        this.hasFreePeriods = res.length > 0;
      });
  }

  LoadMap(loader: Loader) {
    loader.load().then(() => {
      const map = document.getElementById('map') as HTMLElement;
      const googleMap = new google.maps.Map(map, {
        center: {
          lat: Number(this.adventure.latitude),
          lng: Number(this.adventure.longitude),
        },
        zoom: 16,
      });
      const marker = new google.maps.Marker({
        position: {
          lat: Number(this.adventure.latitude),
          lng: Number(this.adventure.longitude),
        },
        map: googleMap,
      });
    });
  }

  onImageClick(i: number): void {
    document
      .getElementById('mainImage')
      ?.setAttribute('src', this.adventure1.images[i]);
  }

  public openReservationDialog() {
    this.reservationService
      .getFreePeriodsById(this.adventureId)
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
          id: this.adventureId,
          name: this.adventure.name,
          startDate: localStorage.getItem('startDate'),
          endDate: localStorage.getItem('endDate'),
          pricePerDay: this.adventure.price,
          rangeFilter: rangeFilter,
          dateRangeArray: dateRangeArray,
        };
        const dialogRef = this.dialog.open(
          AdventureClientReservationDialogComponent,
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
                this.adventureId
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

  get reservationTooltipText() {
    return 'No free periods are available!';
  }
}
