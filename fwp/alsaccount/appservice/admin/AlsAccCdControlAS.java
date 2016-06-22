package fwp.alsaccount.appservice.admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsAccCdControl;
import fwp.alsaccount.dao.admin.AlsAccCdControlDAO;
import fwp.alsaccount.dao.admin.AlsAccCdControlIdPk;
import fwp.alsaccount.dao.admin.AlsOrgControl;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsAccCdControlAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsAccCdControlDAO.class);
	
	/**
	 * returns a list of AlsAccCdControl filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsAccCdControl instances by where filter");
		try {
			String queryString = " from AlsAccCdControl";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsAccCdControl findById(AlsAccCdControlIdPk idPk){
		AlsAccCdControlDAO dao = new AlsAccCdControlDAO();
		
		AlsAccCdControl code;
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
	 * Saves any AlsAccCdControl using the merge function
	 * @param AlsAccCdControl
	 */
	public void save(AlsAccCdControl tmp){
		log.debug("saving AlsAccCdControl");
		Transaction tx = null;
		AlsAccCdControlDAO dao = new AlsAccCdControlDAO();
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
	 * delete an existing AlsAccCdControl
	 * @param AlsAccCdControl
	 */
	public void delete(AlsAccCdControl AlsAccCdControl){
		log.debug("deleting AlsAccCdControl");
		Transaction tx = null;
		AlsAccCdControlDAO dao = new AlsAccCdControlDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsAccCdControl);
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
	 * Builds the tool tip text for the account drop-downs
	 * @param AlsAccCdControl
	 */
	@SuppressWarnings("unchecked")
	public String buildToolTipText(AlsAccCdControl aacc, String labelSeparator, String valSeparator) throws Exception {
		String toolTipText = "";
		String accountDescr = "";
		
		String qryStr = " SELECT aam.idPk.aamAccount || ' - ' || aam.aamAccountDesc " +
 						"   FROM AlsAccountMaster aam " +
 						"  WHERE aam.idPk.asacBudgetYear = :budgetYear" +
 						"    AND aam.idPk.aamAccount = :account"; 
 		
		try {
			
	 		Query qryObj = HibernateSessionFactory.getSession().createQuery(qryStr);
	 		qryObj.setParameter("budgetYear", aacc.getIdPk().getAsacBudgetYear());
	 		qryObj.setParameter("account", aacc.getAamAccount());
	 		
			List<String> qryLst = qryObj.list();
			if (qryLst != null && !qryLst.isEmpty()) {
				accountDescr = qryLst.get(0);					
			}
			
			toolTipText = aacc.getIdPk().getAaccAccCd() + valSeparator + accountDescr;
		} catch (Exception e) {
			throw new Exception(this.getClass().getName()+".buildToolTipText - "+e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
    	return toolTipText;
	}
	
	/**
	 * returns a list of AlsAccCdControl filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<String> findAllAccountControlCodes(String filter) {
		log.debug("finding all AlsAccCdControl instances by where filter");
		
		List<String> retLst = new ArrayList<String>();
		
		try {
			String queryString = "SELECT DISTINCT aacc.idPk.aaccAccCd from AlsAccCdControl aacc";
			
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
	 * @param idPk
	 * @return
	 */
	public Boolean isDuplicateEntry(AlsAccCdControlIdPk idPk) {
		
		Boolean retVal = false;
		
		try {
			AlsAccCdControl aacc = this.findById(idPk);
			if(aacc != null){
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
	 * This method checks for duplicate Budget year, Account code, Account, and Fund entries.
	 * @param year
	 * @param accCd
	 * @param acc
	 * @param fund
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isDuplicateBudgYearAccCdAccFund(Integer year, String accCd, String acc, String fund) {
		
		Boolean retVal = false;
		String where = " WHERE idPk.asacBudgetYear = "+year
				  +" AND idPk.aaccAccCd = '"+accCd+"'"
				  +" AND aamAccount = '"+acc+"'"
				  +" AND aaccFund = '"+fund+"'";
		
		
		try {
			List<AlsAccCdControl> aaccLst = this.findAllByWhere(where);
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
	 * This method checks to see if a entries has been made for the budget year and account code
	 * with a balancing amt flag set to yes.
	 * @param year
	 * @param accCd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isBalanceAmtFlagSet(Integer year, String accCd) {
		
		Boolean retVal = false;
		String where = " WHERE idPk.asacBudgetYear = "+year
				  +" AND idPk.aaccAccCd = "+accCd
				  +" AND aaccBalancingAmtFlag = 'Y'";
		
		try {
			List<AlsAccCdControl> aaccLst = this.findAllByWhere(where);
			
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
	 * This method checks to see if a entries has been made in ALS_ORG_CONTROL
	 * for this year and account code
	 * @param year
	 * @param accCd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isBudgYearAccCdUsed(Integer year, String accCd) {
		AlsOrgControlAS appSer = new AlsOrgControlAS();
		Boolean retVal = false;
		String where = " WHERE ASAC_BUDGET_YEAR = " + year
					+ " AND AACC_ACC_CD = '" + accCd + "'";

		
		try {
			List<AlsOrgControl> aocLst = appSer.findAllByWhere(where);
			
			if(!aocLst.isEmpty()){
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
	 * This method gets the next available seq no.
	 * @param year
	 * @param accCd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer getNextSeqNo(Integer year, String accCd) {
		Integer retSeqNo = 0;

		String where = " WHERE idPk.asacBudgetYear = "+year
				  +" AND idPk.aaccAccCd = "+accCd;
				
		
		try {
			List<AlsAccCdControl> tmpLst = this.findAllByWhere(where);
			
			if(!tmpLst.isEmpty()){
				AlsAccCdControl tmpAACC = tmpLst.get(tmpLst.size() - 1);
				retSeqNo = tmpAACC.getIdPk().getAaccSeqNo() + 1;
			}else{
				retSeqNo = 1;
			}

		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retSeqNo;
	}

}
