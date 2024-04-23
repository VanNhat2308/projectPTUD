package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class HoaDon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(7)")
	private String maHD; //
	@ManyToOne
	@JoinColumn(name = "maKH")
	private KhachHang khachHang;//
	@ManyToOne
	@JoinColumn(name = "maKM")
	private KhuyenMai khuyenMai;//
	private Date ngayLap;//
	private Date ngayTraPhong;
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanVienLap;//
	private float thue;//

	@OneToMany(mappedBy = "dichVu", fetch = FetchType.LAZY)
	private List<ChiTietDichVu> chiTietDichVu;

	@OneToMany(mappedBy = "hoaDon", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<ChiTietHoaDon> chiTietHoaDon;
	private float chietKhau;//
	private Date gioKetThuc;//
	private Date gioNhanPhong;//
	private double tongTien;//
	private long tienKhachTra;//
	private boolean trangThai;//

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(NhanVien nhanVienLap,Date ngayTraPhong ,KhuyenMai khuyenMai, KhachHang khachHang) {
		this.khachHang = khachHang;
		this.khuyenMai = khuyenMai;
		this.nhanVienLap = nhanVienLap;
		this.ngayTraPhong = ngayTraPhong;
		this.tongTien = 0;
		this.thue = (float) 10;
		this.chietKhau = 0;
		this.gioNhanPhong = new Date();
		this.ngayLap = new Date();
		this.trangThai = false;
	}
	public HoaDon(NhanVien nhanVienLap,Date ngayNhanPhong,Date ngayTraPhong ,KhuyenMai khuyenMai, KhachHang khachHang) {
		this.khachHang = khachHang;
		this.khuyenMai = khuyenMai;
		this.nhanVienLap = nhanVienLap;
		this.ngayTraPhong = ngayTraPhong;
		this.ngayLap = ngayNhanPhong;
		this.tongTien = 0;
		this.thue = (float) 10;
		this.chietKhau = 0;
		this.gioNhanPhong = new Date();
		this.ngayLap = new Date();
		this.trangThai = false;
	}
	public HoaDon(NhanVien nhanVienLap,KhuyenMai khuyenMai, KhachHang khachHang) {
		this.khachHang = khachHang;
		this.khuyenMai = khuyenMai;
		this.nhanVienLap = nhanVienLap;
		this.tongTien = 0;
		this.thue = (float) 10;
		this.chietKhau = 0;
		this.gioNhanPhong = new Date();
		this.ngayLap = new Date();
		this.trangThai = false;
	}

	public Date getNgayTraPhong() {
		return ngayTraPhong;
	}

	public void setNgayTraPhong(Date ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.chietKhau = khuyenMai.getChietKhau();
		this.khuyenMai = khuyenMai;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public NhanVien getNhanVienLap() {
		return nhanVienLap;
	}

	public void setNhanVienLap(NhanVien nhanVienLap) {
		this.nhanVienLap = nhanVienLap;
	}

	public float getThue() {
		return thue;
	}

	public void setThue(float thue) {
		this.thue = thue;
	}

	public List<ChiTietDichVu> getChiTietDichVu() {
		return chiTietDichVu;
	}

	public void setChiTietDichVu(List<ChiTietDichVu> chiTietDichVu) {
		this.chiTietDichVu = chiTietDichVu;
	}

	public List<ChiTietHoaDon> getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(List<ChiTietHoaDon> chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public float getChietKhau() {
		return chietKhau;
	}

	public void setChietKhau(float chietKhau) {
		this.chietKhau = chietKhau;
	}

	public Date getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(Date gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

	public Date getGioNhanPhong() {
		return gioNhanPhong;
	}

	public void setGioNhanPhong(Date gioNhanPhong) {
		this.gioNhanPhong = gioNhanPhong;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public double getTienKhachTra() {
		return tienKhachTra;
	}

	public void setTienKhachTra(long tienKhachTra) {
		this.tienKhachTra = tienKhachTra;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long tinhTienDichVu() {
		long sum = 0;
		if (getChiTietDichVu() == null)
			return 0;
		for (ChiTietDichVu chiTietDichVu : getChiTietDichVu()) {
			sum += chiTietDichVu.thanhTien();
		}
		return sum;
	}

	public long tinhTienPhong() {
		long sum = 0;
		for (ChiTietHoaDon chiTietHoaDon : getChiTietHoaDon()) {
			sum += chiTietHoaDon.thanhTien();
		}
		return sum;
	}

	//cap nhat thoi gian su dung phong
//	public int capNhatThoiLuong(String maPhong) {
//		if (this.gioKetThuc == null) {
//			this.gioKetThuc = new Date();
//		}
//		//60000 = 60 * 1000 ms = 1p
//		//gio ket thuc - gio nhan phong ( don vi PHUT )
//		long phut = ((gioKetThuc.getTime() / 60000) - (gioNhanPhong.getTime() / 60000));
//		long phut2 = phut;
//		int size = chiTietHoaDon.size();
//		int index = -1;
//		for (int i = 0; i < size; i++) {
//			if (chiTietHoaDon.get(i).getPhong().getMaPhong().equals(maPhong)) {
//				index = i;
//			}
//			phut -= chiTietHoaDon.get(i).getThoiLuong();
//		}
//		chiTietHoaDon.get(index).setThoiLuong((int) phut + chiTietHoaDon.get(index).getThoiLuong());
//		return (int) phut2;
//	}
//1
	public double thanhTien() {
	    if (chiTietHoaDon == null)
	        return 0;

	    double sum = tinhTienDichVu(); // Tính tiền dịch vụ

	    int thoiGian = 0;
	    double giaPhongMotNgay = 0;

	    // Tính tổng thời gian sử dụng và tổng giá phòng mỗi ngày
	    for (ChiTietHoaDon chiTietHoaDonTam : chiTietHoaDon) {
	        thoiGian += chiTietHoaDonTam.getThoiLuong().getHours();
	        sum += chiTietHoaDonTam.thanhTien();
	        giaPhongMotNgay = chiTietHoaDonTam.getPhong().getLoaiPhong().getGiaTien(); // Giá phòng mỗi ngày
	    }

	    // Nếu thời gian sử dụng nhỏ hơn 1 ngày
	    if (thoiGian < 1440) { // 1440 phút = 1 ngày
	        // Tính số ngày sử dụng
	        int soNgaySuDung = 1;

	        // Tính tiền dựa trên số ngày sử dụng
	        sum += giaPhongMotNgay * soNgaySuDung;
	    } else { // Nếu thời gian sử dụng lớn hơn hoặc bằng 1 ngày
	        // Tính số ngày sử dụng
	        int soNgaySuDung = thoiGian / 1440; // Số ngày là phép chia lấy phần nguyên

	        // Tính tiền dựa trên số ngày sử dụng
	        sum += giaPhongMotNgay * soNgaySuDung;
	    }

	    // Thêm thuế 10%
	    double thue = sum * 0.1;

	    // Thực hiện tính thuế và khuyến mãi
	    double chietKhau = ((this.thue - this.khuyenMai.getChietKhau()) / 100) * sum;
	    this.tongTien = (sum + thue + chietKhau);

	    return this.tongTien;
	}


	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", khachHang=" + khachHang + ", khuyenMai=" + khuyenMai + ", ngayLap=" + ngayLap
				+ ", nhanVienLap=" + nhanVienLap + ", thue=" + thue + ", chietKhau=" + chietKhau + ", gioKetThuc="
				+ gioKetThuc + ", gioNhanPhong=" + gioNhanPhong + ", tongTien=" + tongTien + ", tienKhachTra="
				+ tienKhachTra + ", trangThai=" + trangThai + "]";
	}

}// end HoaDon