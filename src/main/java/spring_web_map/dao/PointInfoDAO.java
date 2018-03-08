package spring_web_map.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring_web_map.entity.Point;
import spring_web_map.entity.User;
import spring_web_map.model.PointInfo;
import spring_web_map.model.UserInfo;

@Transactional
@Repository
public class PointInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void savePointInfo(PointInfo pointInfo) {
		// TODO Auto-generated method stub

		int pointID = pointInfo.getPoint_id();
		Point Point = null;
		if (pointID != 0) {
			Point = this.findPoint(pointID);
		}
		boolean isNew = false;
		if (Point == null) {
			isNew = true;
			Point = new Point();
			Point.setPoint_id(pointInfo.getPoint_id());
		}
		Point.setX_data(pointInfo.getX_data());
		Point.setY_data(pointInfo.getY_data());
		//

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			System.out.println(Point.toString());
			session.persist(Point);
		}
	}

	public Point findPoint(int pointID) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Point.class);
		crit.add(Restrictions.eq("point_id", pointID));
		return (Point) crit.uniqueResult();
	}

	public List<PointInfo> getAllPoint() {
		String sql = "Select new " + PointInfo.class.getName() + "(p.point_id, p.x_data, p.y_data) "//
				+ " from " + Point.class.getName() + " p";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		// Object rs = query.uniqueResult();
		List<PointInfo> data = query.list();
		for (PointInfo pointInfo : data) {
			System.out.println(pointInfo.toString());
		}
		return data;
	}

	public void deletePoint(int point_id) {
		Point point = this.findPoint(point_id);
		if (point != null) {
			this.sessionFactory.getCurrentSession().delete(point);
		}

	}

}
