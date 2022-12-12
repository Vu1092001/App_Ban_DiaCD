package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import entity.PhieuTra;

public interface PhieuTraFacade extends Remote{

	public List<PhieuTra> getAllPhieuTra( ) 	throws RemoteException;
	public boolean themPhieuTra(PhieuTra phieuTra)	throws RemoteException;
	public boolean xoaPhieutra(PhieuTra pm)	throws RemoteException;
	public boolean suaPhieuTra(PhieuTra pm)	throws RemoteException;
	public PhieuTra timPhieuTraTheoMa(String ma)	throws RemoteException;
	public List<PhieuTra> timPhiuTraTheoTenNhanVien(String tenNV)	throws RemoteException;
	public List<PhieuTra> timPhieuTraTheoTenKhachHang(String tenKH)	throws RemoteException;
	public List<PhieuTra> timPhieuTraTheoNgayMuon(Date ngayMuon)	throws RemoteException;
	
	
}
