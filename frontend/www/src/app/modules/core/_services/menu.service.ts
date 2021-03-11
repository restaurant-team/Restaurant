import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../../environments/environment';
import {HandleErrorsService} from './utils/handle-errors.service';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Dish} from '../_model/Dish';

@Injectable({
  providedIn: 'root'
})
export class MenuService {

  MENU_URL = `${environment.apiUrl}dish`;

  constructor(private http: HttpClient,
              private handleErrorsService: HandleErrorsService) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  public getDishesList(): Observable<Dish[]> {
    return this.http.get<Dish[]>(this.MENU_URL, this.httpOptions)
      .pipe(catchError(this.handleErrorsService.handleError<Dish[]>('getDishesList', [])));
  }

}
