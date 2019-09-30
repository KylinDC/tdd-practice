package com.twuc.bagSaving;

import org.junit.jupiter.api.Test;

import static com.twuc.bagSaving.CabinetFactory.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LockerSizeTest {
    @Test
    void should_throw_if_locker_size_is_not_specified() {
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();
        assertThrows(
            IllegalArgumentException.class,
            () -> cabinet.save(new Bag(BagSize.BIG), null));
    }

    @Test
    void should_get_ticket_when_put_big_bag_to_big_locker(){
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();
        Bag bag = new Bag(BagSize.BIG);
        Ticket ticket = cabinet.save(bag, LockerSize.BIG);

        assertNotNull(ticket);
    }
}
