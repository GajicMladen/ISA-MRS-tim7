import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Loader } from '@googlemaps/js-api-loader';
import { AdventureService } from '../../adventure.service';
import { Adventure } from '../../classes/adventure';

@Component({
  selector: 'app-adventure-edit',
  templateUrl: './adventure-edit.component.html',
  styleUrls: ['./adventure-edit.component.css']
})
export class AdventureEditComponent implements OnInit {

  nameError: boolean = false;
  promoError: boolean = false;
  maxNumError: boolean = false;
  streetError: boolean = false;
  bioError: boolean = false;
  priceError: boolean = false;
  cityError: boolean = false;
  countryError: boolean = false;

  form: FormGroup = this.createRegistrationForm();

  adventureId: number;
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
    deleted: false
  });

  constructor(private route: ActivatedRoute, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.adventureId = Number(this.route.snapshot.paramMap.get('id'));

    if(!isNaN(this.adventureId)){
      this.adventureService.getAdventureById(this.adventureId).subscribe(adventure =>{
        this.adventure = adventure;
        this.adventure.equipment = this.adventure.equipment.split("|").join("\r\n");
        this.adventure.rulesOfConduct = this.adventure.rulesOfConduct.split("|").join("\r\n");
        console.log(adventure);
      })
    }

    let loader = new Loader({
      apiKey: "AIzaSyAPNK7vqFqOCb5Lu1B0j--zFj4ws4czwGQ"
    })

    loader.load().then(() => {
      const map = document.getElementById("map") as HTMLElement;
      const googleMap = new google.maps.Map(map, {
        center: {lat: Number(this.adventure.latitude), lng: Number(this.adventure.longitude)},
        zoom: 14
      });
      const marker = new google.maps.Marker({
        position: {lat: Number(this.adventure.latitude), lng: Number(this.adventure.longitude)},
        map: googleMap,
      });
      // Configure the click listener.
      googleMap.addListener("click", (mapsMouseEvent: { latLng: any; }) => {
        console.log(JSON.stringify(mapsMouseEvent.latLng).slice(2, -1).split(","));
        this.adventure.latitude = JSON.stringify(mapsMouseEvent.latLng).slice(2, -1).split(",")[0].split(":")[1];
        this.adventure.longitude = JSON.stringify(mapsMouseEvent.latLng).slice(2, -1).split(",")[1].split(":")[1];
        marker.setPosition(new google.maps.LatLng(Number(this.adventure.latitude), Number(this.adventure.longitude)));
      });
  });
  }

  createRegistrationForm(): FormGroup {
    return new FormGroup({
      name: new FormControl(''),
      promoDescription: new FormControl(''),
      price: new FormControl(''),
      capacity: new FormControl(''),
      street: new FormControl(''),
      city: new FormControl(''),
      country: new FormControl(''),
      instructorBiography: new FormControl(''),
      equipment: new FormControl(''),
  	  rulesOfConduct: new FormControl(''),
	    rulesOfCancelation: new FormControl(''),
	    moreInfo: new FormControl('')
    });
  }

  editAdventure(){

  }
}
