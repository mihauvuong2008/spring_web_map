package spring_web_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mang_xong")
public class Mangxong {
	private int mang_xong_id;
	private String ghi_chu;

	@Id
	@Column(name = "Mang_xong_id", nullable = false)
	public int getMang_xong_id() {
		return mang_xong_id;
	}

	public void setMang_xong_id(int mang_xong_id) {
		this.mang_xong_id = mang_xong_id;
	}

	@Column(name = "Ghi_chu", length = 500, nullable = false)
	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

}
