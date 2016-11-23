package fwp.alsaccount.appservice.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.als.hibernate.admin.dao.AlsTribeInfo;
import fwp.als.hibernate.admin.dao.AlsTribeInfoDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;


/**
 * @author CF0006
 *
 */
public class AlsTribeInfoAS {

	private static final Logger log = LoggerFactory
			.getLogger(AlsTribeInfoDAO.class);

	/**
	 * returns a list of AlsTribeInfo filtered by where clause
	 * 
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all Tribe instances by where filter");
		try {
			String queryString = " from AlsTribeInfo";
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
	 * @param atiTribeCd
	 * @return
	 */
	public AlsTribeInfo findById(String atiTribeCd) {
		AlsTribeInfoDAO dao = new AlsTribeInfoDAO();

		AlsTribeInfo tibeInfo;
		try {
			tibeInfo = dao.findById(atiTribeCd);
		} catch (RuntimeException re) {
			throw re;
		} finally {
			HibernateSessionFactory.closeSession();
		}

		return tibeInfo;
	}

	/**
	 * @param atiTribeCd
	 * @return
	 */
	public Boolean isDuplicateEntry(String atiTribeCd) {

		Boolean retVal = false;

		try {
			AlsTribeInfo ati = this.findById(atiTribeCd);
			if (ati != null) {
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
	 * Saves any AlsTribeInfo using the merge function
	 * 
	 * @param AlsTribeInfo
	 */
	public void save(AlsTribeInfo tmp) {
		log.debug("saving AlsTribeInfo");
		Transaction tx = null;
		AlsTribeInfoDAO dao = new AlsTribeInfoDAO();
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
	 * delete an existing AlsTribeInfo
	 * 
	 * @param alsTribeInfo
	 */

	public void delete(AlsTribeInfo alsTribeInfo) {
		log.debug("deleting AlsTribeInfo");
		Transaction tx = null;
		AlsTribeInfoDAO dao = new AlsTribeInfoDAO();
		try {
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(alsTribeInfo);
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
	 * Finds all Tribe Bank Codes
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Tribe instances by where filter");
		try {
			String queryString = " from AlsTribeInfo";
			String whereString = " where 1=1";
			Query queryObject = HibernateSessionFactory.getSession()
					.createQuery(queryString + " " + whereString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
