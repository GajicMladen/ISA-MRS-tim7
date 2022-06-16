import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { User } from 'src/app/shared/classes/user';
import { ConfigService } from 'src/app/shared/services/config.service';
import { Adventure } from './classes/adventure';
import { Instructor } from './classes/instructor';

@Injectable({
  providedIn: 'root',
})
export class AdventureService {
  private adventureUrl: string;

  constructor(private http: HttpClient, private config: ConfigService) {
    this.adventureUrl = 'http://localhost:8080/adventure';
  }

  public addAdventure(adventure: Adventure) {
    return this.http.post<Adventure>(this.adventureUrl, adventure);
  }

  public deleteAdventure(id: any): Observable<Adventure> {
    console.log(id);
    return this.http.delete<Adventure>(this.adventureUrl + '/' + id);
  }

  public updateInstructorData(instructor: User) {
    return this.http.put<User>(this.adventureUrl + '/instructor', instructor);
  }

  public getAdventureById(adventureId: number): Observable<Adventure> {
    return this.http.get<Adventure>(this.adventureUrl + '/get/' + adventureId);
  }

  public getAdventuresOfInstructor(
    instructorId: number
  ): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(
      this.adventureUrl + '/instructor/adventures/' + instructorId
    );
  }

  public editAdventure(adventure: Adventure) {
    return this.http.put<User>(this.adventureUrl + '/edit', adventure);
  }

  public changePassword(instructorId: number, data: any) {
    return this.http.post(
      this.adventureUrl + '/instructor/passwordChange/' + instructorId,
      data,
      {
        headers: { 'Content-Type': 'application/json' },
      }
    );
  }

  public sendDeletionRequest(instructorId: number, data: FormGroup) {
    return this.http.post(
      this.adventureUrl + '/instructor/delete/' + instructorId,
      data,
      {
        headers: { 'Content-Type': 'application/json' },
      }
    );
  }

  public getAdventureIds(instructorId: number) {
    return this.http.get(
      this.adventureUrl + '/instructor/adventuresId/' + instructorId
    );
  }

  public getAdventuresCount() {
    return this.http.get(this.config.adventuresCountUrl);
  }

  public getAdventuresPage(pageNum: number, perpageNum: number, sort: string) {
    return this.http.get(this.config.adventuresPageUrl, {
      params: { page: pageNum, perPage: perpageNum, sort: sort },
    });
  }

  public getAdventuresPageSearch(
    pageNum: number,
    perPageNum: number,
    sort: string,
    searchParams: any
  ) {
    return this.http.get(this.config.adventuresPageSearchUrl, {
      params: {
        page: pageNum,
        perPage: perPageNum,
        sort: sort,
        // startDate:
        //   searchParams.startDate.getDate() +
        //   '-' +
        //   (searchParams.startDate.getMonth() + 1) +
        //   '-' +
        //   searchParams.startDate.getFullYear(),
        startDate: '1-1-2022',
        endDate: '1-1-2023',
        // searchParams.endDate.getDate() +
        // '-' +
        // (searchParams.endDate.getMonth() + 1) +
        // '-' +
        // searchParams.endDate.getFullYear(),
        name: searchParams.name,
        minRating: searchParams.minRating,
        location: searchParams.location,
        capacity: searchParams.capacity,
        minPrice: searchParams.minPrice,
        maxPrice: searchParams.maxPrice,
      },
    });
  }

  public getAdventuresPageSearchCount(searchParams: any) {
    return this.http.get(this.config.adventuresPageSearchCountUrl, {
      params: {
        // startDate:
        //   searchParams.startDate.getDate() +
        //   '-' +
        //   (searchParams.startDate.getMonth() + 1) +
        //   '-' +
        //   searchParams.startDate.getFullYear(),
        startDate: '1-1-2022',
        endDate: '1-1-2023',
        // searchParams.endDate.getDate() +
        // '-' +
        // (searchParams.endDate.getMonth() + 1) +
        // '-' +
        // searchParams.endDate.getFullYear(),
        name: searchParams.name,
        minRating: searchParams.minRating,
        location: searchParams.location,
        capacity: searchParams.capacity,
        minPrice: searchParams.minPrice,
        maxPrice: searchParams.maxPrice,
      },
    });
  }
}
