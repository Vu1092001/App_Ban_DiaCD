package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.TaiKhoan;
import entity.ThanhVien;
import util.HibernateUtil;

public class TaiKhoanDao {
	private OgmSessionFactory sessionFactory;
	
	public TaiKhoanDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
}
	public boolean themTaiKhoan(TaiKhoan taikhoan) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(taikhoan);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return false;
	}
	public boolean xoaTaiKhoan(TaiKhoan tk) {
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			session.delete(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return false;
	}
	public boolean suaTaiKhoan(TaiKhoan tk) {
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			session.update(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return false;
	}
	public List<TaiKhoan> getAllTaiKhoan( ) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {		
			tr.begin();
			List<TaiKhoan> taikhoans = new ArrayList<TaiKhoan>();
			String query = "select tk from TaiKhoan tk";
			taikhoans =  session.createQuery(query,TaiKhoan.class)
					.getResultList();
			
			tr.commit();
			return taikhoans;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}
//
	
	public TaiKhoan timTaiKhoanTheoUserName(String username) {
		OgmSession session = sessionFactory.openSession();
		org.hibernate.Transaction tr = session.getTransaction();
		TaiKhoan a=new TaiKhoan();
		try {
			tr.begin();
			
			a = session.createNativeQuery("db.TaiKhoan.find({user_name:'"+username+"'})"
					, TaiKhoan.class).getSingleResult();		
			tr.commit();
			return a;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		
		return null;
	}
	
	
	
	
	
	
	
}
