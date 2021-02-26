import {Component, OnDestroy, OnInit} from '@angular/core';
import {ReservationsService} from '../../core/_services/reservations.service';
import {Observable, Subscription} from 'rxjs';
import {Reservation} from '../../core/_model/Reservation';
import {faSpinner} from '@fortawesome/free-solid-svg-icons';
import {ToastsService} from '../../core/_services/utils/toasts.service';

@Component({
  selector: 'app-reservforpers',
  templateUrl: './reservforpers.component.html',
  styleUrls: ['./reservforpers.component.css']
})
export class ReservforpersComponent implements OnInit, OnDestroy {

  subscriptions: Subscription = new Subscription();
  faSpinner = faSpinner;
  isLoading: boolean;
  isEmpty: boolean;
  reservationsList: Reservation[];
  constructor(private reservationsService: ReservationsService,
              private toastsService: ToastsService) {
    this.reservationsList = [];
    this.isLoading = true;
    this.isEmpty = false;
  }

  ngOnInit(): void {
    this.getReservations();
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  getReservations(): void {
    this.subscriptions.add(this.reservationsService.getReservationsList().subscribe(
      v => {
        if (v === undefined) {
          this.toastsService.toastAddDanger('Something went wrong while fetching reservations list');
        }
        this.reservationsList = v;
        if (v.length === 0) {
          this.isEmpty = true;
        }
        this.isLoading = false;
        console.log('fetched reservations list: ');
        console.log(this.reservationsList);
      }, () =>
        this.toastsService.toastAddDanger('Something went wrong while fetching reservations list'))
    );
  }

}
