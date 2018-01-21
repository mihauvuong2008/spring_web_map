package spring_web_map.model;

public class TuyencapInfo {

	private int TUYEN_CAP_ID;
	private String TEN_TUYEN_CAP;
	private int CHIEU_DAI_TUYEN_CAP;
	private int SO_CORE;
	private int VI_TRI_DIEM_DAU_ID;
	private int VI_TRI_DIEM_CUOI_ID;
	private String MO_TA_TUYEN_CAP;

	public TuyencapInfo(int tUYEN_CAP_ID, String tEN_TUYEN_CAP, int cHIEU_DAI_TUYEN_CAP, int sO_CORE,
			int vI_TRI_DIEM_DAU_ID, int vI_TRI_DIEM_CUOI_ID, String mO_TA_TUYEN_CAP) {
		super();
		TUYEN_CAP_ID = tUYEN_CAP_ID;
		TEN_TUYEN_CAP = tEN_TUYEN_CAP;
		CHIEU_DAI_TUYEN_CAP = cHIEU_DAI_TUYEN_CAP;
		SO_CORE = sO_CORE;
		VI_TRI_DIEM_DAU_ID = vI_TRI_DIEM_DAU_ID;
		VI_TRI_DIEM_CUOI_ID = vI_TRI_DIEM_CUOI_ID;
		MO_TA_TUYEN_CAP = mO_TA_TUYEN_CAP;
	}

	public int getTUYEN_CAP_ID() {
		return TUYEN_CAP_ID;
	}

	public void setTUYEN_CAP_ID(int tUYEN_CAP_ID) {
		TUYEN_CAP_ID = tUYEN_CAP_ID;
	}

	public String getTEN_TUYEN_CAP() {
		return TEN_TUYEN_CAP;
	}

	public void setTEN_TUYEN_CAP(String tEN_TUYEN_CAP) {
		TEN_TUYEN_CAP = tEN_TUYEN_CAP;
	}

	public int getCHIEU_DAI_TUYEN_CAP() {
		return CHIEU_DAI_TUYEN_CAP;
	}

	public void setCHIEU_DAI_TUYEN_CAP(int cHIEU_DAI_TUYEN_CAP) {
		CHIEU_DAI_TUYEN_CAP = cHIEU_DAI_TUYEN_CAP;
	}

	public int getSO_CORE() {
		return SO_CORE;
	}

	public void setSO_CORE(int sO_CORE) {
		SO_CORE = sO_CORE;
	}

	public int getVI_TRI_DIEM_DAU_ID() {
		return VI_TRI_DIEM_DAU_ID;
	}

	public void setVI_TRI_DIEM_DAU_ID(int vI_TRI_DIEM_DAU_ID) {
		VI_TRI_DIEM_DAU_ID = vI_TRI_DIEM_DAU_ID;
	}

	public int getVI_TRI_DIEM_CUOI_ID() {
		return VI_TRI_DIEM_CUOI_ID;
	}

	public void setVI_TRI_DIEM_CUOI_ID(int vI_TRI_DIEM_CUOI_ID) {
		VI_TRI_DIEM_CUOI_ID = vI_TRI_DIEM_CUOI_ID;
	}

	public String getMO_TA_TUYEN_CAP() {
		return MO_TA_TUYEN_CAP;
	}

	public void setMO_TA_TUYEN_CAP(String mO_TA_TUYEN_CAP) {
		MO_TA_TUYEN_CAP = mO_TA_TUYEN_CAP;
	}

}
