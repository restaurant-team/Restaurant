package com.coolparty.restaurant.model;

import lombok.Data;

@Data
public abstract class IdentifiableEntity<T> {

    private T id;

}
