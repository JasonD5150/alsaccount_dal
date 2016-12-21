package fwp.alsaccount.dao.refund;
// Generated Dec 20, 2016 4:04:41 PM by Hibernate Tools 5.2.0.Alpha3


import fwp.alsaccount.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hibernate.criterion.Example.create;

/**
 * DAO object for domain model class AlsAppDisposition.
 * @see AlsAppDisposition
 * @author Hibernate Tools
 */
public class AlsAppDispositionDAO extends BaseHibernateDAO {

    private static final Logger log = LoggerFactory.getLogger(AlsAppDispositionDAO.class);

    public void save(AlsAppDisposition transientInstance) {
        log.debug("saving AlsAppDisposition instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        }
        catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsAppDisposition instance) {
        log.debug("attaching dirty AlsAppDisposition instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(AlsAppDisposition instance) {
        log.debug("attaching clean AlsAppDisposition instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(AlsAppDisposition persistentInstance) {
        log.debug("deleting AlsAppDisposition instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public AlsAppDisposition merge(AlsAppDisposition detachedInstance) {
        log.debug("merging AlsAppDisposition instance");
        try {
            AlsAppDisposition result = (AlsAppDisposition) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public AlsAppDisposition findById( fwp.alsaccount.dao.refund.AlsAppDispositionIdPk id) {
        log.debug("getting AlsAppDisposition instance with id: " + id);
        try {
            AlsAppDisposition instance = (AlsAppDisposition) getSession()
                    .get("fwp.alsaccount.dao.refund.AlsAppDisposition", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

	public List<AlsAppDisposition> findAll() {
		log.debug("finding all AlsAppDisposition instances");
		try {
			String queryString = "from AlsAppDisposition";
            Query queryObject = getSession().createQuery(queryString);
			return (List<AlsAppDisposition>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

    public List<AlsAppDisposition> findByExample(AlsAppDisposition instance) {
        log.debug("finding AlsAppDisposition instance by example");
        try {
            List<AlsAppDisposition> results = (List<AlsAppDisposition>) getSession()
                    .createCriteria("fwp.alsaccount.dao.refund.AlsAppDisposition")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

}

