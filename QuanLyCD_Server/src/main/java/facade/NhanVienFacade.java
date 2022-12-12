package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVienFacade extends Remote{
	public boolean themNhanVien(NhanVien nhanVien)throws RemoteException;
	public List<NhanVien> getAllNhanVien()throws RemoteException;
	public boolean xoaNhanVien(NhanVien nv)throws RemoteException;
	public boolean suaNhanVien(NhanVien nv)throws RemoteException;
	public NhanVien timNhanVienTheoMa(String maNV)throws RemoteException;
	public List<NhanVien> timNhanVienTheoTen(String tenNV)throws RemoteException;	
	public NhanVien checkDangNhap(String tk, String mk) throws RemoteException;
	public boolean doiMatKhau(String tendangnhap, String password, String passwordxacthuclai) throws RemoteException;
}
