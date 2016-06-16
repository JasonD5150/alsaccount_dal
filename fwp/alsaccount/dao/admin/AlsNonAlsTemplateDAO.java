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
 	* A data access object (DAO) providing persistence and search support for AlsNonAlsTemplate entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.als.hibernate.admin.dao.AlsNonAlsTemplate
  * @author MyEclipse Persistence Tools 
 */
public class AlsNonAlsTemplateDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsNonAlsTemplateDAO.class);
		//property constants
	public static final String ANAT_DESC = "anatDesc";
	public static final String ANAT_BUSINESS_UNIT = "anatBusinessUnit";
	public static final String ANAT_DR_ACCOUNT = "anatDrAccount";
	public static final String ANAT_CR_ACCOUNT = "anatCrAccount";
	public static final String ANAT_FUND = "anatFund";
	public static final String ANAT_DR_ORG = "anatDrOrg";
	public static final String ANAT_CR_ORG = "anatCrOrg";
	public static final String ANAT_DR_SUBCLASS = "anatDrSubclass";
	public static final String ANAT_CR_SUBCLASS = "anatCrSubclass";
	public static final String ANAT_PROGRAM_YEAR = "anatProgramYear";
	public static final String ANAT_DR_PROJECT_GRANT = "anatDrProjectGrant";
	public static final String ANAT_CR_PROJECT_GRANT = "anatCrProjectGrant";
	public static final String ANAT_DR_JOURNAL_LINE_REFR = "anatDrJournalLineRefr";
	public static final String ANAT_CR_JOURNAL_LINE_REFR = "anatCrJournalLineRefr";
	public static final String ANAT_DR_LINE_DESC = "anatDrLineDesc";
	public static final String ANAT_CR_LINE_DESC = "anatCrLineDesc";
	public static final String ANAT_WHO_LOG = "anatWhoLog";



    
    public void save(AlsNonAlsTemplate transientInstance) {
        log.debug("saving AlsNonAlsTemplate instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsNonAlsTemplate persistentInstance) {
        log.debug("deleting AlsNonAlsTemplate instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsNonAlsTemplate findById( fwp.alsaccount.dao.admin.AlsNonAlsTemplateIdPk id) {
        log.debug("getting AlsNonAlsTemplate instance with id: " + id);
        try {
            AlsNonAlsTemplate instance = (AlsNonAlsTemplate) getSession()
                    .get("fwp.alsaccount.dao.admin.AlsNonAlsTemplate", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsNonAlsTemplate> findByExample(AlsNonAlsTemplate instance) {
        log.debug("finding AlsNonAlsTemplate instance by example");
        try {
            List<AlsNonAlsTemplate> results = (List<AlsNonAlsTemplate>) getSession()
                    .createCriteria("fwp.alsaccount.dao.admin.AlsNonAlsTemplate")
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
      log.debug("finding AlsNonAlsTemplate instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsNonAlsTemplate as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsNonAlsTemplate> findByAnatDesc(Object anatDesc
	) {
		return findByProperty(ANAT_DESC, anatDesc
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatBusinessUnit(Object anatBusinessUnit
	) {
		return findByProperty(ANAT_BUSINESS_UNIT, anatBusinessUnit
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatDrAccount(Object anatDrAccount
	) {
		return findByProperty(ANAT_DR_ACCOUNT, anatDrAccount
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatCrAccount(Object anatCrAccount
	) {
		return findByProperty(ANAT_CR_ACCOUNT, anatCrAccount
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatFund(Object anatFund
	) {
		return findByProperty(ANAT_FUND, anatFund
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatDrOrg(Object anatDrOrg
	) {
		return findByProperty(ANAT_DR_ORG, anatDrOrg
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatCrOrg(Object anatCrOrg
	) {
		return findByProperty(ANAT_CR_ORG, anatCrOrg
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatDrSubclass(Object anatDrSubclass
	) {
		return findByProperty(ANAT_DR_SUBCLASS, anatDrSubclass
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatCrSubclass(Object anatCrSubclass
	) {
		return findByProperty(ANAT_CR_SUBCLASS, anatCrSubclass
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatProgramYear(Object anatProgramYear
	) {
		return findByProperty(ANAT_PROGRAM_YEAR, anatProgramYear
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatDrProjectGrant(Object anatDrProjectGrant
	) {
		return findByProperty(ANAT_DR_PROJECT_GRANT, anatDrProjectGrant
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatCrProjectGrant(Object anatCrProjectGrant
	) {
		return findByProperty(ANAT_CR_PROJECT_GRANT, anatCrProjectGrant
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatDrJournalLineRefr(Object anatDrJournalLineRefr
	) {
		return findByProperty(ANAT_DR_JOURNAL_LINE_REFR, anatDrJournalLineRefr
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatCrJournalLineRefr(Object anatCrJournalLineRefr
	) {
		return findByProperty(ANAT_CR_JOURNAL_LINE_REFR, anatCrJournalLineRefr
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatDrLineDesc(Object anatDrLineDesc
	) {
		return findByProperty(ANAT_DR_LINE_DESC, anatDrLineDesc
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatCrLineDesc(Object anatCrLineDesc
	) {
		return findByProperty(ANAT_CR_LINE_DESC, anatCrLineDesc
		);
	}
	
	public List<AlsNonAlsTemplate> findByAnatWhoLog(Object anatWhoLog
	) {
		return findByProperty(ANAT_WHO_LOG, anatWhoLog
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsNonAlsTemplate instances");
		try {
			String queryString = "from AlsNonAlsTemplate";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsNonAlsTemplate merge(AlsNonAlsTemplate detachedInstance) {
        log.debug("merging AlsNonAlsTemplate instance");
        try {
            AlsNonAlsTemplate result = (AlsNonAlsTemplate) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsNonAlsTemplate instance) {
        log.debug("attaching dirty AlsNonAlsTemplate instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsNonAlsTemplate instance) {
        log.debug("attaching clean AlsNonAlsTemplate instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}