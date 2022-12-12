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
public class PhieuMuon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8177037550724513158L;

	@Id
	private String maPhieuMuon;
	
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
	private double tongTien;
	
	public PhieuMuon() {
		super();
	}
	public PhieuMuon(String maPhieuMuon) {
		super();
		this.maPhieuMuon = maPhieuMuon;
	}
	public PhieuMuon(String maPhieuMuon, ThanhVien thanhVien, NhanVien nhanVien, List<String> diaCDs, int soLuong,
			Date ngayMuon, int hanNgayMuon, double tongTien) {
		super();
		this.maPhieuMuon = maPhieuMuon;
		this.thanhVien = thanhVien;
		this.nhanVien = nhanVien;
		this.diaCDs = diaCDs;
		this.soLuong = soLuong;
		this.ngayMuon = ngayMuon;
		this.hanNgayMuon = hanNgayMuon;
		this.tongTien = tongTien;
	}
	public String getMaPhieuMuon() {
		return maPhieuMuon;
	}

	public void setMaPhieuMuon(String maPhieuMuon) {
		this.maPhieuMuon = maPhieuMuon;
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

	public List<String> getDiaCDs() {
		return diaCDs;
	}

	public void setDiaCDs(List<String> diaCDs) {
		this.diaCDs = diaCDs;
	}
	
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return "PhieuMuon [maPhieuMuon=" + maPhieuMuon + ", thanhVien=" + thanhVien.getHoTen() + ", nhanVien=" + nhanVien.getHoTenNV()
				+ ", diaCDs=" + diaCDs + ", soLuong=" + soLuong + ", ngayMuon=" + ngayMuon + ", hanNgayMuon="
				+ hanNgayMuon + ", tongTien=" + tongTien + "]";
	}





	
}
