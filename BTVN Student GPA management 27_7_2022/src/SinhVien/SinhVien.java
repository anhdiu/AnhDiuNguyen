package SinhVien;

import Interface.InputTable;

import java.util.Scanner;

public class SinhVien implements InputTable,Comparable<SinhVien> {
    public static int auto_ID = 10000;
    private int maSinhVien;
    private String hoVaTen;
    private String diaChi;
    private int soDienThoai;
    private String lop;
    public SinhVien (){}

    public SinhVien(int maSinhVien, String hoVaTen, String diaChi, int soDienThoai, String lop) {
        this.maSinhVien = maSinhVien;
        this.hoVaTen = hoVaTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.lop = lop;
    }

    public static int getAuto_ID() {
        return auto_ID;
    }

    public static void setAdto_ID(int adto_ID) {
        SinhVien.auto_ID = adto_ID;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public void inputInfor() {
        this.maSinhVien = SinhVien.auto_ID++;
        System.out.println("nhap ho va ten sinh vien");
        this.hoVaTen = new Scanner(System.in).nextLine();
        System.out.println("nhap dia chi");
        this.diaChi = new Scanner(System.in).nextLine();
        System.out.println("nhap so dien thoai");
        this.soDienThoai = new Scanner(System.in).nextInt();
        System.out.println("nhap lop ");
        this.lop = new Scanner(System.in).nextLine();


    }


    @Override
    public int compareTo(SinhVien sinhVien) {
     if (this.maSinhVien < sinhVien.getMaSinhVien()){
         return 1;
     } else if ( this.maSinhVien > sinhVien.getMaSinhVien()){
         return -1;
     }
        return 0;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSinhVien=" + maSinhVien +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai=" + soDienThoai +
                ", lop='" + lop + '\'' +
                '}';
    }
}
