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

import spring_web_map.entity.User;
import spring_web_map.entity.UserRole;
import spring_web_map.model.UserInfo;

@Transactional
@Repository
public class UserInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserInfo findUserInfo(String userName) {
		String sql = "Select new " + UserInfo.class.getName()
				+ "(u.username,u.password,u.hoten,u.ngaysinh,u.lienhe,u.gioithieu,u.last_modify) "//
				+ " from " + User.class.getName() + " u where u.username = :username";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		query.setParameter("username", userName);
		Object rs = query.uniqueResult();
		return (UserInfo) rs;
	}

	@SuppressWarnings("unchecked")
	public List<String> getUserRoles(String userName) {
		String sql = "Select r.userRole "//
				+ " from " + UserRole.class.getName() + " r where r.user.username = :username ";
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		query.setParameter("username", userName);
		List<String> roles = query.list();

		return roles;
	}

	public List<UserInfo> getAllUser() {
		String sql = "Select new " + UserInfo.class.getName()
				+ "(u.username,u.password,u.hoten,u.ngaysinh,u.lienhe,u.gioithieu,u.last_modify) "//
				+ " from " + User.class.getName() + " u";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		// Object rs = query.uniqueResult();
		List<UserInfo> data = query.list();
		return data;
	}

	public void saveUserInfo(UserInfo userInfo) {
		String userName = userInfo.getUserName();
		User User = null;
		if (userName != null) {
			User = this.findUser(userName);
		}
		boolean isNew = false;
		if (User == null) {
			isNew = true;
			User = new User();
			User.setUsername(userInfo.getUserName());
		}
		User.setHoten(userInfo.getUserName());
		User.setPassword(userInfo.getPassword());
		User.setNgaysinh(userInfo.getNgaysinh());
		User.setLienhe(userInfo.getLienhe());
		User.setLast_modify(userInfo.getLast_modify());
		User.setGioithieu(userInfo.getGioithieu());
		//

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			System.out.println(User.toString());
			session.persist(User);
		}
	}

	private User findUser(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("username", userName));
		return (User) crit.uniqueResult();
	}
}
