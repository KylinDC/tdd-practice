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
        Ticket ticket = cabinet.save(new Bag(BagSize.BIG), LockerSize.BIG);

        assertNotNull(ticket);
    }

    @Test
    void should_throw_if_cabinet_is_full() {
        Cabinet cabinet = new Cabinet(1);
        cabinet.save(new Bag(BagSize.BIG), LockerSize.BIG);

        assertThrows(
            InsufficientLockersException.class,
            () -> cabinet.save(new Bag(BagSize.BIG), LockerSize.BIG),
            "Insufficient empty lockers."
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void should_throw_when_capacity_is_less_1(int capacity) {
        assertThrows(IllegalArgumentException.class, () ->
            new Cabinet(capacity));
    }
}
