package fwp.alsaccount.appservice.admin;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsProviderInfo;
import fwp.alsaccount.dao.admin.AlsProviderInfoDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;

import java.util.*;


/**
 * @author CF1275
 * 
 */
public class AlsProviderInfoAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsProviderInfoDAO.class);
	
	/**
	 * returns a list of AlsProviderInfo filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<AlsProviderInfo> findAllByWhere(String where) {
		log.debug("finding all AlsProviderInfo instances by where filter");
		try {
			String queryString = " from AlsProviderInfo";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@SuppressWarnings("rawtypes")
	public List findColumnByWhere(String column, String where) {
		log.debug("finding a column from AlsProviderInfo instances by where filter");
		try {
			String queryString = "SELECT " + column + " from als.Als_Provider_Info";
			SQLQuery queryObject = HibernateSessionFactory.getSession().createSQLQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsProviderInfo findById(int id){
		AlsProviderInfoDAO dao = new AlsProviderInfoDAO();
		
		AlsProviderInfo code;
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
	 * Saves any AlsProviderInfo using the merge function
	 * @param tmp
	 */
	public String save(AlsProviderInfo tmp){
		log.debug("saving AlsProviderInfo");
		Transaction tx = null;
		String id;
		AlsProviderInfo api = new AlsProviderInfo();
		AlsProviderInfoDAO dao = new AlsProviderInfoDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			api = dao.merge(tmp);
			
			tx.commit();
			id = Integer.toString(api.getApiProviderNo());
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
	 * delete an existing AlsProviderInfo
	 * @param api
	 */
	public void delete(AlsProviderInfo api){
		log.debug("deleting AlsProviderInfo");
		Transaction tx = null;
		AlsProviderInfoDAO dao = new AlsProviderInfoDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(api);
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
	
	@SuppressWarnings("unchecked")
	public String[] loadBusinessNameList() {
		log.debug("loading business name list");
		
		List<String> businessNm = new ArrayList<String>();
    	
    	String where = " GROUP BY api_business_nm" +
    				   " ORDER BY api_business_nm";

    	businessNm = findColumnByWhere("api_business_nm", where);
		
		return businessNm.toArray(new String[businessNm.size()]);
	}
	
	public String[] loadProviderClassList() {
		log.debug("loading provider class list");
		
		List<AlsProviderInfo> providerInfoList = new ArrayList<AlsProviderInfo>();
		HashSet<String> providerClass = new HashSet<String>();
    	
    	String where = "";

        providerInfoList = (List<AlsProviderInfo>) findAllByWhere(where);
        
        for (AlsProviderInfo providerInfo : providerInfoList) {
        	providerClass.add(providerInfo.getApiProviderClass());
        }
		
		return providerClass.toArray(new String[providerClass.size()]);
	}

	/**
	 * Load the distinct provider categories
	 *
	 * @return list of provider categories in the provider table
	 */
	public String[] loadProviderCatList() {
		log.debug("loading provider category list");
		try {
			Query queryObject = HibernateSessionFactory.getSession()
					.createQuery(
							"select distinct p.apiProviderCat " +
									" from AlsProviderInfo p");
			List queryList = queryObject.list();
			return (String[])queryList.toArray(new String[queryList.size()]);
		} catch (RuntimeException re) {
			log.error(re.getMessage(), re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	public String[] loadBusinessRegionList() {
		log.debug("loading business region list");
		
		List<AlsProviderInfo> providerInfoList = new ArrayList<AlsProviderInfo>();
		HashSet<String> businessRegion = new HashSet<String>();
    	
    	String where = " ORDER BY ar_business_region";

        providerInfoList = (List<AlsProviderInfo>) findAllByWhere(where);
        
        for (AlsProviderInfo providerInfo : providerInfoList) {
        	businessRegion.add(providerInfo.getArBusinessRegion());
        }
        String[] tempRegion = businessRegion.toArray(new String[businessRegion.size()]);
        Arrays.sort(tempRegion);//small enough to use this shortcut.
		return tempRegion;
	}
	






}
