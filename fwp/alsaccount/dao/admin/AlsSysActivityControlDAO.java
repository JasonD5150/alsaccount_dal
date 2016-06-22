package fwp.alsaccount.dao.admin;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for AlsSysActivityControl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.admin.AlsSysActivityControl
  * @author MyEclipse Persistence Tools 
 */
public class AlsSysActivityControlDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsSysActivityControlDAO.class);
		//property constants
	public static final String ASAC_SYS_ACTIVITY_TYPE_CD_DESC = "asacSysActivityTypeCdDesc";
	public static final String ASAC_PROGRAM = "asacProgram";
	public static final String ASAC_PROJECT_GRANT = "asacProjectGrant";
	public static final String ASAC_WHO_LOG = "asacWhoLog";



    
    public void save(AlsSysActivityControl transientInstance) {
        log.debug("saving AlsSysActivityControl instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsSysActivityControl persistentInstance) {
        log.debug("deleting AlsSysActivityControl instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsSysActivityControl findById( fwp.alsaccount.dao.admin.AlsSysActivityControlIdPk id) {
        log.debug("getting AlsSysActivityControl instance with id: " + id);
        try {
            AlsSysActivityControl instance = (AlsSysActivityControl) getSession()
                    .get("fwp.alsaccount.dao.admin.AlsSysActivityControl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsSysActivityControl> findByExample(AlsSysActivityControl instance) {
        log.debug("finding AlsSysActivityControl instance by example");
        try {
            List<AlsSysActivityControl> results = (List<AlsSysActivityControl>) getSession()
                    .createCriteria("fwp.alsaccount.dao.admin.AlsSysActivityControl")
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
      log.debug("finding AlsSysActivityControl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsSysActivityControl as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsSysActivityControl> findByAsacSysActivityTypeCdDesc(Object asacSysActivityTypeCdDesc
	) {
		return findByProperty(ASAC_SYS_ACTIVITY_TYPE_CD_DESC, asacSysActivityTypeCdDesc
		);
	}
	
	public List<AlsSysActivityControl> findByAsacProgram(Object asacProgram
	) {
		return findByProperty(ASAC_PROGRAM, asacProgram
		);
	}
	
	public List<AlsSysActivityControl> findByAsacProjectGrant(Object asacProjectGrant
	) {
		return findByProperty(ASAC_PROJECT_GRANT, asacProjectGrant
		);
	}
	
	public List<AlsSysActivityControl> findByAsacWhoLog(Object asacWhoLog
	) {
		return findByProperty(ASAC_WHO_LOG, asacWhoLog
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsSysActivityControl instances");
		try {
			String queryString = "from AlsSysActivityControl";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsSysActivityControl merge(AlsSysActivityControl detachedInstance) {
        log.debug("merging AlsSysActivityControl instance");
        try {
            AlsSysActivityControl result = (AlsSysActivityControl) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsSysActivityControl instance) {
        log.debug("attaching dirty AlsSysActivityControl instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsSysActivityControl instance) {
        log.debug("attaching clean AlsSysActivityControl instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}