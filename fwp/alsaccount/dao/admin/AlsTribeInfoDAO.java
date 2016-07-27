package fwp.alsaccount.dao.admin;

import fwp.alsaccount.hibernate.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlsTribeInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see fwp.alsaccount.dao.admin.AlsTribeInfo
 * @author MyEclipse Persistence Tools
 */
public class AlsTribeInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlsTribeInfoDAO.class);
	// property constants
	public static final String ATI_TRIBE_NM = "atiTribeNm";
	public static final String ABC_BANK_CD = "abcBankCd";
	public static final String ATI_DIRECTOR_NM = "atiDirectorNm";
	public static final String ATI_WHO_LOG = "atiWhoLog";
	public static final String ATI_TRIBE_ACCT_BANK_NM = "atiTribeAcctBankNm";
	public static final String ATI_TRIBE_ACCT_ROUTING_NO = "atiTribeAcctRoutingNo";
	public static final String ATI_TRIBE_ACCT_NO = "atiTribeAcctNo";

	public void save(AlsTribeInfo transientInstance) {
		log.debug("saving AlsTribeInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlsTribeInfo persistentInstance) {
		log.debug("deleting AlsTribeInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlsTribeInfo findById(String id) {
		log.debug("getting AlsTribeInfo instance with id: " + id);
		try {
			AlsTribeInfo instance = (AlsTribeInfo) getSession().get(
					"fwp.alsaccount.dao.admin.AlsTribeInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AlsTribeInfo instance) {
		log.debug("finding AlsTribeInfo instance by example");
		try {
			List results = getSession()
					.createCriteria("fwp.alsaccount.dao.admin.AlsTribeInfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AlsTribeInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AlsTribeInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAtiTribeNm(Object atiTribeNm) {
		return findByProperty(ATI_TRIBE_NM, atiTribeNm);
	}

	public List findByAbcBankCd(Object abcBankCd) {
		return findByProperty(ABC_BANK_CD, abcBankCd);
	}

	public List findByAtiDirectorNm(Object atiDirectorNm) {
		return findByProperty(ATI_DIRECTOR_NM, atiDirectorNm);
	}

	public List findByAtiWhoLog(Object atiWhoLog) {
		return findByProperty(ATI_WHO_LOG, atiWhoLog);
	}

	public List findByAtiTribeAcctBankNm(Object atiTribeAcctBankNm) {
		return findByProperty(ATI_TRIBE_ACCT_BANK_NM, atiTribeAcctBankNm);
	}

	public List findByAtiTribeAcctRoutingNo(Object atiTribeAcctRoutingNo) {
		return findByProperty(ATI_TRIBE_ACCT_ROUTING_NO, atiTribeAcctRoutingNo);
	}

	public List findByAtiTribeAcctNo(Object atiTribeAcctNo) {
		return findByProperty(ATI_TRIBE_ACCT_NO, atiTribeAcctNo);
	}

	public List findAll() {
		log.debug("finding all AlsTribeInfo instances");
		try {
			String queryString = "from AlsTribeInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlsTribeInfo merge(AlsTribeInfo detachedInstance) {
		log.debug("merging AlsTribeInfo instance");
		try {
			AlsTribeInfo result = (AlsTribeInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlsTribeInfo instance) {
		log.debug("attaching dirty AlsTribeInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlsTribeInfo instance) {
		log.debug("attaching clean AlsTribeInfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}