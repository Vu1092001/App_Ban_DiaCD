package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ThanhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3234686727306803185L;
	@Id
	private String maThanhVien;
	@Column(name = "Ho_Ten")
	private String hoTen;
	@Column(name = "Gioi_Tinh")
	private String gioiTinh;
	@Column(name = "Dien_Thoai")
	private String dienThoai;
	@Column(name = "Dia_Chi")
	private String diaChi;
	@Column(name = "So_CMND")
	private String soCMND;
	
	@Embedded
	private TheThanhVien theThanhVien;

	public ThanhVien() {
		super();
	}

	public ThanhVien(String maThanhVien) {
		super();
		this.maThanhVien = maThanhVien;
	}

	public ThanhVien(String maThanhVien, String hoTen, String gioiTinh, String dienThoai, String diaChi, String soCMND,
			TheThanhVien theThanhVien) {
		super();
		this.maThanhVien = maThanhVien;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
		this.soCMND = soCMND;
		this.theThanhVien = theThanhVien;
	}

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public TheThanhVien getTheThanhVien() {
		return theThanhVien;
	}

	public void setTheThanhVien(TheThanhVien theThanhVien) {
		this.theThanhVien = theThanhVien;
	}

	@Override
	public String toString() {
		return "ThanhVien [maThanhVien=" + maThanhVien + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", dienThoai="
				+ dienThoai + ", diaChi=" + diaChi + ", soCMND=" + soCMND + ", theThanhVien=" + theThanhVien + "]";
	}
	
	
}
