package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entity.PhieuMuon;
import entity.ThanhVien;
import entity.TheThanhVien;
import facade.ThanhVienFacade;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class FrmThanhVien extends JPanel {
	
	private JPanel contentPane;
	private JTextField txtTim;
	private JTable table_ThanhVien;
	List<ThanhVien> lsTV;

	ThanhVienFacade thanhVienFacade;

//	DefaultTableModel model_PM = new DefaultTableModel();
	DefaultTableModel model_ThanhVien = new DefaultTableModel();
	private JTextField txtMaThanhVien;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtSoCMND;
	private JLabel lblThongBao_1;
	InetAddress myIP;
	public FrmThanhVien() throws RemoteException {	
		try {
			myIP = InetAddress.getLocalHost();
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		};
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			thanhVienFacade = (ThanhVienFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/thanhVienFacade");
			// trước khi load dữ liệu in thử ra class App xem đc ko
//			lsTV = thanhVienFacade.getAllThanhVien();
//			for (ThanhVien re : lsTV) {
//				System.out.println(re.getTheThanhVien().getNgayMo());
//				System.out.println(re.getTheThanhVien().getNgayHetHan());
//			}

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
		panel.setBounds(0, 0, 1390, 835);
		add(panel);
		panel.setLayout(null);

		JPanel panel_ThanhVien = new JPanel();
		panel_ThanhVien.setBounds(10, 44, 1370, 389);
		panel_ThanhVien.setLayout(null);
		panel_ThanhVien.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_ThanhVien);

//		Vector<String> KH = new Vector<String>();
//		for (ThanhVien tv : lsTV) {
//			KH.add(tv.getMaThanhVien());
//		}
//		
//		Vector<String> NV = new Vector<String>();
//		for (NhanVien nv : lsNV) {
//			NV.add(nv.getMaNV());
//		}

		JLabel lblMaThanhVien = new JLabel("Mã Thành Viên :");
		lblMaThanhVien.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMaThanhVien.setBounds(46, 53, 165, 25);
		panel_ThanhVien.add(lblMaThanhVien);

		txtMaThanhVien = new JTextField();
		txtMaThanhVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaThanhVien.setColumns(10);
		txtMaThanhVien.setBounds(211, 48, 255, 37);
		panel_ThanhVien.add(txtMaThanhVien);

		JLabel lblHoTen = new JLabel("Họ Tên :");
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHoTen.setBounds(114, 134, 76, 25);
		panel_ThanhVien.add(lblHoTen);

		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(211, 129, 255, 37);
		panel_ThanhVien.add(txtHoTen);

		JLabel lblDiaChi = new JLabel("Địa Chỉ :");
		lblDiaChi.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDiaChi.setBounds(114, 216, 85, 25);
		panel_ThanhVien.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(211, 211, 255, 37);
		panel_ThanhVien.add(txtDiaChi);

		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại :");
		lblSoDienThoai.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(58, 305, 140, 25);
		panel_ThanhVien.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(211, 300, 255, 37);
		panel_ThanhVien.add(txtSoDienThoai);

		JLabel lblSoCMND = new JLabel("Số Chứng Minh Nhân Dân :");
		lblSoCMND.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSoCMND.setBounds(503, 53, 255, 25);
		panel_ThanhVien.add(lblSoCMND);

		txtSoCMND = new JTextField();
		txtSoCMND.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoCMND.setColumns(10);
		txtSoCMND.setBounds(774, 48, 230, 37);
		panel_ThanhVien.add(txtSoCMND);

		JLabel lblGioiTinh = new JLabel("Giới Tính :");
		lblGioiTinh.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGioiTinh.setBounds(654, 134, 98, 25);
		panel_ThanhVien.add(lblGioiTinh);

		Vector<String> gioitinh = new Vector<String>();
		gioitinh.add("Nam");
		gioitinh.add("Nữ");
		JComboBox cboGioiTinh = new JComboBox(gioitinh);
//		cboGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cboGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboGioiTinh.setBounds(774, 128, 230, 38);
		panel_ThanhVien.add(cboGioiTinh);

		JLabel lblNgayMoThe = new JLabel("Ngày Mở Thẻ :");
		lblNgayMoThe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNgayMoThe.setBounds(615, 216, 148, 25);
		panel_ThanhVien.add(lblNgayMoThe);

		JDateChooser dtc_NgayMoThe = new JDateChooser();
		dtc_NgayMoThe.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 25));
		dtc_NgayMoThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtc_NgayMoThe.setDateFormatString("dd-MM-yyyy");
		dtc_NgayMoThe.setBounds(774, 211, 230, 37);
		panel_ThanhVien.add(dtc_NgayMoThe);

		JLabel lblNgyHtHn = new JLabel("Ngày Hết Hạn :");
		lblNgyHtHn.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNgyHtHn.setBounds(615, 305, 148, 25);
		panel_ThanhVien.add(lblNgyHtHn);

		JDateChooser dtc_NgayHetHan = new JDateChooser();
		dtc_NgayHetHan.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 25));
		dtc_NgayHetHan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtc_NgayHetHan.setDateFormatString("dd-MM-yyyy");
		dtc_NgayHetHan.setBounds(774, 293, 230, 37);
		panel_ThanhVien.add(dtc_NgayHetHan);

		JButton btnThem_1 = new JButton("Thêm");
		btnThem_1.setIcon(new ImageIcon(FrmThanhVien.class.getResource("/icon_trangchu/icons8_add_48px.png")));
		btnThem_1.addActionListener(new ActionListener() {// thêm thành viên
			public void actionPerformed(ActionEvent e) {
				if (txtMaThanhVien.getText().equals("") || txtHoTen.getText().equals("")
						|| txtSoDienThoai.getText().equals("") || txtDiaChi.getText().equals("")
						|| txtSoCMND.getText().equals("")) {
					lblThongBao_1.setText("Vui lòng nhập đủ thông tin");
				}else {
					try {
						int i=0;
						for (ThanhVien rs : lsTV) {
							if(rs.getMaThanhVien().equals(txtMaThanhVien.getText()))
								i=1;
						}
						if(i==0) {
							TheThanhVien a = new TheThanhVien(dtc_NgayMoThe.getCalendar().getTime(),
									dtc_NgayHetHan.getCalendar().getTime());
							ThanhVien tv = new ThanhVien(txtMaThanhVien.getText(), txtHoTen.getText(),
									cboGioiTinh.getSelectedItem().toString(), txtSoDienThoai.getText(), txtDiaChi.getText(),
									txtSoCMND.getText(), a);
							
							thanhVienFacade.themThanhVien(tv);
							loadFullDuLieu(0);
							loadData_ThanhVien(lsTV);
							lblThongBao_1.setText("Thêm thành công");
						}else {
							lblThongBao_1.setText("Thành Viên đã tồn tại");
						}
					

					} catch (Exception e2) {
						e2.printStackTrace();
						lblThongBao_1.setText("Thêm không thành công");
					}
				}
			}
		});
		btnThem_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem_1.setBounds(1183, 27, 129, 48);
		panel_ThanhVien.add(btnThem_1);

		JButton btnXoa_1 = new JButton("Xóa ");
		btnXoa_1.setIcon(new ImageIcon(FrmThanhVien.class.getResource("/icon_trangchu/icons8_remove_30px.png")));
		btnXoa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTim.getText().equals("")) {
					lblThongBao_1.setText("Chưa chọn thành viên");
				}else {
					ThanhVien tv = new ThanhVien(txtMaThanhVien.getText().toString());
					try {
						thanhVienFacade.xoaThanhVien(tv);
						loadFullDuLieu(0);
						loadData_ThanhVien(lsTV);
						lblThongBao_1.setText("Xoá Thành Công");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}	
			}
		});
		btnXoa_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa_1.setBounds(1183, 118, 129, 48);
		panel_ThanhVien.add(btnXoa_1);

		JButton btnSua_1 = new JButton("Sửa");
		btnSua_1.setIcon(new ImageIcon(FrmThanhVien.class.getResource("/icon_trangchu/icons8_edit_24px.png")));
		btnSua_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMaThanhVien.getText().equals("")) {
					lblThongBao_1.setText("Chưa chọn thành viên");
				}else {
					ThanhVien tv = new ThanhVien(txtMaThanhVien.getText(), txtHoTen.getText(),
							cboGioiTinh.getSelectedItem().toString(), txtSoDienThoai.getText(), txtDiaChi.getText(),
							txtSoCMND.getText(), new TheThanhVien(dtc_NgayMoThe.getCalendar().getTime(),
									dtc_NgayHetHan.getCalendar().getTime()));
					try {
						thanhVienFacade.suaThanhVien(tv);
						loadFullDuLieu(0);
						loadData_ThanhVien(lsTV);
						lblThongBao_1.setText("Sửa thành công");

					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnSua_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSua_1.setBounds(1183, 204, 129, 48);
		panel_ThanhVien.add(btnSua_1);

		lblThongBao_1 = new JLabel("Thông Báo !");
		lblThongBao_1.setIcon(new ImageIcon(FrmThanhVien.class.getResource("/icon_trangchu/icons8_error_30px.png")));
		lblThongBao_1.setForeground(Color.RED);
		lblThongBao_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblThongBao_1.setBounds(71, 340, 410, 37);
		panel_ThanhVien.add(lblThongBao_1);

		JButton btnTaiLai = new JButton("Tải Lại");
		btnTaiLai.setIcon(new ImageIcon(FrmThanhVien.class.getResource("/icon_trangchu/icons8_spinner_40px.png")));
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaThanhVien.setText("");
				cboGioiTinh.setSelectedIndex(0);
				txtHoTen.setText("");
				txtDiaChi.setText("");
				txtSoCMND.setText("");
				txtSoDienThoai.setText("");
				txtTim.setText("");

				dtc_NgayMoThe.setCalendar(Calendar.getInstance());
				dtc_NgayHetHan.setCalendar(Calendar.getInstance());
				loadData_ThanhVien(lsTV);

			}
		});
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTaiLai.setBounds(1183, 282, 129, 48);
		panel_ThanhVien.add(btnTaiLai);

		JPanel panel_ChuaTableThanhVien = new JPanel();
		panel_ChuaTableThanhVien.setBounds(10, 443, 1370, 470);
		panel_ChuaTableThanhVien.setLayout(null);
		panel_ChuaTableThanhVien.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_ChuaTableThanhVien);

		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setLayout(null);
		panel_TimKiem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TimKiem.setBounds(10, 10, 1350, 69);
		panel_ChuaTableThanhVien.add(panel_TimKiem);

		JLabel lblThongTinCD = new JLabel("DANH SÁCH THÀNH VIÊN");
		lblThongTinCD.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblThongTinCD.setBounds(10, 20, 365, 30);
		panel_TimKiem.add(lblThongTinCD);

		JLabel lblTim = new JLabel("Nhập từ khoá :");
		lblTim.setForeground(Color.RED);
		lblTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTim.setBounds(480, 22, 146, 26);
		panel_TimKiem.add(lblTim);

		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTim.setColumns(10);
		txtTim.setBounds(636, 15, 305, 40);
		panel_TimKiem.add(txtTim);

		JComboBox cboLoaiTimThanhVien = new JComboBox();
		cboLoaiTimThanhVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		cboLoaiTimThanhVien.setModel(new DefaultComboBoxModel(new String[] {"Tìm theo mã", "Tìm theo họ tên", "Tìm theo số điện thoại"}));
		cboLoaiTimThanhVien.setBounds(1092, 20, 225, 35);
		panel_TimKiem.add(cboLoaiTimThanhVien);

		JButton btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(FrmThanhVien.class.getResource("/icon_trangchu/icons8_search_40px.png")));
		btnTim.setBounds(959, 15, 123, 40);
		panel_TimKiem.add(btnTim);

		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		btnTim.setIcon(new ImageIcon("..\\QuanLyCD_FinalProject\\img\\search_32px.png"));

		JPanel panel_TableThanhVien = new JPanel();
		panel_TableThanhVien.setBounds(10, 82, 1350, 331);
		panel_ChuaTableThanhVien.add(panel_TableThanhVien);
		panel_TableThanhVien.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_TableThanhVien.add(scrollPane_1);

		table_ThanhVien = new JTable();
		table_ThanhVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_ThanhVien.getSelectedRow();
				txtMaThanhVien.setText(table_ThanhVien.getValueAt(row, 0).toString());
				txtHoTen.setText(table_ThanhVien.getValueAt(row, 1).toString());
				txtDiaChi.setText(table_ThanhVien.getValueAt(row, 2).toString());
				txtSoDienThoai.setText(table_ThanhVien.getValueAt(row, 3).toString());
				txtSoCMND.setText(table_ThanhVien.getValueAt(row, 4).toString());
				cboGioiTinh.setSelectedItem(table_ThanhVien.getValueAt(row, 5));
				String ngayMoThe = table_ThanhVien.getValueAt(row, 6).toString();
				try {
					Date date = new SimpleDateFormat("dd-MM-yyyy").parse(ngayMoThe);
					dtc_NgayMoThe.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String ngayHetHan = table_ThanhVien.getValueAt(row, 7).toString();
				try {
					Date date = new SimpleDateFormat("dd-MM-yyyy").parse(ngayHetHan);
					dtc_NgayHetHan.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(table_ThanhVien);
		// Tự động dàn cột cho vừa với dữ liệu
		table_ThanhVien.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		loadTIeuDe_ThanhVien();
		loadData_ThanhVien(lsTV);

		JLabel lblTieuDe = new JLabel("THÀNH VIÊN");
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(0, 0, 1390, 37);
		panel.add(lblTieuDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTim.getText().equals("")) {
					lblThongBao_1.setText("Tìm rỗng");
				}else {
					if(cboLoaiTimThanhVien.getSelectedItem().equals("Tìm theo mã")) {				
						try {
							List<ThanhVien>tv=new ArrayList<ThanhVien>();
							ThanhVien thanhvien=thanhVienFacade.timThanhVienTheoMa(txtTim.getText().toString());	
							tv.add(thanhvien);
							if(thanhvien==null) {
								lblThongBao_1.setText("Không tìm thấy");
							}else {
								loadData_ThanhVien(tv);
							}
						} catch (RemoteException e1) {
							
							e1.printStackTrace();
						}
					}
					else if(cboLoaiTimThanhVien.getSelectedItem().equals("Tìm theo họ tên")) {
						try {
							List<ThanhVien> tv= new ArrayList<ThanhVien>();
		//					List<ThanhVien>dstv=thanhVienFacade.timThanhVienTheoHoTen(txtTim.getText());
							for (ThanhVien rs : lsTV) {
								if(rs.getHoTen().toLowerCase().contains(txtTim.getText().toLowerCase())) {
									tv.add(rs);
								}
							}
						
							if(tv.isEmpty()) {
								lblThongBao_1.setText("Không tìm thấy");
							}else {
								loadData_ThanhVien(tv);
							}
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
					}
					else if(cboLoaiTimThanhVien.getSelectedItem().equals("Tìm theo số điện thoại")) {
						try {
							List<ThanhVien>dstv= thanhVienFacade.timThanhVienTheoSDT(txtTim.getText().toString());				
							if(dstv.isEmpty()) {
								lblThongBao_1.setText("Không tìm thấy");
							}else {
								loadData_ThanhVien(dstv);
							}
						} catch (RemoteException e1) {
							
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}


	private void loadTIeuDe_ThanhVien() {
		model_ThanhVien.addColumn("Mã Thành Viên");
		model_ThanhVien.addColumn("Họ Tên");
		model_ThanhVien.addColumn("Địa Chỉ");
		model_ThanhVien.addColumn("Số Điện Thoại");
		model_ThanhVien.addColumn("Số CMND");
		model_ThanhVien.addColumn("Giới Tính");
		model_ThanhVien.addColumn("Ngày Mở Thẻ");
		model_ThanhVien.addColumn("Ngày Hết Hạn");
		table_ThanhVien.setModel(model_ThanhVien);
	}


	private void loadData_ThanhVien(List<ThanhVien> listThanhVien) {
		model_ThanhVien.getDataVector().removeAllElements();
		Object row = new Object();
		SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
		for (ThanhVien tv : listThanhVien) {
			model_ThanhVien.addRow(new Object[] { tv.getMaThanhVien(), tv.getHoTen(), tv.getDiaChi(), tv.getDienThoai(),
					tv.getSoCMND(), tv.getGioiTinh(), fm.format(tv.getTheThanhVien().getNgayMo()),
					fm.format(tv.getTheThanhVien().getNgayHetHan()) });
		}
		table_ThanhVien.setModel(model_ThanhVien);
	}

	public void loadFullDuLieu(int k) {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			ThanhVienFacade thanhVienFacade = (ThanhVienFacade) Naming
					.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/thanhVienFacade");
			if (lsTV != null) {
				lsTV.clear();
			}

			// Chỉ cần thành viên không cần thông tin bảng khác nên ko gọi nhiều
			if (k == 0) {
				lsTV = thanhVienFacade.getAllThanhVien(); // 3
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
