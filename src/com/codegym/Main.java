package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int select;
        ManagerMaterial managerMaterials = new ManagerMaterial();

        do {
            System.out.println("Menu");
            System.out.println("1.Them san pham");
            System.out.println("2.Hien thi san pham");
            System.out.println("3.Xoa san pham");
            System.out.println("4.Tinh chiet khau");
            System.out.println("0.Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            select = scanner.nextInt();

            switch (select) {
                case 1:
                    managerMaterials.addNewMaterial(managerMaterials.inputMaterial(managerMaterials, scanner));
                    break;
                case 2:
                    managerMaterials.displayMaterial();
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Nhap id can xoa: ");
                    String id = scanner.nextLine();
                    int index = managerMaterials.findMaterialId(id);
                    if (index == -1) {
                        System.out.println("Không tìm thấy");
                    } else {
                        managerMaterials.removeMaterial(index);
                        managerMaterials.displayMaterial();
                    }
                    break;
                case 4:
                    System.out.println("Chiet Khau: ");
                    managerMaterials.getRealMoneyMaterial();
                    break;
                case 0:
                    System.out.print("Bye");
                    break;
                default:
                    System.out.println("Nhap sai roi nhap ai dum");
            }
        } while (select != 0);


    }
}
