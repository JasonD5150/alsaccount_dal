package fwp.alsaccount.appservice.admin;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsTribeItemInfo;
import fwp.alsaccount.dao.admin.AlsTribeItemInfoDAO;
import fwp.alsaccount.dao.admin.AlsTribeItemInfoIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;



/**
 * @author CF0006
 *
 */
public class AlsTribeItemInfoAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsTribeItemInfoDAO.class);
	
	
	/**
	 * @param idPk
	 * @return
	 */
	public AlsTribeItemInfo findById(AlsTribeItemInfoIdPk idPk){
		AlsTribeItemInfoDAO dao = new AlsTribeItemInfoDAO();
		
		AlsTribeItemInfo toReturn;
		try {
			toReturn = dao.findById(idPk);
		} catch (RuntimeException re) {	
			throw re;	
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return toReturn;
	}
	
	
	

	
	/**
	 * @param tmp
	 */
	public void save(List<AlsTribeItemInfo> tmp){
		log.debug("saving AlsTribeInfo");
		Transaction tx = null;
		AlsTribeItemInfoDAO dao = new AlsTribeItemInfoDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			
			for (AlsTribeItemInfo item : tmp) {
				dao.merge(item);
			}
			
			
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
 * @param alsTribeItemInfo
 */
public void delete(AlsTribeItemInfo alsTribeItemInfo){
	log.debug("deleting AlsTribeInfo");
	Transaction tx = null;
	AlsTribeItemInfoDAO dao = new AlsTribeItemInfoDAO();
	try{
		Session session = dao.getSession();
		tx = session.beginTransaction();
		dao.delete(alsTribeItemInfo);
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

	}
	
