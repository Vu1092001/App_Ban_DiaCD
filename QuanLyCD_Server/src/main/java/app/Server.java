package app;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import facade.DiaCDFacade;
import facade.DiaCDImp;
import facade.NhanVienFacade;
import facade.NhanVienImp;
import facade.PhieuMuonFacade;
import facade.PhieuMuonImp;
import facade.PhieuTraFacade;
import facade.PhieuTraImp;
import facade.ThanhVienFacade;
import facade.ThanhVienImpl;

public class Server {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "myrmi/myrmi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {	
			 InetAddress myIP = InetAddress.getLocalHost();
		
			LocateRegistry.createRegistry(1088);
					
			PhieuMuonFacade phieuMuonFacade = new PhieuMuonImp();
			NhanVienFacade nhanVienFacade = new NhanVienImp();
			DiaCDFacade diaCDFacade = new DiaCDImp();
			PhieuTraFacade phieuTraFacade = new PhieuTraImp();
			ThanhVienFacade thanhVienFacade = new ThanhVienImpl();	
			
			Naming.bind("rmi://"+myIP.getHostAddress()+":1088/phieuMuonFacade", phieuMuonFacade);
			Naming.bind("rmi://"+myIP.getHostAddress()+":1088/diaCDFacade", diaCDFacade);
			Naming.bind("rmi://"+myIP.getHostAddress()+":1088/nhanVienFacade", nhanVienFacade);
			Naming.bind("rmi://"+myIP.getHostAddress()+":1088/phieuTraFacade", phieuTraFacade);
			Naming.bind("rmi://"+myIP.getHostAddress()+":1088/thanhVienFacade", thanhVienFacade);

					
			System.out.println("Server bound in RMIRegistry");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
