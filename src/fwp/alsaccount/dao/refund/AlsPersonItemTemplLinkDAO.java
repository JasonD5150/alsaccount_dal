package fwp.alsaccount.dao.refund;
// Generated Dec 15, 2016 1:48:57 PM by Hibernate Tools 5.2.0.Alpha3

import fwp.alsaccount.hibernate.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DAO object for domain model class AlsPersonItemTemplLink.
 * @see AlsPersonItemTemplLink
 * @author Hibernate Tools
 */
public class AlsPersonItemTemplLinkDAO extends BaseHibernateDAO {

    private static final Logger log = LoggerFactory.getLogger(AlsPersonItemTemplLinkDAO.class);

    public void save(AlsPersonItemTemplLink transientInstance) {
        log.debug("saving AlsPersonItemTemplLink instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        }
        catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsPersonItemTemplLink instance) {
        log.debug("attaching dirty AlsPersonItemTemplLink instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(AlsPersonItemTemplLink instance) {
        log.debug("attaching clean AlsPersonItemTemplLink instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(AlsPersonItemTemplLink persistentInstance) {
        log.debug("deleting AlsPersonItemTemplLink instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public AlsPersonItemTemplLink merge(AlsPersonItemTemplLink detachedInstance) {
        log.debug("merging AlsPersonItemTemplLink instance");
        try {
            AlsPersonItemTemplLink result = (AlsPersonItemTemplLink) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public AlsPersonItemTemplLink findById( fwp.alsaccount.dao.refund.AlsPersonItemTemplLinkIdPk id) {
        log.debug("getting AlsPersonItemTemplLink instance with id: " + id);
        try {
            AlsPersonItemTemplLink instance = (AlsPersonItemTemplLink) getSession()
                    .get("fwp.alsaccount.dao.refund.AlsPersonItemTemplLink", id);
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

	public List<AlsPersonItemTemplLink> findAll() {
		log.debug("finding all AlsPersonItemTemplLink instances");
		try {
			String queryString = "from AlsPersonItemTemplLink";
            Query queryObject = getSession().createQuery(queryString);
			return (List<AlsPersonItemTemplLink>)queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

    public List<AlsPersonItemTemplLink> findByExample(AlsPersonItemTemplLink instance) {
        log.debug("finding AlsPersonItemTemplLink instance by example");
        try {
            List<AlsPersonItemTemplLink> results = (List<AlsPersonItemTemplLink>) getSession()
                    .createCriteria("fwp.alsaccount.dao.refund.AlsPersonItemTemplLink")
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

