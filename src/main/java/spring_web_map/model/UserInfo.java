package spring_web_map.model;

import java.util.Date;

public class UserInfo {

	private String userName;
	private String password;
	private String hoten;
	private Date ngaysinh;
	private String lienhe;
	private String gioithieu;
	private Date last_modify;
	private boolean enabled;

	public UserInfo() {

	}

	// Không thay đổi Constructor này, nó được sử dụng trong Hibernate Query
	public UserInfo(String userName, String password, String hoten, Date ngaysinh, String lienhe, String gioithieu,Date last_modify) {
		this.userName = userName;
		this.password = password;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioithieu = gioithieu;
		this.lienhe = lienhe;
		this.last_modify = last_modify;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getLienhe() {
		return lienhe;
	}

	public void setLienhe(String lienhe) {
		this.lienhe = lienhe;
	}

	public String getGioithieu() {
		return gioithieu;
	}

	public void setGioithieu(String gioithieu) {
		this.gioithieu = gioithieu;
	}

	public Date getLast_modify() {
		return last_modify;
	}

	public void setLast_modify(Date last_modify) {
		this.last_modify = last_modify;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "string: { " + userName + ", " + password + ", " + hoten + ", " + ngaysinh + ", " + lienhe + ", "
				+ gioithieu + ", " + last_modify + ", " + enabled + '}';
	}
}