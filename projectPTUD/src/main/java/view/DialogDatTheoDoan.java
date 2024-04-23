package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.KhuyenMaiDao;
import dao.PhongDao;
import entity.ChiTietDichVu;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhuyenMai;
import entity.Phong;
import view.util.FormatCustom;
import javax.swing.JToggleButton;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;

public class DialogDatTheoDoan extends JDialog{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JTable tableChiTiet = new JTable();
	private final JTable tableChiTiet1 = new JTable();
	private final JTable tableChiTiet2 = new JTable();
	private final JTable tableChiTiet3 = new JTable();
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane1;
	private JScrollPane scrollPane_1_1;
	private JScrollPane scrollPane_1_1_1;
//	private HoaDonDao hoaDonDao;
	private HoaDon hoaDon;
	private double tongTienDichVu;
	private double tongTienPhong;
	private JButton btnQuayLai;
	private KhuyenMaiDao khuyenMaiDao;
	private HoaDonDao hoaDonDao;
	private double tienThanhToan;
	private JLabel lblTienThanhToan;
	private Phong phong;
	static boolean trangThai;
	private PhongDao phongDao;
	private JTextField textField;

	public DialogDatTheoDoan(HoaDon hoaDon, Phong phong) {
		this.hoaDon = hoaDon;
		this.phong = phong;
		setVisible(true);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);

		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 1338, 735);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(SystemColor.textHighlightText);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1324, 50);
		panel.setBackground(new Color(0, 206, 209));
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3_1 = new JLabel("ĐẶT THEO ĐOÀN");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3_1.setBackground(Color.CYAN);
		lblNewLabel_3_1.setBounds(536, 0, 279, 50);
		panel.add(lblNewLabel_3_1);

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBounds(10, 652, 100, 40);
		btnQuayLai.setForeground(Color.WHITE);
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuayLai.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		btnQuayLai.setBackground(new Color(30, 144, 255));
		contentPanel.add(btnQuayLai);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 79, 435, 535);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 42, 435, 502);
		panel_1.add(scrollPane);

		tableChiTiet.setModel(tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Số thứ tự", "Tên phòng", "Đơn giá" }));
		scrollPane.setViewportView(tableChiTiet);
		tableChiTiet.setEnabled(false);
		tableChiTiet.setRowHeight(40);

		Label label = new Label("Danh Sách Phòng Trống");
		label.setBounds(10, 0, 222, 41);
		label.setForeground(Color.BLUE);
		label.setBackground(UIManager.getColor("Button.background"));
		label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_1.add(label);

		Panel panel_2 = new Panel();
		panel_2.setBounds(467, 79, 400, 35);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Khách hàng");
		lblNewLabel.setBounds(0, 0, 59, 35);
		panel_2.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Tran Thanh Duc", "Nguyen Van Hien" }));
		comboBox.setBounds(66, 0, 278, 35);
		panel_2.add(comboBox);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(354, 0, 35, 35);
		panel_2.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(DialogDatTheoDoan.class.getResource("/icon/exchange.png")));

		Panel panel_2_1 = new Panel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(467, 120, 193, 35);
		contentPanel.add(panel_2_1);

		JLabel lblNgyt = new JLabel("Ngày đặt");
		lblNgyt.setBounds(0, 0, 53, 35);
		panel_2_1.add(lblNgyt);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(66, 0, 127, 35);
		panel_2_1.add(comboBox_1);

		Panel panel_2_1_1 = new Panel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(677, 120, 190, 35);
		contentPanel.add(panel_2_1_1);

		JLabel lblNgyTr = new JLabel("Ngày trả");
		lblNgyTr.setBounds(0, 0, 58, 35);
		panel_2_1_1.add(lblNgyTr);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(56, 0, 124, 35);
		panel_2_1_1.add(comboBox_1_1);

		Panel panel_2_1_2 = new Panel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBounds(467, 161, 400, 35);
		contentPanel.add(panel_2_1_2);

		textField = new JTextField();
		textField.setBounds(67, 0, 323, 35);
		panel_2_1_2.add(textField);
		textField.setColumns(10);

		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setBounds(0, 0, 63, 35);
		panel_2_1_2.add(lblGhiCh);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(879, 79, 435, 535);
		contentPanel.add(panel_1_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 42, 435, 502);
		panel_1_1.add(scrollPane_1);

		tableChiTiet1.setModel(
				tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "", "TÊN SP - DV", "Đơn giá" }));
		scrollPane_1.setViewportView(tableChiTiet1);
		tableChiTiet1.setEnabled(false);
		tableChiTiet1.setRowHeight(40);

		Label label_1 = new Label("Sản Phẩm - Dịch Vụ");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_1.setBackground(UIManager.getColor("Button.background"));
		label_1.setBounds(10, 0, 222, 41);
		panel_1_1.add(label_1);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(467, 202, 391, 168);
		contentPanel.add(panel_1_1_1);

		Label label_1_1 = new Label("Danh sách phòng đặt");
		label_1_1.setForeground(Color.BLUE);
		label_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_1_1.setBackground(UIManager.getColor("Button.background"));
		label_1_1.setBounds(10, 0, 222, 29);
		panel_1_1_1.add(label_1_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 35, 371, 133);
		panel_1_1_1.add(scrollPane_1_1);

		tableChiTiet2.setModel(
				tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "TÊN SP - DV", "Đơn giá" }));
		scrollPane_1_1.setViewportView(tableChiTiet2);
		tableChiTiet2.setEnabled(false);
		tableChiTiet2.setRowHeight(40);

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBounds(467, 380, 391, 168);
		contentPanel.add(panel_1_1_1_1);

		Label label_1_1_1 = new Label("Danh sách sản phẩm dịch vụ");
		label_1_1_1.setForeground(Color.BLUE);
		label_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_1_1_1.setBackground(UIManager.getColor("Button.background"));
		label_1_1_1.setBounds(10, 0, 222, 29);
		panel_1_1_1_1.add(label_1_1_1);

		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setBounds(10, 35, 371, 133);
		panel_1_1_1_1.add(scrollPane_1_1_1);

		tableChiTiet3.setModel(tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Phòng", "Tên SP - DV", "Đơn giá", "Thành Tiền" }));
		scrollPane_1_1_1.setViewportView(tableChiTiet3);
		tableChiTiet3.setEnabled(false);
		tableChiTiet3.setRowHeight(40);

		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBounds(467, 560, 391, 111);
		contentPanel.add(panel_1_1_1_1_1);

		Label label_1_1_1_1 = new Label("Tổng thanh toán");
		label_1_1_1_1.setForeground(Color.BLUE);
		label_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_1_1_1_1.setBackground(UIManager.getColor("Button.background"));
		label_1_1_1_1.setBounds(10, 0, 222, 29);
		panel_1_1_1_1_1.add(label_1_1_1_1);

		JPanel panel_15 = new JPanel();
		panel_15.setBounds(10, 49, 300, 25);
		panel_1_1_1_1_1.add(panel_15);
		panel_15.setBackground(SystemColor.textHighlightText);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("Tiền thanh toán:");
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1.setBackground(SystemColor.textHighlightText);
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1.setBounds(0, 0, 119, 25);
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblTienThanhToan = new JLabel("8.550.000 VND");
		lblTienThanhToan.setBackground(SystemColor.textHighlightText);
		lblTienThanhToan.setBounds(129, 0, 160, 25);
		lblTienThanhToan.setForeground(Color.RED);
		lblTienThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_15.setLayout(null);
		panel_15.add(lblNewLabel_1_1_1_1_1_1_1_1_1_1_1_1);
		panel_15.add(lblTienThanhToan);

		// khong cho sua table
		tableChiTiet.setDefaultEditor(Object.class, null);
//
//		hienThiChiTiet();
//		btnQuayLai.addActionListener(this);
//		khuyenMaiDao = new KhuyenMaiDao(MainFrame.sessionFactory);
//		hoaDonDao = new HoaDonDao(MainFrame.sessionFactory);
//		new KhachHangDao(MainFrame.sessionFactory);
//		phongDao = new PhongDao(MainFrame.sessionFactory);
//		new PhongDao(MainFrame.sessionFactory);
//
//	}

//	public void hienThiChiTiet() {
//		for (int i = tableModel.getRowCount(); i > 0; i--) {
//			tableModel.removeRow(0);
//		}
//		int i = 1;
//		this.tongTienDichVu = 0;
//		this.tongTienPhong = 0;
//		int thoiLuong = 0;
//		// *** need call function the first
//		hoaDon.setGioKetThuc(new Date());
//		thoiLuong = hoaDon.capNhatThoiLuong(phong.getMaPhong());
//		tienThanhToan = hoaDon.thanhTien();
//		lblTienThanhToan.setText(FormatCustom.chuyenDoiTienTe(tienThanhToan));
//
//		for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDon()) {
//			tableModel.addRow(new String[] { Integer.toString(i++),
//					"Phòng số: " + chiTietHoaDon.getPhong().getMaPhong().substring(1),
//					FormatCustom.dinhDangGio(chiTietHoaDon.getThoiLuong()),
//					FormatCustom.chuyenDoiTienTe(chiTietHoaDon.getPhong().getLoaiPhong().getGiaTien()), " ",
//					FormatCustom.chuyenDoiTienTe(chiTietHoaDon.thanhTien()) });
//			tongTienPhong += chiTietHoaDon.thanhTien();
//		}
//
//		if (thoiLuong < 60) {
//			double sum = hoaDon.getChiTietHoaDon().get(0).getPhong().getLoaiPhong().getGiaTien()
//					* ((60 - thoiLuong) / 60.0);
//			tableModel.setValueAt(FormatCustom.chuyenDoiTienTe(sum + hoaDon.getChiTietHoaDon().get(0).thanhTien()), 0,
//					5);
//			tongTienPhong = tongTienPhong + sum;
//		}
//		if (hoaDon.getChiTietDichVu() != null) {
//			for (ChiTietDichVu chiTietDichVu : hoaDon.getChiTietDichVu()) {
//				tableModel.addRow(new String[] { Integer.toString(i++), chiTietDichVu.getDichVu().getTenDichVu(),
//						Integer.toString(chiTietDichVu.getSoLuong()),
//						FormatCustom.chuyenDoiTienTe(chiTietDichVu.getDichVu().getDonGia()),
//						chiTietDichVu.getDichVu().getDonViTinh(),
//						FormatCustom.chuyenDoiTienTe(chiTietDichVu.thanhTien()) });
//				tongTienDichVu += chiTietDichVu.thanhTien();
//			}
//		}
//
//		if (hoaDon.getKhachHang() != null
//				&& !hoaDon.getKhachHang().getMaKH().equals(MainFrame.khachHangMacDinh.getMaKH())) {
////			AbstractButton lblSDTKhach;
////			lblSDTKhach.setText(hoaDon.getKhachHang().getSoDienThoai());
////			AbstractButton lblTenKhach;
////			lblTenKhach.setText(hoaDon.getKhachHang().getHoTen());
//		}
//
//		if (hoaDon.getKhuyenMai() != null
//				&& !hoaDon.getKhuyenMai().getMaKM().equals((MainFrame.khuyenMaiMacDinh.getMaKM()))) {
//			AbstractButton tfMaGiamGia;
//			tfMaGiamGia.setText(hoaDon.getKhuyenMai().getMaKM());
//			AbstractButton lblIconMaGiamGia;
//			lblIconMaGiamGia.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/true.png")));
//			AbstractButton lblChietKhau;
//			lblChietKhau.setText(hoaDon.getKhuyenMai().getChietKhau() + "%");
//		}
//
//	}
//
//	public boolean kiemTraTienNhan() {
//		String txtTienNhan = tfTienNhan.getText().toString();
//		if (!txtTienNhan.matches("[0-9]+")) {
//			lblIconTienNhan.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/remove1.png")));
////			JOptionPane.showMessageDialog(this, "Tiền nhận phải là số và lớn hơn 0");
////			JOptionPane.showMessageDialog(this, "Tiền nhận phải là số và không âm");
//			lblTienThua.setText("");
//			return false;
//		}
//		double tienThua = Long.parseLong(txtTienNhan) - tienThanhToan;
//		if (tienThua < 0 && tienThua != 0) {
//			lblIconTienNhan.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/remove1.png")));
//			lblTienThua.setText("");
//			return false;
//		}
//		lblIconTienNhan.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/true.png")));
//		lblTienThua.setText(FormatCustom.chuyenDoiTienTe(tienThua));
//		return true;
//	}
//
//	@SuppressWarnings("deprecation")
//	public boolean kiemTraMaGiamGia() {
//		String maGiamGia = tfMaGiamGia.getText().toString().trim();
//		if (maGiamGia.equals("")) {
//			hoaDon.setKhuyenMai(MainFrame.khuyenMaiMacDinh);
//			return true;
//		}
//		KhuyenMai khuyenMai = null;
//		try {
//			khuyenMai = khuyenMaiDao.layKhuyenMaiTheoMa(maGiamGia);
//		} catch (Exception e) {
//
//		}
//		if (khuyenMai == null) {
//			JOptionPane.showMessageDialog(this, "Mã khuyến mãi không tồn tại. Bạn có thể nhập lại hoặc bỏ trống");
//			lblIconMaGiamGia.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/remove1.png")));
//			hoaDon.setKhuyenMai(MainFrame.khuyenMaiMacDinh);
//			tfMaGiamGia.selectAll();
//			tfMaGiamGia.setFocusable(true);
//			return false;
//		}
//		if (khuyenMai.getDaSuDung() >= khuyenMai.getTongSoLuong()) {
//			JOptionPane.showMessageDialog(this, "Mã giảm giá này đã được sử dụng hết");
//			tfMaGiamGia.selectAll();
//			tfMaGiamGia.setFocusable(true);
//			return false;
//		}
//		if (!khuyenMai.isTrangThai()) {
//			JOptionPane.showMessageDialog(this, "Mã giảm giá này đã hết hiệu lực");
//			tfMaGiamGia.selectAll();
//			tfMaGiamGia.setFocusable(true);
//			return false;
//		}
//		if (!khuyenMai.getNgayBatDau().before(new Date()) || !khuyenMai.getNgayHetHan().after(new Date())) {
//			JOptionPane.showMessageDialog(this, String.format("Mã giảm giá chỉ áp dụng từ ngày %s Đến %s",
//					khuyenMai.getNgayBatDau().toLocaleString(), khuyenMai.getNgayHetHan().toLocaleString()));
//			tfMaGiamGia.selectAll();
//			tfMaGiamGia.setFocusable(true);
//			return false;
//		}
//		lblIconMaGiamGia.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/true.png")));
//		hoaDon.setKhuyenMai(khuyenMai);
//		lblChietKhau.setText(khuyenMai.getChietKhau() + "%");
//		tienThanhToan = hoaDon.thanhTien();
//		lblTienThanhToan.setText(FormatCustom.chuyenDoiTienTe(tienThanhToan));
//		tfTienNhan.setFocusable(true);
//		return true;
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object object = e.getSource();
//		if (object.equals(btnQuayLai)) {
//			setVisible(false);
//			dispose();
//		}
//
//		if (object.equals(btnKiemTraMaGiamGia)) {
//			if (tfMaGiamGia.getText().toString().trim().equalsIgnoreCase("")) {
//				lblIconMaGiamGia.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/check.png")));
//				hoaDon.setKhuyenMai(MainFrame.khuyenMaiMacDinh);
//			} else if (!kiemTraMaGiamGia()) {
//				lblIconMaGiamGia.setIcon(new ImageIcon(ChiTietPhongPanel.class.getResource("/icon/remove1.png")));
//				tfMaGiamGia.setFocusable(true);
//			}
//			hoaDonDao.capNhatHoaDon(hoaDon);
//			return;
//		}
//		if (object.equals(btnThanhToan)) {
//
//			if (!kiemTraMaGiamGia()) {
//				return;
//			}
//			if (!kiemTraTienNhan()) {
//				JOptionPane.showMessageDialog(this, "Bạn chưa nhập tiền nhận hoặc số tiền nhận không hợp lệ");
//				return;
//			}
//			int xacnhan = JOptionPane.showConfirmDialog(this,
//					"Xác nhận tính tiền phòng: " + phong.getMaPhong().substring(1), "Thông báo",
//					JOptionPane.YES_NO_OPTION);
//			if (xacnhan != JOptionPane.YES_OPTION) {
//				return;
//			}
//			// suptraction quantity "voucher discount(Mã Giảm giá)"
//			if (!hoaDon.getKhuyenMai().equals(MainFrame.khuyenMaiMacDinh)) {
//				// it differen default voucher discount
//				if (!khuyenMaiDao.apDungMaGiamGia(hoaDon.getKhuyenMai().getMaKM())) {
//					JOptionPane.showMessageDialog(this, "Không thể áp dụng mã giảm giá này");
//					return;
//				}
//			}
//
//			hoaDon.setTienKhachTra(Long.parseLong(tfTienNhan.getText().trim()));
//			hoaDon.setTongTien(tienThanhToan);
//			hoaDon.setTrangThai(true);
//			hoaDonDao.capNhatHoaDon(hoaDon);
//
//			if (phong.getTrangThaiPhong().equalsIgnoreCase(MainFrame.maPhongTam)) {
//				phong.setTrangThaiPhong("PC0001");
//				phongDao.capNhatTrangThaiPhong(phong.getMaPhong(), MainFrame.maPhongCho);
//			} else {
//				phong.setTrangThaiPhong("PC001");
//				phongDao.capNhatTrangThaiPhong(phong.getMaPhong(), MainFrame.maPhongTrong);
//			}
//			JOptionPane.showMessageDialog(this, "Tính tiền thành công");
//
//			if (checkboxInHoaDon.isSelected()) {
//				DialogChiTietHoaDon dialogChiTietHoaDon = new DialogChiTietHoaDon();
//				dialogChiTietHoaDon.khoiTao(hoaDon);
//				dialogChiTietHoaDon.btnXuatPDF.doClick();
//			}
//			dispose();
//			setVisible(false);
//		}
//	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//
//		Object object = e.getSource();
//		if (object.equals(tfTienNhan)) {
//			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//				btnThanhToan.doClick();
//			}
//		}
//		if (object.equals(tfMaGiamGia)) {
//			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//				btnKiemTraMaGiamGia.doClick();
//			}
//		}
//
//	}
//
//	public Phong getPhong() {
//		return this.phong;
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		Object object = e.getSource();
//		if (object.equals(tfTienNhan)) {
//			kiemTraTienNhan();
//		}
//	}

}}