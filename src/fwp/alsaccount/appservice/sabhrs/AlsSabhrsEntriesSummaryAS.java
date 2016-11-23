package fwp.alsaccount.appservice.sabhrs;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesSummary;
import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesSummaryDAO;
import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesSummaryIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsSabhrsEntriesSummaryAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsSabhrsEntriesSummaryDAO.class);
	
	/**
	 * returns a list of AlsSabhrsEntriesSummary filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsSabhrsEntriesSummary instances by where filter");
		try {
			String queryString = " from AlsSabhrsEntriesSummary";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsSabhrsEntriesSummary findById(AlsSabhrsEntriesSummaryIdPk id){
		AlsSabhrsEntriesSummaryDAO dao = new AlsSabhrsEntriesSummaryDAO();
		
		AlsSabhrsEntriesSummary code;
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
	 * Saves any AlsSabhrsEntriesSummary using the merge function
	 * @param AlsSabhrsEntriesSummary
	 */
	public void save(AlsSabhrsEntriesSummary tmp){
		log.debug("saving AlsSabhrsEntriesSummary");
		Transaction tx = null;
		AlsSabhrsEntriesSummaryDAO dao = new AlsSabhrsEntriesSummaryDAO();
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
	 * delete an existing AlsSabhrsEntriesSummary
	 * @param AlsSabhrsEntriesSummary
	 */
	public void delete(AlsSabhrsEntriesSummary AlsSabhrsEntriesSummary){
		log.debug("deleting AlsSabhrsEntriesSummary");
		Transaction tx = null;
		AlsSabhrsEntriesSummaryDAO dao = new AlsSabhrsEntriesSummaryDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsSabhrsEntriesSummary);
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
