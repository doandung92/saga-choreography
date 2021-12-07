package com.javatechie.saga.commons.event;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public abstract class Event {

    private final UUID eventId = UUID.randomUUID();
    private final Instant eventDate = Instant.now();
}
