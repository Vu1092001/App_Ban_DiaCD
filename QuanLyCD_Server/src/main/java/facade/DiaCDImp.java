package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.DiaCDDao;
import entity.DiaCD;

public class DiaCDImp extends UnicastRemoteObject implements DiaCDFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5371773478976157335L;
	DiaCDDao cdDao = new DiaCDDao();

	public DiaCDImp() throws RemoteException {
		cdDao = new DiaCDDao();
	}

	@Override
	public boolean themDiaCD(DiaCD diaCD) throws RemoteException {
	
		return cdDao.themDiaCD(diaCD);
	}

	@Override
	public List<DiaCD> getAllDiaCD() throws RemoteException {
		// TODO Auto-generated method stub
		return cdDao.getAllDiaCD();
	}

	@Override
	public boolean xoaDiaCD(DiaCD cd) throws RemoteException {
		// TODO Auto-generated method stub
		return cdDao.xoaDiaCD(cd);
	}

	@Override
	public boolean suaDiaCD(DiaCD cd) throws RemoteException {
		// TODO Auto-generated method stub
		return cdDao.suaDiaCD(cd);
	}

	@Override
	public DiaCD timCDTheoMa(String macd) throws RemoteException {
		// TODO Auto-generated method stub
		return cdDao.timCDTheoMa(macd);
	}

	@Override
	public List<DiaCD> timCDTheoTen(String tenCD) throws RemoteException {
		// TODO Auto-generated method stub
		return cdDao.timCDTheoTen(tenCD);
	}

	@Override
	public List<DiaCD> timCDTheoTheLoai(String theLoai) throws RemoteException {
		// TODO Auto-generated method stub
		return cdDao.timCDTheoTheLoai(theLoai);
	}
}
