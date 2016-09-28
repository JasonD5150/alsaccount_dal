package fwp.alsaccount.dao.sabhrs;

import fwp.alsaccount.hibernate.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for AlsOverUnderSalesDets entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.sabhrs.AlsOverUnderSalesDets
  * @author MyEclipse Persistence Tools 
 */
public class AlsOverUnderSalesDetsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsOverUnderSalesDetsDAO.class);
		//property constants
	public static final String AOUSD_FLAG = "aousdFlag";
	public static final String AOUSD_DESC = "aousdDesc";
	public static final String AOUSD_AMOUNT = "aousdAmount";
	public static final String AOUSD_WHO_LOG = "aousdWhoLog";
	public static final String AOUSD_CREATE_PERSONID = "aousdCreatePersonid";
	public static final String AOUSD_CREATE_DBUSERS = "aousdCreateDbusers";
	public static final String AOUSD_LAST_MOD_PERSONID = "aousdLastModPersonid";
	public static final String AOUSD_LAST_MOD_DBUSERS = "aousdLastModDbusers";



    
    public void save(AlsOverUnderSalesDets transientInstance) {
        log.debug("saving AlsOverUnderSalesDets instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsOverUnderSalesDets persistentInstance) {
        log.debug("deleting AlsOverUnderSalesDets instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsOverUnderSalesDets findById( fwp.alsaccount.dao.sabhrs.AlsOverUnderSalesDetsIdPk id) {
        log.debug("getting AlsOverUnderSalesDets instance with id: " + id);
        try {
            AlsOverUnderSalesDets instance = (AlsOverUnderSalesDets) getSession()
                    .get("fwp.alsaccount.dao.sabhrs.AlsOverUnderSalesDets", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsOverUnderSalesDets> findByExample(AlsOverUnderSalesDets instance) {
        log.debug("finding AlsOverUnderSalesDets instance by example");
        try {
            List<AlsOverUnderSalesDets> results = (List<AlsOverUnderSalesDets>) getSession()
                    .createCriteria("fwp.alsaccount.dao.sabhrs.AlsOverUnderSalesDets")
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
      log.debug("finding AlsOverUnderSalesDets instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsOverUnderSalesDets as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsOverUnderSalesDets> findByAousdFlag(Object aousdFlag
	) {
		return findByProperty(AOUSD_FLAG, aousdFlag
		);
	}
	
	public List<AlsOverUnderSalesDets> findByAousdDesc(Object aousdDesc
	) {
		return findByProperty(AOUSD_DESC, aousdDesc
		);
	}
	
	public List<AlsOverUnderSalesDets> findByAousdAmount(Object aousdAmount
	) {
		return findByProperty(AOUSD_AMOUNT, aousdAmount
		);
	}
	
	public List<AlsOverUnderSalesDets> findByAousdWhoLog(Object aousdWhoLog
	) {
		return findByProperty(AOUSD_WHO_LOG, aousdWhoLog
		);
	}
	
	public List<AlsOverUnderSalesDets> findByAousdCreatePersonid(Object aousdCreatePersonid
	) {
		return findByProperty(AOUSD_CREATE_PERSONID, aousdCreatePersonid
		);
	}
	
	public List<AlsOverUnderSalesDets> findByAousdCreateDbusers(Object aousdCreateDbusers
	) {
		return findByProperty(AOUSD_CREATE_DBUSERS, aousdCreateDbusers
		);
	}
	
	public List<AlsOverUnderSalesDets> findByAousdLastModPersonid(Object aousdLastModPersonid
	) {
		return findByProperty(AOUSD_LAST_MOD_PERSONID, aousdLastModPersonid
		);
	}
	
	public List<AlsOverUnderSalesDets> findByAousdLastModDbusers(Object aousdLastModDbusers
	) {
		return findByProperty(AOUSD_LAST_MOD_DBUSERS, aousdLastModDbusers
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsOverUnderSalesDets instances");
		try {
			String queryString = "from AlsOverUnderSalesDets";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsOverUnderSalesDets merge(AlsOverUnderSalesDets detachedInstance) {
        log.debug("merging AlsOverUnderSalesDets instance");
        try {
            AlsOverUnderSalesDets result = (AlsOverUnderSalesDets) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsOverUnderSalesDets instance) {
        log.debug("attaching dirty AlsOverUnderSalesDets instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsOverUnderSalesDets instance) {
        log.debug("attaching clean AlsOverUnderSalesDets instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}