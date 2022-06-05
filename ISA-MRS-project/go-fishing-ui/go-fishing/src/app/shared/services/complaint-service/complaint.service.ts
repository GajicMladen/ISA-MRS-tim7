import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ComplaintDTO } from 'src/models/complaint';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  private complaintsUrl:string;

  constructor(private http: HttpClient) {
    this.complaintsUrl = "http://localhost:8080/api/complaints";
  }

  
  public addNewComplaint(complaint:ComplaintDTO):Observable<string>{
    
    return this.http.post(this.complaintsUrl+"/addNew",JSON.stringify(complaint),{headers : new HttpHeaders({ 'Content-Type': 'application/json' }),responseType:'text'});
  }

}
