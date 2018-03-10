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

import spring_web_map.entity.Hamcap;
import spring_web_map.model.HamcapInfo;

@Transactional
@Repository
public class HamcapInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Hamcap findHamcap(int hamcap_id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Hamcap.class);
		crit.add(Restrictions.eq("ham_cap_id", hamcap_id));
		return (Hamcap) crit.uniqueResult();
	}

	public void saveHamcapInfo(HamcapInfo hamcapInfo) {
		int hamcap_id = hamcapInfo.getHam_cap_id();
		Hamcap Hamcap = null;
		if (hamcap_id >= 0) {
			Hamcap = this.findHamcap(hamcap_id);
		}
		boolean isNew = false;
		if (Hamcap == null) {
			isNew = true;
			Hamcap = new Hamcap();
			Hamcap.setHam_cap_id(hamcapInfo.getHam_cap_id());
		}
		Hamcap.setTen_ham_cap(hamcapInfo.getTen_ham_cap());
		Hamcap.setTreo_ngam(hamcapInfo.getTreo_ngam());
		Hamcap.setVi_tri_id(hamcapInfo.getVi_tri_id());
		//

		if (isNew) {
			Session session = this.sessionFactory.getCurrentSession();
			System.out.println(Hamcap.toString());
			session.persist(Hamcap);
		}
	}

	public List<HamcapInfo> getAllHamcap() {
		String sql = "Select new " + HamcapInfo.class.getName()
				+ "(h.ham_cap_id, h.ten_ham_cap, h.treo_ngam, h.vi_tri_id) "//
				+ " from " + Hamcap.class.getName() + " h";

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);
		// Object rs = query.uniqueResult();
		List<HamcapInfo> data = query.list();
		for (HamcapInfo HamcapInfo : data) {
			System.out.println(HamcapInfo.toString());
		}
		return data;
	}

	public void deleteHamcap(int hamcap_id) {
		Hamcap Hamcap = this.findHamcap(hamcap_id);
		if (Hamcap != null) {
			this.sessionFactory.getCurrentSession().delete(Hamcap);
		}

	}

}
