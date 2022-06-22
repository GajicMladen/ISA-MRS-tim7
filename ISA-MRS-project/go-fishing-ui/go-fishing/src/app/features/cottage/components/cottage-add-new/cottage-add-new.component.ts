import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {
  MessageService,
  MessageType,
} from 'src/app/shared/services/message-service/message.service';
import { Cottage } from 'src/models/cottage';
import { CottageService } from '../../services/cottage.service';

@Component({
  selector: 'app-cottage-add-new',
  templateUrl: './cottage-add-new.component.html',
  styleUrls: ['./cottage-add-new.component.css'],
})
export class CottageAddNewComponent implements OnInit {
  @Input() ownerId: number;
  @Input() cottages: Cottage[];

  newCottage: Cottage = new Cottage();
  name: string;
  price: number;
  capacity: number;
  promoDescription: string;
  bedCount: number;

  extraFavorString: string;
  constructor(
    private cottageService: CottageService,
    private router: Router,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('user-role') !== 'ROLE_COTTAGE_OWNER') {
      this.router.navigateByUrl('');
    }
    this.ownerId = history.state.ownerId;
  }

  addNewCottage() {

    if((this.name == undefined || this.name.length == 0) &&
      this.price == 0 &&
      this.capacity == 0 &&
      (this.promoDescription == undefined || this.promoDescription.length == 0) &&
      this.bedCount == 0)
      {
        this.messageService.showMessage("Popunite polja",MessageType.ERROR);
        return;
      }

    this.newCottage.name = this.name;
    this.newCottage.price = this.price;
    this.newCottage.capacity = this.capacity;
    this.newCottage.description = this.promoDescription;
    this.newCottage.bedCount = this.bedCount;
    this.newCottage.ownerId = this.ownerId;
    if(this.extraFavorString != undefined){
    this.newCottage.extraFavors = this.extraFavorString
      .split(/\r?\n/)
      .join('|');
    }
    else{
      this.newCottage.extraFavors = "";
    }

    this.cottageService.addNewCottage(this.newCottage).subscribe((data) => {
      this.messageService.showMessage(
        'Uspešno ste dodali vikendicu',
        MessageType.SUCCESS
      );
    });

    this.router.navigate(['/cottageOwner/' + this.ownerId]);
  }
}
