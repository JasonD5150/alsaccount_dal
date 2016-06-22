package fwp.alsaccount.appservice.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsSysActivityControl;
import fwp.alsaccount.dao.admin.AlsSysActivityControlDAO;
import fwp.alsaccount.dao.admin.AlsSysActivityControlIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author jla
 * 
 */
public class AlsSysActivityControlAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsSysActivityControlDAO.class);
	
	/**
	 * returns a list of AlsSysActivityControl filtered by where clause and ordered by rgc_name
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsSysActivityControl instances by where filter");
		try {
			String queryString = " from AlsSysActivityControl";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsSysActivityControl findById(AlsSysActivityControlIdPk id){
		AlsSysActivityControlDAO dao = new AlsSysActivityControlDAO();
		
		AlsSysActivityControl code;
		try{
			code = dao.findById(id);
		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return code;
	}
	
	/**
	 * Saves any AlsSysActivityControl using the merge function
	 * @param rgsCode
	 */
	public AlsSysActivityControlIdPk save(AlsSysActivityControl tmp){
		log.debug("saving AlsSysActivityControl");
		Transaction tx = null;
		AlsSysActivityControlIdPk id;
		AlsSysActivityControl bac = new AlsSysActivityControl();
		AlsSysActivityControlDAO dao = new AlsSysActivityControlDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			bac = dao.merge(tmp);			
			tx.commit();
			id = bac.getIdPk();
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
	 * delete an existing BasAccountCode
	 * @param rsgCode
	 */
	public void delete(AlsSysActivityControl rsgCode){
		log.debug("deleting AlsSysActivityControl");
		Transaction tx = null;
		AlsSysActivityControlDAO dao = new AlsSysActivityControlDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(rsgCode);
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
