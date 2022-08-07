package MonHoc;

import SinhVien.SinhVien;

import java.util.Arrays;

public class BangDiem {
    private SinhVien sinhVien;
    private chiTietBangDiem[] chiTietBangDiems;
    public BangDiem (){}

    public BangDiem(SinhVien sinhVien, chiTietBangDiem[] chiTietBangDiems) {
        this.sinhVien = sinhVien;
        this.chiTietBangDiems = chiTietBangDiems;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public chiTietBangDiem[] getChiTietBangDiems() {
        return chiTietBangDiems;
    }

    public void setChiTietBangDiems(chiTietBangDiem[] chiTietBangDiems) {
        this.chiTietBangDiems = chiTietBangDiems;
    }

    @Override
    public String toString() {
        return "BangDiem{" +
                "sinhVien=" + sinhVien +
                ", chiTietBangDiems=" + Arrays.toString(chiTietBangDiems) +
                '}';
    }
}
