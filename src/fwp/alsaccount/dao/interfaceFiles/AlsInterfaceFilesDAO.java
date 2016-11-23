package fwp.alsaccount.dao.interfaceFiles;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 	* A data access object (DAO) providing persistence and search support for AlsInterfaceFiles entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see fwp.alsaccount.dao.interfaceFiles.AlsInterfaceFiles
  * @author MyEclipse Persistence Tools 
 */
public class AlsInterfaceFilesDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AlsInterfaceFilesDAO.class);
		//property constants
	public static final String AIF_CREATE_PERSONID = "aifCreatePersonid";
	public static final String AIF_MOD_PERSONID = "aifModPersonid";
	public static final String AIF_AWGC_ID = "aifAwgcId";
	public static final String AIF_FILE_NAME = "aifFileName";
	public static final String AIF_PARENT_PROCESS = "aifParentProcess";
	public static final String AIF_FILE_SENT = "aifFileSent";
	public static final String AIF_FILE = "aifFile";
	public static final String AIF_ORIGFILE_ID = "aifOrigfileId";
	public static final String AIF_NOTES = "aifNotes";
	public static final String AIF_SEND_FLAG = "aifSendFlag";



    
    public void save(AlsInterfaceFiles transientInstance) {
        log.debug("saving AlsInterfaceFiles instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AlsInterfaceFiles persistentInstance) {
        log.debug("deleting AlsInterfaceFiles instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AlsInterfaceFiles findById( Integer id) {
        log.debug("getting AlsInterfaceFiles instance with id: " + id);
        try {
            AlsInterfaceFiles instance = (AlsInterfaceFiles) getSession()
                    .get("fwp.alsaccount.dao.interfaceFiles.AlsInterfaceFiles", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AlsInterfaceFiles> findByExample(AlsInterfaceFiles instance) {
        log.debug("finding AlsInterfaceFiles instance by example");
        try {
            List<AlsInterfaceFiles> results = (List<AlsInterfaceFiles>) getSession()
                    .createCriteria("fwp.alsaccount.dao.interfaceFiles.AlsInterfaceFiles")
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
      log.debug("finding AlsInterfaceFiles instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AlsInterfaceFiles as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AlsInterfaceFiles> findByAifCreatePersonid(Object aifCreatePersonid
	) {
		return findByProperty(AIF_CREATE_PERSONID, aifCreatePersonid
		);
	}
	
	public List<AlsInterfaceFiles> findByAifModPersonid(Object aifModPersonid
	) {
		return findByProperty(AIF_MOD_PERSONID, aifModPersonid
		);
	}
	
	public List<AlsInterfaceFiles> findByAifAwgcId(Object aifAwgcId
	) {
		return findByProperty(AIF_AWGC_ID, aifAwgcId
		);
	}
	
	public List<AlsInterfaceFiles> findByAifFileName(Object aifFileName
	) {
		return findByProperty(AIF_FILE_NAME, aifFileName
		);
	}
	
	public List<AlsInterfaceFiles> findByAifParentProcess(Object aifParentProcess
	) {
		return findByProperty(AIF_PARENT_PROCESS, aifParentProcess
		);
	}
	
	public List<AlsInterfaceFiles> findByAifFileSent(Object aifFileSent
	) {
		return findByProperty(AIF_FILE_SENT, aifFileSent
		);
	}
	
	public List<AlsInterfaceFiles> findByAifFile(Object aifFile
	) {
		return findByProperty(AIF_FILE, aifFile
		);
	}
	
	public List<AlsInterfaceFiles> findByAifOrigfileId(Object aifOrigfileId
	) {
		return findByProperty(AIF_ORIGFILE_ID, aifOrigfileId
		);
	}
	
	public List<AlsInterfaceFiles> findByAifNotes(Object aifNotes
	) {
		return findByProperty(AIF_NOTES, aifNotes
		);
	}
	
	public List<AlsInterfaceFiles> findByAifSendFlag(Object aifSendFlag
	) {
		return findByProperty(AIF_SEND_FLAG, aifSendFlag
		);
	}
	

	public List findAll() {
		log.debug("finding all AlsInterfaceFiles instances");
		try {
			String queryString = "from AlsInterfaceFiles";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AlsInterfaceFiles merge(AlsInterfaceFiles detachedInstance) {
        log.debug("merging AlsInterfaceFiles instance");
        try {
            AlsInterfaceFiles result = (AlsInterfaceFiles) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AlsInterfaceFiles instance) {
        log.debug("attaching dirty AlsInterfaceFiles instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AlsInterfaceFiles instance) {
        log.debug("attaching clean AlsInterfaceFiles instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}