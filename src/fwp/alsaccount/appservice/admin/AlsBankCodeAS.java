package fwp.alsaccount.appservice.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsBankCode;
import fwp.alsaccount.dao.admin.AlsBankCodeDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;

/**
 * @author 
 * 
 */
public class AlsBankCodeAS {

	private static final Logger log = LoggerFactory
			.getLogger(AlsBankCodeDAO.class);

	/**
	 * returns a list of AlsAccCdControl filtered by where clause
	 * 
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsBankCode instances by where filter");
		try {
			String queryString = " from AlsBankCode";
			Query queryObject = HibernateSessionFactory.getSession()
					.createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	/**
	 * Finds a Bank code by ID
	 * @param abcBankCd
	 * @return
	 */
	public AlsBankCode findById(String abcBankCd) {
		AlsBankCodeDAO dao = new AlsBankCodeDAO();

		AlsBankCode code;
		try {
			code = dao.findById(abcBankCd);
		} catch (RuntimeException re) {
			throw re;
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return code;
	}

	/**
	 * Checks if bank code is a duplicate
	 * @param abcBankCd
	 * @return
	 */
	public Boolean isDuplicateEntry(String abcBankCd) {

		Boolean retVal = false;

		try {
			AlsBankCode abc = this.findById(abcBankCd);
			if (abc != null) {
				retVal = true;
			}

		} catch (RuntimeException re) {
			throw re;
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return retVal;
	}

	/**
	 * Saves any AlsBankCode using the merge function
	 * 
	 * @param AlsBankCode
	 */
	public void save(AlsBankCode tmp) {
		log.debug("saving AlsBankCode");
		Transaction tx = null;
		AlsBankCodeDAO dao = new AlsBankCodeDAO();
		try {
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.merge(tmp);
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			log.error("save failed", re);
			throw re;
		} finally {
			try {
				dao.getSession().close();
			} catch (Exception e) {

			}
		}
		return;
	}

	/**
	 * delete an existing AlsBankCode
	 * 
	 * @param AlsBankCode
	 */

	public void delete(AlsBankCode AlsBankCode) {
		log.debug("deleting AlsBankCode");
		Transaction tx = null;
		AlsBankCodeDAO dao = new AlsBankCodeDAO();
		try {
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsBankCode);
			tx.commit();
		} catch (RuntimeException re) {
			tx.rollback();
			log.error("delete failed", re);
			throw re;
		} finally {
			try {
				dao.getSession().close();
			} catch (Exception e) {

			}
		}
	}

	/**
	 * Find all Bank Codes
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all AlsBankCode instances by where filter");
		try {
			String queryString = " from AlsBankCode";
			String whereString = " where 1=1";
			Query queryObject = HibernateSessionFactory.getSession()
					.createQuery(queryString + whereString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
