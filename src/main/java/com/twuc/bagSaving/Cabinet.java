package com.twuc.bagSaving;

public class Cabinet {
    public Ticket save(Bag bag) {
        if (bag == null) {
            throw new IllegalArgumentException("Please at least put something here.");
        }
        return new Ticket();
    }
}
