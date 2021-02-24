package com.coolparty.restaurant.model.pojo;

import lombok.Data;

import java.util.UUID;

@Data
public class Dish extends IdentifiableNamedEntity<UUID> {

    private int dishTypeId;
    private int price;
    private String description;


}
