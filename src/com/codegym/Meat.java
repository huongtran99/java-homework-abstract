package com.codegym;

import java.time.LocalDate;

public class Meat extends Material {

    private double weight;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

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

    @Override
    public String toString() {
        return "Meat{" +
                "id: " + super.getId() +
                ", name: " + super.getName() +
                ", manufacturingDate: " + super.getManufacturingDate() +
                ", cost: " + super.getCost() +
                ", weight: " + weight +
                '}';
    }

    @Override
    public double getRealMoney() {
        boolean checkExpireDay = LocalDate.now().getYear() == getExpiryDate().getYear() && LocalDate.now().getMonth() == getExpiryDate().getMonth();
        if (checkExpireDay && getExpiryDate().getDayOfMonth() - LocalDate.now().getDayOfMonth() > 5) {
            return getAmount() - (getAmount() * 10 / 100);
        } else if (checkExpireDay && getExpiryDate().getDayOfMonth() - LocalDate.now().getDayOfMonth() > 3) {
            return getAmount() - (getAmount() * 30 / 100);
        } else {
            return getAmount() - (getAmount() * 50 / 100);
        }
    }
}
