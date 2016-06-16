package fwp.alsaccount.appservice.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;











import fwp.alsaccount.dao.admin.AlsAccCdControl;
import fwp.alsaccount.dao.admin.AlsNonAlsOrgControl;
import fwp.alsaccount.dao.admin.AlsNonAlsOrgControlDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author c81203
 * 
 */
public class AlsNonAlsOrgControlAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsNonAlsOrgControlDAO.class);
	
	/**
	 * returns a list of AlsNonAlsOrgControl filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsNonAlsOrgControl instances by where filter");
		try {
			String queryString = " from AlsNonAlsOrgControl";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsNonAlsOrgControl findById(Integer id){
		AlsNonAlsOrgControlDAO dao = new AlsNonAlsOrgControlDAO();
		
		AlsNonAlsOrgControl code;
		try {
			code = dao.findById(id);
		} catch (RuntimeException re) {	
			throw re;	
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return code;
	}
	
	/**
	 * Saves any AlsNonAlsOrgControl using the merge function
	 * @param AlsNonAlsOrgControl
	 */
	public void save(AlsNonAlsOrgControl tmp){
		log.debug("saving AlsNonAlsOrgControl");
		Transaction tx = null;
		AlsNonAlsOrgControlDAO dao = new AlsNonAlsOrgControlDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.merge(tmp);
			tx.commit();			
		} catch (RuntimeException re) {
			tx.rollback();
			log.error("save failed", re);	
			throw re;			
		}finally{
			try{
				dao.getSession().close();
			}catch(Exception e){
			
			}
		}		
		return;
	}
	
	
	/**
	 * delete an existing AlsNonAlsOrgControl
	 * @param AlsNonAlsOrgControl
	 */
	public void delete(AlsNonAlsOrgControl AlsNonAlsOrgControl){
		log.debug("deleting AlsNonAlsOrgControl");
		Transaction tx = null;
		AlsNonAlsOrgControlDAO dao = new AlsNonAlsOrgControlDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsNonAlsOrgControl);
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			log.error("delete failed", re);	
			throw re;			
		}finally{
			try{
				dao.getSession().close();
			}catch(Exception e){
			
			}
		}
	}
	
	/**
	 * This method gets the next available seq no.
	 * @param year
	 * @param accCd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer getNextSeqNo() {
		Integer retVal = 0;
		
		try {
			String queryString = " SELECT NVL(MAX(anaoc_id), 0) + 1"+
								 " FROM AlsNonAlsOrgControl";

			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
			
			List<Integer> anaocList = (List<Integer>)queryObject.list();
			
			if (anaocList != null && !anaocList.isEmpty()) {
				if (anaocList.get(0) != null) {
					retVal = anaocList.get(0);
				}
			}
			
		} catch (RuntimeException re) {	
			throw re;	
		}
		
		return retVal;
	}

}
