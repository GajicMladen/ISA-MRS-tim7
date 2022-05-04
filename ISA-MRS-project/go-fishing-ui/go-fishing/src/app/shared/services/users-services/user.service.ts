import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../../classes/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private usersUrl : string;

  constructor(private http : HttpClient) {
    this.usersUrl = "http://localhost:8080/api/users"
  }

  public findAll():Observable<User[]>{
    return this.http.get<User[]>(this.usersUrl+"/all");
  }

  public findById(id:number):Observable<User>{
    return this.http.get<User>(this.usersUrl+"/getUser/"+id);
  }
}
