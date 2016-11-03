package fwp.alsaccount.hibernate.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class DalUtils {

	

	@SuppressWarnings("unchecked")
	public Integer getNextAvailableSequence(String tableName,
	                                        String seqColName, Session session) throws RuntimeException {
		Integer nextSeq = null;

		String queryString = "SELECT MIN(rnum) AS nextSeq"
				+ "  FROM (SELECT rownum rnum" + "          FROM DUAL"
				+ "          CONNECT BY LEVEL <= (SELECT NVL(MAX(table1."
				+ seqColName + "),1) + 1 "
				+ "                                 FROM " + tableName
				+ " table1)) " + " WHERE NOT EXISTS (SELECT 1 "
				+ " 					   FROM " + tableName + " table2 "
				+ "                    WHERE table2." + seqColName
				+ " = rnum) ";

		Query query = session.createSQLQuery(queryString);
		List<BigDecimal> nextSeqList = query.list();
		if (nextSeqList != null && !nextSeqList.isEmpty()) {
			BigDecimal seq = nextSeqList.get(0);
			nextSeq = seq.intValue();
		} else {
			throw new RuntimeException(
					"Unable to find the next sequence for table: " + tableName);
		}

		return nextSeq;
	}

	@SuppressWarnings("unchecked")
	public Integer getNextAvailableSequence(String tableName,
	                                        String seqColName, String filter, Session session)
			throws RuntimeException {
		Integer nextSeq = null;

		String queryString = "SELECT MIN(rnum) AS nextSeq"
				+ "  FROM (SELECT rownum rnum" + "          FROM DUAL"
				+ "          CONNECT BY LEVEL <= (SELECT NVL(MAX(table1."
				+ seqColName + "),1) + 1 "
				+ "                                 FROM " + tableName
				+ " table1 " + "                                WHERE 1=1 AND "
				+ filter + ")) " + " WHERE NOT EXISTS (SELECT 1 "
				+ " 					   FROM " + tableName + " table2 "
				+ "                    WHERE table2." + seqColName
				+ " = rnum AND " + filter + ") ";

		Query query = session.createSQLQuery(queryString);
		List<BigDecimal> nextSeqList = query.list();
		if (nextSeqList != null && !nextSeqList.isEmpty()) {
			BigDecimal seq = nextSeqList.get(0);
			nextSeq = seq.intValue();
		} else {
			throw new RuntimeException(
					"Unable to find the next sequence for table: " + tableName);
		}

		return nextSeq;
	}

	public Integer getNextValueFromSequence(String sequenceName, Session session)
			throws RuntimeException {
		Integer nextSeq = null;

		String queryString = "SELECT ALS." + sequenceName
				+ ".NextVal FROM DUAL";

		Query query = session.createSQLQuery(queryString);
		Object nextSeqObj = query.uniqueResult();
		if (nextSeqObj != null) {
			BigDecimal seq = (BigDecimal) nextSeqObj;
			nextSeq = seq.intValue();
		} else {
			throw new RuntimeException(
					"Unable to find the next value for sequence: "
							+ sequenceName);
		}

		return nextSeq;
	}

	public static boolean isNil(String stringVal){
		if(stringVal == null || stringVal.equals("")) return true; else return false;
	}
	public static boolean isNil(Integer integerVal){
		if(integerVal == null) return true; else return false;
	}
	public static boolean isNil(Double integerVal){
		if(integerVal == null) return true; else return false;
	}
	public static  boolean isNil(Date dateVal){
		if(dateVal == null) return true; else return false;
	}

}