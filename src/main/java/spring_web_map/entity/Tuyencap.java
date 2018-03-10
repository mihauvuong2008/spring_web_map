package spring_web_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tuyen_cap")
public class Tuyencap {
	private int tuyen_cap_id;
	private String ten_tuyen_cap;
	private int chieu_dai_tuyen_cap;
	private int so_core;
	private int vi_tri_diem_dau_id;
	private int vi_tri_diem_cuoi_id;
	private String mo_ta_tuyen_cap;

	@Id
	@Column(name = "tuyen_cap_id", nullable = false)
	public int getTuyen_cap_id() {
		return tuyen_cap_id;
	}

	public void setTuyen_cap_id(int tuyen_cap_id) {
		this.tuyen_cap_id = tuyen_cap_id;
	}

	@Column(name = "ten_tuyen_cap", length = 300, nullable = false)
	public String getTen_tuyen_cap() {
		return ten_tuyen_cap;
	}

	public void setTen_tuyen_cap(String ten_tuyen_cap) {
		this.ten_tuyen_cap = ten_tuyen_cap;
	}

	@Column(name = "chieu_dai_tuyen_cap", nullable = false)
	public int getChieu_dai_tuyen_cap() {
		return chieu_dai_tuyen_cap;
	}

	public void setChieu_dai_tuyen_cap(int chieu_dai_tuyen_cap) {
		this.chieu_dai_tuyen_cap = chieu_dai_tuyen_cap;
	}

	@Column(name = "so_core", nullable = false)
	public int getSo_core() {
		return so_core;
	}

	public void setSo_core(int so_core) {
		this.so_core = so_core;
	}

	@Column(name = "vi_tri_diem_dau_id", nullable = false)
	public int getVi_tri_diem_dau_id() {
		return vi_tri_diem_dau_id;
	}

	public void setVi_tri_diem_dau_id(int vi_tri_diem_dau_id) {
		this.vi_tri_diem_dau_id = vi_tri_diem_dau_id;
	}
 

	@Column(name = "vi_tri_diem_cuoi_id", nullable = false)
	public int getVi_tri_diem_cuoi_id() {
		return vi_tri_diem_cuoi_id;
	}

	public void setVi_tri_diem_cuoi_id(int vi_tri_diem_cuoi_id) {
		this.vi_tri_diem_cuoi_id = vi_tri_diem_cuoi_id;
	}

	@Column(name = "mo_ta_tuyen_cap", length = 500, nullable = false)
	public String getMo_ta_tuyen_cap() {
		return mo_ta_tuyen_cap;
	}

	public void setMo_ta_tuyen_cap(String mo_ta_tuyen_cap) {
		this.mo_ta_tuyen_cap = mo_ta_tuyen_cap;
	}

}
