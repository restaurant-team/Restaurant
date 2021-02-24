package com.coolparty.restaurant.model.pojo;

import lombok.Data;

import java.util.UUID;

@Data
public class User extends IdentifiableNamedEntity<UUID> {

    private int roleId;
    private String surname;
    private String email;
    private String password;

}
