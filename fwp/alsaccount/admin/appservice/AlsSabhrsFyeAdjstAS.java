package fwp.alsaccount.admin.appservice;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.alsaccount.hibernate.dao.AlsSabhrsFyeAdjst;
import fwp.alsaccount.hibernate.dao.AlsSabhrsFyeAdjstDAO;
import fwp.alsaccount.hibernate.utils.ListComp;

/**
 * Application service for the ALS Item Control Table functions
 * 
 * @author CF5898
 * 
 */
public class AlsSabhrsFyeAdjstAS {
	
	private static final Logger log = LoggerFactory.getLogger(AlsSabhrsFyeAdjstDAO.class);

	/**
	 * returns a list of AlsSabhrsFyeAdjst objects
	 * @param where the Where clause to filter the result list
	 * @return List The list of AlsSabhrsFyeAdjst objects returned from the query
	 */
	@SuppressWarnings("unchecked")
	public List<AlsSabhrsFyeAdjst> findAllByWhere(String where) {

		try {
			String queryString = " from AlsSabhrsFyeAdjst ";
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


	/**
	 * Saves an AlsSabhrsFyeAdjst using the merge function
	 * @param AlsSabhrsFyeAdjst
	 */
	public Integer save(AlsSabhrsFyeAdjst tmp){
		log.debug("saving AlsSabhrsFyeAdjst");
		Transaction tx = null;
		Integer id;
		AlsSabhrsFyeAdjst misc = new AlsSabhrsFyeAdjst();
		AlsSabhrsFyeAdjstDAO dao = new AlsSabhrsFyeAdjstDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			misc = dao.merge(tmp);			
			tx.commit();
			id = misc.getAsfaBudgetYear();
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
		
		return id;
	}
	
	/**
	 * delete an existing AlsSabhrsFyeAdjst
	 * @param AlsSabhrsFyeAdjst
	 */
	public void delete(AlsSabhrsFyeAdjst AlsSabhrsFyeAdjst){
		log.debug("deleting AlsSabhrsFyeAdjst");
		Transaction tx = null;
		AlsSabhrsFyeAdjstDAO dao = new AlsSabhrsFyeAdjstDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsSabhrsFyeAdjst);
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
	
	public AlsSabhrsFyeAdjst findById(Integer id){
		AlsSabhrsFyeAdjstDAO dao = new AlsSabhrsFyeAdjstDAO();
		
		AlsSabhrsFyeAdjst api=null;
		try{
			api = dao.findById(id);
		} catch (RuntimeException re) {
			log.error(re.getMessage(), re);
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return api;
	}
	
}
