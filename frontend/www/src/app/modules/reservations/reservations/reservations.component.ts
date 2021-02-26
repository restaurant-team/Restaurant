import {Component, OnDestroy, OnInit} from '@angular/core';
import {RestaurantsService} from '../../core/_services/restaurants.service';
import {Restaurant} from '../../core/_model/Restaurant';
import {faSpinner} from '@fortawesome/free-solid-svg-icons';
import {Subscription} from 'rxjs';
import {ToastsService} from '../../core/_services/utils/toasts.service';
import {ReservationsService} from '../../core/_services/reservations.service';
import {Reservation} from '../../core/_model/Reservation';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit, OnDestroy {

  subscriptions: Subscription = new Subscription();

  faSpinner = faSpinner;

  restaurantsList: Restaurant[];
  isLoading: boolean;
  isEmpty: boolean;

  chosenRestaurant: Restaurant;
  reservation: Reservation;
  numberOfSeats: number;

  constructor(private restaurantsService: RestaurantsService,
              private reservationsService: ReservationsService,
              private toastsService: ToastsService) {
    this.restaurantsList = [];
    this.isLoading = true;
    this.isEmpty = false;
    this.chosenRestaurant = null;
    this.reservation = new Reservation(null, null, null, null, null, null);
  }

  ngOnInit(): void {
    this.getRestaurantList();
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  getRestaurantList(): void {
    this.subscriptions.add(this.restaurantsService.getRestaurantList().subscribe(
        v => {
          this.restaurantsList = v;
          if (v.length === 0) {
            this.isEmpty = true;
          }
          console.log(this.restaurantsList);
          this.isLoading = false;
        }, () =>
        this.toastsService.toastAddDanger('Something went wrong while fetching restaurant list'))
    );
  }

  makeReservation(): void {
    console.log(this.chosenRestaurant);
    console.log(this.numberOfSeats);
    console.log(this.reservation);
    if (this.chosenRestaurant == null || this.isReservationNotFilled()) {
      this.toastsService.toastAddDanger('Please, choose a restaurant or fill all the fields');
    } else {
      this.subscriptions.add(
      this.reservationsService.makeReservation(this.reservation, this.numberOfSeats, this.chosenRestaurant.id)
          .subscribe(
        v => {
          if (v === undefined) {
            this.toastsService.toastAddDanger('There aren\'t any suitable tables for your reservation.\nTry another date or restaurant');
          } else {
            console.log('Successful reservation!');
            console.log(v);
            this.toastsService.toastAddSuccess('Your reservation is successful!');
            this.toastsService.toastAddSuccess('Your reservation:\nName ' + v.name + ', email: ' + v.email
              + '\nFrom: ' + v.reservedFrom + '\nTo: ' + v.reservedTo);
          }

        }, (err) => {
              this.toastsService.toastAddDanger('Error. Something went wrong while making your reservation');
              console.log(err);
            }
      ));
    }
  }

  private isReservationNotFilled(): boolean {
    if (this.reservation.name == null || this.reservation.name === ''
      || this.reservation.reservedTo == null || this.reservation.email == null
      || this.reservation.email === ''
      || this.reservation.reservedFrom == null) {
      console.log('Found that reservation is not filled: ' + String(this.reservation));
      return true;
    }
    return false;
  }

  setRestaurant(restaurantId: string): void{
    this.chosenRestaurant = this.restaurantsList.find(x => x.id === restaurantId);
  }

}
