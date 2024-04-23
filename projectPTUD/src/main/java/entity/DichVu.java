package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DichVu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(7)")
	private String maDV;//
	private Double donGia; //
	@Column(columnDefinition = "nvarchar(50)")
	private String donViTinh;//
	@Column(columnDefinition = "nvarchar(MAX)")
	private String tenDichVu;//
	private boolean trangThaiDichVu;//
	private int soLuong; //
	private Date ngayHetHan;
	private Date ngayNhap;
	
	
	
	
	public DichVu(String maDV, Double donGia, String donViTinh, String tenDichVu, boolean trangThaiDichVu, int soLuong,
			Date ngayHetHan, Date ngayNhap) {
		super();
		this.maDV = maDV;
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.tenDichVu = tenDichVu;
		this.trangThaiDichVu = trangThaiDichVu;
		this.soLuong = soLuong;
		this.ngayHetHan = ngayHetHan;
		this.ngayNhap = ngayNhap;
	}




	public String getMaDV() {
		return maDV;
	}




	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}




	public Double getDonGia() {
		return donGia;
	}




	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}




	public String getDonViTinh() {
		return donViTinh;
	}




	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}




	public String getTenDichVu() {
		return tenDichVu;
	}




	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}




	public boolean isTrangThaiDichVu() {
		return trangThaiDichVu;
	}




	public void setTrangThaiDichVu(boolean trangThaiDichVu) {
		this.trangThaiDichVu = trangThaiDichVu;
	}




	public int getSoLuong() {
		return soLuong;
	}




	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}




	public Date getNgayHetHan() {
		return ngayHetHan;
	}




	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}




	public Date getNgayNhap() {
		return ngayNhap;
	}




	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public DichVu(Double donGia, String donViTinh, String tenDichVu, boolean trangThaiDichVu, int soLuong,
			Date ngayHetHan, Date ngayNhap) {
		super();
		this.donGia = donGia;
		this.donViTinh = donViTinh;
		this.tenDichVu = tenDichVu;
		this.trangThaiDichVu = trangThaiDichVu;
		this.soLuong = soLuong;
		this.ngayHetHan = ngayHetHan;
		this.ngayNhap = ngayNhap;
	}




	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", donGia=" + donGia + ", donViTinh=" + donViTinh + ", tenDichVu=" + tenDichVu
				+ ", trangThaiDichVu=" + trangThaiDichVu + ", soLuong=" + soLuong + ", ngayHetHan=" + ngayHetHan
				+ ", ngayNhap=" + ngayNhap + "]";
	}
	
	

	

}// end DichVu