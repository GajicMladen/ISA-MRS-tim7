import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ConfigService {
  private _api_url = 'http://localhost:8080/api';
  private _reg_url = 'http://localhost:8080/reg';

  private _signup_url = this._reg_url + '/signup';
  private _login_url = this._reg_url + '/login';

  get login_url(): string {
    return this._login_url;
  }

  get registrationUrl(): string {
    return this._signup_url;
  }
}
