package form;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
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

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class FrmThongKe extends JPanel {
	private JTextField txtTongPhieuMuon;
	private JTextField txtTongNV;
	private JTextField txtTongCD;
	private JTextField txtCDDaChoThue;
	private JTextField txtDoanhSo;

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
	private JTextField txtCDChuaTra;
	private JTextField txtPhieuChuaTra;
	private JTextField txtSoPhieuDaTra;
	private JTextField txtTongTV;
	InetAddress myIP;
	/**
	 * Create the panel.
	 */
	public FrmThongKe() {
		
		try {
			myIP = InetAddress.getLocalHost();
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		};
		loadFullDuLieu(0);
		setPreferredSize(new Dimension(1400, 915));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 1390, 835);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 1370, 50);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(236, 60, 937, 701);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Chọn Tháng :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(249, 24, 154, 41);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng CD đã cho thuê :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(191, 133, 212, 28);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng CD trong kho :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(214, 496, 189, 28);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tổng số nhân viên :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(188, 441, 215, 28);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tổng số phiếu mượn :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(137, 213, 266, 31);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tổng doanh số :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(116, 557, 287, 41);
		panel_1.add(lblNewLabel_6);
		
		txtTongPhieuMuon = new JTextField();
		txtTongPhieuMuon.setEditable(false);
		txtTongPhieuMuon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongPhieuMuon.setColumns(10);
		txtTongPhieuMuon.setBounds(413, 218, 298, 26);
		panel_1.add(txtTongPhieuMuon);
		
		txtTongNV = new JTextField();
		txtTongNV.setEditable(false);
		txtTongNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongNV.setColumns(10);
		txtTongNV.setBounds(413, 441, 298, 31);
		panel_1.add(txtTongNV);
		
		txtTongCD = new JTextField();
		txtTongCD.setEditable(false);
		txtTongCD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongCD.setColumns(10);
		txtTongCD.setBounds(413, 495, 298, 28);
		panel_1.add(txtTongCD);
		
		txtCDDaChoThue = new JTextField();
		txtCDDaChoThue.setEditable(false);
		txtCDDaChoThue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCDDaChoThue.setColumns(10);
		txtCDDaChoThue.setBounds(413, 133, 298, 28);
		panel_1.add(txtCDDaChoThue);
		
		JButton btnNewButton = new JButton("Thống Kê");
		btnNewButton.setIcon(new ImageIcon(FrmThongKe.class.getResource("/icon_trangchu/icons8_statistics_40px.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(366, 623, 189, 68);
		panel_1.add(btnNewButton);
		
		txtDoanhSo = new JTextField();
		txtDoanhSo.setEditable(false);
		txtDoanhSo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDoanhSo.setColumns(10);
		txtDoanhSo.setBounds(413, 571, 298, 28);
		panel_1.add(txtDoanhSo);
		
		
		JComboBox cboThang = new JComboBox(new Object[] {"1","2","3","4","5","6","7","8","9","10","11","12"});
		cboThang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboThang.setBounds(413, 34, 298, 28);
		panel_1.add(cboThang);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chọn Năm :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(249, 75, 154, 41);
		panel_1.add(lblNewLabel_1_1);
		
		JComboBox cboNam = new JComboBox(new Object[] {2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,"2021"});
		cboNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboNam.setBounds(413, 80, 298, 28);
		panel_1.add(cboNam);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tổng CD chưa trả :");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(191, 175, 212, 28);
		panel_1.add(lblNewLabel_2_1);
		
		txtCDChuaTra = new JTextField();
		txtCDChuaTra.setEditable(false);
		txtCDChuaTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCDChuaTra.setColumns(10);
		txtCDChuaTra.setBounds(413, 178, 298, 28);
		panel_1.add(txtCDChuaTra);
		
		txtPhieuChuaTra = new JTextField();
		txtPhieuChuaTra.setEditable(false);
		txtPhieuChuaTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhieuChuaTra.setColumns(10);
		txtPhieuChuaTra.setBounds(413, 269, 298, 26);
		panel_1.add(txtPhieuChuaTra);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tổng số phiếu chưa trả :");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(137, 264, 266, 31);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Tổng số phiếu đã trả :");
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1.setBounds(137, 317, 266, 31);
		panel_1.add(lblNewLabel_5_1_1);
		
		txtSoPhieuDaTra = new JTextField();
		txtSoPhieuDaTra.setEditable(false);
		txtSoPhieuDaTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoPhieuDaTra.setColumns(10);
		txtSoPhieuDaTra.setBounds(413, 322, 298, 26);
		panel_1.add(txtSoPhieuDaTra);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("Tổng số thành viên :");
		lblNewLabel_5_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_2.setBounds(137, 390, 266, 31);
		panel_1.add(lblNewLabel_5_1_2);
		
		txtTongTV = new JTextField();
		txtTongTV.setEditable(false);
		txtTongTV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongTV.setColumns(10);
		txtTongTV.setBounds(413, 393, 298, 28);
		panel_1.add(txtTongTV);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tongCDChoThue = 0;
				int tongSoPhieuMuon = 0;
				int tongCDTrongKho = lsCD.size();
				int tongNhanVien = lsNV.size();
				double tongDoanhSo = 0;
				int tongCDChuaTra = 0;
				int tongPhieuChuaTra = 0;
				int tongPhieuDaTra = 0;
				int tongThanhVien = lsTV.size();
				DateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
				for (PhieuMuon pm : lsPm) {
					String dayPM = fm.format(pm.getNgayMuon());
					String month = dayPM.substring(3,5);	
					String year = dayPM.substring(6,10);
					if(month.equals(cboThang.getSelectedItem()) && year.equals(cboNam.getSelectedItem())){
						tongSoPhieuMuon +=1;
						tongCDChoThue += pm.getDiaCDs().size();
						tongDoanhSo += pm.getTongTien();
					}
				}
				for (PhieuTra pt : lsPT) {
					String dayPM = fm.format(pt.getNgayMuon());
					String month = dayPM.substring(3,5);	
					String year = dayPM.substring(6,10);
					if(month.equals(cboThang.getSelectedItem()) && year.equals(cboNam.getSelectedItem())){
						tongDoanhSo += pt.getTienPhat() - pt.getTienTraLai();
						if(pt.getTrangThai().equals("Chưa Trả")) {
							tongCDChuaTra += pt.getDiaCDs().size();
							tongPhieuChuaTra += 1;
						}else {
							tongPhieuDaTra +=1;
						}						
					}
				}
				txtCDDaChoThue.setText(Integer.toString(tongCDChoThue));
				txtTongCD.setText(Integer.toString(tongCDTrongKho));
				txtTongNV.setText(Integer.toString(tongNhanVien));
				txtTongPhieuMuon.setText(Integer.toString(tongSoPhieuMuon));
				txtDoanhSo.setText(Double.toString(tongDoanhSo));
				txtCDChuaTra.setText(Integer.toString(tongCDChuaTra));
				txtPhieuChuaTra.setText(Integer.toString(tongPhieuChuaTra));
				txtSoPhieuDaTra.setText(Integer.toString(tongPhieuDaTra));
				txtTongTV.setText(Integer.toString(tongThanhVien));
			}
		});
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
}
