package com.twuc.bagSaving;

import java.util.HashMap;
import java.util.Map;

public class Cabinet {
    private Map<Ticket, Bag> lockers = new HashMap<>();

    public Ticket save(Bag bag) {
        if (bag == null) {
            throw new IllegalArgumentException("Please at least put something here.");
        }
        Ticket ticket = new Ticket();
        lockers.put(ticket,bag);
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
