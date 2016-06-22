package fwp.alsaccount.appservice.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsSysActivityTypeCodes;
import fwp.alsaccount.dao.admin.AlsSysActivityTypeCodesDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author jla
 * 
 */
public class AlsSysActivityTypeCodesAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsSysActivityTypeCodesDAO.class);
	
	/**
	 * returns a list of AlsSysActivityTypeCodes filtered by where clause and ordered by rgc_name
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsSysActivityTypeCodes instances by where filter");
		try {
			String queryString = " from AlsSysActivityTypeCodes";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsSysActivityTypeCodes findById(String id){
		AlsSysActivityTypeCodesDAO dao = new AlsSysActivityTypeCodesDAO();
		
		AlsSysActivityTypeCodes code;
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
	 * Saves any AlsSysActivityTypeCodes using the merge function
	 * @param rgsCode
	 */
	public String save(AlsSysActivityTypeCodes tmp){
		log.debug("saving AlsSysActivityTypeCodes");
		Transaction tx = null;
		String id;
		AlsSysActivityTypeCodes bac = new AlsSysActivityTypeCodes();
		AlsSysActivityTypeCodesDAO dao = new AlsSysActivityTypeCodesDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			bac = dao.merge(tmp);			
			tx.commit();
			id = bac.getAsacSystemActivityTypeCd();
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
	public void delete(AlsSysActivityTypeCodes rsgCode){
		log.debug("deleting AlsSysActivityTypeCodes");
		Transaction tx = null;
		AlsSysActivityTypeCodesDAO dao = new AlsSysActivityTypeCodesDAO();
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

	/**
	 * This method returns System Activity Type Codes Desc
	 * @param sysActivityType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getCodeDesc(String sysActivityType) {
		String rtn = "";

		String where = "SELECT asattc_desc"
					+ "  FROM ALS.ALS_SYS_ACTIVITY_TYPE_TRAN_CDS"
					+ " WHERE asac_system_activity_type_cd ='" + sysActivityType + "'";
		
		try {
			Query query = HibernateSessionFactory.getSession().createSQLQuery(where);
			List<String> descList = query.list();
			if (descList != null && !descList.isEmpty()) {
				rtn = descList.get(0);
			} 
		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return rtn;
	}
}
