package fwp.alsaccount.appservice.admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsAccCdControl;
import fwp.alsaccount.dao.admin.AlsOrgControl;
import fwp.alsaccount.dao.admin.AlsOrgControlDAO;
import fwp.alsaccount.dao.admin.AlsOrgControlIdPk;
import fwp.alsaccount.dao.admin.AlsProviderInfo;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author c81203
 * 
 */
public class AlsOrgControlAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsOrgControlDAO.class);
	
	/**
	 * returns a list of AlsOrgControl filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsOrgControl instances by where filter");
		try {
			String queryString = " from AlsOrgControl";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsOrgControl findById(AlsOrgControlIdPk idPk){
		AlsOrgControlDAO dao = new AlsOrgControlDAO();
		
		AlsOrgControl code;
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
	 * Saves any AlsOrgControl using the merge function
	 * @param AlsOrgControl
	 */
	public void save(AlsOrgControl tmp){
		log.debug("saving AlsOrgControl");
		Transaction tx = null;
		AlsOrgControlDAO dao = new AlsOrgControlDAO();
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
	 * delete an existing AlsOrgControl
	 * @param AlsOrgControl
	 */
	public void delete(AlsOrgControl AlsOrgControl){
		log.debug("deleting AlsOrgControl");
		Transaction tx = null;
		AlsOrgControlDAO dao = new AlsOrgControlDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsOrgControl);
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
	 * returns a list of AlsOrgControl filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<String> findAllAccountControlCodes(String filter) {
		log.debug("finding all AlsOrgControl instances by where filter");
		
		List<String> retLst = new ArrayList<String>();
		
		try {
			String queryString = "SELECT DISTINCT aacc.idPk.aaccAccCd from AlsOrgControl aacc";
			
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
	 * This method checks for duplicate entries.
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isDuplicateEntry(AlsOrgControlIdPk idPk) {
		
		Boolean retVal = false;
		
		try {
			AlsOrgControl aoc = this.findById(idPk);
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
	 * This method checks for valid provider number.
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isValidProvider(Integer apiProviderNo) {
		
		Boolean retVal = false;
		AlsProviderInfoAS apiAS = new AlsProviderInfoAS();
		
		try {
			AlsProviderInfo api = apiAS.findById(apiProviderNo);
			if(api != null){
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
	 * This method checks for valid Budget Year and Account Code
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isValidBudgYearAccCd(Integer budgetYear, String accCd) {
		
		Boolean retVal = false;
		AlsAccCdControlAS aaccAS = new AlsAccCdControlAS();
		String where = " WHERE idPk.asacBudgetYear = "+budgetYear
				  +" AND idPk.aaccAccCd = "+accCd;
		
		try {
			List<AlsAccCdControl> aaccLst = aaccAS.findAllByWhere(where);
			if(!aaccLst.isEmpty()){
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
	 * This method checks if Account Code, Provider, and Org are already used for the given budget year.
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isDuplicateAccCdProviderOrg(AlsOrgControlIdPk idPk, Integer org) {
		Boolean retVal = false;
		String where = " WHERE idPk.asacBudgetYear = "+idPk.getAsacBudgetYear()
				  	  +" AND idPk.aaccAccCd = "+idPk.getAaccAccCd()
				  	  +" AND idPk.apiProviderNo = "+idPk.getApiProviderNo()
				  	  +" AND aocOrg = "+org;
		
		try {
			List<AlsOrgControl> aoc = this.findAllByWhere(where);
			if(!aoc.isEmpty()){
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
