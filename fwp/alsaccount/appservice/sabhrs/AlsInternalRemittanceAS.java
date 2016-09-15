package fwp.alsaccount.appservice.sabhrs;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





import fwp.als.hibernate.inventory.dao.AlsInternalRemittance;
import fwp.als.hibernate.inventory.dao.AlsInternalRemittanceDAO;
import fwp.als.hibernate.inventory.dao.AlsInternalRemittanceIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsInternalRemittanceAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsInternalRemittanceDAO.class);
	
	/**
	 * returns a list of AlsInternalRemittance filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsInternalRemittance instances by where filter");
		try {
			String queryString = " from AlsInternalRemittance";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsInternalRemittance findById(AlsInternalRemittanceIdPk id){
		AlsInternalRemittanceDAO dao = new AlsInternalRemittanceDAO();
		
		AlsInternalRemittance code;
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
	 * Saves any AlsInternalRemittance using the merge function
	 * @param AlsInternalRemittance
	 */
	public void save(AlsInternalRemittance tmp){
		log.debug("saving AlsInternalRemittance");
		Transaction tx = null;
		AlsInternalRemittanceDAO dao = new AlsInternalRemittanceDAO();
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
	 * delete an existing AlsInternalRemittance
	 * @param AlsInternalRemittance
	 */
	public void delete(AlsInternalRemittance AlsInternalRemittance){
		log.debug("deleting AlsInternalRemittance");
		Transaction tx = null;
		AlsInternalRemittanceDAO dao = new AlsInternalRemittanceDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsInternalRemittance);
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
