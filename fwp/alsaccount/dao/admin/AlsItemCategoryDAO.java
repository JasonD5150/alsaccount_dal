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
 	* A data access object (DAO) providing persistence and search support for AlsItemCategory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.admin.AlsItemCategory
  * @author MyEclipse Persistence Tools 
 */
public class AlsItemCategoryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsItemCategoryDAO.class);
		//property constants
	public static final String AIC_CATEGORY_DESC = "aicCategoryDesc";
	public static final String AIC_WHO_LOG = "aicWhoLog";
	public static final String AIC_WEB_DESC_HTML = "aicWebDescHtml";
	public static final String AIC_ALX_DESC_TEXT = "aicAlxDescText";



    
    public void save(AlsItemCategory transientInstance) {
        log.debug("saving AlsItemCategory instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsItemCategory persistentInstance) {
        log.debug("deleting AlsItemCategory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsItemCategory findById( fwp.alsaccount.dao.admin.AlsItemCategoryIdPk id) {
        log.debug("getting AlsItemCategory instance with id: " + id);
        try {
            AlsItemCategory instance = (AlsItemCategory) getSession()
                    .get("fwp.alsaccount.dao.admin.AlsItemCategory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsItemCategory> findByExample(AlsItemCategory instance) {
        log.debug("finding AlsItemCategory instance by example");
        try {
            List<AlsItemCategory> results = (List<AlsItemCategory>) getSession()
                    .createCriteria("fwp.alsaccount.dao.admin.AlsItemCategory")
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
      log.debug("finding AlsItemCategory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsItemCategory as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsItemCategory> findByAicCategoryDesc(Object aicCategoryDesc
	) {
		return findByProperty(AIC_CATEGORY_DESC, aicCategoryDesc
		);
	}
	
	public List<AlsItemCategory> findByAicWhoLog(Object aicWhoLog
	) {
		return findByProperty(AIC_WHO_LOG, aicWhoLog
		);
	}
	
	public List<AlsItemCategory> findByAicWebDescHtml(Object aicWebDescHtml
	) {
		return findByProperty(AIC_WEB_DESC_HTML, aicWebDescHtml
		);
	}
	
	public List<AlsItemCategory> findByAicAlxDescText(Object aicAlxDescText
	) {
		return findByProperty(AIC_ALX_DESC_TEXT, aicAlxDescText
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsItemCategory instances");
		try {
			String queryString = "from AlsItemCategory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsItemCategory merge(AlsItemCategory detachedInstance) {
        log.debug("merging AlsItemCategory instance");
        try {
            AlsItemCategory result = (AlsItemCategory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsItemCategory instance) {
        log.debug("attaching dirty AlsItemCategory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsItemCategory instance) {
        log.debug("attaching clean AlsItemCategory instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}