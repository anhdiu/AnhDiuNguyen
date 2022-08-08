package Main;

import Logic.MonHocService;
import Logic.QuanLySinhVien;
import Logic.SinhVienService;
import MonHoc.MonHoc;
import MonHoc.BangDiem;
import SinhVien.SinhVien;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static SinhVien [] SINHVIEN = new SinhVien[100];
    public static MonHoc [] MONHOC = new MonHoc[100];
    public static BangDiem [] BANGDIEM = new BangDiem[100];

    public static void main(String[] args) {

        try {

            File file = new File("C:\\Users\\user\\Dropbox\\My PC (DESKTOP-FHD07IB)\\Desktop\\eclipse-workspace\\kaiasia\\Buoi17_27_7_2022\\BTVN_Group3\\file.doc");
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (BangDiem bangDiem: BANGDIEM) {
                oos.writeObject(bangDiem);
            }
            oos.flush();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        menu();

    }
    public static void menu(){
        boolean isExit = false;
        do {
            int functionChoice = functionChoice();
            switch (functionChoice){
                case 1:
                    SinhVienService.them1SinhVien();
                    break;
                case 2:
                    SinhVienService.hienThiSinhVien();
                    break;
                case 3:
                    MonHocService.themMonHoc();
                    break;
                case 4:
                    MonHocService.hienThiMonHoc();
                    break;
                case 5:
                    QuanLySinhVien.nhapDiem();
                    break;
                case 6:
                    QuanLySinhVien.hienThiBangDiem();
                    break;
                case 7:
                    QuanLySinhVien.sapXepBangDiem();
                    break;
                case 8:
                   QuanLySinhVien.diemTrungBinh();
                    break;
                case 9:
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
        System.out.println("\n\n\n----- phan mem quan ly sinh vien -----");
        System.out.println("1. nhap danh sach sinh vien moi");
        System.out.println("2. in ra danh sach sinh vien ");
        System.out.println("3. nhap danh sach mon hoc moi");
        System.out.println("4. in ra danh sach mon hoc moi");
        System.out.println("5. nhap diem cho sinh vien ");
        System.out.println("6. in danh sach ra man hinh ");
        System.out.println("7. sap xep bang diem ");

        System.out.println("8. tinh diem tong ket cho moi sinh vien ");



    }

}
