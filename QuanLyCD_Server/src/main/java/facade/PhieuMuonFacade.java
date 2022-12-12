package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import entity.PhieuMuon;

public interface PhieuMuonFacade extends Remote{
	public boolean themPhieuMuon(PhieuMuon phieuMuon)throws RemoteException;
	public List<PhieuMuon> getAllPhieuMuon()throws RemoteException;
	public boolean xoaPhieuMuon(PhieuMuon pm)throws RemoteException;
	public boolean suaPhieuMuon(PhieuMuon pm)throws RemoteException;
	public PhieuMuon timPhieuMuonTheoMa(String ma)throws RemoteException;
	public List<PhieuMuon> timPhieuMuonTheoTenNhanVien(String tenNV)throws RemoteException;
	public List<PhieuMuon> timPhieuMuonTheoTenKhachHang(String tenKH)throws RemoteException;
	public List<PhieuMuon> timPhieuMuonTheoNgayMuon(Date ngayMuon)throws RemoteException;
	
}
