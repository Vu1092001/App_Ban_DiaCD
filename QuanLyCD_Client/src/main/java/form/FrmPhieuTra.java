package form;

import java.awt.BorderLayout;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
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

public class FrmPhieuTra extends JPanel {
	
	DefaultTableModel model_PT = new DefaultTableModel();
	private JTable table_PT;
	DefaultTableModel model_CD = new DefaultTableModel();
	private JTable table_CD;
	
	PhieuMuonFacade phieuMuonFacade;
	DiaCDFacade diaCDFacade;
	NhanVienFacade nhanVienFacade;
	ThanhVienFacade thanhVienFacade;
	PhieuTraFacade phieuTraFacade;
	
	List<PhieuMuon>	lsPm;
	List<DiaCD> lsCD;
	List<NhanVien> lsNV;
	List<ThanhVien> lsTV;
	List<PhieuTra> lsPT;
	private JTextField txtTim;
	InetAddress myIP;
	
	
	
	/**
	 * Create the panel.
	 */
	public FrmPhieuTra() {
	
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
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 1390, 835);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(10, 49, 1370, 463);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table_PT = new JTable();
		table_PT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table_PT);
		table_PT.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		loadTieuDe_PhieuTra();
		loadData_PhieuTra(lsPT);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 522, 1370, 303);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 41, 725, 252);
		panel_3.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		table_CD = new JTable();
		table_CD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table_CD);
		loadTIeuDe_CD();
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(745, 41, 615, 252);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phiếu Trả :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 55, 125, 44);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm Ngày :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 111, 101, 35);
		panel_4.add(lblNewLabel_1);
		
		JDateChooser dtcNgay = new JDateChooser();
		dtcNgay.setDateFormatString("dd-MM-yyyy");
		dtcNgay.setBounds(114, 111, 254, 35);
		panel_4.add(dtcNgay);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTim.setColumns(10);
		txtTim.setBounds(114, 55, 317, 44);
		panel_4.add(txtTim);
		
		JComboBox cboLoaiTim = new JComboBox(new Object[] {"Tìm Theo Mã PT", "Tìm Theo Tên NV", "Tìm Theo Tên KH", "Tìm Theo Ngày Mượn"});
		cboLoaiTim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboLoaiTim.setBounds(114, 10, 317, 35);
		panel_4.add(cboLoaiTim);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(FrmPhieuTra.class.getResource("/icon_trangchu/icons8_search_40px.png")));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTim.setBounds(454, 56, 138, 44);
		panel_4.add(btnTim);
		
		JButton btnTra = new JButton("Trả");
		btnTra.setHorizontalAlignment(SwingConstants.LEFT);
		btnTra.setIcon(new ImageIcon(FrmPhieuTra.class.getResource("/icon_trangchu/icons8_cash_in_hand_100px.png")));
		btnTra.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnTra.setBounds(430, 111, 175, 103);
		panel_4.add(btnTra);
		
		JLabel lblThongBao = new JLabel("Thông Báo");
		lblThongBao.setIcon(new ImageIcon(FrmPhieuTra.class.getResource("/icon_trangchu/icons8_error_30px.png")));
		lblThongBao.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblThongBao.setForeground(Color.RED);
		lblThongBao.setBounds(10, 193, 333, 34);
		panel_4.add(lblThongBao);
		
		JLabel lblNewLabel_4 = new JLabel("Loại Tìm :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(20, 10, 101, 35);
		panel_4.add(lblNewLabel_4);
		
		JButton btnTaiLai = new JButton("Tải Lại");
		btnTaiLai.setIcon(new ImageIcon(FrmPhieuTra.class.getResource("/icon_trangchu/icons8_spinner_40px.png")));
		btnTaiLai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTaiLai.setBounds(454, 10, 138, 35);
		panel_4.add(btnTaiLai);
		
		JLabel lblNewLabel_3 = new JLabel("Thông Tin Đĩa CD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_3.setBounds(10, 0, 314, 42);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Phiếu Trả");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 0, 1370, 49);
		panel.add(lblNewLabel_2);
//----------------------------------------------------------------------------------------------Sử lý Phiếu Trả---------------------------------------------------------	
		table_PT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowSl = table_PT.getSelectedRow();
				txtTim.setText(table_PT.getValueAt(rowSl, 0).toString());
			
				try {
					PhieuTra pt = phieuTraFacade.timPhieuTraTheoMa(txtTim.getText());
					loadData_CD(pt.getDiaCDs());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTim.getText().equals("")) {
					lblThongBao.setText("Chưa chọn phiêu trả");
				}else {
					try {
						int row = table_PT.getSelectedRow();			
						String maPt = table_PT.getValueAt(row, 0).toString();	
						
						double tienPhat = 0;
						
						SimpleDateFormat fm = new SimpleDateFormat();
						PhieuTra pt = phieuTraFacade.timPhieuTraTheoMa(maPt);
						double tienTralai = pt.getTienTraLai();
						long mbML = new Date().getTime()- pt.getNgayMuon().getTime();									
						long mbDay = TimeUnit.MILLISECONDS.toDays(mbML);
						if (mbDay > pt.getHanNgayMuon()) {
							tienPhat = (pt.getTienTraLai()* 0.25) * (mbDay - pt.getHanNgayMuon());
							tienTralai = pt.getTienTraLai() - tienPhat;
						}				
						PhieuTra PT = new PhieuTra(pt.getMaPhieuTra(), pt.getThanhVien(),
								pt.getNhanVien(), pt.getDiaCDs(), 1, pt.getNgayMuon(), 
								pt.getHanNgayMuon(), "Đã Trả", new Date(), tienPhat, tienTralai);
						
						phieuTraFacade.suaPhieuTra(PT);
						loadFullDuLieu(5);
						loadData_PhieuTra(lsPT);
						//Tăng đĩa
						for (String st : pt.getDiaCDs()) {
							DiaCD cd = diaCDFacade.timCDTheoMa(st);
							int sl = cd.getSoLuong();
							cd.setSoLuong(sl+1);
							diaCDFacade.suaDiaCD(cd);
						}
											
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						lblThongBao.setText("Chưa chọn phiếu");
					}
				}			
			}
		});
