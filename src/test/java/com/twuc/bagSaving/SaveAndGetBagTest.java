package com.twuc.bagSaving;

import org.junit.jupiter.api.Test;

import static com.twuc.bagSaving.CabinetFactory.createCabinetWithPlentyOfCapacity;
import static org.junit.jupiter.api.Assertions.*;

class SaveAndGetBagTest {
    @Test
    void should_get_a_ticket_when_saving_a_bag() {
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();
        Ticket ticket = cabinet.save(new Bag(BagSize.BIG), LockerSize.BIG);

        assertNotNull(ticket);
    }

    @Test
    void should_notify_when_put_nothing() {
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();
        assertThrows(IllegalArgumentException.class, () ->
            cabinet.save(null, LockerSize.BIG), "Please at least put something here.");
    }

    @Test
    void should_get_corresponded_bag_given_ticket() {
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();
        Bag bag = new Bag(BagSize.BIG);
        Ticket ticket = cabinet.save(bag, LockerSize.BIG);

        Bag sameBag = cabinet.getBag(ticket);

        assertNotNull(sameBag);
        assertSame(bag, sameBag);
    }

    @Test
    void should_throw_if_no_ticket_is_provided() {
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();

        assertThrows(
            IllegalArgumentException.class,
            () -> cabinet.getBag(null),
            "Please use your ticket");
    }

    @Test
    void should_throw_if_ticket_is_not_valid() {
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();
        Cabinet anotherCabinet = createCabinetWithPlentyOfCapacity();

        Ticket ticket = cabinet.save(new Bag(BagSize.BIG), LockerSize.BIG);

        assertThrows(IllegalArgumentException.class, () ->
            anotherCabinet.getBag(ticket), "Invalid ticket.");
    }

    @Test
    void should_throw_if_ticket_is_not_valid_2() {
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();
        Ticket ticket = new Ticket();

        assertThrows(IllegalArgumentException.class, () -> cabinet.getBag(ticket), "Invalid ticket.");
    }

    @Test
    void should_throw_if_ticket_is_used() {
        Cabinet cabinet = createCabinetWithPlentyOfCapacity();
        Bag bag = new Bag(BagSize.BIG);
        Ticket ticket = cabinet.save(bag, LockerSize.BIG);
        cabinet.getBag(ticket);

        assertThrows(IllegalArgumentException.class, () ->
            cabinet.getBag(ticket), "Invalid ticket.");
    }
}
