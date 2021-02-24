package com.coolparty.restaurant.model.pojo;

import lombok.Data;

@Data
public abstract class IdentifiableNamedEntity<T> extends IdentifiableEntity<T>  {

    private String name;

}
