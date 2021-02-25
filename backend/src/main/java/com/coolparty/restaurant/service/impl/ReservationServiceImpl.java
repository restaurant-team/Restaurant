package com.coolparty.restaurant.service.impl;

import com.coolparty.restaurant.model.pojo.Reservation;
import com.coolparty.restaurant.repository.ReservationDao;
import com.coolparty.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public Reservation find(Object id) {
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return null;
    }

    @Override
    public Reservation create(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public Reservation createByTableCapacity(Reservation reservation, int capacity, int restaurantId) {
        return null;
    }

    // SELECT * from tables
    // inner join reservations on tables.id = reservations.id_table
    // where id_restaurant = restaurantId
    // and
}
