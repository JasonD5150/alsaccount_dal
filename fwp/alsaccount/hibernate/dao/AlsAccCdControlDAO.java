package fwp.alsaccount.hibernate.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for AlsAccCdControl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.hibernate.dao.AlsAccCdControl
  * @author MyEclipse Persistence Tools 
 */
public class AlsAccCdControlDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsAccCdControlDAO.class);
		//property constants
	public static final String AAM_ACCOUNT = "aamAccount";
	public static final String AOC_ORG = "aocOrg";
	public static final String AACC_ORG_FLAG = "aaccOrgFlag";
	public static final String AACC_FUND = "aaccFund";
	public static final String AACC_ALLOCATED_AMT = "aaccAllocatedAmt";
	public static final String AACC_BALANCING_AMT_FLAG = "aaccBalancingAmtFlag";
	public static final String ASAC_SUBCLASS = "asacSubclass";
	public static final String AACC_WHO_LOG = "aaccWhoLog";
	public static final String AACC_REMARKS = "aaccRemarks";
	public static final String AACC_JLR_REQUIRED = "aaccJlrRequired";



    
    public void save(AlsAccCdControl transientInstance) {
        log.debug("saving AlsAccCdControl instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsAccCdControl persistentInstance) {
        log.debug("deleting AlsAccCdControl instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsAccCdControl findById( fwp.alsaccount.hibernate.dao.AlsAccCdControlIdPk id) {
        log.debug("getting AlsAccCdControl instance with id: " + id);
        try {
            AlsAccCdControl instance = (AlsAccCdControl) getSession()
                    .get("fwp.alsaccount.hibernate.dao.AlsAccCdControl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsAccCdControl> findByExample(AlsAccCdControl instance) {
        log.debug("finding AlsAccCdControl instance by example");
        try {
            List<AlsAccCdControl> results = (List<AlsAccCdControl>) getSession()
                    .createCriteria("fwp.alsaccount.hibernate.dao.AlsAccCdControl")
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
      log.debug("finding AlsAccCdControl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsAccCdControl as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsAccCdControl> findByAamAccount(Object aamAccount
	) {
		return findByProperty(AAM_ACCOUNT, aamAccount
		);
	}
	
	public List<AlsAccCdControl> findByAocOrg(Object aocOrg
	) {
		return findByProperty(AOC_ORG, aocOrg
		);
	}
	
	public List<AlsAccCdControl> findByAaccOrgFlag(Object aaccOrgFlag
	) {
		return findByProperty(AACC_ORG_FLAG, aaccOrgFlag
		);
	}
	
	public List<AlsAccCdControl> findByAaccFund(Object aaccFund
	) {
		return findByProperty(AACC_FUND, aaccFund
		);
	}
	
	public List<AlsAccCdControl> findByAaccAllocatedAmt(Object aaccAllocatedAmt
	) {
		return findByProperty(AACC_ALLOCATED_AMT, aaccAllocatedAmt
		);
	}
	
	public List<AlsAccCdControl> findByAaccBalancingAmtFlag(Object aaccBalancingAmtFlag
	) {
		return findByProperty(AACC_BALANCING_AMT_FLAG, aaccBalancingAmtFlag
		);
	}
	
	public List<AlsAccCdControl> findByAsacSubclass(Object asacSubclass
	) {
		return findByProperty(ASAC_SUBCLASS, asacSubclass
		);
	}
	
	public List<AlsAccCdControl> findByAaccWhoLog(Object aaccWhoLog
	) {
		return findByProperty(AACC_WHO_LOG, aaccWhoLog
		);
	}
	
	public List<AlsAccCdControl> findByAaccRemarks(Object aaccRemarks
	) {
		return findByProperty(AACC_REMARKS, aaccRemarks
		);
	}
	
	public List<AlsAccCdControl> findByAaccJlrRequired(Object aaccJlrRequired
	) {
		return findByProperty(AACC_JLR_REQUIRED, aaccJlrRequired
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsAccCdControl instances");
		try {
			String queryString = "from AlsAccCdControl";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsAccCdControl merge(AlsAccCdControl detachedInstance) {
        log.debug("merging AlsAccCdControl instance");
        try {
            AlsAccCdControl result = (AlsAccCdControl) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsAccCdControl instance) {
        log.debug("attaching dirty AlsAccCdControl instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsAccCdControl instance) {
        log.debug("attaching clean AlsAccCdControl instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}