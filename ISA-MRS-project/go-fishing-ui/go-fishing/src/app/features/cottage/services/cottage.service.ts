import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cottage } from '../classes/cottage';

@Injectable()
export class CottageService {

  private cottagesUrl: string;

  constructor(private http: HttpClient) {
    this.cottagesUrl  = "http://localhost:8080/api/cottages";
  }

  public findAll():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.cottagesUrl+"/all");
  }

  public findCottageById(cottageId:number):Observable<Cottage>{
    return this.http.get<Cottage>(this.cottagesUrl+"/getCottage/"+cottageId);
  }

  public findCottagesByOwner(ownerId:number):Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.cottagesUrl+"/owner/"+ownerId);
  }

  public deleteCottage(cottageId:number){
    return this.http.delete<Boolean>(this.cottagesUrl+"/deleteCottage/"+cottageId);
  }

  public addNewCottage(cottage:Cottage):Observable<string>{
    console.log(JSON.stringify(cottage));
    return this.http.post(this.cottagesUrl+"/newCottage",JSON.stringify(cottage),{headers : new HttpHeaders({ 'Content-Type': 'application/json' }),responseType:'text'});
  }

  public editCottage(cottageId:number,cottage:Cottage){
    this.http.put(this.cottagesUrl+"/updateCottage/"+cottageId , JSON.stringify(cottage));
  }
}
