import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ConfigService {
  private _api_url = 'http://localhost:8080/api';
  private _auth_url = 'http://localhost:8080/auth';

  private _signup_url = this._auth_url + '/signup';
  private _login_url = this._auth_url + '/login';

  get login_url(): string {
    return this._login_url;
  }

  get signup_url(): string {
    return this._signup_url;
  }
}
