package MonHoc;

public class chiTietBangDiem {
    private MonHoc monHoc;
    private Float diemSo;
    public chiTietBangDiem(){}

    public chiTietBangDiem(MonHoc monHoc, Float diemSo) {
        this.monHoc = monHoc;
        this.diemSo = diemSo;
    }

    public  MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public Float getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(Float diemSo) {
        this.diemSo = diemSo;
    }

    @Override
    public String toString() {
        return "chiTietBangDiem{" +
                "monHoc=" + monHoc +
                ", diemSo=" + diemSo +
                '}';
    }
}
