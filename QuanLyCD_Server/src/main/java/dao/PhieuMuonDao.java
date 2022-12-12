package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.PhieuMuon;
import util.HibernateUtil;

public class PhieuMuonDao {
	private OgmSessionFactory sessionFactory;


	public PhieuMuonDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	public boolean themPhieuMuon(PhieuMuon phieuMuon) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			session.save(phieuMuon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
	public boolean xoaPhieuMuon(PhieuMuon pm) {
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
	public boolean suaPhieuMuon(PhieuMuon pm) {
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

	public List<PhieuMuon> getAllPhieuMuon( ) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {		
			tr.begin();
			List<PhieuMuon> phieuMuons = new ArrayList<PhieuMuon>();
			String query = "select pm from PhieuMuon pm";
			phieuMuons =  session.createQuery(query,PhieuMuon.class)
					.getResultList();
			
			tr.commit();
			return phieuMuons;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}
	public PhieuMuon timPhieuMuonTheoMa(String ma) {
		PhieuMuon pm = new PhieuMuon();
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			pm = session.find(PhieuMuon.class,ma);
			tr.commit();
			return pm;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return null;
	}
	public List<PhieuMuon> timPhieuMuonTheoTenNhanVien(String tenNV) {
		List<PhieuMuon> pm = new ArrayList<PhieuMuon>();
		List<PhieuMuon> rs = new ArrayList<PhieuMuon>();
		NhanVienDao nvDao = new NhanVienDao();
		pm = getAllPhieuMuon();
		
		for (PhieuMuon phieuMuon : pm) {
				if(phieuMuon.getNhanVien().getHoTenNV().equals(tenNV)) {
					rs.add(phieuMuon);
				}
		}	
		return rs;	
	}
	public List<PhieuMuon> timPhieuMuonTheoTenKhachHang(String tenKH) {
		List<PhieuMuon> pm = new ArrayList<PhieuMuon>();
		List<PhieuMuon> rs = new ArrayList<PhieuMuon>();
		NhanVienDao nvDao = new NhanVienDao();
		pm = getAllPhieuMuon();
		
		for (PhieuMuon phieuMuon : pm) {
				if(phieuMuon.getThanhVien().getHoTen().equals(tenKH)) {
					rs.add(phieuMuon);
				}
		}	
		return rs;	
	}
	public List<PhieuMuon> timPhieuMuonTheoNgayMuon(Date ngayMuon) {
		List<PhieuMuon> pm = new ArrayList<PhieuMuon>();
		List<PhieuMuon> rs = new ArrayList<PhieuMuon>();
		DateFormat fm = new SimpleDateFormat("dd-MM-yyy");
		NhanVienDao nvDao = new NhanVienDao();
		pm = getAllPhieuMuon();	
		for (PhieuMuon phieuMuon : pm) {	
			String x = fm.format(phieuMuon.getNgayMuon().getTime());
			String y = fm.format(ngayMuon);
//			System.out.println(x);
//			System.out.println(y);
				if(x.equals(y)) {
					System.out.println("ok");
					rs.add(phieuMuon);
				}
		}	
		return rs;	
	}
}
