package fwp.alsaccount.dao.admin;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for AlsProviderInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.admin.AlsProviderInfo
  * @author MyEclipse Persistence Tools 
 */
public class AlsProviderInfoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsProviderInfoDAO.class);
		//property constants
	public static final String API_PROVIDER_CAT = "apiProviderCat";
	public static final String API_PROVIDER_CLASS = "apiProviderClass";
	public static final String API_SECURITY_REQ_MET = "apiSecurityReqMet";
	public static final String API_APPLICANT_LAST_NM = "apiApplicantLastNm";
	public static final String API_APPLICANT_FIRST_NM = "apiApplicantFirstNm";
	public static final String API_APPLICANT_MID_INIT = "apiApplicantMidInit";
	public static final String API_BUSINESS_NM = "apiBusinessNm";
	public static final String API_BUSINESS_ADDRESS = "apiBusinessAddress";
	public static final String API_BUSINESS_CITY = "apiBusinessCity";
	public static final String AC_BUSINESS_COUNTY = "acBusinessCounty";
	public static final String AR_BUSINESS_REGION = "arBusinessRegion";
	public static final String AZC_BUSINESS_ZIPCODE = "azcBusinessZipcode";
	public static final String API_BUSINESS_STATE = "apiBusinessState";
	public static final String API_BUSINESS_TYPE = "apiBusinessType";
	public static final String API_MERCHANDISE_TYPE = "apiMerchandiseType";
	public static final String API_BUSINESS_EIN = "apiBusinessEin";
	public static final String API_BUSINESS_PHONE = "apiBusinessPhone";
	public static final String API_BUSINESS_FAX = "apiBusinessFax";
	public static final String API_BUSINESS_EMAIL = "apiBusinessEmail";
	public static final String API_APPLICANT_HOMEPHONE = "apiApplicantHomephone";
	public static final String API_PERSONS_TRAINING = "apiPersonsTraining";
	public static final String API_OPEN_HOLIDAYS = "apiOpenHolidays";
	public static final String API_OPEN_MONTHS = "apiOpenMonths";
	public static final String API_APPLICANT_SSN = "apiApplicantSsn";
	public static final String API_BANKRUPTCY_FILED = "apiBankruptcyFiled";
	public static final String API_TIME_CURRBUSI_YRS = "apiTimeCurrbusiYrs";
	public static final String API_TIME_CURRBUSI_MNTHS = "apiTimeCurrbusiMnths";
	public static final String API_SECOFF_LAST_NM = "apiSecoffLastNm";
	public static final String API_SECOFF_FIRST_NM = "apiSecoffFirstNm";
	public static final String API_SECOFF_MID_INIT = "apiSecoffMidInit";
	public static final String ACD_CC_NO = "acdCcNo";
	public static final String API_DESIRED_NODEVICES = "apiDesiredNodevices";
	public static final String API_DEVICES_APPROVED = "apiDevicesApproved";
	public static final String API_FEE_EXEMPTED = "apiFeeExempted";
	public static final String API_COMMISSION_YN = "apiCommissionYn";
	public static final String API_SECURITY_REQUIRED = "apiSecurityRequired";
	public static final String API_DESIG = "apiDesig";
	public static final String API_ALLOW_SEC_PROV = "apiAllowSecProv";
	public static final String API_WHO_LOG = "apiWhoLog";
	public static final String API_COMMISSION_SI = "apiCommissionSi";
	public static final String API_SESS_COMM_AMOUNT = "apiSessCommAmount";
	public static final String API_SSL_FLAG = "apiSslFlag";
	public static final String ATI_TRIBE_CD = "atiTribeCd";
	public static final String API_MIX_SESS_COMM_AMT = "apiMixSessCommAmt";
	public static final String API_SP_SESS_COMM_AMT = "apiSpSessCommAmt";
	public static final String API_ALX_PROV_IND = "apiAlxProvInd";
	public static final String API_PRIMARY_PROVIDER_NO = "apiPrimaryProviderNo";
	public static final String API_SPEC_DEV_CONFIG = "apiSpecDevConfig";
	public static final String API_SPEC_CONFIG_IND = "apiSpecConfigInd";



    
    public void save(AlsProviderInfo transientInstance) {
        log.debug("saving AlsProviderInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsProviderInfo persistentInstance) {
        log.debug("deleting AlsProviderInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsProviderInfo findById( Integer id) {
        log.debug("getting AlsProviderInfo instance with id: " + id);
        try {
            AlsProviderInfo instance = (AlsProviderInfo) getSession()
                    .get("fwp.alsaccount.dao.admin.AlsProviderInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsProviderInfo> findByExample(AlsProviderInfo instance) {
        log.debug("finding AlsProviderInfo instance by example");
        try {
            List<AlsProviderInfo> results = (List<AlsProviderInfo>) getSession()
                    .createCriteria("fwp.alsaccount.dao.admin.AlsProviderInfo")
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
      log.debug("finding AlsProviderInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsProviderInfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsProviderInfo> findByApiProviderCat(Object apiProviderCat
	) {
		return findByProperty(API_PROVIDER_CAT, apiProviderCat
		);
	}
	
	public List<AlsProviderInfo> findByApiProviderClass(Object apiProviderClass
	) {
		return findByProperty(API_PROVIDER_CLASS, apiProviderClass
		);
	}
	
	public List<AlsProviderInfo> findByApiSecurityReqMet(Object apiSecurityReqMet
	) {
		return findByProperty(API_SECURITY_REQ_MET, apiSecurityReqMet
		);
	}
	
	public List<AlsProviderInfo> findByApiApplicantLastNm(Object apiApplicantLastNm
	) {
		return findByProperty(API_APPLICANT_LAST_NM, apiApplicantLastNm
		);
	}
	
	public List<AlsProviderInfo> findByApiApplicantFirstNm(Object apiApplicantFirstNm
	) {
		return findByProperty(API_APPLICANT_FIRST_NM, apiApplicantFirstNm
		);
	}
	
	public List<AlsProviderInfo> findByApiApplicantMidInit(Object apiApplicantMidInit
	) {
		return findByProperty(API_APPLICANT_MID_INIT, apiApplicantMidInit
		);
	}
	
	public List<AlsProviderInfo> findByApiBusinessNm(Object apiBusinessNm
	) {
		return findByProperty(API_BUSINESS_NM, apiBusinessNm
		);
	}
	
	public List<AlsProviderInfo> findByApiBusinessAddress(Object apiBusinessAddress
	) {
		return findByProperty(API_BUSINESS_ADDRESS, apiBusinessAddress
		);
	}
	
	public List<AlsProviderInfo> findByApiBusinessCity(Object apiBusinessCity
	) {
		return findByProperty(API_BUSINESS_CITY, apiBusinessCity
		);
	}
	
	public List<AlsProviderInfo> findByAcBusinessCounty(Object acBusinessCounty
	) {
		return findByProperty(AC_BUSINESS_COUNTY, acBusinessCounty
		);
	}
	
	public List<AlsProviderInfo> findByArBusinessRegion(Object arBusinessRegion
	) {
		return findByProperty(AR_BUSINESS_REGION, arBusinessRegion
		);
	}
	
	public List<AlsProviderInfo> findByAzcBusinessZipcode(Object azcBusinessZipcode
	) {
		return findByProperty(AZC_BUSINESS_ZIPCODE, azcBusinessZipcode
		);
	}
	
	public List<AlsProviderInfo> findByApiBusinessState(Object apiBusinessState
	) {
		return findByProperty(API_BUSINESS_STATE, apiBusinessState
		);
	}
	
	public List<AlsProviderInfo> findByApiBusinessType(Object apiBusinessType
	) {
		return findByProperty(API_BUSINESS_TYPE, apiBusinessType
		);
	}
	
	public List<AlsProviderInfo> findByApiMerchandiseType(Object apiMerchandiseType
	) {
		return findByProperty(API_MERCHANDISE_TYPE, apiMerchandiseType
		);
	}
	
	public List<AlsProviderInfo> findByApiBusinessEin(Object apiBusinessEin
	) {
		return findByProperty(API_BUSINESS_EIN, apiBusinessEin
		);
	}
	
	public List<AlsProviderInfo> findByApiBusinessPhone(Object apiBusinessPhone
	) {
		return findByProperty(API_BUSINESS_PHONE, apiBusinessPhone
		);
	}
	
	public List<AlsProviderInfo> findByApiBusinessFax(Object apiBusinessFax
	) {
		return findByProperty(API_BUSINESS_FAX, apiBusinessFax
		);
	}
	
	public List<AlsProviderInfo> findByApiBusinessEmail(Object apiBusinessEmail
	) {
		return findByProperty(API_BUSINESS_EMAIL, apiBusinessEmail
		);
	}
	
	public List<AlsProviderInfo> findByApiApplicantHomephone(Object apiApplicantHomephone
	) {
		return findByProperty(API_APPLICANT_HOMEPHONE, apiApplicantHomephone
		);
	}
	
	public List<AlsProviderInfo> findByApiPersonsTraining(Object apiPersonsTraining
	) {
		return findByProperty(API_PERSONS_TRAINING, apiPersonsTraining
		);
	}
	
	public List<AlsProviderInfo> findByApiOpenHolidays(Object apiOpenHolidays
	) {
		return findByProperty(API_OPEN_HOLIDAYS, apiOpenHolidays
		);
	}
	
	public List<AlsProviderInfo> findByApiOpenMonths(Object apiOpenMonths
	) {
		return findByProperty(API_OPEN_MONTHS, apiOpenMonths
		);
	}
	
	public List<AlsProviderInfo> findByApiApplicantSsn(Object apiApplicantSsn
	) {
		return findByProperty(API_APPLICANT_SSN, apiApplicantSsn
		);
	}
	
	public List<AlsProviderInfo> findByApiBankruptcyFiled(Object apiBankruptcyFiled
	) {
		return findByProperty(API_BANKRUPTCY_FILED, apiBankruptcyFiled
		);
	}
	
	public List<AlsProviderInfo> findByApiTimeCurrbusiYrs(Object apiTimeCurrbusiYrs
	) {
		return findByProperty(API_TIME_CURRBUSI_YRS, apiTimeCurrbusiYrs
		);
	}
	
	public List<AlsProviderInfo> findByApiTimeCurrbusiMnths(Object apiTimeCurrbusiMnths
	) {
		return findByProperty(API_TIME_CURRBUSI_MNTHS, apiTimeCurrbusiMnths
		);
	}
	
	public List<AlsProviderInfo> findByApiSecoffLastNm(Object apiSecoffLastNm
	) {
		return findByProperty(API_SECOFF_LAST_NM, apiSecoffLastNm
		);
	}
	
	public List<AlsProviderInfo> findByApiSecoffFirstNm(Object apiSecoffFirstNm
	) {
		return findByProperty(API_SECOFF_FIRST_NM, apiSecoffFirstNm
		);
	}
	
	public List<AlsProviderInfo> findByApiSecoffMidInit(Object apiSecoffMidInit
	) {
		return findByProperty(API_SECOFF_MID_INIT, apiSecoffMidInit
		);
	}
	
	public List<AlsProviderInfo> findByAcdCcNo(Object acdCcNo
	) {
		return findByProperty(ACD_CC_NO, acdCcNo
		);
	}
	
	public List<AlsProviderInfo> findByApiDesiredNodevices(Object apiDesiredNodevices
	) {
		return findByProperty(API_DESIRED_NODEVICES, apiDesiredNodevices
		);
	}
	
	public List<AlsProviderInfo> findByApiDevicesApproved(Object apiDevicesApproved
	) {
		return findByProperty(API_DEVICES_APPROVED, apiDevicesApproved
		);
	}
	
	public List<AlsProviderInfo> findByApiFeeExempted(Object apiFeeExempted
	) {
		return findByProperty(API_FEE_EXEMPTED, apiFeeExempted
		);
	}
	
	public List<AlsProviderInfo> findByApiCommissionYn(Object apiCommissionYn
	) {
		return findByProperty(API_COMMISSION_YN, apiCommissionYn
		);
	}
	
	public List<AlsProviderInfo> findByApiSecurityRequired(Object apiSecurityRequired
	) {
		return findByProperty(API_SECURITY_REQUIRED, apiSecurityRequired
		);
	}
	
	public List<AlsProviderInfo> findByApiDesig(Object apiDesig
	) {
		return findByProperty(API_DESIG, apiDesig
		);
	}
	
	public List<AlsProviderInfo> findByApiAllowSecProv(Object apiAllowSecProv
	) {
		return findByProperty(API_ALLOW_SEC_PROV, apiAllowSecProv
		);
	}
	
	public List<AlsProviderInfo> findByApiWhoLog(Object apiWhoLog
	) {
		return findByProperty(API_WHO_LOG, apiWhoLog
		);
	}
	
	public List<AlsProviderInfo> findByApiCommissionSi(Object apiCommissionSi
	) {
		return findByProperty(API_COMMISSION_SI, apiCommissionSi
		);
	}
	
	public List<AlsProviderInfo> findByApiSessCommAmount(Object apiSessCommAmount
	) {
		return findByProperty(API_SESS_COMM_AMOUNT, apiSessCommAmount
		);
	}
	
	public List<AlsProviderInfo> findByApiSslFlag(Object apiSslFlag
	) {
		return findByProperty(API_SSL_FLAG, apiSslFlag
		);
	}
	
	public List<AlsProviderInfo> findByAtiTribeCd(Object atiTribeCd
	) {
		return findByProperty(ATI_TRIBE_CD, atiTribeCd
		);
	}
	
	public List<AlsProviderInfo> findByApiMixSessCommAmt(Object apiMixSessCommAmt
	) {
		return findByProperty(API_MIX_SESS_COMM_AMT, apiMixSessCommAmt
		);
	}
	
	public List<AlsProviderInfo> findByApiSpSessCommAmt(Object apiSpSessCommAmt
	) {
		return findByProperty(API_SP_SESS_COMM_AMT, apiSpSessCommAmt
		);
	}
	
	public List<AlsProviderInfo> findByApiAlxProvInd(Object apiAlxProvInd
	) {
		return findByProperty(API_ALX_PROV_IND, apiAlxProvInd
		);
	}
	
	public List<AlsProviderInfo> findByApiPrimaryProviderNo(Object apiPrimaryProviderNo
	) {
		return findByProperty(API_PRIMARY_PROVIDER_NO, apiPrimaryProviderNo
		);
	}
	
	public List<AlsProviderInfo> findByApiSpecDevConfig(Object apiSpecDevConfig
	) {
		return findByProperty(API_SPEC_DEV_CONFIG, apiSpecDevConfig
		);
	}
	
	public List<AlsProviderInfo> findByApiSpecConfigInd(Object apiSpecConfigInd
	) {
		return findByProperty(API_SPEC_CONFIG_IND, apiSpecConfigInd
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsProviderInfo instances");
		try {
			String queryString = "from AlsProviderInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsProviderInfo merge(AlsProviderInfo detachedInstance) {
        log.debug("merging AlsProviderInfo instance");
        try {
            AlsProviderInfo result = (AlsProviderInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsProviderInfo instance) {
        log.debug("attaching dirty AlsProviderInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsProviderInfo instance) {
        log.debug("attaching clean AlsProviderInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}