package fwp.alsaccount.appservice.sabhrs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.TimestampType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.hibernate.item.dao.AlsItemApplFeeAcctIdPk;
import fwp.alsaccount.dao.sabhrs.AlsProviderBankDetails;
import fwp.alsaccount.dao.sabhrs.AlsProviderBankDetailsDAO;
import fwp.alsaccount.dao.sabhrs.AlsProviderBankDetailsIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.alsaccount.hibernate.utils.DalUtils;

/**
 * @author cfa027
 * 
 */
public class AlsProviderBankDetailsAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsProviderBankDetailsDAO.class);
	
	/**
	 * returns a list of AlsProviderBankDetails filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsProviderBankDetails instances by where filter");
		try {
			String queryString = " from AlsProviderBankDetails";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsProviderBankDetails findById(AlsProviderBankDetailsIdPk id){
		AlsProviderBankDetailsDAO dao = new AlsProviderBankDetailsDAO();
		
		AlsProviderBankDetails code;
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
	 * Saves any AlsProviderBankDetails using the merge function
	 * @param AlsProviderBankDetails
	 */
	public void save(AlsProviderBankDetails tmp){
		log.debug("saving AlsProviderBankDetails");
		Transaction tx = null;
		AlsProviderBankDetailsDAO dao = new AlsProviderBankDetailsDAO();
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
	 * delete an existing AlsProviderBankDetails
	 * @param AlsProviderBankDetails
	 */
	public void delete(AlsProviderBankDetails AlsProviderBankDetails){
		log.debug("deleting AlsProviderBankDetails");
		Transaction tx = null;
		AlsProviderBankDetailsDAO dao = new AlsProviderBankDetailsDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsProviderBankDetails);
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

}
