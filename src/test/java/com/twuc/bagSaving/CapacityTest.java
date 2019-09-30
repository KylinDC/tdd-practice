package com.twuc.bagSaving;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CapacityTest {
    @Test
    void should_save_bag_if_there_is_empty_locker() {
        Cabinet cabinet = new Cabinet(10);
        Ticket ticket = cabinet.save(new Bag());

        assertNotNull(ticket);
    }

    @Test
    void should_throw_if_cabinet_is_full() {
        Cabinet cabinet = new Cabinet(1);
        cabinet.save(new Bag());

        assertThrows(
            InsufficientLockersException.class,
            () -> cabinet.save(new Bag()),
            "Insufficient empty lockers."
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void should_throw_if_capacity_is_less_than_1(int invalidCapacity) {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Cabinet(invalidCapacity)
        );
    }
}
