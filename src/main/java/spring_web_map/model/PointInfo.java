package spring_web_map.model;

public class PointInfo {

	private int point_id;
	private int x_data;
	private int y_data;

	public PointInfo(int point_id, int x_data, int y_data) {
		super();
		this.point_id = point_id;
		this.x_data = x_data;
		this.y_data = y_data;
	}

	public PointInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getPoint_id() {
		return point_id;
	}

	public void setPoint_id(int point_id) {
		this.point_id = point_id;
	}

	public int getX_data() {
		return x_data;
	}

	public void setX_data(int x_data) {
		this.x_data = x_data;
	}

	public int getY_data() {
		return y_data;
	}

	public void setY_data(int y_data) {
		this.y_data = y_data;
	}

	public String toString() {
		return getPoint_id() + ", " + getX_data() + ", " + getY_data();
	}
}
