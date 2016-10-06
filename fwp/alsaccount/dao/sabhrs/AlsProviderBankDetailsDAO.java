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
 	* A data access object (DAO) providing persistence and search support for sabhrsAlsProviderBankDetails entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.AlsProviderBankDetails
  * @author MyEclipse Persistence Tools 
 */
public class AlsProviderBankDetailsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsProviderBankDetailsDAO.class);
		//property constants
	public static final String ABC_BANK_CD = "abcBankCd";
	public static final String APBD_AMOUNT_DEPOSIT = "apbdAmountDeposit";
	public static final String APBD_DEPOSIT_ID = "apbdDepositId";
	public static final String ATGS_GROUP_IDENTIFIER = "atgsGroupIdentifier";
	public static final String APBD_WHO_LOG = "apbdWhoLog";
	public static final String ATG_TRANSACTION_CD = "atgTransactionCd";
	public static final String CREATE_DBUSER = "createDbuser";
	public static final String CREATE_PERSONID = "createPersonid";
	public static final String MOD_DBUSER = "modDbuser";
	public static final String MOD_PERSONID = "modPersonid";
	public static final String APBD_CASH_IND = "apbdCashInd";



    
    public void save(AlsProviderBankDetails transientInstance) {
        log.debug("saving AlsProviderBankDetails instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsProviderBankDetails persistentInstance) {
        log.debug("deleting AlsProviderBankDetails instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsProviderBankDetails findById(AlsProviderBankDetailsIdPk id) {
        log.debug("getting AlsProviderBankDetails instance with id: " + id);
        try {
            AlsProviderBankDetails instance = (AlsProviderBankDetails) getSession()
                    .get("fwp.alsaccount.dao.sabhrs.AlsProviderBankDetails", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsProviderBankDetails> findByExample(AlsProviderBankDetails instance) {
        log.debug("finding AlsProviderBankDetails instance by example");
        try {
            List<AlsProviderBankDetails> results = (List<AlsProviderBankDetails>) getSession()
                    .createCriteria("fwp.alsaccount.dao.sabhrs.AlsProviderBankDetails")
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
      log.debug("finding AlsProviderBankDetails instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsProviderBankDetails as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsProviderBankDetails> findByAbcBankCd(Object abcBankCd
	) {
		return findByProperty(ABC_BANK_CD, abcBankCd
		);
	}
	
	public List<AlsProviderBankDetails> findByApbdAmountDeposit(Object apbdAmountDeposit
	) {
		return findByProperty(APBD_AMOUNT_DEPOSIT, apbdAmountDeposit
		);
	}
	
	public List<AlsProviderBankDetails> findByApbdDepositId(Object apbdDepositId
	) {
		return findByProperty(APBD_DEPOSIT_ID, apbdDepositId
		);
	}
	
	public List<AlsProviderBankDetails> findByAtgsGroupIdentifier(Object atgsGroupIdentifier
	) {
		return findByProperty(ATGS_GROUP_IDENTIFIER, atgsGroupIdentifier
		);
	}
	
	public List<AlsProviderBankDetails> findByApbdWhoLog(Object apbdWhoLog
	) {
		return findByProperty(APBD_WHO_LOG, apbdWhoLog
		);
	}
	
	public List<AlsProviderBankDetails> findByAtgTransactionCd(Object atgTransactionCd
	) {
		return findByProperty(ATG_TRANSACTION_CD, atgTransactionCd
		);
	}
	
	public List<AlsProviderBankDetails> findByCreateDbuser(Object createDbuser
	) {
		return findByProperty(CREATE_DBUSER, createDbuser
		);
	}
	
	public List<AlsProviderBankDetails> findByCreatePersonid(Object createPersonid
	) {
		return findByProperty(CREATE_PERSONID, createPersonid
		);
	}
	
	public List<AlsProviderBankDetails> findByModDbuser(Object modDbuser
	) {
		return findByProperty(MOD_DBUSER, modDbuser
		);
	}
	
	public List<AlsProviderBankDetails> findByModPersonid(Object modPersonid
	) {
		return findByProperty(MOD_PERSONID, modPersonid
		);
	}
	
	public List<AlsProviderBankDetails> findByApbdCashInd(Object apbdCashInd
	) {
		return findByProperty(APBD_CASH_IND, apbdCashInd
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsProviderBankDetails instances");
		try {
			String queryString = "from AlsProviderBankDetails";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsProviderBankDetails merge(AlsProviderBankDetails detachedInstance) {
        log.debug("merging AlsProviderBankDetails instance");
        try {
            AlsProviderBankDetails result = (AlsProviderBankDetails) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsProviderBankDetails instance) {
        log.debug("attaching dirty AlsProviderBankDetails instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsProviderBankDetails instance) {
        log.debug("attaching clean AlsProviderBankDetails instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}