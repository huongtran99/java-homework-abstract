package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong san pham: ");
        int size = scanner.nextInt();
        MaterialManagement materialManagement = new MaterialManagement(size);
        MaterialManagement[] materials = materialManagement.getMaterials();
        for (int i = 0; i < size; i++) {
            materials[i] = materialManagement.inputMaterial(scanner);
        }

        for (MaterialManagement managements: materials) {
            managements.displayMaterial();

        }

    }
}
