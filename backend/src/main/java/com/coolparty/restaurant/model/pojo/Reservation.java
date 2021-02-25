package com.coolparty.restaurant.model.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Reservation extends IdentifiableNamedEntity<UUID> {
    private UUID tableId;
    private String email;
    private LocalDateTime reservedFrom;
    private LocalDateTime reservedTo;
}
