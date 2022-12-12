package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TaiKhoan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8754179395269213453L;
//	@Column(name = "Tài Khoản")
	private String taiKhoan;
//	@Column(name = "Mật Khẩu")
	private String matKhau;
//	@Column(name = "Chức Vụ")
	private String chucVu;
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(String taiKhoan, String matKhau, String chucVu) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.chucVu = chucVu;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	@Override
	public String toString() {
		return "TaiKhoan [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", chucVu=" + chucVu + "]";
	}
	
	
}
