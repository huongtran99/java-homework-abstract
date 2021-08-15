package com.codegym;

import java.time.LocalDate;

public class Meat extends Material {

    private double weight;

    public Meat(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return super.getCost() * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusDays(7);
    }
}
