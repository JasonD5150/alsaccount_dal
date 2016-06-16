package fwp.alsaccount.appservice.admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsAccCdControl;
import fwp.alsaccount.dao.admin.AlsAccountMaster;
import fwp.alsaccount.dao.admin.AlsAccountMasterDAO;
import fwp.alsaccount.dao.admin.AlsAccountMasterIdPk;
import fwp.alsaccount.dao.admin.AlsSysActivityControl;
import fwp.alsaccount.dto.admin.AlsAccountMasterDTO;
import fwp.alsaccount.dto.admin.AlsSysActivityControlDTO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author c81203
 * 
 */
public class AlsAccountMasterAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsAccountMasterDAO.class);
	
	/**
	 * returns a list of AlsAccountMaster filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsAccountMaster instances by where filter");
		try {
			String queryString = " from AlsAccountMaster";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsAccountMaster findById(AlsAccountMasterIdPk idPk){
		AlsAccountMasterDAO dao = new AlsAccountMasterDAO();
		
		AlsAccountMaster code;
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
	 * Saves any AlsAccountMaster using the merge function
	 * @param AlsAccountMaster
	 */
	public void save(AlsAccountMaster tmp){
		log.debug("saving AlsAccountMaster");
		Transaction tx = null;
		AlsAccountMasterDAO dao = new AlsAccountMasterDAO();
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
	 * delete an existing AlsAccountMaster
	 * @param AlsAccountMaster
	 */
	public void delete(AlsAccountMaster AlsAccountMaster){
		log.debug("deleting AlsAccountMaster");
		Transaction tx = null;
		AlsAccountMasterDAO dao = new AlsAccountMasterDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsAccountMaster);
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
	 * returns a list of AlsAccountMaster filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<String> findAllAccountControlCodes(String filter) {
		log.debug("finding all AlsAccountMaster instances by where filter");
		
		List<String> retLst = new ArrayList<String>();
		
		try {
			String queryString = "SELECT DISTINCT aacc.idPk.aaccAccCd from AlsAccountMaster aacc";
			
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
	
	@SuppressWarnings("unchecked")
	public Boolean isBudgYearAccUsed(Integer asacBudgetYear, String aamAccount) {
		
		Boolean retVal = false;
		
		try {
			String where = "SELECT *"
						+ " FROM ALS.ALS_SABHRS_ENTRIES"
						+ " WHERE ASAC_BUDGET_YEAR =" + asacBudgetYear
						+ " AND AAM_ACCOUNT ='" + aamAccount + "'";

			Query query = HibernateSessionFactory.getSession().createSQLQuery(where);
			List aseLst = query.list();
			
			where = "SELECT *"
					+ " FROM ALS.ALS_REFUND_SUMMARY"
					+ " WHERE ASAC_BUDGET_YEAR =" + asacBudgetYear
					+ " AND AAM_ACCOUNT ='" + aamAccount + "'";

			query = HibernateSessionFactory.getSession().createSQLQuery(where);
			List afsLst = query.list();

			where = "SELECT *"
					+ " FROM ALS.ALS_SABHRS_ENTRIES_SUMMARY"
					+ " WHERE ASAC_BUDGET_YEAR =" + asacBudgetYear
					+ " AND AAM_ACCOUNT ='" + aamAccount + "'";

			query = HibernateSessionFactory.getSession().createSQLQuery(where);
			List asesLst = query.list();

			if(!aseLst.isEmpty()){
				retVal = true;
			}else if(!afsLst.isEmpty()){
				retVal = true;
			}else if(!asesLst.isEmpty()){
				retVal = true;
			}
			
		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}

}
