package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class DiaCD implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 101574128641161421L;
	@Id
	private String maDia;
	@Column(name = "Ten_CD")
	private String tenDia;
	@Column(name = "The_Loai")
	private String theLoai;
	@Column(name = "Tinh_Trang")
	private String tinhTrang;
	@Column(name = "Hang_SX")
	private String hangSanXuat;
	@Column(name = "Ghi_Chu")
	private String ghiChu;
	@Column(name = "Số_Lượng")
	private int soLuong;
	@Column(name = "Đơn giá")
	private double donGia;
	
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public DiaCD(String maDia, String tenDia, String theLoai, String tinhTrang, String hangSanXuat, String ghiChu,
			int soLuong, double donGia) {
		super();
		this.maDia = maDia;
		this.tenDia = tenDia;
		this.theLoai = theLoai;
		this.tinhTrang = tinhTrang;
		this.hangSanXuat = hangSanXuat;
		this.ghiChu = ghiChu;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public DiaCD() {
		super();
	}
	public DiaCD(String maDia) {
		super();
		this.maDia = maDia;
	}
	public String getMaDia() {
		return maDia;
	}
	public void setMaDia(String maDia) {
		this.maDia = maDia;
	}
	public String getTenDia() {
		return tenDia;
	}
	public void setTenDia(String tenDia) {
		this.tenDia = tenDia;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "DiaCD [maDia=" + maDia + ", tenDia=" + tenDia + ", theLoai=" + theLoai + ", tinhTrang=" + tinhTrang
				+ ", hangSanXuat=" + hangSanXuat + ", ghiChu=" + ghiChu + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ "]";
	}

	
	
	
}
