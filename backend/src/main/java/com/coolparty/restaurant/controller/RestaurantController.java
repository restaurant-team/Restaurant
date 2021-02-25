package com.coolparty.restaurant.controller;

import com.coolparty.restaurant.model.pojo.Restaurant;
import com.coolparty.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> get(){
        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
    }

}
