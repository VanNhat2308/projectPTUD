package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import org.hibernate.SessionFactory;

import dao.MySessionFactory;
import dao.PhongDao;
import entity.Phong;
import view.util.FormatCustom;

public class ChiTietPhongDiaglog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Phong phong;
	private PhongDao phongDao;
	private JLabel imgPhong;
	private JLabel lbTrangThaiPhong;
	private JLabel lblSNgi;
	private JLabel lblNgi;
	private JLabel lblGing;
	private JLabel lbDienTich;
	private JLabel lblLoaiPhong;
	private JLabel lblGiaPhong;
	private JButton btnQuayLai;
	private JLabel lblTang;
	public static SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChiTietPhongDiaglog dialog = new ChiTietPhongDiaglog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChiTietPhongDiaglog() {
		setBounds(100, 100, 642, 601);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setFont(new Font("Times New Roman", Font.BOLD, 18));
			panel.setBounds(-85, 0, 711, 562);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JPanel panel_3 = new JPanel();
				panel_3.setBackground(Color.BLUE);
				panel_3.setBounds(0, 0, 802, 61);
				panel.add(panel_3);
				JLabel lblNewLabel_11 = new JLabel("Chi tiết phòng");
				lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_11.setForeground(Color.WHITE);
				lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 24));
				GroupLayout gl_panel_3 = new GroupLayout(panel_3);
				gl_panel_3.setHorizontalGroup(
					gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addGap(241)
							.addComponent(lblNewLabel_11, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
							.addGap(238))
				);
				gl_panel_3.setVerticalGroup(
					gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				panel_3.setLayout(gl_panel_3);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(337, 72, 138, 163);
			panel.add(panel_1);
			
		    imgPhong = new JLabel("Phòng 001");
			imgPhong.setFont(new Font("Tahoma", Font.BOLD, 14));
			imgPhong.setHorizontalTextPosition(SwingConstants.CENTER);
			imgPhong.setHorizontalAlignment(SwingConstants.TRAILING);
			imgPhong.setVerticalTextPosition(SwingConstants.BOTTOM);
			imgPhong.setIcon(new ImageIcon(ChiTietPhongDiaglog.class.getResource("/icon/PhongChoThuong.png")));
			panel_1.add(imgPhong);
			
			JPanel panel_16 = new JPanel();
			panel_16.setBounds(82, 246, 666, 21);
			panel.add(panel_16);
			
			JLabel lblNewLabel = new JLabel("Trạng thái phòng:");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
			
		    lbTrangThaiPhong = new JLabel("Phòng bận");
			lbTrangThaiPhong.setFont(new Font("Arial", Font.BOLD, 16));
			GroupLayout gl_panel_16 = new GroupLayout(panel_16);
			gl_panel_16.setHorizontalGroup(
				gl_panel_16.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_panel_16.createSequentialGroup()
						.addGap(172)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addGap(37)
						.addComponent(lbTrangThaiPhong, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(138, Short.MAX_VALUE))
			);
			gl_panel_16.setVerticalGroup(
				gl_panel_16.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_16.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panel_16.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbTrangThaiPhong)
							.addComponent(lblNewLabel))
						.addGap(1))
			);
			panel_16.setLayout(gl_panel_16);
			
			JPanel panel_16_1 = new JPanel();
			panel_16_1.setBounds(82, 278, 666, 21);
			panel.add(panel_16_1);
			
		    lblSNgi = new JLabel("Số người:");
			lblSNgi.setFont(new Font("Arial", Font.BOLD, 16));
			
		    lblNgi = new JLabel("5 người");
			lblNgi.setFont(new Font("Arial", Font.BOLD, 16));
			GroupLayout gl_panel_16_1 = new GroupLayout(panel_16_1);
			gl_panel_16_1.setHorizontalGroup(
				gl_panel_16_1.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_16_1.createSequentialGroup()
						.addContainerGap(233, Short.MAX_VALUE)
						.addComponent(lblSNgi)
						.addGap(51)
						.addComponent(lblNgi, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGap(139))
			);
			gl_panel_16_1.setVerticalGroup(
				gl_panel_16_1.createParallelGroup(Alignment.LEADING)
					.addGap(0, 21, Short.MAX_VALUE)
					.addGroup(gl_panel_16_1.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panel_16_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNgi)
							.addComponent(lblSNgi))
						.addGap(1))
			);
			panel_16_1.setLayout(gl_panel_16_1);
			
			JPanel panel_16_2 = new JPanel();
			panel_16_2.setBounds(82, 310, 666, 21);
			panel.add(panel_16_2);
			
			JLabel lblSGing = new JLabel("Số giường:");
			lblSGing.setFont(new Font("Arial", Font.BOLD, 16));
			
		    lblGing = new JLabel("2 Giường");
			lblGing.setFont(new Font("Arial", Font.BOLD, 16));
			GroupLayout gl_panel_16_2 = new GroupLayout(panel_16_2);
			gl_panel_16_2.setHorizontalGroup(
				gl_panel_16_2.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_16_2.createSequentialGroup()
						.addContainerGap(223, Short.MAX_VALUE)
						.addComponent(lblSGing)
						.addGap(50)
						.addComponent(lblGing, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGap(140))
			);
			gl_panel_16_2.setVerticalGroup(
				gl_panel_16_2.createParallelGroup(Alignment.LEADING)
					.addGap(0, 21, Short.MAX_VALUE)
					.addGroup(gl_panel_16_2.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panel_16_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblSGing)
							.addComponent(lblGing))
						.addGap(1))
			);
			panel_16_2.setLayout(gl_panel_16_2);
			
			JPanel panel_16_3 = new JPanel();
			panel_16_3.setBounds(82, 342, 666, 21);
			panel.add(panel_16_3);
			
			JLabel lblDinTch = new JLabel("Diện tích:");
			lblDinTch.setFont(new Font("Arial", Font.BOLD, 16));
			
		    lbDienTich = new JLabel("25m2");
			lbDienTich.setFont(new Font("Arial", Font.BOLD, 16));
			GroupLayout gl_panel_16_3 = new GroupLayout(panel_16_3);
			gl_panel_16_3.setHorizontalGroup(
				gl_panel_16_3.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_16_3.createSequentialGroup()
						.addContainerGap(238, Short.MAX_VALUE)
						.addComponent(lblDinTch, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addGap(36)
						.addComponent(lbDienTich, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGap(139))
			);
			gl_panel_16_3.setVerticalGroup(
				gl_panel_16_3.createParallelGroup(Alignment.LEADING)
					.addGap(0, 21, Short.MAX_VALUE)
					.addGroup(gl_panel_16_3.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panel_16_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDinTch)
							.addComponent(lbDienTich))
						.addGap(1))
			);
			panel_16_3.setLayout(gl_panel_16_3);
			
			JPanel panel_16_3_1 = new JPanel();
			panel_16_3_1.setBounds(82, 374, 666, 21);
			panel.add(panel_16_3_1);
			
			JLabel lblLoiPhng = new JLabel("Loại phòng:");
			lblLoiPhng.setFont(new Font("Arial", Font.BOLD, 16));
			
		    lblLoaiPhong = new JLabel("VIP");
			lblLoaiPhong.setFont(new Font("Arial", Font.BOLD, 16));
			GroupLayout gl_panel_16_3_1 = new GroupLayout(panel_16_3_1);
			gl_panel_16_3_1.setHorizontalGroup(
				gl_panel_16_3_1.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_16_3_1.createSequentialGroup()
						.addContainerGap(218, Short.MAX_VALUE)
						.addComponent(lblLoiPhng, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addGap(37)
						.addComponent(lblLoaiPhong, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGap(139))
			);
			gl_panel_16_3_1.setVerticalGroup(
				gl_panel_16_3_1.createParallelGroup(Alignment.LEADING)
					.addGap(0, 21, Short.MAX_VALUE)
					.addGap(0, 21, Short.MAX_VALUE)
					.addGroup(gl_panel_16_3_1.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panel_16_3_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblLoaiPhong)
							.addComponent(lblLoiPhng))
						.addGap(1))
			);
			panel_16_3_1.setLayout(gl_panel_16_3_1);
			
			JPanel panel_16_3_2 = new JPanel();
			panel_16_3_2.setBounds(82, 406, 666, 21);
			panel.add(panel_16_3_2);
			
			JLabel lblGiTin = new JLabel("Giá tiền:");
			lblGiTin.setFont(new Font("Arial", Font.BOLD, 16));
			
		    lblGiaPhong = new JLabel("100.000 VNĐ");
			lblGiaPhong.setForeground(Color.RED);
			lblGiaPhong.setFont(new Font("Arial", Font.BOLD, 16));
			GroupLayout gl_panel_16_3_2 = new GroupLayout(panel_16_3_2);
			gl_panel_16_3_2.setHorizontalGroup(
				gl_panel_16_3_2.createParallelGroup(Alignment.TRAILING)
					.addGap(0, 666, Short.MAX_VALUE)
					.addGroup(gl_panel_16_3_2.createSequentialGroup()
						.addContainerGap(238, Short.MAX_VALUE)
						.addComponent(lblGiTin, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addGap(36)
						.addComponent(lblGiaPhong, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGap(139))
			);
			gl_panel_16_3_2.setVerticalGroup(
				gl_panel_16_3_2.createParallelGroup(Alignment.LEADING)
					.addGap(0, 21, Short.MAX_VALUE)
					.addGap(0, 21, Short.MAX_VALUE)
					.addGroup(gl_panel_16_3_2.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panel_16_3_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblGiTin)
							.addComponent(lblGiaPhong))
						.addGap(1))
			);
			panel_16_3_2.setLayout(gl_panel_16_3_2);
			
			btnQuayLai = new JButton("Quay lại");
			btnQuayLai.setBounds(102, 496, 150, 40);
			panel.add(btnQuayLai);
			btnQuayLai.setForeground(Color.WHITE);
			btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnQuayLai.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
			btnQuayLai.setBackground(new Color(0, 127, 255));
			
			JPanel panel_16_3_2_1 = new JPanel();
			panel_16_3_2_1.setBounds(82, 438, 666, 21);
			panel.add(panel_16_3_2_1);
			
			JLabel lblTng = new JLabel("Tầng:");
			lblTng.setFont(new Font("Arial", Font.BOLD, 16));
			
		    lblTang = new JLabel("4");
			lblTang.setForeground(Color.BLACK);
			lblTang.setFont(new Font("Arial", Font.BOLD, 16));
			GroupLayout gl_panel_16_3_2_1 = new GroupLayout(panel_16_3_2_1);
			gl_panel_16_3_2_1.setHorizontalGroup(
				gl_panel_16_3_2_1.createParallelGroup(Alignment.TRAILING)
					.addGap(0, 666, Short.MAX_VALUE)
					.addGroup(gl_panel_16_3_2_1.createSequentialGroup()
						.addContainerGap(238, Short.MAX_VALUE)
						.addComponent(lblTng, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addGap(36)
						.addComponent(lblTang, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addGap(139))
			);
			gl_panel_16_3_2_1.setVerticalGroup(
				gl_panel_16_3_2_1.createParallelGroup(Alignment.LEADING)
					.addGap(0, 21, Short.MAX_VALUE)
					.addGap(0, 21, Short.MAX_VALUE)
					.addGroup(gl_panel_16_3_2_1.createSequentialGroup()
						.addGap(0)
						.addGroup(gl_panel_16_3_2_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblTng)
							.addComponent(lblTang))
						.addGap(1))
			);
			panel_16_3_2_1.setLayout(gl_panel_16_3_2_1);
			btnQuayLai.addActionListener(this);
			phongDao = new PhongDao(sessionFactory);
			
		}
	}
	public static String layDiaChiIconTheoLoaiVaTrangThaiPhong(String maLP, String maTTP) {
		String loaiPhong = "Vip";
		if (maLP.equalsIgnoreCase("LP001")) {
			loaiPhong = "Thuong";
		}
		switch (maTTP) {
		case "TTP001":
			// Phòng bận
			return "/icon/PhongBan" + loaiPhong + ".png";
		case "TTP002":
			// Phòng chờ
			return "/icon/PhongCho" + loaiPhong + ".png";
		case "TTP003":
			// Phòng trống
			return "/icon/PhongTrong" + loaiPhong + ".png";
		default:
			// Phòng tạm
			return "/icon/PhongTam" + loaiPhong + ".png";
		}
	}
	public String covertTrangThai(String TrangThaiPhong) {
		if (TrangThaiPhong.equalsIgnoreCase("TTP001"))
			return "Phòng Bận";
		else if (TrangThaiPhong.equalsIgnoreCase("TTP003"))
			return "Phòng Trống";
		return "Phòng đặt trước";
	}
	public void khoiTao(String maPhong) {
		phong = phongDao.layThongTinPhongQuaMa(maPhong);
		imgPhong.setIcon(new ImageIcon(ChiTietPhongDiaglog.class.getResource(layDiaChiIconTheoLoaiVaTrangThaiPhong(
		phong.getLoaiPhong().getMaLP().strip(), phong.getTrangThaiPhong().strip()))));
		imgPhong.setText(phong.getMaPhong().substring(1));
		lbTrangThaiPhong.setText(covertTrangThai(phong.getTrangThaiPhong().strip()));
		lblLoaiPhong.setText(phong.getLoaiPhong().getTenLoaiPhong());
		lblNgi.setText(phong.getSoNguoi() +" "+"Người");
		lbDienTich.setText(phong.getDienTich()+" "+"m2");
		lblGiaPhong.setText(FormatCustom.chuyenDoiTienTe(phong.getLoaiPhong().getGiaTien()));
		lblGing.setText(Integer.toString(phong.getSoGiuong())+" "+"Giường");
		lblTang.setText(phong.getTang()+"");
		setVisible(true);
		
//		lblGioNhanPhong.setText(FormatCustom.dinhDanhThoiGian(new Date()));

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object.equals(btnQuayLai)) {
		  setVisible(false);
		}
		
	}
	public void lamMoi() {
		// TODO Auto-generated method stub
		if (this.phong != null) {
			khoiTao(phong.getMaPhong());
		}

	}
}
