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
 	* A data access object (DAO) providing persistence and search support for sabhrsAlsSabhrsEntries entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries
  * @author MyEclipse Persistence Tools 
 */
public class AlsSabhrsEntriesDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsSabhrsEntriesDAO.class);
		//property constants
	public static final String ASAC_BUDGET_YEAR = "asacBudgetYear";
	public static final String ASAC_SYSTEM_ACTIVITY_TYPE_CD = "asacSystemActivityTypeCd";
	public static final String ASAC_TXN_CD = "asacTxnCd";
	public static final String AAM_ACCOUNT = "aamAccount";
	public static final String AAM_BUSINESS_UNIT = "aamBusinessUnit";
	public static final String AAM_FUND = "aamFund";
	public static final String AOC_ORG = "aocOrg";
	public static final String ASAC_PROGRAM = "asacProgram";
	public static final String ASAC_SUBCLASS = "asacSubclass";
	public static final String ASAC_PROJECT_GRANT = "asacProjectGrant";
	public static final String ASAC_REFERENCE = "asacReference";
	public static final String ASE_AMT = "aseAmt";
	public static final String ASE_ALLOW_UPLOAD_TO_SUMMARY = "aseAllowUploadToSummary";
	public static final String ASES_SEQ_NO = "asesSeqNo";
	public static final String API_PROVIDER_NO = "apiProviderNo";
	public static final String AIAFA_SEQ_NO = "aiafaSeqNo";
	public static final String ASE_WHO_LOG = "aseWhoLog";
	public static final String ATG_TRANSACTION_CD = "atgTransactionCd";
	public static final String ATGS_GROUP_IDENTIFIER = "atgsGroupIdentifier";
	public static final String ASE_NON_ALS_FLAG = "aseNonAlsFlag";
	public static final String ASE_LINE_DESCRIPTION = "aseLineDescription";
	public static final String ATI_TRIBE_CD = "atiTribeCd";
	public static final String ANAT_CD = "anatCd";



    
    public void save(AlsSabhrsEntries transientInstance) {
        log.debug("saving AlsSabhrsEntries instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsSabhrsEntries persistentInstance) {
        log.debug("deleting AlsSabhrsEntries instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsSabhrsEntries findById( fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesIdPk id) {
        log.debug("getting AlsSabhrsEntries instance with id: " + id);
        try {
            AlsSabhrsEntries instance = (AlsSabhrsEntries) getSession()
                    .get("fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsSabhrsEntries> findByExample(AlsSabhrsEntries instance) {
        log.debug("finding AlsSabhrsEntries instance by example");
        try {
            List<AlsSabhrsEntries> results = (List<AlsSabhrsEntries>) getSession()
                    .createCriteria("fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries")
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
      log.debug("finding AlsSabhrsEntries instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsSabhrsEntries as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsSabhrsEntries> findByAsacBudgetYear(Object asacBudgetYear
	) {
		return findByProperty(ASAC_BUDGET_YEAR, asacBudgetYear
		);
	}
	
	public List<AlsSabhrsEntries> findByAsacSystemActivityTypeCd(Object asacSystemActivityTypeCd
	) {
		return findByProperty(ASAC_SYSTEM_ACTIVITY_TYPE_CD, asacSystemActivityTypeCd
		);
	}
	
	public List<AlsSabhrsEntries> findByAsacTxnCd(Object asacTxnCd
	) {
		return findByProperty(ASAC_TXN_CD, asacTxnCd
		);
	}
	
	public List<AlsSabhrsEntries> findByAamAccount(Object aamAccount
	) {
		return findByProperty(AAM_ACCOUNT, aamAccount
		);
	}
	
	public List<AlsSabhrsEntries> findByAamBusinessUnit(Object aamBusinessUnit
	) {
		return findByProperty(AAM_BUSINESS_UNIT, aamBusinessUnit
		);
	}
	
	public List<AlsSabhrsEntries> findByAamFund(Object aamFund
	) {
		return findByProperty(AAM_FUND, aamFund
		);
	}
	
	public List<AlsSabhrsEntries> findByAocOrg(Object aocOrg
	) {
		return findByProperty(AOC_ORG, aocOrg
		);
	}
	
	public List<AlsSabhrsEntries> findByAsacProgram(Object asacProgram
	) {
		return findByProperty(ASAC_PROGRAM, asacProgram
		);
	}
	
	public List<AlsSabhrsEntries> findByAsacSubclass(Object asacSubclass
	) {
		return findByProperty(ASAC_SUBCLASS, asacSubclass
		);
	}
	
	public List<AlsSabhrsEntries> findByAsacProjectGrant(Object asacProjectGrant
	) {
		return findByProperty(ASAC_PROJECT_GRANT, asacProjectGrant
		);
	}
	
	public List<AlsSabhrsEntries> findByAsacReference(Object asacReference
	) {
		return findByProperty(ASAC_REFERENCE, asacReference
		);
	}
	
	public List<AlsSabhrsEntries> findByAseAmt(Object aseAmt
	) {
		return findByProperty(ASE_AMT, aseAmt
		);
	}
	
	public List<AlsSabhrsEntries> findByAseAllowUploadToSummary(Object aseAllowUploadToSummary
	) {
		return findByProperty(ASE_ALLOW_UPLOAD_TO_SUMMARY, aseAllowUploadToSummary
		);
	}
	
	public List<AlsSabhrsEntries> findByAsesSeqNo(Object asesSeqNo
	) {
		return findByProperty(ASES_SEQ_NO, asesSeqNo
		);
	}
	
	public List<AlsSabhrsEntries> findByApiProviderNo(Object apiProviderNo
	) {
		return findByProperty(API_PROVIDER_NO, apiProviderNo
		);
	}
	
	public List<AlsSabhrsEntries> findByAiafaSeqNo(Object aiafaSeqNo
	) {
		return findByProperty(AIAFA_SEQ_NO, aiafaSeqNo
		);
	}
	
	public List<AlsSabhrsEntries> findByAseWhoLog(Object aseWhoLog
	) {
		return findByProperty(ASE_WHO_LOG, aseWhoLog
		);
	}
	
	public List<AlsSabhrsEntries> findByAtgTransactionCd(Object atgTransactionCd
	) {
		return findByProperty(ATG_TRANSACTION_CD, atgTransactionCd
		);
	}
	
	public List<AlsSabhrsEntries> findByAtgsGroupIdentifier(Object atgsGroupIdentifier
	) {
		return findByProperty(ATGS_GROUP_IDENTIFIER, atgsGroupIdentifier
		);
	}
	
	public List<AlsSabhrsEntries> findByAseNonAlsFlag(Object aseNonAlsFlag
	) {
		return findByProperty(ASE_NON_ALS_FLAG, aseNonAlsFlag
		);
	}
	
	public List<AlsSabhrsEntries> findByAseLineDescription(Object aseLineDescription
	) {
		return findByProperty(ASE_LINE_DESCRIPTION, aseLineDescription
		);
	}
	
	public List<AlsSabhrsEntries> findByAtiTribeCd(Object atiTribeCd
	) {
		return findByProperty(ATI_TRIBE_CD, atiTribeCd
		);
	}
	
	public List<AlsSabhrsEntries> findByAnatCd(Object anatCd
	) {
		return findByProperty(ANAT_CD, anatCd
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsSabhrsEntries instances");
		try {
			String queryString = "from AlsSabhrsEntries";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsSabhrsEntries merge(AlsSabhrsEntries detachedInstance) {
        log.debug("merging AlsSabhrsEntries instance");
        try {
            AlsSabhrsEntries result = (AlsSabhrsEntries) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsSabhrsEntries instance) {
        log.debug("attaching dirty AlsSabhrsEntries instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsSabhrsEntries instance) {
        log.debug("attaching clean AlsSabhrsEntries instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}