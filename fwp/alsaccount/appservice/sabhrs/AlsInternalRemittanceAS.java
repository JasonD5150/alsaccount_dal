package fwp.alsaccount.appservice.sabhrs;

import java.util.ArrayList;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;











import fwp.als.hibernate.inventory.dao.AlsInternalRemittance;
import fwp.als.hibernate.inventory.dao.AlsInternalRemittanceDAO;
import fwp.als.hibernate.inventory.dao.AlsInternalRemittanceIdPk;
import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries;
import fwp.alsaccount.dto.admin.AccCdDistByItemTypeDTO;
import fwp.alsaccount.dto.sabhrs.AlsInternalRemittanceDTO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsInternalRemittanceAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsInternalRemittanceDAO.class);
	
	/**
	 * returns a list of AlsInternalRemittance filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsInternalRemittance instances by where filter");
		try {
			String queryString = " from AlsInternalRemittance";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsInternalRemittance findById(AlsInternalRemittanceIdPk id){
		AlsInternalRemittanceDAO dao = new AlsInternalRemittanceDAO();
		
		AlsInternalRemittance code;
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
	 * Saves any AlsInternalRemittance using the merge function
	 * @param AlsInternalRemittance
	 */
	public void save(AlsInternalRemittance tmp){
		log.debug("saving AlsInternalRemittance");
		Transaction tx = null;
		AlsInternalRemittanceDAO dao = new AlsInternalRemittanceDAO();
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
	 * delete an existing AlsInternalRemittance
	 * @param AlsInternalRemittance
	 */
	public void delete(AlsInternalRemittance AlsInternalRemittance){
		log.debug("deleting AlsInternalRemittance");
		Transaction tx = null;
		AlsInternalRemittanceDAO dao = new AlsInternalRemittanceDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsInternalRemittance);
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
	 * This method gets the next available seq no.
	 * @return
	 */
	public Integer getNextSeqNo() {
		Integer retSeqNo = 0;

		String queryString = "SELECT ALS.ALS_SABHRS_ENTRIES_SEQ.NEXTVAL seq FROM DUAL";

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
	 * returns a list of AlsSabhrsEntries filtered
	 * @param provNo
	 * @param bpFrom
	 * @param bpTo
	 * @return List<AlsSabhrsEntries>
	 */
	public List<AlsInternalRemittanceDTO> getRemittanceRecords(Integer provNo, Date bpFrom, Date bpTo, 
															Boolean hasNonAlsDetails, Boolean hasOverShortDetails, Boolean hasPaeAmt,
															String comByProv, Date comByProvDt, String remittanceApproved, 
															String appBy, Date appDt, String appCom) {
		List<AlsInternalRemittanceDTO> lst = new ArrayList<AlsInternalRemittanceDTO>(); 
		try {
			StringBuilder queryString = new StringBuilder("SELECT a.API_PROVIDER_NO apiProviderNo,"
														+ "a.AIR_BILLING_FROM airBillingFrom,"
														+ "a.AIR_BILLING_TO airBillingTo,"
														+ "a.AIR_EFTDDD eftddd,"
														+ "a.AIR_OTC_PHONE_SALES airOtcPhoneSales,"
														+ "a.AIR_PAE airPae,"
														+ "a.AIR_NON_ALS_SALES airNonAlsSales,"
														+ "a.AIR_CREDIT_SALES airCreditSales,"
														+ "a.AIR_COMPLETE_PROVIDER completeProvider,"
														+ "a.AIR_OFFLN_PAYMENT_APPROVED airOfflnPaymentApproved,"
														+ "a.AIR_OFFLN_PAYMENT_APP_BY airOfflnPaymentAppBy,"
														+ "a.AIR_OFFLN_PAYMENT_APP_DT offlnPaymentAppDt,"
														+ "a.AIR_OFFLN_PAYMENT_APP_COM airOfflnPaymentAppCom,"
														+ "a.AIR_BANK_DEPT_APPROVED airBankDeptApproved,"
														+ "a.AIR_BANK_DEPT_APP_BY airBankDeptAppBy,"
														+ "a.AIR_BANK_DEPT_APP_DT bankDeptAppDt,"
														+ "a.AIR_BANK_DEPT_APP_COM airBankDeptAppCom,"
														+ "a.AIR_OVER_SALES airOverSales,"
														+ "a.AIR_SHORT_SALES airShortSales,"
														+ "a.AIR_SYSTEM_SALES airSystemSales,"
														+ "'false' bankDepEditOnly "
														+ "FROM ALS.Als_Internal_Remittance a "
														+ "WHERE 1=1 ");

			if(provNo != null && !"".equals(provNo)){
				queryString.append("AND a.API_PROVIDER_NO = :provNo ");
			}
			if(bpFrom != null){
				queryString.append("AND a.AIR_BILLING_FROM = :bpFrom ");
			}
			if(bpTo != null){
				queryString.append("AND a.AIR_BILLING_TO = :bpTo ");
			}
			if(hasNonAlsDetails != null && hasNonAlsDetails != false){
				queryString.append("and exists(SELECT 1 FROM ALS.Als_Non_Als_Details b "
											+ "WHERE b.API_PROVIDER_NO = a.API_PROVIDER_NO "
											+ "AND b.AIR_BILLING_FROM = a.AIR_BILLING_FROM "
											+ "AND b.AIR_BILLING_TO = a.AIR_BILLING_TO) ");
			}
			if(hasOverShortDetails != null && hasOverShortDetails != false){
				queryString.append("and exists(SELECT 1 FROM ALS.Als_Over_Under_Sales_Dets c "
											+ "WHERE c.API_PROVIDER_NO = a.API_PROVIDER_NO "
											+ "AND c.AIR_BILLING_FROM = a.AIR_BILLING_FROM "
											+ "AND c.AIR_BILLING_TO = a.AIR_BILLING_TO) ");
			}
			if(hasOverShortDetails != null && hasOverShortDetails != false){
				queryString.append("AND a.AIR_PAE != 0.00 AND a.AIR_PAE IS NOT NULL ");
			}
			if(comByProv != null && !"".equals(comByProv)){
				if("Y".equals(comByProv)){
					queryString.append("AND a.AIR_COMPLETE_PROVIDER IS NOT NULL ");
				}else{
					queryString.append("AND a.AIR_COMPLETE_PROVIDER IS NULL ");
				}
			}
			if(comByProvDt != null){
				queryString.append("AND a.AIR_COMPLETE_PROVIDER = :comByProvDt ");
			}
			if(remittanceApproved != null && !"".equals(remittanceApproved)){
				queryString.append("AND a.AIR_OFFLN_PAYMENT_APPROVED = :remittanceApproved ");
			}
			if(appBy != null && !"".equals(appBy)){
				queryString.append("AND a.AIR_OFFLN_PAYMENT_APP_BY = UPPER(:appBy) ");
			}
			if(appDt != null){
				queryString.append("AND a.AIR_OFFLN_PAYMENT_APP_DT = :appDt ");
			}
			if(appCom != null && !"".equals(appCom)){
				queryString.append("AND a.AIR_OFFLN_PAYMENT_APP_COM LIKE UPPER(:appCom||'%') ");
			}
			//If a provider is chosen add a dummy record to the remittance table for the current billing period.
			//This will allow the Internal Providers to enter deposits throughout the week, before the actual remittance is created.
			if(provNo != null && !"".equals(provNo)){
				queryString.append("UNION "
						+ "SELECT apr.api_provider_no apiProviderNo, "
						+ "MAX(apr.APR_BILLING_FROM) airBillingFrom, "
						+ "MAX(apr.APR_BILLING_TO) airBillingTo,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,"
						+ "'true' bankDepEditOnly " 
						+ "FROM ALS.ALS_PROVIDER_REMITTANCE apr "
						+ "WHERE apr.API_PROVIDER_NO = :provNo "
						+ "GROUP BY apr.api_provider_no ");
			}
			
			queryString.append("ORDER BY apiProviderNo, airBillingFrom DESC");
												
			Query query = HibernateSessionFactory.getSession().createSQLQuery(queryString.toString())
																.addScalar("apiProviderNo", IntegerType.INSTANCE)
																.addScalar("airBillingFrom", DateType.INSTANCE)
																.addScalar("airBillingTo", DateType.INSTANCE)
																.addScalar("eftddd", DateType.INSTANCE)
																.addScalar("airOtcPhoneSales", DoubleType.INSTANCE)
																.addScalar("airPae", DoubleType.INSTANCE)
																.addScalar("airNonAlsSales", DoubleType.INSTANCE)
																.addScalar("airCreditSales", DoubleType.INSTANCE)
																.addScalar("completeProvider", DateType.INSTANCE)
																.addScalar("airOfflnPaymentApproved")
																.addScalar("airOfflnPaymentAppBy")
																.addScalar("offlnPaymentAppDt", DateType.INSTANCE)
																.addScalar("airOfflnPaymentAppCom")
																.addScalar("airBankDeptApproved")
																.addScalar("airBankDeptAppBy")
																.addScalar("bankDeptAppDt", DateType.INSTANCE)
																.addScalar("airBankDeptAppCom")
																.addScalar("airOverSales", DoubleType.INSTANCE)
																.addScalar("airShortSales", DoubleType.INSTANCE)
																.addScalar("airSystemSales", DoubleType.INSTANCE)
																.addScalar("bankDepEditOnly")
																.setResultTransformer(Transformers.aliasToBean(AlsInternalRemittanceDTO.class));;
			
			if(provNo != null && !"".equals(provNo)){
				query.setInteger("provNo", provNo);
			}
			if(bpFrom != null){
				query.setDate("bpFrom", bpFrom);
			}
			if(bpTo != null){
				query.setDate("bpTo", bpTo);
			}
			if(comByProvDt != null){
				query.setDate("comByProvDt", comByProvDt);
			}
			if(remittanceApproved != null && !"".equals(remittanceApproved)){
				query.setString("remittanceApproved", remittanceApproved);
			}
			if(appBy != null && !"".equals(appBy)){
				query.setString("appBy", appBy);
			}
			if(appDt != null){
				query.setDate("appDt", appDt);
			}
			if(appCom != null && !"".equals(appCom)){
				query.setString("appCom", appCom);
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
