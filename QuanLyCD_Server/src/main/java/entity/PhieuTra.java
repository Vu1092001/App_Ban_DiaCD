package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PhieuTra implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6753904974873067758L;

	@Id
	private String maPhieuTra;
	
	@ManyToOne
	@JoinColumn(name = "ThanhVien")
	private ThanhVien thanhVien;
	
	
	@ManyToOne
	@JoinColumn(name = "NhanVien")
	private NhanVien nhanVien;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> diaCDs;
		
	private int soLuong;
	private Date ngayMuon;
	private int hanNgayMuon;
	
	private String trangThai;
	private Date ngayTra;
	private double tienPhat;
	private double tienTraLai;
	
	public PhieuTra() {
		super();
	}
	public PhieuTra(String maPhieuTra) {
		super();
		this.maPhieuTra = maPhieuTra;
	}
	public PhieuTra(String maPhieuTra, ThanhVien thanhVien, NhanVien nhanVien, List<String> diaCDs, int soLuong,
			Date ngayMuon, int hanNgayMuon, String trangThai, Date ngayTra, double tienPhat, double tienTraLai) {
		super();
		this.maPhieuTra = maPhieuTra;
		this.thanhVien = thanhVien;
		this.nhanVien = nhanVien;
		this.diaCDs = diaCDs;
		this.soLuong = soLuong;
		this.ngayMuon = ngayMuon;
		this.hanNgayMuon = hanNgayMuon;
		this.trangThai = trangThai;
		this.ngayTra = ngayTra;
		this.tienPhat = tienPhat;
		this.tienTraLai = tienTraLai;
	}
	public String getMaPhieuTra() {
		return maPhieuTra;
	}
	public void setMaPhieuTra(String maPhieuTra) {
		this.maPhieuTra = maPhieuTra;
	}
	public ThanhVien getThanhVien() {
		return thanhVien;
	}
	public void setThanhVien(ThanhVien thanhVien) {
		this.thanhVien = thanhVien;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public List<String> getDiaCDs() {
		return diaCDs;
	}
	public void setDiaCDs(List<String> diaCDs) {
		this.diaCDs = diaCDs;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public int getHanNgayMuon() {
		return hanNgayMuon;
	}
	public void setHanNgayMuon(int hanNgayMuon) {
		this.hanNgayMuon = hanNgayMuon;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public double getTienPhat() {
		return tienPhat;
	}
	public void setTienPhat(double tienPhat) {
		this.tienPhat = tienPhat;
	}
	public double getTienTraLai() {
		return tienTraLai;
	}
	public void setTienTraLai(double tienTraLai) {
		this.tienTraLai = tienTraLai;
	}
	@Override
	public String toString() {
		return "PhieuTra [maPhieuTra=" + maPhieuTra + ", thanhVien=" + thanhVien + ", nhanVien=" + nhanVien
				+ ", diaCDs=" + diaCDs + ", soLuong=" + soLuong + ", ngayMuon=" + ngayMuon + ", hanNgayMuon="
				+ hanNgayMuon + ", trangThai=" + trangThai + ", ngayTra=" + ngayTra + ", tienPhat=" + tienPhat
				+ ", tienTraLai=" + tienTraLai + "]";
	}
	
	
	
}
