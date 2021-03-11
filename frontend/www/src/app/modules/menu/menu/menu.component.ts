import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';
import {Dish} from '../../core/_model/Dish';
import {MenuService} from '../../core/_services/menu.service';
import {ToastsService} from '../../core/_services/utils/toasts.service';
import {faSpinner} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit, OnDestroy {

  faSpinner = faSpinner;
  subscriptions: Subscription = new Subscription();
  isLoading: boolean;
  isEmpty: boolean;
  dishesList: Dish[];

  constructor(private menuService: MenuService,
              private toastsService: ToastsService) {
    this.dishesList = [];
    this.isLoading = true;
    this.isEmpty = false;
  }

  ngOnInit(): void {
    this.getDishes();
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  getDishes(): void {
    this.subscriptions.add(this.menuService.getDishesList().subscribe(
      v => {
        if (v === undefined) {
          this.toastsService.toastAddDanger('Something went wrong while fetching dishes list');
        }
        this.dishesList = v;
        if (v.length === 0) {
          this.isEmpty = true;
        }
        this.isLoading = false;
        }, () =>
        this.toastsService.toastAddDanger('Something went wrong while fetching reservations list'))
    );
  }

}
