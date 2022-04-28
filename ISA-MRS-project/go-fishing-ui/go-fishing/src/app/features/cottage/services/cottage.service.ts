import { HttpClient } from '@angular/common/http';
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

}
