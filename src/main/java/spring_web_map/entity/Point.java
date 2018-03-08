package spring_web_map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Point")
public class Point {

	private int point_id;
	private int x_data;
	private int y_data;

	@Id
	@Column(name = "Point_id", nullable = false)
	public int getPoint_id() {
		return point_id;
	}

	public void setPoint_id(int point_id) {
		this.point_id = point_id;
	}

	@Column(name = "X_data", nullable = false)
	public int getX_data() {
		return x_data;
	}

	public void setX_data(int x_data) {
		this.x_data = x_data;
	}

	@Column(name = "Y_data", nullable = false)
	public int getY_data() {
		return y_data;
	}

	public void setY_data(int y_data) {
		this.y_data = y_data;
	}

}
