package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class PhieuDatPhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "varchar(8)")
	private String maPDP;//

	@ManyToOne
	@JoinColumn(name = "maKH")
	private KhachHang khachHang;//
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanVienLap;//
	@ManyToOne
	@JoinColumn(name = "maPhong")
	private Phong phong;//
	private Date ngayDKDatPhong;//
	private Date ngayNhanPhong;//
	private boolean tinhTrang;//
    private int soNguoi;
	public PhieuDatPhong() {

	}
	public PhieuDatPhong(String maPDP, KhachHang khachHang, NhanVien nhanVienLap, Phong phong,
			Date thoiGianDangKyDatPhong, Date thoiGianNhanPhong, boolean tinhTrang,int soNguoi) {
		super();
		this.maPDP = maPDP;
		this.khachHang = khachHang;
		this.nhanVienLap = nhanVienLap;
		this.phong = phong;
		this.ngayDKDatPhong = thoiGianDangKyDatPhong;
		this.ngayNhanPhong = thoiGianNhanPhong;
		this.tinhTrang = tinhTrang;
		this.soNguoi = soNguoi;
	}

	public PhieuDatPhong(KhachHang khachHang, NhanVien nhanVienLap, Phong phong, Date thoiGianNhanPhong) {
		super();
		this.khachHang = khachHang;
		this.nhanVienLap = nhanVienLap;
		this.phong = phong;
		this.ngayNhanPhong = thoiGianNhanPhong;
		this.tinhTrang = true;
	}

	public String getMaPDP() {
		return maPDP;
	}
	public void setMaPDP(String maPDP) {
		this.maPDP = maPDP;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVienLap() {
		return nhanVienLap;
	}
	public void setNhanVienLap(NhanVien nhanVienLap) {
		this.nhanVienLap = nhanVienLap;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public Date getNgayDKDatPhong() {
		return ngayDKDatPhong;
	}
	public void setNgayDKDatPhong(Date ngayDKDatPhong) {
		this.ngayDKDatPhong = ngayDKDatPhong;
	}
	public Date getNgayNhanPhong() {
		return ngayNhanPhong;
	}
	public void setNgayNhanPhong(Date ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PhieuDatPhong [maPDP=" + maPDP + ", khachHang=" + khachHang + ", nhanVienLap=" + nhanVienLap
				+ ", phong=" + phong + ", ngayDKDatPhong=" + ngayDKDatPhong + ", ngayNhanPhong=" + ngayNhanPhong
				+ ", tinhTrang=" + tinhTrang + ", soNguoi=" + soNguoi + "]";
	}

	
	
	
}// end PhieuDatPhong