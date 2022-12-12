package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.DiaCD;
import util.HibernateUtil;

public class DiaCDDao {
	private OgmSessionFactory sessionFactory;

	public DiaCDDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	public boolean themDiaCD(DiaCD diaCD) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {		
			tr.begin();
			session.save(diaCD);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
	public boolean suaDiaCD(DiaCD diaCD) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {		
			tr.begin();
			session.update(diaCD);;
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
	public DiaCD timCDTheoMa(String macd) {
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		DiaCD rs = new DiaCD();
		try {
			tr.begin();
			rs = session.find(DiaCD.class, macd);
			tr.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}


	public boolean xoaDiaCD(DiaCD cd) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(cd);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
	public List<DiaCD> timCDTheoTen(String tenCD) {
		List<DiaCD> diaCDs = new ArrayList<DiaCD>();
		List<DiaCD> rs = new ArrayList<DiaCD>();
		diaCDs = getAllDiaCD();
		for (DiaCD diaCD : diaCDs) {
			if (diaCD.getTenDia().equals(tenCD)) {
				rs.add(diaCD);
			}
		}
		return rs;

	}

	public List<DiaCD> timCDTheoTheLoai(String theLoai) {
		List<DiaCD> diaCDs = new ArrayList<DiaCD>();
		List<DiaCD> rs = new ArrayList<DiaCD>();
		diaCDs = getAllDiaCD();
		for (DiaCD diaCD : diaCDs) {
			if (diaCD.getTheLoai().equals(theLoai)) {
				rs.add(diaCD);
			}
		}
		return rs;
	}

	public List<DiaCD> getAllDiaCD() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<DiaCD> diaCDs = new ArrayList<DiaCD>();
			String query ="select cd from DiaCD cd";
			diaCDs = session.createQuery(query,DiaCD.class).getResultList();
			tr.commit();
			return diaCDs;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;

	}
}
