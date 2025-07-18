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
                System.out.println("9. Ghi ra file");
                System.out.println("10. Đọc từ file");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Nhập họ tên: ");
                            String ten = sc.nextLine();
                            System.out.print("Điểm Toán: ");
                            double toan = sc.nextDouble();
                            System.out.print("Điểm Lý: ");
                            double ly = sc.nextDouble();
                            System.out.print("Điểm Hóa: ");
                            double hoa = sc.nextDouble();
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
                        if (thiLai.size() < 2 || thiLai.size() > 30) {
                            System.out.println("Số lượng học sinh thi lại không hợp lệ. (2 - 30)");
                        } else if (thiLai.isEmpty()) {
                            System.out.println("Không có học sinh nào phải thi lại.");
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
                        try {
                            ql.ghiFile("output.txt");
                            System.out.println("Đã ghi vào file output.txt");
                        } catch (Exception e) {
                            System.out.println("Lỗi ghi file: " + e.getMessage());
                        }
                        break;
                    case 10:
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
}
