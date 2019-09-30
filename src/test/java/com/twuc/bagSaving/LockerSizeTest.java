package com.twuc.bagSaving;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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

    @ParameterizedTest
    @EnumSource(value = BagSize.class,names = {"BIG", "MEDIUM", "SMALL", "MINI"},mode = EnumSource.Mode.INCLUDE)
    void should_get_ticket_when_put_big_bag_to_big_locker(BagSize size){
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();
        Bag bag = new Bag(size);
        Ticket ticket = cabinet.save(bag, LockerSize.BIG);

        assertNotNull(ticket);
    }
}
