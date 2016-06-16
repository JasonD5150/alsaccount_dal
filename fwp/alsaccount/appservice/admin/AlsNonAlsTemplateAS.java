package fwp.alsaccount.appservice.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.appservice.admin.AlsMiscAS;
import fwp.alsaccount.dao.admin.AlsNonAlsOrgControl;
import fwp.alsaccount.dao.admin.AlsNonAlsTemplate;
import fwp.alsaccount.dao.admin.AlsNonAlsTemplateDAO;
import fwp.alsaccount.dao.admin.AlsNonAlsTemplateIdPk;
import fwp.alsaccount.hibernate.HibernateSessionFactory;
import fwp.data.ConnectionFactory;


/**
 * @author c81203
 * 
 */
public class AlsNonAlsTemplateAS {
	
	private static final Logger log = LoggerFactory
			.getLogger(AlsNonAlsTemplateDAO.class);
	
	/**
	 * returns a list of AlsNonAlsTemplate filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsNonAlsTemplate instances by where filter");
		try {
			String queryString = " from AlsNonAlsTemplate";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsNonAlsTemplate findById(AlsNonAlsTemplateIdPk idPk){
		AlsNonAlsTemplateDAO dao = new AlsNonAlsTemplateDAO();
		
		AlsNonAlsTemplate code;
		try {
			code = dao.findById(idPk);
		} catch (RuntimeException re) {	
			throw re;	
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return code;
	}
	
	/**
	 * Saves any AlsNonAlsTemplate using the merge function
	 * @param AlsNonAlsTemplate
	 */
	public void save(AlsNonAlsTemplate tmp){
		log.debug("saving AlsNonAlsTemplate");
		Transaction tx = null;
		AlsNonAlsTemplateDAO dao = new AlsNonAlsTemplateDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.merge(tmp);
			tx.commit();			
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
		return;
	}
	
	
	/**
	 * delete an existing AlsNonAlsTemplate
	 * @param AlsNonAlsTemplate
	 */
	public void delete(AlsNonAlsTemplate AlsNonAlsTemplate){
		log.debug("deleting AlsNonAlsTemplate");
		Transaction tx = null;
		AlsNonAlsTemplateDAO dao = new AlsNonAlsTemplateDAO();
		try{
			Session session = dao.getSession();
			tx = session.beginTransaction();
			dao.delete(AlsNonAlsTemplate);
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
	 * Returns JLR am_val_desc corresponding to a given am_par_val from the als_misc table
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getJlrValDesc(Integer amParVal) {
		String retVal = "";
		
		AlsMiscAS amAS = new AlsMiscAS();
		String where = "SELECT am_val_desc"
					+ "  FROM ALS.ALS_MISC"
					+ " WHERE am_key1 = 'JOURNAL_LINE_REFERENCE' "   
					+ "	AND am_par_val||'00' = '"+amParVal+"'";
		
		try {
			Query query = HibernateSessionFactory.getSession().createSQLQuery(where);
			List<String> descList = query.list();
			if (descList != null && !descList.isEmpty()) {
				retVal = descList.get(0)+"00";
			}
		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}
	
	/**
	 * Returns JLR am_par_val corresponding to a given am_val_desc from the als_misc table
	 * @param tmp
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Integer getJlrParVal(String amValDesc) {
		Integer retVal = 0;
		
		AlsMiscAS amAS = new AlsMiscAS();;

		String where = "SELECT am_par_val"
					+ "  FROM ALS.ALS_MISC"
					+ " WHERE am_key1 = 'JOURNAL_LINE_REFERENCE' "   
					+ "	AND am_val_desc||'00' = '"+amValDesc+"'";
		
		try {
			Query query = HibernateSessionFactory.getSession().createSQLQuery(where);
			List<String> descList = query.list();
			if (descList != null && !descList.isEmpty()) {
				retVal = Integer.parseInt(descList.get(0)+"00");
			} 
		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}

	/**
	 * This method checks for duplicate entries.
	 * @param idPk
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isDuplicateEntry(AlsNonAlsTemplateIdPk idPk) {
		
		Boolean retVal = false;
		
		try {
			AlsNonAlsTemplate anat = this.findById(idPk);
			if(anat != null){
				retVal = true;
			}

		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}
	
	/**
	 * This method checks for duplicate entries.
	 * @param idPk
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean isDuplicateDesc(Integer budgYear, String desc) {
		
		Boolean retVal = false;
		
		try {
			String where = " WHERE idPk.anatBudgetYear = '"+budgYear+"'"+
						   " AND anatDesc = '"+desc+"'";
			List anat = this.findAllByWhere(where);
			if(anat != null && !anat.isEmpty()){
				retVal = true;
			}

		} catch (RuntimeException re) {	
			throw re;	
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return retVal;
	}
	
	/**
	 * This method returns report data
	 * 
	 * @return
	 * @throws SQLException 
	 */
	@SuppressWarnings("unchecked")
	public String genReport(Integer year, String provider, String org, String jlr, String account, String tempToRpt) throws SQLException {
		StringBuffer rtn = new StringBuffer("");
		Connection conn = null;
		String sql = "SELECT 'Debit' dr_cr, "
					   		+ "anat.anat_cd, "
					   		+ "INITCAP(anat.anat_desc) anat_desc, "
					   		+ "anat.anat_budget_year, "
					   		+ "anat.anat_program_year, "
					   		+ "anat.anat_dr_account account, "
					   		+ "anat.anat_fund, "
					   		+ "anat.anat_dr_subclass subclass, "
					   		+ "anat.anat_dr_project_grant project_grant, "
					   		+ "am.am_val_desc journal_line_refr, "
					   		+ "anat.anat_dr_line_desc line_desc, "
					   		+ "anaoc.anaoc_org, "
					   		+ "DECODE(api.api_provider_no||' - '||INITCAP(api_business_nm), ' - ', NULL, api.api_provider_no||' - '||INITCAP(api_business_nm)) provider, "
					   		+ "anaoc.anaoc_cr_dr_cd "
					   + "FROM als.als_misc am, "
					   		+ "als.als_provider_info api, "
					   		+ "als.als_non_als_org_control anaoc, "
					   		+ "als.als_non_als_template anat "
					   + "WHERE anat.anat_program_year = "+year+" "
					   + "AND anaoc.anat_cd(+) = anat.anat_cd "
					   + "AND anaoc.anaoc_cr_dr_cd(+) = 'D' "
					   + "AND api.api_provider_no(+) = anaoc.api_provider_no "
					   + "AND am.am_key1(+) = 'JOURNAL_LINE_REFERENCE' "
					   + "AND am.am_par_val(+) = SUBSTR(anat.anat_dr_journal_line_refr, 1, 3) "
					   + "AND ("+provider+" IS NULL OR  EXISTS (SELECT 1 "
					   									+ "FROM als.als_non_als_org_control "
					   									+ "WHERE anat_cd = anat.anat_cd "
					   									+ "AND api_provider_no = "+provider+")) "
					   + "AND ("+jlr+" IS NULL OR  EXISTS (SELECT 1 "
					   								+ "FROM als.als_non_als_template "
					   								+ "WHERE anat_cd = anat.anat_cd "
					   								+ "AND anat.anat_dr_journal_line_refr LIKE "+jlr+")) "
					   + "AND ("+org+" IS NULL OR  EXISTS (SELECT 1 "
					   								+ "FROM als.als_non_als_org_control "
					   								+ "WHERE anat_cd = anat.anat_cd "
					   								+ "AND anaoc_org LIKE "+org+")) "
					   + "AND ("+account+" IS NULL OR  EXISTS (SELECT 1 "
					   									+ "FROM als.als_non_als_template "
					   									+ "WHERE anat_cd = anat.anat_cd "
					   									+ "AND anat_dr_account LIKE "+account+")) "
					   + "AND ('"+tempToRpt+"' = 'A' OR ('"+tempToRpt+"' = 'M' AND  1 < (SELECT COUNT(*) "
					   													+ "FROM als.als_non_als_org_control "
					   													+ "WHERE anat_cd = anat.anat_cd "
					   													+ "AND anat_budget_year = anat.anat_budget_year)) "
					   + "OR ('"+tempToRpt+"' = 'S' AND  1 = (SELECT COUNT(*) "
					   								+ "FROM als.als_non_als_org_control "
					   								+ "WHERE anat_cd = anat.anat_cd "
					   								+ "AND anat_budget_year = anat.anat_budget_year)) "
					   + "OR ('"+tempToRpt+"' = 'N' AND  0 = (SELECT COUNT(*) "
					   								+ "FROM als.als_non_als_org_control "
					   								+ "WHERE anat_cd = anat.anat_cd "
					   								+ "AND anat_budget_year = anat.anat_budget_year))) "
					   + "UNION "
					   + "SELECT 'Credit', "
					   			+ "anat.anat_cd, "
					   			+ "INITCAP(anat.anat_desc), "
					   			+ "anat.anat_budget_year, "
					   			+ "anat.anat_program_year, "
					   			+ "anat.anat_cr_account, "
					   			+ "anat.anat_fund, "
					   			+ "anat.anat_cr_subclass, "
					   			+ "anat.anat_cr_project_grant, "
					   			+ "am.am_val_desc journal_line_refr, "
					   			+ "anat.anat_cr_line_desc, "
					   			+ "anaoc.anaoc_org, "
					   			+ "DECODE(api.api_provider_no||' - '||INITCAP(api_business_nm), ' - ', NULL, api.api_provider_no||' - '||INITCAP(api_business_nm)), "
					   			+ "anaoc.anaoc_cr_dr_cd "
					   + "FROM als.als_misc am, "
					   			+ "als.als_provider_info api, "
					   			+ "als.als_non_als_org_control anaoc, "
					   			+ "als.als_non_als_template anat "
					   + "WHERE anat.anat_program_year = "+year+" "
					   + "AND anaoc.anat_cd(+) = anat.anat_cd  "
					   + "AND anaoc.anaoc_cr_dr_cd(+) = 'C'"
					   + "AND api.api_provider_no(+) = anaoc.api_provider_no "
					   + "AND am.am_key1(+) = 'JOURNAL_LINE_REFERENCE' "
					   + "AND am.am_par_val(+) = SUBSTR(anat.anat_cr_journal_line_refr, 1, 3) "
					   + "AND ("+provider+" IS NULL OR  EXISTS (SELECT 1 "
					   									+ "FROM als.als_non_als_org_control "
					   									+ "WHERE anat_cd = anat.anat_cd "
					   									+ "AND api_provider_no = "+provider+")) "
					   + "AND ("+org+" IS NULL OR  EXISTS (SELECT 1 "
					   								+ "FROM als.als_non_als_org_control "
					   								+ "WHERE anat_cd = anat.anat_cd "
					   								+ "AND anaoc_org LIKE "+org+")) "
					   + "AND ("+jlr+" IS NULL OR  EXISTS (SELECT 1 "
					   								+ "FROM als.als_non_als_template "
					   								+ "WHERE anat_cd = anat.anat_cd "
					   								+ "AND anat.anat_cr_journal_line_refr LIKE "+jlr+")) "
					   + "AND ("+account+" IS NULL OR  EXISTS (SELECT 1 "
					   									+ "FROM als.als_non_als_template "
					   									+ "WHERE anat_cd = anat.anat_cd "
					   									+ "AND anat_cr_account LIKE "+account+")) "
					   + "AND ('"+tempToRpt+"' = 'A' OR ('"+tempToRpt+"' = 'M' AND  1 < (SELECT COUNT(*) "
					   													+ "FROM als.als_non_als_org_control "
					   													+ "WHERE anat_cd = anat.anat_cd "
					   													+ "AND anat_budget_year = anat.anat_budget_year)) "
					   + "OR ('"+tempToRpt+"' = 'S' AND  1 = (SELECT COUNT(*) "
					   								+ "FROM als.als_non_als_org_control "
					   								+ "WHERE anat_cd = anat.anat_cd "
					   								+ "AND anat_budget_year = anat.anat_budget_year)) "
					   + "OR ('"+tempToRpt+"' = 'N' AND  0 = (SELECT COUNT(*) "
					   								+ "FROM als.als_non_als_org_control "
					   								+ "WHERE anat_cd = anat.anat_cd "
					   								+ "AND anat_budget_year = anat.anat_budget_year))) "
					   + "ORDER BY 2, 1 DESC";
		
		PreparedStatement pst = null;
        ResultSet rst = null;
		
		try {
			conn = ConnectionFactory.getConnection("als_web_user_ds", "als_web_user_ds");
    		pst = conn.prepareStatement(sql);
        	rst = pst.executeQuery();
        	String where = "";
        	AlsNonAlsOrgControlAS anaocAS = new AlsNonAlsOrgControlAS();
        	List<AlsNonAlsOrgControl> anaoc = new ArrayList<AlsNonAlsOrgControl>();
			while (rst.next()) { 
				where = " WHERE anat_cd ='"+rst.getString("anat_cd")+"'"+
						" AND anaoc_cr_dr_cd = '"+rst.getString("anaoc_cr_dr_cd")+"'";
				
				anaoc = anaocAS.findAllByWhere(where);
				
				rtn.append(rst.getString("dr_cr")+",");
				rtn.append(rst.getString("anat_cd")+",");
				rtn.append(rst.getString("anat_desc")+",");
				rtn.append(rst.getString("anat_budget_year")+",");
				rtn.append(rst.getString("account")+",");
				rtn.append(rst.getString("anat_fund")+",");
				rtn.append(nullFix(rst.getString("subclass"))+",");
				rtn.append(nullFix(rst.getString("project_grant"))+",");
				rtn.append(nullFix(rst.getString("journal_line_refr"))+",");
				rtn.append(rst.getString("line_desc")+",");
				rtn.append(anaoc.size() > 1 ? "YES," : "NO,");
				rtn.append(nullFix(rst.getString("anaoc_org"))+",");
				rtn.append(nullFix(rst.getString("provider"))+",");
				
				rtn.append("\r\n");
				
			}

		} catch (RuntimeException re) {	
			throw re;	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			HibernateSessionFactory.closeSession();
		}
		
		return rtn.toString();
	}
	
	public static String nullFix(String in){
       if (in == null) return "";
       else return in;
	}
	
}
