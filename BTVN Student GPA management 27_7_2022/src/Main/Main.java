package Main;

import MonHoc.MonHoc;
import MonHoc.BangDiem;
import SinhVien.SinhVien;

import java.util.Scanner;

public class Main {
    public static SinhVien [] SINHVIEN = new SinhVien[100];
    public static MonHoc [] MONHOC = new MonHoc[100];
    public static BangDiem [] BANGDIEM = new BangDiem[100];

    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        boolean isExit = false;
        do {
            int functionChoice = functionChoice();
            switch (functionChoice){
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    System.exit(0);
                    isExit = true;

            }
        }while (!isExit);
    }

    private static int functionChoice(){
        ShowMenu();
        System.out.println("xin moi chon 1 chuc nang : ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if ( choice >= 1 && choice <= 8){
                break;
            }
            System.out.println("lua chon khong hop le, vui long nhap lai :");

        }while (true);
        return choice;
    }
    private static void  ShowMenu(){
        System.out.println("----- phan mem quan ly sinh vien -----");
        System.out.println("1.");



    }

}
