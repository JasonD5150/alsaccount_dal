package fwp.alsaccount.appservice.admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsAccCdControl;
import fwp.alsaccount.dao.admin.AlsAccCdControlDAO;
import fwp.alsaccount.dao.admin.AlsAccCdControlIdPk;
import fwp.alsaccount.dao.admin.AlsBankCodeDAO;
import fwp.alsaccount.dao.admin.AlsOrgControl;
import fwp.alsaccount.hibernate.HibernateSessionFactory;




/**
 * @author cfa027
 * 
 */
public class AlsBankCodeAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsBankCodeDAO.class);
	
	/**
	 * returns a list of AlsAccCdControl filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsBankCode instances by where filter");
		try {
			String queryString = " from AlsBankCode";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	

}
