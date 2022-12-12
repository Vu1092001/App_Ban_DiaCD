package app;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import dao.DiaCDDao;
import dao.NhanVienDao;
import dao.PhieuMuonDao;
import dao.PhieuTraDao;
import dao.ThanhVienDao;
import entity.DiaCD;
import entity.NhanVien;
import entity.PhieuMuon;
import entity.PhieuTra;
import entity.TaiKhoan;
import entity.ThanhVien;
import entity.TheThanhVien;
import facade.DiaCDFacade;
import facade.DiaCDImp;
import facade.NhanVienFacade;
import facade.NhanVienImp;
import facade.PhieuMuonFacade;
import facade.PhieuMuonImp;
import facade.PhieuTraFacade;

public class App {

	public static void main(String[] args) throws RemoteException {
		
		//----------------------------------------------------------------------------Đĩa CD
		DiaCDDao diaCDDao = new DiaCDDao();	
		
		DiaCD cd_01 = new DiaCD("01", "Test", "Test", "Test", "Test", "Test" , 20, 10000);
		DiaCD cd_02 = new DiaCD("02", "Test", "Test", "Test", "Test", "Test" , 20, 10000);
		DiaCD cd_03 = new DiaCD("03", "Test", "Test", "Test", "Test", "Test" , 20, 10000);
		DiaCDFacade diaCDFacade = new DiaCDImp();

//		DiaCD cd = new DiaCD("0000", "Tạm", "Tạm", "Tạm", "Tạm", "Tạm", 0 ,0); //Bắt buộc thêm cái này vào trước
//		System.out.println(diaCDDao.themDiaCD(cd));
		
//		System.out.println(diaCDDao.themDiaCD(cd_01));
//		System.out.println(diaCDDao.themDiaCD(cd_02));
//		System.out.println(diaCDDao.themDiaCD(cd_03));
			
		//----------------------------------------------------------------------------Thành Viên (Khách Hàng)
		ThanhVienDao thanhVienDao = new ThanhVienDao();
		
		ThanhVien thanhVien_01 = new ThanhVien("0001", "Trần Thành Nam", "Nam", "0355034827", "Test", "Test", new TheThanhVien(new Date(), new Date()));	
		ThanhVien thanhVien_02 = new ThanhVien("0002", "Nguyễn Lâm Nhật Minh", "Nam", "0355034827", "Test", "Test", new TheThanhVien(new Date(), new Date()));		
		ThanhVien thanhVien_03 = new ThanhVien("0003", "Hoàng Huy Vũ", "Nam", "0355034827", "Test", "Test", new TheThanhVien(new Date(), new Date()));
			
//		System.out.println(thanhVienDao.themThanhVien(thanhVien_01));
//		System.out.println(thanhVienDao.themThanhVien(thanhVien_02));
//		System.out.println(thanhVienDao.themThanhVien(thanhVien_03));
		
		//----------------------------------------------------------------------------Nhân Viên
		
		NhanVienDao nhanVienDao = new NhanVienDao();
		NhanVienFacade nhanVienFacade = new NhanVienImp();
		
		NhanVien nhanVien_01 = new NhanVien("0001", "Trần Thành Nam", "Nam", "0355034729", "Test", "Test","nam01697826435nam@gmail.com", new TaiKhoan("namql", "123", "Quản lý"));
		NhanVien nhanVien_02 = new NhanVien("0002", "Nguyễn Lâm Nhật Minh", "Nam", "0355034729", "Test", "Test","nhatminhminh57@gmail.com",new TaiKhoan("minhql", "123", "Quản lý"));
		NhanVien nhanVien_03 = new NhanVien("0003", "Hoàng Huy Vũ", "Nam", "0355034729", "Test", "Test","vhong10092001@gmail.com",new TaiKhoan("vuql", "123", "Quản lý"));
		NhanVien nhanVien_04 = new NhanVien("0004", "Trần Thành Nam 2", "Nam", "0355034721", "Test", "Test","nam0355034827nam@gmail.com",new TaiKhoan("namnv", "123", "Nhân Viên"));
		
//		System.out.println(nhanVienDao.themNhanVien(nhanVien_01));
//		System.out.println(nhanVienDao.themNhanVien(nhanVien_02));
//		System.out.println(nhanVienDao.themNhanVien(nhanVien_03));
//		System.out.println(nhanVienDao.themNhanVien(nhanVien_04));
		//----------------------------------------------------------------------------Phiếu Mượn
		
		PhieuMuonDao phieuMuonDao = new PhieuMuonDao();		
		List<String> lsCD_01 = new ArrayList<String>();
		lsCD_01.add(cd_01.getMaDia());
		
		List<String> lsCD_02 = new ArrayList<String>();
		lsCD_02.add(cd_01.getMaDia());
		lsCD_02.add(cd_02.getMaDia());
		
		List<String> lsCD_03 = new ArrayList<String>();
		lsCD_03.add(cd_01.getMaDia());
		lsCD_03.add(cd_02.getMaDia());
		lsCD_03.add(cd_03.getMaDia());
		PhieuMuon phieuMuon_01 = new PhieuMuon("001", new ThanhVien("0001"), new NhanVien("0001"), lsCD_01, 1, new Date(), 10, 10000);
		PhieuMuon phieuMuon_02 = new PhieuMuon("002", new ThanhVien("0002"), new NhanVien("0002"), lsCD_02, 1, new Date(), 10, 20000);
		PhieuMuon phieuMuon_03 = new PhieuMuon("003", new ThanhVien("0003"), new NhanVien("0003"), lsCD_03, 1, new Date(), 10, 30000);

		PhieuMuonFacade phieuMuonFacade = new PhieuMuonImp();


//		System.out.println(phieuMuonFacade.themPhieuMuon(phieuMuon_01));
//		System.out.println(phieuMuonFacade.themPhieuMuon(phieuMuon_02));
//		System.out.println(phieuMuonFacade.themPhieuMuon(phieuMuon_03));
		//----------------------------------------------------------------------------Phiếu Trả
//		
//		PhieuTraDao phieuTraDao = new PhieuTraDao();
//			
//		List<PhieuMuon> pm = phieuMuonDao.getAllPhieuMuon();
//		for (PhieuMuon pt : pm) {
//			List<String> dsTCD = new ArrayList<String>();		
//			for (String rs : pt.getDiaCDs()) {
//				DiaCD cd = diaCDDao.timCDTheoMa(rs);
//				dsTCD.add(cd.getMaDia());
//			}
//			System.out.println(pt.getDiaCDs());
//			PhieuTra PT = new PhieuTra("PT" + pt.getMaPhieuMuon(), pt.getThanhVien(), pt.getNhanVien(),  dsTCD, pt.getSoLuong(),
//					pt.getNgayMuon(), pt.getHanNgayMuon(), "Chưa Trả", new Date(),0, pt.getTongTien()/2);
//			System.out.println(PT);
//			phieuTraDao.themPhieuTra(PT);
//	}
	//----------------------------------------------------------------------------Nháp
		
//		System.out.println(nhanVienDao.checkDangNhap("minh","123"));
		
//		System.out.println(nhanVienDao.doiMatKhau("minh", "1234", "1234"));
		
		
		
		
//		System.out.println(nhanVienFacade.xoaNhanVien(new NhanVien("0004")));
//		PhieuTra pt = phieuTraDao.timPhieuTraTheoMa("PT001");
//		System.out.println(pt);
//		List<String> lsCD = pt.getDiaCDs();
//		lsCD.add("new");
//		pt.setDiaCDs(lsCD);
//		
//		System.out.println(phieuTraDao.suaPhieuTra(pt));
		
//		List<PhieuTra> lspt = phieuTraDao.getAllPhieuTra();
//		System.out.println(lspt);
		
		
		
//		phieuMuonFacade.getAllPhieuMuon().forEach(rs -> System.out.println(rs));
//		phieuMuonDao.getAllPhieuMuon().forEach(rs -> System.out.println(rs));
//		System.out.println(phieuMuonDao.suaPhieuMuon(phieuMuon));
//		System.out.println(phieuMuonDao.themPhieuMuon(phieuMuon));
		
//		List<PhieuMuon> rs = phieuMuonDao.getAllPhieuMuon();
//		PhieuMuonFacade pmIml = new PhieuMuonImp();
//		pmIml.getAllPhieuMuon();
//		for (PhieuMuon pm : rs) {
//			System.out.println(pm);
//			for (String cd : pm.getDiaCDs()) {
//				System.out.println(diaCDDao.timCDTheoTen(cd));
//			}
//		}
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(fm.format(new java.sql.Date(2021-1900, 11-1, 24)));
//		
//		String day = fm.format(new java.sql.Date(2021-1900, 11-1, 24));
//		if(phieuMuonDao.timPhieuMuonTheoNgay(day) == null)
//			System.out.println("null");
//		else
//			phieuMuonDao.timPhieuMuonTheoNgay(day).forEach(rs -> System.out.println(rs));
			
//		System.out.println(phieuMuonDao.timPhieuMuonTheoMa("001"));
		
//		phieuMuonDao.timPhieuMuonTheoTenNhanVien("Nguyễn Lâm Nhật Minh").forEach(rs -> System.out.println(rs));
//		phieuMuonDao.timPhieuMuonTheoTenKhachHang("Trần Thành Nam").forEach(rs -> System.out.println(rs));
//		DateFormat fm = new SimpleDateFormat("dd-MM-yyy");
//		Date day= new GregorianCalendar(2021, Calendar.NOVEMBER, 24).getTime();
//		phieuMuonDao.timPhieuMuonTheoNgayMuon(day).forEach(rs -> System.out.println(rs));
		//----------------------------------------------------------------------------
		
//		DiaCD diaCD = new DiaCD("03", "Test", "Test", "Test", "Test", "Test", 1);
//		System.out.println(diaCDDao.themDiaCD(diaCD));
//		System.out.println(diaCDDao.timCDTheoTen("04"));
		//---------------------------------------------------------------------------- Phiếu Trả
//		phieuTraDao.getAllPhieuTra().forEach(rs -> System.out.println(rs));
//		System.out.println(phieuTraDao.timPhieuTraTheoMa("001"));
//		System.out.println(phieuTraDao.timPhieuTraTheoTenKhachHang("Trần Thành Nam"));
//		Date day = new GregorianCalendar(2021,Calendar.NOVEMBER, 24).getTime();
//		phieuTraDao.timPhieuTraTheoNgayMuon(day).forEach(rs -> System.out.println(rs));
	}
}	
	

