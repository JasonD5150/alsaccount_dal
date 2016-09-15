package fwp.alsaccount.dao.sabhrs;

import fwp.alsaccount.hibernate.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for sabhrsAlsProviderRemittance entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.sabhrs.AlsProviderRemittance
  * @author MyEclipse Persistence Tools 
 */
public class AlsProviderRemittanceDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsProviderRemittanceDAO.class);
		//property constants
	public static final String APR_AMT_RECEIVED = "aprAmtReceived";
	public static final String APR_OLD_AMT_RECEIVED = "aprOldAmtReceived";
	public static final String APR_AMT_DUE = "aprAmtDue";
	public static final String APR_REMITT_PER_STATUS = "aprRemittPerStatus";
	public static final String APR_WHO_LOG = "aprWhoLog";



    
    public void save(AlsProviderRemittance transientInstance) {
        log.debug("saving AlsProviderRemittance instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsProviderRemittance persistentInstance) {
        log.debug("deleting AlsProviderRemittance instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsProviderRemittance findById( fwp.alsaccount.dao.sabhrs.AlsProviderRemittanceIdPk id) {
        log.debug("getting AlsProviderRemittance instance with id: " + id);
        try {
            AlsProviderRemittance instance = (AlsProviderRemittance) getSession()
                    .get("fwp.alsaccount.dao.sabhrs.AlsProviderRemittance", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsProviderRemittance> findByExample(AlsProviderRemittance instance) {
        log.debug("finding sabhrsAlsProviderRemittance instance by example");
        try {
            List<AlsProviderRemittance> results = (List<AlsProviderRemittance>) getSession()
                    .createCriteria("fwp.alsaccount.dao.sabhrs.AlsProviderRemittance")
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
      log.debug("finding AlsProviderRemittance instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsProviderRemittance as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsProviderRemittance> findByAprAmtReceived(Object aprAmtReceived
	) {
		return findByProperty(APR_AMT_RECEIVED, aprAmtReceived
		);
	}
	
	public List<AlsProviderRemittance> findByAprOldAmtReceived(Object aprOldAmtReceived
	) {
		return findByProperty(APR_OLD_AMT_RECEIVED, aprOldAmtReceived
		);
	}
	
	public List<AlsProviderRemittance> findByAprAmtDue(Object aprAmtDue
	) {
		return findByProperty(APR_AMT_DUE, aprAmtDue
		);
	}
	
	public List<AlsProviderRemittance> findByAprRemittPerStatus(Object aprRemittPerStatus
	) {
		return findByProperty(APR_REMITT_PER_STATUS, aprRemittPerStatus
		);
	}
	
	public List<AlsProviderRemittance> findByAprWhoLog(Object aprWhoLog
	) {
		return findByProperty(APR_WHO_LOG, aprWhoLog
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsProviderRemittance instances");
		try {
			String queryString = "from AlsProviderRemittance";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsProviderRemittance merge(AlsProviderRemittance detachedInstance) {
        log.debug("merging AlsProviderRemittance instance");
        try {
            AlsProviderRemittance result = (AlsProviderRemittance) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsProviderRemittance instance) {
        log.debug("attaching dirty AlsProviderRemittance instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsProviderRemittance instance) {
        log.debug("attaching clean AlsProviderRemittance instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}