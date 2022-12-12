package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1967863212621720278L;
	@Id
	@Column(name = "Mã NV")
	private String maNV;
	@Column(name = "Tên NV")
	private String hoTenNV;
	@Column(name = "Giới Tính")
	private String gioiTinh;
	@Column(name = "Điện Thoại")
	private String dienThoai;
	@Column(name = "Địa Chỉ")
	private String diaChi;
	@Column(name = "CMND")
	private String cMND;
	@Column(name = "Email")
	private String email;
	
	@Embedded
	private TaiKhoan taiKhoan;
	
	public NhanVien() {
		super();
	}

	public NhanVien(String maNV, String hoTenNV, String gioiTinh, String dienThoai, String diaChi, String cMND,
			String email, TaiKhoan taiKhoan) {
		super();
		this.maNV = maNV;
		this.hoTenNV = hoTenNV;
		this.gioiTinh = gioiTinh;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
		this.cMND = cMND;
		this.email = email;
		this.taiKhoan = taiKhoan;
	}

	public String getMaNV() {
		return maNV;
	}
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTenNV() {
		return hoTenNV;
	}

	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
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

	public String getcMND() {
		return cMND;
	}

	public void setcMND(String cMND) {
		this.cMND = cMND;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTenNV=" + hoTenNV + ", gioiTinh=" + gioiTinh + ", dienThoai=" + dienThoai
				+ ", diaChi=" + diaChi + ", cMND=" + cMND + ", email=" + email + ", taiKhoan=" + taiKhoan + "]";
	}


	
}
