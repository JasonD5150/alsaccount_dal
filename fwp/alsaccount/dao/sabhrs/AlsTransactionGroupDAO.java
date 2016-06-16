package fwp.alsaccount.dao.sabhrs;
// default package

import fwp.alsaccount.hibernate.BaseHibernateDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlsTransactionGroup entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .AlsTransactionGroup
 * @author MyEclipse Persistence Tools
 */
public class AlsTransactionGroupDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlsTransactionGroupDAO.class);
	// property constants
	public static final String ATG_BUSINESS_PROCESS_TYPE = "atgBusinessProcessType";
	public static final String ATG_TRANSACTION_DESC = "atgTransactionDesc";
	public static final String ATG_IDENTIFIER_STRING = "atgIdentifierString";
	public static final String ATG_INTERFACE_FILE = "atgInterfaceFile";
	public static final String ATG_WHO_LOG = "atgWhoLog";

	public void save(AlsTransactionGroup transientInstance) {
		log.debug("saving AlsTransactionGroup instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlsTransactionGroup persistentInstance) {
		log.debug("deleting AlsTransactionGroup instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlsTransactionGroup findById(java.lang.Integer id) {
		log.debug("getting AlsTransactionGroup instance with id: " + id);
		try {
			AlsTransactionGroup instance = (AlsTransactionGroup) getSession()
					.get("fwp.alsaccount.dao.sabhrs.AlsTransactionGroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlsTransactionGroup> findByExample(AlsTransactionGroup instance) {
		log.debug("finding AlsTransactionGroup instance by example");
		try {
			List<AlsTransactionGroup> results = (List<AlsTransactionGroup>) getSession()
					.createCriteria("fwp.alsaccount.dao.sabhrs.AlsTransactionGroup")
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
		log.debug("finding AlsTransactionGroup instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AlsTransactionGroup as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlsTransactionGroup> findByAtgBusinessProcessType(
			Object atgBusinessProcessType) {
		return findByProperty(ATG_BUSINESS_PROCESS_TYPE, atgBusinessProcessType);
	}

	public List<AlsTransactionGroup> findByAtgTransactionDesc(
			Object atgTransactionDesc) {
		return findByProperty(ATG_TRANSACTION_DESC, atgTransactionDesc);
	}

	public List<AlsTransactionGroup> findByAtgIdentifierString(
			Object atgIdentifierString) {
		return findByProperty(ATG_IDENTIFIER_STRING, atgIdentifierString);
	}

	public List<AlsTransactionGroup> findByAtgInterfaceFile(
			Object atgInterfaceFile) {
		return findByProperty(ATG_INTERFACE_FILE, atgInterfaceFile);
	}

	public List<AlsTransactionGroup> findByAtgWhoLog(Object atgWhoLog) {
		return findByProperty(ATG_WHO_LOG, atgWhoLog);
	}

	public List findAll() {
		log.debug("finding all AlsTransactionGroup instances");
		try {
			String queryString = "from AlsTransactionGroup";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlsTransactionGroup merge(AlsTransactionGroup detachedInstance) {
		log.debug("merging AlsTransactionGroup instance");
		try {
			AlsTransactionGroup result = (AlsTransactionGroup) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlsTransactionGroup instance) {
		log.debug("attaching dirty AlsTransactionGroup instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlsTransactionGroup instance) {
		log.debug("attaching clean AlsTransactionGroup instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}