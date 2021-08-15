package com.codegym;

import java.time.LocalDate;

public class CrispyFlour extends Material {

    private int quantity;

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * super.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusYears(1);
    }
}
