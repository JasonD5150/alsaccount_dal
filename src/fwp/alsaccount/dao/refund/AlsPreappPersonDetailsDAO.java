package fwp.alsaccount.dao.refund;
// Generated Dec 20, 2016 4:37:22 PM by Hibernate Tools 5.2.0.Alpha3


import fwp.alsaccount.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hibernate.criterion.Example.create;

/**
 * DAO object for domain model class AlsPreappPersonDetails.
 * @see AlsPreappPersonDetails
 * @author Hibernate Tools
 */
public class AlsPreappPersonDetailsDAO extends BaseHibernateDAO {

    private static final Logger log = LoggerFactory.getLogger(AlsPreappPersonDetailsDAO.class);

    public void save(AlsPreappPersonDetails transientInstance) {
        log.debug("saving AlsPreappPersonDetails instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        }
        catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsPreappPersonDetails instance) {
        log.debug("attaching dirty AlsPreappPersonDetails instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(AlsPreappPersonDetails instance) {
        log.debug("attaching clean AlsPreappPersonDetails instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(AlsPreappPersonDetails persistentInstance) {
        log.debug("deleting AlsPreappPersonDetails instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public AlsPreappPersonDetails merge(AlsPreappPersonDetails detachedInstance) {
        log.debug("merging AlsPreappPersonDetails instance");
        try {
            AlsPreappPersonDetails result = (AlsPreappPersonDetails) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public AlsPreappPersonDetails findById( fwp.alsaccount.dao.refund.AlsPreappPersonDetailsIdPk id) {
        log.debug("getting AlsPreappPersonDetails instance with id: " + id);
        try {
            AlsPreappPersonDetails instance = (AlsPreappPersonDetails) getSession()
                    .get("fwp.alsaccount.dao.refund.AlsPreappPersonDetails", id);
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

	public List<AlsPreappPersonDetails> findAll() {
		log.debug("finding all AlsPreappPersonDetails instances");
		try {
			String queryString = "from AlsPreappPersonDetails";
            Query queryObject = getSession().createQuery(queryString);
			return (List<AlsPreappPersonDetails>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

    public List<AlsPreappPersonDetails> findByExample(AlsPreappPersonDetails instance) {
        log.debug("finding AlsPreappPersonDetails instance by example");
        try {
            List<AlsPreappPersonDetails> results = (List<AlsPreappPersonDetails>) getSession()
                    .createCriteria("fwp.alsaccount.dao.refund.AlsPreappPersonDetails")
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

