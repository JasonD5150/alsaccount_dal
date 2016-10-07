package fwp.alsaccount.appservice.sabhrs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.ListComp;
import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries;
import fwp.alsaccount.dao.sabhrs.AlsTransactionGrpStatus;
import fwp.alsaccount.dao.sabhrs.AlsTransactionGrpStatusDAO;
import fwp.alsaccount.dao.sabhrs.AlsTransactionGrpStatusIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.alsaccount.hibernate.utils.DalUtils;

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
	
	public List<AlsTransactionGrpStatus> findAllByQuery(String sqlQuery, List<Object> strParms){
		log.debug("finding all AlsTransactionGrpStatus instances by query");
		try {
			String queryString = " from AlsTransactionGrpStatus";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + sqlQuery);
			int x = 0;
            for(Object parm : strParms){
            	if(parm instanceof Integer){
            		queryObject.setInteger(x++,Integer.valueOf(parm.toString()));   
            	}else if(parm instanceof String){
            		queryObject.setString(x++,parm.toString());   
            	}else if(parm instanceof Date){
            		queryObject.setDate(x++, (Date) parm);
            	}
            	         	
            }
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
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
	
	@SuppressWarnings("unchecked")
	public List<ListComp> getTransGrpIdList(Integer provNo, Integer txGrpType) {
		List<ListComp> lst = new ArrayList<ListComp>();
		ListComp tmp;
		StringBuilder queryString = new StringBuilder(" from AlsTransactionGrpStatus WHERE 1=1 ");
		if(!DalUtils.isNil(provNo))
			queryString.append("AND TRIM(TRIM(LEADING 0 FROM substr(idPk.atgsGroupIdentifier,3,6))) = :provNo ");
		if(!DalUtils.isNil(txGrpType))
			queryString.append("AND idPk.atgTransactionCd = :txGrpType ");
		queryString.append("ORDER BY 1,2 DESC ");
		
		Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString.toString());
		
		if(!DalUtils.isNil(provNo))
			queryObject.setInteger("provNo", provNo);
		if(!DalUtils.isNil(txGrpType))
			queryObject.setInteger("txGrpType", txGrpType);

		List<AlsTransactionGrpStatus> atgsLst = queryObject.list();
		String atgsTmp = null;
		for (AlsTransactionGrpStatus atgs : atgsLst) {
			if(atgs.getIdPk().getAtgTransactionCd() == 8){
				if(atgsTmp == null){
					atgsTmp = atgs.getIdPk().getAtgsGroupIdentifier().substring(0, 18);
				}else if(!atgsTmp.equals(atgs.getIdPk().getAtgsGroupIdentifier().substring(0, 18))){
					tmp = new ListComp();
					tmp.setItemLabel(atgsTmp);
					tmp.setItemVal(atgsTmp);
					lst.add(tmp);
					atgsTmp = atgs.getIdPk().getAtgsGroupIdentifier().substring(0, 18);
				}
			}else{
				tmp = new ListComp();
				tmp.setItemLabel(atgs.getIdPk().getAtgsGroupIdentifier());
				tmp.setItemVal(atgs.getIdPk().getAtgsGroupIdentifier());
				lst.add(tmp);
			}
		}
		HibernateSessionFactory.getSession().close();
		return lst;
	}
	
	/**
	 * returns a list of AlsTransactionGrpStatus filtered
	 * @param 
	 * @param 
	 * @return List<AlsTransactionGrpStatus>
	 */
	public List<AlsTransactionGrpStatus> getTransactionGroupApprovalRecords(Integer srchTransGrpType, String srchTranGrpId, Integer srchTranGrpCreated,
													   Date srchAccDt, String srchSumAppStat, Date srchSumAppDt, String srchIntAppStat,
													   Date srchIntAppDt, Date srchUpToSumDt, String srchBankCd, String srchBankRefNo,
													   String srchIntFileNm, String srchDepId, Integer srchProviderNo, Boolean srchAll,
													   Date srchDate) {
		List<AlsTransactionGrpStatus> lst = new ArrayList<AlsTransactionGrpStatus>(); 
		try {
			Boolean deafultDate = true;
			StringBuilder sb = new StringBuilder(" FROM AlsTransactionGrpStatus WHERE 1=1 ");
			
	    	if(srchTransGrpType != null && !"".equals(srchTransGrpType)){
	    		sb.append("AND idPk.atgTransactionCd = :srchTransGrpType ");
	    	}
			if(srchTranGrpId != null && !" ".equals(srchTranGrpId)){
				sb.append("AND idPk.atgsGroupIdentifier LIKE :srchTranGrpId||'%' ");
				deafultDate = false;
			}
			if(srchTranGrpCreated != null){
				sb.append("AND TO_CHAR(atgsWhenCreated,'YYYY') = :srchTranGrpCreated ");
				deafultDate = false;
			}
			if(srchAccDt != null){
				sb.append("AND atgsAccountingDt = :srchAccDt ");
				deafultDate = false;
			}
			if(srchSumAppStat != null && !"".equals(srchSumAppStat)){
				if("NS".equals(srchSumAppStat)){
					sb.append("AND atgsSummaryStatus IS NULL ");
				}else{
					sb.append("AND atgsSummaryStatus = :srchSumAppStat ");
				}				
			}
			if(srchSumAppDt != null ){
				sb.append("AND atgsSummaryDt = :srchSumAppDt ");
				deafultDate = false;
			}
			if(srchIntAppStat != null && !"".equals(srchIntAppStat)){
				if("NS".equals(srchIntAppStat)){
					sb.append("AND atgsInterfaceStatus IS NULL ");
				}else{
					sb.append("AND atgsInterfaceStatus = :srchIntAppStat ");
				}
			}
			if(srchIntAppDt != null ){
				sb.append("AND atgsInterfaceDt = :srchIntAppDt ");
				deafultDate = false;
			}
			if(srchUpToSumDt != null ){
				sb.append("AND atgsWhenUploadToSummary = :srchUpToSumDt ");
				deafultDate = false;
			}
			if(srchBankCd != null && !"".equals(srchBankCd)){
				sb.append("AND abcBankCd = :srchBankCd ");
			}
			if(srchBankRefNo != null && !"".equals(srchBankRefNo)){
				sb.append("AND atgsBankReferenceNo = :srchBankRefNo ");
			}
			if(srchIntFileNm != null && !"".equals(srchIntFileNm)){
				sb.append("AND atgsFileName = :srchIntFileNm ");
			}
			if(srchDepId != null && !"".equals(srchDepId)){
				sb.append("AND atgsDepositId = :srchDepId ");
			}
			if(srchProviderNo != null && !" ".equals(srchProviderNo)){
				sb.append("AND TRIM(TRIM(LEADING 0 FROM substr(idPk.atgsGroupIdentifier,3,6))) = :srchProviderNo ");
			}
			if(deafultDate){
				if(srchAll != true){
					sb.append("AND atgsWhenCreated >= :srchDate ");
				}
			}
			sb.append(" ORDER BY atgsWhenCreated desc,idPk.atgTransactionCd,idPk.atgsGroupIdentifier");
			
												
			Query query = HibernateSessionFactory.getSession().createQuery(sb.toString());
			
			if(srchTransGrpType != null && !"".equals(srchTransGrpType)){
	    		query.setInteger("srchTransGrpType", srchTransGrpType);
	    	}
			if(srchTranGrpId != null && !" ".equals(srchTranGrpId)){
				query.setString("srchTranGrpId", srchTranGrpId);
			}
			if(srchTranGrpCreated != null){
				query.setInteger("srchTranGrpCreated", srchTranGrpCreated);
			}
			if(srchAccDt != null){
				query.setDate("srchAccDt", srchAccDt);
			}
			if(srchSumAppStat != null && !"".equals(srchSumAppStat)){
				if(!"NS".equals(srchSumAppStat)){
					query.setString("srchSumAppStat", srchSumAppStat);
				}				
			}
			if(srchSumAppDt != null ){
				query.setDate("srchSumAppDt", srchSumAppDt);
			}
			if(srchIntAppStat != null && !"".equals(srchIntAppStat)){
				if(!"NS".equals(srchIntAppStat)){
					query.setString("srchIntAppStat", srchIntAppStat);
				}
			}
			if(srchIntAppDt != null ){
				query.setDate("srchIntAppDt", srchIntAppDt);
			}
			if(srchUpToSumDt != null ){
				query.setDate("srchUpToSumDt", srchUpToSumDt);
			}
			if(srchBankCd != null && !"".equals(srchBankCd)){
				query.setString("srchBankCd", srchBankCd);
			}
			if(srchBankRefNo != null && !"".equals(srchBankRefNo)){
				query.setString("srchBankRefNo", srchBankRefNo);
			}
			if(srchIntFileNm != null && !"".equals(srchIntFileNm)){
				query.setString("srchIntFileNm", srchIntFileNm);
			}
			if(srchDepId != null && !"".equals(srchDepId)){
				query.setString("srchDepId", srchDepId);
			}
			if(srchProviderNo != null && !" ".equals(srchProviderNo)){
				query.setInteger("srchProviderNo", srchProviderNo);
			}
			if(deafultDate){
				if(srchAll != true){
					query.setDate("srchDate", srchDate);
				}
			}
			
			lst = query.list();
		} catch (HibernateException he){
			System.out.println(he.toString());
		}
		catch (RuntimeException re) {
			System.out.println(re.toString());
		}
		finally {
			HibernateSessionFactory.getSession().close();
		}
		return lst;
	}
	
}
