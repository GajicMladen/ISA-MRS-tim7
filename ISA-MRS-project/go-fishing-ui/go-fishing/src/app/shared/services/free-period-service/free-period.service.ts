import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FreePeriodDTO } from '../../classes/freePeriod';

@Injectable({
  providedIn: 'root'
})
export class FreePeriodService {

  private freePeriodsUrl:string;

  constructor(private http: HttpClient) {
    this.freePeriodsUrl = "http://localhost:8080/api/freePeriods";
  }

  public addNewFreePeriod(freePeriod:FreePeriodDTO):Observable<string>{
    
    return this.http.post(this.freePeriodsUrl+"/addFreePeriod",JSON.stringify(freePeriod),{headers : new HttpHeaders({ 'Content-Type': 'application/json' }),responseType:'text'});
  }
}
