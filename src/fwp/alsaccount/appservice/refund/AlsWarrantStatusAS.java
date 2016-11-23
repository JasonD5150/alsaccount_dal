package fwp.alsaccount.appservice.refund;

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
import org.hibernate.type.TimestampType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







import fwp.alsaccount.dao.refund.AlsWarrantStatus;
import fwp.alsaccount.dao.refund.AlsWarrantStatusDAO;
import fwp.alsaccount.dto.admin.PersonRefundAppDTO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.alsaccount.hibernate.utils.DalUtils;

/**
 * @author cfa027
 * 
 */
public class AlsWarrantStatusAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsWarrantStatusDAO.class);
	
	/**
	 * returns a list of AlsWarrantStatus filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsWarrantStatus instances by where filter");
		try {
			String queryString = " from AlsWarrantStatus";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	
	/**
	 * Saves any AlsWarrantStatus using the merge function
	 * @param AlsWarrantStatus
	 */
	public void save(AlsWarrantStatus tmp){
		log.debug("saving AlsWarrantStatus");
		Transaction tx = null;
		AlsWarrantStatusDAO dao = new AlsWarrantStatusDAO();
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
	 * delete an existing AlsWarrantStatus
	 * @param alsItemResidency
	 */
	public void delete(AlsWarrantStatus adc){
		log.debug("deleting AlsWarrantStatus");
		Transaction tx = null;
		AlsWarrantStatusDAO dao = new AlsWarrantStatusDAO();
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
	 * returns a list of AlsWarrantStatus filtered by 
	 * @param downloadDt
	 * @param apiDob
	 * @param apiAlsNo
	 * @return List<AlsWarrantStatus>
	 */
	public List<AlsWarrantStatus> getPersonRefundWarrantStatusRecords(Date 	downloadDt, Date apiDob, Integer apiAlsNo) {
		List<AlsWarrantStatus> lst = new ArrayList<AlsWarrantStatus>(); 
		try {
			StringBuilder queryString = new StringBuilder(" FROM AlsWarrantStatus "
															+ "WHERE substr(aws_trans_ref_no,4,8) = to_char(:downloadDt,'YYYYMMDD')"
															+ "AND substr(aws_vendor_id,1,7) = to_char(:apiDob,'MMDDYYY')"
															+ "AND substr(aws_vendor_id,8,3) = to_char(:apiAlsNo,'FM000')");
	
			
			Query query = HibernateSessionFactory.getSession().createQuery(queryString.toString())
												 .setDate("downloadDt", downloadDt)
												 .setDate("apiDob", apiDob)
												 .setInteger("apiAlsNo", apiAlsNo);

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
