import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurant } from '../_model/Restaurant';
import { catchError } from 'rxjs/operators';
import {HandleErrorsService} from './utils/handle-errors.service';

@Injectable({
  providedIn: 'root'
})
export class RestaurantsService {

  RESTAURANTS_GET_URL = `${environment.apiUrl}restaurant`;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient,
              private handleErrorsService: HandleErrorsService) {
  }

  getRestaurantList(): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>(this.RESTAURANTS_GET_URL, this.httpOptions)
      .pipe(catchError(this.handleErrorsService.handleError<Restaurant[]>('getRestaurantList', [])));
  }
}
