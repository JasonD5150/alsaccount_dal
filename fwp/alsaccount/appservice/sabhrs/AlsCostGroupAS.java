package fwp.alsaccount.appservice.sabhrs;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.sabhrs.AlsCostGroup;
import fwp.alsaccount.dao.sabhrs.AlsCostGroupDAO;
import fwp.alsaccount.dao.sabhrs.AlsCostGroupIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author c81203
 * 
 */
public class AlsCostGroupAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsCostGroupDAO.class);
	
	/**
	 * returns a list of AlsCostGroup filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsCostGroup instances by where filter");
		try {
			String queryString = " from AlsCostGroup";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsCostGroup findById(AlsCostGroupIdPk idPk){
		AlsCostGroupDAO dao = new AlsCostGroupDAO();
		
		AlsCostGroup code;
		try {
			code = dao.findById(idPk);
		} catch (RuntimeException re) {	
			throw re;	
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return code;
	}
	
	/**
	 * Saves any AlsCostGroup using the merge function
	 * @param AlsCostGroup
	 */
	public void save(AlsCostGroup tmp){
		log.debug("saving AlsCostGroup");
		Transaction tx = null;
		AlsCostGroupDAO dao = new AlsCostGroupDAO();
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
	 * delete an existing AlsCostGroup
	 * @param AlsCostGroup
	 */
	public void delete(AlsCostGroup AlsCostGroup){
		log.debug("deleting AlsCostGroup");
		Transaction tx = null;
		AlsCostGroupDAO dao = new AlsCostGroupDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsCostGroup);
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
	 * This method checks for duplicate entries.
	 * @param tmp
	 * @return
	 */
	public Boolean isDuplicateEntry(AlsCostGroupIdPk idPk) {
		
		Boolean retVal = false;
		
		try {
			AlsCostGroup aoc = this.findById(idPk);
			if(aoc != null){
				retVal = true;
			}

		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}

	
}
