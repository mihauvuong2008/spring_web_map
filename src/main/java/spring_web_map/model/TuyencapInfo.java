package spring_web_map.model;

public class TuyencapInfo {

	private int tuyen_cap_id;
	private String ten_tuyen_cap;
	private int chieu_dai_tuyen_cap;
	private int so_core;
	private int vi_tri_diem_dau_id;
	private int vi_tri_diem_cuoi_id;
	private String mo_ta_tuyen_cap;

	// Không thay đổi Constructor này, nó được sử dụng trong Hibernate Query
	public TuyencapInfo(int tUYEN_CAP_ID, String tEN_TUYEN_CAP, int cHIEU_DAI_TUYEN_CAP, int sO_CORE,
			int vI_TRI_DIEM_DAU_ID, int vI_TRI_DIEM_CUOI_ID, String mO_TA_TUYEN_CAP) {
		super();
		tuyen_cap_id = tUYEN_CAP_ID;
		ten_tuyen_cap = tEN_TUYEN_CAP;
		chieu_dai_tuyen_cap = cHIEU_DAI_TUYEN_CAP;
		so_core = sO_CORE;
		vi_tri_diem_dau_id = vI_TRI_DIEM_DAU_ID;
		vi_tri_diem_cuoi_id = vI_TRI_DIEM_CUOI_ID;
		mo_ta_tuyen_cap = mO_TA_TUYEN_CAP;
	}

	public TuyencapInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getTuyen_cap_id() {
		return tuyen_cap_id;
	}

	public void setTuyen_cap_id(int tuyen_cap_id) {
		this.tuyen_cap_id = tuyen_cap_id;
	}

	public String getTen_tuyen_cap() {
		return ten_tuyen_cap;
	}

	public void setTen_tuyen_cap(String ten_tuyen_cap) {
		this.ten_tuyen_cap = ten_tuyen_cap;
	}

	public int getChieu_dai_tuyen_cap() {
		return chieu_dai_tuyen_cap;
	}

	public void setChieu_dai_tuyen_cap(int chieu_dai_tuyen_cap) {
		this.chieu_dai_tuyen_cap = chieu_dai_tuyen_cap;
	}

	public int getSo_core() {
		return so_core;
	}

	public void setSo_core(int so_core) {
		this.so_core = so_core;
	}

	public int getVi_tri_diem_dau_id() {
		return vi_tri_diem_dau_id;
	}

	public void setVi_tri_diem_dau_id(int vi_tri_diem_dau_id) {
		this.vi_tri_diem_dau_id = vi_tri_diem_dau_id;
	}

	public int getVi_tri_diem_cuoi_id() {
		return vi_tri_diem_cuoi_id;
	}

	public void setVi_tri_diem_cuoi_id(int vi_tri_diem_cuoi_id) {
		this.vi_tri_diem_cuoi_id = vi_tri_diem_cuoi_id;
	}

	public String getMo_ta_tuyen_cap() {
		return mo_ta_tuyen_cap;
	}

	public void setMo_ta_tuyen_cap(String mo_ta_tuyen_cap) {
		this.mo_ta_tuyen_cap = mo_ta_tuyen_cap;
	}

}
