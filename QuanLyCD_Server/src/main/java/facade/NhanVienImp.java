package facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.NhanVienDao;
import entity.NhanVien;

public class NhanVienImp extends UnicastRemoteObject implements NhanVienFacade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 179411877259475905L;
	NhanVienDao nhanVienDao;

	public NhanVienImp() throws RemoteException {
		nhanVienDao = new NhanVienDao();
	}

	@Override
	public boolean themNhanVien(NhanVien nhanVien) throws RemoteException {
		
		return nhanVienDao.themNhanVien(nhanVien);
	}

	@Override
	public List<NhanVien> getAllNhanVien() throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienDao.getAllNhanVien();
	}

	@Override
	public boolean xoaNhanVien(NhanVien nv) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienDao.xoaNhanVien(nv);
	}

	@Override
	public boolean suaNhanVien(NhanVien nv) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienDao.suaNhanVien(nv);
	}

	@Override
	public NhanVien timNhanVienTheoMa(String maNV) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienDao.timNhanVienTheoMa(maNV);
	}

	@Override
	public List<NhanVien> timNhanVienTheoTen(String tenNV) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienDao.timNhanVienTheoTen(tenNV);
	}

	@Override
	public NhanVien checkDangNhap(String tk, String mk) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienDao.checkDangNhap(tk, mk);
	}

	@Override
	public boolean doiMatKhau(String tendangnhap, String password, String passwordxacthuclai) throws RemoteException {
		// TODO Auto-generated method stub
		return nhanVienDao.doiMatKhau(tendangnhap, password, passwordxacthuclai);
	}
	
}
