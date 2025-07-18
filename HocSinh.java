public class HocSinh {
    private String hoTen;
    private double toan, ly, hoa;

    public HocSinh(String hoTen, double toan, double ly, double hoa) {
        this.hoTen = hoTen;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getLy() {
        return ly;
    }

    public void setLy(double ly) {
        this.ly = ly;
    }

    public double getHoa() {
        return hoa;
    }

    public void setHoa(double hoa) {
        this.hoa = hoa;
    }

    public double diemTB() {
        return (toan + ly + hoa) / 3.0;
    }

    public boolean phaiThiLai() {
        return diemTB() < 5;
    }

    @Override
    public String toString() {
        return hoTen + " - Toán: " + toan + ", Lý: " + ly + ", Hóa: " + hoa + ", TB: " + String.format("%.2f", diemTB());
    }
}
