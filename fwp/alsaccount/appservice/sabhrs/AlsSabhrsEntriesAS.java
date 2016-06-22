package fwp.alsaccount.appservice.sabhrs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries;
import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesDAO;
import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsSabhrsEntriesAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsSabhrsEntriesDAO.class);
	
	/**
	 * returns a list of AlsSabhrsEntries filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsSabhrsEntries instances by where filter");
		try {
			String queryString = " from AlsSabhrsEntries";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsSabhrsEntries findById(AlsSabhrsEntriesIdPk id){
		AlsSabhrsEntriesDAO dao = new AlsSabhrsEntriesDAO();
		
		AlsSabhrsEntries code;
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
	 * Saves any AlsSabhrsEntries using the merge function
	 * @param AlsSabhrsEntries
	 */
	public void save(AlsSabhrsEntries tmp){
		log.debug("saving AlsSabhrsEntries");
		Transaction tx = null;
		AlsSabhrsEntriesDAO dao = new AlsSabhrsEntriesDAO();
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
	 * delete an existing AlsSabhrsEntries
	 * @param AlsSabhrsEntries
	 */
	public void delete(AlsSabhrsEntries AlsSabhrsEntries){
		log.debug("deleting AlsSabhrsEntries");
		Transaction tx = null;
		AlsSabhrsEntriesDAO dao = new AlsSabhrsEntriesDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsSabhrsEntries);
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
	 * returns a list of AlsSabhrsEntries filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<String> findAllAccountControlCodes(String filter) {
		log.debug("finding all AlsSabhrsEntries instances by where filter");
		
		List<String> retLst = new ArrayList<String>();
		
		try {
			String queryString = "SELECT DISTINCT aacc.idPk.aaccAccCd from AlsSabhrsEntries aacc";
			
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + filter);
			List<String> aaccAccCdLst = (List<String>)queryObject.list();
			
			if (aaccAccCdLst != null && !aaccAccCdLst.isEmpty()) {
				retLst.addAll(aaccAccCdLst);
			}
			
		} catch (RuntimeException re) {
			log.error("findAllAccountControlCodes failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retLst;
	}
	
	/**
	 * This method gets the next available seq no.
	 * @return
	 */
	public Integer getNextSeqNo() {
		Integer retSeqNo = 0;

		String queryString = "SELECT MAX(atg_transaction_cd)+1 seq FROM ALS.ALS_TRANSACTION_GROUP";

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
	
	/**
	 * This method checks to see if the Transaction Group has a corresponding record in ALS_TRANSACTION_GRP_STATUS
	 * @return
	 */
	public Boolean getTransGroupDtlsExists(String id) {
		Boolean rtn = false;
		Integer count = 0;

		String queryString = "SELECT COUNT(1) count FROM ALS.ALS_TRANSACTION_GRP_STATUS "
						   + "WHERE ATG_TRANSACTION_CD="+id;

		try {
			Query query = HibernateSessionFactory.getSession()
					.createSQLQuery(queryString)
					.addScalar("count", IntegerType.INSTANCE);
		
			count = (Integer) query.uniqueResult();
			if(count>0){
				rtn = true;
			}
		} catch (RuntimeException re) {
			System.out.println(re.toString());
		}
		
		finally {
			HibernateSessionFactory.getSession().close();
		}

		return rtn;
	}

}
