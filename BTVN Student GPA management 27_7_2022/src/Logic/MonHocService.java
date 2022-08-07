package Logic;

import Main.Main;
import MonHoc.MonHoc;

import java.util.Scanner;

public class MonHocService {
    public static void themMonHoc (){
        System.out.println("xin moi nhap so luong mon hoc muon them : ");
        int soLuongMonHoc = new Scanner(System.in).nextInt();
        for (int i = 0; i < soLuongMonHoc; i++) {
             MonHoc monHoc = new MonHoc();
             monHoc.inputInfor();
             luaMonHoc(monHoc);
        }

    }
    public static void luaMonHoc(MonHoc monHoc){
        for (int i = 0 ; i < Main.MONHOC.length ; i ++){
            if (Main.MONHOC[i] == null){
                Main.MONHOC[i] = monHoc;
                return;
            }
        }
    }
    public static void  hienThiMonHoc ( ){
        for (int i = 0; i < Main.MONHOC.length; i++) {
            if (Main.MONHOC[i] == null){
                continue;
            }
            System.out.println(Main.MONHOC[i]);
        }
    }

    public static boolean kiemTraMonHoc (){
        for (int i = 0; i < Main.MONHOC.length; i++) {
            if (Main.MONHOC[i] != null){
                return false;
            }
        }
        return true;
    }
}

