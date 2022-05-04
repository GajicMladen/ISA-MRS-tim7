import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, throwError } from 'rxjs';
import { ConfigService } from 'src/app/shared/services/config.service';

@Injectable({
  providedIn: 'root',
})
export class StartpageRegisterService {
  constructor(private http: HttpClient, private config: ConfigService) {}

  sendRegistrationRequest(value: any) {
    let register_url = this.config.signup_url;

    return this.http
      .post(register_url, value, {
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
      })
      .pipe(
        map((res) => {
          return res;
        })
      );
  }

  private handleError(err: string) {
    return throwError(() => new Error(err));
  }
}
