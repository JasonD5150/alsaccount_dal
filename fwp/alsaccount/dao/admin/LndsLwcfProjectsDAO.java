package fwp.alsaccount.dao.admin;

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
 * LndsLwcfProjects entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see fwp.alsaccount.dao.admin.LndsLwcfProjects
 * @author MyEclipse Persistence Tools
 */
public class LndsLwcfProjectsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LndsLwcfProjectsDAO.class);
	// property constants
	public static final String LLP_PROJECT_NUMBER = "llpProjectNumber";
	public static final String LLP_PROJECT_TITLE = "llpProjectTitle";
	public static final String LLP_PROJECT_SPONSOR = "llpProjectSponsor";
	public static final String LLP_SPONSOR_TYPE = "llpSponsorType";
	public static final String LLP_PROJECT_TYPE = "llpProjectType";
	public static final String LLP_GRANT_AMOUNT = "llpGrantAmount";
	public static final String LLP_PROJECT_SCOPE = "llpProjectScope";
	public static final String LLP_REMARKS = "llpRemarks";
	public static final String LLP_LLSCV_ID = "llpLlscvId";
	public static final String LLP_LEGACY_PROJECT_ID = "llpLegacyProjectId";
	public static final String LLP_CREATE_DBUSER = "llpCreateDbuser";
	public static final String LLP_CREATE_PERSONID = "llpCreatePersonid";
	public static final String LLP_MOD_DBUSER = "llpModDbuser";
	public static final String LLP_MOD_PERSONID = "llpModPersonid";

	public void save(LndsLwcfProjects transientInstance) {
		log.debug("saving LndsLwcfProjects instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(LndsLwcfProjects persistentInstance) {
		log.debug("deleting LndsLwcfProjects instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LndsLwcfProjects findById(java.math.BigDecimal id) {
		log.debug("getting LndsLwcfProjects instance with id: " + id);
		try {
			LndsLwcfProjects instance = (LndsLwcfProjects) getSession().get(
					"fwp.alsaccount.dao.admin.LndsLwcfProjects", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<LndsLwcfProjects> findByExample(LndsLwcfProjects instance) {
		log.debug("finding LndsLwcfProjects instance by example");
		try {
			List<LndsLwcfProjects> results = (List<LndsLwcfProjects>) getSession()
					.createCriteria("fwp.alsaccount.dao.admin.LndsLwcfProjects")
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
		log.debug("finding LndsLwcfProjects instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from LndsLwcfProjects as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<LndsLwcfProjects> findByLlpProjectNumber(Object llpProjectNumber) {
		return findByProperty(LLP_PROJECT_NUMBER, llpProjectNumber);
	}

	public List<LndsLwcfProjects> findByLlpProjectTitle(Object llpProjectTitle) {
		return findByProperty(LLP_PROJECT_TITLE, llpProjectTitle);
	}

	public List<LndsLwcfProjects> findByLlpProjectSponsor(
			Object llpProjectSponsor) {
		return findByProperty(LLP_PROJECT_SPONSOR, llpProjectSponsor);
	}

	public List<LndsLwcfProjects> findByLlpSponsorType(Object llpSponsorType) {
		return findByProperty(LLP_SPONSOR_TYPE, llpSponsorType);
	}

	public List<LndsLwcfProjects> findByLlpProjectType(Object llpProjectType) {
		return findByProperty(LLP_PROJECT_TYPE, llpProjectType);
	}

	public List<LndsLwcfProjects> findByLlpGrantAmount(Object llpGrantAmount) {
		return findByProperty(LLP_GRANT_AMOUNT, llpGrantAmount);
	}

	public List<LndsLwcfProjects> findByLlpProjectScope(Object llpProjectScope) {
		return findByProperty(LLP_PROJECT_SCOPE, llpProjectScope);
	}

	public List<LndsLwcfProjects> findByLlpRemarks(Object llpRemarks) {
		return findByProperty(LLP_REMARKS, llpRemarks);
	}

	public List<LndsLwcfProjects> findByLlpLlscvId(Object llpLlscvId) {
		return findByProperty(LLP_LLSCV_ID, llpLlscvId);
	}

	public List<LndsLwcfProjects> findByLlpLegacyProjectId(
			Object llpLegacyProjectId) {
		return findByProperty(LLP_LEGACY_PROJECT_ID, llpLegacyProjectId);
	}

	public List<LndsLwcfProjects> findByLlpCreateDbuser(Object llpCreateDbuser) {
		return findByProperty(LLP_CREATE_DBUSER, llpCreateDbuser);
	}

	public List<LndsLwcfProjects> findByLlpCreatePersonid(
			Object llpCreatePersonid) {
		return findByProperty(LLP_CREATE_PERSONID, llpCreatePersonid);
	}

	public List<LndsLwcfProjects> findByLlpModDbuser(Object llpModDbuser) {
		return findByProperty(LLP_MOD_DBUSER, llpModDbuser);
	}

	public List<LndsLwcfProjects> findByLlpModPersonid(Object llpModPersonid) {
		return findByProperty(LLP_MOD_PERSONID, llpModPersonid);
	}

	public List findAll() {
		log.debug("finding all LndsLwcfProjects instances");
		try {
			String queryString = "from LndsLwcfProjects";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public LndsLwcfProjects merge(LndsLwcfProjects detachedInstance) {
		log.debug("merging LndsLwcfProjects instance");
		try {
			LndsLwcfProjects result = (LndsLwcfProjects) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(LndsLwcfProjects instance) {
		log.debug("attaching dirty LndsLwcfProjects instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LndsLwcfProjects instance) {
		log.debug("attaching clean LndsLwcfProjects instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}