import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ConfigService {
  private _server_address = 'http://localhost:8080';

  private _signup_url = this._server_address + '/reg/signup';
  private _login_url = this._server_address + '/login';

  get loginUrl(): string {
    return this._login_url;
  }

  get registrationUrl(): string {
    return this._signup_url;
  }
}
