package service;

import java.rmi.RemoteException;
import java.util.List;


import entity.NhanVien;

public interface NhanVienService {
	public List<NhanVien> layDanhSachNhanVien();

	
	public boolean  doiMatKhau(String sdt, String oldPassword, String newPassword);

	public List<NhanVien> DanhSachNhanVien();

//	public int tongTrang(String txtSearch, String gioiTinh, String trangThaiLamViec, String loaiNhanVien, int limit);

	public NhanVien layThongTinNhanVienQuaSDT(String sdt) throws RemoteException;

	public NhanVien layThongTinNhanVienQuaCMND(String cmnd) throws RemoteException;

	public List<NhanVien> layDanhSachNhanVienTheoTen(String ten);
	

	public boolean suaTrangThaiLamViecQuaSoDienThoai(String soDienThoai, boolean trangThaiLamViec)
			throws RemoteException;

	public boolean themNhanVien(NhanVien nv);

	public boolean suaThongTinNhanVien(NhanVien nv);

	public NhanVien layNhanVienTheoMa(String ma);

	public String phatSinhMaTuDong();


	int tongTrang(String txtSearch, String gioiTinh, String trangThaiLamViec, int limit);


	List<NhanVien> findNhanVien(String maNV, String tenNV, String sdt, String CMND);
}