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
 	* A data access object (DAO) providing persistence and search support for AlsOrgControl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.admin.AlsOrgControl
  * @author MyEclipse Persistence Tools 
 */
public class AlsOrgControlDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsOrgControlDAO.class);
		//property constants
	public static final String AOC_ORG = "aocOrg";
	public static final String AOC_WHO_LOG = "aocWhoLog";



    
    public void save(AlsOrgControl transientInstance) {
        log.debug("saving AlsOrgControl instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsOrgControl persistentInstance) {
        log.debug("deleting AlsOrgControl instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsOrgControl findById( fwp.alsaccount.dao.admin.AlsOrgControlIdPk id) {
        log.debug("getting AlsOrgControl instance with id: " + id);
        try {
            AlsOrgControl instance = (AlsOrgControl) getSession()
                    .get("fwp.alsaccount.dao.admin.AlsOrgControl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsOrgControl> findByExample(AlsOrgControl instance) {
        log.debug("finding AlsOrgControl instance by example");
        try {
            List<AlsOrgControl> results = (List<AlsOrgControl>) getSession()
                    .createCriteria("fwp.alsaccount.dao.admin.AlsOrgControl")
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
      log.debug("finding AlsOrgControl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsOrgControl as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsOrgControl> findByAocOrg(Object aocOrg
	) {
		return findByProperty(AOC_ORG, aocOrg
		);
	}
	
	public List<AlsOrgControl> findByAocWhoLog(Object aocWhoLog
	) {
		return findByProperty(AOC_WHO_LOG, aocWhoLog
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsOrgControl instances");
		try {
			String queryString = "from AlsOrgControl";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsOrgControl merge(AlsOrgControl detachedInstance) {
        log.debug("merging AlsOrgControl instance");
        try {
            AlsOrgControl result = (AlsOrgControl) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsOrgControl instance) {
        log.debug("attaching dirty AlsOrgControl instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsOrgControl instance) {
        log.debug("attaching clean AlsOrgControl instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}