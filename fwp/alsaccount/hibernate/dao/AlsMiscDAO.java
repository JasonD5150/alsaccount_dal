package fwp.alsaccount.hibernate.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for AlsMisc entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.als.hibernate.admin.dao.AlsMisc
  * @author MyEclipse Persistence Tools 
 */
public class AlsMiscDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsMiscDAO.class);
		//property constants
	public static final String AM_KEY1 = "amKey1";
	public static final String AM_KEY2 = "amKey2";
	public static final String AM_KEY3 = "amKey3";
	public static final String AM_KEY4 = "amKey4";
	public static final String AM_KEY5 = "amKey5";
	public static final String AM_DESC1 = "amDesc1";
	public static final String AM_DESC2 = "amDesc2";
	public static final String AM_DESC3 = "amDesc3";
	public static final String AM_DESC4 = "amDesc4";
	public static final String AM_DESC5 = "amDesc5";
	public static final String AM_PAR_VAL = "amParVal";
	public static final String AM_VAL_DESC = "amValDesc";
	public static final String AM_WHO_LOG = "amWhoLog";



    
    public void save(AlsMisc transientInstance) {
        log.debug("saving AlsMisc instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsMisc persistentInstance) {
        log.debug("deleting AlsMisc instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsMisc findById( Integer id) {
        log.debug("getting AlsMisc instance with id: " + id);
        try {
            AlsMisc instance = (AlsMisc) getSession()
                    .get("fwp.als.hibernate.admin.dao.AlsMisc", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsMisc> findByExample(AlsMisc instance) {
        log.debug("finding AlsMisc instance by example");
        try {
            List<AlsMisc> results = (List<AlsMisc>) getSession()
                    .createCriteria("fwp.als.hibernate.admin.dao.AlsMisc")
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
      log.debug("finding AlsMisc instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsMisc as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsMisc> findByAmKey1(Object amKey1
	) {
		return findByProperty(AM_KEY1, amKey1
		);
	}
	
	public List<AlsMisc> findByAmKey2(Object amKey2
	) {
		return findByProperty(AM_KEY2, amKey2
		);
	}
	
	public List<AlsMisc> findByAmKey3(Object amKey3
	) {
		return findByProperty(AM_KEY3, amKey3
		);
	}
	
	public List<AlsMisc> findByAmKey4(Object amKey4
	) {
		return findByProperty(AM_KEY4, amKey4
		);
	}
	
	public List<AlsMisc> findByAmKey5(Object amKey5
	) {
		return findByProperty(AM_KEY5, amKey5
		);
	}
	
	public List<AlsMisc> findByAmDesc1(Object amDesc1
	) {
		return findByProperty(AM_DESC1, amDesc1
		);
	}
	
	public List<AlsMisc> findByAmDesc2(Object amDesc2
	) {
		return findByProperty(AM_DESC2, amDesc2
		);
	}
	
	public List<AlsMisc> findByAmDesc3(Object amDesc3
	) {
		return findByProperty(AM_DESC3, amDesc3
		);
	}
	
	public List<AlsMisc> findByAmDesc4(Object amDesc4
	) {
		return findByProperty(AM_DESC4, amDesc4
		);
	}
	
	public List<AlsMisc> findByAmDesc5(Object amDesc5
	) {
		return findByProperty(AM_DESC5, amDesc5
		);
	}
	
	public List<AlsMisc> findByAmParVal(Object amParVal
	) {
		return findByProperty(AM_PAR_VAL, amParVal
		);
	}
	
	public List<AlsMisc> findByAmValDesc(Object amValDesc
	) {
		return findByProperty(AM_VAL_DESC, amValDesc
		);
	}
	
	public List<AlsMisc> findByAmWhoLog(Object amWhoLog
	) {
		return findByProperty(AM_WHO_LOG, amWhoLog
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsMisc instances");
		try {
			String queryString = "from AlsMisc";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsMisc merge(AlsMisc detachedInstance) {
        log.debug("merging AlsMisc instance");
        try {
            AlsMisc result = (AlsMisc) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsMisc instance) {
        log.debug("attaching dirty AlsMisc instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsMisc instance) {
        log.debug("attaching clean AlsMisc instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}