package Logic;

import Main.Main;
import SinhVien.SinhVien;

import java.util.Scanner;

public class SinhVienService {
    public static void  hienThiSinhVien(){
        for (int i = 0; i < Main.SINHVIEN.length; i++) {
            if (Main.SINHVIEN[i] == null){
                continue;
            }
            System.out.println(Main.SINHVIEN[i]);
        }
    }
    public static void them1SinhVien (){
        System.out.println("xin moi nhap so luong sinh vien muon them ");
        int soLuongSinhVien = new Scanner(System.in).nextInt();
        for (int i = 0; i < soLuongSinhVien; i++) {
            System.out.println("moi nhap thong tin sinh vien thu " + ( i + 1));
             SinhVien sinhVien = new SinhVien();
             sinhVien.inputInfor();
             luaThongTinSinhVien(sinhVien);
        }
    }
    public static void luaThongTinSinhVien(SinhVien sinhVien){
        for (int i = 0; i < Main.SINHVIEN.length; i++) {
            if ( Main.SINHVIEN[i] == null){
                Main.SINHVIEN[i] = sinhVien;
                return;
            }
        }
    }
    public static boolean kiemTraSinhVien (){
        for (int i = 0 ; i< Main.SINHVIEN.length; i ++){
            if (Main.SINHVIEN[i] != null) {
                return false;
            }
        }
        return true;
    }

}
