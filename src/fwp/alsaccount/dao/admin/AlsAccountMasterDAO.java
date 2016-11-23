package fwp.alsaccount.dao.admin;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for AlsAccountMaster entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.admin.AlsAccountMaster
  * @author MyEclipse Persistence Tools 
 */
public class AlsAccountMasterDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsAccountMasterDAO.class);
		//property constants
	public static final String AAM_ACCOUNT_DESC = "aamAccountDesc";
	public static final String AAM_WHO_LOG = "aamWhoLog";



    
    public void save(AlsAccountMaster transientInstance) {
        log.debug("saving AlsAccountMaster instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsAccountMaster persistentInstance) {
        log.debug("deleting AlsAccountMaster instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsAccountMaster findById( fwp.alsaccount.dao.admin.AlsAccountMasterIdPk id) {
        log.debug("getting AlsAccountMaster instance with id: " + id);
        try {
            AlsAccountMaster instance = (AlsAccountMaster) getSession()
                    .get("fwp.alsaccount.dao.admin.AlsAccountMaster", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsAccountMaster> findByExample(AlsAccountMaster instance) {
        log.debug("finding AlsAccountMaster instance by example");
        try {
            List<AlsAccountMaster> results = (List<AlsAccountMaster>) getSession()
                    .createCriteria("fwp.alsaccount.dao.admin.AlsAccountMaster")
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
      log.debug("finding AlsAccountMaster instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsAccountMaster as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsAccountMaster> findByAamAccountDesc(Object aamAccountDesc
	) {
		return findByProperty(AAM_ACCOUNT_DESC, aamAccountDesc
		);
	}
	
	public List<AlsAccountMaster> findByAamWhoLog(Object aamWhoLog
	) {
		return findByProperty(AAM_WHO_LOG, aamWhoLog
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsAccountMaster instances");
		try {
			String queryString = "from AlsAccountMaster";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsAccountMaster merge(AlsAccountMaster detachedInstance) {
        log.debug("merging AlsAccountMaster instance");
        try {
            AlsAccountMaster result = (AlsAccountMaster) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsAccountMaster instance) {
        log.debug("attaching dirty AlsAccountMaster instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsAccountMaster instance) {
        log.debug("attaching clean AlsAccountMaster instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}