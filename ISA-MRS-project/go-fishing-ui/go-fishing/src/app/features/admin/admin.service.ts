import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/shared/classes/user';
import { DeletionRequest } from './classes/DeletionRequest';
import { RegistrationRequest } from './classes/RegistrationRequest';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private adminUrl: string;

  constructor(private http: HttpClient) {
    this.adminUrl = "http://localhost:8080/admin"
  }

  public updateAdminData(admin: User) {
    return this.http.put<User>(this.adminUrl + "/update", admin);
  }

  public addAdmin(value: any) {
    return this.http.post(this.adminUrl + "/add", value, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
  }


  public getDeletionRequests(): Observable<DeletionRequest[]> {
    return this.http.get<DeletionRequest[]>(this.adminUrl + "/deletionRequests");    
  }

  public deleteUser(userId: number) {
    return this.http.post(this.adminUrl + "/deleteUser/" + userId, null);
  }

  public refuseDeletion(userId: number, reason: string) {
    return this.http.post(this.adminUrl + "/refuseDeletion/" + userId, reason);
  } 

  public getRegistrationRequests(): Observable<RegistrationRequest[]> {
    return this.http.get<RegistrationRequest[]>(this.adminUrl + "/registrationRequests");
  }

  public refuseRegistration(userId: number, reason: string) {
    return this.http.post(this.adminUrl + "/refuseRegistration/" + userId, reason);
  }

  public registerUser(userId: number) {
    return this.http.post(this.adminUrl + "/registerUser/" + userId, null);
  }

}
