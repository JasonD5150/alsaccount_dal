package fwp.alsaccount.hibernate.dao;


import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for AlsSabhrsFyeAdjst entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.hibernate.dao.AlsSabhrsFyeAdjst
  * @author MyEclipse Persistence Tools 
 */
public class AlsSabhrsFyeAdjstDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsSabhrsFyeAdjstDAO.class);
		//property constants
	public static final String ASFA_FYE_GROUP_IDENTIFIER = "asfaFyeGroupIdentifier";
	public static final String ASFA_NFY_GROUP_IDENTIFIER = "asfaNfyGroupIdentifier";



    
    public void save(AlsSabhrsFyeAdjst transientInstance) {
        log.debug("saving AlsSabhrsFyeAdjst instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsSabhrsFyeAdjst persistentInstance) {
        log.debug("deleting AlsSabhrsFyeAdjst instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsSabhrsFyeAdjst findById( Integer id) {
        log.debug("getting AlsSabhrsFyeAdjst instance with id: " + id);
        try {
            AlsSabhrsFyeAdjst instance = (AlsSabhrsFyeAdjst) getSession()
                    .get("fwp.alsaccount.hibernate.dao.AlsSabhrsFyeAdjst", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsSabhrsFyeAdjst> findByExample(AlsSabhrsFyeAdjst instance) {
        log.debug("finding AlsSabhrsFyeAdjst instance by example");
        try {
            List<AlsSabhrsFyeAdjst> results = (List<AlsSabhrsFyeAdjst>) getSession()
                    .createCriteria("fwp.alsaccount.hibernate.dao.AlsSabhrsFyeAdjst")
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
      log.debug("finding AlsSabhrsFyeAdjst instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsSabhrsFyeAdjst as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsSabhrsFyeAdjst> findByAsfaFyeGroupIdentifier(Object asfaFyeGroupIdentifier
	) {
		return findByProperty(ASFA_FYE_GROUP_IDENTIFIER, asfaFyeGroupIdentifier
		);
	}
	
	public List<AlsSabhrsFyeAdjst> findByAsfaNfyGroupIdentifier(Object asfaNfyGroupIdentifier
	) {
		return findByProperty(ASFA_NFY_GROUP_IDENTIFIER, asfaNfyGroupIdentifier
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsSabhrsFyeAdjst instances");
		try {
			String queryString = "from AlsSabhrsFyeAdjst";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsSabhrsFyeAdjst merge(AlsSabhrsFyeAdjst detachedInstance) {
        log.debug("merging AlsSabhrsFyeAdjst instance");
        try {
            AlsSabhrsFyeAdjst result = (AlsSabhrsFyeAdjst) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsSabhrsFyeAdjst instance) {
        log.debug("attaching dirty AlsSabhrsFyeAdjst instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsSabhrsFyeAdjst instance) {
        log.debug("attaching clean AlsSabhrsFyeAdjst instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}