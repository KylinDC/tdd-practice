package com.twuc.bagSaving;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CapacityTest {
    @Test
    void should_save_bag_if_there_is_empty_locker() {
        Cabinet cabinet = new Cabinet(10);
        Ticket ticket = cabinet.save(new Bag());

        assertNotNull(ticket);
    }
}
