package fwp.alsaccount.appservice.admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.admin.AlsMisc;
import fwp.alsaccount.dao.admin.AlsMiscDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.alsaccount.hibernate.utils.ListComp;
import fwp.alsaccount.hibernate.utils.ProcRtrn;

/**
 * Application service for the ALS Item Control Table functions
 * 
 * @author CF5898
 * 
 */
public class AlsMiscAS {
	
	private static final Logger log = LoggerFactory.getLogger(AlsMiscDAO.class);

	/**
	 * returns a list of AlsMisc objects
	 * @param where the Where clause to filter the result list
	 * @return List The list of AlsMisc objects returned from the query
	 */
	@SuppressWarnings("unchecked")
	public List<AlsMisc> findAllByWhere(String where) {

		try {
			String queryString = " from AlsMisc ";
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
	 * returns a list of AlsMisc objects matching the input search criteria
	 * @param alsMisc the AlsMisc instance containing the search values
	 * @param searchAllStr the value to search all fields on
	 * @param orderByClause the order by clause
	 * @return List The list of AlsMisc objects returned from the query
	 */
    @SuppressWarnings("unchecked")
	public List<AlsMisc> miscSearch(AlsMisc alsMisc, String searchAllStr, String orderByClause) {

    	if (alsMisc == null) {
    		alsMisc = new AlsMisc();
    	}
    	
    	if (searchAllStr != null) {
        	searchAllStr = searchAllStr.toUpperCase();
    	}
    	
    	List<AlsMisc> lst = new ArrayList<AlsMisc>();

    	String queryString =
            "SELECT am.am_seq_no amSeqNo, am.am_key1 amKey1, am.am_key2 amKey2, am.am_key3 amKey3, am.am_key4 amKey4, am.am_key5 amKey5, " +
            "       am.am_desc1 amDesc1, am.am_desc2 amDesc2, am.am_desc3 amDesc3, am.am_desc4 amDesc4, am.am_desc5 amDesc5, " +
            "       am.am_par_val amParVal, am.am_val_desc amValDesc, am.am_who_log amWhoLog, am.am_when_log amWhenLog " +
            "  FROM als.als_misc am " +
            " WHERE 1 = 1 ";
    	
    	if (searchAllStr != null && !"".equals(searchAllStr)) {
    		queryString += " AND (upper(am.am_key1) like '%" + searchAllStr + "%' or " + 
    					   "      upper(am.am_key2) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_key3) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_key4) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_key5) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_desc1) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_desc2) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_desc3) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_desc4) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_desc5) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_par_val) like '%" + searchAllStr + "%' or " +
    					   "      upper(am.am_val_desc) like '%" + searchAllStr + "%') ";
    	}

    	if (alsMisc.getAmKey1() != null && !"".equals(alsMisc.getAmKey1())) {
    		queryString += " AND upper(am.am_key1) like '%" + alsMisc.getAmKey1().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmKey2() != null && !"".equals(alsMisc.getAmKey2())) {
    		queryString += " AND upper(am.am_key2) like '%" + alsMisc.getAmKey2().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmKey3() != null && !"".equals(alsMisc.getAmKey3())) {
    		queryString += " AND upper(am.am_key3) like '%" + alsMisc.getAmKey3().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmKey4() != null && !"".equals(alsMisc.getAmKey4())) {
    		queryString += " AND upper(am.am_key4) like '%" + alsMisc.getAmKey4().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmKey5() != null && !"".equals(alsMisc.getAmKey5())) {
    		queryString += " AND upper(am.am_key5) like '%" + alsMisc.getAmKey5().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmDesc1() != null && !"".equals(alsMisc.getAmDesc1())) {
    		queryString += " AND upper(am.am_desc1) like '%" + alsMisc.getAmDesc1().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmDesc2() != null && !"".equals(alsMisc.getAmDesc2())) {
    		queryString += " AND upper(am.am_desc2) like '%" + alsMisc.getAmDesc2().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmDesc3() != null && !"".equals(alsMisc.getAmDesc3())) {
    		queryString += " AND upper(am.am_desc3) like '%" + alsMisc.getAmDesc3().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmDesc4() != null && !"".equals(alsMisc.getAmDesc4())) {
    		queryString += " AND upper(am.am_desc4) like '%" + alsMisc.getAmDesc4().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmDesc5() != null && !"".equals(alsMisc.getAmDesc5())) {
    		queryString += " AND upper(am.am_desc5) like '%" + alsMisc.getAmDesc5().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmParVal() != null && !"".equals(alsMisc.getAmParVal())) {
    		queryString += " AND upper(am.am_par_val) like '%" + alsMisc.getAmParVal().toUpperCase() + "%' ";
    	}

    	if (alsMisc.getAmValDesc() != null && !"".equals(alsMisc.getAmValDesc())) {
    		queryString += " AND upper(am.am_val_desc) like '%" + alsMisc.getAmValDesc().toUpperCase() + "%' ";
    	}

    	if (orderByClause != null && !"".equals(orderByClause)) {
        	queryString += orderByClause;
    	}
    	else {
        	queryString += " ORDER BY am.am_key1, am.am_key2, am.am_key3, am.am_key4, am.am_key5 ";
    	}
        Query query = HibernateSessionFactory.getSession().createSQLQuery(queryString )
				.addScalar("amSeqNo",IntegerType.INSTANCE)
				.addScalar("amKey1",StringType.INSTANCE)
				.addScalar("amKey2",StringType.INSTANCE)
				.addScalar("amKey3",StringType.INSTANCE)
				.addScalar("amKey4",StringType.INSTANCE)
				.addScalar("amKey5",StringType.INSTANCE)
				.addScalar("amDesc1",StringType.INSTANCE)
				.addScalar("amDesc2",StringType.INSTANCE)
				.addScalar("amDesc3",StringType.INSTANCE)
				.addScalar("amDesc4",StringType.INSTANCE)
				.addScalar("amDesc5",StringType.INSTANCE)
				.addScalar("amParVal",StringType.INSTANCE)
				.addScalar("amValDesc",StringType.INSTANCE)
				.addScalar("amWhoLog",StringType.INSTANCE)
				.addScalar("amWhenLog",TimestampType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(AlsMisc.class));

        lst = query.list();
        HibernateSessionFactory.getSession().close();
        return lst;
    }
	
	/**
	 * Saves an AlsMisc using the merge function
	 * @param AlsMisc
	 */
	public Integer save(AlsMisc tmp){
		log.debug("saving AlsMisc");
		Transaction tx = null;
		Integer id;
		AlsMisc misc = new AlsMisc();
		AlsMiscDAO dao = new AlsMiscDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			misc = dao.merge(tmp);			
			tx.commit();
			id = misc.getAmSeqNo();
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
	 * delete an existing AlsMisc
	 * @param alsMisc
	 */
	public void delete(AlsMisc alsMisc){
		log.debug("deleting AlsMisc");
		Transaction tx = null;
		AlsMiscDAO dao = new AlsMiscDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(alsMisc);
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

	public AlsMisc findById(Integer id){
		AlsMiscDAO dao = new AlsMiscDAO();
		
		AlsMisc am;
		try{
			am = dao.findById(id);
		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return am;
	}
	
	/**
	 * This method checks for duplicate entries.
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isDuplicateEntry(AlsMisc tmp) {
		
		Boolean retVal = false;
		
		try {
			String queryString = "  FROM AlsMisc am " +
								 " WHERE NVL(am.amKey1,'X') = NVL(:amKey1,'X') " +
								 "   AND NVL(am.amKey2,'X') = NVL(:amKey2,'X') " +
								 "   AND NVL(am.amKey3,'X') = NVL(:amKey3,'X') " +
								 "   AND NVL(am.amKey4,'X') = NVL(:amKey4,'X') " +
								 "   AND NVL(am.amKey5,'X') = NVL(:amKey5,'X') " +
								 "   AND NVL(am.amParVal,'X') = NVL(:amParVal,'X') " +
//								 "   AND NVL(am.amValDesc,'X') = NVL(:amValDesc,'X') " +
								 "   AND (am.amSeqNo <> :amSeqNo or :amSeqNo is null) ";
			
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);
			
			queryObject.setParameter("amKey1", tmp.getAmKey1());
			queryObject.setParameter("amKey2", tmp.getAmKey2());
			queryObject.setParameter("amKey3", tmp.getAmKey3());
			queryObject.setParameter("amKey4", tmp.getAmKey4());
			queryObject.setParameter("amKey5", tmp.getAmKey5());
			queryObject.setParameter("amSeqNo", tmp.getAmSeqNo());
			queryObject.setParameter("amParVal", tmp.getAmParVal());
			//queryObject.setParameter("amValDesc", tmp.getAmValDesc());
			
			
			List<AlsMisc> amList = (List<AlsMisc>)queryObject.list();
			
			if (amList != null && !amList.isEmpty()) {
				retVal = true;
			}

		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}
    
	/**
	 * Deletes the advice record text from the ALS_MISC table.
	 * @param adviceRecType the advice record type
	 * 
	 * @return ProcRtrn
	 */
    @SuppressWarnings("unchecked")
	public ProcRtrn deleteAdviceRecordText(String adviceRecordType) {
    	
    	ProcRtrn rtrn = new ProcRtrn();
    	
    	try {
    		
        	String queryString = "SELECT am " +
		             "  FROM AlsMisc am " +
		             " WHERE am.amKey1 = :recType " + 
		             "   AND am.amKey2 = 'ADVICE RECORD' " +
		             "   AND am.amKey3 IN ('1','2','3','4','5')" +
		             " ORDER BY am.amKey3";

			Query query = HibernateSessionFactory.getSession().createQuery(queryString);
			query.setParameter("recType", adviceRecordType);
			List<AlsMisc> amLst = query.list();

			if (amLst != null && !amLst.isEmpty()) {
				for (AlsMisc am : amLst) {
					this.delete(am);
				}
				
				rtrn.setProcStatus("SUCCESS");
				rtrn.setProcMsg("Delete Successful.");
				
			} else {
				rtrn.setProcStatus("ERROR");
				rtrn.setProcMsg("You cannot delete an advice record that does not exist.");
			}
			
		} catch (Exception e) {	
			rtrn.setProcStatus("ERROR");
			rtrn.setProcMsg(this.getClass().getName()+".deleteAdviceRecordText - " + e.getMessage());	
		} finally {
			if (HibernateSessionFactory.getSession() != null) {
				HibernateSessionFactory.closeSession();
			}
		}
    	
    	return rtrn;
    }
    
    /**
	 * This method checks for duplicate entries.
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isDuplicateJLRKey2(String amParVal) {
		
		Boolean retVal = false;
		
		try {
			String queryString = "  FROM AlsMisc am " +
								 " WHERE am.amKey1 = 'JOURNAL_LINE_REFERENCE' " +
								 "   AND am.amKey2 = 'NON ALS "+amParVal+"' ";
			
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);

			List<AlsMisc> amList = (List<AlsMisc>)queryObject.list();
			
			if (amList != null && !amList.isEmpty()) {
				retVal = true;
			}

		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}
	
	/**
	 * This method checks for duplicate entries.
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isDuplicateJLRNonAls(String amParVal) {
		
		Boolean retVal = false;
		
		try {
			String queryString = "  FROM AlsMisc am " +
								 " WHERE am.amKey1 = 'JOURNAL_LINE_REFERENCE' " +
								 "   AND am.amParVal = "+amParVal;
			
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString);

			List<AlsMisc> amList = (List<AlsMisc>)queryObject.list();
			
			if (amList != null && !amList.isEmpty()) {
				retVal = true;
			}

		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}

}
