package Logic;

import Main.Main;
import MonHoc.chiTietBangDiem;
import MonHoc.MonHoc;
import MonHoc.BangDiem;
import SinhVien.SinhVien;

import java.util.Scanner;

public class QuanLySinhVien {
    public static void nhapDiem() {
        if (SinhVienService.kiemTraSinhVien() || MonHocService.kiemTraMonHoc()) {
            System.out.println("can them sinh vien va mon hoc truoc khi nhap  diem ");

        }
        System.out.println("ban muon them bao nhieu sinh vien : ");
        int soLuongSinhVien = new Scanner(System.in).nextInt();
        for (int i = 0; i < soLuongSinhVien; i++) {

            // thuc hien nhap diem cho ban thu n


            // nhap sinh vien muon nhap diem
            SinhVien sinhVien = nhapThongTinSinhVien(i);

            // nhap danh them diem vao mon hoc
            chiTietBangDiem[] chiTietBangDiems = nhapThongTinChiTietBangDiem();
            BangDiem bangDiem = new BangDiem(sinhVien, chiTietBangDiems);
            luuBangDiem(bangDiem);

        }
    }
    public static void diemTrungBinh (){


    }

    public static void luuBangDiem(BangDiem bangDiem) {
        for (int i = 0; i < Main.BANGDIEM.length; i++) {
            if (Main.BANGDIEM[i] == null) {
                Main.BANGDIEM[i] = bangDiem;
                break;
            }
        }
    }

    public static chiTietBangDiem[] nhapThongTinChiTietBangDiem() {
        System.out.println("ban muon nhap diem cho bao nhieu mon hoc  : ");
        int soLuong = new Scanner(System.in).nextInt();
        // nhap so luong mon hoc muon them diem
        chiTietBangDiem[] chiTietBangDiems = new chiTietBangDiem[soLuong];
        for (int i = 0; i < soLuong; i++) {
            System.out.println("nhap  ma mon hoc thu " + (i + 1) + " ma ban muon them ");
            MonHoc monHoc = null;
            do {
                int IDmonhoc = new Scanner(System.in).nextInt();
                for (int j = 0; j < Main.MONHOC.length; j++) {
                    if (Main.MONHOC[j] != null && Main.MONHOC[j].getMaMonHoc() == IDmonhoc) {
                        monHoc = Main.MONHOC[j];
                        break;
                    }
                }
                if (monHoc != null) {
                    break;
                }
                System.out.println("khong tim thay mon hoc vui long nhap lai : ");

            } while (true);
            System.out.println("ban dat duoc bao nhieu diem cho mon nay : ");
            float soDiem;
            do {
                soDiem = new Scanner(System.in).nextFloat();
                if (soDiem >= 0 && soDiem <= 10) {
                    break;
                }
                System.out.println("xin vui long nhap lai diem : ");
            } while (true);
            chiTietBangDiem chiTietBangDiem = new chiTietBangDiem(monHoc, soDiem);
            for (int j = 0; j < chiTietBangDiems.length; j++) {
                if (chiTietBangDiems[i] == null) {
                    chiTietBangDiems[i] = chiTietBangDiem;
                    break;
                }
            }
        }
        return chiTietBangDiems;

    }

    public static SinhVien nhapThongTinSinhVien(int oder) {
        System.out.println("nhap ma sinh vien thu " + (oder + 1) + "muon them diem : ");
        SinhVien sinhVien = null;
        do {
            int IDsinhVien = new Scanner(System.in).nextInt();
            for (int i = 0; i < Main.SINHVIEN.length; i++) {
                if (Main.SINHVIEN[i] != null && Main.SINHVIEN[i].getMaSinhVien() == IDsinhVien) {
                    sinhVien = Main.SINHVIEN[i];
                    break;
                }
            }
            if (sinhVien != null) {
                break;
            }
            System.out.println("khong tim thay sinh vien vua nhap, vui long nhap lai ");
        } while (true);
        return sinhVien;
    }

    public static void sapXepBangDiem() {
        System.out.println("xin moi nhap lua chon cua ban: ");
        System.out.println("1. sap xep theo ten sinh vien ");
        System.out.println("2. sap xep theo ten  mon hoc ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2) {
                break;
            }
            System.out.println("lua chon khong hop le, vui long chon lai: ");
        } while (true);

        for (int i = 0; i < Main.BANGDIEM.length - 1; i++) {
            if (Main.BANGDIEM[i] == null) {
                continue;
            }
            for (int j = i + 1; j < Main.BANGDIEM.length; j++) {
                if (Main.BANGDIEM[j] == null) {
                    continue;
                }
               if (choice == 1) {
                   if (Main.BANGDIEM[i].getSinhVien().getHoVaTen().compareTo(Main.BANGDIEM[j].getSinhVien().getHoVaTen()) > 0){
                       BangDiem temp = Main.BANGDIEM[i];
                       Main.BANGDIEM[i] = Main.BANGDIEM[j];
                       Main.BANGDIEM[j] = temp;
                   }

               } else if (choice == 2){
                   if (Main.MONHOC[i].getTenMon().compareTo(Main.MONHOC[j].getTenMon()) > 0) {

                       Main.BANGDIEM[i] = Main.BANGDIEM[j];

                   }

               }
            }
        }
        hienThiBangDiem();


    }

    public static void hienThiBangDiem() {
        for (int i = 0; i < Main.BANGDIEM.length; i++) {
            if (Main.BANGDIEM[i] != null) {
                System.out.println(Main.BANGDIEM[i]);
            }
        }
    }


}
