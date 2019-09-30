package com.twuc.bagSaving;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SaveBagTest {
    @Test
    void should_get_a_ticket_when_saving_a_bag() {
        Cabinet cabinet = new Cabinet();
        Ticket ticket = cabinet.save(new Bag());

        assertNotNull(ticket);
    }
}
