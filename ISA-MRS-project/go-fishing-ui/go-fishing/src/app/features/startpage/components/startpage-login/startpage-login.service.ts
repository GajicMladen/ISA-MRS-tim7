import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, map, throwError } from 'rxjs';
import { ConfigService } from 'src/app/shared/services/config.service';

@Injectable({
  providedIn: 'root',
})
export class StartpageLoginService {
  private accessToken = null;
  private currentUser = null;

  constructor(
    private http: HttpClient,
    private config: ConfigService,
    private router: Router
  ) {}

  sendLoginRequest(value: any) {
    let loginUrl = this.config.loginUrl;

    return this.http
      .post(loginUrl, value, {
        headers: { 'Content-Type': 'application/json' },
      })
      .pipe(
        map((res: any) => {
          this.accessToken = res.accessToken;
          localStorage.setItem('jwt', res.accessToken);
        }),
        catchError(this.handleError)
      );
  }
  private handleError(error: HttpErrorResponse) {
    return throwError(() => new Error(error.error));
  }

  logout() {
    this.currentUser = null;
    this.accessToken = null;
    this.router.navigate(['/login']);
  }

  tokenIsPresent() {
    return this.accessToken != undefined && this.accessToken != null;
  }

  public getToken(): string | null {
    return this.accessToken;
  }
}