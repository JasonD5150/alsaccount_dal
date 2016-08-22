package fwp.alsaccount.appservice.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.hibernate.item.dao.AlsItemCategory;
import fwp.als.hibernate.item.dao.AlsItemCategoryDAO;
import fwp.als.hibernate.item.dao.AlsItemCategoryIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author c81203
 * 
 */
public class AlsItemCategoryAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsItemCategoryDAO.class);
	
	/**
	 * returns a list of AlsItemCategory filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsItemCategory instances by where filter");
		try {
			String queryString = " from AlsItemCategory";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsItemCategory findById(AlsItemCategoryIdPk idPk){
		AlsItemCategoryDAO dao = new AlsItemCategoryDAO();
		
		AlsItemCategory code;
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
	 * Saves any AlsItemCategory using the merge function
	 * @param AlsItemCategory
	 */
	public void save(AlsItemCategory tmp){
		log.debug("saving AlsItemCategory");
		Transaction tx = null;
		AlsItemCategoryDAO dao = new AlsItemCategoryDAO();
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
	 * delete an existing AlsItemCategory
	 * @param AlsItemCategory
	 */
	public void delete(AlsItemCategory AlsItemCategory){
		log.debug("deleting AlsItemCategory");
		Transaction tx = null;
		AlsItemCategoryDAO dao = new AlsItemCategoryDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsItemCategory);
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
	public Boolean isDuplicateEntry(AlsItemCategoryIdPk idPk) {
		
		Boolean retVal = false;
		
		try {
			AlsItemCategory aoc = this.findById(idPk);
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
