import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ConfigService {
  private _server_address = 'http://localhost:8080';

  private _signup_url = this._server_address + '/reg/signup';
  private _login_url = this._server_address + '/login';
  private _user_controller_url = this._server_address + '/api/users';
  private _entity_controller_url = this._server_address + '/api/entity';

  get loginUrl(): string {
    return this._login_url;
  }

  get registrationUrl(): string {
    return this._signup_url;
  }

  get userDataUrl(): string {
    return this._user_controller_url + '/getUserData';
  }

  get dummyUrl(): string {
    return this._user_controller_url + '/dummy';
  }

  get loyaltyPointsUrl(): string {
    return this._user_controller_url + '/loyaltyPoints';
  }

  get updateProfileUrl(): string {
    return this._user_controller_url + '/updateProfile';
  }

  get changePasswordUrl(): string {
    return this._user_controller_url + '/changePassword';
  }

  get deletionRequestUrl(): string {
    return this._user_controller_url + '/deletionRequest';
  }

  /*
   *
   *   ENTITIY CONTROLLER
   *
   */

  /*
   *  COTTAGES
   */

  get cottagesPageUrl(): string {
    return this._entity_controller_url + '/cottages/all';
  }

  get cottagesPageSearchUrl(): string {
    return this._entity_controller_url + '/cottages/search';
  }

  get cottagesCountUrl(): string {
    return this._entity_controller_url + '/cottages/count';
  }

  get cottagesPageSearchCountUrl(): string {
    return this._entity_controller_url + '/cottages/searchcount';
  }

  /*
   *  BOATS
   */

  get boatsPageUrl(): string {
    return this._entity_controller_url + '/boats/all';
  }

  get boatsCountUrl(): string {
    return this._entity_controller_url + '/boats/count';
  }

  get boatsPageSearchUrl(): string {
    return this._entity_controller_url + '/boats/search';
  }

  get boatsPageSearchCountUrl(): string {
    return this._entity_controller_url + '/boats/searchcount';
  }

  /*
   *  ADVENTURES
   */

  get adventuresPageUrl(): string {
    return this._entity_controller_url + '/adventures/all';
  }

  get adventuresCountUrl(): string {
    return this._entity_controller_url + '/adventures/count';
  }

  get adventuresPageSearchUrl(): string {
    return this._entity_controller_url + '/adventures/search';
  }

  get adventuresPageSearchCountUrl(): string {
    return this._entity_controller_url + '/adventures/searchcount';
  }
}
