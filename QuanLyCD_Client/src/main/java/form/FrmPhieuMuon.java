package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

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
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

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

public class FrmPhieuMuon extends JPanel {

	private JPanel contentPane;
	private JTextField txtMaPhieu;
	private JTextField txtHanMuon;
	private JTable table_PM;
	private JTextField txtTim;
	private JTextField txtTim_CD;
	private JTable table_CD;
	List<PhieuMuon>	lsPm;
	List<DiaCD> lsCD;
	List<NhanVien> lsNV;
	List<ThanhVien> lsTV;
	List<PhieuTra> lsPT;
	
	PhieuMuonFacade phieuMuonFacade;
	DiaCDFacade diaCDFacade;
	NhanVienFacade nhanVienFacade;
	ThanhVienFacade thanhVienFacade;
	PhieuTraFacade phieuTraFacade;
	
	
	DefaultTableModel model_PM = new DefaultTableModel();
	DefaultTableModel model_CD = new DefaultTableModel();
	InetAddress myIP;
	
	public FrmPhieuMuon() throws RemoteException {
		try {
			myIP = InetAddress.getLocalHost();
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		};
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
		panel.setBounds(0, 0, 1390, 835);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_PhieuMuon = new JPanel();
		panel_PhieuMuon.setBounds(10, 52, 1370, 381);
		panel_PhieuMuon.setLayout(null);
		panel_PhieuMuon.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_PhieuMuon);
		
