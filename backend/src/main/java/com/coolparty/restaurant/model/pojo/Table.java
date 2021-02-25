package com.coolparty.restaurant.model.pojo;

import lombok.Data;

import java.util.UUID;

@Data
public class Table extends IdentifiableEntity<UUID>{

    private int restaurantId;
    private int tableNumber;
    private int capacity;
    private String notes;

}
