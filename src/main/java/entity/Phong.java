package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author  Nguyễn Thanh Sơn, Phan Thành Công, Nguyễn Thị Minh Châu
 * @version 1.0
 * @created 25-Oct-2021 9:18:53 PM
 */
@Entity
public class Phong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(4)")
	private String maPhong;//
	private int soNguoi;//
	private boolean tinhTrangPhong;//
	@ManyToOne
	@JoinColumn(name = "maLP")
	private LoaiPhong loaiPhong;//
    private Float dienTich;
    private Integer soGiuong;
    private Integer tang;
    private String TrangThaiPhong;

	public Phong() {

	}

	public Phong(String maPhong) {
		this.maPhong = maPhong;
	}

	public void finalize() throws Throwable {

	}


	

	public Phong(String maPhong, int soNguoi, boolean tinhTrangPhong, LoaiPhong loaiPhong, float dienTich, int soGiuong,
			int tang, String trangThaiPhong) {
		super();
		this.maPhong = maPhong;
		this.soNguoi = soNguoi;
		this.tinhTrangPhong = tinhTrangPhong;
		this.loaiPhong = loaiPhong;
		this.dienTich = dienTich;
		this.soGiuong = soGiuong;
		this.tang = tang;
		TrangThaiPhong = trangThaiPhong;
	}

	
	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public int getSoNguoi() {
		return soNguoi;
	}

	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}

	public boolean isTinhTrangPhong() {
		return tinhTrangPhong;
	}

	public void setTinhTrangPhong(boolean tinhTrangPhong) {
		this.tinhTrangPhong = tinhTrangPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public float getDienTich() {
		return dienTich;
	}

	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}

	public int getSoGiuong() {
		return soGiuong;
	}

	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}

	public int getTang() {
		return tang;
	}

	public void setTang(int tang) {
		this.tang = tang;
	}

	public String getTrangThaiPhong() {
		return TrangThaiPhong;
	}

	public void setTrangThaiPhong(String trangThaiPhong) {
		TrangThaiPhong = trangThaiPhong;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", soNguoi=" + soNguoi + ", tinhTrangPhong=" + tinhTrangPhong
				+ ", loaiPhong=" + loaiPhong + ", dienTich=" + dienTich + ", soGiuong=" + soGiuong + ", tang=" + tang
				+ ", TrangThaiPhong=" + TrangThaiPhong + "]";
	}

	

	
}// end Phong