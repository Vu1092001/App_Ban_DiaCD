package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ThanhVienDao;
import entity.ThanhVien;

public class ThanhVienImpl extends UnicastRemoteObject implements ThanhVienFacade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2567613554295895789L;
	ThanhVienDao thanhviendao;
	public ThanhVienImpl() throws RemoteException {
		thanhviendao=new ThanhVienDao();
	}

	@Override
	public boolean themThanhVien(ThanhVien thanhVien) throws RemoteException {
		
		return thanhviendao.themThanhVien(thanhVien);
		
	}

	@Override
	public boolean xoaThanhVien(ThanhVien tv) throws RemoteException {
		// TODO Auto-generated method stub
		return thanhviendao.xoaThanhVien(tv);
	}

	@Override
	public boolean suaThanhVien(ThanhVien tv) throws RemoteException {
		// TODO Auto-generated method stub
		return thanhviendao.suaThanhVien(tv);
	}

	@Override
	public List<ThanhVien> getAllThanhVien() throws RemoteException {
		// TODO Auto-generated method stub
		return thanhviendao.getAllThanhVien();
	}

	@Override
	public ThanhVien timThanhVienTheoMa(String maThanhVien) throws RemoteException {
		// TODO Auto-generated method stub
		return thanhviendao.timThanhVienTheoMa(maThanhVien);
	}

	@Override
	public List<ThanhVien> timThanhVienTheoHoTen(String hoTen) throws RemoteException {
		// TODO Auto-generated method stub
		return thanhviendao.timThanhVienTheoHoTen(hoTen);
	}

	@Override
	public List<ThanhVien> timThanhVienTheoSDT(String dienthoai) throws RemoteException {
		// TODO Auto-generated method stub
		return thanhviendao.timThanhVienTheoSDT(dienthoai);
	}

}
