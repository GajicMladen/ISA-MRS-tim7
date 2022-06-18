import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConfigService } from '../config.service';

@Injectable({
  providedIn: 'root',
})
export class LoyaltyService {
  constructor(private http: HttpClient, private config: ConfigService) {}

  public getLoyalties() {
    return this.http.get(this.config.allLoyaltiesUrl);
  }

  public getLoyaltyForUser() {
    return this.http.get(this.config.userLoyaltyUrl);
  }
}
