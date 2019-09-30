package com.twuc.bagSaving;

public class Ticket {
    private Bag bag;

    Ticket(Bag bag) {
        this.bag = bag;
    }

    Bag getBag() {
        return bag;
    }
}
