package fwp.alsaccount.dao.sabhrs;
// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AlsTransactionGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ALS_TRANSACTION_GROUP", schema = "ALS")
public class AlsTransactionGroup implements java.io.Serializable {

	// Fields

	private Integer atgTransactionCd;
	private String atgBusinessProcessType;
	private String atgTransactionDesc;
	private String atgIdentifierString;
	private String atgInterfaceFile;
	private String atgWhoLog;
	private Timestamp atgWhenLog;

	// Constructors

	/** default constructor */
	public AlsTransactionGroup() {
	}

	/** full constructor */
	public AlsTransactionGroup(Integer atgTransactionCd,
			String atgBusinessProcessType, String atgTransactionDesc,
			String atgIdentifierString, String atgInterfaceFile,
			String atgWhoLog, Timestamp atgWhenLog) {
		this.atgTransactionCd = atgTransactionCd;
		this.atgBusinessProcessType = atgBusinessProcessType;
		this.atgTransactionDesc = atgTransactionDesc;
		this.atgIdentifierString = atgIdentifierString;
		this.atgInterfaceFile = atgInterfaceFile;
		this.atgWhoLog = atgWhoLog;
		this.atgWhenLog = atgWhenLog;
	}

	// Property accessors
	@Id
	@Column(name = "ATG_TRANSACTION_CD", unique = true, nullable = false, precision = 5, scale = 0)
	public Integer getAtgTransactionCd() {
		return this.atgTransactionCd;
	}

	public void setAtgTransactionCd(Integer atgTransactionCd) {
		this.atgTransactionCd = atgTransactionCd;
	}

	@Column(name = "ATG_BUSINESS_PROCESS_TYPE", nullable = false, length = 50)
	public String getAtgBusinessProcessType() {
		return this.atgBusinessProcessType;
	}

	public void setAtgBusinessProcessType(String atgBusinessProcessType) {
		this.atgBusinessProcessType = atgBusinessProcessType;
	}

	@Column(name = "ATG_TRANSACTION_DESC", nullable = false, length = 200)
	public String getAtgTransactionDesc() {
		return this.atgTransactionDesc;
	}

	public void setAtgTransactionDesc(String atgTransactionDesc) {
		this.atgTransactionDesc = atgTransactionDesc;
	}

	@Column(name = "ATG_IDENTIFIER_STRING", nullable = false, length = 50)
	public String getAtgIdentifierString() {
		return this.atgIdentifierString;
	}

	public void setAtgIdentifierString(String atgIdentifierString) {
		this.atgIdentifierString = atgIdentifierString;
	}

	@Column(name = "ATG_INTERFACE_FILE", nullable = false, length = 2)
	public String getAtgInterfaceFile() {
		return this.atgInterfaceFile;
	}

	public void setAtgInterfaceFile(String atgInterfaceFile) {
		this.atgInterfaceFile = atgInterfaceFile;
	}

	@Column(name = "ATG_WHO_LOG", nullable = false, length = 15)
	public String getAtgWhoLog() {
		return this.atgWhoLog;
	}

	public void setAtgWhoLog(String atgWhoLog) {
		this.atgWhoLog = atgWhoLog;
	}

	@Column(name = "ATG_WHEN_LOG", nullable = false, length = 7)
	public Timestamp getAtgWhenLog() {
		return this.atgWhenLog;
	}

	public void setAtgWhenLog(Timestamp atgWhenLog) {
		this.atgWhenLog = atgWhenLog;
	}

}