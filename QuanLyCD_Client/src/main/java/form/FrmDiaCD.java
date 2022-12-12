package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.DiaCD;
import entity.NhanVien;
import entity.PhieuMuon;
import entity.PhieuTra;
import entity.ThanhVien;
import facade.DiaCDFacade;
import facade.NhanVienFacade;
import facade.PhieuMuonFacade;
import facade.PhieuTraFacade;
import facade.ThanhVienFacade;

public class FrmDiaCD extends JPanel {
	private JTextField txtMaDiaCD;
	private JTextField txtTenDiaCD;
	private JTextField txtNSX;
	private JTextField txtGhiChu;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
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

	DefaultTableModel model_CD = new DefaultTableModel();
	InetAddress myIP;

	/**
	 * Create the panel.
	 */
	public FrmDiaCD() throws RemoteException {
		try {
			myIP=InetAddress.getLocalHost();
		} catch (UnknownHostException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			diaCDFacade = (DiaCDFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/diaCDFacade");
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

		JLabel lblTitle = new JLabel("Danh Mục Đĩa CD");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setBounds(594, 10, 232, 36);
		add(lblTitle);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 75, 1380, 253);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaDiaCD = new JLabel("Mã đĩa CD");
		lblMaDiaCD.setBounds(27, 6, 91, 20);
		lblMaDiaCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblMaDiaCD);

		txtMaDiaCD = new JTextField();
		txtMaDiaCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaDiaCD.setColumns(10);
		txtMaDiaCD.setBounds(128, 3, 235, 31);
		panel_1.add(txtMaDiaCD);

		JLabel lblTenDiaCD = new JLabel("Tên Đĩa CD");
		lblTenDiaCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenDiaCD.setBounds(27, 79, 91, 20);
		panel_1.add(lblTenDiaCD);

		txtTenDiaCD = new JTextField();
		txtTenDiaCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenDiaCD.setColumns(10);
		txtTenDiaCD.setBounds(128, 68, 235, 31);
		panel_1.add(txtTenDiaCD);

		JLabel lblTheLoai = new JLabel("Thể Loại");
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTheLoai.setBounds(446, 6, 91, 20);
		panel_1.add(lblTheLoai);

		JLabel lblTinhTrang = new JLabel("Tình Trạng");
		lblTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTinhTrang.setBounds(446, 77, 91, 20);
		panel_1.add(lblTinhTrang);

		JComboBox cbxTheLoai = new JComboBox(
				new Object[] { "Hoạt Hình", "18+", "16+", "Kinh Dị", "Hoang Tưởng", "Khoa Học", "Viễn Tưởng", "Hài" });
		cbxTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxTheLoai.setBounds(573, 3, 235, 31);
		panel_1.add(cbxTheLoai);

		JComboBox cbxTinhTrang = new JComboBox(new Object[] { "Mới", "Cũ" });
		cbxTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxTinhTrang.setBounds(573, 68, 235, 31);
		panel_1.add(cbxTinhTrang);

		JLabel lblNSX = new JLabel("Nhà Xuất Bản");
		lblNSX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNSX.setBounds(905, 6, 110, 20);
		panel_1.add(lblNSX);

		txtNSX = new JTextField();
		txtNSX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNSX.setColumns(10);
		txtNSX.setBounds(1043, 3, 235, 31);
		panel_1.add(txtNSX);

		JLabel lblGhiChu = new JLabel("Ghi Chú");
		lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGhiChu.setBounds(905, 79, 110, 20);
		panel_1.add(lblGhiChu);

		txtGhiChu = new JTextField();
		txtGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGhiChu.setColumns(10);
		txtGhiChu.setBounds(1043, 68, 235, 31);
		panel_1.add(txtGhiChu);

		JLabel lblSoLuong = new JLabel("Số Lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoLuong.setBounds(27, 147, 91, 20);
		panel_1.add(lblSoLuong);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(128, 134, 235, 31);
		panel_1.add(txtSoLuong);

		JLabel lblDonGia = new JLabel("Đơn Giá");
		lblDonGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDonGia.setBounds(446, 143, 91, 20);
		panel_1.add(lblDonGia);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(573, 136, 235, 31);
		panel_1.add(txtDonGia);

		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(FrmDiaCD.class.getResource("/icon_trangchu/icons8_add_48px.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(27, 195, 142, 33);
		panel_1.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(FrmDiaCD.class.getResource("/icon_trangchu/icons8_remove_30px.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(215, 195, 142, 33);
		panel_1.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(FrmDiaCD.class.getResource("/icon_trangchu/icons8_edit_24px.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(407, 195, 142, 33);
		panel_1.add(btnSua);

		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(790, 196, 192, 31);
		panel_1.add(txtTimKiem);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(FrmDiaCD.class.getResource("/icon_trangchu/icons8_search_40px.png")));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimKiem.setBounds(1213, 195, 157, 33);
		panel_1.add(btnTimKiem);

		JLabel lblThongBao = new JLabel("Thông Báo !");
		lblThongBao.setIcon(new ImageIcon(FrmDiaCD.class.getResource("/icon_trangchu/icons8_error_30px.png")));
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblThongBao.setBounds(924, 142, 247, 25);
		panel_1.add(lblThongBao);

		JButton btnTaiLai = new JButton("Tải Lại");
		btnTaiLai.setIcon(new ImageIcon(FrmDiaCD.class.getResource("/icon_trangchu/icons8_spinner_40px.png")));
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTaiLai.setBounds(599, 195, 142, 33);
		panel_1.add(btnTaiLai);

		JComboBox cbxTimKiem = new JComboBox(new Object[] { "Tìm Theo Mã", "Tìm Theo Tên", "Tìm Theo Thể Loại" });
		cbxTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxTimKiem.setBounds(1002, 196, 201, 31);
		panel_1.add(cbxTimKiem);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 353, 1380, 482);
		add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		loadTieuDe();
		loadData_CD(lsCD);
//------------------------------------------------Chức năng-------------------------------------------------------		
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtMaDiaCD.getText().equals("") || txtDonGia.getText().equals("") || txtGhiChu.getText().equals("") || 
						txtNSX.getText().equals("") || txtSoLuong.getText().equals("") || txtTenDiaCD.getText().equals("")) {
					lblThongBao.setText("Lỗi nhập liệu, nhập lại");
				}else {
					int i = 0;
					for (DiaCD diaCD : lsCD) {
						if(txtMaDiaCD.getText().equals(diaCD.getMaDia()))
							i=1;
					}
					if(i==0) {
						// DiaCD cd = new DiaCD("0000");
						DiaCD cd1 = new DiaCD(txtMaDiaCD.getText(), txtTenDiaCD.getText(),
								cbxTheLoai.getSelectedItem().toString(), cbxTinhTrang.getSelectedItem().toString(),
								txtNSX.getText(), txtGhiChu.getText(), Integer.parseInt(txtSoLuong.getText().toString()),
								Double.parseDouble(txtDonGia.getText().toString()));
						try {
							diaCDFacade.themDiaCD(cd1);
							loadFullDuLieu(4);
							loadData_CD(lsCD);
							;
							lblThongBao.setText("Thêm Thành Công");
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						lblThongBao.setText("CD đã tồn tại");
					}
				
				}
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMaDiaCD.getText().equals("")) {
					lblThongBao.setText("Chưa chọn đĩa");
				}else {
					int row = table.getSelectedRow();
					String maCD = table.getValueAt(row, 0).toString();
					if (txtMaDiaCD == null) {
						lblThongBao.setText("Chưa chọn đĩa");
					} else {
						DiaCD CD;
						try {
							CD = diaCDFacade.timCDTheoMa(txtMaDiaCD.getText().toString());
							// System.out.println(CD);
							// lsCD.remove(maCD);
//							DecimalFormat df = new DecimalFormat("###,###.## VND");

							// DiaCD cd = new
							// DiaCD(txtMaDiaCD.getText(),txtTenDiaCD.getText(),cbxTinhTrang.getSelectedItem().toString(),cbxTheLoai.getSelectedItem().toString(),txtNSX.getText(),txtGhiChu.getText(),Integer.parseInt(txtSoLuong.getText().toString()),Double.parseDouble(txtDonGia.getText().toString()));
							DiaCD cd = new DiaCD(CD.getMaDia());
							diaCDFacade.xoaDiaCD(cd);
							loadFullDuLieu(4);
							loadData_CD(lsCD);
							lblThongBao.setText("Xóa Thành Công");
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}
				}

				}
			}
		});
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaDiaCD.setText("");
				txtTenDiaCD.setText("");
				cbxTinhTrang.setSelectedIndex(0);
				cbxTheLoai.setSelectedIndex(0);
				txtNSX.setText("");
				txtGhiChu.setText("");
				txtSoLuong.setText("");
				txtDonGia.setText("");
				loadData_CD(lsCD);
				table.setModel(model_CD);
			}
		});
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTimKiem.getText().equals("")) {
					lblThongBao.setText("Tìm rỗng");
				}else {
					if (cbxTimKiem.getSelectedItem().equals("Tìm Theo Mã")) {
						try {
							List<String> dsCD = new ArrayList<String>();
							DiaCD cd = diaCDFacade.timCDTheoMa(txtTimKiem.getText().toString());
							if (dsCD.size() == 0) {
								lblThongBao.setText("Mã Không Tồn Tại");
							} else
								dsCD.add(cd.getMaDia());
							loadData_CD1(dsCD);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (cbxTimKiem.getSelectedItem().equals("Tìm Theo Tên")) {
						List<DiaCD> dsCD = new ArrayList<DiaCD>();
						try {
							for (DiaCD cd : lsCD) {
								if(cd.getTenDia().toLowerCase().contains(txtTimKiem.getText().toLowerCase())) {
									dsCD.add(cd);
								}
							}
//							dsCD = diaCDFacade.timCDTheoTen(txtTimKiem.getText().toString());
							if (dsCD.size() == 0) {
								lblThongBao.setText("Tên không tồn tại");
							} else
								loadData_CD(dsCD);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							lblThongBao.setText("Lỗi Nhập liệu");
						}
					} else if (cbxTimKiem.getSelectedItem().equals("Tìm Theo Thể Loại")) {
						List<DiaCD> dsCD = new ArrayList<DiaCD>();
						try {
//							dsCD = diaCDFacade.timCDTheoTheLoai(txtTimKiem.getText().toString());
							for (DiaCD cd : lsCD) {
								if(cd.getTheLoai().toLowerCase().contains(txtTimKiem.getText().toLowerCase())) {
									dsCD.add(cd);
								}
							}
							if (dsCD.size() == 0) {
								lblThongBao.setText("Thể loại không tồn tại");
							} else
								loadData_CD(dsCD);
							;
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			}
		});
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtMaDiaCD.getText().equals("")) {
					lblThongBao.setText("Chưa chọn đĩa CD");
				}else {
					List<String> lsCD = new ArrayList<String>();
					DecimalFormat df = new DecimalFormat("###,###.## VND");
					int row = model_CD.getRowCount();
					for (int i = 0; i < row; i++) {
						lsCD.add(table.getValueAt(i, 0).toString());
					}

					DiaCD cd = new DiaCD(txtMaDiaCD.getText(), txtTenDiaCD.getText(),
							cbxTinhTrang.getSelectedItem().toString(), cbxTheLoai.getSelectedItem().toString(),
							txtNSX.getText(), txtGhiChu.getText(), Integer.parseInt(txtSoLuong.getText().toString()),
							Double.parseDouble(txtDonGia.getText().toString()));
//					DiaCD cd;
//					try {
//						cd = diaCDFacade.timCDTheoMa(txtMaDiaCD.getText().toString());
//						cd.setTenDia(txtTenDiaCD.getText());
//						cd.setTinhTrang(cbxTinhTrang.getSelectedItem().toString());
//						cd.setTheLoai(cbxTheLoai.getSelectedItem().toString());
//						cd.setHangSanXuat(txtNSX.getText());
//						cd.setGhiChu(txtGhiChu.getText());
//						cd.setSoLuong(Integer.parseInt(txtSoLuong.getText().toString()));
//					} catch (RemoteException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					try {
						diaCDFacade.suaDiaCD(cd);
						loadFullDuLieu(4);
						loadData_CD1(lsCD);
						lblThongBao.setText("Sửa thành công");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}

		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaDiaCD.setText(table.getValueAt(row, 0).toString());
				txtTenDiaCD.setText(table.getValueAt(row, 1).toString());
				cbxTheLoai.setSelectedItem(table.getValueAt(row, 3));
				txtNSX.setText(table.getValueAt(row, 4).toString());
				txtGhiChu.setText(table.getValueAt(row, 5).toString());
				txtSoLuong.setText(table.getValueAt(row, 6).toString());
				
				try {
					DiaCD cd = diaCDFacade.timCDTheoMa(table.getValueAt(row, 0).toString());
					txtDonGia.setText(String.valueOf(cd.getDonGia()));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	

//				System.out.println(giaC);
			}
		});
	}

	// ------------------------------------------------Load-----------------------------------------------------------
	private void loadTieuDe() {
		model_CD.addColumn("MÃ ĐĨA CD");
		model_CD.addColumn("TÊN ĐĨA");
		model_CD.addColumn("TÌNH TRẠNG");
		model_CD.addColumn("THỂ LOẠI");
		model_CD.addColumn("NHÀ XUẤT BẢN");
		model_CD.addColumn("GHI CHÚ");
		model_CD.addColumn("SỐ LƯỢNG");
		model_CD.addColumn("ĐƠN GIÁ");
		table.setModel(model_CD);
	}

	private void loadData_CD(List<DiaCD> cd) {
		model_CD.getDataVector().removeAllElements();
		Object row = new Object();
		DecimalFormat df = new DecimalFormat("###,###.## VND");
		for (DiaCD diaCD : cd) {
			model_CD.addRow(new Object[] { diaCD.getMaDia(), diaCD.getTenDia(), diaCD.getTinhTrang(),
					diaCD.getTheLoai(), diaCD.getHangSanXuat(), diaCD.getGhiChu(), diaCD.getSoLuong(),
					df.format(diaCD.getDonGia()) });
		}
		table.setModel(model_CD);
	}

	private void loadData_CD1(List<String> maCD) {
		model_CD.getDataVector().removeAllElements();
		DecimalFormat df = new DecimalFormat("###,###.## VND");
		for (String cd : maCD) {
			try {
				DiaCD diaCD = diaCDFacade.timCDTheoMa(cd);
				model_CD.addRow(new Object[] { diaCD.getMaDia(), diaCD.getTenDia(), diaCD.getTinhTrang(),
						diaCD.getTheLoai(), diaCD.getHangSanXuat(), diaCD.getGhiChu(), diaCD.getSoLuong(),
						df.format(diaCD.getDonGia()) });
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		table.setModel(model_CD);
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
