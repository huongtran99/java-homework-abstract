package com.codegym;

import java.time.LocalDate;

public class CrispyFlour extends Material {

    private int quantity;

    public CrispyFlour() {

    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
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

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "id: " + super.getId() +
                ", name: " + super.getName() +
                ", manufacturingDate: " + super.getManufacturingDate() +
                ", cost: " + super.getCost() +
                ", quantity: " + quantity +
                '}';
    }

    @Override
    public double getRealMoney() {
        boolean checkExpireDay = LocalDate.now().getYear() == getExpiryDate().getYear();
        if (checkExpireDay && getExpiryDate().getDayOfYear() - LocalDate.now().getDayOfYear() >= 60) {
            return getAmount() - (getAmount() * 40 / 100);
        } else if (checkExpireDay && getExpiryDate().getDayOfYear() - LocalDate.now().getDayOfYear() >= 120) {
            return getAmount() - (getAmount() * 20 / 100);
        } else {
            return getAmount() - (getAmount() * 5 / 100);
        }
    }
}
