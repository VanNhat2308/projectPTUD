package entity;

import java.sql.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PhieuDoiPhong {
  private String maDoiPhong;
  private Date ngayDoiPhong;
  private String lyDoDoiPhong;
	@ManyToOne
	@JoinColumn(name = "maPhongMoi")
	private Phong phong;
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanVien;
	public PhieuDoiPhong(String maDoiPhong, Date ngayDoiPhong, String lyDoDoiPhong, Phong phong, NhanVien nhanVien) {
		super();
		this.maDoiPhong = maDoiPhong;
		this.ngayDoiPhong = ngayDoiPhong;
		this.lyDoDoiPhong = lyDoDoiPhong;
		this.phong = phong;
		this.nhanVien = nhanVien;
	}
	public PhieuDoiPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaDoiPhong() {
		return maDoiPhong;
	}
	public void setMaDoiPhong(String maDoiPhong) {
		this.maDoiPhong = maDoiPhong;
	}
	public Date getNgayDoiPhong() {
		return ngayDoiPhong;
	}
	public void setNgayDoiPhong(Date ngayDoiPhong) {
		this.ngayDoiPhong = ngayDoiPhong;
	}
	public String getLyDoDoiPhong() {
		return lyDoDoiPhong;
	}
	public void setLyDoDoiPhong(String lyDoDoiPhong) {
		this.lyDoDoiPhong = lyDoDoiPhong;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public String toString() {
		return "PhieuDoiPhong [maDoiPhong=" + maDoiPhong + ", ngayDoiPhong=" + ngayDoiPhong + ", lyDoDoiPhong="
				+ lyDoDoiPhong + ", phong=" + phong + ", nhanVien=" + nhanVien + "]";
	}
	
	
	 
	
	
	
	
	
}
