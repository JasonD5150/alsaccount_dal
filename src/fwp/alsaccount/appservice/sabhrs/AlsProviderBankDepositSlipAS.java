package fwp.alsaccount.appservice.sabhrs;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.sabhrs.AlsProviderBankDepositSlip;
import fwp.alsaccount.dao.sabhrs.AlsProviderBankDepositSlipDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;

/**
 * @author cfa027
 * 
 */
public class AlsProviderBankDepositSlipAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsProviderBankDepositSlipDAO.class);
	
	/**
	 * returns a list of AlsProviderBankDepositSlip filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsProviderBankDepositSlip instances by where filter");
		try {
			String queryString = " from AlsProviderBankDepositSlip";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsProviderBankDepositSlip findById(Integer id){
		AlsProviderBankDepositSlipDAO dao = new AlsProviderBankDepositSlipDAO();
		
		AlsProviderBankDepositSlip code;
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
	 * Saves any AlsProviderBankDepositSlip using the merge function
	 * @param AlsProviderBankDepositSlip
	 */
	public void save(AlsProviderBankDepositSlip tmp){
		log.debug("saving AlsProviderBankDepositSlip");
		Transaction tx = null;
		AlsProviderBankDepositSlipDAO dao = new AlsProviderBankDepositSlipDAO();
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
	 * delete an existing AlsProviderBankDepositSlip
	 * @param AlsProviderBankDepositSlip
	 */
	public void delete(AlsProviderBankDepositSlip AlsProviderBankDepositSlip){
		log.debug("deleting AlsProviderBankDepositSlip");
		Transaction tx = null;
		AlsProviderBankDepositSlipDAO dao = new AlsProviderBankDepositSlipDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsProviderBankDepositSlip);
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
	 * This method gets the next sequence number.
	 * @return
	 */
	public Integer getNextSeqNo() {
		Integer retSeqNo = 0;
		try {
			String queryString = " SELECT MAX(apbds_id)+1 seq" +
								 "   FROM ALS.Als_Provider_Bank_Deposit_Slip ";

			Query query = HibernateSessionFactory.getSession().createSQLQuery(queryString)
																	.addScalar("seq", IntegerType.INSTANCE);;
			
			retSeqNo = (Integer) query.uniqueResult();
			if(retSeqNo == null){
				retSeqNo = 1;
			}
		} catch (RuntimeException re) {	
			throw re;	
		}
		
		return retSeqNo;
	}

	/**
	 * returns a list of AlsProviderBankDepositSlip by AlsProviderBankDetails Id
	 * @param provNo
	 * @param bpTo
	 * @param seqNo
	 * @return List<AlsProviderBankDepositSlip>
	 */
	public List<AlsProviderBankDepositSlip> findByApbdId(Integer provNo, Timestamp bpTo, Integer seqNo) {
		List<AlsProviderBankDepositSlip> lst = new ArrayList<AlsProviderBankDepositSlip>(); 
		try {
			String queryString = " FROM AlsProviderBankDepositSlip "
								+ "WHERE apiProviderNo = :provNo "
								+ "AND apbdBillingTo = :bpTo "		
								+ "AND apbdSeqNo = :seqNo ";
			
												
			Query query = HibernateSessionFactory.getSession().createQuery(queryString)
															  .setInteger("provNo", provNo)
															  .setTimestamp("bpTo", bpTo)
															  .setInteger("seqNo", seqNo);
			
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
