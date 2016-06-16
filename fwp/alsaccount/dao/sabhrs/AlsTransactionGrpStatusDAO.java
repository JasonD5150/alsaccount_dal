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
 	* A data access object (DAO) providing persistence and search support for sabhrsAlsTransactionGrpStatus entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.AlsTransactionGrpStatus
  * @author MyEclipse Persistence Tools 
 */
public class AlsTransactionGrpStatusDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsTransactionGrpStatusDAO.class);
		//property constants
	public static final String ATGS_SUMMARY_STATUS = "atgsSummaryStatus";
	public static final String ATGS_INTERFACE_STATUS = "atgsInterfaceStatus";
	public static final String ATGS_SUMMARY_APPROVED_BY = "atgsSummaryApprovedBy";
	public static final String ATGS_INTERFACE_APPROVED_BY = "atgsInterfaceApprovedBy";
	public static final String ATGS_FILE_NAME = "atgsFileName";
	public static final String ATGS_REMARKS = "atgsRemarks";
	public static final String ABC_BANK_CD = "abcBankCd";
	public static final String ATGS_NET_DR_CR = "atgsNetDrCr";
	public static final String ATGS_NON_ALS_FLAG = "atgsNonAlsFlag";
	public static final String ATGS_DEPOSIT_ID = "atgsDepositId";
	public static final String ATGS_WHO_CREATED = "atgsWhoCreated";
	public static final String ATGS_WHO_MODI = "atgsWhoModi";
	public static final String ATGS_AR_GL_FLAG = "atgsArGlFlag";
	public static final String ATGS_BANK_REFERENCE_NO = "atgsBankReferenceNo";
	public static final String ATGS_FYE_PRIOR_PROGRAM = "atgsFyePriorProgram";
	public static final String ATGS_FYE_OVERRIDE_PROGRAM = "atgsFyeOverrideProgram";



    
    public void save(AlsTransactionGrpStatus transientInstance) {
        log.debug("saving sabhrsAlsTransactionGrpStatus instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsTransactionGrpStatus persistentInstance) {
        log.debug("deleting sabhrsAlsTransactionGrpStatus instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsTransactionGrpStatus findById( fwp.alsaccount.dao.sabhrs.AlsTransactionGrpStatusIdPk id) {
        log.debug("getting sabhrsAlsTransactionGrpStatus instance with id: " + id);
        try {
            AlsTransactionGrpStatus instance = (AlsTransactionGrpStatus) getSession()
                    .get("fwp.alsaccount.dao.sabhrsAlsTransactionGrpStatus", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsTransactionGrpStatus> findByExample(AlsTransactionGrpStatus instance) {
        log.debug("finding sabhrsAlsTransactionGrpStatus instance by example");
        try {
            List<AlsTransactionGrpStatus> results = (List<AlsTransactionGrpStatus>) getSession()
                    .createCriteria("fwp.alsaccount.dao.sabhrsAlsTransactionGrpStatus")
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
      log.debug("finding sabhrsAlsTransactionGrpStatus instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from sabhrsAlsTransactionGrpStatus as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsTransactionGrpStatus> findByAtgsSummaryStatus(Object atgsSummaryStatus
	) {
		return findByProperty(ATGS_SUMMARY_STATUS, atgsSummaryStatus
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsInterfaceStatus(Object atgsInterfaceStatus
	) {
		return findByProperty(ATGS_INTERFACE_STATUS, atgsInterfaceStatus
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsSummaryApprovedBy(Object atgsSummaryApprovedBy
	) {
		return findByProperty(ATGS_SUMMARY_APPROVED_BY, atgsSummaryApprovedBy
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsInterfaceApprovedBy(Object atgsInterfaceApprovedBy
	) {
		return findByProperty(ATGS_INTERFACE_APPROVED_BY, atgsInterfaceApprovedBy
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsFileName(Object atgsFileName
	) {
		return findByProperty(ATGS_FILE_NAME, atgsFileName
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsRemarks(Object atgsRemarks
	) {
		return findByProperty(ATGS_REMARKS, atgsRemarks
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAbcBankCd(Object abcBankCd
	) {
		return findByProperty(ABC_BANK_CD, abcBankCd
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsNetDrCr(Object atgsNetDrCr
	) {
		return findByProperty(ATGS_NET_DR_CR, atgsNetDrCr
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsNonAlsFlag(Object atgsNonAlsFlag
	) {
		return findByProperty(ATGS_NON_ALS_FLAG, atgsNonAlsFlag
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsDepositId(Object atgsDepositId
	) {
		return findByProperty(ATGS_DEPOSIT_ID, atgsDepositId
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsWhoCreated(Object atgsWhoCreated
	) {
		return findByProperty(ATGS_WHO_CREATED, atgsWhoCreated
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsWhoModi(Object atgsWhoModi
	) {
		return findByProperty(ATGS_WHO_MODI, atgsWhoModi
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsArGlFlag(Object atgsArGlFlag
	) {
		return findByProperty(ATGS_AR_GL_FLAG, atgsArGlFlag
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsBankReferenceNo(Object atgsBankReferenceNo
	) {
		return findByProperty(ATGS_BANK_REFERENCE_NO, atgsBankReferenceNo
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsFyePriorProgram(Object atgsFyePriorProgram
	) {
		return findByProperty(ATGS_FYE_PRIOR_PROGRAM, atgsFyePriorProgram
		);
	}
	
	public List<AlsTransactionGrpStatus> findByAtgsFyeOverrideProgram(Object atgsFyeOverrideProgram
	) {
		return findByProperty(ATGS_FYE_OVERRIDE_PROGRAM, atgsFyeOverrideProgram
		);
	}
	

	public List findAll() {
		log.debug("finding all sabhrsAlsTransactionGrpStatus instances");
		try {
			String queryString = "from sabhrsAlsTransactionGrpStatus";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsTransactionGrpStatus merge(AlsTransactionGrpStatus detachedInstance) {
        log.debug("merging sabhrsAlsTransactionGrpStatus instance");
        try {
            AlsTransactionGrpStatus result = (AlsTransactionGrpStatus) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsTransactionGrpStatus instance) {
        log.debug("attaching dirty sabhrsAlsTransactionGrpStatus instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsTransactionGrpStatus instance) {
        log.debug("attaching clean sabhrsAlsTransactionGrpStatus instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}