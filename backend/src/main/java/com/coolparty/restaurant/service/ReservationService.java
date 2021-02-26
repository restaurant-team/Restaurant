package com.coolparty.restaurant.service;

import com.coolparty.restaurant.model.pojo.Reservation;

public interface ReservationService extends CRUDService<Reservation> {

    Reservation createByTableCapacity(Reservation reservation, int restaurantId, int capacity);

}
