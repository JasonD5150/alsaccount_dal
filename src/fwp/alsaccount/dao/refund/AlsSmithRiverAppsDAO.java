package fwp.alsaccount.dao.refund;
// Generated Dec 20, 2016 4:13:42 PM by Hibernate Tools 5.2.0.Alpha3


import fwp.alsaccount.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hibernate.criterion.Example.create;

/**
 * DAO object for domain model class AlsSmithRiverApps.
 *
 * @author Hibernate Tools
 * @see AlsSmithRiverApps
 */
public class AlsSmithRiverAppsDAO extends BaseHibernateDAO {

	private static final Logger log = LoggerFactory.getLogger(AlsSmithRiverAppsDAO.class);

	public void save(AlsSmithRiverApps transientInstance) {
		log.debug("saving AlsSmithRiverApps instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void attachDirty(AlsSmithRiverApps instance) {
		log.debug("attaching dirty AlsSmithRiverApps instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlsSmithRiverApps instance) {
		log.debug("attaching clean AlsSmithRiverApps instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AlsSmithRiverApps persistentInstance) {
		log.debug("deleting AlsSmithRiverApps instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlsSmithRiverApps merge(AlsSmithRiverApps detachedInstance) {
		log.debug("merging AlsSmithRiverApps instance");
		try {
			AlsSmithRiverApps result = (AlsSmithRiverApps) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AlsSmithRiverApps findById(fwp.alsaccount.dao.refund.AlsSmithRiverAppsIdPk id) {
		log.debug("getting AlsSmithRiverApps instance with id: " + id);
		try {
			AlsSmithRiverApps instance = (AlsSmithRiverApps) getSession()
					.get("fwp.alsaccount.dao.refund.AlsSmithRiverApps", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlsSmithRiverApps> findAll() {
		log.debug("finding all AlsSmithRiverApps instances");
		try {
			String queryString = "from AlsSmithRiverApps";
			Query queryObject = getSession().createQuery(queryString);
			return (List<AlsSmithRiverApps>) queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List<AlsSmithRiverApps> findByExample(AlsSmithRiverApps instance) {
		log.debug("finding AlsSmithRiverApps instance by example");
		try {
			List<AlsSmithRiverApps> results = (List<AlsSmithRiverApps>) getSession()
					.createCriteria("fwp.alsaccount.dao.refund.AlsSmithRiverApps")
					.add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

}