		JPanel panel_ChucNang = new JPanel();
		panel_ChucNang.setLayout(null);
		panel_ChucNang.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_ChucNang.setBounds(1006, 10, 364, 373);
		panel_PhieuMuon.add(panel_ChucNang);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phiếu ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 23, 125, 25);
		panel_ChucNang.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Khách Hàng ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 58, 125, 25);
		panel_ChucNang.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày Mượn ");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 128, 125, 25);
		panel_ChucNang.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hạn Mượn ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(10, 163, 125, 25);
		panel_ChucNang.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Nhân Viên ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 93, 125, 25);
		panel_ChucNang.add(lblNewLabel_3);
		
		txtMaPhieu = new JTextField();
		txtMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPhieu.setColumns(10);
		txtMaPhieu.setBounds(145, 20, 212, 31);
		panel_ChucNang.add(txtMaPhieu);
		
		Vector<String> KH = new Vector<String>();
		KH.add("Khách Hàng");
		for (ThanhVien tv : lsTV) {
			KH.add(tv.getMaThanhVien());
		}
		JComboBox cboKhachHang = new JComboBox(KH);
		cboKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboKhachHang.setBounds(145, 55, 212, 31);
		panel_ChucNang.add(cboKhachHang);
		
		Vector<String> NV = new Vector<String>();
		NV.add("Nhân Viên");
		for (NhanVien nv : lsNV) {
			NV.add(nv.getMaNV());
		}
		JComboBox cboNhanVien = new JComboBox(NV);
		cboNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboNhanVien.setBounds(145, 90, 212, 31);
		panel_ChucNang.add(cboNhanVien);
		
		txtHanMuon = new JTextField();
		txtHanMuon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHanMuon.setColumns(10);
		txtHanMuon.setBounds(145, 160, 212, 31);
		panel_ChucNang.add(txtHanMuon);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_add_48px.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(10, 237, 125, 48);
		panel_ChucNang.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa ");
		btnXoa.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_remove_30px.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(145, 237, 101, 48);
		panel_ChucNang.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_edit_24px.png")));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(256, 237, 101, 48);
		panel_ChucNang.add(btnSua);
		
		JLabel lblThongBao = new JLabel("Thông Báo !");
		lblThongBao.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_error_30px.png")));
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblThongBao.setBounds(10, 321, 252, 25);
		panel_ChucNang.add(lblThongBao);
		
		JDateChooser dtc_NgayMuon = new JDateChooser();
		dtc_NgayMuon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtc_NgayMuon.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 25));
		dtc_NgayMuon.setDateFormatString("dd-MM-yyyy");
		dtc_NgayMuon.setBounds(145, 125, 209, 31);
		panel_ChucNang.add(dtc_NgayMuon);
		
		JButton btnTaiLai = new JButton("Tải Lại");
		btnTaiLai.setHorizontalAlignment(SwingConstants.RIGHT);
		btnTaiLai.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_spinner_40px.png")));
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTaiLai.setBounds(232, 308, 125, 50);
		panel_ChucNang.add(btnTaiLai);
		
		JPanel panel_Table = new JPanel();
		panel_Table.setBounds(10, 10, 986, 373);
		panel_PhieuMuon.add(panel_Table);
		panel_Table.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Table.add(scrollPane, BorderLayout.CENTER);
		
		table_PM = new JTable();
		table_PM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table_PM);
		loadTieuDe_PhieuMuon();
		loadData_PhieuMuon(lsPm);
		table_PM.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_PM.setAutoCreateRowSorter(true);
		
		JPanel panel_ChiTietPhieuMUon = new JPanel();
		panel_ChiTietPhieuMUon.setBounds(10, 443, 1370, 392);
		panel_ChiTietPhieuMUon.setLayout(null);
		panel_ChiTietPhieuMUon.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_ChiTietPhieuMUon);
		
		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setLayout(null);
		panel_TimKiem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_TimKiem.setBounds(10, 10, 1350, 69);
		panel_ChiTietPhieuMUon.add(panel_TimKiem);
		
		JLabel lblThongTinCD = new JLabel("THÔNG TIN CHI TIẾT PHIẾU MƯỢN");
		lblThongTinCD.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblThongTinCD.setBounds(10, 20, 328, 30);
		panel_TimKiem.add(lblThongTinCD);
		
		JLabel lblTim = new JLabel("Tìm Phiếu Mượn :");
		lblTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTim.setBounds(456, 22, 165, 26);
		panel_TimKiem.add(lblTim);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTim.setColumns(10);
		txtTim.setBounds(636, 15, 209, 35);
		panel_TimKiem.add(txtTim);
		
		JComboBox cboLoaiTimPM = new JComboBox(new Object[] {"Loại Tìm Kiếm", "Tìm Theo Mã", "Tìm Theo Tên KH","Tìm Kiếm Theo Tên NV", "Tìm Theo Ngày"});
		cboLoaiTimPM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboLoaiTimPM.setBounds(972, 16, 165, 34);
		panel_TimKiem.add(cboLoaiTimPM);
		
		JDateChooser dtcTim = new JDateChooser();
		dtcTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtcTim.setBounds(1150, 15, 172, 35);
		panel_TimKiem.add(dtcTim);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBounds(855, 15, 107, 43);
		panel_TimKiem.add(btnTim);
	
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTim.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_search_40px.png")));
		
		JPanel panel_TableCD = new JPanel();
		panel_TableCD.setBounds(10, 82, 989, 300);
		panel_ChiTietPhieuMUon.add(panel_TableCD);
		panel_TableCD.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_TableCD.add(scrollPane_1);

		
		table_CD = new JTable();
		scrollPane_1.setViewportView(table_CD);
		loadTIeuDe_CD();
		table_CD.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JPanel panel_ChucNang_CD = new JPanel();
		panel_ChucNang_CD.setLayout(null);
		panel_ChucNang_CD.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_ChucNang_CD.setBounds(1009, 82, 351, 300);
		panel_ChiTietPhieuMUon.add(panel_ChucNang_CD);
		
		JButton btnThemCD = new JButton("Thêm");
		btnThemCD.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_add_48px.png")));
		btnThemCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemCD.setBounds(10, 131, 125, 45);
		panel_ChucNang_CD.add(btnThemCD);
		
		JLabel lblNewLabel_9 = new JLabel("CD :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(10, 73, 53, 29);
		panel_ChucNang_CD.add(lblNewLabel_9);
		
		txtTim_CD = new JTextField();
		txtTim_CD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTim_CD.setColumns(10);
		txtTim_CD.setBounds(73, 77, 163, 29);
		panel_ChucNang_CD.add(txtTim_CD);
		
		JButton btnXoaCD = new JButton("Xóa");
		btnXoaCD.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_remove_30px.png")));
		btnXoaCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaCD.setBounds(155, 131, 117, 45);
		panel_ChucNang_CD.add(btnXoaCD);
		
		JLabel lblThongBao_CD = new JLabel("Thông Báo !");
		lblThongBao_CD.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_error_30px.png")));
		lblThongBao_CD.setForeground(Color.RED);
		lblThongBao_CD.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblThongBao_CD.setBounds(10, 265, 196, 25);
		panel_ChucNang_CD.add(lblThongBao_CD);
		
		JButton btnTimCD = new JButton("Tìm");
		btnTimCD.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_search_40px.png")));
		btnTimCD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimCD.setBounds(246, 60, 105, 61);
		panel_ChucNang_CD.add(btnTimCD);
		
		JComboBox cboLoaiTimCD = new JComboBox(new Object[] {"Tìm Theo Mã","Tìm Theo Tên", "Tìm Theo Thể Loại"});
		cboLoaiTimCD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboLoaiTimCD.setBounds(72, 22, 164, 29);
		panel_ChucNang_CD.add(cboLoaiTimCD);
		
		JButton btnNewButton_1 = new JButton("Tải Lại");
		btnNewButton_1.setIcon(new ImageIcon(FrmPhieuMuon.class.getResource("/icon_trangchu/icons8_spinner_40px.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(92, 186, 129, 61);
		panel_ChucNang_CD.add(btnNewButton_1);
		
		JButton btnInPM = new JButton("In PM");
		btnInPM.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInPM.setBounds(246, 229, 105, 61);
		panel_ChucNang_CD.add(btnInPM);
		
		JLabel lblTieuDe = new JLabel("PHIẾU MƯỢN");
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(10, 0, 1370, 53);
		panel.add(lblTieuDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//------------------------------------------------------------------------------------------action PhiueMuon-------------------------------------------------
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMaPhieu.getText().equals("")) {
					lblThongBao.setText("Chưa Nhập Mã");
				}
				else if(cboKhachHang.getSelectedItem().toString().equals("Khách Hàng")){
					lblThongBao.setText("Chưa Chọn Khách hàng");
				}
				else if(cboNhanVien.getSelectedItem().toString().equals("Nhân Viên")) {
					lblThongBao.setText("Chưa Chọn Nhân Viên");
				}
				else if(dtc_NgayMuon.getDate() == null) {
					dtc_NgayMuon.setDate(new Date());
				}
				else if(txtHanMuon.getText().equals("")) {
					lblThongBao.setText("Chưa Nhập hạn ngày mượn");
				}
				else {
					int i=0;
					for (PhieuMuon rs : lsPm) {
						if(rs.getMaPhieuMuon().equals(txtMaPhieu.getText()))
							i=1;
					}
					if(i==0) {
						DiaCD cd = new DiaCD("0000");
						PhieuMuon pm = new PhieuMuon(txtMaPhieu.getText(), new ThanhVien(cboKhachHang.getSelectedItem().toString()),
								new NhanVien(cboNhanVien.getSelectedItem().toString()), Arrays.asList(cd.getMaDia()), 1,
								dtc_NgayMuon.getCalendar().getTime(), Integer.parseInt(txtHanMuon.getText()),0);
						
						PhieuTra pt = new PhieuTra("PT"+txtMaPhieu.getText(), new ThanhVien(cboKhachHang.getSelectedItem().toString()),						
								new NhanVien(cboNhanVien.getSelectedItem().toString()), Arrays.asList(cd.getMaDia()), 1,
								dtc_NgayMuon.getCalendar().getTime(), Integer.parseInt(txtHanMuon.getText()), "Chưa Trả", new Date(), 0,0);
						try {
							phieuMuonFacade.themPhieuMuon(pm);
							phieuTraFacade.themPhieuTra(pt);
							loadFullDuLieu(1);
							loadData_PhieuMuon(lsPm);
							lblThongBao.setText("Thêm Thành Công");
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						lblThongBao.setText("Phiếu mượn đã tồn tại");
					}
				}					
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtMaPhieu.getText().equals("")) {
					PhieuMuon pm = new PhieuMuon(txtMaPhieu.getText());
					PhieuTra pt = new PhieuTra("PT"+txtMaPhieu.getText());
					try {
						PhieuTra ptTam = phieuTraFacade.timPhieuTraTheoMa(pt.getMaPhieuTra());
						if(!ptTam.getTrangThai().equals("Đã Trả")) {
							int row = table_CD.getRowCount();
							for (int i = 0 ;i<row ; i++) {
								DiaCD cdTam = diaCDFacade.timCDTheoMa(table_CD.getValueAt(i, 0).toString());
								int sl = cdTam.getSoLuong();
								cdTam.setSoLuong(sl+1);
								diaCDFacade.suaDiaCD(cdTam);
							}
						}
						phieuMuonFacade.xoaPhieuMuon(pm);
						phieuTraFacade.xoaPhieutra(pt);
						loadFullDuLieu(1);
						loadData_PhieuMuon(lsPm);
						lblThongBao.setText("Xóa Thành Công");
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else
					lblThongBao.setText("Chưa chọn phiếu");				
			}
		});
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMaPhieu.getText().equals("")) {
					lblThongBao.setText("Chưa chọn Phiếu Mượn");
				}else {
					List<String> lsCD = new ArrayList<String>();
					int row = model_CD.getRowCount();
					for (int i = 0; i < row; i++) {
						lsCD.add(table_CD.getValueAt(i, 0).toString());
					}				
					PhieuMuon pm = new PhieuMuon(txtMaPhieu.getText(), new ThanhVien(cboKhachHang.getSelectedItem().toString()),
							new NhanVien(cboNhanVien.getSelectedItem().toString()), lsCD, 1, dtc_NgayMuon.getCalendar().getTime(),
							Integer.parseInt(txtHanMuon.getText().toString()),0);
					
					PhieuTra pt = new PhieuTra("PT"+txtMaPhieu.getText(), new ThanhVien(cboKhachHang.getSelectedItem().toString()),
							new NhanVien(cboNhanVien.getSelectedItem().toString()), lsCD, 1, dtc_NgayMuon.getCalendar().getTime(), 
							Integer.parseInt(txtHanMuon.getText().toString()), "Chưa Trả", new Date(), 0,0);
					
					try {
						phieuTraFacade.suaPhieuTra(pt);
						phieuMuonFacade.suaPhieuMuon(pm);
						loadFullDuLieu(1);
						loadData_PhieuMuon(lsPm);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	
			}
		});
		//		JComboBox cboLoaiTimPM = new JComboBox(new Object[] {"Loại Tìm Kiếm", "Tìm Theo Mã", "Tìm Theo Tên", "Tìm Theo Ngày"});
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboLoaiTimPM.getSelectedItem().equals("Loại Tìm Kiếm")) {
					lblThongBao.setText("Chưa Chọn loại Tìm Kiếm");
				}
				else if(cboLoaiTimPM.getSelectedItem().equals("Tìm Theo Mã")) {
					try {
						List<PhieuMuon> pm = new ArrayList<PhieuMuon>();
						PhieuMuon PM = phieuMuonFacade.timPhieuMuonTheoMa(txtTim.getText().toString());
						pm.add(PM);
						if(PM == null) {
							lblThongBao.setText("Mã Không Tồn Tại");
						}
						else {
							loadData_PhieuMuon(pm);
						}					
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(cboLoaiTimPM.getSelectedItem().equals("Tìm Theo Tên KH")) {
					if(txtTim.getText().equals("")) {
						lblThongBao.setText("Tìm rỗng");
					}
					else {
						List<PhieuMuon> pm = new ArrayList<PhieuMuon>();
						try {
//							pm = phieuMuonFacade.timPhieuMuonTheoTenKhachHang(txtTim.getText().toString());
							for (PhieuMuon rs : lsPm) {
								if(rs.getThanhVien().getHoTen().toLowerCase().contains(txtTim.getText().toLowerCase())) {
									pm.add(rs);
								}
							}
							if(pm.size() == 0) {
								lblThongBao.setText("Tên Không Tồn Tại");
							}
							else
								loadData_PhieuMuon(pm);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}			
				}
				else if(cboLoaiTimPM.getSelectedItem().equals("Tìm Theo Ngày")) {
					if(dtc_NgayMuon.getDate() == null) {
						lblThongBao.setText("Chưa chọn ngày tìm");
					}
					else {
						List<PhieuMuon> pm = new ArrayList<PhieuMuon>();
						Date day = dtcTim.getDate();
						try {
							pm = phieuMuonFacade.timPhieuMuonTheoNgayMuon(day);
							if(pm == null) {
								lblThongBao.setText("Ngày Không Tồn Tại");
							}
							else
								loadData_PhieuMuon(pm);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}			
				}
				//
				else if(cboLoaiTimPM.getSelectedItem().equals("Tìm Kiếm Theo Tên NV")) {
					if(txtTim.getText().equals("")) {
						lblThongBao.setText("Tìm Rỗng");
					}
					else {
						List<PhieuMuon> pm = new ArrayList<PhieuMuon>();
						try {
//							pm = phieuMuonFacade.timPhieuMuonTheoTenNhanVien(txtTim.getText().toString());
							for (PhieuMuon rs : lsPm) {
								if(rs.getNhanVien().getHoTenNV().toLowerCase().contains(txtTim.getText().toLowerCase())) {
									pm.add(rs);
								}
							}
							System.out.println(pm.size());
							if(pm.size() == 0) {
								lblThongBao.setText("Tên Không Tồn Tại");
							}
							else
								loadData_PhieuMuon(pm);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}			
				}
			}
		});
		table_PM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table_PM.getSelectedRow();
				txtMaPhieu.setText(table_PM.getValueAt(row, 0).toString());
				for (ThanhVien tv : lsTV) {
					if(tv.getHoTen().equals(table_PM.getValueAt(row, 1))) {
						cboKhachHang.setSelectedItem(tv.getMaThanhVien());
					}
				}
				for (NhanVien nv : lsNV) {
					if(nv.getHoTenNV().equals(table_PM.getValueAt(row, 2))) {
						cboNhanVien.setSelectedItem(nv.getMaNV());
					}
				}
				String day = table_PM.getValueAt(row, 3).toString();
				try {
					Date date =  new SimpleDateFormat("dd-MM-yyyy").parse(day);
					dtc_NgayMuon.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtHanMuon.setText(table_PM.getValueAt(row, 4).toString());
				//update table_CD đọc hết dữ liệu từ lsCD nếu giống cái đang chọn thì lấy list đó về đồng thời update lên table_CD
				for (PhieuMuon pm : lsPm) {
					if(pm.getMaPhieuMuon().equals(table_PM.getValueAt(row, 0))) {
						loadData_CD(pm.getDiaCDs());
					}
				}
			}
		});
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaPhieu.setText("");
				cboKhachHang.setSelectedIndex(0);
				cboNhanVien.setSelectedIndex(0);
				//dtc_NgayMuon;
				txtHanMuon.setText("");
				
				loadData_PhieuMuon(lsPm);
				xoaTableCD();
			}
		});
