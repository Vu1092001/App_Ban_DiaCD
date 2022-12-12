package app;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import entity.PhieuMuon;
import facade.DiaCDFacade;
import facade.NhanVienFacade;
import facade.PhieuMuonFacade;
import facade.PhieuTraFacade;
import facade.ThanhVienFacade;

public class App_2 {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {			
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			PhieuMuonFacade	phieuMuonFacade = (PhieuMuonFacade) Naming.lookup("rmi://192.168.1.31:1088/phieuMuonFacade");
			DiaCDFacade	diaCDFacade = (DiaCDFacade) Naming.lookup("rmi://192.168.1.31:1088/diaCDFacade");
			NhanVienFacade	nhanVienFacade = (NhanVienFacade) Naming.lookup("rmi://192.168.1.31:1088/nhanVienFacade");
			ThanhVienFacade	thanhVienFacade = (ThanhVienFacade) Naming.lookup("rmi://192.168.1.31:1088/thanhVienFacade");
			PhieuTraFacade	phieuTraFacade = (PhieuTraFacade) Naming.lookup("rmi://192.168.1.31:1088/phieuTraFacade");
//			nhanVienFacade.doiMatKhau("nam","123","123"); 
			
//			thanhVienFacade.getAllThanhVien().forEach(rs -> System.out.println(rs));			
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
