import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { User } from 'src/app/shared/classes/user';
import { Adventure } from './classes/adventure';
import { Instructor } from './classes/instructor';

@Injectable({
  providedIn: 'root'
})
export class AdventureService {

  private adventureUrl: string;

  constructor(private http: HttpClient) {
    this.adventureUrl = "http://localhost:8080/adventure";
   }

  public deleteAdventure(id: any): Observable<Adventure>{
    console.log(id);
    return this.http.delete<Adventure>(this.adventureUrl + "/" + id);
  }

  public addAdventure(adventure: Adventure) {
    return this.http.post<Adventure>(this.adventureUrl, adventure);
  }

  public updateInstructorData(instructor: User) {
    return this.http.put<User>(this.adventureUrl + "/instructor", instructor);
  }

  public getAdventureById(adventureId: number): Observable<Adventure>{
    return this.http.get<Adventure>(this.adventureUrl + "/get/" + adventureId);
  }

  public getAdventuresOfInstructor(instructorId: number): Observable<Adventure[]>{
    return this.http.get<Adventure[]>(this.adventureUrl + "/instructor/adventures/" + instructorId);
  }

  public editAdventure(adventure: Adventure) {
    return this.http.put<User>(this.adventureUrl + "/edit", adventure);
  }

  public changePassword(instructorId: number, data: any) {
    return this.http.post(this.adventureUrl + '/instructor/passwordChange/' + instructorId, data, {
      headers: { 'Content-Type': 'application/json' },
    });
  }

  public sendDeletionRequest(instructorId: number, data: FormGroup){
    return this.http.post(this.adventureUrl + '/instructor/delete/' + instructorId, data, {
      headers: {'Content-Type': 'application/json' }
    });
  }

  public getAdventureIds(instructorId: number) {
    return this.http.get(this.adventureUrl + '/instructor/adventuresId/' + instructorId);
  }
}