//		{"Tìm Theo Mã PM", "Tìm Theo Tên NV, Tìm Theo Tên KH", "Tìm Theo Ngày Mượn"});
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTim.getText().equals("")) {
					lblThongBao.setText("Tìm Rỗng");
				}else {
					if(cboLoaiTim.getSelectedItem().equals("Tìm Theo Mã PT")) {
						List<PhieuTra> dsPT = new ArrayList<PhieuTra>();
						for (PhieuTra pt : lsPT) {
							if(pt.getMaPhieuTra().equalsIgnoreCase(txtTim.getText())) {
								dsPT.add(pt);
								if(dsPT.size() != 0) 
									loadData_PhieuTra(dsPT);
								else
									lblThongBao.setText("Mã Không tồn tại");
							}
						}
					}
					else if(cboLoaiTim.getSelectedItem().equals("Tìm Theo Tên NV")) {
						List<PhieuTra> dsPT = new ArrayList<PhieuTra>();
						for (PhieuTra pt : lsPT) {
							if(pt.getNhanVien().getHoTenNV().toLowerCase().contains(txtTim.getText().toLowerCase())) {
								dsPT.add(pt);
							}
						}
						if(dsPT.size() != 0)
							loadData_PhieuTra(dsPT);
						else
							lblThongBao.setText("Tên Không tồn tại");
					}
					else if(cboLoaiTim.getSelectedItem().equals("Tìm Theo Tên KH")) {
						List<PhieuTra> dsPT = new ArrayList<PhieuTra>();
						for (PhieuTra pt : lsPT) {
							if(pt.getThanhVien().getHoTen().toLowerCase().contains(txtTim.getText().toLowerCase())) {
								dsPT.add(pt);
							}
						}
						if(dsPT.size() != 0)
							loadData_PhieuTra(dsPT);
						else
							lblThongBao.setText("Tên không tồn tại");
					}
					else if(cboLoaiTim.getSelectedItem().equals("Tìm Theo Ngày Mượn")) {
						if(dtcNgay.getDate() == null) {
							lblThongBao.setText("Tìm Rỗng");
						}else {
							Date day = dtcNgay.getDate();
							try {
								List<PhieuTra> dsPT = phieuTraFacade.timPhieuTraTheoNgayMuon(day);
								if(dsPT.size() != 0)
									loadData_PhieuTra(dsPT);
								else
									lblThongBao.setText("Ngày không không đúng");
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
				
					}
				}				
			}
		});
		btnTaiLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData_PhieuTra(lsPT);
				txtTim.setText("");
				xoaTrangCD();
			}
		});
	}
	private void loadTieuDe_PhieuTra() {	
		model_PT.addColumn("Mã Phiếu");
		model_PT.addColumn("Tên Khách Hàng");
		model_PT.addColumn("Tên Nhân Viên");
		model_PT.addColumn("Ngày Mượn");
		model_PT.addColumn("Hạn Mượn");
		model_PT.addColumn("Ngày Trả");
		model_PT.addColumn("Tình Trạng");
		model_PT.addColumn("Tiền Phạt");
		model_PT.addColumn("Tiền Cọc");
		table_PT.setModel(model_PT);	
	}
	private void loadTIeuDe_CD() {
		model_CD.addColumn("Mã Đĩa");
		model_CD.addColumn("Tên Đĩa");
		model_CD.addColumn("Tình Trạng");
		model_CD.addColumn("Đơn Giá");
		model_CD.addColumn("Ghi Chú");	
		model_CD.addColumn("Nhà Sản Xuất");
	}
	private void loadData_PhieuTra(List<PhieuTra> ls) {
		model_PT.getDataVector().removeAllElements();
		DateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
		for (PhieuTra pt : ls) {
			model_PT.addRow(new Object[] {pt.getMaPhieuTra(), pt.getNhanVien().getHoTenNV(), pt.getThanhVien().getHoTen(),
					fm.format(pt.getNgayMuon()), pt.getHanNgayMuon() + " Ngày", fm.format(pt.getNgayTra()),
					pt.getTrangThai(), pt.getTienPhat() + " VND", pt.getTienTraLai() +"VND"});
		}
		table_PT.setModel(model_PT);
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
	public void xoaTrangCD() {
		DefaultTableModel newModel = new DefaultTableModel();
		model_CD.getDataVector().removeAllElements();
		table_CD.setModel(newModel);
	}
}
