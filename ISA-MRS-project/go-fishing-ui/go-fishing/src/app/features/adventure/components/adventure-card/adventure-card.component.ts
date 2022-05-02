import { Component, Input, OnInit } from '@angular/core';
import { AnyForUntypedForms } from '@angular/forms';

@Component({
  selector: 'app-adventure-card',
  templateUrl: './adventure-card.component.html',
  styleUrls: ['./adventure-card.component.css']
})
export class AdventureCardComponent implements OnInit {

  adventure: any;
  @Input('instructor')
  instructorName!: string;

  @Input('name')
  name!: string;

  @Input('price')
  price!: string;
 
  isInstructor: boolean = true;
  


  constructor() { }

  ngOnInit(): void {
    this.adventure = {
      instructor: this.instructorName,
      name: this.name,
      price: this.price,
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
      cancellation: "U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.",
    }
  }

}
