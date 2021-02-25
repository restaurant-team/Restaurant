package com.coolparty.restaurant.model.pojo;

import lombok.Data;

@Data
public class Restaurant extends IdentifiableNamedEntity<Integer>{

    private String address;
    private String notes;

}
