import { Injectable } from '@angular/core';
import {environment} from '../../../../environments/environment';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {HandleErrorsService} from './utils/handle-errors.service';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Reservation} from '../_model/Reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  RESERVATIONS_URL = `${environment.apiUrl}reservation`;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient,
              private handleErrorsService: HandleErrorsService) {
  }

  public getReservationsList(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.RESERVATIONS_URL, this.httpOptions)
      .pipe(catchError(this.handleErrorsService.handleError<Reservation[]>('getReservationsList', [])));
  }

  // tslint:disable-next-line:typedef
  public makeReservation(reservation: Reservation, capacity: number, restaurantId: string) {

    const requestParams: HttpParams = new HttpParams()
      .set('capacity', String(capacity))
      .set('restaurantId', restaurantId);

    console.log('Trying to make reservation of ' + reservation + ', capacity: ' + capacity + ', resetaurantId: ' + restaurantId);
    return this.http.post<Reservation>(this.RESERVATIONS_URL, reservation,
      {
        headers: this.httpOptions.headers,
        params: requestParams
      }).pipe(catchError(this.handleErrorsService.handleError<any>('makeReservation')));

  }

}
