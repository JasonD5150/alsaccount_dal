package fwp.alsaccount.appservice.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.hibernate.admin.dao.AlsSysActivityTypeTranCds;
import fwp.als.hibernate.admin.dao.AlsSysActivityTypeTranCdsDAO;
import fwp.als.hibernate.admin.dao.AlsSysActivityTypeTranCdsIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author jla
 * 
 */
public class AlsSysActivityTypeTranCdsAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsSysActivityTypeTranCdsDAO.class);
	
	/**
	 * returns a list of AlsSysActivityTypeTranCds filtered by where clause and ordered by rgc_name
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsSysActivityTypeTranCds instances by where filter");
		try {
			
			String queryString = " from AlsSysActivityTypeTranCds";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsSysActivityTypeTranCds findById(AlsSysActivityTypeTranCdsIdPk id){
		AlsSysActivityTypeTranCdsDAO dao = new AlsSysActivityTypeTranCdsDAO();
		
		AlsSysActivityTypeTranCds code;
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
	 * Saves any AlsSysActivityTypeTranCds using the merge function
	 * @param rgsCode
	 */
	public AlsSysActivityTypeTranCdsIdPk save(AlsSysActivityTypeTranCds tmp){
		log.debug("saving AlsSysActivityTypeTranCds");
		Transaction tx = null;
		AlsSysActivityTypeTranCdsIdPk id;
		AlsSysActivityTypeTranCds bac = new AlsSysActivityTypeTranCds();
		AlsSysActivityTypeTranCdsDAO dao = new AlsSysActivityTypeTranCdsDAO();
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
	public void delete(AlsSysActivityTypeTranCds rsgCode){
		log.debug("deleting AlsSysActivityTypeTranCds");
		Transaction tx = null;
		AlsSysActivityTypeTranCdsDAO dao = new AlsSysActivityTypeTranCdsDAO();
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
	 * This method returns System Activity Type Tran Codes Desc
	 * @param sysActivityType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getCodeDesc(String sysActivityType, String txnCd) {
		String rtn = "";

		String where = "SELECT asattc_desc"
					+ "  FROM ALS.ALS_SYS_ACTIVITY_TYPE_TRAN_CDS"
					+ " WHERE asac_system_activity_type_cd ='"
					+ sysActivityType + "'" + " AND asac_txn_cd = " + txnCd;
		
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