//--------------------------------------------------------------------------------------------------action PhiueMuon-------------------------------------------------
//--------------------------------------------------------------------------------------------------action DiaCD-----------------------------------------------------	
		btnThemCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DiaCD cd = diaCDFacade.timCDTheoMa(txtTim_CD.getText().toString());
					if(txtMaPhieu.getText().equals("")) {
						lblThongBao_CD.setText("Chưa Chọn Phiếu");
					}
					else if(txtTim_CD.getText().equals("")) {
						lblThongBao_CD.setText("Chưa Nhập Mã CD");
					}
					else if(cd == null) {
						lblThongBao_CD.setText("CD Không Tồn Tại");
					}
					else {
						int i=0;
//						for (PhieuMuon rs : lsPm) {
//							if(rs.getMaPhieuMuon().equals(txtMaPhieu.getText()))
//								i=1;
//						}
//						if(i==0) 
						PhieuMuon PM = phieuMuonFacade.timPhieuMuonTheoMa(txtMaPhieu.getText());
						List<String> dsCD = PM.getDiaCDs();
						dsCD.add(cd.getMaDia());
						for (String rs : dsCD) {
							System.out.println(rs);
							if(rs.equals("0000")) {
								dsCD.remove(0);
							}
							else if(rs.equals(txtTim_CD.getText())) {								
								i=1;
								System.out.println(rs);
							}
						}
						if(true) {
							
							double tongTien = PM.getTongTien() + cd.getDonGia();
							
							PhieuMuon pm = new PhieuMuon(txtMaPhieu.getText(), new ThanhVien(cboKhachHang.getSelectedItem().toString()),
									new NhanVien(cboNhanVien.getSelectedItem().toString()), dsCD, 1, dtc_NgayMuon.getCalendar().getTime(),
									Integer.parseInt(txtHanMuon.getText().toString()),tongTien);
							
							List<String> dsTCD = new ArrayList<String>();
							for (String st : pm.getDiaCDs()) {
								dsTCD.add(st);
							}
								DiaCD cdTam = diaCDFacade.timCDTheoMa(txtTim_CD.getText());
								int sl = cdTam.getSoLuong();
								if(sl == 0) {
									lblThongBao_CD.setText("Đĩa CD đã hết");
								}
								else {
									cdTam.setSoLuong(sl-1);
									diaCDFacade.suaDiaCD(cdTam);
									
									PhieuTra pt = new PhieuTra("PT"+txtMaPhieu.getText(), new ThanhVien(cboKhachHang.getSelectedItem().toString()),						
											new NhanVien(cboNhanVien.getSelectedItem().toString()), 
											dsTCD, 1, dtc_NgayMuon.getCalendar().getTime(), Integer.parseInt(txtHanMuon.getText()), "Chưa Trả", new Date(), 0, tongTien/2);							
									phieuMuonFacade.suaPhieuMuon(pm);
									phieuTraFacade.suaPhieuTra(pt);
									
									loadFullDuLieu(1);
									loadData_PhieuMuon(lsPm);
									loadFullDuLieu(1);
									loadData_CD(dsCD);
									lblThongBao_CD.setText("Thêm Thành Công");
								}
						}else {
							lblThongBao_CD.setText("CD đã có trong giỏ hàng");
						}
						
								
										
					}										
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnXoaCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(txtMaPhieu.getText().equals("")) {
					lblThongBao_CD.setText("Chưa Chon Phiếu");
				}
				else {
					try {
						int row = table_CD.getSelectedRow();
						String maCD = table_CD.getValueAt(row, 0).toString();
						//Sủa Dĩa CD khi xóa 1 cd
						DiaCD cdTam = diaCDFacade.timCDTheoMa(table_CD.getValueAt(row, 0).toString());
						int sl = cdTam.getSoLuong();
						cdTam.setSoLuong(sl+1);
						diaCDFacade.suaDiaCD(cdTam);
						
					
						PhieuMuon PM = phieuMuonFacade.timPhieuMuonTheoMa(txtMaPhieu.getText().toString());
						List<String> dsCD = PM.getDiaCDs();
						dsCD.remove(maCD);
						
						double tongTien = PM.getTongTien() - cdTam.getDonGia();
						
						PhieuMuon pm = new PhieuMuon(txtMaPhieu.getText(), new ThanhVien(cboKhachHang.getSelectedItem().toString()),
								new NhanVien(cboNhanVien.getSelectedItem().toString()), dsCD, 1, dtc_NgayMuon.getCalendar().getTime(),
								Integer.parseInt(txtHanMuon.getText().toString()), tongTien);
						phieuMuonFacade.suaPhieuMuon(pm);
						
						loadFullDuLieu(1);
						loadData_PhieuMuon(lsPm);
						loadData_CD(dsCD);
						lblThongBao_CD.setText("Xóa Thành Công");
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
								
				}
			}
		});
		//{"Tìm Theo Mã","Tìm Theo Tên", "Tìm Theo Thể Loại"});
		btnTimCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTim_CD.getText().equals("")) {
					lblThongBao_CD.setText("Tìm kiếm rỗng");
				}
				else {
					if(cboLoaiTimCD.getSelectedItem().equals("Tìm Theo Mã")) {
						try {
							List<String> dsCD = new ArrayList<String>();					
							DiaCD cd = diaCDFacade.timCDTheoMa(txtTim_CD.getText().toString());
							if(cd != null) {
								dsCD.add(cd.getMaDia());
								loadData_CD(dsCD);
							}
							else {
								lblThongBao_CD.setText("Sai mã CD");
							}						
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(cboLoaiTimCD.getSelectedItem().equals("Tìm Theo Tên")){
						List<String> dsCD = new ArrayList<String>();
						for (DiaCD rs : lsCD) {
							if(rs.getTenDia().equalsIgnoreCase(txtTim_CD.getText()))
								dsCD.add(rs.getMaDia());
						}
						if(dsCD.size() != 0) {
							loadData_CD(dsCD);	
						}	
						else
							lblThongBao_CD.setText("Sai tên CD");	
					}
					else if(cboLoaiTimCD.getSelectedItem().equals("Tìm Theo Thể Loại")) {
						List<String> dsCD = new ArrayList<String>();
						for (DiaCD rs : lsCD) {
							if(rs.getTheLoai().equalsIgnoreCase(txtTim_CD.getText()))
								dsCD.add(rs.getMaDia());
						}
						if(dsCD.size() !=0)
							loadData_CD(dsCD);
						else {
							lblThongBao_CD.setText("Tên thể loại không tồn tại");	
						}					
					}
				}
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					PhieuMuon pm = phieuMuonFacade.timPhieuMuonTheoMa(txtMaPhieu.getText().toString());
					List<String> maCD = pm.getDiaCDs();
					loadData_CD(maCD);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnInPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
					DecimalFormat dm = new DecimalFormat("#,###.##" + " VND");
					String maPM = txtMaPhieu.getText() + "_TXT";
					OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("..\\QuanLyCD_Client\\KhoPM\\"+maPM+".txt"));
					if(!txtMaPhieu.getText().equals("")) {
						PhieuMuon pm = phieuMuonFacade.timPhieuMuonTheoMa(txtMaPhieu.getText());
						
						String[] data = {
								"-------------------------------------------------------------------------------------",
								"\t\t CỬA HÀNG THUÊ ĐĨA CD CDMAN",
								"\t\t\t Phiếu Mượn",
								"\t Mã Phiếu   :" + pm.getMaPhieuMuon(),
								"\t Khách Hàng :" + pm.getThanhVien().getHoTen(),
								"\t Địa Chỉ    :" + pm.getThanhVien().getDiaChi(),
								"\t Số SDT    :" + pm.getThanhVien().getDienThoai(),
								"\t Nhân Viên  :" + pm.getNhanVien().getHoTenNV(),
								"\t Ngày Mượn  :" + fm.format(pm.getNgayMuon()) ,
								"\t Số Ngày Mươn:" + pm.getHanNgayMuon() + "NGày",
								"--------------------CHI TIẾT PHIẾU MƯỢN-----------------------------------------------",	
							
						};
						
						int i = 0;
						String[] dscd = new String[pm.getDiaCDs().size()];
						for (String maCD : pm.getDiaCDs()) {
							DiaCD cd = diaCDFacade.timCDTheoMa(maCD);						
							dscd[i] ="Mã CD: " + cd.getMaDia() + " - Tên CD: " + cd.getTenDia() +" - Thể Loại: "+ cd.getTheLoai() +" - Đơn Giá: "+ dm.format(cd.getDonGia()) +" - Tình Trạng: "+ cd.getTinhTrang() +" - Nhà Sản Xuât: "+ cd.getHangSanXuat() + "\n";
							i++;						
						}
						String[] tt = {
								"-------------------------------------------------------------------------------------",								
								"\t TỔNG TIỀN : " + dm.format(pm.getTongTien()) + " (Tổng tiền đã bao gồm tiền cọc 50% và tiền thuê 50% !)",
								"\n",
								"LƯU Ý: nếu trả muộn tiền phạt xẽ được tính thêm bằng 25% tiền thuê mỗi ngày !"
						};
						for (String st : data) {
							out.write(st);
							out.write("\n");					
						}
						
						for (String cd : dscd) {
							out.write(cd);
							out.write("\n");	
						}
						for (String t : tt) {
							out.write(t);
							out.write("\n");	
						}
						out.flush();
						JOptionPane.showMessageDialog(null, "In thành Công");
						out.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Chưa CHọn Phiếu");
					}				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
//--------------------------------------------------------------------------------------------------action DiaCD-----------------------------------------------------		
	}

	private void loadTieuDe_PhieuMuon() {	
		model_PM.addColumn("Mã Phiếu");
		model_PM.addColumn("Tên Khách Hàng");
		model_PM.addColumn("Tên Nhân Viên");
		model_PM.addColumn("Ngày Mượn");
		model_PM.addColumn("Hạn Mượn");	
		model_PM.addColumn("Thành Tiền");	
		table_PM.setModel(model_PM);	
	}
	private void loadTIeuDe_CD() {
		model_CD.addColumn("Mã Đĩa");
		model_CD.addColumn("Tên Đĩa");
		model_CD.addColumn("Tình Trạng");
		model_CD.addColumn("Đơn Giá");
		model_CD.addColumn("Ghi Chú");	
		model_CD.addColumn("Nhà Sản Xuất");	
		table_CD.setModel(model_CD);
	}
	private void loadData_PhieuMuon(List<PhieuMuon> ls) {
		model_PM.getDataVector().removeAllElements();
		Object row = new Object();
		DateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
		for (PhieuMuon pm : ls) {
			model_PM.addRow(new Object[] {pm.getMaPhieuMuon(), pm.getThanhVien().getHoTen(),
					pm.getNhanVien().getHoTenNV(), fm.format(pm.getNgayMuon()), pm.getHanNgayMuon(), pm.getTongTien()});		
		}
		table_PM.setModel(model_PM);
	}
	private void loadData_CD(List<String> maCD) {
		model_CD.getDataVector().removeAllElements();
		for (String cd : maCD) {
			try {
				DiaCD diaCD = diaCDFacade.timCDTheoMa(cd);
				model_CD.addRow(new Object[] {diaCD.getMaDia(), diaCD.getTenDia(),diaCD.getTheLoai(),diaCD.getDonGia(),diaCD.getGhiChu(),diaCD.getHangSanXuat()});
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		table_CD.setModel(model_CD);
	}
	public void loadFullDuLieu(int k) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}		
		try {
			PhieuMuonFacade phieuMuonFacade = (PhieuMuonFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/phieuMuonFacade");
			DiaCDFacade diaCDFacade = (DiaCDFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/diaCDFacade");
			NhanVienFacade nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/nhanVienFacade");
			ThanhVienFacade thanhVienFacade = (ThanhVienFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/thanhVienFacade");
			PhieuTraFacade phieuTraFacade = (PhieuTraFacade) Naming.lookup("rmi://"+myIP.getHostAddress().toString()+":1088/phieuTraFacade");
			
			if(lsPm != null || lsNV != null || lsNV != null || lsCD != null) {
				lsPm.clear();
				lsNV.clear();
				lsTV.clear();
				lsCD.clear();
			}
			
			if(k == 0) {
				lsPm = phieuMuonFacade.getAllPhieuMuon(); //1
				lsNV = nhanVienFacade.getAllNhanVien(); //2
				lsTV = thanhVienFacade.getAllThanhVien(); //3
				lsCD = diaCDFacade.getAllDiaCD(); //4
				lsPT = phieuTraFacade.getAllPhieuTra(); //5
			}else if(k == 1)
			{
				lsPm = phieuMuonFacade.getAllPhieuMuon();
			}else if(k == 2)
			{
				lsNV = nhanVienFacade.getAllNhanVien();
			}else if(k == 3)
			{
				lsTV = thanhVienFacade.getAllThanhVien();
			}else if(k == 4)
			{
				lsCD = diaCDFacade.getAllDiaCD();
			}
			else if(k == 5)
			{
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
	public void xoaTableCD() {
		DefaultTableModel newModel = new DefaultTableModel();
		table_CD.setModel(newModel);
	}
}

