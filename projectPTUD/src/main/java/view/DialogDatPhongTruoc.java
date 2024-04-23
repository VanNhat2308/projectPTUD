package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.PhieuDatPhongDao;
import dao.PhongDao;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;

public class DialogDatPhongTruoc extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnDatPhong;
	private JButton btnHuy;
	private JTextField tfSDTKhach;
	@SuppressWarnings("unused")
	private HoaDonDao hoaDonDao;
	private KhachHangDao khachHangDao;
	private JLabel lblTenKhach;
	private JLabel lblIconKiemTraSDT;
	private JButton btnKiemTraSDTKKhach;
	private PhongDao phongDao;
	private PhieuDatPhongDao phieuDatPhongDao;
	private Phong phong;
	boolean trangThai = false;
	private DefaultComboBoxModel<String> gioModel;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel phutModel;
	private DialogPhieuDatPhongCho dialogPhieuDatPhongCho;
	private JCheckBox cbInPhieuDat;
	private JRadioButton radioHomNay;
	private JRadioButton radioNgayMai;
	private DefaultComboBoxModel<String> cbGio;
	private DefaultComboBoxModel<String> cbPhut;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DialogDatPhongTruoc(Phong phong) {
		setModal(true);
		this.phong = phong;
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 857, 59);
		setSize(799, 535);
		getContentPane().add(panel);
		setLocationRelativeTo(null);
		panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Đặt phòng trước");
				lblNewLabel.setBounds(162, 0, 476, 59);
				panel.add(lblNewLabel);
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("Ngày nhận phòng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(81, 304, 157, 35);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ngày trả phòng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(81, 350, 157, 35);
		getContentPane().add(lblNewLabel_1_1);

		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setBackground(new Color(65, 105, 225));
		btnDatPhong.setForeground(new Color(255, 255, 255));
		btnDatPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDatPhong.setBounds(624, 450, 135, 35);
		getContentPane().add(btnDatPhong);

		btnHuy = new JButton("Hủy");
		btnHuy.setForeground(Color.WHITE);
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHuy.setBackground(new Color(128, 128, 128));
		btnHuy.setBounds(38, 450, 78, 35);
		getContentPane().add(btnHuy);

		cbInPhieuDat = new JCheckBox("In phiếu đặt");
		cbInPhieuDat.setSelected(true);
		cbInPhieuDat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbInPhieuDat.setBounds(508, 458, 106, 21);
		getContentPane().add(cbInPhieuDat);

		tfSDTKhach = new JTextField();
		tfSDTKhach.setColumns(10);
		tfSDTKhach.setBounds(248, 215, 296, 35);
		getContentPane().add(tfSDTKhach);

		lblIconKiemTraSDT = new JLabel("");
		lblIconKiemTraSDT.setBounds(177, 128, 22, 33);
		getContentPane().add(lblIconKiemTraSDT);

		JLabel lblStKhach = new JLabel("SĐT Khách:");
		lblStKhach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStKhach.setBounds(81, 212, 157, 35);
		getContentPane().add(lblStKhach);

		btnKiemTraSDTKKhach = new JButton("Kiểm tra");
		btnKiemTraSDTKKhach.setBounds(558, 215, 90, 35);
		getContentPane().add(btnKiemTraSDTKKhach);

		lblTenKhach = new JLabel("");
		lblTenKhach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenKhach.setBounds(248, 258, 220, 35);
		getContentPane().add(lblTenKhach);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Tên Khách:");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(81, 258, 157, 35);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1);
		ButtonGroup bg = new ButtonGroup();
		try {
			khachHangDao = new KhachHangDao(MainFrame.sessionFactory);
			phongDao = new PhongDao(MainFrame.sessionFactory);
			phieuDatPhongDao = new PhieuDatPhongDao(MainFrame.sessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		btnKiemTraSDTKKhach.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnHuy.addActionListener(this);
		
		JDateChooser dateNgaySinh = new JDateChooser();
		dateNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateNgaySinh.setDateFormatString("dd/MM/yyyy");
		dateNgaySinh.setBounds(248, 304, 296, 35);
		getContentPane().add(dateNgaySinh);
		
		JDateChooser dateNgaySinh_1 = new JDateChooser();
		dateNgaySinh_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateNgaySinh_1.setDateFormatString("dd/MM/yyyy");
		dateNgaySinh_1.setBounds(247, 350, 296, 35);
		getContentPane().add(dateNgaySinh_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_1_1 = new JLabel("Trạng thái:");
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setBounds(81, 120, 99, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2_1_1);
		
		JLabel lblTrangThaiPhong = new JLabel("Phòng trống");
		lblTrangThaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrangThaiPhong.setBounds(217, 120, 136, 25);
		getContentPane().add(lblTrangThaiPhong);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_2 = new JLabel("Số giường:");
		lblNewLabel_1_1_1_1_1_1_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2_2.setBounds(586, 120, 99, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2 = new JLabel("Số người:");
		lblNewLabel_1_1_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2.setBounds(350, 120, 99, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2);
		
		JLabel lblSoNguoi = new JLabel("5 Người");
		lblSoNguoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoNguoi.setBounds(393, 120, 128, 25);
		getContentPane().add(lblSoNguoi);
		
		JLabel lableSoNguoi = new JLabel("5");
		lableSoNguoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lableSoNguoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lableSoNguoi.setBounds(698, 120, 30, 25);
		getContentPane().add(lableSoNguoi);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Loại phòng:");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(81, 171, 128, 30);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		JLabel lblLoaiPhong = new JLabel("Phòng VIP");
		lblLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaiPhong.setBounds(217, 171, 136, 30);
		getContentPane().add(lblLoaiPhong);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_3 = new JLabel("Giá tiền:");
		lblNewLabel_1_1_1_1_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_3.setBounds(350, 171, 94, 30);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_3);
		
		JLabel lblGiaTien = new JLabel("100.000 VND");
		lblGiaTien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGiaTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiaTien.setBounds(431, 171, 128, 30);
		getContentPane().add(lblGiaTien);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_2_1 = new JLabel("Diện tích");
		lblNewLabel_1_1_1_1_1_1_1_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1_1_1_2_2_1.setBounds(586, 174, 99, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2_2_1);
		
		JLabel LableDienTich = new JLabel("5 m2");
		LableDienTich.setHorizontalAlignment(SwingConstants.RIGHT);
		LableDienTich.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LableDienTich.setBounds(683, 174, 45, 25);
		getContentPane().add(LableDienTich);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_1 = new JLabel("Số phòng: ");
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setBounds(318, 70, 116, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1_2_1);
		
		JLabel lblSoPhong = new JLabel("001");
		lblSoPhong.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSoPhong.setBounds(439, 70, 59, 25);
		getContentPane().add(lblSoPhong);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(337, 234, 0, 0);
		getContentPane().add(separator);
		thietLapGio();
		dialogPhieuDatPhongCho = new DialogPhieuDatPhongCho();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void thietLapGio() {
		int gio = 1;
		int phut = 0;
		if (radioHomNay.isSelected()) {
			Date date = new Date();
			gio = date.getHours();
			phut = date.getMinutes() % 5 == 0 ? date.getMinutes() : ((date.getMinutes() / 5) * 5) + 5;
			if (phut == 60) {
				gio += 1;
				phut = 5;
			}
		}
		if (gio < 8) {
			gio = 8;
		}
		gioModel.removeAllElements();
		phutModel.removeAllElements();
		for (int i = gio; i < 23; i++) {
			gioModel.addElement(i + "");
		}
		for (int i = phut; i < 60; i += 5) {
			phutModel.addElement(i + "");
		}

	}

	public KhachHang kiemTraSDTKhach() {
		String sdt = tfSDTKhach.getText().toString();
		if (sdt.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại Khách");
			lblIconKiemTraSDT.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/remove.png")));
			tfSDTKhach.selectAll();
			tfSDTKhach.requestFocus();
			return null;
		}
		if (!sdt.matches(
				"(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không đúng địng dạng");
			tfSDTKhach.selectAll();
			lblIconKiemTraSDT.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/remove1.png")));
			tfSDTKhach.requestFocus();
			return null;
		}
		KhachHang KhachHang = khachHangDao.layKhachHangTheoSDT(sdt);
		if (KhachHang == null) {
			int xacNhan = JOptionPane.showConfirmDialog(this,
					"Khách hàng không có trong hệ thống, Bạn có muốn thêm khách hàng không", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			lblIconKiemTraSDT.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/remove1.png")));
			if (xacNhan == JOptionPane.YES_OPTION) {
				DialogThemKhachHang dialogThemKhachHang = new DialogThemKhachHang(sdt);
				dialogThemKhachHang.setVisible(true);
				if (DialogThemKhachHang.khachHang == null) {
					dialogThemKhachHang.dispose();
					return null;
				}
				dialogThemKhachHang.dispose();
				KhachHang = DialogThemKhachHang.khachHang;
			}
		}
		lblTenKhach.setText(KhachHang.getHoTen());
		lblIconKiemTraSDT.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/true.png")));
		return KhachHang;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object.equals(btnKiemTraSDTKKhach)) {
			if (kiemTraSDTKhach() == null) {
				lblIconKiemTraSDT.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/remove1.png")));
			}
			return;
		}
		if (object.equals(btnDatPhong)) {
			KhachHang khachHang = kiemTraSDTKhach();
			int gio = Integer.parseInt(cbGio.getSelectedItem().toString());
			int phut = Integer.parseInt(cbPhut.getSelectedItem().toString());
			Date date = new Date();
			if (radioHomNay.isSelected()) {
				if (gio < date.getDay() || (gio == date.getHours() && phut < date.getMinutes())) {
					JOptionPane.showMessageDialog(this, "Thời gian phải trước thời gian hiện tại");
					return;
				}
			} else {
				// add one day
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.DATE, 1);
				date = c.getTime();
			}
			date.setMinutes(phut);
			date.setHours(gio);
			if (khachHang == null)
				return;
			int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn đặt phòng chờ không ", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (xacNhan != JOptionPane.YES_OPTION) {
				return;
			}
			PhieuDatPhong phieuDatPhong = new PhieuDatPhong(khachHang, MainFrame.nhanVien, phong,date);
			if (!phongDao.capNhatTrangThaiPhong(phong.getMaPhong(), MainFrame.maPhongCho)
					|| !phieuDatPhongDao.themPhieuDatPhong(phieuDatPhong)) {
				JOptionPane.showMessageDialog(this, "Đặt phòng KHÔNG thành công");
				setVisible(false);
				dispose();
				return;
			}
			if (cbInPhieuDat.isSelected()) {
				dialogPhieuDatPhongCho.khoiTao(phieuDatPhong);
				dialogPhieuDatPhongCho.xuatFile();

			} else
				JOptionPane.showMessageDialog(this, "Đặt phòng thành công");

			trangThai = true;
			setVisible(false);
			dispose();
		}
		if (object.equals(btnHuy)) {
			setVisible(false);
			dispose();
		}
		if (object.equals(radioHomNay) || object.equals(radioNgayMai)) {
			thietLapGio();
		}
	}
}