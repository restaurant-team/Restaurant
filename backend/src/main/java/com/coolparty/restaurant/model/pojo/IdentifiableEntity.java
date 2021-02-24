package com.coolparty.restaurant.model.pojo;

import lombok.Data;

@Data
public abstract class IdentifiableEntity<T> {

    private T id;

}
