package fwp.alsaccount.appservice.sales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.TimestampType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.hibernate.item.dao.AlsItemApplFeeAcct;
import fwp.als.hibernate.item.dao.AlsItemApplFeeAcctDAO;
import fwp.als.hibernate.item.dao.AlsItemApplFeeAcctIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.alsaccount.hibernate.utils.DalUtils;




/**
 * @author cfa027
 * 
 */
public class AlsItemApplFeeAcctAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsItemApplFeeAcctDAO.class);
	
	/**
	 * returns a list of AlsItemApplFeeAcct filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsItemApplFeeAcct instances by where filter");
		try {
			String queryString = " from AlsItemApplFeeAcct";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsItemApplFeeAcct findById(AlsItemApplFeeAcctIdPk id){
		AlsItemApplFeeAcctDAO dao = new AlsItemApplFeeAcctDAO();
		
		AlsItemApplFeeAcct code;
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
	 * Saves any AlsItemApplFeeAcct using the merge function
	 * @param AlsItemApplFeeAcct
	 */
	public void save(AlsItemApplFeeAcct tmp){
		log.debug("saving AlsItemApplFeeAcct");
		Transaction tx = null;
		AlsItemApplFeeAcctDAO dao = new AlsItemApplFeeAcctDAO();
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
	 * delete an existing AlsItemApplFeeAcct
	 * @param AlsItemApplFeeAcct
	 */
	public void delete(AlsItemApplFeeAcct AlsItemApplFeeAcct){
		log.debug("deleting AlsItemApplFeeAcct");
		Transaction tx = null;
		AlsItemApplFeeAcctDAO dao = new AlsItemApplFeeAcctDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsItemApplFeeAcct);
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
	 * returns a list of AlsItemApplFeeAcctIdPk filtered
	 * @param transCd
	 * @param groupId
	 * @param provNo
	 * @param iafaSeqNo
	 * @param bpFromDt
	 * @param bpToDt
	 * @return List<AlsItemApplFeeAcctIdPk>
	 */
	public List<AlsItemApplFeeAcctIdPk> getManualProviderAdjEntriesRecords(String groupId, Integer provNo, Integer iafaSeqNo, Date bpFromDt, Date	bpToDt) {
		List<AlsItemApplFeeAcctIdPk> lst = new ArrayList<AlsItemApplFeeAcctIdPk>(); 
		try {
			String queryString = "SELECT a.API_PROVIDER_NO apiProviderNo, "
									  + "a.APR_BILLING_FROM aprBillingFrom, "
									  + "a.APR_BILLING_To aprBillingTo, "
									  + "a.AIAFA_SEQ_NO aiafaSeqNo "
								+ "FROM ALS.ALS_ITEM_APPL_FEE_ACCT a "
								+ "WHERE a.AIAFA_STATUS = 'A' "
								+ "AND a.AIAFA_AMT <> 0 "
								+ "AND EXISTS (SELECT 1 From ALS.ALS_SABHRS_ENTRIES b "
											+ "WHERE b.API_PROVIDER_NO = a.API_PROVIDER_NO "
											+ "And b.APR_BILLING_FROM = a.APR_BILLING_FROM "
											+ "And b.APR_BILLING_TO = a.APR_BILLING_TO "
											+ "AND b.AIAFA_SEQ_NO = a.AIAFA_SEQ_NO "
											+ "And b.ATG_TRANSACTION_CD = 8 "
											+ "And b.ATGS_GROUP_IDENTIFIER LIKE :groupId) ";
												
			
			if(!DalUtils.isNil(provNo)){
				queryString += "AND a.API_PROVIDER_NO = :provNo ";
			}
			if(!DalUtils.isNil(iafaSeqNo)){
				queryString += "AND a.AIAFA_SEQ_NO = :iafaSeqNo ";		
			}
			if(!DalUtils.isNil(bpFromDt)){
				queryString += "AND a.APR_BILLING_FROM = :bpFromDt ";	
			}
			if(!DalUtils.isNil(bpToDt)){
				queryString += "AND a.APR_BILLING_TO = :bpToDt ";	
			}
			queryString += "ORDER BY a.API_PROVIDER_NO,a.APR_BILLING_FROM,a.APR_BILLING_TO,a.AIAFA_SEQ_NO ";
			
			Query query = HibernateSessionFactory.getSession().createSQLQuery(queryString)
												 .addScalar("apiProviderNo", IntegerType.INSTANCE)
												 .addScalar("aprBillingFrom", TimestampType.INSTANCE)
												 .addScalar("aprBillingTo", TimestampType.INSTANCE)
												 .addScalar("aiafaSeqNo", IntegerType.INSTANCE)
												 .setString("groupId", groupId)
												 .setResultTransformer(Transformers.aliasToBean(AlsItemApplFeeAcctIdPk.class));


			if(!DalUtils.isNil(provNo)){
				query.setInteger("provNo", provNo);
			}
			if(!DalUtils.isNil(iafaSeqNo)){
				query.setInteger("iafaSeqNo", iafaSeqNo);
			}
			if(!DalUtils.isNil(bpFromDt)){
				query.setDate("bpFromDt", bpFromDt);
			}
			if(!DalUtils.isNil(bpToDt)){
				query.setDate("bpToDt", bpToDt);
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
