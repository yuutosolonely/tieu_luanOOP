import java.io.*;
import java.util.*;

public class QuanLyHocSinh implements QuanLy {
    private final ArrayList<HocSinh> danhSach = new ArrayList<>();

    @Override
    public void themHocSinh(HocSinh hs) throws InvalidStudentCountException {
        if (danhSach.size() >= 30) {
            throw new InvalidStudentCountException("Danh sách học sinh không được vượt quá 30 em.");
        }
        danhSach.add(hs);
    }

    @Override
    public void xoaHocSinh(String ten) {
        danhSach.removeIf(h -> h.getHoTen().equalsIgnoreCase(ten));
    }

   @Override
    public void suaHocSinh(String ten) {
        for (HocSinh h : danhSach) {
            if (h.getHoTen().equalsIgnoreCase(ten)) {
                Scanner sc = new Scanner(System.in);
                h.setToan(Main.nhapDiem(sc, "Toán mới"));
                h.setLy(Main.nhapDiem(sc, "Lý mới"));
                h.setHoa(Main.nhapDiem(sc, "Hóa mới"));
                System.out.println("Đã cập nhật điểm cho học sinh " + ten);
                return;
            }
        }
        System.out.println("Không tìm thấy học sinh!");
    }


    @Override
    public HocSinh timTheoTen(String ten) {
        for (HocSinh h : danhSach) {
            if (h.getHoTen().equalsIgnoreCase(ten)) {
                return h;
            }
        }
        return null;
    }

    @Override
    public List<HocSinh> danhSachThiLai() {
        List<HocSinh> kq = new ArrayList<>();
        for (HocSinh h : danhSach) {
            if (h.phaiThiLai()) kq.add(h);
        }
        return kq;
    }

    @Override
    public void hienThiTatCa() {
        for (HocSinh h : danhSach) {
            System.out.println(h);
        }
    }

    @Override
    public void sapXepTheoDTB() {
        danhSach.sort((a, b) -> Double.compare(b.diemTB(), a.diemTB()));
    }

    @Override
    public int demHocSinhGioi() {
        int dem = 0;
        for (HocSinh h : danhSach) {
            if (h.diemTB() >= 8) dem++;
        }
        return dem;
    }
    @Override
    public void thongke()
    {
        int tonghs = danhSach.size();
        int y=0,tb=0,g=0;
        for (HocSinh h : danhSach)
            if (h.diemTB() < 5)
                y++;
            else if(h.diemTB() >=5 && h.diemTB() <8)
                tb++;
            else g++;
        float tmp;
        System.out.printf("Hiện đang có tổng cộng %d học sinh \n",tonghs);
        if(y == 0)
            tmp = 0;
        else
            tmp = ((float)y/tonghs)*100;
        System.out.printf("Trong đó có %d học sinh yếu, chiếm %.2f phần trăm tổng hs \n",y,tmp);
        if(tb == 0)
            tmp = 0;
        else
            tmp = ((float)tb/tonghs)*100;
        System.out.printf("Trong đó có %d học sinh trung bình, chiếm %.2f phần trăm tổng hs \n",tb,tmp);
        if(g == 0)
            tmp = 0;
        else 
            tmp = ((float)g/tonghs)*100;
        System.out.printf("Trong đó có %d học sinh giỏi, chiếm %.2f phần trăm tổng hs \n",g,tmp);
    }

    @Override
    public void ghiFile(String tenFile) throws Exception {
        try (PrintWriter pw = new PrintWriter(new FileWriter(tenFile))) {
            for (HocSinh h : danhSach) {
                pw.println(h.getHoTen() + "," + h.getToan() + "," + h.getLy() + "," + h.getHoa());
            }
        }
    }

    @Override
    public void docFile(String tenFile) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    themHocSinh(new HocSinh(parts[0], Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2]), Double.parseDouble(parts[3])));
                }
            }
        }
    }
}
