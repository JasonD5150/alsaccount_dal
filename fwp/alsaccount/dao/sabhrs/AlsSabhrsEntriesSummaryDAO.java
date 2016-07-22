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
 	* A data access object (DAO) providing persistence and search support for AlsSabhrsEntriesSummary entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesSummary
  * @author MyEclipse Persistence Tools 
 */
public class AlsSabhrsEntriesSummaryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsSabhrsEntriesSummaryDAO.class);
		//property constants
	public static final String AAM_BUSINESS_UNIT = "aamBusinessUnit";
	public static final String ASAC_REFERENCE = "asacReference";
	public static final String AAM_ACCOUNT = "aamAccount";
	public static final String AAM_FUND = "aamFund";
	public static final String AOC_ORG = "aocOrg";
	public static final String ASAC_PROGRAM = "asacProgram";
	public static final String ASAC_SUBCLASS = "asacSubclass";
	public static final String ASAC_BUDGET_YEAR = "asacBudgetYear";
	public static final String ASAC_PROJECT_GRANT = "asacProjectGrant";
	public static final String ASE_AMT = "aseAmt";
	public static final String ASAC_SYSTEM_ACTIVITY_TYPE_CD = "asacSystemActivityTypeCd";
	public static final String ASAC_TXN_CD = "asacTxnCd";
	public static final String ASES_WHO_LOG = "asesWhoLog";
	public static final String ATG_TRANSACTION_CD = "atgTransactionCd";
	public static final String ATGS_GROUP_IDENTIFIER = "atgsGroupIdentifier";
	public static final String ASE_NON_ALS_FLAG = "aseNonAlsFlag";
	public static final String ASE_LINE_DESCRIPTION = "aseLineDescription";
	public static final String ATI_TRIBE_CD = "atiTribeCd";



    
    public void save(AlsSabhrsEntriesSummary transientInstance) {
        log.debug("saving AlsSabhrsEntriesSummary instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsSabhrsEntriesSummary persistentInstance) {
        log.debug("deleting AlsSabhrsEntriesSummary instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsSabhrsEntriesSummary findById( fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesSummaryIdPk id) {
        log.debug("getting AlsSabhrsEntriesSummary instance with id: " + id);
        try {
            AlsSabhrsEntriesSummary instance = (AlsSabhrsEntriesSummary) getSession()
                    .get("fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesSummary", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsSabhrsEntriesSummary> findByExample(AlsSabhrsEntriesSummary instance) {
        log.debug("finding AlsSabhrsEntriesSummary instance by example");
        try {
            List<AlsSabhrsEntriesSummary> results = (List<AlsSabhrsEntriesSummary>) getSession()
                    .createCriteria("fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesSummary")
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
      log.debug("finding AlsSabhrsEntriesSummary instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsSabhrsEntriesSummary as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsSabhrsEntriesSummary> findByAamBusinessUnit(Object aamBusinessUnit
	) {
		return findByProperty(AAM_BUSINESS_UNIT, aamBusinessUnit
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAsacReference(Object asacReference
	) {
		return findByProperty(ASAC_REFERENCE, asacReference
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAamAccount(Object aamAccount
	) {
		return findByProperty(AAM_ACCOUNT, aamAccount
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAamFund(Object aamFund
	) {
		return findByProperty(AAM_FUND, aamFund
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAocOrg(Object aocOrg
	) {
		return findByProperty(AOC_ORG, aocOrg
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAsacProgram(Object asacProgram
	) {
		return findByProperty(ASAC_PROGRAM, asacProgram
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAsacSubclass(Object asacSubclass
	) {
		return findByProperty(ASAC_SUBCLASS, asacSubclass
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAsacBudgetYear(Object asacBudgetYear
	) {
		return findByProperty(ASAC_BUDGET_YEAR, asacBudgetYear
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAsacProjectGrant(Object asacProjectGrant
	) {
		return findByProperty(ASAC_PROJECT_GRANT, asacProjectGrant
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAseAmt(Object aseAmt
	) {
		return findByProperty(ASE_AMT, aseAmt
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAsacSystemActivityTypeCd(Object asacSystemActivityTypeCd
	) {
		return findByProperty(ASAC_SYSTEM_ACTIVITY_TYPE_CD, asacSystemActivityTypeCd
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAsacTxnCd(Object asacTxnCd
	) {
		return findByProperty(ASAC_TXN_CD, asacTxnCd
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAsesWhoLog(Object asesWhoLog
	) {
		return findByProperty(ASES_WHO_LOG, asesWhoLog
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAtgTransactionCd(Object atgTransactionCd
	) {
		return findByProperty(ATG_TRANSACTION_CD, atgTransactionCd
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAtgsGroupIdentifier(Object atgsGroupIdentifier
	) {
		return findByProperty(ATGS_GROUP_IDENTIFIER, atgsGroupIdentifier
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAseNonAlsFlag(Object aseNonAlsFlag
	) {
		return findByProperty(ASE_NON_ALS_FLAG, aseNonAlsFlag
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAseLineDescription(Object aseLineDescription
	) {
		return findByProperty(ASE_LINE_DESCRIPTION, aseLineDescription
		);
	}
	
	public List<AlsSabhrsEntriesSummary> findByAtiTribeCd(Object atiTribeCd
	) {
		return findByProperty(ATI_TRIBE_CD, atiTribeCd
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsSabhrsEntriesSummary instances");
		try {
			String queryString = "from AlsSabhrsEntriesSummary";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsSabhrsEntriesSummary merge(AlsSabhrsEntriesSummary detachedInstance) {
        log.debug("merging AlsSabhrsEntriesSummary instance");
        try {
            AlsSabhrsEntriesSummary result = (AlsSabhrsEntriesSummary) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsSabhrsEntriesSummary instance) {
        log.debug("attaching dirty AlsSabhrsEntriesSummary instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsSabhrsEntriesSummary instance) {
        log.debug("attaching clean AlsSabhrsEntriesSummary instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}