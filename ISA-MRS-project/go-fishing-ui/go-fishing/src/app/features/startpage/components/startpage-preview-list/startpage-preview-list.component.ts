import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Adventure } from 'src/models/adventure';
import { Boat } from 'src/models/boat';
import { Cottage } from 'src/models/cottage';
import { StartpagePreviewListService } from './startpage-preview-list.service';

@Component({
  selector: 'app-startpage-preview-list',
  templateUrl: './startpage-preview-list.component.html',
  styleUrls: ['./startpage-preview-list.component.css'],
})
export class StartpagePreviewListComponent implements OnInit {
  boatList: Array<Boat>;
  cottageList: Array<Cottage>;
  adventureList: Array<Adventure>;

  form: FormGroup = this.createSearchControl();

  constructor(private previewListService: StartpagePreviewListService) {
    this.boatList = this.getBoatPreviewList();
    this.cottageList = this.getCottagePreviewList();
    this.adventureList = this.getAdventurePreviewList();
  }

  ngOnInit(): void {}

  getBoatPreviewList(): Array<Boat> {
    return this.previewListService.getBoatPreviewList();
  }

  getCottagePreviewList(): Array<Cottage> {
    return this.previewListService.getCottagePreviewList();
  }

  getAdventurePreviewList(): Array<Adventure> {
    return this.previewListService.getAdventurePreviewList();
  }

  createSearchControl() {
    return new FormGroup({
      searchBar: new FormControl(''),
    });
  }
}
