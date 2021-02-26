package com.coolparty.restaurant.service.impl;

import com.coolparty.restaurant.model.pojo.Reservation;
import com.coolparty.restaurant.model.pojo.Table;
import com.coolparty.restaurant.repository.ReservationDao;
import com.coolparty.restaurant.repository.RestaurantDao;
import com.coolparty.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public Reservation find(Object id) {
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    @Override
    public Reservation create(Reservation reservation) {
        return reservationDao.create(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public Reservation createByTableCapacity(Reservation reservation, int restaurantId, int capacity) {
        List<Table> matchedTables = restaurantDao.getAvailableTables(reservation.getReservedFrom(),reservation.getReservedTo(), restaurantId, capacity);
        if (matchedTables.size() == 0){
            throw new NoSuchElementException();
        } else {
            Table table = matchedTables.get(0);
            for (Table t: matchedTables){
                if (t.getCapacity() < table.getCapacity()){
                    table = t;
                }
            }
            reservation.setTableId(table.getId());
            return create(reservation);
        }
    }
}
