package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import dao.PhieuTraDao;
import entity.PhieuTra;

public class PhieuTraImp extends UnicastRemoteObject implements PhieuTraFacade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7973202195731905801L;
	private PhieuTraDao ptDao;

	public PhieuTraImp() throws RemoteException {
		ptDao = new PhieuTraDao();
	}

	@Override
	public List<PhieuTra> getAllPhieuTra() throws RemoteException {
		// TODO Auto-generated method stub
		return ptDao.getAllPhieuTra();
	}

	@Override
	public boolean themPhieuTra(PhieuTra phieuTra) throws RemoteException {
		// TODO Auto-generated method stub
		return ptDao.themPhieuTra(phieuTra);
	}

	@Override
	public boolean xoaPhieutra(PhieuTra pm) throws RemoteException {
		// TODO Auto-generated method stub
		return ptDao.xoaPhieutra(pm);
	}

	@Override
	public boolean suaPhieuTra(PhieuTra pm) throws RemoteException {
		// TODO Auto-generated method stub
		return ptDao.suaPhieuTra(pm);
	}

	@Override
	public PhieuTra timPhieuTraTheoMa(String ma) throws RemoteException {
		// TODO Auto-generated method stub
		return ptDao.timPhieuTraTheoMa(ma);
	}

	@Override
	public List<PhieuTra> timPhiuTraTheoTenNhanVien(String tenNV) throws RemoteException {
		// TODO Auto-generated method stub
		return ptDao.timPhiuTraTheoTenNhanVien(tenNV);
	}

	@Override
	public List<PhieuTra> timPhieuTraTheoTenKhachHang(String tenKH) throws RemoteException {
		// TODO Auto-generated method stub
		return ptDao.timPhieuTraTheoTenKhachHang(tenKH);
	}

	@Override
	public List<PhieuTra> timPhieuTraTheoNgayMuon(Date ngayMuon) throws RemoteException {
		// TODO Auto-generated method stub
		return ptDao.timPhieuTraTheoNgayMuon(ngayMuon);
	}
	
	
}
