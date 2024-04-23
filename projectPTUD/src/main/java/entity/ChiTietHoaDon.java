package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@Entity
@IdClass(ChiTietHoaDonPK.class)
public class ChiTietHoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "maPhong" ,columnDefinition = "varchar(4)")
	private Phong phong;	//
	@Id
	@ManyToOne
	@JoinColumn(name = "maHD",columnDefinition = "varchar(7)")
	private HoaDon hoaDon;//
	private Date thoiLuong;//

	public ChiTietHoaDon(){

	}
	public void finalize() throws Throwable {

	}
	public double thanhTien(){
		return (getThoiLuong().getHours()/60.0)*phong.getLoaiPhong().getGiaTien();
	}
	public ChiTietHoaDon(Phong phong, HoaDon hoaDon, Date thoiLuong) {
		super();
		this.phong = phong;
		this.hoaDon = hoaDon;
		this.thoiLuong = thoiLuong;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Date getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(Date thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [phong=" + phong + ", hoaDon=" + hoaDon + ", thoiLuong=" + thoiLuong + "]";
	}
//	public void capNhatThoiLuongThue(Date thoiGianNhanPhong) {
//	    // Lấy thời gian hiện tại
//	    Date thoiGianHienTai = new Date();
//
//	    // Tạo đối tượng SimpleDateFormat để định dạng thời gian
////	
//    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
//	    // Tính thời lượng thuê
//	    long thoiLuong = thoiGianHienTai.get - thoiGianNhanPhong;
//
//	    // Chuyển thời lượng thuê thành chuỗi định dạng
////	    String thoiLuongThue = sdf.format(thoiLuongMillis);
//
//	    // Cập nhật thời lượng thuê vào chi tiết hóa đơn
//	    this.setThoiLuong(thoiLuong);
//	}
	public void capNhatThoiLuongThue(Date thoiGianNhanPhong) {
	    // Lấy thời gian hiện tại
	    Date thoiGianHienTai = new Date();

	    // Chuyển đổi thời gian nhận phòng và thời gian hiện tại sang kiểu LocalDateTime
	    // để sử dụng trong lớp Duration
	    long thoiGianNhanPhongMillis = thoiGianNhanPhong.getTime();
	    long thoiGianHienTaiMillis = thoiGianHienTai.getTime();

	    // Tính thời lượng thuê bằng Duration
	    Duration thoiLuong = Duration.ofMillis(thoiGianHienTaiMillis - thoiGianNhanPhongMillis);

	    // Cập nhật thời lượng thuê vào chi tiết hóa đơn
	    this.setThoiLuong(new Date(thoiLuong.toMillis()));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDon == null) ? 0 : hoaDon.hashCode());
		result = prime * result + ((phong == null) ? 0 : phong.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		if (hoaDon == null) {
			if (other.hoaDon != null)
				return false;
		} else if (!hoaDon.equals(other.hoaDon))
			return false;
		if (phong == null) {
			if (other.phong != null)
				return false;
		} else if (!phong.equals(other.phong))
			return false;
		return true;
	}
	
}//end ChiTietHoaDon