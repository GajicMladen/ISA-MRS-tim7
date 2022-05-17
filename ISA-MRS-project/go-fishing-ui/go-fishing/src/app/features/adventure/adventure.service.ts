import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Adventure } from './classes/adventure';
import { Instructor } from './classes/instructor';

@Injectable({
  providedIn: 'root'
})
export class AdventureService {

  constructor(private http: HttpClient) { }

  public deleteAdventure(id: any): Observable<Adventure>{
    console.log(id);
    return this.http.delete<Adventure>("http://localhost:8080/adventure/" + id);
  }

  public addAdventure(adventure: Adventure) {
    return this.http.post<Adventure>("http://localhost:8080/adventure", adventure);
  }

  public updateInstructorData(instructor: Instructor) {
    return this.http.put<Instructor>("http://localhost:8080/adventure/instructor", instructor);
  }

  public getAdventureById(adventureId: number): Observable<Adventure>{
    return this.http.get<Adventure>("http://localhost:8080/adventure/get/" + adventureId);
  }

  public getAdventuresOfInstructor(instructorId: number): Observable<Adventure[]>{
    return this.http.get<Adventure[]>("http://localhost:8080/adventure/instructor/adventures/" + instructorId);
  }
}
