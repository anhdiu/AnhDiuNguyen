package MonHoc;

import Interface.InputTable;

import java.util.Scanner;

public class MonHoc implements InputTable {
    public static int auto_maMonHoc = 100;
    private int maMonHoc;
    private String tenMon;
    private int soHocTrinh;
    private LoaiMon loaiMon;
    public MonHoc(){}


    public MonHoc(int maMonHoc, String tenMon, int soHocTrinh,LoaiMon loaiMon) {
        this.maMonHoc = maMonHoc;
        this.tenMon = tenMon;
        this.soHocTrinh = soHocTrinh;
        this.loaiMon = loaiMon;
    }

    public static int getAuto_maMonHoc() {
        return auto_maMonHoc;
    }

    public static void setAuto_maMonHoc(int auto_maMonHoc) {
        MonHoc.auto_maMonHoc = auto_maMonHoc;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(int maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoHocTrinh() {
        return soHocTrinh;
    }

    public void setSoHocTrinh(int soHocTrinh) {
        this.soHocTrinh = soHocTrinh;
    }

    public LoaiMon getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(LoaiMon loaiMon) {
        this.loaiMon = loaiMon;
    }

    @Override
    public void inputInfor() {
        this.maMonHoc = MonHoc.auto_maMonHoc++;
        System.out.println("nhap ten mon hoc");
        this.tenMon =  new Scanner(System.in).nextLine();
        System.out.println("nhap so hoc trinh");
        this.soHocTrinh = new Scanner(System.in).nextInt();
        System.out.println("nhap the loai mon hoc");
        this.nhapTheloaiMonhoc();
    }
    public void  nhapTheloaiMonhoc(){
        System.out.println("1. Dai cuong");
        System.out.println("2. Co so Nganh ");
        System.out.println("3. Chuyen Nganh");
        int LuaChon = 0;
        do {
            LuaChon = new Scanner(System.in).nextInt();
            if (LuaChon >= 1 && LuaChon <= 3 ){
                break;
            }
            System.out.println("lua chon sai vui long nhap lai");
        } while (true);
        switch (LuaChon){
            case 1:
                this.setLoaiMon(LoaiMon.DaiCuong);
                break;
            case 2:
                this.setLoaiMon(LoaiMon.CoSoNganh);
                break;
            case 3:
                this.setLoaiMon(LoaiMon.ChuyenNganh);
      break;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
