package fwp.alsaccount.appservice.admin;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







import fwp.alsaccount.dao.admin.AlsTribeInfo;
import fwp.alsaccount.dao.admin.AlsTribeInfoDAO;
import fwp.alsaccount.dao.admin.AlsTribeItemInfoDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsItemTypeAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsTribeItemInfoDAO.class);
	
	/**
	 * returns a list of AlsTribeInfo filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all Tribe Item instances by where filter");
		try {
			String queryString = " from AlsTribeItemInfo";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	/*public AlsTribeInfo findById(String atiTribeCd){
		AlsTribeInfoDAO dao = new AlsTribeInfoDAO();
		
		AlsTribeInfo tibeInfo;
		try {
			tibeInfo = dao.findById(atiTribeCd);
		} catch (RuntimeException re) {	
			throw re;	
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return tibeInfo;
	}
	*/
	
	
/*public Boolean isDuplicateEntry(String atiTribeCd) {
		
		Boolean retVal = false;
		
		try {
			AlsTribeInfo ati = this.findById(atiTribeCd);
			if(ati != null){
				retVal = true;
			}

		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}*/

/**
 * Saves any AlsTribeInfo using the merge function
 * @param AlsTribeInfo
 */
/*public void save(AlsTribeInfo tmp){
	log.debug("saving AlsTribeInfo");
	Transaction tx = null;
	AlsTribeInfoDAO dao = new AlsTribeInfoDAO();
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
}*/
	

/**
 * delete an existing AlsTribeInfo
 * @param alsTribeInfo
 */

/*public void delete(AlsTribeInfo alsTribeInfo){
	log.debug("deleting AlsTribeInfo");
	Transaction tx = null;
	AlsTribeInfoDAO dao = new AlsTribeInfoDAO();
	try{
		Session session = dao.getSession();
		tx = session.beginTransaction();
		dao.delete(alsTribeInfo);
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
}*/

}
