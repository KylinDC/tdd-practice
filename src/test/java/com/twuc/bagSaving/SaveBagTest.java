package com.twuc.bagSaving;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaveBagTest {
    @Test
    void should_get_a_ticket_when_saving_a_bag() {
        Cabinet cabinet = new Cabinet();
        Ticket ticket = cabinet.save(new Bag());

        assertNotNull(ticket);
    }

    @Test
    void should_notify_when_put_nothing() {
        Cabinet cabinet = new Cabinet();
        assertThrows(IllegalArgumentException.class, () ->
            cabinet.save(null), "Please at least put something here.");
    }

    @Test
    void should_get_corresponded_bag_given_ticket() {
        Cabinet cabinet = new Cabinet();
        Bag bag = new Bag();
        Ticket ticket = cabinet.save(bag);

        Bag sameBag = cabinet.getBag(ticket);

        assertNotNull(sameBag);
        assertSame(bag, sameBag);
    }
}
