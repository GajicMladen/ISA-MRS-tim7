import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConfigService } from 'src/app/shared/services/config.service';

@Injectable()
export class BoatEntityService {
  constructor(private http: HttpClient, private config: ConfigService) {}

  public getBoatsCount() {
    return this.http.get(this.config.boatsCountUrl);
  }

  public getBoatsPage(pageNum: number, perPageNum: number, sort: string) {
    return this.http.get(this.config.boatsPageUrl, {
      params: { page: pageNum, perPage: perPageNum, sort: sort },
    });
  }
}
