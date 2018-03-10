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

import spring_web_map.entity.Tuyencap;
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

	public Tuyencap findTuyencap(int tuyencap_id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Tuyencap.class);
		crit.add(Restrictions.eq("tuyen_cap_id", tuyencap_id));
		return (Tuyencap) crit.uniqueResult();
	}

	public void saveTuyencapInfo(TuyencapInfo tuyencapInfo) {
		// TODO Auto-generated method stub

		int TuyencapID = tuyencapInfo.getTuyen_cap_id();
		Tuyencap Tuyencap = null;
		if (TuyencapID != 0) {
			Tuyencap = this.findTuyencap(TuyencapID);
		}
		boolean isNew = false;
		if (Tuyencap == null) {
			isNew = true;
			Tuyencap = new Tuyencap();
			Tuyencap.setTuyen_cap_id(tuyencapInfo.getTuyen_cap_id());
			Tuyencap.setTuyen_cap_id(tuyencapInfo.getTuyen_cap_id());
			Tuyencap.setTen_tuyen_cap(tuyencapInfo.getTen_tuyen_cap());
			Tuyencap.setChieu_dai_tuyen_cap(tuyencapInfo.getChieu_dai_tuyen_cap());
			Tuyencap.setSo_core(tuyencapInfo.getSo_core());
			Tuyencap.setVi_tri_diem_dau_id(tuyencapInfo.getVi_tri_diem_dau_id());
			Tuyencap.setVi_tri_diem_cuoi_id(tuyencapInfo.getVi_tri_diem_cuoi_id());
			Tuyencap.setMo_ta_tuyen_cap(tuyencapInfo.getMo_ta_tuyen_cap());
		}

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			System.out.println(Tuyencap.toString());
			session.persist(Tuyencap);
		}
	}

	public List<TuyencapInfo> getAllTuyencap() {
		String sql = "Select new " + TuyencapInfo.class.getName()
				+ "(t.tuyen_cap_id, t.ten_tuyen_cap, t.chieu_dai_tuyen_cap, t.so_core, t.vi_tri_diem_dau_id, t.vi_tri_diem_cuoi_id, t.mo_ta_tuyen_cap) "//
				+ " from " + Tuyencap.class.getName() + " t";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		// Object rs = query.uniqueResult();
		List<TuyencapInfo> data = query.list();
		for (TuyencapInfo TuyencapInfo : data) {
			System.out.println(TuyencapInfo.toString());
		}
		return data;
	}

	public void deleteTuyencap(int tuyencap_id) {
		Tuyencap tuyencap = this.findTuyencap(tuyencap_id);
		if (tuyencap != null) {
			this.sessionFactory.getCurrentSession().delete(tuyencap);
		}
	}
}
