package com.twuc.bagSaving;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LockerSizeTest {
    @Test
    void should_throw_if_locker_size_is_not_specified() {
        Cabinet cabinet = new Cabinet(Integer.MAX_VALUE);
        assertThrows(
            IllegalArgumentException.class,
            () -> cabinet.save(new Bag(), null));
    }
}
