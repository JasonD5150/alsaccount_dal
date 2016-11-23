package fwp.alsaccount.dao.refund;

import fwp.alsaccount.hibernate.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for AlsWarrantStatus entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.refund.AlsWarrantStatus
  * @author MyEclipse Persistence Tools 
 */
public class AlsWarrantStatusDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsWarrantStatusDAO.class);
		//property constants
	public static final String AWS_RSAM_CODE = "awsRsamCode";
	public static final String AWS_WARRANT_TYPE = "awsWarrantType";
	public static final String AWS_PAYMENT_ID = "awsPaymentId";
	public static final String AWS_PAYMENT_STATUS = "awsPaymentStatus";
	public static final String AWS_CANCEL_ACTION = "awsCancelAction";
	public static final String AWS_RECON_STATUS = "awsReconStatus";
	public static final String AWS_STALEDATE_STATUS = "awsStaledateStatus";
	public static final String AWS_PAID_AMOUNT = "awsPaidAmount";
	public static final String AWS_TRANS_REF_NO = "awsTransRefNo";
	public static final String AWS_PAYMENT_METHOD = "awsPaymentMethod";
	public static final String AWS_VENDOR_ID = "awsVendorId";
	public static final String AWS_VOUCHER_ID = "awsVoucherId";
	public static final String AWS_AP_BUSINESS_UNIT = "awsApBusinessUnit";
	public static final String AWS_PAYMENT_GROSS_AMOUNT = "awsPaymentGrossAmount";
	public static final String AWS_PREVIOUS_PAYMENT_ID = "awsPreviousPaymentId";
	public static final String AWS_COMMENT = "awsComment";



    
    public void save(AlsWarrantStatus transientInstance) {
        log.debug("saving AlsWarrantStatus instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsWarrantStatus persistentInstance) {
        log.debug("deleting AlsWarrantStatus instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsWarrantStatus findById( Integer id) {
        log.debug("getting AlsWarrantStatus instance with id: " + id);
        try {
            AlsWarrantStatus instance = (AlsWarrantStatus) getSession()
                    .get("fwp.alsaccount.dao.refund.AlsWarrantStatus", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsWarrantStatus> findByExample(AlsWarrantStatus instance) {
        log.debug("finding AlsWarrantStatus instance by example");
        try {
            List<AlsWarrantStatus> results = (List<AlsWarrantStatus>) getSession()
                    .createCriteria("fwp.alsaccount.dao.refund.AlsWarrantStatus")
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
      log.debug("finding AlsWarrantStatus instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsWarrantStatus as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsWarrantStatus> findByAwsRsamCode(Object awsRsamCode
	) {
		return findByProperty(AWS_RSAM_CODE, awsRsamCode
		);
	}
	
	public List<AlsWarrantStatus> findByAwsWarrantType(Object awsWarrantType
	) {
		return findByProperty(AWS_WARRANT_TYPE, awsWarrantType
		);
	}
	
	public List<AlsWarrantStatus> findByAwsPaymentId(Object awsPaymentId
	) {
		return findByProperty(AWS_PAYMENT_ID, awsPaymentId
		);
	}
	
	public List<AlsWarrantStatus> findByAwsPaymentStatus(Object awsPaymentStatus
	) {
		return findByProperty(AWS_PAYMENT_STATUS, awsPaymentStatus
		);
	}
	
	public List<AlsWarrantStatus> findByAwsCancelAction(Object awsCancelAction
	) {
		return findByProperty(AWS_CANCEL_ACTION, awsCancelAction
		);
	}
	
	public List<AlsWarrantStatus> findByAwsReconStatus(Object awsReconStatus
	) {
		return findByProperty(AWS_RECON_STATUS, awsReconStatus
		);
	}
	
	public List<AlsWarrantStatus> findByAwsStaledateStatus(Object awsStaledateStatus
	) {
		return findByProperty(AWS_STALEDATE_STATUS, awsStaledateStatus
		);
	}
	
	public List<AlsWarrantStatus> findByAwsPaidAmount(Object awsPaidAmount
	) {
		return findByProperty(AWS_PAID_AMOUNT, awsPaidAmount
		);
	}
	
	public List<AlsWarrantStatus> findByAwsTransRefNo(Object awsTransRefNo
	) {
		return findByProperty(AWS_TRANS_REF_NO, awsTransRefNo
		);
	}
	
	public List<AlsWarrantStatus> findByAwsPaymentMethod(Object awsPaymentMethod
	) {
		return findByProperty(AWS_PAYMENT_METHOD, awsPaymentMethod
		);
	}
	
	public List<AlsWarrantStatus> findByAwsVendorId(Object awsVendorId
	) {
		return findByProperty(AWS_VENDOR_ID, awsVendorId
		);
	}
	
	public List<AlsWarrantStatus> findByAwsVoucherId(Object awsVoucherId
	) {
		return findByProperty(AWS_VOUCHER_ID, awsVoucherId
		);
	}
	
	public List<AlsWarrantStatus> findByAwsApBusinessUnit(Object awsApBusinessUnit
	) {
		return findByProperty(AWS_AP_BUSINESS_UNIT, awsApBusinessUnit
		);
	}
	
	public List<AlsWarrantStatus> findByAwsPaymentGrossAmount(Object awsPaymentGrossAmount
	) {
		return findByProperty(AWS_PAYMENT_GROSS_AMOUNT, awsPaymentGrossAmount
		);
	}
	
	public List<AlsWarrantStatus> findByAwsPreviousPaymentId(Object awsPreviousPaymentId
	) {
		return findByProperty(AWS_PREVIOUS_PAYMENT_ID, awsPreviousPaymentId
		);
	}
	
	public List<AlsWarrantStatus> findByAwsComment(Object awsComment
	) {
		return findByProperty(AWS_COMMENT, awsComment
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsWarrantStatus instances");
		try {
			String queryString = "from AlsWarrantStatus";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsWarrantStatus merge(AlsWarrantStatus detachedInstance) {
        log.debug("merging AlsWarrantStatus instance");
        try {
            AlsWarrantStatus result = (AlsWarrantStatus) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsWarrantStatus instance) {
        log.debug("attaching dirty AlsWarrantStatus instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsWarrantStatus instance) {
        log.debug("attaching clean AlsWarrantStatus instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}