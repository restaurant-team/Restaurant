package com.coolparty.restaurant.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User extends IdentifiableEntity<UUID> {

    private int roleId;
    private String name;
    private String surname;

}
