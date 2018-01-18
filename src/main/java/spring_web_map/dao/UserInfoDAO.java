package spring_web_map.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		String sql = "Select new " + UserInfo.class.getName() + "(u.username,u.password,u.hoten,u.ngaysinh,u.lienhe,u.gioithieu,u.last_modify) "//
				+ " from " + User.class.getName() + " u where u.username = :username";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		query.setParameter("username", userName);
		Object rs = query.uniqueResult();
		UserInfo rss = (UserInfo) rs;
		System.out.println(rss.toString());
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

}