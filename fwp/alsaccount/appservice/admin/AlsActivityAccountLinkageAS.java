package fwp.alsaccount.appservice.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsActivityAccountLinkage;
import fwp.alsaccount.dao.admin.AlsActivityAccountLinkageDAO;
import fwp.alsaccount.dao.admin.AlsActivityAccountLinkageIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.alsaccount.hibernate.utils.DalUtils;


/**
 * @author 
 * 
 */
public class AlsActivityAccountLinkageAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsActivityAccountLinkageDAO.class);
	
	/**
	 * returns a list of AlsActivityAccountLinkage filtered by where clause and ordered by rgc_name
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsActivityAccountLinkage instances by where filter");
		try {
			String queryString = " from AlsActivityAccountLinkage";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsActivityAccountLinkage findById(AlsActivityAccountLinkageIdPk id){
		AlsActivityAccountLinkageDAO dao = new AlsActivityAccountLinkageDAO();
		
		AlsActivityAccountLinkage code;
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
	 * Saves any AlsActivityAccountLinkage using the merge function
	 * @param rgsCode
	 */
	public AlsActivityAccountLinkageIdPk save(AlsActivityAccountLinkage tmp){
		log.debug("saving AlsActivityAccountLinkage");
		Transaction tx = null;
		AlsActivityAccountLinkageIdPk id;
		AlsActivityAccountLinkage bac = new AlsActivityAccountLinkage();
		AlsActivityAccountLinkageDAO dao = new AlsActivityAccountLinkageDAO();
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
	public void delete(AlsActivityAccountLinkage rsgCode){
		log.debug("deleting AlsActivityAccountLinkage");
		Transaction tx = null;
		AlsActivityAccountLinkageDAO dao = new AlsActivityAccountLinkageDAO();
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
