package fwp.alsaccount.hibernate.dao;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for AlsSysActivityTypeCodes entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.hibernate.dao.AlsSysActivityTypeCodes
  * @author MyEclipse Persistence Tools 
 */
public class AlsSysActivityTypeCodesDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsSysActivityTypeCodesDAO.class);
		//property constants
	public static final String ASATC_DESC = "asatcDesc";
	public static final String ASATC_WHO_LOG = "asatcWhoLog";
	public static final String ASATC_WHO_MODI = "asatcWhoModi";



    
    public void save(AlsSysActivityTypeCodes transientInstance) {
        log.debug("saving AlsSysActivityTypeCodes instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsSysActivityTypeCodes persistentInstance) {
        log.debug("deleting AlsSysActivityTypeCodes instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsSysActivityTypeCodes findById( String id) {
        log.debug("getting AlsSysActivityTypeCodes instance with id: " + id);
        try {
            AlsSysActivityTypeCodes instance = (AlsSysActivityTypeCodes) getSession()
                    .get("fwp.alsaccount.hibernate.dao.AlsSysActivityTypeCodes", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsSysActivityTypeCodes> findByExample(AlsSysActivityTypeCodes instance) {
        log.debug("finding AlsSysActivityTypeCodes instance by example");
        try {
            List<AlsSysActivityTypeCodes> results = (List<AlsSysActivityTypeCodes>) getSession()
                    .createCriteria("fwp.alsaccount.hibernate.dao.AlsSysActivityTypeCodes")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding AlsSysActivityTypeCodes instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsSysActivityTypeCodes as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsSysActivityTypeCodes> findByAsatcDesc(Object asatcDesc
	) {
		return findByProperty(ASATC_DESC, asatcDesc
		);
	}
	
	public List<AlsSysActivityTypeCodes> findByAsatcWhoLog(Object asatcWhoLog
	) {
		return findByProperty(ASATC_WHO_LOG, asatcWhoLog
		);
	}
	
	public List<AlsSysActivityTypeCodes> findByAsatcWhoModi(Object asatcWhoModi
	) {
		return findByProperty(ASATC_WHO_MODI, asatcWhoModi
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsSysActivityTypeCodes instances");
		try {
			String queryString = "from AlsSysActivityTypeCodes";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsSysActivityTypeCodes merge(AlsSysActivityTypeCodes detachedInstance) {
        log.debug("merging AlsSysActivityTypeCodes instance");
        try {
            AlsSysActivityTypeCodes result = (AlsSysActivityTypeCodes) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsSysActivityTypeCodes instance) {
        log.debug("attaching dirty AlsSysActivityTypeCodes instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsSysActivityTypeCodes instance) {
        log.debug("attaching clean AlsSysActivityTypeCodes instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}