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
 	* A data access object (DAO) providing persistence and search support for AlsProviderBankDepositSlip entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.sabhrs.AlsProviderBankDepositSlip
  * @author MyEclipse Persistence Tools 
 */
public class AlsProviderBankDepositSlipDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsProviderBankDepositSlipDAO.class);
		//property constants
	public static final String API_PROVIDER_NO = "apiProviderNo";
	public static final String APBD_SEQ_NO = "apbdSeqNo";
	public static final String APBDS_FILE_NAME = "apbdsFileName";
	public static final String APBDS_FILE_TYPE = "apbdsFileType";
	public static final String APBDS_CREATE_DBUSER = "apbdsCreateDbuser";
	public static final String APBDS_CREATE_PERSON_ID = "apbdsCreatePersonId";
	public static final String APBDS_MOD_DBUSER = "apbdsModDbuser";
	public static final String APBDS_MOD_PERSONID = "apbdsModPersonid";



    
    public void save(AlsProviderBankDepositSlip transientInstance) {
        log.debug("saving AlsProviderBankDepositSlip instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsProviderBankDepositSlip persistentInstance) {
        log.debug("deleting AlsProviderBankDepositSlip instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsProviderBankDepositSlip findById( Integer id) {
        log.debug("getting AlsProviderBankDepositSlip instance with id: " + id);
        try {
            AlsProviderBankDepositSlip instance = (AlsProviderBankDepositSlip) getSession()
                    .get("fwp.alsaccount.dao.sabhrs.AlsProviderBankDepositSlip", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsProviderBankDepositSlip> findByExample(AlsProviderBankDepositSlip instance) {
        log.debug("finding AlsProviderBankDepositSlip instance by example");
        try {
            List<AlsProviderBankDepositSlip> results = (List<AlsProviderBankDepositSlip>) getSession()
                    .createCriteria("fwp.alsaccount.dao.sabhrs.AlsProviderBankDepositSlip")
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
      log.debug("finding AlsProviderBankDepositSlip instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsProviderBankDepositSlip as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsProviderBankDepositSlip> findByApiProviderNo(Object apiProviderNo
	) {
		return findByProperty(API_PROVIDER_NO, apiProviderNo
		);
	}
	
	public List<AlsProviderBankDepositSlip> findByApbdSeqNo(Object apbdSeqNo
	) {
		return findByProperty(APBD_SEQ_NO, apbdSeqNo
		);
	}
	
	public List<AlsProviderBankDepositSlip> findByApbdsFileName(Object apbdsFileName
	) {
		return findByProperty(APBDS_FILE_NAME, apbdsFileName
		);
	}
	
	public List<AlsProviderBankDepositSlip> findByApbdsFileType(Object apbdsFileType
	) {
		return findByProperty(APBDS_FILE_TYPE, apbdsFileType
		);
	}
	
	public List<AlsProviderBankDepositSlip> findByApbdsCreateDbuser(Object apbdsCreateDbuser
	) {
		return findByProperty(APBDS_CREATE_DBUSER, apbdsCreateDbuser
		);
	}
	
	public List<AlsProviderBankDepositSlip> findByApbdsCreatePersonId(Object apbdsCreatePersonId
	) {
		return findByProperty(APBDS_CREATE_PERSON_ID, apbdsCreatePersonId
		);
	}
	
	public List<AlsProviderBankDepositSlip> findByApbdsModDbuser(Object apbdsModDbuser
	) {
		return findByProperty(APBDS_MOD_DBUSER, apbdsModDbuser
		);
	}
	
	public List<AlsProviderBankDepositSlip> findByApbdsModPersonid(Object apbdsModPersonid
	) {
		return findByProperty(APBDS_MOD_PERSONID, apbdsModPersonid
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsProviderBankDepositSlip instances");
		try {
			String queryString = "from AlsProviderBankDepositSlip";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsProviderBankDepositSlip merge(AlsProviderBankDepositSlip detachedInstance) {
        log.debug("merging AlsProviderBankDepositSlip instance");
        try {
            AlsProviderBankDepositSlip result = (AlsProviderBankDepositSlip) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsProviderBankDepositSlip instance) {
        log.debug("attaching dirty AlsProviderBankDepositSlip instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsProviderBankDepositSlip instance) {
        log.debug("attaching clean AlsProviderBankDepositSlip instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}