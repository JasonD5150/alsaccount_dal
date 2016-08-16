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
 	* A data access object (DAO) providing persistence and search support for AlsCostGroup entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.sabhrs.AlsCostGroup
  * @author MyEclipse Persistence Tools 
 */
public class AlsCostGroupDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsCostGroupDAO.class);
		//property constants
	public static final String ACG_SUPPLEMENT_COST_GRP_DESC = "acgSupplementCostGrpDesc";
	public static final String ACG_SUPPLEMENTAL_PRNT_ITEM_LMT = "acgSupplementalPrntItemLmt";
	public static final String ACG_WHO_LOG = "acgWhoLog";



    
    public void save(AlsCostGroup transientInstance) {
        log.debug("saving AlsCostGroup instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsCostGroup persistentInstance) {
        log.debug("deleting AlsCostGroup instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsCostGroup findById( fwp.alsaccount.dao.sabhrs.AlsCostGroupIdPk id) {
        log.debug("getting AlsCostGroup instance with id: " + id);
        try {
            AlsCostGroup instance = (AlsCostGroup) getSession()
                    .get("fwp.alsaccount.dao.sabhrs.AlsCostGroup", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsCostGroup> findByExample(AlsCostGroup instance) {
        log.debug("finding AlsCostGroup instance by example");
        try {
            List<AlsCostGroup> results = (List<AlsCostGroup>) getSession()
                    .createCriteria("fwp.alsaccount.dao.sabhrs.AlsCostGroup")
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
      log.debug("finding AlsCostGroup instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsCostGroup as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsCostGroup> findByAcgSupplementCostGrpDesc(Object acgSupplementCostGrpDesc
	) {
		return findByProperty(ACG_SUPPLEMENT_COST_GRP_DESC, acgSupplementCostGrpDesc
		);
	}
	
	public List<AlsCostGroup> findByAcgSupplementalPrntItemLmt(Object acgSupplementalPrntItemLmt
	) {
		return findByProperty(ACG_SUPPLEMENTAL_PRNT_ITEM_LMT, acgSupplementalPrntItemLmt
		);
	}
	
	public List<AlsCostGroup> findByAcgWhoLog(Object acgWhoLog
	) {
		return findByProperty(ACG_WHO_LOG, acgWhoLog
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsCostGroup instances");
		try {
			String queryString = "from AlsCostGroup";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsCostGroup merge(AlsCostGroup detachedInstance) {
        log.debug("merging AlsCostGroup instance");
        try {
            AlsCostGroup result = (AlsCostGroup) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsCostGroup instance) {
        log.debug("attaching dirty AlsCostGroup instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsCostGroup instance) {
        log.debug("attaching clean AlsCostGroup instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}