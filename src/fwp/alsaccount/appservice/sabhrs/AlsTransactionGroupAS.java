package fwp.alsaccount.appservice.sabhrs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.sabhrs.AlsTransactionGroup;
import fwp.alsaccount.dao.sabhrs.AlsTransactionGroupDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsTransactionGroupAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsTransactionGroupDAO.class);
	
	/**
	 * returns a list of AlsTransactionGroup filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsTransactionGroup instances by where filter");
		try {
			String queryString = " from AlsTransactionGroup";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsTransactionGroup findById(Integer id){
		AlsTransactionGroupDAO dao = new AlsTransactionGroupDAO();
		
		AlsTransactionGroup code;
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
	 * Saves any AlsTransactionGroup using the merge function
	 * @param AlsTransactionGroup
	 */
	public void save(AlsTransactionGroup tmp){
		log.debug("saving AlsTransactionGroup");
		Transaction tx = null;
		AlsTransactionGroupDAO dao = new AlsTransactionGroupDAO();
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
	 * delete an existing AlsTransactionGroup
	 * @param AlsTransactionGroup
	 */
	public void delete(AlsTransactionGroup AlsTransactionGroup){
		log.debug("deleting AlsTransactionGroup");
		Transaction tx = null;
		AlsTransactionGroupDAO dao = new AlsTransactionGroupDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsTransactionGroup);
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
	 * returns a list of AlsTransactionGroup filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<String> findAllAccountControlCodes(String filter) {
		log.debug("finding all AlsTransactionGroup instances by where filter");
		
		List<String> retLst = new ArrayList<String>();
		
		try {
			String queryString = "SELECT DISTINCT aacc.idPk.aaccAccCd from AlsTransactionGroup aacc";
			
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
