package com.twuc.bagSaving;

class CabinetFactory {
    static Cabinet createCabinetWithPlentyOfCapacity() {
        return new Cabinet(Integer.MAX_VALUE);
    }
}
