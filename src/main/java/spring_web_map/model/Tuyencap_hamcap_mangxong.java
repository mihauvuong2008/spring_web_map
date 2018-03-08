package spring_web_map.model;

public class Tuyencap_hamcap_mangxong {
	private int tuyen_cap_id;
	private int ham_cap_id;
	private int mang_xong_id;

	public Tuyencap_hamcap_mangxong(int tuyen_cap_id, int ham_cap_id, int mang_xong_id) {
		super();
		this.tuyen_cap_id = tuyen_cap_id;
		this.ham_cap_id = ham_cap_id;
		this.mang_xong_id = mang_xong_id;
	}

	public int getTuyen_cap_id() {
		return tuyen_cap_id;
	}

	public void setTuyen_cap_id(int tuyen_cap_id) {
		this.tuyen_cap_id = tuyen_cap_id;
	}

	public int getHam_cap_id() {
		return ham_cap_id;
	}

	public void setHam_cap_id(int ham_cap_id) {
		this.ham_cap_id = ham_cap_id;
	}

	public int getMang_xong_id() {
		return mang_xong_id;
	}

	public void setMang_xong_id(int mang_xong_id) {
		this.mang_xong_id = mang_xong_id;
	}

}
