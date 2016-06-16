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
 	* A data access object (DAO) providing persistence and search support for AlsSysActivityTypeTranCds entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.admin.AlsSysActivityTypeTranCds
  * @author MyEclipse Persistence Tools 
 */
public class AlsSysActivityTypeTranCdsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsSysActivityTypeTranCdsDAO.class);
		//property constants
	public static final String ASATTC_DESC = "asattcDesc";
	public static final String ASATTC_WHO_LOG = "asattcWhoLog";
	public static final String ASATTC_WHO_MODI = "asattcWhoModi";



    
    public void save(AlsSysActivityTypeTranCds transientInstance) {
        log.debug("saving AlsSysActivityTypeTranCds instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsSysActivityTypeTranCds persistentInstance) {
        log.debug("deleting AlsSysActivityTypeTranCds instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsSysActivityTypeTranCds findById( fwp.alsaccount.dao.admin.AlsSysActivityTypeTranCdsIdPk id) {
        log.debug("getting AlsSysActivityTypeTranCds instance with id: " + id);
        try {
            AlsSysActivityTypeTranCds instance = (AlsSysActivityTypeTranCds) getSession()
                    .get("fwp.alsaccount.dao.admin.AlsSysActivityTypeTranCds", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsSysActivityTypeTranCds> findByExample(AlsSysActivityTypeTranCds instance) {
        log.debug("finding AlsSysActivityTypeTranCds instance by example");
        try {
            List<AlsSysActivityTypeTranCds> results = (List<AlsSysActivityTypeTranCds>) getSession()
                    .createCriteria("fwp.alsaccount.dao.admin.AlsSysActivityTypeTranCds")
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
      log.debug("finding AlsSysActivityTypeTranCds instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsSysActivityTypeTranCds as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsSysActivityTypeTranCds> findByAsattcDesc(Object asattcDesc
	) {
		return findByProperty(ASATTC_DESC, asattcDesc
		);
	}
	
	public List<AlsSysActivityTypeTranCds> findByAsattcWhoLog(Object asattcWhoLog
	) {
		return findByProperty(ASATTC_WHO_LOG, asattcWhoLog
		);
	}
	
	public List<AlsSysActivityTypeTranCds> findByAsattcWhoModi(Object asattcWhoModi
	) {
		return findByProperty(ASATTC_WHO_MODI, asattcWhoModi
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsSysActivityTypeTranCds instances");
		try {
			String queryString = "from AlsSysActivityTypeTranCds";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsSysActivityTypeTranCds merge(AlsSysActivityTypeTranCds detachedInstance) {
        log.debug("merging AlsSysActivityTypeTranCds instance");
        try {
            AlsSysActivityTypeTranCds result = (AlsSysActivityTypeTranCds) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsSysActivityTypeTranCds instance) {
        log.debug("attaching dirty AlsSysActivityTypeTranCds instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsSysActivityTypeTranCds instance) {
        log.debug("attaching clean AlsSysActivityTypeTranCds instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}