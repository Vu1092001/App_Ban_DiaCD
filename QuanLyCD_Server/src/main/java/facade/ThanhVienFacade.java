package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.ThanhVien;

public interface ThanhVienFacade extends Remote {
	public boolean themThanhVien(ThanhVien thanhVien) throws RemoteException;
	public boolean xoaThanhVien(ThanhVien tv) throws RemoteException;
	public boolean suaThanhVien(ThanhVien tv) throws RemoteException;
	public List<ThanhVien> getAllThanhVien() throws RemoteException;
	public ThanhVien timThanhVienTheoMa(String maThanhVien) throws RemoteException;
	public List<ThanhVien> timThanhVienTheoHoTen(String hoTen) throws RemoteException;
	public List<ThanhVien> timThanhVienTheoSDT(String dienthoai) throws RemoteException;
}
