package fwp.alsaccount.appservice.sabhrs;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.sabhrs.AlsTransactionGrpStatus;
import fwp.alsaccount.dao.sabhrs.AlsTransactionGrpStatusDAO;
import fwp.alsaccount.dao.sabhrs.AlsTransactionGrpStatusIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsTransactionGrpStatusAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsTransactionGrpStatusDAO.class);
	
	/**
	 * returns a list of AlsTransactionGrpStatus filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsTransactionGrpStatus instances by where filter");
		try {
			String queryString = " from AlsTransactionGrpStatus";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsTransactionGrpStatus findById(AlsTransactionGrpStatusIdPk idPk){
		AlsTransactionGrpStatusDAO dao = new AlsTransactionGrpStatusDAO();
		
		AlsTransactionGrpStatus code;
		try {
			code = dao.findById(idPk);
		} catch (RuntimeException re) {	
			throw re;	
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return code;
	}
	
	/**
	 * Saves any AlsTransactionGrpStatus using the merge function
	 * @param AlsTransactionGrpStatus
	 */
	public void save(AlsTransactionGrpStatus tmp){
		log.debug("saving AlsTransactionGrpStatus");
		Transaction tx = null;
		AlsTransactionGrpStatusDAO dao = new AlsTransactionGrpStatusDAO();
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
	 * delete an existing AlsTransactionGrpStatus
	 * @param AlsTransactionGrpStatus
	 */
	public void delete(AlsTransactionGrpStatus AlsTransactionGrpStatus){
		log.debug("deleting AlsTransactionGrpStatus");
		Transaction tx = null;
		AlsTransactionGrpStatusDAO dao = new AlsTransactionGrpStatusDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsTransactionGrpStatus);
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
	 * This method returns System Activity Type Codes Desc
	 * @param sysActivityType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getTransDesc(Integer transCd) {
		String rtn = "";

		String where = "SELECT ATG_TRANSACTION_DESC "
					 + "FROM ALS.ALS_TRANSACTION_GROUP "
					 + "WHERE ATG_TRANSACTION_CD = "+transCd;
		
		try {
			Query query = HibernateSessionFactory.getSession().createSQLQuery(where);
			List<String> descList = query.list();
			if (descList != null && !descList.isEmpty()) {
				rtn = descList.get(0);
			} 
		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return rtn;
	}
	
}
