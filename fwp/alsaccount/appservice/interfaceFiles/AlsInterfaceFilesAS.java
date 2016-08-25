package fwp.alsaccount.appservice.interfaceFiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.dao.interfaceFiles.AlsInterfaceFiles;
import fwp.alsaccount.dao.interfaceFiles.AlsInterfaceFilesDAO;
import fwp.alsaccount.hibernate.HibernateSessionFactory;

/**
 * @author CFA077
 *
 */
public class AlsInterfaceFilesAS {
	private static final Logger log = LoggerFactory
			.getLogger(AlsInterfaceFilesDAO.class);
	
	/**
	 * @param iFile AlsInterfaceFiles object containing search parameters
	 * @param createDateFrom start date for range of dates file was created 
	 * @param createDateTo end date for range of dates file was created
	 * @param processDateFrom start date for range of dates file was processed
	 * @param processDateTo end date for range of dates file was processed
	 * @return list of AlsInterfaceFiles objects
	 */
	public List<AlsInterfaceFiles> searchFiles(AlsInterfaceFiles iFile, Date createDateFrom, Date createDateTo, Date processDateFrom, Date processDateTo){
		List<AlsInterfaceFiles> records = new ArrayList<AlsInterfaceFiles>();
		try{
			StringBuilder sqlWhere = new StringBuilder(" where 1 = 1 ");
			if(iFile.getAifAwgcId() != null){
				sqlWhere.append(" AND aif.aifAwgcId = :aifAwgcId ");
			}
			if(iFile.getAifFileName() != null && !iFile.getAifFileName().isEmpty()){
				sqlWhere.append(" AND aif.aifFileName LIKE :aifFileName ");
			}
			if(iFile.getAifFileSent() != null && !iFile.getAifFileSent().isEmpty()){
				sqlWhere.append(" AND aif.aifFileSent = :aifFileSent ");
			}
			if(createDateFrom != null){
				sqlWhere.append(" AND aif.aifCreateDate >= :createDateFrom ");
			}
			if(createDateTo != null){
				sqlWhere.append(" AND aif.aifCreateDate <= :createDateTo ");
			}
			if(processDateFrom != null){
				sqlWhere.append(" AND aif.aifProcessDate >= :processDateFrom ");
			}
			if(processDateTo != null){
				sqlWhere.append(" AND aif.aifProcessDate <= :processDateTo ");
			}
			
			String queryString = " from AlsInterfaceFiles aif ";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + sqlWhere.toString());	   		
			
			if(iFile.getAifAwgcId() != null){
				queryObject.setParameter("aifAwgcId", iFile.getAifAwgcId());
			}
			if(iFile.getAifFileName() != null && !iFile.getAifFileName().isEmpty()){
				queryObject.setParameter("aifFileName", iFile.getAifFileName());
			}
			if(iFile.getAifFileSent() != null && !iFile.getAifFileSent().isEmpty()){
				queryObject.setParameter("aifFileSent", iFile.getAifFileSent());
			}
			if(createDateFrom != null){
				queryObject.setParameter("createDateFrom", createDateFrom);
			}
			if(createDateTo != null){
				queryObject.setParameter("createDateTo", createDateTo);
			}
			if(processDateFrom != null){
				queryObject.setParameter("processDateFrom", processDateFrom);
			}
			if(processDateTo != null){
				queryObject.setParameter("processDateTo", processDateTo);
			}
			records = queryObject.list();
		}catch(Exception re){
			log.error(re.getMessage(), re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return records;
	}
	
	/**
	 * returns a list of AlsInterfaceFiles filtered by where clause
	 * @param where
	 * @return List
	 */
	@SuppressWarnings("rawtypes")
	public List findAllByWhere(String where) {
		log.debug("finding all AlsInterfaceFiles instances by where filter");
		try {
			String queryString = " from AlsInterfaceFiles";
			Query queryObject = HibernateSessionFactory.getSession().createQuery(queryString + " " + where);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
	public AlsInterfaceFiles findById(Integer idPk){
		AlsInterfaceFilesDAO dao = new AlsInterfaceFilesDAO();
		
		AlsInterfaceFiles aif=new AlsInterfaceFiles();
		try{
			aif = dao.findById(idPk);
		} catch (RuntimeException re) {	
			throw re;	
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return aif;
	}
	
	/**
	 * Saves an AlsInterfaceFiles record using the merge function
	 * @param tmp AlsInterfaceFiles object
	 */
	public void save(AlsInterfaceFiles tmp){
		log.debug("saving AlsInterfaceFiles");
		Transaction tx = null;
		AlsInterfaceFilesDAO dao = new AlsInterfaceFilesDAO();
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
}
