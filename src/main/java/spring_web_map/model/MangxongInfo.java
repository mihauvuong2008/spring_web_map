package spring_web_map.model;

public class MangxongInfo {

	private int mang_xong_id;
	private String ghi_chu;

	public MangxongInfo(int mang_xong_id, String ghi_chu) {
		super();
		this.mang_xong_id = mang_xong_id;
		this.ghi_chu = ghi_chu;
	}

	public int getMang_xong_id() {
		return mang_xong_id;
	}

	public void setMang_xong_id(int mang_xong_id) {
		this.mang_xong_id = mang_xong_id;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

}
