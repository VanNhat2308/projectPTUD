package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import org.hibernate.SessionFactory;



import dao.MySessionFactory;
import dao.NhanVienDao;

import entity.NhanVien;

import service.NhanVienService;
import view.util.HeaderRenderer;

public class NhanVienPanel extends JPanel implements ActionListener, KeyListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JPanel panel;
	private List<NhanVien> nhanVien;
	@SuppressWarnings("rawtypes")
	private JComboBox cbTrangThaiLamViec;
	private DefaultTableModel tableModle;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtTimTen;
	private JTextField txtCMND;
	private JLabel lblCm;
	@SuppressWarnings("rawtypes")
	private JComboBox cbGioiTinh;
	private JTextField txtSDT;
	private JButton btnSua;
	private JButton btnTrangThaiLamViec;
	private JButton btnThem;
	private JButton btnTim;
	private int limit = 20;
	private JButton btnLamMoi;
	@SuppressWarnings("unused")
	
	SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();
	NhanVienService nhanVienService = new NhanVienDao(sessionFactory);
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					NhanVien frame = new NhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NhanVienPanel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		setSize(1263, 659);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));

		JLabel lblNhpSdt = new JLabel("SDT: ");
		lblNhpSdt.setBounds(358, 111, 48, 40);
		lblNhpSdt.setForeground(Color.BLACK);
		lblNhpSdt.setFont(new Font("Tahoma", Font.BOLD, 16));

		txtSDT = new JTextField();
		txtSDT.setBounds(410, 111, 249, 40);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);

		btnSua = new JButton("Sửa");
		btnSua.setBounds(969, 61, 140, 40);
		btnSua.setMargin(new Insets(2, 9, 2, 9));
		btnSua.setBackground(new Color(128, 128, 128));
		btnSua.setForeground(new Color(255, 255, 255));
		btnSua.setToolTipText("");
		btnSua.setIconTextGap(30);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnTrangThaiLamViec = new JButton("Nghỉ việc");
		btnTrangThaiLamViec.setBounds(1119, 60, 140, 40);

		btnTrangThaiLamViec.setMargin(new Insets(2, 0, 2, 0));
		btnTrangThaiLamViec.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnTrangThaiLamViec.setForeground(new Color(255, 255, 255));
		btnTrangThaiLamViec.setBackground(new Color(255, 99, 71));
		btnTrangThaiLamViec.setIconTextGap(10);
		btnTrangThaiLamViec.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnThem = new JButton("Thêm");
		btnThem.setBounds(819, 62, 140, 40);
		btnThem.setMargin(new Insets(2, 9, 2, 9));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setIconTextGap(20);
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		

		btnTim = new JButton("Tìm");
		btnTim.setBounds(819, 110, 140, 40);
		btnTim.setIconTextGap(30);
		btnTim.setBackground(new Color(60, 179, 113));
		btnTim.setForeground(new Color(255, 255, 255));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		

		cbTrangThaiLamViec = new JComboBox();
		cbTrangThaiLamViec.setBounds(669, 111, 140, 40);
		cbTrangThaiLamViec.setBackground(new Color(255, 248, 220));
		cbTrangThaiLamViec.setModel(new DefaultComboBoxModel(new String[] { "Trạng Thái", "Đang làm", "Nghỉ việc" }));
		cbTrangThaiLamViec.setToolTipText("");
		cbTrangThaiLamViec.setName("Loại");
		cbTrangThaiLamViec.setFont(new Font("Tahoma", Font.PLAIN, 18));

		scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 162, 1248, 446);

		table = new JTable();
		table.setSelectionBackground(SystemColor.activeCaption);
		scrollPane.setColumnHeaderView(table);

		tableModle = new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã NV", "Họ tên", "Số CMND", "SĐT", "Giới tính", "Ngày sinh", "Địa chỉ",
				"Trạng thái làm việc","Password" });
		table.addMouseListener(this);
		table.setRowHeight(50);
		scrollPane.setViewportView(table);

		table.setModel(tableModle);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(110);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		JLabel lblTn = new JLabel("Tên: ");
		lblTn.setBounds(20, 61, 61, 40);
		lblTn.setForeground(Color.BLACK);
		lblTn.setFont(new Font("Tahoma", Font.BOLD, 16));

		txtTimTen = new JTextField();
		txtTimTen.setBounds(87, 61, 572, 40);
		txtTimTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimTen.setColumns(10);

		txtCMND = new JTextField();
		txtCMND.setBounds(86, 111, 262, 40);
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setColumns(10);

		lblCm = new JLabel("CMND: ");
		lblCm.setBounds(20, 111, 61, 40);
		lblCm.setForeground(Color.BLACK);
		lblCm.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblNewLabel = new JLabel("Quản lý Nhân Viên\r\n");
		lblNewLabel.setBounds(1, 1, 1258, 50);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBackground(new Color(0, 0, 255));

		btnLamMoi = new JButton("làm mới");
		btnLamMoi.setBounds(969, 110, 140, 40);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoi.setMargin(new Insets(2, 9, 2, 9));
		btnLamMoi.setIconTextGap(10);
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLamMoi.setBackground(new Color(50, 205, 50));

		cbGioiTinh = new JComboBox();
		cbGioiTinh.setBounds(669, 60, 140, 40);
		cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Giới tính", "Nam", "Nữ" }));
		cbGioiTinh.setToolTipText("");
		cbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbGioiTinh.setBackground(Color.WHITE);

		JTableHeader h = table.getTableHeader();
		h.setPreferredSize(new Dimension(40, 40));
		((DefaultTableCellRenderer) h.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		HeaderRenderer renderer = new HeaderRenderer();
		// center
		JLabel headerLabel = (JLabel) renderer;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		// set color Header Table
		@SuppressWarnings("unused")
		TableColumnModel columnmodel;
		columnmodel = table.getColumnModel();
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setHeaderRenderer(renderer);
			renderer.setBackgroundColor(new Color(185, 219, 215));
			renderer.setForegroundColor(Color.black);
			renderer.setBorder(new LineBorder(new Color(0, 206, 209)));
		}
		btnLamMoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnTrangThaiLamViec.addActionListener(this);
		cbTrangThaiLamViec.addActionListener(this);
		cbGioiTinh.addActionListener(this);
		txtTimTen.addKeyListener(this);
		txtSDT.addKeyListener(this);
		txtCMND.addKeyListener(this);
		table.addMouseListener(this);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1263, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(3))
		);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel);
		panel_1.add(scrollPane);
		panel_1.add(lblCm);
		panel_1.add(txtCMND);
		panel_1.add(lblNhpSdt);
		panel_1.add(txtSDT);
		panel_1.add(lblTn);
		panel_1.add(txtTimTen);
		panel_1.add(btnThem);
		panel_1.add(btnTrangThaiLamViec);
		panel_1.add(btnSua);
		panel_1.add(btnLamMoi);
		panel_1.add(btnTim);
		panel_1.add(cbTrangThaiLamViec);
		panel_1.add(cbGioiTinh);
		setLayout(groupLayout);
		// khong cho sua table
		table.setDefaultEditor(Object.class, null);

	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	private void setAlwaysOnTop(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub


	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		@SuppressWarnings("unused")
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Object object = e.getSource();
		if (object.equals(txtTimTen)) {
			String ten = txtTimTen.getText().toString().trim();
			if (ten.equalsIgnoreCase("")) {
				xoaToanBoBang();
				themDuLieuVaoTable();
			} else {
				List<NhanVien> list = null;
				xoaToanBoBang();
				list = nhanVienService.layDanhSachNhanVienTheoTen(ten);
				for (NhanVien nhanVien : list) {
					String[] s = { nhanVien.getMaNV(), nhanVien.getHoTen().toUpperCase(), nhanVien.getSoCMND(),
							nhanVien.getSoDienThoai(), nhanVien.isGioiTinh() ? "Nam" : "Nũ",
							nhanVien.getNgaySinh().toString(),
							nhanVien.getDiaChi().getTinhTP() + " " + nhanVien.getDiaChi().getQuanHuyen() + " "
									+ nhanVien.getDiaChi().getPhuongXa(),
							nhanVien.isTrangThaiLamViec() ? "Đang làm" : "Đã nghĩ",nhanVien.getPassword()};
					tableModle.addRow(s);
				}
			}
		}
	}


	public void themDuLieuVaoTable() {
		String trangThaiLamViec = "";
		String gioiTinh = "";
		if (cbTrangThaiLamViec.getSelectedIndex() != 0) {
			trangThaiLamViec = cbTrangThaiLamViec.getSelectedItem().toString().equalsIgnoreCase("Đang làm") ? "1" : "0";
		}

	
		if (cbGioiTinh.getSelectedIndex() != 0) {
			gioiTinh = cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nam") ? "1" : "0";
		}
		System.out.println(trangThaiLamViec);
		System.out.println(gioiTinh);
		List<NhanVien> list = null;
		try {
			list = nhanVienService.layDanhSachNhanVien();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (list == null) {
			JOptionPane.showMessageDialog(this, "rong");
			
		
			return;
		}
		nhanVien = nhanVienService.layDanhSachNhanVien();
		xoaToanBoBang();
		for (NhanVien nhanVien : list) {
			String[] s = { nhanVien.getMaNV(), nhanVien.getHoTen().toUpperCase(), nhanVien.getSoCMND(),
					nhanVien.getSoDienThoai(), nhanVien.isGioiTinh() ? "Nam" : "Nữ", nhanVien.getNgaySinh().toString(),
					nhanVien.getDiaChi().getTinhTP() + " " + nhanVien.getDiaChi().getQuanHuyen() + " "
							+ nhanVien.getDiaChi().getPhuongXa(),
					nhanVien.isTrangThaiLamViec() ? "Đang làm" : "Đã nghĩ" ,nhanVien.getPassword() };
			tableModle.addRow(s);
		}

	}

	public void xoaToanBoBang() {
		for (int i = tableModle.getRowCount(); i > 0; i--) {
			tableModle.removeRow(0);
		}
	}

	public void khoiTaoDuLieu() {
		xoaToanBoBang();
		themDuLieuVaoTable();
	}

	public void lamMoi() {
//		btnTrangThaiLamViec = new JButton("TTLV");
		cbTrangThaiLamViec.setSelectedIndex(0);
		cbGioiTinh.setSelectedIndex(0);
		txtTimTen.setText("");
		txtSDT.setText("");
//		txtCMND.setText("");
		xoaToanBoBang();
		themDuLieuVaoTable();
		txtSDT.setEnabled(true);
		txtCMND.setEnabled(true);
		btnTrangThaiLamViec.setText("Nghĩ việc");
		btnTrangThaiLamViec.setIcon(new ImageIcon(NhanVienPanel.class.getResource("/icon/unemployment.png")));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		int tongPage = 1;
		String trangThaiLamViec = "", gioiTinh = "";
		if (cbTrangThaiLamViec.getSelectedIndex() != 0) {
			trangThaiLamViec = cbTrangThaiLamViec.getSelectedItem().toString().equalsIgnoreCase("Đang làm") ? "1" : "0";
		}
		try {
			tongPage = nhanVienService.tongTrang(txtTimTen.getText().trim(), gioiTinh, trangThaiLamViec,
					limit);

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
         if (object.equals(btnLamMoi)) { // lam moi
			lamMoi();
		} else if (object.equals(btnTim)) { // tim SDT

			String sdt = txtSDT.getText();
			String cmnd = txtCMND.getText();
			NhanVien nhanVien = null;
			if (!sdt.trim().equals("")) {
				
				try {
					nhanVien = nhanVienService.layThongTinNhanVienQuaSDT(sdt);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (nhanVien != null) {
					xoaToanBoBang();
					txtCMND.setEnabled(true);
					txtSDT.setEnabled(true);
					txtTimTen.setText("");
					String[] s = { nhanVien.getMaNV(), nhanVien.getHoTen().toUpperCase(), nhanVien.getSoCMND(),
							nhanVien.getSoDienThoai(), nhanVien.isGioiTinh() ? "Nam" : "Nữ",
							nhanVien.getNgaySinh().toString(),
							nhanVien.getDiaChi().getTinhTP() + " " + nhanVien.getDiaChi().getQuanHuyen() + " "
									+ nhanVien.getDiaChi().getPhuongXa(),
							nhanVien.isTrangThaiLamViec() ? "Đang làm" : "Đã nghĩ",nhanVien.getPassword()
							 };
					tableModle.addRow(s);

				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy");
				}
			}
			if (!cmnd.trim().equals("")) {
				try {
					nhanVien = nhanVienService.layThongTinNhanVienQuaCMND(cmnd);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (nhanVien != null) {
					xoaToanBoBang();
					txtSDT.setEnabled(true);
					txtCMND.setEnabled(true);
					txtSDT.setText("");
					String[] s = { nhanVien.getMaNV(), nhanVien.getHoTen().toUpperCase(), nhanVien.getSoCMND(),
							nhanVien.getSoDienThoai(), nhanVien.isGioiTinh() ? "Nam" : "Nữ",
							nhanVien.getNgaySinh().toString(),
							nhanVien.getDiaChi().getTinhTP() + " " + nhanVien.getDiaChi().getQuanHuyen() + " "
									+ nhanVien.getDiaChi().getPhuongXa(),
							nhanVien.isTrangThaiLamViec() ? "Đang làm" : "Đã nghĩ",nhanVien.getPassword()
							 };
					tableModle.addRow(s);

				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy ");
				}
			}
		} else if (object.equals(btnSua)) {
//			JOptionPane.showMessageDialog(this, "NOoooooooooo");
			int selectRow = table.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên!");
				return;
			}
			String ma = (String) table.getValueAt(table.getSelectedRow(), 0);
			DialogSuaNhanVien dialogSuaNhanVien = new DialogSuaNhanVien(ma);
			dialogSuaNhanVien.setVisible(true);
			lamMoi();			
		} else if (object.equals(btnThem)) {// them nhan vien
			new DialogThemNhanVien().setVisible(true);
			lamMoi();
		} else if (object.equals(cbTrangThaiLamViec) || object.equals(cbGioiTinh)) {

			xoaToanBoBang();
			themDuLieuVaoTable();
		}
		else if (object.equals(btnTrangThaiLamViec)) { // thay doi trang thai lam viec

			int hang = table.getSelectedRow();
			if (hang == -1) {
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn Nhân viên");
				return;
			}
			int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn thay đổi trạng thái làm việc không",
					"Thông báo", JOptionPane.YES_NO_OPTION);
			if (xacnhan == JOptionPane.NO_OPTION) {
				return;
			}
			try {
				nhanVienService.suaTrangThaiLamViecQuaSoDienThoai(tableModle.getValueAt(hang, 3).toString(),
						tableModle.getValueAt(hang, 7).toString().equalsIgnoreCase("Đang Làm") ? false : true);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tableModle.setValueAt(
					tableModle.getValueAt(hang, 7).toString().equalsIgnoreCase("Đang Làm") ? "Đã nghĩ" : "Đang làm",
					hang, 7);
			String trangThaiLamViec2 = tableModle.getValueAt(table.getSelectedRow(), 6).toString();
			if (trangThaiLamViec2.equalsIgnoreCase("Đã nghĩ")) {
				btnTrangThaiLamViec.setText("Làm lại");
				btnTrangThaiLamViec.setIcon(new ImageIcon(NhanVienPanel.class.getResource("/icon/lam_moi.png")));
			} else {
				btnTrangThaiLamViec.setText("Nghĩ việc");
				btnTrangThaiLamViec.setIcon(new ImageIcon(NhanVienPanel.class.getResource("/icon/xoa.png")));
			}
			JOptionPane.showMessageDialog(this, "Thay đổi thành công");
		}

////		 dong ket noi

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// set trang thai lam viec
		Object object = e.getSource();
		if (object.equals(table)) {
			String trangThaiLamViec = tableModle.getValueAt(table.getSelectedRow(), 7).toString();
			System.out.println(trangThaiLamViec);
			if (trangThaiLamViec.equalsIgnoreCase("Đã nghĩ")) {
				btnTrangThaiLamViec.setText("Làm lại");
				btnTrangThaiLamViec.setIcon(new ImageIcon(NhanVienPanel.class.getResource("/icon/lam_moi.png")));
			} else {
				btnTrangThaiLamViec.setText("Nghĩ việc");
				btnTrangThaiLamViec.setIcon(new ImageIcon(NhanVienPanel.class.getResource("/icon/xoa.png")));
			}
		}
	}
	
}
