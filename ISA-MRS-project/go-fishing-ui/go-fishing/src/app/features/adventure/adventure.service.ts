import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdventureService {

  constructor(private http: HttpClient) { }

  deleteAdventure(id: any): Observable<string>{
    console.log(id);
    return this.http.delete<string>("http://localhost:8080/adventure/" + id);
  }

  addAdventure(adventure: any) {
    return this.http.post<any>("http://localhost:8080/adventure", adventure);
  }
}
