package fwp.alsaccount.appservice.refund;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.hibernate.HibernateSessionFactory;
import fwp.als.hibernate.item.dao.AlsItemInd;
import fwp.als.hibernate.item.dao.AlsItemIndDAO;
import fwp.als.hibernate.item.dao.AlsItemIndIdPk;

public class AlsItemIndAS {
	private static final Logger log = LoggerFactory.getLogger(AlsItemIndDAO.class);

	
	public  AlsItemInd findById( AlsItemIndIdPk idPk){
		 AlsItemIndDAO dao = new  AlsItemIndDAO();
		
		 AlsItemInd aii=null;
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
	 * Saves any  AlsItemInd using the merge function
	 * @param tmp  AlsItemInd object
	 */
	public void save( AlsItemInd tmp){
		log.debug("saving  AlsItemInd");
		Transaction tx = null;
		 AlsItemIndDAO dao = new  AlsItemIndDAO();
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
	 * delete an existing  AlsItemInd
	 * @param ari  AlsItemInd entity
	 */
	public void delete( AlsItemInd ari){
		log.debug("deleting  AlsItemInd");
		Transaction tx = null;
		 AlsItemIndDAO dao = new  AlsItemIndDAO();
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
	
	/**
	 * Selecting The Max. Value Of Item Index Seq. No. & Adding One To It
	 * @param upFrom
	 * @param upTo
	 * @param itemTypeCd
	 * @param dob
	 * @param alsNo
	 * @param itemTxnInd
	 * @param aiiSeqNo
	 * @return seqNo
	 */
	public Integer getNextItemIndexSeq(Timestamp upFrom, Timestamp upTo, String itemTypeCd, 
									   Timestamp dob, Integer alsNo, String itemTxnInd, 
									   Integer aiiSeqNo) {
		Integer seqNo = null;

		String queryString = "SELECT (nvl(max(Aiin_Item_Ind_Seq_No),0)+1) seqNo "
							+ "FROM Als.Als_Item_Ind"
							+ "WHERE Aict_Usage_Period_From = :upFrom "
							+ "AND Aict_Usage_Period_To = :upTo "
							+ "AND Aict_Item_Type_Cd = :itemTypeCd "
							+ "AND Api_Dob = :dob "
							+ "AND Api_Als_No = :alsNo "
							+ "AND Aii_Item_Txn_Ind = :itemTxnInd "
							+ "AND Aii_Seq_No = :aiiSeqNo ";

		try {
			Query query = HibernateSessionFactory.getSession().createSQLQuery(queryString)
															  .addScalar("seqNo", IntegerType.INSTANCE)
															  .setTimestamp("upFrom", upFrom)
															  .setTimestamp("upTo", upTo)
															  .setString("itemTypeCd", itemTypeCd)
															  .setTimestamp("dob", dob)
															  .setInteger("alsNo", alsNo)
															  .setString("itemTxnInd", itemTxnInd)
															  .setInteger("aiiSeqNo", aiiSeqNo);
		
			seqNo = (Integer) query.uniqueResult();
		} catch (RuntimeException re) {
			System.out.println(re.toString());
		}
		finally {
			HibernateSessionFactory.getSession().close();
		}
		return seqNo;
	}
}
