package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.PhieuDatPhongDao;
import dao.PhongDao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;

import view.util.FormatCustom;
import com.toedter.calendar.JDateChooser;

public class DialogDatPhong extends JDialog implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private JTextField tfSDTKhach;
	private Phong phong;
	private JLabel lblLoaiPhong;
	private JButton btnKiemTraSDTKKhach;
	private JLabel lblIconKiemTraSDT;
	private JLabel lblTenKhach;
	private JButton btnXacNhan;
	private HoaDonDao hoaDonDao;
	private KhachHangDao khachHangDao;
	private KhachHang khachHang;
	private HoaDon hoaDon;
	private PhieuDatPhongDao phieuDatPhongDao;
	private PhongDao phongDao;
	private PhieuDatPhong phieuDatPhong;
	private JLabel lblSoPhong;
	private JLabel lblSoNguoi;
	private JLabel lblGiaTien;
	private JLabel lblTrangThaiPhong;
	private JLabel lableSoNguoi;
	private JLabel LableDienTich;
	private JDateChooser dateNgaySinh;

	public DialogDatPhong() {
		setModal(true);

		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 945, 50);
		setSize(961, 535);
		getContentPane().add(panel);
		panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Đặt phòng");
				lblNewLabel.setBounds(65, 0, 836, 50);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(new Color(255, 255, 255));
		setLocationRelativeTo(null);

		lblLoaiPhong = new JLabel("Phòng VIP");
		lblLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiPhong.setBounds(220, 161, 136, 30);
		getContentPane().add(lblLoaiPhong);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Loại phòng:");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(82, 161, 128, 30);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("SĐT Khách:");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(194, 215, 112, 30);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_1);

		lblIconKiemTraSDT = new JLabel("");
		lblIconKiemTraSDT.setIcon(new ImageIcon(DialogDatPhong.class.getResource("/icon/check.png")));
		lblIconKiemTraSDT.setBounds(332, 215, 16, 30);
		getContentPane().add(lblIconKiemTraSDT);

		tfSDTKhach = new JTextField("0945601331");
		tfSDTKhach.setColumns(10);
		tfSDTKhach.setBounds(351, 215, 267, 30);
		getContentPane().add(tfSDTKhach);

		btnKiemTraSDTKKhach = new JButton("Kiểm tra");
		btnKiemTraSDTKKhach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKiemTraSDTKKhach.setBounds(628, 215, 116, 30);
		getContentPane().add(btnKiemTraSDTKKhach);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1 = new JLabel("Tên khách:");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_1_1.setBounds(193, 276, 99, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_1_1);

		btnXacNhan = new JButton("Đặt phòng");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXacNhan.setBackground(new Color(0, 128, 0));
		btnXacNhan.setForeground(new Color(255, 255, 255));
		btnXacNhan.setBounds(757, 438, 107, 35);
		getContentPane().add(btnXacNhan);

		lblTenKhach = new JLabel("Nguyễn Hoàng Khánh");
		lblTenKhach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenKhach.setBounds(350, 276, 283, 25);
		getContentPane().add(lblTenKhach);

		lblSoNguoi = new JLabel("5 Người");
		lblSoNguoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoNguoi.setBounds(486, 110, 128, 25);
		getContentPane().add(lblSoNguoi);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2 = new JLabel("Số người:");
		lblNewLabel_1_1_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2.setBounds(405, 110, 99, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_1 = new JLabel("Số phòng: ");
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setBounds(405, 61, 116, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2_1);

		lblSoPhong = new JLabel("001");
		lblSoPhong.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSoPhong.setBounds(526, 61, 59, 25);
		getContentPane().add(lblSoPhong);

		lblGiaTien = new JLabel("100.000 VND");
		lblGiaTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaTien.setBounds(486, 161, 128, 30);
		getContentPane().add(lblGiaTien);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_3 = new JLabel("Giá tiền:");
		lblNewLabel_1_1_1_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_3.setBounds(405, 161, 94, 30);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_3);

		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnQuayLi.setForeground(Color.WHITE);
		btnQuayLi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnQuayLi.setBackground(SystemColor.textHighlight);
		btnQuayLi.setBounds(82, 438, 99, 35);
		getContentPane().add(btnQuayLi);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_1_1 = new JLabel("Trạng thái:");
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setBounds(82, 110, 99, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2_1_1);

		lblTrangThaiPhong = new JLabel("Phòng trống");
		lblTrangThaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrangThaiPhong.setBounds(218, 110, 136, 25);
		getContentPane().add(lblTrangThaiPhong);
		
	    dateNgaySinh = new JDateChooser();
		dateNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateNgaySinh.setBounds(349, 320, 269, 35);
		getContentPane().add(dateNgaySinh);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("Ngày trả phòng:");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1.setBounds(160, 318, 146, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_2 = new JLabel("Số giường:");
		lblNewLabel_1_1_1_1_1_1_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2_2.setBounds(703, 110, 99, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2_2);
		
	    lableSoNguoi = new JLabel("5");
		lableSoNguoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lableSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lableSoNguoi.setBounds(834, 110, 30, 25);
		getContentPane().add(lableSoNguoi);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_2_1 = new JLabel("Diện tích:");
		lblNewLabel_1_1_1_1_1_1_1_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2_2_1.setBounds(703, 164, 99, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2_2_1);
		
	     LableDienTich = new JLabel("5 m2");
		LableDienTich.setHorizontalAlignment(SwingConstants.RIGHT);
		LableDienTich.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LableDienTich.setBounds(812, 164, 45, 25);
		getContentPane().add(LableDienTich);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(366, 110, 9, 84);
		getContentPane().add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(638, 110, 9, 84);
		getContentPane().add(panel_1_1);

		hoaDonDao = new HoaDonDao(MainFrame.sessionFactory);
		khachHangDao = new KhachHangDao(MainFrame.sessionFactory);
		phieuDatPhongDao = new PhieuDatPhongDao(MainFrame.sessionFactory);
		phongDao = new PhongDao(MainFrame.sessionFactory);

		btnKiemTraSDTKKhach.addActionListener(this);
		btnXacNhan.addActionListener(this);
		tfSDTKhach.addKeyListener(this);

	}
	public String covertTrangThai(String TrangThaiPhong) {
		if(TrangThaiPhong.equalsIgnoreCase("TTP001")) 
			return "Phòng Bận";
		else if(TrangThaiPhong.equalsIgnoreCase("TTP003")) 
			return "Phòng Trống";
		return "Phòng chờ";
	}

	@SuppressWarnings("deprecation")
	public void khoiTao(Phong phong) {
		this.phong = phong;
		phieuDatPhong = null;
		hoaDon = null;
		lblTenKhach.setText("");
		tfSDTKhach.setText("");
		lblSoPhong.setText(phong.getMaPhong().substring(1));
		lableSoNguoi.setText(phong.getSoNguoi() + " người");
		lblGiaTien.setText(FormatCustom.chuyenDoiTienTe(phong.getLoaiPhong().getGiaTien()));
		lblLoaiPhong.setText(phong.getLoaiPhong().getTenLoaiPhong());
		lblTrangThaiPhong.setText(covertTrangThai(phong.getTrangThaiPhong().strip()));
		LableDienTich.setText(phong.getDienTich()+" "+"m2");
		lblIconKiemTraSDT.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/check.png")));
		if (phong.getTrangThaiPhong().equals(MainFrame.maPhongCho)) {
			Date now = new Date();
			phieuDatPhong = phieuDatPhongDao.layPhieuDatPhongMoiNhatTheoPhong(phong.getMaPhong());
			if (now.getDay() == phieuDatPhong.getNgayNhanPhong().getDay()
					&& now.getHours() >= phieuDatPhong.getNgayNhanPhong().getHours() - 2) {
				JOptionPane.showMessageDialog(this,
						"Hiện tại bạn KHÔNG được phép đặt phòng này do có khách sắp tới nhận phòng");
				this.setVisible(false);
				hoaDon = null;
				phieuDatPhong = null;
				phong = null;
				return;
				
			}
		}
		this.setVisible(true);
	}

	public boolean kiemTraSDTKhach() {
		String sdt = tfSDTKhach.getText().toString();
		if (sdt.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại Khách");
			tfSDTKhach.selectAll();
			tfSDTKhach.requestFocus();
			return false;
		}
		if (!sdt.matches(
				"(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không đúng địng dạng");
			tfSDTKhach.selectAll();
			tfSDTKhach.requestFocus();
			return false;
		}
		khachHang = khachHangDao.layKhachHangTheoSDT(sdt);
		if (khachHang == null) {
			int xacNhan = JOptionPane.showConfirmDialog(this,
					"Khách hàng không có trong hệ thống, Bạn có muốn thêm khách hàng không", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (xacNhan == JOptionPane.YES_OPTION) {
				DialogThemKhachHang dialogThemKhachHang = new DialogThemKhachHang(sdt);
				dialogThemKhachHang.setVisible(true);
				if (DialogThemKhachHang.khachHang == null) {
					dialogThemKhachHang.dispose();
					return false;
				}
				dialogThemKhachHang.dispose();
				khachHang = DialogThemKhachHang.khachHang;
			}
		}
		lblTenKhach.setText(khachHang.getHoTen());
		lblIconKiemTraSDT.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/true.png")));
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(btnKiemTraSDTKKhach)) {
			kiemTraSDTKhach();
			return;
		}
		if (object.equals(btnXacNhan)) {
			if (!kiemTraSDTKhach()) {
				return;
			}
			int n = JOptionPane.showConfirmDialog(null, "Xác nhận đặt phòng " + phong.getMaPhong().substring(1),
					"Thông báo", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				// đặt phòng tạm
				if (phieuDatPhong != null) {
					@SuppressWarnings("unused")
					Date now = new Date();
					JOptionPane.showMessageDialog(this, "Vui lòng thông báo cho khách TRẢ PHÒNG trước "
							+ FormatCustom.dinhDanhThoiGian(phieuDatPhong.getNgayNhanPhong()));
					phong.setTrangThaiPhong("TTP001");
					phongDao.capNhatTrangThaiPhong(phong.getMaPhong(), MainFrame.maPhongTam);
				} else {
					phong.setTrangThaiPhong("TTP001");
					System.out.println(phong.getTrangThaiPhong());
					phongDao.capNhatTrangThaiPhong(phong.getMaPhong(), MainFrame.maPhongBan);
				}
               
				// Lấy ngày từ JDateChooser
				Date ngayNhap = dateNgaySinh.getDate();
				Date now = new Date();
				boolean k = true;
				// Kiểm tra nếu ngày nhập nhỏ hơn ngày hiện tại
				if (ngayNhap != null && ngayNhap.before(now)) {
				    // Hiển thị thông báo
				    JOptionPane.showMessageDialog(null, "Ngày trả phòng không được nhỏ hơn ngày nhận phòng");
				    return;
				}
				
					
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(dateNgaySinh.getDate());

					// Đặt giờ, phút và giây thành 12 giờ trưa
					calendar.set(Calendar.HOUR_OF_DAY, 14);
					calendar.set(Calendar.MINUTE, 0);
					calendar.set(Calendar.SECOND, 0);

					// Đặt ngày được chọn từ JDateChooser lại với giờ, phút và giây đã thiết lập
					dateNgaySinh.setDate(calendar.getTime());
				
				
				
				hoaDon = new HoaDon(MainFrame.nhanVien,dateNgaySinh.getDate(), MainFrame.khuyenMaiMacDinh, khachHang);
				System.out.println(hoaDon.getMaHD());
				hoaDon.setChiTietHoaDon(Arrays.asList(new ChiTietHoaDon(phong, hoaDon, new Date(0))));
				System.out.println(hoaDon.getChiTietHoaDon());
				if (hoaDonDao.themHoaDon(hoaDon)) {
					System.out.println("add Bill success");
					setVisible(false);
					dispose();
				} else {
					System.out.println("add Bill fail");
					hoaDon = null;
				}
			}
		}
	}

	public HoaDon getHoaDon() {

		return hoaDon;
	}

	public Phong getPhong() {
		return phong;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(tfSDTKhach)) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				btnKiemTraSDTKKhach.doClick();
				System.out.println(lblIconKiemTraSDT.getIcon().toString());
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}