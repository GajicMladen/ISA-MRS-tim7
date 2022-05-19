import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { catchError, map, Observable, throwError } from 'rxjs';
import { ConfigService } from 'src/app/shared/services/config.service';

@Injectable({
  providedIn: 'root',
})
export class UserprofileService {
  constructor(private configService: ConfigService, private http: HttpClient) {}

  public getUserData() {
    return this.http.get(this.configService.userData);
  }

  updateProfileInfo(data: FormGroup) {
    return this.http
      .post(this.configService.updateProfileUrl, data, {
        headers: { 'Content-Type': 'application/json' },
      })
      .pipe(
        map((res: any) => {
          localStorage.removeItem('user-name');
          localStorage.setItem('user-name', res.name);
          return res;
        }),
        catchError(this.handleError)
      );
  }

  public validateNewUserData(data: any): string {
    if (data.name.length === 0) return 'Invalid name!';
    else if (data.lastName.length === 0) return 'Invalid surname!';
    else if (data.country.length === 0) return 'Invalid country!';
    else if (data.town.length === 0) return 'Invalid city/town!';
    else if (data.address.length === 0) return 'Invalid address!';
    else if (!new RegExp('^[+][0-9]{10,12}$').test(data.phoneNumber))
      return 'Invalid phone number!';
    return 'OK';
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(() => new Error(error.error));
  }
}
