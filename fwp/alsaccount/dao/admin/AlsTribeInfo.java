package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

/**
 * AlsTribeInfo entity. @author MyEclipse Persistence Tools
 */

public class AlsTribeInfo implements java.io.Serializable {

	// Fields

	private String atiTribeCd;
	private String atiTribeNm;
	private String abcBankCd;
	private String atiDirectorNm;
	private String atiWhoLog;
	private Timestamp atiWhenLog;
	private String atiTribeAcctBankNm;
	private String atiTribeAcctRoutingNo;
	private String atiTribeAcctNo;

	// Constructors

	/** default constructor */
	public AlsTribeInfo() {
	}

	/** minimal constructor */
	public AlsTribeInfo(String atiTribeCd, String atiTribeNm, String abcBankCd,
			String atiWhoLog, Timestamp atiWhenLog) {
		this.atiTribeCd = atiTribeCd;
		this.atiTribeNm = atiTribeNm;
		this.abcBankCd = abcBankCd;
		this.atiWhoLog = atiWhoLog;
		this.atiWhenLog = atiWhenLog;
	}

	/** full constructor */
	public AlsTribeInfo(String atiTribeCd, String atiTribeNm, String abcBankCd,
			String atiDirectorNm, String atiWhoLog, Timestamp atiWhenLog,
			String atiTribeAcctBankNm, String atiTribeAcctRoutingNo,
			String atiTribeAcctNo) {
		this.atiTribeCd = atiTribeCd;
		this.atiTribeNm = atiTribeNm;
		this.abcBankCd = abcBankCd;
		this.atiDirectorNm = atiDirectorNm;
		this.atiWhoLog = atiWhoLog;
		this.atiWhenLog = atiWhenLog;
		this.atiTribeAcctBankNm = atiTribeAcctBankNm;
		this.atiTribeAcctRoutingNo = atiTribeAcctRoutingNo;
		this.atiTribeAcctNo = atiTribeAcctNo;
	}

	// Property accessors

	public String getAtiTribeCd() {
		return this.atiTribeCd;
	}

	public void setAtiTribeCd(String atiTribeCd) {
		this.atiTribeCd = atiTribeCd;
	}

	public String getAtiTribeNm() {
		return this.atiTribeNm;
	}

	public void setAtiTribeNm(String atiTribeNm) {
		this.atiTribeNm = atiTribeNm;
	}

	public String getAbcBankCd() {
		return this.abcBankCd;
	}

	public void setAbcBankCd(String abcBankCd) {
		this.abcBankCd = abcBankCd;
	}

	public String getAtiDirectorNm() {
		return this.atiDirectorNm;
	}

	public void setAtiDirectorNm(String atiDirectorNm) {
		this.atiDirectorNm = atiDirectorNm;
	}

	public String getAtiWhoLog() {
		return this.atiWhoLog;
	}

	public void setAtiWhoLog(String atiWhoLog) {
		this.atiWhoLog = atiWhoLog;
	}

	public Timestamp getAtiWhenLog() {
		return this.atiWhenLog;
	}

	public void setAtiWhenLog(Timestamp atiWhenLog) {
		this.atiWhenLog = atiWhenLog;
	}

	public String getAtiTribeAcctBankNm() {
		return this.atiTribeAcctBankNm;
	}

	public void setAtiTribeAcctBankNm(String atiTribeAcctBankNm) {
		this.atiTribeAcctBankNm = atiTribeAcctBankNm;
	}

	public String getAtiTribeAcctRoutingNo() {
		return this.atiTribeAcctRoutingNo;
	}

	public void setAtiTribeAcctRoutingNo(String atiTribeAcctRoutingNo) {
		this.atiTribeAcctRoutingNo = atiTribeAcctRoutingNo;
	}

	public String getAtiTribeAcctNo() {
		return this.atiTribeAcctNo;
	}

	public void setAtiTribeAcctNo(String atiTribeAcctNo) {
		this.atiTribeAcctNo = atiTribeAcctNo;
	}

}