package fwp.alsaccount.dao.admin;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlsTribeItemInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see fwp.alsaccount.dao.admin.AlsTribeItemInfo
 * @author MyEclipse Persistence Tools
 */
public class AlsTribeItemInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlsTribeItemInfoDAO.class);
	// property constants
	public static final String ATI_TRIBE_CD = "atiTribeCd";
	public static final String ATII_WHO_LOG = "atiiWhoLog";

	public void save(AlsTribeItemInfo transientInstance) {
		log.debug("saving AlsTribeItemInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlsTribeItemInfo persistentInstance) {
		log.debug("deleting AlsTribeItemInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlsTribeItemInfo findById(
			fwp.alsaccount.dao.admin.AlsTribeItemInfoIdPk id) {
		log.debug("getting AlsTribeItemInfo instance with id: " + id);
		try {
			AlsTribeItemInfo instance = (AlsTribeItemInfo) getSession().get(
					"fwp.alsaccount.dao.admin.AlsTribeItemInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlsTribeItemInfo> findByExample(AlsTribeItemInfo instance) {
		log.debug("finding AlsTribeItemInfo instance by example");
		try {
			List<AlsTribeItemInfo> results = (List<AlsTribeItemInfo>) getSession()
					.createCriteria("fwp.alsaccount.dao.admin.AlsTribeItemInfo")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AlsTribeItemInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AlsTribeItemInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlsTribeItemInfo> findByAtiTribeCd(Object atiTribeCd) {
		return findByProperty(ATI_TRIBE_CD, atiTribeCd);
	}

	public List<AlsTribeItemInfo> findByAtiiWhoLog(Object atiiWhoLog) {
		return findByProperty(ATII_WHO_LOG, atiiWhoLog);
	}

	public List findAll() {
		log.debug("finding all AlsTribeItemInfo instances");
		try {
			String queryString = "from AlsTribeItemInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlsTribeItemInfo merge(AlsTribeItemInfo detachedInstance) {
		log.debug("merging AlsTribeItemInfo instance");
		try {
			AlsTribeItemInfo result = (AlsTribeItemInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlsTribeItemInfo instance) {
		log.debug("attaching dirty AlsTribeItemInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlsTribeItemInfo instance) {
		log.debug("attaching clean AlsTribeItemInfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}