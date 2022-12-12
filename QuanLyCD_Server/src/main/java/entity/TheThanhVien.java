package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
@Embeddable
public class TheThanhVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4654758651992832943L;
	private Date ngayMo;
	private Date ngayHetHan;
	public TheThanhVien() {
		super();
	}
	
	public TheThanhVien(Date ngayMo, Date ngayHetHan) {
		super();
	
		this.ngayMo = ngayMo;
		this.ngayHetHan = ngayHetHan;
	}
	public Date getNgayMo() {
		return ngayMo;
	}
	public void setNgayMo(Date ngayMo) {
		this.ngayMo = ngayMo;
	}
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	
	@Override
	public String toString() {
		return "TheThanhVien [ngayMo=" + ngayMo + ", ngayHetHan=" + ngayHetHan + "]";
	}
	
}
