import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            QuanLyHocSinh ql = new QuanLyHocSinh();
            int choice;

            do {
                System.out.println("\n====== MENU QUẢN LÝ HỌC SINH ======");
                System.out.println("1. Thêm học sinh");
                System.out.println("2. Hiển thị tất cả học sinh");
                System.out.println("3. Hiển thị danh sách học sinh thi lại");
                System.out.println("4. Tìm kiếm học sinh theo tên");
                System.out.println("5. Sửa điểm học sinh");
                System.out.println("6. Xóa học sinh");
                System.out.println("7. Đếm số học sinh giỏi");
                System.out.println("8. Sắp xếp theo điểm TB giảm dần");
                System.out.println("9. Thống kê học lực các học sinh");
                System.out.println("10. Ghi ra file");
                System.out.println("11. Đọc từ file");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");
                choice = sc.nextInt();
                sc.nextLine(); // Xóa bộ đệm dòng

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Nhập họ tên: ");
                            String ten = sc.nextLine();
                            double toan = nhapDiem(sc, "Toán");
                            double ly = nhapDiem(sc, "Lý");
                            double hoa = nhapDiem(sc, "Hóa");
                            ql.themHocSinh(new HocSinh(ten, toan, ly, hoa));
                        } catch (InvalidStudentCountException e) {
                            System.out.println("Lỗi: " + e.getMessage());
                        }
                        break;

                    case 2:
                        ql.hienThiTatCa();
                        break;

                    case 3:
                        List<HocSinh> thiLai = ql.danhSachThiLai();
                        if (thiLai.isEmpty()) {
                            System.out.println("Không có học sinh nào phải thi lại.");
                        } else if (thiLai.size() < 1 || thiLai.size() > 30) {
                            System.out.println("Số lượng học sinh thi lại không hợp lệ. (1 - 30)");
                        } else {
                            System.out.println("Danh sách học sinh thi lại:");
                            thiLai.forEach(System.out::println);
                        }
                        break;

                    case 4:
                        System.out.print("Nhập tên cần tìm: ");
                        HocSinh found = ql.timTheoTen(sc.nextLine());
                        System.out.println(found != null ? found : "Không tìm thấy học sinh.");
                        break;

                    case 5:
                        System.out.print("Nhập tên học sinh cần sửa: ");
                        ql.suaHocSinh(sc.nextLine());
                        break;

                    case 6:
                        System.out.print("Nhập tên học sinh cần xóa: ");
                        ql.xoaHocSinh(sc.nextLine());
                        break;

                    case 7:
                        System.out.println("Số học sinh giỏi: " + ql.demHocSinhGioi());
                        break;

                    case 8:
                        ql.sapXepTheoDTB();
                        System.out.println("Đã sắp xếp theo điểm trung bình.");
                        break;

                    case 9:
                        ql.thongke();
                        break;

                    case 10:
                        try {
                            ql.ghiFile("output.txt");
                            System.out.println("Đã ghi vào file output.txt");
                        } catch (Exception e) {
                            System.out.println("Lỗi ghi file: " + e.getMessage());
                        }
                        break;

                    case 11:
                        try {
                            ql.docFile("input.txt");
                            System.out.println("Đã đọc từ file input.txt");
                        } catch (Exception e) {
                            System.out.println("Lỗi đọc file: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Kết thúc chương trình.");
                        break;

                    default:
                        System.out.println("Chức năng không hợp lệ.");
                }

            } while (choice != 0);
        }
    }

    // Hàm kiểm tra và nhập điểm hợp lệ từ 0 đến 10
    public static double nhapDiem(Scanner sc, String mon) {
        double diem;
        while (true) {
            try {
                System.out.print("Điểm " + mon + ": ");
                diem = Double.parseDouble(sc.nextLine());
                if (diem >= 0 && diem <= 10) {
                    return diem;
                } else {
                    System.out.println("Điểm phải từ 0 đến 10. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số.");
            }
        }
    }
}
