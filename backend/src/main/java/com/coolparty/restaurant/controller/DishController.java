package com.coolparty.restaurant.controller;

import com.coolparty.restaurant.model.pojo.Dish;
import com.coolparty.restaurant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> get(){
        return new ResponseEntity<>(dishService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Dish> getById(@PathVariable UUID id){
        return new ResponseEntity<>(dishService.find(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dish> create(@RequestBody Dish dish){
        return new ResponseEntity<>(dishService.create(dish), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Dish> update(@RequestBody Dish dish){
        return new ResponseEntity<>(dishService.update(dish), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id){
        dishService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
