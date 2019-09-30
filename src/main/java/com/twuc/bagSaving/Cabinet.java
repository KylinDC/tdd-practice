package com.twuc.bagSaving;

import java.util.HashMap;
import java.util.Map;

public class Cabinet {
    private final int capacity;

    private Map<Ticket, Bag> lockers = new HashMap<>();

    public Cabinet(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException(String.format("Invalid capacity: %d", capacity));
        }

        this.capacity = capacity;
    }

    public Ticket save(Bag bag, LockerSize size) {
        if (size == null) {
            throw new IllegalArgumentException("Please specify locker size");
        }

        if (capacity <= lockers.size()) {
            throw new InsufficientLockersException("Insufficient empty lockers.");
        }

        if (bag == null) {
            throw new IllegalArgumentException("Please at least put something here.");
        }

        Ticket ticket = new Ticket();
        lockers.put(ticket, bag);
        return ticket;
    }

    public Bag getBag(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Please use your ticket.");
        }

        if (!lockers.containsKey(ticket)) {
            throw new IllegalArgumentException("Invalid Ticket.");
        }

        Bag bag = lockers.get(ticket);
        lockers.remove(ticket);

        return bag;
    }
}
