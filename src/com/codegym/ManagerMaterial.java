package com.codegym;

import java.time.LocalDate;
import java.util.Scanner;

public class ManagerMaterial {

    private Material materials[] = new Material[0];

    public ManagerMaterial() {
    }

    public ManagerMaterial(Material[] material) {
        this.materials = material;
    }

    public void addNewMaterial(Material material) {
        Material[] newMaterials = new Material[materials.length + 1];
        for (int i = 0; i < materials.length; i++) {
            newMaterials[i] = materials[i];
        }
        newMaterials[materials.length] = material;
        materials = newMaterials;
    }

    public Material inputMaterial(ManagerMaterial managerMaterials, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Nhap id: ");
        String id = scanner.nextLine();
        System.out.print("Nhap name: ");
        String name = scanner.nextLine();
        LocalDate localDate = LocalDate.now();
        int cost = 0;
        switch (name) {
            case "Meat":
                System.out.print("Nhap trong luong");
                double weight = scanner.nextDouble();
                localDate = LocalDate.of(2021, 8, 12);
                cost = 600;
                return new Meat(id, name, localDate, cost, weight);
            case "CrispyFlour":
                System.out.print("Nhap so luong: ");
                int quantity = scanner.nextInt();
                localDate = LocalDate.of(2021, 4, 15);
                cost = 40;
                return new CrispyFlour(id, name, localDate, cost, quantity);
            default:
                System.out.println("Bạn đã nhập sai tên. Đề nghị nhập lại thông tin");
                inputMaterial(managerMaterials, scanner);
        }

        return null;
    }

    public void displayMaterial() {
        for (Material materials : materials) {
            System.out.println(materials.toString());
        }
    }

    public int findMaterialId(String id) {
        int index = -1;
        for (int i = 0; i < materials.length; i++) {
            if (materials[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void removeMaterial(int index) {
        Material[] newMaterial = new Material[materials.length - 1];
        for (int i = 0; i < newMaterial.length; i++) {
            if (i < index) {
                newMaterial[i] = materials[i];
            } else {
                newMaterial[i] = materials[i + 1];
            }
        }
        materials = newMaterial;
    }

    public void getRealMoneyMaterial() {
        for (Material materials : materials) {
            if (materials instanceof Meat) {
                System.out.println("Meat: " + materials.getRealMoney());
            } else {
                System.out.println("CrispyFlour: " + materials.getRealMoney());
            }

        }
    }

}
