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
 	* A data access object (DAO) providing persistence and search support for AlsActivityAccountLinkage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.hibernate.dao.AlsActivityAccountLinkage
  * @author MyEclipse Persistence Tools 
 */
public class AlsActivityAccountLinkageDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsActivityAccountLinkageDAO.class);
		//property constants
	public static final String AAM_ACCOUNT = "aamAccount";
	public static final String AAAL_ACCOUNTING_CD_FLAG = "aaalAccountingCdFlag";
	public static final String AAAL_REFERENCE = "aaalReference";
	public static final String AAM_FUND = "aamFund";
	public static final String AOC_ORG = "aocOrg";
	public static final String ASAC_SUBCLASS = "asacSubclass";
	public static final String AAAL_WHO_LOG = "aaalWhoLog";



    
    public void save(AlsActivityAccountLinkage transientInstance) {
        log.debug("saving AlsActivityAccountLinkage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsActivityAccountLinkage persistentInstance) {
        log.debug("deleting AlsActivityAccountLinkage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsActivityAccountLinkage findById( fwp.alsaccount.hibernate.dao.AlsActivityAccountLinkageIdPk id) {
        log.debug("getting AlsActivityAccountLinkage instance with id: " + id);
        try {
            AlsActivityAccountLinkage instance = (AlsActivityAccountLinkage) getSession()
                    .get("fwp.alsaccount.hibernate.dao.AlsActivityAccountLinkage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsActivityAccountLinkage> findByExample(AlsActivityAccountLinkage instance) {
        log.debug("finding AlsActivityAccountLinkage instance by example");
        try {
            List<AlsActivityAccountLinkage> results = (List<AlsActivityAccountLinkage>) getSession()
                    .createCriteria("fwp.alsaccount.hibernate.dao.AlsActivityAccountLinkage")
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
      log.debug("finding AlsActivityAccountLinkage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsActivityAccountLinkage as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsActivityAccountLinkage> findByAamAccount(Object aamAccount
	) {
		return findByProperty(AAM_ACCOUNT, aamAccount
		);
	}
	
	public List<AlsActivityAccountLinkage> findByAaalAccountingCdFlag(Object aaalAccountingCdFlag
	) {
		return findByProperty(AAAL_ACCOUNTING_CD_FLAG, aaalAccountingCdFlag
		);
	}
	
	public List<AlsActivityAccountLinkage> findByAaalReference(Object aaalReference
	) {
		return findByProperty(AAAL_REFERENCE, aaalReference
		);
	}
	
	public List<AlsActivityAccountLinkage> findByAamFund(Object aamFund
	) {
		return findByProperty(AAM_FUND, aamFund
		);
	}
	
	public List<AlsActivityAccountLinkage> findByAocOrg(Object aocOrg
	) {
		return findByProperty(AOC_ORG, aocOrg
		);
	}
	
	public List<AlsActivityAccountLinkage> findByAsacSubclass(Object asacSubclass
	) {
		return findByProperty(ASAC_SUBCLASS, asacSubclass
		);
	}
	
	public List<AlsActivityAccountLinkage> findByAaalWhoLog(Object aaalWhoLog
	) {
		return findByProperty(AAAL_WHO_LOG, aaalWhoLog
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsActivityAccountLinkage instances");
		try {
			String queryString = "from AlsActivityAccountLinkage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsActivityAccountLinkage merge(AlsActivityAccountLinkage detachedInstance) {
        log.debug("merging AlsActivityAccountLinkage instance");
        try {
            AlsActivityAccountLinkage result = (AlsActivityAccountLinkage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsActivityAccountLinkage instance) {
        log.debug("attaching dirty AlsActivityAccountLinkage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsActivityAccountLinkage instance) {
        log.debug("attaching clean AlsActivityAccountLinkage instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}