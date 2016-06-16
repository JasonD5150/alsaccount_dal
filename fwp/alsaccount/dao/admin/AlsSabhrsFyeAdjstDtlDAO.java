package fwp.alsaccount.dao.admin;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for AlsSabhrsFyeAdjstDtl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.admin.AlsSabhrsFyeAdjstDtl
  * @author MyEclipse Persistence Tools 
 */
public class AlsSabhrsFyeAdjstDtlDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsSabhrsFyeAdjstDtlDAO.class);
		//property constants



    
    public void save(AlsSabhrsFyeAdjstDtl transientInstance) {
        log.debug("saving AlsSabhrsFyeAdjstDtl instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsSabhrsFyeAdjstDtl persistentInstance) {
        log.debug("deleting AlsSabhrsFyeAdjstDtl instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsSabhrsFyeAdjstDtl findById( fwp.alsaccount.dao.admin.AlsSabhrsFyeAdjstDtlIdPk id) {
        log.debug("getting AlsSabhrsFyeAdjstDtl instance with id: " + id);
        try {
            AlsSabhrsFyeAdjstDtl instance = (AlsSabhrsFyeAdjstDtl) getSession()
                    .get("fwp.alsaccount.dao.admin.AlsSabhrsFyeAdjstDtl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsSabhrsFyeAdjstDtl> findByExample(AlsSabhrsFyeAdjstDtl instance) {
        log.debug("finding AlsSabhrsFyeAdjstDtl instance by example");
        try {
            List<AlsSabhrsFyeAdjstDtl> results = (List<AlsSabhrsFyeAdjstDtl>) getSession()
                    .createCriteria("fwp.alsaccount.dao.admin.AlsSabhrsFyeAdjstDtl")
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
      log.debug("finding AlsSabhrsFyeAdjstDtl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsSabhrsFyeAdjstDtl as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all AlsSabhrsFyeAdjstDtl instances");
		try {
			String queryString = "from AlsSabhrsFyeAdjstDtl";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsSabhrsFyeAdjstDtl merge(AlsSabhrsFyeAdjstDtl detachedInstance) {
        log.debug("merging AlsSabhrsFyeAdjstDtl instance");
        try {
            AlsSabhrsFyeAdjstDtl result = (AlsSabhrsFyeAdjstDtl) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsSabhrsFyeAdjstDtl instance) {
        log.debug("attaching dirty AlsSabhrsFyeAdjstDtl instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsSabhrsFyeAdjstDtl instance) {
        log.debug("attaching clean AlsSabhrsFyeAdjstDtl instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}