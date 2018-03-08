package spring_web_map.model;

public class HamcapInfo {
	private int ham_cap_id;
	private int ten_ham_cap;
	private int treo_ngam;

	public HamcapInfo(int ham_cap_id, int ten_ham_cap, int treo_ngam) {
		super();
		this.ham_cap_id = ham_cap_id;
		this.ten_ham_cap = ten_ham_cap;
		this.treo_ngam = treo_ngam;
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

	public int getTen_ham_cap() {
		return ten_ham_cap;
	}

	public void setTen_ham_cap(int ten_ham_cap) {
		this.ten_ham_cap = ten_ham_cap;
	}

	public int getTreo_ngam() {
		return treo_ngam;
	}

	public void setTreo_ngam(int treo_ngam) {
		this.treo_ngam = treo_ngam;
	}

}
