package component;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.prefs.Preferences;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import entity.NhanVien;
import facade.NhanVienFacade;
import java.awt.SystemColor;

public class GuiFormDangNhap extends JFrame {

	private JFrame frame;
	private JTextField txtDangNhap;
	public Preferences pref = Preferences.userRoot().node("Ghi nhớ mật khẩu");// code ghi nhá»› Ä‘Äƒng nháº­p
	public JCheckBox chckboxLuuDangNhap;
	// ket noi jdbc
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	private JPasswordField passwordMatKhau;
	private final JLabel lblNewLabel_1 = new JLabel("");
	InetAddress myIP;

	//

	public static void main(String[] args) {
		GuiFormDangNhap window = new GuiFormDangNhap();
		window.setVisible(true);
	}

	public GuiFormDangNhap() {
		getContentPane().setEnabled(false);
		getContentPane().setBackground(new Color(240, 248, 255));
		initialize();

		String usr = null;
		usr = pref.get("Email", usr);
		txtDangNhap.setText(usr);

		String pss = null;
		pss = pref.get("Password", pss);
		passwordMatKhau.setText(pss);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			myIP = InetAddress.getLocalHost();
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		};
		setResizable(false);
		setTitle("Đăng nhập");
		getContentPane().setForeground(Color.WHITE);
		setBounds(100, 100, 987, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập:");
		lblTenDangNhap.setForeground(new Color(255, 0, 51));
		lblTenDangNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenDangNhap.setBounds(444, 91, 147, 50);
		getContentPane().add(lblTenDangNhap);

		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setForeground(new Color(255, 0, 51));
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMatKhau.setBounds(470, 176, 129, 43);
		getContentPane().add(lblMatKhau);

		txtDangNhap = new JTextField();
		txtDangNhap.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDangNhap.setBounds(601, 87, 275, 61);
		getContentPane().add(txtDangNhap);
		txtDangNhap.setColumns(10);

		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDangNhap.setIcon(new ImageIcon("image\\login_circle-512 (1).png"));
		// xá»­ lÃ½ nÃºt Ä‘Äƒng nháº­p
		btnDangNhap.addActionListener(new ActionListener() {
			 int n;

			public void actionPerformed(ActionEvent e) {
				// code ghi nhá»› Ä‘Äƒng nháº­p
				if (chckboxLuuDangNhap.isSelected()) {
					checked(true);

				} else {
					checked(false);
				}
				// code ghi nhá»› Ä‘Äƒng nháº­p

				// RMI
				SecurityManager securityManager = System.getSecurityManager();

				if (securityManager == null) {
					System.setProperty("java.security.policy", "myrmi/myrmi.policy");
					System.setSecurityManager(new SecurityManager());
				}
				try {				
					NhanVienFacade nhanVienFacade= (NhanVienFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/nhanVienFacade");
					NhanVien nv = nhanVienFacade.checkDangNhap(txtDangNhap.getText(), passwordMatKhau.getText());	
				if(nv != null) {
					if(nv.getTaiKhoan().getChucVu().equals("Quản lý")) {						
						//JOptionPane.showMessageDialog(null, "Đăng nhập thành công với quyền quản lý");
						Ten_Khi_Dang_Nhap.lblTen.setText(nv.getTaiKhoan().getTaiKhoan());

						Ten_Khi_Dang_Nhap.avatar.setIcon(
								new javax.swing.ImageIcon(getClass().getResource("/icon_trangchu/nam.jpg")));
						new Main_QuanLy().setVisible(true);
						dispose();
					}
					else if(nv.getTaiKhoan().getChucVu().equals("Nhân Viên")) {
						//JOptionPane.showMessageDialog(null, "Đăng nhập thành công với quyền nhân viên");
						Ten_Khi_Dang_Nhap.lblTen.setText(nv.getTaiKhoan().getTaiKhoan());
						Ten_Khi_Dang_Nhap.avatar.setIcon(
								new javax.swing.ImageIcon(getClass().getResource("/icon_trangchu/manager.png")));
						new Main_NhanVien().setVisible(true);
						dispose();
					}				
				}		
				else {
					JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
				}
				
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnDangNhap.setBackground(new Color(245, 245, 245));
		btnDangNhap.setForeground(new Color(255, 0, 0));
		btnDangNhap.setBounds(747, 236, 199, 58);
		getContentPane().add(btnDangNhap);

		JLabel lblNewLabel = new JLabel("Quên mật khẩu ?");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				String t = "<html><u> Quên mật khẩu ?</u></html>";
				lblNewLabel.setText(t);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				String t = "<html><u> Quên mật khẩu ?</u></html>";
				lblNewLabel.setText(t);
				lblNewLabel.setForeground(new Color(220, 20, 60));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setText("Quên mật khẩu ?");
				lblNewLabel.setForeground(new Color(0, 0, 255));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				String t = "<html><u> Quên mật khẩu ?</u></html>";
				lblNewLabel.setText(t);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new SendCode().setVisible(true);

				dispose();

			}
		});

		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(830, 305, 147, 36);
		getContentPane().add(lblNewLabel);

		passwordMatKhau = new JPasswordField();
		passwordMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordMatKhau.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		passwordMatKhau.setEchoChar('*');
		passwordMatKhau.setBounds(601, 174, 275, 50);
		getContentPane().add(passwordMatKhau);

		chckboxLuuDangNhap = new JCheckBox("Ghi nhớ mật khẩu");
		chckboxLuuDangNhap.setVerifyInputWhenFocusTarget(false);
		chckboxLuuDangNhap.setBackground(SystemColor.info);
		chckboxLuuDangNhap.setFont(new Font("Tahoma", Font.BOLD, 17));

		chckboxLuuDangNhap.setBounds(545, 251, 184, 35);
		getContentPane().add(chckboxLuuDangNhap);

		JButton btnAnMatKhau = new JButton("");
		btnAnMatKhau.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ImageIcon showPass = new ImageIcon("image\\eye.png");

				if (!passwordMatKhau.getText().isEmpty()) {
					passwordMatKhau.setEchoChar((char) 0);
					btnAnMatKhau.setIcon(showPass);

				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				ImageIcon hidePass = new ImageIcon("image\\hidden.png");

				if (!passwordMatKhau.getText().isEmpty()) {
					passwordMatKhau.setEchoChar('*');
					btnAnMatKhau.setIcon(hidePass);

				}
			}

		});

		btnAnMatKhau.setIcon(new ImageIcon("image\\hidden.png"));
		btnAnMatKhau.setContentAreaFilled(false);
		btnAnMatKhau.setBorderPainted(false);
		btnAnMatKhau.setBounds(892, 174, 54, 50);
		getContentPane().add(btnAnMatKhau);

		JLabel lblTieuDe = new JLabel("PHẦN MỀM QUẢN LÝ THUÊ CD");
		lblTieuDe.setForeground(new Color(255, 0, 51));
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTieuDe.setBounds(10, 0, 417, 50);
		getContentPane().add(lblTieuDe);
		lblNewLabel_1.setIcon(new ImageIcon("image\\cd.png"));
		lblNewLabel_1.setBounds(0, -41, 424, 565);
		getContentPane().add(lblNewLabel_1);

		JLabel lblDangNhap = new JLabel("ĐĂNG NHẬP");
		lblDangNhap.setForeground(new Color(255, 0, 51));
		lblDangNhap.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDangNhap.setBounds(661, 11, 262, 50);
		getContentPane().add(lblDangNhap);

		JButton btnDangNhap_1 = new JButton("Thoát");
		btnDangNhap_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnDangNhap_1.setIcon(new ImageIcon("image\\exit.png"));
		btnDangNhap_1.setForeground(new Color(255, 0, 0));
		btnDangNhap_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnDangNhap_1.setBackground(new Color(255, 240, 245));
		btnDangNhap_1.setBounds(763, 370, 208, 81);
		getContentPane().add(btnDangNhap_1);

		JLabel lblbackground = new JLabel("");
		lblbackground.setIcon(new ImageIcon("image\\anh-background-nen-trang-trong-dep .jpg"));
		lblbackground.setBackground(Color.WHITE);
		lblbackground.setBounds(411, 0, 566, 465);
		getContentPane().add(lblbackground);

	}

	// code ghi nhá»› Ä‘Äƒng nháº­p
	public void saveemailpass(String Email, String Pass) {
		if (Email == null || Pass == null) {
			System.out.println("..");
		} else {
			String user = Email;
			pref.put("Email", Email);
			String pass = Pass;
			pref.put("Password", pass);
			System.out.println("");
		}
	}

	public final void checked(boolean remember) {
		if (remember == true) {
			saveemailpass(txtDangNhap.getText(), passwordMatKhau.getText());
		} else {
			
		}
	}

}
