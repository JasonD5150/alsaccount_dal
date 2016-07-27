package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AlsTribeInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ALS_TRIBE_INFO", schema = "ALS")
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
	@Id
	@Column(name = "ATI_TRIBE_CD", unique = true, nullable = false, length = 5)
	public String getAtiTribeCd() {
		return this.atiTribeCd;
	}

	public void setAtiTribeCd(String atiTribeCd) {
		this.atiTribeCd = atiTribeCd;
	}

	@Column(name = "ATI_TRIBE_NM", nullable = false, length = 25)
	public String getAtiTribeNm() {
		return this.atiTribeNm;
	}

	public void setAtiTribeNm(String atiTribeNm) {
		this.atiTribeNm = atiTribeNm;
	}

	@Column(name = "ABC_BANK_CD", nullable = false, length = 5)
	public String getAbcBankCd() {
		return this.abcBankCd;
	}

	public void setAbcBankCd(String abcBankCd) {
		this.abcBankCd = abcBankCd;
	}

	@Column(name = "ATI_DIRECTOR_NM", length = 100)
	public String getAtiDirectorNm() {
		return this.atiDirectorNm;
	}

	public void setAtiDirectorNm(String atiDirectorNm) {
		this.atiDirectorNm = atiDirectorNm;
	}

	@Column(name = "ATI_WHO_LOG", nullable = false, length = 15)
	public String getAtiWhoLog() {
		return this.atiWhoLog;
	}

	public void setAtiWhoLog(String atiWhoLog) {
		this.atiWhoLog = atiWhoLog;
	}

	@Column(name = "ATI_WHEN_LOG", nullable = false, length = 7)
	public Timestamp getAtiWhenLog() {
		return this.atiWhenLog;
	}

	public void setAtiWhenLog(Timestamp atiWhenLog) {
		this.atiWhenLog = atiWhenLog;
	}

	@Column(name = "ATI_TRIBE_ACCT_BANK_NM", length = 23)
	public String getAtiTribeAcctBankNm() {
		return this.atiTribeAcctBankNm;
	}

	public void setAtiTribeAcctBankNm(String atiTribeAcctBankNm) {
		this.atiTribeAcctBankNm = atiTribeAcctBankNm;
	}

	@Column(name = "ATI_TRIBE_ACCT_ROUTING_NO", length = 9)
	public String getAtiTribeAcctRoutingNo() {
		return this.atiTribeAcctRoutingNo;
	}

	public void setAtiTribeAcctRoutingNo(String atiTribeAcctRoutingNo) {
		this.atiTribeAcctRoutingNo = atiTribeAcctRoutingNo;
	}

	@Column(name = "ATI_TRIBE_ACCT_NO", length = 17)
	public String getAtiTribeAcctNo() {
		return this.atiTribeAcctNo;
	}

	public void setAtiTribeAcctNo(String atiTribeAcctNo) {
		this.atiTribeAcctNo = atiTribeAcctNo;
	}

}