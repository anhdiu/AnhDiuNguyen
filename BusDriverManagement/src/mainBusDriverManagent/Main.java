package mainBusDriverManagent;

import busDriverManagement.BusDriverManagement;
import busDriverManagementService.BusDriverManegementService;
import busDriverManagementService.DriverService;
import busDriverManagementService.RouteService;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        menu();


    }



    private static void menu()

    {
        boolean isExit = false;

        do {

            int functionChoice = functionChoice();

            switch (functionChoice) {
                case 1:
                    DriverService.inputNewDriver();
                    break;
                case 2:
                    RouteService.inputNewRoute();
                case 3:
                    BusDriverManegementService.busDriverManegement();
                    break;
                case 4:
                    BusDriverManegementService.sort();
                    break;
                case 5:
                   BusDriverManegementService.statistic();
                case 6:
                    isExit = true;

                    break;
                default:
                    isExit = true;

            }
        } while (!isExit);
    }

    private static int functionChoice() {
        showMenu();
        System.out.println(" xin moi nhap chuc nang : ");

        int choice;

        do {
             choice = new Scanner(System.in).nextInt();

            if (choice >= 1 && choice <= 6) {
                break;
            } else {
                System.out.println(" lua chon khong hop le, vui long chon lai ");
            }
        } while (true);
        return choice;
    }

    private static void showMenu() {
        System.out.println(" \n\n\n ----- PHAN MEM QUAN LY XE BUS -----");
        System.out.println("1. nhap va in thong tin lai xe. ");
        System.out.println("2. nhap va in thong tin tuyen xe. ");
        System.out.println("3. phan cong lai xe ");
        System.out.println("4. sap xep phan cong");
        System.out.println("5. thong ke khoang cach xe chay moi ngay ");
        System.out.println("6. thoat ");
    }
}
