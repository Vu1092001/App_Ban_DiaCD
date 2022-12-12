package dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import entity.DiaCD;
import entity.NhanVien;
import entity.TaiKhoan;
import util.HibernateUtil;

public class NhanVienDao {
	private OgmSessionFactory sessionFactory;

	public NhanVienDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	public boolean themNhanVien(NhanVien nhanVien) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {		
			tr.begin();
			session.save(nhanVien);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}	
		return false;
	}
	public boolean xoaNhanVien(NhanVien nv) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(nv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		return false;
	}
	public boolean suaNhanVien(NhanVien nv) {
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {	
			tr.begin();
			session.update(nv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
		}
		
		return false;


	}
	public NhanVien timNhanVienTheoMa(String maNV) {		
		OgmSession session = sessionFactory.getCurrentSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {		
			NhanVien nv = new NhanVien();
			tr.begin();
			nv = session.find(NhanVien.class,maNV);
			tr.commit();
			return nv;
		} catch (Exception e) {
			tr.rollback();
		}	
		return null;
	}
	public List<NhanVien> timNhanVienTheoTen(String tenNV){
		List<NhanVien> nv = new ArrayList<NhanVien>();
		List<NhanVien> rs = new ArrayList<NhanVien>();
		nv = getAllNhanVien();
		for (NhanVien nhanvien : nv) {
			if (nhanvien.getHoTenNV().equals(tenNV)) {
				rs.add(nhanvien);
			}
		}
		return rs;
	}

	public List<NhanVien> getAllNhanVien() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			List<NhanVien> nhanvien = new ArrayList<NhanVien>();
			String query ="select nv from NhanVien nv";
			nhanvien = session.createQuery(query,NhanVien.class).getResultList();
			tr.commit();
			return nhanvien;
		} catch (Exception e) {
			tr.rollback();
		}
		session.close();
		return null;
	}
	//QLCD> db.NhanVien.find({'taiKhoan.chucVu' : 'QL'})
	public NhanVien checkDangNhap(String tk, String mk) {
		OgmSession session = sessionFactory.openSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {
			tr.begin();			
			String query = "db.NhanVien.find({'taiKhoan.taiKhoan' : '"+tk+"'})";
			NhanVien nv = session.createNativeQuery(query, NhanVien.class).getSingleResult();			
			tr.commit();
			if(nv.getTaiKhoan().getMatKhau().equals(mk))
				return nv;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}
	public NhanVien timNVTheoTenDN(String tk) {
		OgmSession session = sessionFactory.openSession();
		org.hibernate.Transaction tr = session.getTransaction();
		try {
			tr.begin();			
			String query = "db.NhanVien.find({'taiKhoan.taiKhoan' : '"+tk+"'})";
			NhanVien nv = session.createNativeQuery(query, NhanVien.class).getSingleResult();			
			tr.commit();
			return nv;
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
		return null;
	}
	public boolean doiMatKhau(String tendangnhap, String password, String passwordxacthuclai) {
		if(password.equals("")||passwordxacthuclai.equals("")||tendangnhap.equals("")) {
			JOptionPane.showMessageDialog(null, "Không được bỏ trống");
			return false;
		}
		else if(password.equals(passwordxacthuclai)) {
			NhanVien nv = timNVTheoTenDN(tendangnhap);
			String CV = nv.getTaiKhoan().getChucVu();
			nv.setTaiKhoan(new TaiKhoan(tendangnhap, passwordxacthuclai, CV));
			suaNhanVien(nv);
			return true;
			}
		else {
			JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại không trùng khớp");
		}
		return false;
			
		
		
		
	}
}
