package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import dao.DiaCDDao;
import dao.PhieuMuonDao;
import entity.DiaCD;
import entity.PhieuMuon;

public class PhieuMuonImp extends UnicastRemoteObject implements PhieuMuonFacade{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2770330932967457735L;
	DiaCDDao cdDao = new DiaCDDao();
	PhieuMuonDao pmDao;
	
//	public PhieuMuonImp() throws RemoteException {
//		pmDao = new PhieuMuonDao();		
//	}
	public PhieuMuonImp() throws RemoteException {
		pmDao = new PhieuMuonDao();		
	}

	@Override
	public boolean themPhieuMuon(PhieuMuon phieuMuon) throws RemoteException {
		
		if(phieuMuon.getMaPhieuMuon() == null)
			return false;
		if(phieuMuon.getDiaCDs().size() != 0) {
			List<String> lscd = phieuMuon.getDiaCDs();
			for (String cd : lscd) {
				DiaCD CD = cdDao.timCDTheoMa(cd);
				if (cd == null ) {
					return false;
				}
				else if(CD.getSoLuong() == 0 && !CD.getMaDia().equals("0000")) {
					return false;
				}
				else if (CD.getMaDia().equals("0000")) {
					return pmDao.themPhieuMuon(phieuMuon);
				}			
				int sl = CD.getSoLuong();
				CD.setSoLuong(sl-1);
			}
		}	
		return pmDao.themPhieuMuon(phieuMuon);
	}
	
	@Override
	public List<PhieuMuon> getAllPhieuMuon() throws RemoteException {
		
		return pmDao.getAllPhieuMuon();
	}

	@Override
	public boolean xoaPhieuMuon(PhieuMuon pm) throws RemoteException {
		// TODO Auto-generated method stub
		return pmDao.xoaPhieuMuon(pm);
	}

	@Override
	public boolean suaPhieuMuon(PhieuMuon pm) throws RemoteException {
		// TODO Auto-generated method stub
		return pmDao.suaPhieuMuon(pm);
	}

	@Override
	public PhieuMuon timPhieuMuonTheoMa(String ma) throws RemoteException {
		// TODO Auto-generated method stub
		return pmDao.timPhieuMuonTheoMa(ma);
	}

	@Override
	public List<PhieuMuon> timPhieuMuonTheoTenNhanVien(String tenNV) throws RemoteException {
		// TODO Auto-generated method stub
		return pmDao.timPhieuMuonTheoTenNhanVien(tenNV);
	}

	@Override
	public List<PhieuMuon> timPhieuMuonTheoTenKhachHang(String tenKH) throws RemoteException {
		// TODO Auto-generated method stub
		return pmDao.timPhieuMuonTheoTenKhachHang(tenKH);
	}

	@Override
	public List<PhieuMuon> timPhieuMuonTheoNgayMuon(Date ngayMuon) throws RemoteException {
		// TODO Auto-generated method stub
		return pmDao.timPhieuMuonTheoNgayMuon(ngayMuon);
	}

}
