import java.util.List;

public interface QuanLy {
    void themHocSinh(HocSinh hs) throws InvalidStudentCountException;
    void xoaHocSinh(String ten);
    void suaHocSinh(String ten);
    HocSinh timTheoTen(String ten);
    List<HocSinh> danhSachThiLai();
    void hienThiTatCa();
    void sapXepTheoDTB();
    int demHocSinhGioi();
    void thongke();
    void ghiFile(String tenFile) throws Exception;
    void docFile(String tenFile) throws Exception;
}
