package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.PhieuTra;
import util.HibernateUtil;

public class PhieuTraDao  {
	private OgmSessionFactory sessionFactory;

	public PhieuTraDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	public List<PhieuTra> getAllPhieuTra( ) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {		
			tr.begin();
			List<PhieuTra> phieuTras = new ArrayList<PhieuTra>();
			String query = "select pm from PhieuTra pm";
			phieuTras =  session.createQuery(query,PhieuTra.class)
					.getResultList();
			
			tr.commit();
			return phieuTras;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}
	public boolean themPhieuTra(PhieuTra phieuTra) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			session.save(phieuTra);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
	public boolean xoaPhieutra(PhieuTra pm) {
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			session.delete(pm);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return false;
	}
	public boolean suaPhieuTra(PhieuTra pm) {
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			session.update(pm);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}		
		return false;
	}
	public PhieuTra timPhieuTraTheoMa(String ma) {
		PhieuTra pm = new PhieuTra(ma);
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			pm = session.find(PhieuTra.class,ma);
			tr.commit();
			return pm;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return null;
	}
	public List<PhieuTra> timPhieuTraTheoTenKhachHang(String tenKH) {
		List<PhieuTra> pm = new ArrayList<PhieuTra>();
		List<PhieuTra> rs = new ArrayList<PhieuTra>();
		NhanVienDao nvDao = new NhanVienDao();
		pm = getAllPhieuTra();
		
		for (PhieuTra phiuTra : pm) {
				if(phiuTra.getThanhVien().getHoTen().equals(tenKH)) {
					rs.add(phiuTra);
				}
		}	
		return rs;	
	}
	public List<PhieuTra> timPhiuTraTheoTenNhanVien(String tenNV) {
		List<PhieuTra> pm = new ArrayList<PhieuTra>();
		List<PhieuTra> rs = new ArrayList<PhieuTra>();
		NhanVienDao nvDao = new NhanVienDao();
		pm = getAllPhieuTra();
		
		for (PhieuTra phieuTra : pm) {
				if(phieuTra.getNhanVien().getHoTenNV().equals(tenNV)) {
					rs.add(phieuTra);
				}
		}	
		return rs;	
	}
	public List<PhieuTra> timPhieuTraTheoNgayMuon(Date ngayMuon) {
		List<PhieuTra> pm = new ArrayList<PhieuTra>();
		List<PhieuTra> rs = new ArrayList<PhieuTra>();
		DateFormat fm = new SimpleDateFormat("dd-MM-yyy");
		NhanVienDao nvDao = new NhanVienDao();
		pm = getAllPhieuTra();	
		for (PhieuTra phieuTra : pm) {	
			String x = fm.format(phieuTra.getNgayMuon().getTime());
			String y = fm.format(ngayMuon);
//			System.out.println(x);
//			System.out.println(y);
				if(x.equals(y)) {
					rs.add(phieuTra);
				}
		}	
		return rs;	
	}
}
