import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Offer } from '../../classes/offer';

@Injectable({
  providedIn: 'root'
})
export class FreePeriodService {

  private freePeriodsUrl:string;

  constructor(private http: HttpClient) {
    this.freePeriodsUrl = "http://localhost:8080/api/freePeriods";
  }

  public addNewFreePeriod(offer:Offer):Observable<string>{

    return this.http.post(this.freePeriodsUrl+"/addFreePeriod",JSON.stringify(offer),{headers : new HttpHeaders({ 'Content-Type': 'application/json' }),responseType:'text'});
  }
}
