package facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.DiaCD;

public interface DiaCDFacade extends Remote{
	public boolean themDiaCD(DiaCD diaCD)throws RemoteException;
	public List<DiaCD> getAllDiaCD()throws RemoteException;
	public boolean xoaDiaCD(DiaCD cd)throws RemoteException;
	public boolean suaDiaCD(DiaCD cd)throws RemoteException;
	public DiaCD timCDTheoMa(String macd)throws RemoteException;
	public List<DiaCD> timCDTheoTen(String tenCD)throws RemoteException;
	public List<DiaCD> timCDTheoTheLoai(String theLoai)throws RemoteException;	
}
