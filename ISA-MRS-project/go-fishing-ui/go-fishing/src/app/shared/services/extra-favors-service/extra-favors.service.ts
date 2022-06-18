import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExtraFavorsService {
  extraFavorsForCottage:string[] = ["WIFI","Spa","Djakuzi","Bazen","TV","Klima","Baloni","Rostilj","Piće","Šank","Frizider"];
  extraFavorsForBoat:string[] = ["Kuhinja","Volan","Drazaci za stapove","Skakaonica","Paluba","Slauf","Panciri","Pistolj","Piće","Frizider"];
  extraFavorsForAdventure:string[] = ["Stapovi za planinarenje","Naocare","Rukavice","Sigurnosni pojas","Hrana","Piće","Baloni","Rostilj","Piće","Puška"];
  
  extraFavors: Dict = {};

  constructor() { }
  
  public getFavorsForCottage(offerId:number):string[]{
    if(! this.extraFavors.hasOwnProperty(offerId)){
        let ex:string[] = [];
        while(ex.length < 3){
            let w :string = this.extraFavorsForCottage[getRandomInt(this.extraFavorsForCottage.length)];
            if(!ex.includes(w)){
                ex.push(w);
            }
        }
        this.extraFavors[offerId] = ex;   
    }
    return this.extraFavors[offerId];
  }
  public getFavorsForBoat(offerId:number):string[]{
    if(! this.extraFavors.hasOwnProperty(offerId)){
        let ex:string[] = [];
        while(ex.length < 3){
            let w :string = this.extraFavorsForBoat[getRandomInt(this.extraFavorsForCottage.length)];
            if(!ex.includes(w)){
                ex.push(w);
            }
        }
        this.extraFavors[offerId] = ex;   
    }
    return this.extraFavors[offerId];
  }
  public getFavorsForAdventure(offerId:number):string[]{
    if(! this.extraFavors.hasOwnProperty(offerId)){
        let ex:string[] = [];
        while(ex.length < 3){
            let w :string = this.extraFavorsForAdventure[getRandomInt(this.extraFavorsForCottage.length)];
            if(!ex.includes(w)){
                ex.push(w);
            }
        }
        this.extraFavors[offerId] = ex;   
    }
    return this.extraFavors[offerId];
  }

}

function getRandomInt(max:number) {
  return Math.floor(Math.random() * max);
}

interface Dict {
  [idx: number]: string[]
}

