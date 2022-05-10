import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Adventure } from './classes/adventure';

@Injectable({
  providedIn: 'root'
})
export class AdventureService {

  constructor(private http: HttpClient) { }

  deleteAdventure(id: any): Observable<Adventure>{
    console.log(id);
    return this.http.delete<Adventure>("http://localhost:8080/adventure/" + id);
  }

  addAdventure(adventure: Adventure) {
    return this.http.post<Adventure>("http://localhost:8080/adventure", adventure);
  }
}
