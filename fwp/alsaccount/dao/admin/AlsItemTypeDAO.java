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
 * AlsItemType entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see fwp.alsaccount.dao.admin.AlsItemType
 * @author MyEclipse Persistence Tools
 */
public class AlsItemTypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlsItemTypeDAO.class);
	// property constants
	public static final String AIT_TYPE_DESC = "aitTypeDesc";
	public static final String AIT_WHO_LOG = "aitWhoLog";

	public void save(AlsItemType transientInstance) {
		log.debug("saving AlsItemType instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlsItemType persistentInstance) {
		log.debug("deleting AlsItemType instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlsItemType findById(fwp.alsaccount.dao.admin.AlsItemTypeIdPk id) {
		log.debug("getting AlsItemType instance with id: " + id);
		try {
			AlsItemType instance = (AlsItemType) getSession().get(
					"fwp.alsaccount.dao.admin.AlsItemType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlsItemType> findByExample(AlsItemType instance) {
		log.debug("finding AlsItemType instance by example");
		try {
			List<AlsItemType> results = (List<AlsItemType>) getSession()
					.createCriteria("fwp.alsaccount.dao.admin.AlsItemType")
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
		log.debug("finding AlsItemType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AlsItemType as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlsItemType> findByAitTypeDesc(Object aitTypeDesc) {
		return findByProperty(AIT_TYPE_DESC, aitTypeDesc);
	}

	public List<AlsItemType> findByAitWhoLog(Object aitWhoLog) {
		return findByProperty(AIT_WHO_LOG, aitWhoLog);
	}

	public List findAll() {
		log.debug("finding all AlsItemType instances");
		try {
			String queryString = "from AlsItemType";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlsItemType merge(AlsItemType detachedInstance) {
		log.debug("merging AlsItemType instance");
		try {
			AlsItemType result = (AlsItemType) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlsItemType instance) {
		log.debug("attaching dirty AlsItemType instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlsItemType instance) {
		log.debug("attaching clean AlsItemType instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}