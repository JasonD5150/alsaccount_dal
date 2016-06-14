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
 	* A data access object (DAO) providing persistence and search support for AlsNonAlsOrgControl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.hibernate.dao.AlsNonAlsOrgControl
  * @author MyEclipse Persistence Tools 
 */
public class AlsNonAlsOrgControlDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsNonAlsOrgControlDAO.class);
		//property constants
	public static final String ANAT_CD = "anatCd";
	public static final String ANAOC_CR_DR_CD = "anaocCrDrCd";
	public static final String ANAOC_ORG = "anaocOrg";
	public static final String API_PROVIDER_NO = "apiProviderNo";
	public static final String ANAOC_WHO_LOG = "anaocWhoLog";
	public static final String ANAT_BUDGET_YEAR = "anatBudgetYear";



    
    public void save(AlsNonAlsOrgControl transientInstance) {
        log.debug("saving AlsNonAlsOrgControl instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsNonAlsOrgControl persistentInstance) {
        log.debug("deleting AlsNonAlsOrgControl instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsNonAlsOrgControl findById( Integer id) {
        log.debug("getting AlsNonAlsOrgControl instance with id: " + id);
        try {
            AlsNonAlsOrgControl instance = (AlsNonAlsOrgControl) getSession()
                    .get("fwp.als.hibernate.account.dao.AlsNonAlsOrgControl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsNonAlsOrgControl> findByExample(AlsNonAlsOrgControl instance) {
        log.debug("finding AlsNonAlsOrgControl instance by example");
        try {
            List<AlsNonAlsOrgControl> results = (List<AlsNonAlsOrgControl>) getSession()
                    .createCriteria("fwp.als.hibernate.account.dao.AlsNonAlsOrgControl")
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
      log.debug("finding AlsNonAlsOrgControl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsNonAlsOrgControl as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsNonAlsOrgControl> findByAnatCd(Object anatCd
	) {
		return findByProperty(ANAT_CD, anatCd
		);
	}
	
	public List<AlsNonAlsOrgControl> findByAnaocCrDrCd(Object anaocCrDrCd
	) {
		return findByProperty(ANAOC_CR_DR_CD, anaocCrDrCd
		);
	}
	
	public List<AlsNonAlsOrgControl> findByAnaocOrg(Object anaocOrg
	) {
		return findByProperty(ANAOC_ORG, anaocOrg
		);
	}
	
	public List<AlsNonAlsOrgControl> findByApiProviderNo(Object apiProviderNo
	) {
		return findByProperty(API_PROVIDER_NO, apiProviderNo
		);
	}
	
	public List<AlsNonAlsOrgControl> findByAnaocWhoLog(Object anaocWhoLog
	) {
		return findByProperty(ANAOC_WHO_LOG, anaocWhoLog
		);
	}
	
	public List<AlsNonAlsOrgControl> findByAnatBudgetYear(Object anatBudgetYear
	) {
		return findByProperty(ANAT_BUDGET_YEAR, anatBudgetYear
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsNonAlsOrgControl instances");
		try {
			String queryString = "from AlsNonAlsOrgControl";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsNonAlsOrgControl merge(AlsNonAlsOrgControl detachedInstance) {
        log.debug("merging AlsNonAlsOrgControl instance");
        try {
            AlsNonAlsOrgControl result = (AlsNonAlsOrgControl) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsNonAlsOrgControl instance) {
        log.debug("attaching dirty AlsNonAlsOrgControl instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsNonAlsOrgControl instance) {
        log.debug("attaching clean AlsNonAlsOrgControl instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}