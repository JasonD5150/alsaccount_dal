package fwp.alsaccount.appservice.refund;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.dto.item.AlsItemStatisticsDTO;
import fwp.als.hibernate.HibernateSessionFactory;
import fwp.als.hibernate.item.dao.AlsItemInformation;
import fwp.als.hibernate.item.dao.AlsItemInformationDAO;
import fwp.als.hibernate.item.dao.AlsItemInformationIdPk;
import fwp.als.hibernate.provider.dao.AlsProviderInfo;

/**
 * Application service for the ALS Item Information Table functions
 * 
 * @author CF5898
 * 
 */
public class AlsItemInformationAS {
	
	private static final Logger log = LoggerFactory.getLogger(AlsItemInformationDAO.class);

	/**
	 * returns a list of AlsPersonItemInformation objects
	 * @param where the Where clause to filter the result list
	 * @return List The list of AlsItemInformation objects returned from the query
	 */
	@SuppressWarnings("unchecked")
	public List<AlsItemInformation> findAllByWhere(String where) {

		try {
			String queryString = " from AlsItemInformation ";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		}
		catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Long> retrieveCountFromItemInformation(String aictItemTypeCd, Date aictUsagePeriodFrom, Date aictUsagePeriodTo, String residencyInd)
	{
		
		log.debug("find all AlsCombinedItemType by");
		List<Long> itemInformationList  = null;

		try {
			String queryString = "Select count(aII.aiiResidencyStatus) from AlsItemInformation aII, AlsItemResidency r " +
					" WHERE aII.idPk.aictItemTypeCd = r.idPk.aictItemTypeCd " +
					" AND aII.idPk.aictUsagePeriodFrom = r.idPk.aictUsagePeriodFrom" +
					" AND aII.idPk.aictUsagePeriodTo = r.idPk.aictUsagePeriodTo " +
					" AND (r.idPk.airResidencyInd = 'B' or (aII.aiiResidencyStatus = r.idPk.airResidencyInd)) " +
					" AND aII.idPk.aictUsagePeriodFrom = :usagePeriodFrom " +
					" AND aII.idPk.aictUsagePeriodTo = :usagePeriodTo " +
					" AND aII.idPk.aictItemTypeCd = :itemTypeCd " +
					" and aII.aisItemStatusCd = 1 ";


			Query query = HibernateSessionFactory.getSession().createQuery(queryString);
			query.setDate("usagePeriodFrom", aictUsagePeriodFrom);
			query.setDate("usagePeriodTo", aictUsagePeriodTo);
			query.setString("itemTypeCd", aictItemTypeCd);

			itemInformationList = query.list();
		} catch (RuntimeException re) {
			System.out.println(re.toString());
		}

		finally {
			HibernateSessionFactory.closeSession();
		}
		return itemInformationList;
	}
	
	/**
	 * Saves any AlsItemInformation using the merge function
	 * @param tmp AlsItemInformation object
	 */
	public void save(AlsItemInformation tmp){
		log.debug("saving AlsItemInformation");
		Transaction tx = null;
		AlsItemInformationDAO dao = new AlsItemInformationDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.merge(tmp);			
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			log.error(re.getMessage(), re);
			throw re;			
		}finally{
			try{
				dao.getSession().close();
			}catch(Exception e){
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * delete an existing AlsItemInformation
	 * @param ari AlsItemInformation entity
	 */
	public void delete(AlsItemInformation ari){
		log.debug("deleting AlsItemInformation");
		Transaction tx = null;
		AlsItemInformationDAO dao = new AlsItemInformationDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(ari);
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			log.error(re.getMessage(), re);
			throw re;
		}finally{
			try {
				dao.getSession().close();
			} catch(Exception e){
				log.error(e.getMessage(), e);
			}
		}
	}
	
	public Integer getNextSeqNo(Timestamp aictUsagePeriodFrom, Timestamp aictUsagePeriodTo, String aictItemTypeCd, Timestamp apiDob, Integer apiAlsNo,
			String aiiItemTxnInd){
		Integer nextVal = null;
		if(aictUsagePeriodFrom == null || aictUsagePeriodTo == null || aictItemTypeCd == null || apiDob == null || apiAlsNo == null ||
				aiiItemTxnInd == null){
			return nextVal;
		}
		try{
			StringBuilder sql = new StringBuilder(" select Nvl(Max(t.AII_SEQ_NO)+1,1) nextVal  from ALS.ALS_ITEM_INFORMATION t ");
				sql.append(" where t.aict_Usage_Period_From = :aictUsagePeriodFrom and  t.aict_Usage_Period_To = :aictUsagePeriodTo ");
				sql.append(" and t.aict_Item_Type_Cd = :aictItemTypeCd and t.api_dob = :apiDob and t.api_als_no = :apiAlsNo ");
				sql.append(" and t.aii_Item_Txn_Ind = :aiiItemTxnInd ");
				
			Query queryObject = HibernateSessionFactory.getSession()
					.createSQLQuery(sql.toString())
	                .addScalar("nextVal",IntegerType.INSTANCE)
	                .setParameter("aictUsagePeriodFrom", aictUsagePeriodFrom)
	                .setParameter("aictUsagePeriodTo", aictUsagePeriodTo)
	                .setParameter("aictItemTypeCd", aictItemTypeCd)
	                .setParameter("apiDob", apiDob)
	                .setParameter("apiAlsNo", apiAlsNo)
	                .setParameter("aiiItemTxnInd", aiiItemTxnInd);

			nextVal = (Integer) queryObject.uniqueResult();
		}catch(Exception re){
			log.error(re.getMessage(), re);			
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return nextVal;
	}
	
	public AlsItemInformation findById(AlsItemInformationIdPk idPk){
		AlsItemInformationDAO dao = new AlsItemInformationDAO();
		
		AlsItemInformation aii=null;
		try{
			aii = dao.findById(idPk);
		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return aii;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<AlsItemInformation> getPersonRefundRecords(Date aictUsagePeriodFrom, Date aictUsagePeriodTo, String aictItemTypeCd,
															Timestamp apiDob, Integer apiAlsNo, String itemTxnInd, Integer aiiSeqNo){
		List<AlsItemInformation> aiiLst = new ArrayList<AlsItemInformation>();
		try{
			StringBuilder query = new StringBuilder(" FROM AlsItemInformation  "
													+ "WHERE Trunc(Aict_Usage_Period_From) = :aictUsagePeriodFrom "
													+ "AND Trunc(Aict_Usage_Period_To) = :aictUsagePeriodTo "
													+ "AND Aict_Item_Type_Cd = :Als_Person_Refund_Info_Blk.Aict_Item_Type_Code "
													+ "AND Trunc(Api_Dob) = :apiDob "
													+ "AND Api_Als_No = :apiAlsNo "
													+ "AND Aii_Item_Txn_Ind = :itemTxnInd "
													+ "AND Aii_Seq_No = :Als_Person_Refund_Info_Blk.Aii_Seq_No");
			
			Query queryObject = HibernateSessionFactory.getSession().createQuery(query.toString())
																	.setDate("aictUsagePeriodFrom", aictUsagePeriodFrom)
																	.setDate("aictUsagePeriodTo", aictUsagePeriodTo)
																	.setString("aictItemTypeCd", aictItemTypeCd)
																	.setDate("apiDob", apiDob)
																	.setInteger("apiAlsNo", apiAlsNo)
																	.setString("itemTxnInd",itemTxnInd)
																	.setInteger("aiiSeqNo", aiiSeqNo);
			
			aiiLst = queryObject.list();
		}catch(Exception ex){
			log.error("findByPkStatus failed", ex);
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return aiiLst;
	}
	
	
}
