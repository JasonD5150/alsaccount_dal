package fwp.alsaccount.appservice.sabhrs;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.hibernate.inventory.dao.AlsNonAlsDetailsIdPk;
import fwp.alsaccount.dao.sabhrs.AlsOverUnderSalesDets;
import fwp.alsaccount.dao.sabhrs.AlsOverUnderSalesDetsDAO;
import fwp.alsaccount.dao.sabhrs.AlsOverUnderSalesDetsIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author c81203
 * 
 */
public class AlsOverUnderSalesDetsAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsOverUnderSalesDetsDAO.class);
	
	/**
	 * returns a list of AlsOverUnderSalesDets filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsOverUnderSalesDets instances by where filter");
		try {
			String queryString = " from AlsOverUnderSalesDets";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsOverUnderSalesDets findById(AlsOverUnderSalesDetsIdPk idPk){
		AlsOverUnderSalesDetsDAO dao = new AlsOverUnderSalesDetsDAO();
		
		AlsOverUnderSalesDets code;
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
	 * Saves any AlsOverUnderSalesDets using the merge function
	 * @param AlsOverUnderSalesDets
	 */
	public void save(AlsOverUnderSalesDets tmp){
		log.debug("saving AlsOverUnderSalesDets");
		Transaction tx = null;
		AlsOverUnderSalesDetsDAO dao = new AlsOverUnderSalesDetsDAO();
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
	 * delete an existing AlsOverUnderSalesDets
	 * @param AlsOverUnderSalesDets
	 */
	public void delete(AlsOverUnderSalesDets AlsOverUnderSalesDets){
		log.debug("deleting AlsOverUnderSalesDets");
		Transaction tx = null;
		AlsOverUnderSalesDetsDAO dao = new AlsOverUnderSalesDetsDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsOverUnderSalesDets);
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
	 * This method checks for duplicate entries.
	 * @param tmp
	 * @return
	 */
	public Boolean isDuplicateEntry(AlsOverUnderSalesDetsIdPk idPk) {
		
		Boolean retVal = false;
		
		try {
			AlsOverUnderSalesDets aoc = this.findById(idPk);
			if(aoc != null){
				retVal = true;
			}

		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}
	
	/**
	 * This method gets the next sequence number.
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer getNextSeqNo(AlsOverUnderSalesDetsIdPk idPk) {
		
		Integer retVal = 0;
		
		try {
			String queryString = " SELECT MAX(aousd.idPk.aousdSeqNo) " +
								 "   FROM AlsOverUnderSalesDets aousd " +
			                     "  WHERE aousd.idPk.apiProviderNo = :apiProviderNo " +
								 "    AND aousd.idPk.airBillingFrom = :airBillingFrom " +
								 "    AND aousd.idPk.airBillingTo = :airBillingTo ";

			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
			
			queryObject.setParameter("apiProviderNo", idPk.getApiProviderNo());
			queryObject.setParameter("airBillingFrom", idPk.getAirBillingFrom());
			queryObject.setParameter("airBillingTo", idPk.getAirBillingTo());
			
			List<Integer> anadList = (List<Integer>)queryObject.list();
			
			if (anadList != null && !anadList.isEmpty()) {
				if (anadList.get(0) != null) {
					retVal = anadList.get(0);
				}
			}
			
			retVal++;
		} catch (RuntimeException re) {	
			throw re;	
		}
		
		return retVal;
	}

	
}
