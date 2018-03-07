package spring_web_map.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring_web_map.entity.Tuyencap;
import spring_web_map.model.TuyencapInfo;

@Transactional
@Repository
public class TuyencapInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public TuyencapInfo findTuyencapInfo(String tuyen_cap_id) {
		String sql = "Select new " + TuyencapInfo.class.getName()
				+ "(t.tuyen_cap_id, t.ten_tuyen_cap, t.chieu_dai_tuyen_cap, t.so_core, t.vi_tri_diem_dau_id, t.vi_tri_diem_cuoi, t.mo_ta_tuyen_cap) "//
				+ " from " + Tuyencap.class.getName() + " t where t.tuyen_cap_id = :tuyen_cap_id";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		query.setParameter("tuyen_cap_id", tuyen_cap_id);
		Object rs = query.uniqueResult();
		return (TuyencapInfo) rs;
	}
}
