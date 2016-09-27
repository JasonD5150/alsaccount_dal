package fwp.alsaccount.appservice.sabhrs;

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

import fwp.als.hibernate.item.dao.AlsItemApplFeeAcctIdPk;
import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries;
import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesDAO;
import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntriesIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.alsaccount.hibernate.utils.DalUtils;




/**
 * @author cfa027
 * 
 */
public class AlsSabhrsEntriesAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsSabhrsEntriesDAO.class);
	
	/**
	 * returns a list of AlsSabhrsEntries filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsSabhrsEntries instances by where filter");
		try {
			String queryString = " from AlsSabhrsEntries";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsSabhrsEntries findById(AlsSabhrsEntriesIdPk id){
		AlsSabhrsEntriesDAO dao = new AlsSabhrsEntriesDAO();
		
		AlsSabhrsEntries code;
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
	 * Saves any AlsSabhrsEntries using the merge function
	 * @param AlsSabhrsEntries
	 */
	public void save(AlsSabhrsEntries tmp){
		log.debug("saving AlsSabhrsEntries");
		Transaction tx = null;
		AlsSabhrsEntriesDAO dao = new AlsSabhrsEntriesDAO();
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
	 * delete an existing AlsSabhrsEntries
	 * @param AlsSabhrsEntries
	 */
	public void delete(AlsSabhrsEntries AlsSabhrsEntries){
		log.debug("deleting AlsSabhrsEntries");
		Transaction tx = null;
		AlsSabhrsEntriesDAO dao = new AlsSabhrsEntriesDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsSabhrsEntries);
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
	 * @param transCd
	 * @param groupId
	 * @param provNo
	 * @param iafaSeqNo
	 * @param bpFromDt
	 * @param bpToDt
	 * @return List<AlsSabhrsEntries>
	 */
	public List<AlsSabhrsEntries> getManualProviderAdjEntriesRecords(Integer provNo, Integer iafaSeqNo, Date bpFromDt, Date bpToDt) {
		List<AlsSabhrsEntries> lst = new ArrayList<AlsSabhrsEntries>(); 
		try {
			String queryString = " FROM AlsSabhrsEntries a "
								+ "WHERE atgTransactionCd = 8 "
								
								+ "AND apiProviderNo = :provNo "
								+ "AND aiafaSeqNo = :iafaSeqNo "		
								+ "AND aprBillingFrom = :bpFromDt "	
								+ "AND aprBillingTo = :bpToDt ";
			
			queryString += "ORDER BY apiProviderNo, aprBillingFrom, aiafaSeqNo";
												
			Query query = HibernateSessionFactory.getSession().createQuery(queryString)
															  .setInteger("provNo", provNo)
															  .setInteger("iafaSeqNo", iafaSeqNo)
															  .setTimestamp("bpFromDt", bpFromDt)
															  .setTimestamp("bpToDt", bpToDt);
			
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
	 * This method counts ALS_SABHRS_RECORDS bases on.
	 * @param transCd
	 * @param groupId
	 * @param provNo
	 * @param iafaSeqNo
	 * @param bpFromDt
	 * @param bpToDt
	 * @return cnt
	 */
	public Integer getSabhrsRecordCnt(Integer transCd, String groupId, Integer provNo, Integer iafaSeqNo, Date bpFromDt, Date bpToDt) {
		Integer cnt = 0;

		String queryString = "Select Nvl(Count(*),0) cnt "
						   + "From Als.Als_Sabhrs_Entries "
						   + "Where Api_Provider_No	= :provNo "
						   + "And Apr_Billing_From = :bpFromDt "
						   + "And Apr_Billing_To = :bpToDt "
						   + "And Aiafa_seq_no = :iafaSeqNo "
						   + "And Atg_Transaction_Cd = :transCd "
						   + "And Atgs_Group_Identifier = :groupId "
						   + "And Asac_System_Activity_Type_Cd = 'Z' "
						   + "And Asac_Txn_Cd = '9'";

		try {
			Query query = HibernateSessionFactory.getSession().createSQLQuery(queryString)
															  .addScalar("cnt", IntegerType.INSTANCE)
															  .setInteger("transCd", transCd)
															  .setString("groupId", groupId)
															  .setInteger("provNo", provNo)
															  .setInteger("iafaSeqNo", iafaSeqNo)
															  .setTimestamp("bpFromDt", bpFromDt)
															  .setTimestamp("bpToDt", bpToDt);;
		
			cnt = (Integer) query.uniqueResult();
		} catch (RuntimeException re) {
			System.out.println(re.toString());
		}
		finally {
			HibernateSessionFactory.getSession().close();
		}
		return cnt;
	}
	
	/**
	 * returns a list of AlsSabhrsEntries filtered
	 * @param transIdentifier
	 * @param transGrp
	 * @return List<AlsSabhrsEntries>
	 */
	public List<AlsSabhrsEntries> getRemittanceRecords(String transIdentifier, Integer transGrp) {
		List<AlsSabhrsEntries> lst = new ArrayList<AlsSabhrsEntries>(); 
		try {
			String queryString = " FROM AlsSabhrsEntries a "
								+ "WHERE atgsGroupIdentifier = :transIdentifier "
								+ "AND atgTransactionCd = :transGrp "
								+ "AND NVL(ase_non_als_flag,'N')='Y'";
			
			
			queryString += "ORDER BY apiProviderNo, aprBillingFrom, aiafaSeqNo";
												
			Query query = HibernateSessionFactory.getSession().createQuery(queryString)
															  .setString("transIdentifier", transIdentifier)
															  .setInteger("transGrp", transGrp);
			
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
	 * returns a list of AlsSabhrsEntries filtered
	 * @param provNo
	 * @param bpFrom
	 * @param bpTo
	 * @return List<AlsSabhrsEntries>
	 */
	public List<AlsSabhrsEntries> getRemittanceRecords(Integer provNo, Date bpFrom, Date bpTo) {
		List<AlsSabhrsEntries> lst = new ArrayList<AlsSabhrsEntries>(); 
		try {
			String queryString = " FROM AlsSabhrsEntries a "
								+ "WHERE apiProviderNo = :provNo "
								+ "AND aprBillingFrom = :bpFrom "
								+ "AND aprBillingTo = :bpTo "
								+ "AND NVL(ase_non_als_flag,'N')='Y'";
			
			
			queryString += "ORDER BY apiProviderNo, aprBillingFrom, aiafaSeqNo";
												
			Query query = HibernateSessionFactory.getSession().createQuery(queryString)
															  .setInteger("provNo", provNo)
															  .setDate("bpFrom", bpFrom)
															  .setDate("bpTo", bpTo);
			
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
	
	public String getReferenceDesc(Integer asacReference) {		
		String rtn = null;
		if(asacReference == null){
			return "";
		}
		String reference = asacReference.toString().substring(0,asacReference.toString().length()-2);
		String queryStr =  "SELECT am.am_val_desc d "
						 + "FROM ALS.ALS_MISC am "
						 + "WHERE am.am_key1 = 'JOURNAL_LINE_REFERENCE' "
						 + "AND am.am_par_val = :reference";
		
		try {
			Query query = HibernateSessionFactory.getSession().createSQLQuery(queryStr)
															  .addScalar("d")
															  .setString("reference", reference);

			rtn = (String) query.uniqueResult();
		} catch (HibernateException he){
			System.out.println(he.toString());
		}
		catch (RuntimeException re) {
			System.out.println(re.toString());
		} finally {
			HibernateSessionFactory.getSession().close();
		}
		return rtn;
	}
}
