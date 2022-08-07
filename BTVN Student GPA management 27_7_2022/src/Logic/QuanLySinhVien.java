package Logic;

import Main.Main;
import MonHoc.chiTietBangDiem;
import MonHoc.MonHoc;
import MonHoc.BangDiem;
import SinhVien.SinhVien;

import java.util.Scanner;

public class QuanLySinhVien {
    public static void nhapDiem(){
        if (SinhVienService.kiemTraSinhVien() || MonHocService.kiemTraMonHoc()){
            System.out.println("can them sinh vien va mon hoc truoc khi nhap  diem ");
            return;
        }
        System.out.println("ban muon them bao nhieu sinh vien : ");
        int soLuongSinhVien = new Scanner(System.in).nextInt();
        for (int i = 0; i < soLuongSinhVien; i++) {

            // thuc hien nhap diem cho ban thu n


            // nhap sinh vien muon nhap diem
            SinhVien sinhVien = nhapThongTinSinhVien(i);

            // nhap danh them diem vao mon hoc
            chiTietBangDiem [] chiTietBangDiems = nhapThongTinChiTietBangDiem();
            BangDiem bangDiem = new BangDiem();
            luuBangDiem(bangDiem);

        }
    }
    public static void luuBangDiem(BangDiem bangDiem){
        for (int i = 0; i < Main.BANGDIEM.length;i++){
            if (Main.BANGDIEM[i] == null){
                Main.BANGDIEM[i] = bangDiem;
                break;
            }
        }
    }

    public static chiTietBangDiem[] nhapThongTinChiTietBangDiem(){
        System.out.println("ban muon nhap diem cho bao nhieu mon hoc  : ");
        int soLuong = new Scanner(System.in).nextInt();
        // nhap so luong mon hoc muon them diem
        chiTietBangDiem[] chiTietBangDiems = new chiTietBangDiem[soLuong];
        for (int i = 0; i < soLuong; i++) {
            System.out.println("nhap mon hoc thu " + ( i + 1) + "ma ban muon them ");
            MonHoc monHoc = null;
            do {
                int IDmonhoc = new  Scanner(System.in).nextInt();
                for (int j = 0; j < Main.MONHOC.length; j++) {
                    if (Main.MONHOC[j] != null && Main.MONHOC[j].getMaMonHoc() == IDmonhoc){
                        monHoc = Main.MONHOC[j];
                        System.out.println("ban dat duoc bao nhieu diem cho mon hoc " + IDmonhoc);
                       do {
                           int diemSo = new Scanner(System.in).nextInt();
                           if (diemSo>=0 && diemSo <= 10){
                               break;
                           }
                           System.out.println("nhap lai diem so");
                       }while (true);
                    }

                }

            }
        }

    }

    public static void sapXepBangDiem(){
        System.out.println("xin moi nhap lua chon cua ban: ");
        System.out.println("1. sap xep theo ten sinh vien ");
        System.out.println("2. sap xep them mon hoc ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2){
                break;
            }
            System.out.println("lua chon khong hop le, vui long chon lai: ");
        }while (true);
        if (choice == 1){
            for (int i = 0; i < Main.BANGDIEM.length; i ++ ){
                if (Main.BANGDIEM[i] == null){
                    continue;
                }
                for (int j = 0; j < Main.BANGDIEM.length; j++) {
                    if (Main.BANGDIEM[j]== null){
                        continue;
                    }
                    if (Main.BANGDIEM[i].getSinhVien().getHoVaTen().compareTo(Main.BANGDIEM[j].getSinhVien().getHoVaTen() )> 0){
                        BangDiem temp = Main.BANGDIEM[i];
                        Main.BANGDIEM[j] = Main.BANGDIEM[j];
                        Main.BANGDIEM[j] = temp;
                    }
                }
            }
            hienThiBangDiem();
        } else if (choice == 2) {// sap xep theo Mon hoc

        }
    }
    public static void hienThiBangDiem(){
        for (int i = 0; i < Main.BANGDIEM.length; i++) {
            if (Main.BANGDIEM[i] != null){
                System.out.println(Main.BANGDIEM[i]);
            }
        }
    }


}
