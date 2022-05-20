import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Loader } from '@googlemaps/js-api-loader';
import { AdventureService } from '../../adventure.service';
import { Adventure } from '../../classes/adventure';

@Component({
  selector: 'app-adventure-profilpage',
  templateUrl: './adventure-profilpage.component.html',
  styleUrls: ['./adventure-profilpage.component.css']
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
    deleted: false
  });
  adventure1 = {
    instructor: "Mika Mikic",
    name: "Pecanje na Zvorničkom jezeru",
    price: 59.99,
    latitude: 44.374229,
    longitude: 19.105961,
    address: "Mali Zvornik, Srbija",
    promoDescription: "Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.",
    instructorBio: "Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.",
    images: ["https://i.imgur.com/JJjNarK.jpeg", "https://i.imgur.com/4Kcv4Ha.jpeg", "https://i.imgur.com/AM3wZt7.jpeg", "https://i.imgur.com/yGw6TI2.jpeg"],
    maxNumOfPeople: 10,
    rulesOfConduct: ["Nije dozvoljeno ostavljati smeće na plažama i u reci", "Nije dozvoljenu ulaziti u vodu bez dopuštanja instruktora", "Nije dozvoljeno pušenje"],
    equipment: ["Stapovi za pecanje", "Mreže", "Svi tipovi mamaca i varalica", "Kombinezoni"],
    information: "Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.",
    cancellation: "U slučaju otkazivanja instruktor zadržava 30% uplaćene sume."
  }

  constructor(private route: ActivatedRoute, private adventureService: AdventureService) { }

  ngOnInit(): void {
    this.adventureId = Number(this.route.snapshot.paramMap.get('id'));

    if(!isNaN(this.adventureId)){
      this.adventureService.getAdventureById(this.adventureId).subscribe(adventure =>{
        this.adventure = adventure;
        console.log(adventure);
      })
    }

    let loader = new Loader({
      apiKey: "AIzaSyAPNK7vqFqOCb5Lu1B0j--zFj4ws4czwGQ"
    });

    loader.load().then(() => {
      const map = document.getElementById("map") as HTMLElement;
      const googleMap = new google.maps.Map(map, {
        center: {lat: Number(this.adventure.latitude), lng: Number(this.adventure.longitude)},
        zoom: 16
      });
      const marker = new google.maps.Marker({
        position: {lat: Number(this.adventure.latitude), lng: Number(this.adventure.longitude)},
        map: googleMap,
      });
    });
    
  }

  onImageClick(i: number): void {
    document.getElementById("mainImage")?.setAttribute("src", this.adventure1.images[i]);
  }

}
