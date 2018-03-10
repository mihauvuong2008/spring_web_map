package spring_web_map.model;

public class HamcapInfo {
	private int ham_cap_id;
	private String ten_ham_cap;
	private int treo_ngam;
	private int vi_tri_id;

	public HamcapInfo(int ham_cap_id, String ten_ham_cap, int treo_ngam, int vi_tri_id) {
		super();
		this.ham_cap_id = ham_cap_id;
		this.ten_ham_cap = ten_ham_cap;
		this.treo_ngam = treo_ngam;
		this.vi_tri_id = vi_tri_id;
	}

	public HamcapInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getHam_cap_id() {
		return ham_cap_id;
	}

	public void setHam_cap_id(int ham_cap_id) {
		this.ham_cap_id = ham_cap_id;
	}

	public String getTen_ham_cap() {
		return ten_ham_cap;
	}

	public void setTen_ham_cap(String ten_ham_cap) {
		this.ten_ham_cap = ten_ham_cap;
	}

	public int getTreo_ngam() {
		return treo_ngam;
	}

	public void setTreo_ngam(int treo_ngam) {
		this.treo_ngam = treo_ngam;
	}

	public int getVi_tri_id() {
		return vi_tri_id;
	}

	public void setVi_tri_id(int vi_tri_id) {
		this.vi_tri_id = vi_tri_id;
	}

	public String toString() {
		return ham_cap_id + ", " + ten_ham_cap + ", " + treo_ngam + ", " + vi_tri_id;
	}

}
