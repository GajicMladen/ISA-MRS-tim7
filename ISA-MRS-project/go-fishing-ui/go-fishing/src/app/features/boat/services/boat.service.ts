import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Boat } from 'src/models/boat';

@Injectable({
  providedIn: 'root'
})
export class BoatService {

  private boatsUrl: string;

  constructor(private http: HttpClient) {
    this.boatsUrl  = "http://localhost:8080/api/boats";
  }
  
  public findBoatById(boatId:number):Observable<Boat>{
    return this.http.get<Boat>(this.boatsUrl+"/getBoat/"+boatId);
  }

}
