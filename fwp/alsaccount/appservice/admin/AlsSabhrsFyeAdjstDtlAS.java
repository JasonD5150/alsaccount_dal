package fwp.alsaccount.appservice.admin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsSabhrsFyeAdjstDtl;
import fwp.alsaccount.dao.admin.AlsSabhrsFyeAdjstDtlDAO;
import fwp.alsaccount.dao.admin.AlsSabhrsFyeAdjstDtlIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.alsaccount.hibernate.utils.ListComp;

/**
 * Application service for the ALS Item Control Table functions
 * 
 * @author CF5898
 * 
 */
public class AlsSabhrsFyeAdjstDtlAS {
	
	private static final Logger log = LoggerFactory.getLogger(AlsSabhrsFyeAdjstDtlDAO.class);

	/**
	 * returns a list of AlsSabhrsFyeAdjstDtl objects
	 * @param where the Where clause to filter the result list
	 * @return List The list of AlsSabhrsFyeAdjstDtl objects returned from the query
	 */
	@SuppressWarnings("unchecked")
	public List<AlsSabhrsFyeAdjstDtl> findAllByWhere(String where) {

		try {
			String queryString = " from AlsSabhrsFyeAdjstDtl ";
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
	 * returns values list given key1 and key2
	 * @params keys 1 and 2
	 * @return List The list of parameter values and descriptions returned from the query
	 */
    @SuppressWarnings("unchecked")
	public List<ListComp> getValuesWith2Keys(String key1,String key2) {

    	List<ListComp> lst = new ArrayList<ListComp>();

    	String queryString =
            "SELECT am.am_par_val itemVal \n" +
            "      ,am.am_val_desc itemLabel \n" +
            "  FROM als.als_misc am \n" +
            " WHERE am.am_key1 = '" + key1 + "' \n" +
            "   AND am.am_key2 = '" + key2 + "' ";

        Query query = HibernateSessionFactory.getSession().createSQLQuery(queryString )
                .addScalar("itemVal")
                .addScalar("itemLabel")
                .setResultTransformer(Transformers.aliasToBean(ListComp.class));

        lst = query.list();
        HibernateSessionFactory.getSession().close();
        return lst;
    }
	
	/**
	 * Saves an AlsSabhrsFyeAdjstDtl using the merge function
	 * @param AlsSabhrsFyeAdjstDtl
	 */
	public AlsSabhrsFyeAdjstDtlIdPk save(AlsSabhrsFyeAdjstDtl tmp){
		log.debug("saving AlsSabhrsFyeAdjstDtl");
		Transaction tx = null;
		AlsSabhrsFyeAdjstDtlIdPk id;
		AlsSabhrsFyeAdjstDtl misc = new AlsSabhrsFyeAdjstDtl();
		AlsSabhrsFyeAdjstDtlDAO dao = new AlsSabhrsFyeAdjstDtlDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			misc = dao.merge(tmp);			
			tx.commit();
			id = misc.getIdPk();
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
	 * delete an existing AlsSabhrsFyeAdjstDtl
	 * @param AlsSabhrsFyeAdjstDtl
	 */
	public void delete(AlsSabhrsFyeAdjstDtl AlsSabhrsFyeAdjstDtl){
		log.debug("deleting AlsSabhrsFyeAdjstDtl");
		Transaction tx = null;
		AlsSabhrsFyeAdjstDtlDAO dao = new AlsSabhrsFyeAdjstDtlDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsSabhrsFyeAdjstDtl);
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

	public AlsSabhrsFyeAdjstDtl findById(AlsSabhrsFyeAdjstDtlIdPk id){
		AlsSabhrsFyeAdjstDtlDAO dao = new AlsSabhrsFyeAdjstDtlDAO();
		AlsSabhrsFyeAdjstDtl am;
		try{
			am = dao.findById(id);
		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return am;
	}
	
	
    public Boolean isDuplicate(Integer budgYear, Timestamp adjstDt){
		Boolean rtn = false;
    	AlsSabhrsFyeAdjstDtlIdPk tmpIdPk = new AlsSabhrsFyeAdjstDtlIdPk();
    	AlsSabhrsFyeAdjstDtl tmp = new AlsSabhrsFyeAdjstDtl();
    	
    	tmpIdPk.setAsfaBudgetYear(budgYear);
    	tmpIdPk.setAsfadAdjstDt(adjstDt);
    	
    	tmp = this.findById(tmpIdPk);
    	
    	if(tmp != null){
    		rtn = true;
    	}
    	
		
    	return rtn;
    }
	
    
    
	
	
}
