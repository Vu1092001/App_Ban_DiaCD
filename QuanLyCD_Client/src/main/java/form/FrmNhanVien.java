package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import entity.DiaCD;
import entity.NhanVien;
import entity.PhieuMuon;
import entity.PhieuTra;
import entity.TaiKhoan;
import entity.ThanhVien;
import facade.DiaCDFacade;
import facade.NhanVienFacade;
import facade.PhieuMuonFacade;
import facade.PhieuTraFacade;
import facade.ThanhVienFacade;

public class FrmNhanVien extends JPanel {
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtsoDT;
	private JTextField txtDiaChi;
	private JTextField txtCMND;
	private JTextField txtTimKiem;
	private JTable table;
	List<PhieuMuon> lsPm;
	List<DiaCD> lsCD;
	List<NhanVien> lsNV;
	List<ThanhVien> lsTV;
	List<PhieuTra> lsPT;

	PhieuMuonFacade phieuMuonFacade;
	DiaCDFacade diaCDFacade;
	NhanVienFacade nhanVienFacade;
	ThanhVienFacade thanhVienFacade;
	PhieuTraFacade phieuTraFacade;
	DefaultTableModel model_NV = new DefaultTableModel();
	private JTextField txtTaiKhoan;
	private JTextField txtEmail;
	InetAddress myIP;
	/**
	 * Create the panel.
	 */
	public FrmNhanVien() throws RemoteException{

		try {
			myIP=InetAddress.getLocalHost();
		} catch (UnknownHostException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		setBackground(Color.WHITE);
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}		
		try {
			phieuMuonFacade = (PhieuMuonFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/phieuMuonFacade");
			diaCDFacade = (DiaCDFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/diaCDFacade");
			nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/nhanVienFacade");
			thanhVienFacade = (ThanhVienFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/thanhVienFacade");
			phieuTraFacade = (PhieuTraFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/phieuTraFacade");
			
			//lsPm.forEach(rs -> System.out.println(rs));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		loadFullDuLieu(0);
		setPreferredSize(new Dimension(1400, 915));
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(649, 11, 1, 1);
		add(panel);
		panel.setLayout(null);
		setSize(800, 500);

		JLabel lblTitle = new JLabel("Th??ng Tin Nh??n Vi??n");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setBounds(600, 0, 269, 66);
		add(lblTitle);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 85, 1380, 306);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaNV = new JLabel("M?? Nh??n Vi??n :");
		lblMaNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNV.setBounds(21, 11, 130, 33);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaNV.setBounds(151, 14, 211, 31);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lblTenNV = new JLabel("T??n Nh??n Vi??n :");
		lblTenNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenNV.setBounds(404, 14, 121, 26);
		panel_1.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenNV.setBounds(533, 13, 211, 31);
		panel_1.add(txtTenNV);
		txtTenNV.setColumns(10);

		JLabel lblGioiTinh = new JLabel("Gi???i T??nh :");
		lblGioiTinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGioiTinh.setBounds(764, 12, 84, 28);
		panel_1.add(lblGioiTinh);

		JComboBox cbxGioiTinh = new JComboBox(new Object[] { "Nam", "N???" });
		cbxGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxGioiTinh.setBounds(858, 12, 188, 31);
		panel_1.add(cbxGioiTinh);

		JLabel lblSoDT = new JLabel("??i???n Tho???i :");
		lblSoDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoDT.setBounds(393, 66, 130, 33);
		panel_1.add(lblSoDT);

		txtsoDT = new JTextField();
		txtsoDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtsoDT.setBounds(533, 69, 211, 31);
		panel_1.add(txtsoDT);
		txtsoDT.setColumns(10);

		JLabel lblDiaChi = new JLabel("?????a Ch??? :");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiaChi.setBounds(21, 67, 130, 33);
		panel_1.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(151, 70, 211, 31);
		panel_1.add(txtDiaChi);

		JLabel lblCMND = new JLabel("CMND :");
		lblCMND.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCMND.setBounds(764, 66, 84, 33);
		panel_1.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(858, 67, 188, 31);
		panel_1.add(txtCMND);

		JButton btnThem = new JButton("Th??m");
		btnThem.setIcon(new ImageIcon(FrmNhanVien.class.getResource("/icon_trangchu/icons8_add_48px.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(42, 191, 152, 47);
		panel_1.add(btnThem);

		JButton btnXoa = new JButton("X??a");
		btnXoa.setIcon(new ImageIcon(FrmNhanVien.class.getResource("/icon_trangchu/icons8_remove_30px.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(260, 191, 142, 47);
		panel_1.add(btnXoa);

		JButton btnSua = new JButton("S???a");
		btnSua.setIcon(new ImageIcon(FrmNhanVien.class.getResource("/icon_trangchu/icons8_edit_24px.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(464, 191, 142, 47);
		panel_1.add(btnSua);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(869, 206, 188, 31);
		panel_1.add(txtTimKiem);

		JButton btnTimKiem = new JButton("T??m Ki???m");
		btnTimKiem.setIcon(new ImageIcon(FrmNhanVien.class.getResource("/icon_trangchu/icons8_search_40px.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimKiem.setBounds(1233, 191, 147, 46);
		panel_1.add(btnTimKiem);

		JLabel lblThongBao = new JLabel("Th??ng B??o !");
		lblThongBao.setIcon(new ImageIcon(FrmNhanVien.class.getResource("/icon_trangchu/icons8_error_30px.png")));
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblThongBao.setBounds(71, 111, 248, 25);
		panel_1.add(lblThongBao);

		JButton btnTaiLai = new JButton("T???i L???i");
		btnTaiLai.setIcon(new ImageIcon(FrmNhanVien.class.getResource("/icon_trangchu/icons8_spinner_40px.png")));
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiLai.setBounds(692, 191, 142, 47);
		panel_1.add(btnTaiLai);
		
		JComboBox cbxTimKiem = new JComboBox();
		cbxTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxTimKiem.setModel(new DefaultComboBoxModel(new String[] {"Theo M?? NV", "Theo T??n NV"}));
		cbxTimKiem.setBounds(1085, 191, 138, 47);
		panel_1.add(cbxTimKiem);
		
		JLabel lblChcV = new JLabel("Ch???c V??? :");
		lblChcV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChcV.setBounds(1098, 13, 71, 28);
		panel_1.add(lblChcV);
		
		JLabel lblTiKhon = new JLabel("T??i Kho???n :");
		lblTiKhon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTiKhon.setBounds(1085, 68, 84, 28);
		panel_1.add(lblTiKhon);
		
		JComboBox cboChucVu = new JComboBox(new Object[]{"Nh??n Vi??n", "Qu???n l??"});
		cboChucVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboChucVu.setBounds(1179, 12, 178, 31);
		panel_1.add(cboChucVu);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(1179, 67, 178, 31);
		panel_1.add(txtTaiKhoan);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(359, 128, 130, 33);
		panel_1.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(499, 129, 285, 31);
		panel_1.add(txtEmail);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 401, 1380, 434);
		add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		loadTieuDe();
		loadData_NV(lsNV);
		//--------------------------------------Ch???c n??ng----------------------------------------
		
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtMaNV.getText().equals("") || txtCMND.getText().equals("") || txtDiaChi.getText().equals("") || txtEmail.getText().equals("") || 
						txtsoDT.getText().equals("") || txtTaiKhoan.getText().equals("") || txtTenNV.getText().equals("")) {
					lblThongBao.setText("l???i Nh???p li???u r???ng ho???c sai");
				}else {
					int i=0;
					for (NhanVien nhanVien : lsNV) {
						if(nhanVien.getMaNV().equals(txtMaNV.getText()))
							i=1;
					}
					if(i==0) {
						try {
							NhanVien nv = new NhanVien(txtMaNV.getText(),txtTenNV.getText(),cbxGioiTinh.getSelectedItem().toString(),
									txtsoDT.getText(),txtDiaChi.getText(),txtCMND.getText(), txtEmail.getText(),
									new TaiKhoan(txtTaiKhoan.getText(), "123", cboChucVu.getSelectedItem().toString()));
							nhanVienFacade.themNhanVien(nv);				
							loadFullDuLieu(2);
							loadData_NV(lsNV);
							lblThongBao.setText("Th??m th??nh c??ng");
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}else
						lblThongBao.setText("Nh??n vi??n ???? t???n t???i");
		
				}			
			}});
		
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtMaNV.getText().equals("")) {
					lblThongBao.setText("Ch??a ch???n nh??n vi??n");
				}else {
					int row = table.getSelectedRow();
					String maNV = table.getValueAt(row,0).toString();
					if (txtMaNV==null) {
						lblThongBao.setText("Ch??a ch???n nh??n vi??n");
					}else {
						NhanVien NV;
						try {
							NV = nhanVienFacade.timNhanVienTheoMa(txtMaNV.getText().toString());
							NhanVien nv = new NhanVien(NV.getMaNV());
							nhanVienFacade.xoaNhanVien(nv);
							loadFullDuLieu(2);
							loadData_NV(lsNV);
							lblThongBao.setText("X??a th??nh c??ng");
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
					}	
				}
				
			}});
		btnTaiLai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtCMND.setText("");
				txtDiaChi.setText("");
				txtMaNV.setText("");
				txtTenNV.setText("");
				cbxGioiTinh.setSelectedIndex(0);
				txtsoDT.setText("");
				loadData_NV(lsNV);
				//model_NV.getDataVector().remove(0)
				table.setModel(model_NV);
			}});
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtTimKiem.getText().equals("")) {
					lblThongBao.setText("T??m ki???m r???ng");
				}else {
					if (cbxTimKiem.getSelectedItem().equals("Theo M?? NV")) {
						try {
							List<String> dsNV = new ArrayList<String>();
							NhanVien nv = nhanVienFacade.timNhanVienTheoMa(txtTimKiem.getText().toString());
							if (nv == null) {
								lblThongBao.setText("M?? kh??ng t???n t???i");
							}else {
								dsNV.add(nv.getMaNV());
								loadData_NV1(dsNV);
							}						
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}else if(cbxTimKiem.getSelectedItem().equals("Theo T??n NV")) {
						List<NhanVien> dsNV = new ArrayList<NhanVien>();
						try {
							
							for (NhanVien nhanVien : lsNV) {
								if(nhanVien.getHoTenNV().toLowerCase().contains(txtTimKiem.getText().toLowerCase())) {
									dsNV.add(nhanVien);
								}
							}					
//							dsNV = nhanVienFacade.timNhanVienTheoTen(txtTimKiem.getText().toString());
							if (dsNV.size() != 0) {
								loadData_NV(dsNV);
							}else {
								lblThongBao.setText("T??n kh??ng t???n t???i");
							}						
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				}

				
			}		
			});
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtMaNV.getText().equals("")){
					lblThongBao.setText("Ch??a ch???n nh??n vi??n");
				}else {
					List<String> lsNV = new ArrayList<String>();
					int row = model_NV.getRowCount();
					for (int i = 0; i < row; i++) {
						lsNV.add(table.getValueAt(i,0).toString());
					}
					NhanVien nv = new NhanVien(txtMaNV.getText(),txtTenNV.getText(),cbxGioiTinh.getSelectedItem().toString(),txtsoDT.getText(),
							txtDiaChi.getText(),txtCMND.getText(), txtEmail.getText(), new TaiKhoan(txtTaiKhoan.getText(), "123",
									cboChucVu.getSelectedItem().toString()));
					try {
						nhanVienFacade.suaNhanVien(nv);
						loadFullDuLieu(2);
						loadData_NV1(lsNV);
						lblThongBao.setText("S???a th??nh c??ng");
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
		
				
			}});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaNV.setText(table.getValueAt(row,0).toString());
				txtTenNV.setText(table.getValueAt(row,1).toString());
				cbxGioiTinh.setSelectedItem(table.getValueAt(row, 2));
				txtsoDT.setText(table.getValueAt(row,3).toString());
				txtDiaChi.setText(table.getValueAt(row,4).toString());
				txtCMND.setText(table.getValueAt(row,5).toString());
				txtTaiKhoan.setText(table.getValueAt(row,6).toString());
				cboChucVu.setSelectedItem(table.getValueAt(row,7).toString());
				txtEmail.setText(table.getValueAt(row,8).toString());
				txtTaiKhoan.setEditable(false);
			}
		});
}

//---------------------------------------------------load--------------------------------------------------------------
	private void loadData_NV(List<NhanVien> lsNV2) {
		model_NV.getDataVector().removeAllElements();
		Object row = new Object();
		for (NhanVien nhanVien : lsNV2) {
			model_NV.addRow(new Object[] {nhanVien.getMaNV(),nhanVien.getHoTenNV(),nhanVien.getGioiTinh(),nhanVien.getDienThoai(),
					nhanVien.getDiaChi(),nhanVien.getcMND(),nhanVien.getTaiKhoan().getTaiKhoan(),nhanVien.getTaiKhoan().getChucVu(),nhanVien.getEmail()});
		} 
		table.setModel(model_NV);
	}
	private void loadData_NV1(List<String> maNV) {
		model_NV.getDataVector().removeAllElements();
		for (String nv : maNV) {
			try {
				NhanVien nhanVien= nhanVienFacade.timNhanVienTheoMa(nv);
				model_NV.addRow(new Object[] {nhanVien.getMaNV(),nhanVien.getHoTenNV(),nhanVien.getGioiTinh(),nhanVien.getDienThoai(),
						nhanVien.getDiaChi(),nhanVien.getcMND(),nhanVien.getTaiKhoan().getTaiKhoan(),nhanVien.getTaiKhoan().getChucVu(),nhanVien.getEmail()});

			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
	private void loadTieuDe() {
		// TODO Auto-generated method stub

		model_NV.addColumn("M?? NH??N VI??N");
		model_NV.addColumn("H??? T??N NV");
		model_NV.addColumn("GI???I T??NH");
		model_NV.addColumn("??I???N THO???I");
		model_NV.addColumn("?????A CH???");
		model_NV.addColumn("CMND");
		model_NV.addColumn("T??I KHO???N");
		model_NV.addColumn("CH???C V???");
		model_NV.addColumn("EMAIL");
		table.setModel(model_NV);
	}
	private void loadFullDuLieu(int k) {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			PhieuMuonFacade phieuMuonFacade = (PhieuMuonFacade) Naming
					.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/phieuMuonFacade");
			DiaCDFacade diaCDFacade = (DiaCDFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/diaCDFacade");
			NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/nhanVienFacade");
			ThanhVienFacade thanhVienFacade = (ThanhVienFacade) Naming
					.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/thanhVienFacade");
			PhieuTraFacade phieuTraFacade = (PhieuTraFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/phieuTraFacade");

			if (lsPm != null || lsNV != null || lsNV != null || lsCD != null) {
				lsPm.clear();
				lsNV.clear();
				lsTV.clear();
				lsCD.clear();
			}

			if (k == 0) {
				lsPm = phieuMuonFacade.getAllPhieuMuon(); // 1
				lsNV = nhanVienFacade.getAllNhanVien(); // 2
				lsTV = thanhVienFacade.getAllThanhVien(); // 3
				lsCD = diaCDFacade.getAllDiaCD(); // 4
				lsPT = phieuTraFacade.getAllPhieuTra(); // 5
			} else if (k == 1) {
				lsPm = phieuMuonFacade.getAllPhieuMuon();
			} else if (k == 2) {
				lsNV = nhanVienFacade.getAllNhanVien();
			} else if (k == 3) {
				lsTV = thanhVienFacade.getAllThanhVien();
			} else if (k == 4) {
				lsCD = diaCDFacade.getAllDiaCD();
			} else if (k == 5) {
				lsPT = phieuTraFacade.getAllPhieuTra();
			}

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
