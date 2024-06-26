
package model;

import java.io.Serializable;

public class DiaPhim extends SanPham implements Serializable {
	private String tenDaoDien;
	private String tenDienVien;

	public DiaPhim(String maSanPham, String tenSanPham, int giaMua, int giaBan, String nhaCungCap, int soLuong,
			String tenDaoDien, String tenDienVien) {
		super(maSanPham, tenSanPham, giaMua, giaBan, nhaCungCap, soLuong);
		this.tenDaoDien = tenDaoDien;
		this.tenDienVien = tenDienVien;
	}

	public String getTenDaoDien() {
		return tenDaoDien;
	}

	public void setTenDaoDien(String tenDaoDien) {
		this.tenDaoDien = tenDaoDien;
	}

	public String getTenDienVien() {
		return tenDienVien;
	}

	public void setTenDienVien(String tenDienVien) {
		this.tenDienVien = tenDienVien;
	}

}
