package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KhuyenMai implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(7)")
	private String maKM; //
	private float chietKhau; //
	private boolean trangThai; // 
	private int daSuDung; //
	private Date ngayHetHan; //
	private Date ngayBatDau; //
	@Column(columnDefinition = "nvarchar(MAX)")
	private String moTa;
	private int tongSoLuong; //

	public KhuyenMai() {
		super();
	}

	public KhuyenMai(String maKM) {
		this.maKM = maKM;
	}

	public KhuyenMai(String maKM,float chietKhau, boolean trangThai, int daSuDung, Date ngayHetHan,
			Date ngayBatDau, String moTa, int tongSoLuong) {
		super();
		this.maKM = maKM;
		this.chietKhau = chietKhau;
		this.trangThai = trangThai;
		this.daSuDung = daSuDung;
		this.ngayHetHan = ngayHetHan;
		this.ngayBatDau = ngayBatDau;
		this.moTa = moTa;
		this.tongSoLuong = tongSoLuong;
	}

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}


	public float getChietKhau() {
		return chietKhau;
	}

	public void setChietKhau(float chietKhau) {
		this.chietKhau = chietKhau;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public int getDaSuDung() {
		return daSuDung;
	}

	public void setDaSuDung(int daSuDung) {
		this.daSuDung = daSuDung;
	}

	public Date getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getTongSoLuong() {
		return tongSoLuong;
	}

	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}

}