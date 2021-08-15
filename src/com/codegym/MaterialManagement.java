package com.codegym;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class MaterialManagement extends Material{
    private MaterialManagement[] materials;

    public MaterialManagement(int size) {
        materials = new MaterialManagement[size];
    }

    public MaterialManagement(String id, String name, LocalDate manufacturingDate, int cost, Meat meat) {
        super(id, name, manufacturingDate, cost);
        super.setMeat(meat);
    }

    public MaterialManagement(String id, String name, LocalDate manufacturingDate, int cost, CrispyFlour crispyFlour) {
        super(id, name, manufacturingDate, cost);
        super.setCrispyFlour(crispyFlour);
    }

    @Override
    public double getAmount() {
        return 0;
    }

    @Override
    public LocalDate getExpiryDate() {
        return null;
    }

    public MaterialManagement(MaterialManagement[] materials) {
        this.materials = materials;
    }

    public MaterialManagement[] getMaterials() {
        return materials;
    }

    public CrispyFlour inputCrispyFlour(Scanner scanner) {
        System.out.print("Nhap so luong: ");
        int quantity = scanner.nextInt();
        return new CrispyFlour(quantity);
    }

    public Meat inputMeat(Scanner scanner) {
        System.out.print("Nhap trong luong: ");
        double weight = scanner.nextDouble();
        return new Meat(weight);
    }

    public MaterialManagement inputMaterial(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhap id: ");
        String id = scanner.nextLine();
        System.out.print("Nhap name: ");
        String name = scanner.nextLine();
        LocalDate localDate = LocalDate.now();
        int cost = 0;
        switch (name) {
            case "Meat":
                Meat meat = inputMeat(scanner);
                localDate = LocalDate.of(2021, 8, 14);
                cost = 600;
                return new MaterialManagement(id, name, localDate, cost, meat);
            case "CrispyFlour":
                CrispyFlour crispyFlour = inputCrispyFlour(scanner);
                localDate = LocalDate.of(2021, 4, 15);
                cost = 40;
                return new MaterialManagement(id, name, localDate, cost, crispyFlour);
            default:
                System.out.print("???");
        }
        return null;
    }

    @Override
    public String toString() {
        return "MaterialManagement{" +
                "materials=" + Arrays.toString(materials) +
                '}';
    }

    public void displayMaterial(){
        for (MaterialManagement material : this.materials) {
            System.out.println(material.toString());
        }
    }
}
