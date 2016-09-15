package fwp.alsaccount.appservice.sabhrs;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.sabhrs.AlsProviderRemittance;
import fwp.alsaccount.dao.sabhrs.AlsProviderRemittanceDAO;
import fwp.alsaccount.dao.sabhrs.AlsProviderRemittanceIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsProviderRemittanceAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsProviderRemittanceDAO.class);
	
	/**
	 * returns a list of AlsProviderRemittance filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsProviderRemittance instances by where filter");
		try {
			String queryString = " from AlsProviderRemittance";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsProviderRemittance findById(AlsProviderRemittanceIdPk id){
		AlsProviderRemittanceDAO dao = new AlsProviderRemittanceDAO();
		
		AlsProviderRemittance code;
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
	 * Saves any AlsProviderRemittance using the merge function
	 * @param AlsProviderRemittance
	 */
	public void save(AlsProviderRemittance tmp){
		log.debug("saving AlsProviderRemittance");
		Transaction tx = null;
		AlsProviderRemittanceDAO dao = new AlsProviderRemittanceDAO();
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
	 * delete an existing AlsProviderRemittance
	 * @param AlsProviderRemittance
	 */
	public void delete(AlsProviderRemittance AlsProviderRemittance){
		log.debug("deleting AlsProviderRemittance");
		Transaction tx = null;
		AlsProviderRemittanceDAO dao = new AlsProviderRemittanceDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsProviderRemittance);
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
	 * @return
	 */
	public Integer getNextSeqNo() {
		Integer retSeqNo = 0;

		String queryString = "SELECT ALS.ALS_SABHRS_ENTRIES_SEQ.NEXTVAL seq FROM DUAL";

		try {
			Query query = HibernateSessionFactory.getSession()
					.createSQLQuery(queryString)
					.addScalar("seq", IntegerType.INSTANCE);
		
			retSeqNo = (Integer) query.uniqueResult();
		} catch (RuntimeException re) {
			System.out.println(re.toString());
		}
		
		finally {
			HibernateSessionFactory.getSession().close();
		}

		return retSeqNo;
	}

}
