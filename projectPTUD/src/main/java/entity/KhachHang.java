package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class KhachHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(7)")
	private String maKH;
	@ManyToOne
	@JoinColumn(name = "maDC",columnDefinition = "varchar(7)")
	private DiaChi diaChi;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String hoTen;//
	@Column(columnDefinition = "varchar(11)")
	private String soDienThoai;
	private Date ngaySinh;
	private boolean gioiTinh;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String email;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String soCMND;
	public KhachHang(String maKH, DiaChi diaChi, String hoTen, String soDienThoai, Date ngaySinh, boolean gioiTinh,
			String email, String soCMND) {
		super();
		this.maKH = maKH;
		this.diaChi = diaChi;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.soCMND = soCMND;
	}

	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	
	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhachHang(DiaChi diaChi, String hoTen, String soDienThoai, Date ngaySinh, boolean gioiTinh, String email,
			String soCMND) {
		super();
		this.diaChi = diaChi;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.soCMND = soCMND;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", diaChi=" + diaChi + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", email=" + email + ", soCMND=" + soCMND + "]";
	}


}