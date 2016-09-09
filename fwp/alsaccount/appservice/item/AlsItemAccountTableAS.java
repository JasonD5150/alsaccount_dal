package fwp.alsaccount.appservice.item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.appservice.account.AlsAccCdControlAS;
import fwp.als.appservice.item.AlsPrerequisiteCdAS;
import fwp.als.dto.item.AlsItemAccountTableDTO;
import fwp.als.hibernate.HibernateSessionFactory;
import fwp.als.hibernate.account.dao.AlsAccCdControl;
import fwp.als.hibernate.item.dao.AlsItemAccountTable;
import fwp.als.hibernate.item.dao.AlsItemAccountTableDAO;
import fwp.als.hibernate.item.dao.AlsItemAccountTableIdPk;
import fwp.als.hibernate.item.dao.AlsItemResidencyIdPk;
import fwp.als.hibernate.item.dao.AlsPrerequisiteCd;
import fwp.als.hibernate.item.dao.AlsPrerequisiteCdDAO;
import fwp.alsaccount.hibernate.utils.DalUtils;

/**
 * @author c81203
 * 
 */
public class AlsItemAccountTableAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsItemAccountTableDAO.class);
	
	/**
	 * returns a list of AlsItemAccountTable filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsItemAccountTable instances by where filter");
		try {
			String queryString = " from AlsItemAccountTable";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsItemAccountTable findById(AlsItemAccountTableIdPk idPk){
		AlsItemAccountTableDAO dao = new AlsItemAccountTableDAO();
		
		AlsItemAccountTable air=null;
		try{
			air = dao.findById(idPk);
		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return air;
	}
	
	/**
	 * Saves any AlsItemAccountTable using the merge function
	 * @param AlsItemAccountTable
	 */
	public void save(AlsItemAccountTable tmp){
		log.debug("saving AlsItemAccountTable");
		Transaction tx = null;
		AlsItemAccountTableDAO dao = new AlsItemAccountTableDAO();
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
	 * delete an existing AlsItemAccountTable
	 * @param alsItemResidency
	 */
	public void delete(AlsItemAccountTable adc){
		log.debug("deleting AlsItemAccountTable");
		Transaction tx = null;
		AlsItemAccountTableDAO dao = new AlsItemAccountTableDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(adc);
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
	 * returns a list of AlsItemAccountTable filtered by input parameters
	 * @param aictUsagePeriodFrom
	 * @param aictUsagePeriodTo
	 * @param aictItemTypeCd
	 * 
	 * @return List<AlsItemAccountTableDTO>
	 */
	@SuppressWarnings("unchecked")
	public List<AlsItemAccountTableDTO> retrieveItemAccountTableDetails(AlsItemResidencyIdPk idPk, String filter, String sord) {
		log.debug("finding all AlsItemAccountTable instances by where filter");
		List<AlsItemAccountTableDTO> retList = new ArrayList<AlsItemAccountTableDTO>();
		
		try {
			String queryString = "SELECT aiat FROM AlsItemAccountTable aiat ";
			String whereClause = " WHERE aiat.idPk.aictUsagePeriodFrom = :periodFrom" + 
			                     "   AND aiat.idPk.aictUsagePeriodTo = :periodTo" + 
					             "   AND aiat.idPk.aictItemTypeCd = :itemType";
			
			if (idPk.getAirResidencyInd().equals("B")) {
				whereClause += "   AND aiat.idPk.aiatResidencyInd IN ('R','N','B')";
			} else {
				whereClause += "   AND aiat.idPk.aiatResidencyInd = :residencyInd";
			}		                     
			
			if (filter != null && !"".equals(filter)) {
				whereClause += filter;
			}
			
			String orderByClause = " ORDER BY aiat.idPk.asacBudgetYr " + sord + ", aiat.idPk.aiatResidencyInd, aiat.idPk.aictSeqNo";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString+whereClause+orderByClause);
			queryObject.setParameter("periodFrom", idPk.getAictUsagePeriodFrom());
			queryObject.setParameter("periodTo", idPk.getAictUsagePeriodTo());
			queryObject.setParameter("itemType", idPk.getAictItemTypeCd());
			
			if (!idPk.getAirResidencyInd().equals("B")) {
				queryObject.setParameter("residencyInd", idPk.getAirResidencyInd());
			}			                     

			List<AlsItemAccountTable> aiatList = queryObject.list();
			if (aiatList != null && !aiatList.isEmpty()) {				
				for (AlsItemAccountTable aiat : aiatList) {
					retList.add(fillAlsItemAccountTableDTO(aiat));
				}
			}
		} catch (RuntimeException re) {
			log.error("retrieveItemAccountTableDetails failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retList;
	}
	
	/**
	 * This method gets the next sequence number.
	 * @param tmp
	 * @return
	 */
	public Integer getNextSeqNo(AlsItemAccountTableIdPk idPk) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		Integer retVal = 0;
		Session session = HibernateSessionFactory.getSession();
		
		try {
			
			String filter = "AICT_USAGE_PERIOD_FROM = TO_DATE('" + sdf.format(idPk.getAictUsagePeriodFrom())  + "','MM/DD/YYYY') AND " +
			                "AICT_USAGE_PERIOD_TO = TO_DATE('" + sdf.format(idPk.getAictUsagePeriodTo())  + "','MM/DD/YYYY')  AND " +
					        "AICT_ITEM_TYPE_CD = '" + idPk.getAictItemTypeCd() + "' AND " +
					        "ASAC_BUDGET_YR = " + idPk.getAsacBudgetYr() + " AND " +
					        "AIAT_RESIDENCY_IND = '" + idPk.getAiatResidencyInd() + "'";
			
			DalUtils dalUtils = new DalUtils();
			retVal = dalUtils.getNextAvailableSequence("ALS_ITEM_ACCOUNT_TABLE", "AICT_SEQ_NO", filter, session);
			
		} catch (RuntimeException re) {	
			throw re;	
		}finally{			
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					
				}				
			}
		}

		return retVal;
	}
	
	/**
	 * This method checks for duplicate entries.
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isDuplicateEntry(AlsItemAccountTable tmp) {
		
		Boolean retVal = false;
		
		try {
			String queryString = "SELECT aiat FROM AlsItemAccountTable aiat ";
								 
			String whereClause = " WHERE aiat.idPk.aictUsagePeriodFrom = :usagePeriodFrom " +
					 "   AND aiat.idPk.aictUsagePeriodTo = :usagePeriodTo " +
					 "   AND aiat.idPk.aictItemTypeCd = :itemTypeCd " +
					 "   AND aiat.idPk.asacBudgetYr = :budgetYear " +
					 "   AND aiat.idPk.aiatResidencyInd = :residencyInd " +
					 "   AND aiat.aaccAccCd = :accountCode ";
			
			if (tmp.getIdPk().getAictSeqNo() != null) {
				whereClause +=  "   AND aiat.idPk.aictSeqNo <> :aictSeqNo ";
			}
			if (tmp.getApcPrerequisiteCd() != null) {
				whereClause +=  "   AND aiat.apcPrerequisiteCd = :prereqCd ";
			}
			
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString+whereClause);
			
			queryObject.setDate("usagePeriodFrom", tmp.getIdPk().getAictUsagePeriodFrom());
			queryObject.setDate("usagePeriodTo", tmp.getIdPk().getAictUsagePeriodTo());
			queryObject.setParameter("itemTypeCd", tmp.getIdPk().getAictItemTypeCd());
			queryObject.setParameter("budgetYear", tmp.getIdPk().getAsacBudgetYr());
			queryObject.setParameter("residencyInd", tmp.getIdPk().getAiatResidencyInd());
			
			if (tmp.getIdPk().getAictSeqNo() != null) {
				queryObject.setParameter("aictSeqNo", tmp.getIdPk().getAictSeqNo());
			}
			if (tmp.getApcPrerequisiteCd() != null) {
				queryObject.setParameter("prereqCd", tmp.getApcPrerequisiteCd());
			}
			
			queryObject.setParameter("accountCode", tmp.getAaccAccCd());
			
			List<AlsItemAccountTable> aiatList = (List<AlsItemAccountTable>)queryObject.list();
			
			if (aiatList != null && !aiatList.isEmpty()) {
				retVal = true;
			}

		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}
	
	@SuppressWarnings("unchecked")
	private AlsItemAccountTableDTO fillAlsItemAccountTableDTO(AlsItemAccountTable tmp) throws RuntimeException {
		
		AlsItemAccountTableDTO retObj = new AlsItemAccountTableDTO();
    	AlsPrerequisiteCdAS apcAS = new AlsPrerequisiteCdAS();
    	AlsPrerequisiteCdDAO apcDAO = new AlsPrerequisiteCdDAO();
    	AlsAccCdControlAS aaccAS = new AlsAccCdControlAS();
    	
		try {
			
			retObj.setIdPk(tmp.getIdPk());
			retObj.setAaccAccCd(tmp.getAaccAccCd());
			retObj.setApcPrerequisiteCd(tmp.getApcPrerequisiteCd());
			retObj.setAccountPrerequisiteCode(tmp.getApcPrerequisiteCd());
			retObj.setAiatPartialCostAccCd(tmp.getAiatPartialCostAccCd());
			retObj.setAiatDrawingFeeAccCd(tmp.getAiatDrawingFeeAccCd());
			retObj.setAiatWhenLog(tmp.getAiatWhenLog());
			retObj.setAiatWhoLog(tmp.getAiatWhoLog());
			
			retObj.setIdKey(String.valueOf(tmp.getIdPk().getAsacBudgetYr())+tmp.getIdPk().getAiatResidencyInd()+String.valueOf(tmp.getIdPk().getAictSeqNo()));
		
			//DTO specific values
			retObj.setResidencyInd(tmp.getIdPk().getAiatResidencyInd());
			retObj.setAccountCode(tmp.getAaccAccCd());
			retObj.setBudgetYear(tmp.getIdPk().getAsacBudgetYr());
			retObj.setUseAccountForPartialCost(tmp.getAiatPartialCostAccCd()!=null&&!"".equals(tmp.getAiatPartialCostAccCd())?"Y":"N");
			retObj.setUseAccountForDrawingFee(tmp.getAiatDrawingFeeAccCd()!=null&&!"".equals(tmp.getAiatDrawingFeeAccCd())?"Y":"N");
			String toolTipText = "";
			if (tmp.getApcPrerequisiteCd() != null) {
				AlsPrerequisiteCd apc = apcDAO.findById(tmp.getApcPrerequisiteCd());
				
				if (apc != null) {
					toolTipText = apcAS.buildToolTipText(apc);
				}
			}
			
			retObj.setPrereqToolTip(toolTipText);
			
			
			String accountDescr = getAccountCodeDescr(tmp.getIdPk().getAsacBudgetYr(), tmp.getAaccAccCd());
			String drawingAccountDescr = getAccountCodeDescr(tmp.getIdPk().getAsacBudgetYr(), tmp.getAiatDrawingFeeAccCd());
			String partialAccountDescr = getAccountCodeDescr(tmp.getIdPk().getAsacBudgetYr(), tmp.getAiatPartialCostAccCd());
		
			
			//Updates the description for the account codes
			if (accountDescr!=null)
			{
				retObj.setAccountCodeDescr(accountDescr);
			}
			if (drawingAccountDescr!=null)
			{
				retObj.setDrawingAccountCodeDescr(drawingAccountDescr);
			}
			if (partialAccountDescr!=null)
			{
				retObj.setPartialAccountCodeDescr(partialAccountDescr);
			}
			
			

			
		} catch (Exception e) {
			throw new RuntimeException (this.getClass().getName() + ".fillAlsItemAccountTableDTO - " + e.getMessage());
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return retObj;
	}
	
	
	// Creates the string for the description of the accounting code.
	private String getAccountCodeDescr(int budgetYear, String accountCode)
	{
		String toReturn = null;
		
		Query queryObject = createAlsAccCdQuery(budgetYear, accountCode);
		@SuppressWarnings("unchecked")
		List<AlsAccCdControl> aaccList = queryObject.list();
		AlsAccCdControlAS aaccAS = new AlsAccCdControlAS();
		
		if (aaccList != null && !aaccList.isEmpty()) {
			AlsAccCdControl aacc = aaccList.get(0);
			
			try {
				toReturn = aaccAS.buildToolTipText(aacc, ": ","; ");
			} catch (Exception e) {
				throw new RuntimeException (this.getClass().getName() + ".fillAlsItemAccountTableDTO - " + e.getMessage());
			}
				
			
			
		}		
		return toReturn;
	}

	//creates a Query to get the AlsAccDd for the description.
	private Query createAlsAccCdQuery(int budgetYear, String accountCd) {
		String queryString = "SELECT aacc FROM AlsAccCdControl aacc ";
		String whereClause = " WHERE aacc.idPk.asacBudgetYear = :budgetYear" + 
		                     "   AND aacc.idPk.aaccAccCd = :accountCd" ;
					
		String orderByClause = " ORDER BY aacc.idPk.asacBudgetYear, aacc.idPk.aaccAccCd, aacc.idPk.aaccSeqNo DESC ";
		Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString+whereClause+orderByClause);
		queryObject.setParameter("budgetYear", budgetYear);
		queryObject.setParameter("accountCd", accountCd);
		return queryObject;
	}
	
	/**
	 * returns a list of AlsItemAccountTable filtered by either usage period from/to and budget period
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByUsagePeriodFromToBudgPeriod(Date upFromDt, Date upToDt, Integer budgYear) {
		log.debug("finding all AlsItemAccountTable instances by where filter");
		try {
			String queryString = " from AlsItemAccountTable WHERE 1=1";
    		if(!DalUtils.isNil(upFromDt)){
    			queryString += "AND idPk.aictUsagePeriodFrom = :upFromDt ";
    		}
    		if(!DalUtils.isNil(upToDt)){
    			queryString += "AND idPk.aictUsagePeriodTo = :upToDt ";
    		}
    		if(!DalUtils.isNil(budgYear)){
    			queryString += "AND idPk.asacBudgetYr = :budgYear ";
    		}
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
			if(!DalUtils.isNil(upFromDt)){
    			queryObject.setDate("upFromDt", upFromDt);
    		}
    		if(!DalUtils.isNil(upToDt)){
    			queryObject.setDate("upToDt", upToDt);
    		}
    		if(!DalUtils.isNil(budgYear)){
    			queryObject.setInteger("budgYear", budgYear);
    		}
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	


}
