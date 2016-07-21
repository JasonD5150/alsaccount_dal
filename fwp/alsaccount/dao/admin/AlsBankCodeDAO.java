package fwp.alsaccount.dao.admin;

import fwp.alsaccount.hibernate.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlsBankCode entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see fwp.alsaccount.dao.admin.AlsBankCode
 * @author MyEclipse Persistence Tools
 */
public class AlsBankCodeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlsBankCodeDAO.class);
	// property constants
	public static final String ABC_ACCOUNT_NO = "abcAccountNo";
	public static final String ABC_COMPANY_ID = "abcCompanyId";
	public static final String ABC_BANK_NM = "abcBankNm";
	public static final String AZC_ZIP_CD = "azcZipCd";
	public static final String AZC_CITY_NM = "azcCityNm";
	public static final String ABC_WHO_LOG = "abcWhoLog";
	public static final String ABC_CREATE_PERSONID = "abcCreatePersonid";
	public static final String ABC_ACTIVE = "abcActive";

	public void save(AlsBankCode transientInstance) {
		log.debug("saving AlsBankCode instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlsBankCode persistentInstance) {
		log.debug("deleting AlsBankCode instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlsBankCode findById(String id) {
		log.debug("getting AlsBankCode instance with id: " + id);
		try {
			AlsBankCode instance = (AlsBankCode) getSession().get(
					"fwp.alsaccount.dao.admin.AlsBankCode", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlsBankCode> findByExample(AlsBankCode instance) {
		log.debug("finding AlsBankCode instance by example");
		try {
			List<AlsBankCode> results = (List<AlsBankCode>) getSession()
					.createCriteria("fwp.alsaccount.dao.admin.AlsBankCode")
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
		log.debug("finding AlsBankCode instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AlsBankCode as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlsBankCode> findByAbcAccountNo(Object abcAccountNo) {
		return findByProperty(ABC_ACCOUNT_NO, abcAccountNo);
	}

	public List<AlsBankCode> findByAbcCompanyId(Object abcCompanyId) {
		return findByProperty(ABC_COMPANY_ID, abcCompanyId);
	}

	public List<AlsBankCode> findByAbcBankNm(Object abcBankNm) {
		return findByProperty(ABC_BANK_NM, abcBankNm);
	}

	public List<AlsBankCode> findByAzcZipCd(Object azcZipCd) {
		return findByProperty(AZC_ZIP_CD, azcZipCd);
	}

	public List<AlsBankCode> findByAzcCityNm(Object azcCityNm) {
		return findByProperty(AZC_CITY_NM, azcCityNm);
	}

	public List<AlsBankCode> findByAbcWhoLog(Object abcWhoLog) {
		return findByProperty(ABC_WHO_LOG, abcWhoLog);
	}

	public List<AlsBankCode> findByAbcCreatePersonid(Object abcCreatePersonid) {
		return findByProperty(ABC_CREATE_PERSONID, abcCreatePersonid);
	}

	public List<AlsBankCode> findByAbcActive(Object abcActive) {
		return findByProperty(ABC_ACTIVE, abcActive);
	}

	public List findAll() {
		log.debug("finding all AlsBankCode instances");
		try {
			String queryString = "from AlsBankCode";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlsBankCode merge(AlsBankCode detachedInstance) {
		log.debug("merging AlsBankCode instance");
		try {
			AlsBankCode result = (AlsBankCode) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlsBankCode instance) {
		log.debug("attaching dirty AlsBankCode instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlsBankCode instance) {
		log.debug("attaching clean AlsBankCode instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}