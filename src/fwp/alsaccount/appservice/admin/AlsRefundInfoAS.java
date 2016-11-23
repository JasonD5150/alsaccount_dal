package fwp.alsaccount.appservice.admin;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.dto.admin.AlsRefundInfoDTO;
import fwp.alsaccount.dto.admin.PersonRefundAppDTO;
import fwp.alsaccount.dto.sabhrs.ProvAdjEntAIAFAGridDTO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.als.hibernate.admin.dao.AlsRefundInfo;
import fwp.als.hibernate.admin.dao.AlsRefundInfoDAO;
import fwp.als.hibernate.admin.dao.AlsRefundInfoIdPk;
import fwp.als.hibernate.admin.dao.AlsSessionTrans;
import fwp.als.hibernate.admin.dao.AlsSessionTransIdPk;
import fwp.als.hibernate.item.dao.AlsItemInformation;
import fwp.alsaccount.hibernate.utils.DalUtils;

/**
 * @author c81203
 * 
 */
public class AlsRefundInfoAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsRefundInfoDAO.class);
	
	/**
	 * returns a list of AlsRefundInfo filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsRefundInfo instances by where filter");
		try {
			String queryString = " from AlsRefundInfo";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsRefundInfo findById(AlsRefundInfoIdPk idPk){
		AlsRefundInfoDAO dao = new AlsRefundInfoDAO();
		
		AlsRefundInfo api=null;
		try{
			api = dao.findById(idPk);
		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return api;
	}
	
	/**
	 * Saves any AlsRefundInfo using the merge function
	 * @param AlsRefundInfo
	 */
	public void save(AlsRefundInfo tmp){
		log.debug("saving AlsRefundInfo");
		Transaction tx = null;
		AlsRefundInfoDAO dao = new AlsRefundInfoDAO();
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
	 * delete an existing AlsRefundInfo
	 * @param ari AlsRefundInfo entity
	 */
	public void delete(AlsRefundInfo ari){
		log.debug("deleting AlsRefundInfo");
		Transaction tx = null;
		AlsRefundInfoDAO dao = new AlsRefundInfoDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(ari);
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			log.error("delete failed", re);	
			throw re;			
		}finally{
			try {
				dao.getSession().close();
			} catch(Exception e){
			
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public AlsRefundInfoDTO retrieveRefundInfo(AlsSessionTransIdPk idPk) {
		AlsRefundInfoDTO retObj = new AlsRefundInfoDTO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssa");
		
		try {
			
			String queryString = "	SELECT ari FROM AlsRefundInfo ari" +
							     "   WHERE ari.ahmType = :ahmType" +
							     "     AND ari.ahmCd = :ahmCd" +
							     "     AND TO_CHAR(ari.asSessionDt,'YYYYMMDDHHMISSAM') = :sessDt" +
							     "     AND ari.astTransactionCd = :transactionCd" +
	                             "     AND ari.astTransactionSeqNo = :transactionSeqNo"+
							     "  ORDER BY ari.idPk.ariRefundRequestDt DESC, ari.idPk.ariRefundSeqNo DESC";
			
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
			
			queryObject.setParameter("ahmCd", idPk.getAhmCd());
			queryObject.setParameter("ahmType", idPk.getAhmType());
			queryObject.setParameter("sessDt", sdf.format(idPk.getAsSessionDt()));
			queryObject.setParameter("transactionCd", idPk.getAstTransactionCd());
			queryObject.setParameter("transactionSeqNo", idPk.getAstTransactionSeqNo());
			
			List<AlsRefundInfo> ariLst = queryObject.list();
			
			if (ariLst != null && !ariLst.isEmpty()) {
				AlsRefundInfo ari = ariLst.get(0);
				
				retObj.setIdPk(ari.getIdPk());
				retObj.setAriRefundReasonCd(ari.getAriRefundReasonCd());
				retObj.setAriRefundAmt(ari.getAriRefundAmt()==null?0D:ari.getAriRefundAmt());
				retObj.setAriRefundFee(ari.getAriRefundFee()==null?0D:ari.getAriRefundFee());
				retObj.setRefundFeeModified(ari.getAriRefundFee()==null?0D:ari.getAriRefundFee());
			}

		} catch (RuntimeException re) {
			log.error("retrieveRefundInfo failed", re);
			throw re;
		} catch (Exception e) {
			log.error("retrieveRefundInfo failed", e);
			throw new RuntimeException(e.getMessage());
		} finally {
			if (HibernateSessionFactory.getSession() != null) {
				HibernateSessionFactory.closeSession();
			}		
			
		}
		return retObj;
	}

	@SuppressWarnings("unchecked")
	public void updateRefundInfo(AlsRefundInfoDTO ariDTO, String personId) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssa");
		
		try {
			
			Date today = new Date();
			
			String queryString = "	SELECT ari FROM AlsRefundInfo ari" +
							     "   WHERE ari.ahmType = :ahmType" +
							     "     AND ari.ahmCd = :ahmCd" +
							     "     AND TO_CHAR(ari.asSessionDt,'YYYYMMDDHHMISSAM') = :sessDt" +
							     "     AND ari.astTransactionCd = :transactionCd" +
	                             "     AND ari.astTransactionSeqNo = :transactionSeqNo"+
	                             "     AND ari.apiProviderNo = :providerNo"+
							     "  ORDER BY ari.idPk.ariRefundRequestDt DESC, ari.idPk.ariRefundSeqNo DESC";
			
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
			
			queryObject.setParameter("ahmCd", ariDTO.getAstIdPk().getAhmCd());
			queryObject.setParameter("ahmType", ariDTO.getAstIdPk().getAhmType());
			queryObject.setParameter("sessDt", sdf.format(ariDTO.getAstIdPk().getAsSessionDt()));
			queryObject.setParameter("transactionCd", ariDTO.getAstIdPk().getAstTransactionCd());
			queryObject.setParameter("transactionSeqNo", ariDTO.getAstIdPk().getAstTransactionSeqNo());
			queryObject.setParameter("providerNo", ariDTO.getProviderNo());
			
			List<AlsRefundInfo> ariLst = queryObject.list();
			
			if (ariLst != null && !ariLst.isEmpty()) {
				BigDecimal amtCalc = new BigDecimal(ariDTO.getAriRefundAmt()==null?0:ariDTO.getAriRefundAmt());
				amtCalc.add(new BigDecimal(ariDTO.getAriRefundFee()==null?0:ariDTO.getAriRefundFee()));
				amtCalc.subtract(new BigDecimal(ariDTO.getRefundFeeModified()==null?0:ariDTO.getRefundFeeModified()));

				for (AlsRefundInfo ari : ariLst) {				
					ari.setAriRefundFee(ariDTO.getRefundFeeModified());				
					ari.setAriRefundAmt(amtCalc.doubleValue());
					ari.setAriWhoLog(personId);
					ari.setAriWhenLog(new Timestamp(today.getTime()));
					
					this.save(ari);					
				}
				
			}

		} catch (RuntimeException re) {
			log.error("updateRefundInfo failed", re);
			throw re;
		} catch (Exception e) {
			log.error("updateRefundInfo failed", e);
			throw new RuntimeException(e.getMessage());
		} finally {
			if (HibernateSessionFactory.getSession() != null) {
				HibernateSessionFactory.closeSession();
			}		
			
		}		
	}

	@SuppressWarnings("unchecked")
	public void updateRefundInfo2(AlsRefundInfoDTO ariDTO, AlsSessionTrans ast, String personId) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssa");
		
		try {
			
			Date today = new Date();
			
			String queryAstString = "	SELECT ast FROM AlsSessionTrans ast" +
							     	"   WHERE ast.aictUsagePeriodFrom = :periodFrom" +
							     	"     AND ast.aictUsagePeriodTo = :periodTo" +
							     	"     AND ast.apiDob = :dob" +
							     	"     AND ast.apiAlsNo = :alsNo" +
							     	"     AND ast.aiiItemTxnInd = :aiiItemTxnInd"+
							     	"     AND ast.aiiSeqNo = :aiiSeqNo"+
							     	"     AND ast.astProcessTypeCd IN (1,2)";

			Query queryAstObject = HibernateSessionFactory.getSession().createQuery(queryAstString);
			queryAstObject.setParameter("periodFrom", ast.getAictUsagePeriodFrom());
			queryAstObject.setParameter("periodTo", ast.getAictUsagePeriodTo());
			queryAstObject.setDate("dob", ast.getApiDob());
			queryAstObject.setParameter("alsNo", ast.getApiAlsNo());
			queryAstObject.setParameter("aiiItemTxnInd", ast.getAiiItemTxnInd());
			queryAstObject.setParameter("aiiSeqNo", ast.getAiiSeqNo());

			List<AlsSessionTrans> astLst = new ArrayList<AlsSessionTrans>();
			
			if (astLst != null && !astLst.isEmpty()) {
				
				AlsSessionTrans astObj = astLst.get(0);
				
				if (astObj.getAstNsfStatus() == null || "R".equals(astObj.getAstNsfStatus())) {		
					
					String queryString = "	SELECT ari FROM AlsRefundInfo ari" +
						     			 "   WHERE ari.ahmType = :ahmType" +
						     			 "     AND ari.ahmCd = :ahmCd" +
						     			 "     AND TO_CHAR(ari.asSessionDt,'YYYYMMDDHHMISSAM') = :sessDt" +
						     			 "     AND ari.astTransactionCd = :transactionCd" +
						     			 "     AND ari.astTransactionSeqNo = :transactionSeqNo"+
						     			 "     AND ari.apiProviderNo = :providerNo"+
				     					 "  ORDER BY ari.idPk.ariRefundRequestDt DESC, ari.idPk.ariRefundSeqNo DESC";

					Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
					
					queryObject.setParameter("ahmCd", ariDTO.getAstIdPk().getAhmCd());
					queryObject.setParameter("ahmType", ariDTO.getAstIdPk().getAhmType());
					queryObject.setParameter("sessDt", sdf.format(ariDTO.getAstIdPk().getAsSessionDt()));
					queryObject.setParameter("transactionCd", ariDTO.getAstIdPk().getAstTransactionCd());
					queryObject.setParameter("transactionSeqNo", ariDTO.getAstIdPk().getAstTransactionSeqNo());
					queryObject.setParameter("providerNo", ariDTO.getProviderNo());
					
					List<AlsRefundInfo> ariLst = queryObject.list();
					if (ariLst != null && !ariLst.isEmpty()) {
						
						BigDecimal amtCalc = new BigDecimal(ariDTO.getAriRefundAmt()==null?0:ariDTO.getAriRefundAmt());
						amtCalc.add(new BigDecimal(ariDTO.getAriRefundFee()==null?0:ariDTO.getAriRefundFee()));
						amtCalc.subtract(new BigDecimal(ariDTO.getRefundFeeModified()==null?0:ariDTO.getRefundFeeModified()));

						for (AlsRefundInfo ari : ariLst) {
							
							ari.setAriRefundApproved("Y");
							ari.setAriApprovedBy("SYSTEM");
							ari.setAriApprovedDt(new Timestamp(today.getTime()));
							ari.setAriRefundProcessDt(ast.getAstDtVerified());
							
							ari.setAriRefundFee(ariDTO.getRefundFeeModified());
							
							ari.setAriRefundAmt(amtCalc.doubleValue());
							
							ari.setAriWhoLog(personId);
							ari.setAriWhenLog(new Timestamp(today.getTime()));
							
							this.save(ari);
							
							//update item info
							this.updateItemInfo(ast, personId);
						}
							
					}
				
				} else if ("U".equals(astObj.getAstNsfStatus())) {
				
						String deleteStr = "DELETE FROM ALS.ALS_REFUND_INFO"+
										   " WHERE API_PROVIDER_NO = :providerNo"+
								           "   AND AHM_TYPE = :ahmType"+
										   "   AND AHM_CD = :ahmCd" +
								           "   AND TO_CHAR(AS_SESSION_DT,'YYYYMMDDHHMISSAM') = :sessDt" +
										   "   AND AST_TRANSACTION_CD = :transactionCd" +
								           "   AND AST_TRANSACTION_SEQ_NO = :transactionSeqNo";						

						Query deleteObject = HibernateSessionFactory.getSession().createSQLQuery(deleteStr);
						
						deleteObject.setParameter("providerNo", ariDTO.getProviderNo());
						deleteObject.setParameter("ahmCd", ariDTO.getAstIdPk().getAhmCd());
						deleteObject.setParameter("ahmType", ariDTO.getAstIdPk().getAhmType());
						deleteObject.setParameter("sessDt", sdf.format(ariDTO.getAstIdPk().getAsSessionDt()));
						deleteObject.setParameter("transactionCd", ariDTO.getAstIdPk().getAstTransactionCd());
						deleteObject.setParameter("transactionSeqNo", ariDTO.getAstIdPk().getAstTransactionSeqNo());

						deleteObject.executeUpdate();
				}					
			}

		} catch (RuntimeException re) {
			log.error("updateRefundInfo2 failed", re);
			throw re;
		} catch (Exception e) {
			log.error("updateRefundInfo2 failed", e);
			throw new RuntimeException(e.getMessage());
		} finally {
			if (HibernateSessionFactory.getSession() != null) {
				HibernateSessionFactory.closeSession();
			}		
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void updateItemInfo(AlsSessionTrans ast, String personId) {
		
		try {
			Date today = new Date();
			Integer aiinItemInd = null;
			boolean processItemInfo = true;
			
			if (ast.getAstProcessTypeCd() == 7) {
				aiinItemInd = 8; //Refund
			} else {
				
				//Query item information to determine the item indicator code
				String queryAiiStr = "SELECT aii" +
	                              "  FROM AlsItemInformation aii"+
	                              " WHERE aii.idPk.aictUsagePeriodFrom = :periodFrom" +
	                              "   AND aii.idPk.aictUsagePeriodTo = :periodTo" +
	                              "   AND aii.idPk.aictItemTypeCd = :itemTypeCd" +
	                              "   AND aii.idPk.apiDob = :dob" +
	                              "   AND aii.idPk.apiAlsoNo = :alsNo" +
	                              "   AND aii.idPk.aiiItemTxnInd = :aiiItemTxnInd" +
	                              "   AND aii.idPk.aiiSeqNo = :aiiSeqNo";	
				
				Query queryAiiObject = HibernateSessionFactory.getSession().createQuery(queryAiiStr);
				
				queryAiiObject.setDate("periodFrom", ast.getAictUsagePeriodFrom());
				queryAiiObject.setDate("periodTo", ast.getAictUsagePeriodTo());
				queryAiiObject.setParameter("itemTypeCd", ast.getAictItemTypeCd());
				queryAiiObject.setDate("dob", ast.getApiDob());
				queryAiiObject.setParameter("alsNo", ast.getApiAlsNo());
				queryAiiObject.setParameter("aiiItemTxnInd", ast.getAiiItemTxnInd());
				queryAiiObject.setParameter("aiiSeqNo", ast.getAiiSeqNo());
				
				List<AlsItemInformation> aiiLst = queryAiiObject.list();
				
				
				if (aiiLst != null && !aiiLst.isEmpty()) {
					AlsItemInformation aii = aiiLst.get(0);
					
					//Do not update item info if the item indicator is RETURN/PENDING
					if (aii.getAiinItemIndCd() != 9) {
						processItemInfo = false;
					}
					
				}
				
				//Set item indicator to refund
				aiinItemInd = 10;
				
			}
			
			if (processItemInfo) {
				this.processItemInfoUpdate(ast.getAictUsagePeriodFrom(), 
										   ast.getAictUsagePeriodTo(), 
										   ast.getAictItemTypeCd(), 
										   ast.getApiDob(), 
										   ast.getApiAlsNo(), 
										   ast.getAiiItemTxnInd(), 
										   ast.getAiiSeqNo(), 
										   aiinItemInd, personId, today, ast);
				
				
				//Query item information to determine the item indicator code
				String queryAiiRefStr = "SELECT aii" +
	                              "  FROM AlsItemInformation aii"+
	                              " WHERE aii.aictRefUsagePeriodFrom = :periodFrom" +
	                              "   AND aii.aictRefUsagePeriodTo = :periodTo" +
	                              "   AND aii.aictRefItemTypeCd = :itemTypeCd" +
	                              "   AND idPk.apiDob = :dob" +
	                              "   AND idPk.apiAlsoNo = :alsNo" +
	                              "   AND aii.aiiRefItemTxnInd = :aiiItemTxnInd" +
	                              "   AND aii.aiiRefSeqNo = :aiiSeqNo";	
				
				Query queryAiiRefObject = HibernateSessionFactory.getSession().createQuery(queryAiiRefStr);
				
				queryAiiRefObject.setDate("periodFrom", ast.getAictUsagePeriodFrom());
				queryAiiRefObject.setDate("periodTo", ast.getAictUsagePeriodTo());
				queryAiiRefObject.setParameter("itemTypeCd", ast.getAictItemTypeCd());
				queryAiiRefObject.setDate("dob", ast.getApiDob());
				queryAiiRefObject.setParameter("alsNo", ast.getApiAlsNo());
				queryAiiRefObject.setParameter("aiiItemTxnInd", ast.getAiiItemTxnInd());
				queryAiiRefObject.setParameter("aiiSeqNo", ast.getAiiSeqNo());
				
				List<AlsItemInformation> aiiRefLst = queryAiiRefObject.list();
				
				
				if (aiiRefLst != null && !aiiRefLst.isEmpty()) {
					for (AlsItemInformation aiiRef : aiiRefLst) {
						
						this.processItemInfoUpdate(aiiRef.getIdPk().getAictUsagePeriodFrom(), 
												   aiiRef.getIdPk().getAictUsagePeriodTo(), 
												   aiiRef.getIdPk().getAictItemTypeCd(), 
												   aiiRef.getIdPk().getApiDob(), 
												   aiiRef.getIdPk().getApiAlsNo(), 
												   aiiRef.getIdPk().getAiiItemTxnInd(), 
												   aiiRef.getIdPk().getAiiSeqNo(), 
												   aiinItemInd, personId, today, ast);
					}
				}

			}
		} catch (RuntimeException re) {
			log.error("updateItemInfo failed", re);
			throw re;
		} catch (Exception e) {
			log.error("updateItemInfo failed", e);
			throw new RuntimeException(e.getMessage());
		} finally {
			if (HibernateSessionFactory.getSession() != null) {
				HibernateSessionFactory.closeSession();
			}		
			
		}
	}


	@SuppressWarnings("unchecked")
	private void processItemInfoUpdate(Date periodFrom, 
								  	   Date periodTo, 
								  	   String itemTypeCd, 
								  	   Date dob, 
								  	   Integer alsNo, 
								  	   String aiiItemTxnInd, 
								  	   Integer aiiSeqNo,
								  	   Integer aiinItemInd,
								  	   String personId,
								  	   Date today,
								  	   AlsSessionTrans ast) {
		try {
			
			String updatAiiStr = "UPDATE ALS.ALS_ITEM_INFORMATION"+
								 "   SET aiin_item_ind_cd = :aiinItemInd,"+
								 "       aii_who_log = :whoLog,"+
								 "       aii_when_log = :whenLog"+
								 " WHERE aict_usage_period_from = :periodFrom"+
								 "   AND aict_usage_period_to = :periodTo"+
								 "   AND aict_item_type_cd = :itemType" +
								 "   AND api_dob = :dob" +
								 "   AND api_als_no = :alsNo" +
								 "   AND aii_item_txn_ind = :aiiItemTxnInd" +
								 "   AND aii_seq_no = :aiiSeqNo";						

			Query updateAiiObject = HibernateSessionFactory.getSession().createSQLQuery(updatAiiStr);
			
			updateAiiObject.setDate("periodFrom", periodFrom);
			updateAiiObject.setDate("periodTo", periodTo);
			updateAiiObject.setParameter("itemTypeCd", itemTypeCd);
			updateAiiObject.setDate("dob", dob);
			updateAiiObject.setParameter("alsNo",alsNo);
			updateAiiObject.setParameter("aiiItemTxnInd", aiiItemTxnInd);
			updateAiiObject.setParameter("aiiSeqNo", aiiSeqNo);
			updateAiiObject.setParameter("aiinItemInd", aiinItemInd);
			updateAiiObject.setParameter("whoLog", personId);
			updateAiiObject.setParameter("whenLog", today);

			updateAiiObject.executeUpdate();
						
			String queryAiiStr = "SELECT (NVL(MAX(aiin_item_ind_seq_no),0)+1) nextSeq"+
								 " WHERE aict_usage_period_from = :periodFrom"+
								 "   AND aict_usage_period_to = :periodTo"+
								 "   AND aict_item_type_cd = :itemType" +
								 "   AND api_dob = :dob" +
								 "   AND api_als_no = :alsNo" +
								 "   AND aii_item_txn_ind = :aiiItemTxnInd" +
								 "   AND aii_seq_no = :aiiSeqNo";						

			Query queryAiiObject = HibernateSessionFactory.getSession().createSQLQuery(queryAiiStr)
					.addScalar("nextSeq",StringType.INSTANCE);
			
			queryAiiObject.setDate("periodFrom", periodFrom);
			queryAiiObject.setDate("periodTo", periodTo);
			queryAiiObject.setParameter("itemTypeCd", itemTypeCd);
			queryAiiObject.setDate("dob", dob);
			queryAiiObject.setParameter("alsNo",alsNo);
			queryAiiObject.setParameter("aiiItemTxnInd", aiiItemTxnInd);
			queryAiiObject.setParameter("aiiSeqNo", aiiSeqNo);

			List<String> nextSeqNoLst =  queryAiiObject.list();
			
			if (nextSeqNoLst != null && !nextSeqNoLst.isEmpty()) {
				Integer aiinNextSeq = Integer.valueOf(nextSeqNoLst.get(0));
				
				String insertAiiStr = "INSERT INTO Als.Als_Item_Ind" +   
								      "  (Aict_Usage_Period_From," +
								      "   Aict_Usage_Period_To," +
								      "   Aict_Item_Type_Cd," +  
								      "   Api_Dob," +
								      "   Api_Als_No," +
								      "   Aii_Item_Txn_Ind," +
								      "   Aii_Seq_No," +
								      "   Aiin_Item_Ind_Seq_No," +
								      "   Aiin_Item_Ind_Cd," +
								      "   Ahm_Type," +
								      "   Ahd_Cd," +
								      "   As_Session_Dt," +
								      "   Aiin_Item_Ind_Posted," +
								      "   Ain_Who_Log," +
								      "   Ain_When_Log) " +
								      "VALUES" +
								      "  (:periodFrom," +
								      "   :periodTo," +
								      "   :itemTypeCd," +
								      "   :dob," +
								      "   :alsNo," +
								      "   :aiiItemTxnInd," +
								      "   :aiiSeqNo," +
								      "   :aiinNextSeq," +
								      "   :aiinItemInd," +
								      "   :ahmType," +
								      "   :ahmCd," +
								      "   :sessDt," +
								      "   :itemIndPosted," +
								      "   :whoLog," +
								      "   :whenLog)";						

				Query insertAiiObject = HibernateSessionFactory.getSession().createSQLQuery(insertAiiStr);
				
				insertAiiObject.setDate("periodFrom", periodFrom);
				insertAiiObject.setDate("periodTo", periodTo);
				insertAiiObject.setParameter("itemTypeCd", itemTypeCd);
				insertAiiObject.setDate("dob", dob);
				insertAiiObject.setParameter("alsNo",alsNo);
				insertAiiObject.setParameter("aiiItemTxnInd", aiiItemTxnInd);
				insertAiiObject.setParameter("aiiSeqNo", aiiSeqNo);
				insertAiiObject.setParameter("aiinNextSeq", aiinNextSeq);
				insertAiiObject.setParameter("aiinItemInd", aiinItemInd);
				insertAiiObject.setParameter("ahmType", ast.getIdPk().getAhmType());
				insertAiiObject.setParameter("ahmCd", ast.getIdPk().getAhmCd());
				insertAiiObject.setDate("sessDt", ast.getIdPk().getAsSessionDt());
				insertAiiObject.setParameter("itemIndPosted", today);
				insertAiiObject.setParameter("whoLog", personId);
				insertAiiObject.setParameter("whenLog", today);
			
				insertAiiObject.executeUpdate();
			}
			
		} catch (RuntimeException re) {
			log.error("processItemInfoUpdate failed", re);
			throw re;
		} catch (Exception e) {
			log.error("processItemInfoUpdate failed", e);
			throw new RuntimeException(e.getMessage());
		} finally {
			if (HibernateSessionFactory.getSession() != null) {
				HibernateSessionFactory.closeSession();
			}		
			
		}
	}
	
	/**
	 * returns a list of PersonRefundAppDTO filtered by 
	 * @param dob
	 * @param alsNo
	 * @param upFrom
	 * @param upTo
	 * @param itemTypeCd
	 * @param reasonCd
	 * @param itemIndCd
	 * @param warCreateDt
	 * @param itemFeeRefApp
	 * @param appFeeRefApp
	 * @param prefFeeRefApp
	 * @return List<AlsRefundInfo>
	 */
	public List<PersonRefundAppDTO> getPersonRefundRecords(Date dob, Integer alsNo, Date upFrom, Date upTo,
																Integer itemTypeCd, Integer reasonCd, Integer itemIndCd,
																Date warCreateDt, String itemFeeRefApp, String appFeeRefApp,
																String 	prefFeeRefApp, Boolean srchAll, Boolean noWarrant) {
		List<PersonRefundAppDTO> lst = new ArrayList<PersonRefundAppDTO>(); 
		Date defaultDate = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(defaultDate); 
		c.add(Calendar.MONTH, -12);
		try {
			StringBuilder queryString = new StringBuilder("SELECT ari.ari_refund_request_dt || ari.ari_refund_seq_no gridKey, "
										+ "ari.ari_designated_refundee_dob ariDesignatedRefundeeDob, "
										+ "ari.ari_designated_refundee_als_no ariDesignatedRefundeeAlsNo, "
										+ "api.api_first_nm||' '||api.api_mid_init||' '||api.api_last_nm refundeeName, "
										+ "ast.aict_usage_period_from usagePeriodFrom, "
										+ "ast.aict_usage_period_to usagePeriodTo, "
										+ "ast.aict_item_type_cd itemTypeCd, "
										+ "ait.ait_type_desc itemTypeDesc, "
										+ "am2.am_val_desc itemIndDesc, "
										+ "am.am_val_desc reasonDesc, "
										+ "ari.ari_refund_request_dt refundRequestDt, "
										+ "ari.ari_refund_process_dt ariRefundProcessDt, "
										+ "ari.ari_refund_amt ariRefundAmt, "
										+ "ari.ari_refund_approved ariRefundApproved, "
										+ "ari.ari_drawing_fee ariDrawingFee, "
										+ "ari.ari_drawing_fee_approved ariDrawingFeeApproved, "
										+ "ari.ari_preference_fee ariPreferenceFee, "
										+ "ari.ari_preference_fee_approved ariPreferenceFeeApproved, "
										+ "ari.ars_download_date arsDownloadDate, "
										+ "asess.abi_batch_no batchNo, "
										+ "asess.asi_subbatch_no subBatchNo, "
										+ "ari.ari_reason_disapproval ariReasonDisapproval "
								+ "FROM ALS.ALS_REFUND_INFO ari "
									+ "LEFT OUTER JOIN ALS_SESSION_TRANS ast "
										+ "ON ast.ahm_type = ari.ahm_type "
										+ "AND ast.ahm_cd = ari.ahm_cd "
										+ "AND ast.as_session_dt = ari.as_session_dt "
										+ "AND ast.ast_transaction_cd = ari.ast_transaction_cd "
										+ "AND ast.ast_transaction_seq_no = ari.ast_transaction_seq_no "
									+ "JOIN ALS.ALS_ITEM_TYPE ait "
										+ "ON ait.ai_item_id||ait.aic_category_id||ait.ait_type_id = ast.aict_item_type_cd "
									+ "JOIN ALS.ALS_PERSON_INFORMATION api "
										+ "ON api.api_dob = ari.ari_designated_refundee_dob "
										+ "AND api.api_als_no = ari.ari_designated_refundee_als_no "
									+ "JOIN ALS.ALS_MISC am "
										+ "ON am.am_key1 = 'REFUND REASON' "
										+ "AND LPAD(am.am_par_val,30,'0') = LPAD(ari.ari_refund_reason_cd,30,'0') "
									+ "LEFT OUTER JOIN ALS.ALS_ITEM_INFORMATION aii "
										+ "ON aii.api_dob = ast.api_dob "
										+ "AND aii.api_als_no = ast.api_als_no "
										+ "AND aii.aict_usage_period_from = ast.aict_usage_period_from "
										+ "AND aii.aict_usage_period_to = ast.aict_usage_period_to "
										+ "AND aii.aict_item_type_cd = ast.aict_item_type_cd "
										+ "AND aii.aii_seq_no = ast.aii_seq_no "
										+ "AND aii.aii_item_txn_ind = ast.aii_item_txn_ind "
									+ "LEFT OUTER JOIN ALS.ALS_MISC am2 "
										+ "ON am2.am_key1 = 'ITEM INDICATOR' "
										+ "AND LPAD(am2.am_par_val,30,'0') = LPAD(aii.aiin_item_ind_cd,30,'0') "
									+ "JOIN ALS.ALS_SESSIONS asess "
										+ "ON asess.ahm_type = ast.ahm_type "
										+ "AND asess.ahm_cd = ast.ahm_cd "
										+ "AND asess.as_session_dt = ast.as_session_dt "
								+ "WHERE ari.ari_designated_refundee_dob IS NOT NULL "
								+ "AND  ari.ari_designated_refundee_als_no IS NOT NULL ");
			if(!srchAll){
				queryString.append("AND ari.ari_refund_request_dt >= :defaultDate ");
			}		
			if(!DalUtils.isNil(dob)){
				queryString.append("AND ari.ari_designated_refundee_dob = :dob ");
			}
			if(!DalUtils.isNil(alsNo)){
				queryString.append("AND ari.ari_designated_refundee_als_no = :alsNo ");
			}
			if(!DalUtils.isNil(upFrom)){
				queryString.append("AND ast.aict_usage_period_from >= :upFrom ");
			}
			if(!DalUtils.isNil(upTo)){
				queryString.append("AND ast.aict_usage_period_to <= :upTo ");
			}
			if(!DalUtils.isNil(itemTypeCd)){
				queryString.append("AND ast.aict_item_type_cd = :itemTypeCd ");
			}
			if(!DalUtils.isNil(reasonCd)){
				queryString.append("AND ari.ari_refund_reason_cd = :reasonCd ");
			}
			if(!DalUtils.isNil(itemIndCd)){
				queryString.append("AND aii.aiin_item_ind_cd = :itemIndCd ");
			}
			if(!DalUtils.isNil(warCreateDt)){
				queryString.append("AND ari.ars_download_date = :warCreateDt ");
			}
			if(!DalUtils.isNil(itemFeeRefApp)){
				if("O".equals(itemFeeRefApp)){
					queryString.append("AND ari.ari_refund_approved IS NULL ");
				}else{
					queryString.append("AND ari.ari_refund_approved = :itemFeeRefApp ");
				}
			}
			if(!DalUtils.isNil(appFeeRefApp)){
				if("O".equals(appFeeRefApp)){
					queryString.append("AND ari.ari_drawing_fee_approved IS NULL ");
				}else{
					queryString.append("AND ari.ari_drawing_fee_approved = :appFeeRefApp ");
				}
			}
			if(!DalUtils.isNil(prefFeeRefApp)){
				if("O".equals(prefFeeRefApp)){
					queryString.append("AND ari.ari_preference_fee_approved IS NULL ");
				}else{
					queryString.append("AND ari.ari_preference_fee_approved = :prefFeeRefApp ");
				}
			}
			if(noWarrant){
				queryString.append("AND ari.ars_download_date IS NULL ");
			}
			
			queryString.append("ORDER BY ari.ari_refund_request_dt DESC ");
			
			Query query = HibernateSessionFactory.getSession().createSQLQuery(queryString.toString())
												 .addScalar("gridKey")
												 .addScalar("ariDesignatedRefundeeDob", TimestampType.INSTANCE)
												 .addScalar("ariDesignatedRefundeeAlsNo", IntegerType.INSTANCE)
												 .addScalar("refundeeName")
												 .addScalar("usagePeriodFrom", DateType.INSTANCE)
												 .addScalar("usagePeriodTo", DateType.INSTANCE)
												 .addScalar("itemTypeCd", IntegerType.INSTANCE)
												 .addScalar("itemTypeDesc")
												 .addScalar("itemIndDesc")
												 .addScalar("reasonDesc")
												 .addScalar("refundRequestDt", DateType.INSTANCE)
												 .addScalar("ariRefundProcessDt", TimestampType.INSTANCE)
												 .addScalar("ariRefundAmt", DoubleType.INSTANCE)
												 .addScalar("ariRefundApproved")
												 .addScalar("ariDrawingFee", DoubleType.INSTANCE)
												 .addScalar("ariDrawingFeeApproved")
												 .addScalar("ariPreferenceFee", DoubleType.INSTANCE)
												 .addScalar("ariPreferenceFeeApproved")
												 .addScalar("arsDownloadDate", TimestampType.INSTANCE)
												 .addScalar("batchNo", IntegerType.INSTANCE)
												 .addScalar("subBatchNo", IntegerType.INSTANCE)
												 .addScalar("ariReasonDisapproval")
												 .setResultTransformer(Transformers.aliasToBean(PersonRefundAppDTO.class));

			if(!srchAll){
				query.setDate("defaultDate", c.getTime());
			}
			if(!DalUtils.isNil(dob)){
				query.setDate("dob", dob);
			}
			if(!DalUtils.isNil(alsNo)){
				query.setInteger("alsNo", alsNo);
			}
			if(!DalUtils.isNil(upFrom)){
				query.setDate("upFrom", upFrom);
			}
			if(!DalUtils.isNil(upTo)){
				query.setDate("upTo", upTo);
			}
			if(!DalUtils.isNil(itemTypeCd)){
				query.setInteger("itemTypeCd", itemTypeCd);
			}
			if(!DalUtils.isNil(reasonCd)){
				query.setInteger("reasonCd", reasonCd);
			}
			if(!DalUtils.isNil(itemIndCd)){
				query.setInteger("itemIndCd", itemIndCd);
			}
			if(!DalUtils.isNil(warCreateDt)){
				query.setDate("warCreateDt", warCreateDt);
			}
			if(!DalUtils.isNil(itemFeeRefApp)){
				if(!"O".equals(itemFeeRefApp)){
					query.setString("itemFeeRefApp", itemFeeRefApp);
				}
			}
			if(!DalUtils.isNil(appFeeRefApp)){
				if(!"O".equals(appFeeRefApp)){
					query.setString("appFeeRefApp", appFeeRefApp);
				}
			}
			if(!DalUtils.isNil(prefFeeRefApp)){
				if(!"O".equals(prefFeeRefApp)){
					query.setString("prefFeeRefApp", prefFeeRefApp);
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
	
	/**
	 * returns Application Type for use in PersonRefundAppDTO filtered by 
	 * @param itemTypeCd
	 * @return String
	 */
	public String getAppType(Integer itemTypeCd) {
		List<String> lst = new ArrayList<String>();
		String rtn = null;
		try {
			String queryString = "SELECT SUBSTR(APT_APP_TYPE_DESC, INSTR(APT_APP_TYPE_DESC,' ')+1) appDesc "
								+ "FROM   ALS.ALS_PREAPP_TYPE APT, "
										+ "ALS.ALS_PERSON_ITEM_TEMPL_LINK APIT "
								+ "WHERE  APITL_ITEM_TYPE_CD = :itemTypeCd "
								+ "AND    APT.APT_APP_TYPE_CD = APIT.APT_APP_TYPE_CD "
								+ "AND    APT.APT_DATA_ENTRY = APIT.APT_DATA_ENTRY  "
								+ "AND    APT.APT_DATA_ENTRY = 2 "
								+ "AND    Rtrim(SUBSTR(APT_APP_TYPE_DESC,1,INSTR(APT_APP_TYPE_DESC,' '))) in ('RESIDENT','NONRESIDENT') "
								+ "AND    Rownum < 2 "
								+ "UNION "
								+ "SELECT APT_APP_TYPE_DESC  appDesc "
								+ "FROM   ALS.ALS_PREAPP_TYPE APT, ALS.ALS_PERSON_ITEM_TEMPL_LINK APIT "
								+ "WHERE  APITL_ITEM_TYPE_CD = :itemTypeCd "
								+ "AND    APT.APT_APP_TYPE_CD = APIT.APT_APP_TYPE_CD "
								+ "AND    APT.APT_DATA_ENTRY = APIT.APT_DATA_ENTRY "
								+ "AND    APT.APT_DATA_ENTRY = 2 "
								+ "AND    Rtrim(SUBSTR(APT_APP_TYPE_DESC,1,INSTR(APT_APP_TYPE_DESC,' '))) not in ('RESIDENT','NONRESIDENT')";

			
			Query query = HibernateSessionFactory.getSession().createSQLQuery(queryString)
																.addScalar("appDesc")
																.setInteger("itemTypeCd", itemTypeCd);
												 
			
			
			lst = query.list();
			if(!lst.isEmpty()){
				rtn = lst.get(lst.size()-1);
			}
		} catch (HibernateException he){
			System.out.println(he.toString());
		}
		catch (RuntimeException re) {
			System.out.println(re.toString());
		}
		finally {
			HibernateSessionFactory.getSession().close();
		}
		return rtn;
	}
	
	
	
	
	
	
	
	
	
	
}
