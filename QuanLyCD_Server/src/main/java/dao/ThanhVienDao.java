package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.PhieuMuon;
import entity.ThanhVien;
import util.HibernateUtil;

public class ThanhVienDao {
	private OgmSessionFactory sessionFactory;

	public ThanhVienDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	public boolean themThanhVien(ThanhVien thanhVien) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(thanhVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return false;
	}
	public boolean xoaThanhVien(ThanhVien tv) {
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			session.delete(tv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return false;
	}
	public boolean suaThanhVien(ThanhVien tv) {
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			session.update(tv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return false;
	}
	public List<ThanhVien> getAllThanhVien( ) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {		
			tr.begin();
			List<ThanhVien> thanhViens = new ArrayList<ThanhVien>();
			String query = "select tv from ThanhVien tv";
			thanhViens =  session.createQuery(query,ThanhVien.class)
					.getResultList();
			
			tr.commit();
			return thanhViens;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}
	public ThanhVien timThanhVienTheoMa(String maThanhVien) {
		ThanhVien tv = new ThanhVien();
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			tv = session.find(ThanhVien.class,maThanhVien);
			tr.commit();
			return tv;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return null;
	}
	public List<ThanhVien> timThanhVienTheoHoTen(String hoTen) {
		List<ThanhVien> tv = new ArrayList<ThanhVien>();
		List<ThanhVien> rs = new ArrayList<ThanhVien>();
		NhanVienDao nvDao = new NhanVienDao();
		tv = getAllThanhVien();
		
		for (ThanhVien thanhvien : tv) {
				if(thanhvien.getHoTen().equals(hoTen)) {
					rs.add(thanhvien);
				}
		}	
		return rs;	
	}
	public List<ThanhVien> timThanhVienTheoSDT(String dienthoai) {
		List<ThanhVien> tv = new ArrayList<ThanhVien>();
		List<ThanhVien> rs = new ArrayList<ThanhVien>();
		NhanVienDao nvDao = new NhanVienDao();
		tv = getAllThanhVien();
		
		for (ThanhVien thanhvien : tv) {
				if(thanhvien.getDienThoai().equals(dienthoai)) {
					rs.add(thanhvien);
				}
		}	
		return rs;	
	}
	
}
