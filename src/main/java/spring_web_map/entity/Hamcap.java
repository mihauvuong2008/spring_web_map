package spring_web_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ham_cap")
public class Hamcap {
	private int ham_cap_id;
	private int ten_ham_cap;
	private int treo_ngam;

	@Id
	@Column(name = "Ham_cap_id", nullable = false)
	public int getHam_cap_id() {
		return ham_cap_id;
	}

	public void setHam_cap_id(int ham_cap_id) {
		this.ham_cap_id = ham_cap_id;
	}

	@Column(name = "Ten_ham_cap", length = 300, nullable = false)
	public int getTen_ham_cap() {
		return ten_ham_cap;
	}

	public void setTen_ham_cap(int ten_ham_cap) {
		this.ten_ham_cap = ten_ham_cap;
	}

	@Column(name = "Treo_ngam", nullable = false)
	public int getTreo_ngam() {
		return treo_ngam;
	}

	public void setTreo_ngam(int treo_ngam) {
		this.treo_ngam = treo_ngam;
	}

}
