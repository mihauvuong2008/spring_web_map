package spring_web_map.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Users")
public class User {

	private String username;
	private String password;
	private String hoten;
    @Temporal(TemporalType.DATE)
	private Date ngaysinh;
	private String lienhe;
	private String gioithieu;
    @Temporal(TemporalType.DATE)
	private Date last_modify;
	private boolean enabled;

	@Id
	@Column(name = "Username", length = 36, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password", length = 36, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Hoten", length = 100, nullable = false)
	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	@Column(name = "Ngaysinh", nullable = true)
	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	@Column(name = "Lienhe", length = 300, nullable = true)
	public String getLienhe() {
		return lienhe;
	}

	public void setLienhe(String lienhe) {
		this.lienhe = lienhe;
	}

	@Column(name = "Gioithieu", length = 500, nullable = true)
	public String getGioithieu() {
		return gioithieu;
	}

	public void setGioithieu(String gioithieu) {
		this.gioithieu = gioithieu;
	}

	@Column(name = "Last_modify", nullable = true)
	public Date getLast_modify() {
		return last_modify;
	}

	public void setLast_modify(Date last_modify) {
		this.last_modify = last_modify;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}