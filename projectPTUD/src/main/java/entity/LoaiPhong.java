package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LoaiPhong implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(columnDefinition = "varchar(5)")
	private String maLP;//
	private double giaTien;//
	@Column(columnDefinition = "nvarchar(MAX)")
	private String tenLoaiPhong;//
	@OneToMany(mappedBy = "loaiPhong")
	private List<Phong> dsPhong;
	
	public LoaiPhong(){

	}

	public LoaiPhong(String maLP, double giaTien, String tenLoaiPhong) {
		super();
		this.maLP = maLP;
		this.giaTien = giaTien;
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public String getMaLP() {
		return maLP;
	}

	public void setMaLP(String maLP) {
		this.maLP = maLP;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public void finalize() throws Throwable {

	}

	@Override
	public String toString() {
		return "LoaiPhong [maLP=" + maLP + ", giaTien=" + giaTien + ", tenLoaiPhong=" + tenLoaiPhong + "]";
	}
	
}//end LoaiPhong