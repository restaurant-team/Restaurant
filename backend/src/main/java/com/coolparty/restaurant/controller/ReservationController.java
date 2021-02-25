package com.coolparty.restaurant.controller;

import com.coolparty.restaurant.model.pojo.Reservation;
import com.coolparty.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation,
                                              @RequestParam int capacity,
                                              @RequestParam int restaurantId) {
        return new ResponseEntity(reservationService.createByTableCapacity(reservation, capacity, restaurantId), HttpStatus.CREATED);
    }
}
