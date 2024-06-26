package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.NhanVien;
import entity.Phong;

//public class Main {
//    public static void main(String[] args) {
//        // Initialize Hibernate SessionFactory (this would require configuration)
//        SessionFactory sessionFactory = buildSessionFactory(); // Implement this method based on your Hibernate configuration.
//
//        // Create an instance of PhongDao with the session factory
//        PhongDao phongDao = new PhongDao(sessionFactory);
//
//        // Now you can use phongDao to interact with the database.
//        // For example, to get a list of all rooms:
//     
//         System.out.println(phongDao.layDanhSachPhong());
//         
//
//        // Đóng SessionFactory
//        sessionFactory.close();
//    }
//   
//
//    private static SessionFactory buildSessionFactory() {
//        // Implement the logic to build a SessionFactory based on your Hibernate configuration.
//        // This often includes building a Configuration object, adding annotated classes, and then building the SessionFactory.
//        return new Configuration().configure().buildSessionFactory();
//    }
//}
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import dao.KhachHangDao;
import entity.DiaChi;
import entity.KhachHang;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Tạo SessionFactory từ file cấu hình Hibernate
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        try {
            // Tạo instance của lớp chứa phương thức themKhachHang
            NhanVienDao dao = new NhanVienDao(sessionFactory);
            
            // Tạo một đối tượng KhachHang mới và thiết lập thông tin
            NhanVien khachHang = new NhanVien();
            // Giả định rằng phương thức phatSinhMaTuDong() sẽ được gọi trong phương thức themKhachHang
            // Bạn cần set các thuộc tính khác như trong ví dụ bạn đã cung cấp
            DiaChi diaChi = new DiaChi();
            diaChi.setMaDC("DC02838");
            diaChi.setTinhTP("Tỉnh Cao Bằng");
            diaChi.setQuanHuyen("Huyện Hạ Lang");
            diaChi.setPhuongXa("Xã Đồng Loan");
            khachHang.setDiaChi(diaChi);
            khachHang.setHoTen("trần thanh đức");
            khachHang.setSoDienThoai("0357948350");
            khachHang.setGioiTinh(false); // false nếu là nữ
            khachHang.getPassword();
            khachHang.setSoCMND("2345323");
            
            // Thực hiện thêm khách hàng
            boolean ketQua = dao.themNhanVien(khachHang);
            if (ketQua) {
                System.out.println("Thêm khách hàng thành công!");
            } else {
                System.out.println("Thêm khách hàng thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng SessionFactory
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
