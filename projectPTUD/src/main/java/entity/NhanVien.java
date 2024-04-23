package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(7)")
	private String maNV;
	private boolean gioiTinh;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String hoTen;
	private Date ngaySinh;
	@Column(columnDefinition = "varchar(10)")
	private String password;
	@Column(columnDefinition = "varchar(11)")
	private String soCMND;
	@Column(columnDefinition = "varchar(11)")
	private String soDienThoai;
	private boolean trangThaiLamViec;
	@ManyToOne
	@JoinColumn(name = "maDC")
	private DiaChi diaChi;

	public NhanVien() {

	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	/**
	 * 
	 * @param maNV
	 * @param gioiTinh
	 * @param hoTen
	 * @param ngaySinh
	 * @param password
	 * @param quanLy
	 * @param soCMND
	 * @param soDienThoai
	 * @param trangThaiLamViec
	 * @param diaChi
	 * @param loaiNhanVien
	 */
	public NhanVien(String maNV, boolean gioiTinh, String hoTen, Date ngaySinh, String password, String soCMND,
			String soDienThoai, boolean trangThaiLamViec, DiaChi diaChi) {
		super();
		this.maNV = maNV;
		this.gioiTinh = gioiTinh;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.password = password;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.trangThaiLamViec = trangThaiLamViec;
		this.diaChi = diaChi;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public boolean isTrangThaiLamViec() {
		return trangThaiLamViec;
	}

	public void setTrangThaiLamViec(boolean trangThaiLamViec) {
		this.trangThaiLamViec = trangThaiLamViec;
	}

	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	public NhanVien(boolean gioiTinh, String hoTen, Date ngaySinh, String password, String soCMND, String soDienThoai,
			boolean trangThaiLamViec, DiaChi diaChi) {
		super();
		this.gioiTinh = gioiTinh;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.password = password;
		this.soCMND = soCMND;
		this.soDienThoai = soDienThoai;
		this.trangThaiLamViec = trangThaiLamViec;
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", gioiTinh=" + gioiTinh + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh
				+ ", password=" + password + ", soCMND=" + soCMND + ", soDienThoai=" + soDienThoai
				+ ", trangThaiLamViec=" + trangThaiLamViec + ", diaChi=" + diaChi + "]";
	}

}// end NhanVien