import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/app/shared/classes/user';
import { ConfigService } from 'src/app/shared/services/config.service';

@Injectable({
  providedIn: 'root',
})
export class UserprofileService {
  constructor(private configService: ConfigService, private http: HttpClient) {}

  public getUserData() {
    let res = this.http.get<User>(this.configService.userData, {
      observe: 'response',
    });
    console.log(res);
  }
}
