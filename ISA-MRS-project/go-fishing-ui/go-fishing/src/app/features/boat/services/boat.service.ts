import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Boat } from '../classes/boat';

@Injectable({
  providedIn: 'root'
})
export class BoatService {

  constructor() { }

  boat:Boat = new Boat();

  public findBoatById(boatId:number):Boat{
    console.log(this.boat);
    this.boat.name = "Brod Sara";
    this.boat.id = 1;
    this.boat.capacity= 15;
    this.boat.price = 35;
    this.boat.ownerId = 1;
    this.boat.promoDescription="Ova, po meri pravljena jahta, duga 16 metara, može da primi do 16 ljudi (dnevna krstarenja). Dobro je opremljena pa je preporučujemo i za duža krstarenja.    Smeštajni kapaciteti za prenoćište za 4 osobe.Prostrana, sa dve palube, nudi klijentima nezavisnost i mogućnost dužeg boravka na brodu.";

    return this.boat;
  }

}
