
package util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmProperties;

import entity.DiaCD;
import entity.NhanVien;
import entity.PhieuMuon;
import entity.PhieuTra;
import entity.TaiKhoan;
import entity.ThanhVien;
import entity.TheThanhVien;

public class HibernateUtil {
	
	private static HibernateUtil instance = null;
	private OgmSessionFactory sessionFactory;
	private HibernateUtil() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySetting(OgmProperties.ENABLED, true)
				.configure()
				.build();
		Metadata meta = new MetadataSources(registry)
				.addAnnotatedClass(ThanhVien.class)
				.addAnnotatedClass(DiaCD.class)
				.addAnnotatedClass(NhanVien.class)
				.addAnnotatedClass(PhieuMuon.class)
				.addAnnotatedClass(PhieuTra.class)
				.addAnnotatedClass(TheThanhVien.class)
				.addAnnotatedClass(TaiKhoan.class)
				.getMetadataBuilder()
				.build();
		
		sessionFactory = meta
				.getSessionFactoryBuilder()
				.unwrap(OgmSessionFactoryBuilder.class)
				.build();
	}
	
	public static HibernateUtil getInstance() {
		if(instance == null)
			instance = new HibernateUtil();
		return instance;
	}
	
	public OgmSessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
