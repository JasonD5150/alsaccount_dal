package fwp.alsaccount.dao.admin;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * LndsLwcfProjects entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "LNDS_LWCF_PROJECTS", schema = "FWPOWNER", uniqueConstraints = @UniqueConstraint(columnNames = "LLP_PROJECT_NUMBER"))
public class LndsLwcfProjects implements java.io.Serializable {

	// Fields

	private BigDecimal llpId;
	private String llpProjectNumber;
	private String llpProjectTitle;
	private String llpProjectSponsor;
	private String llpSponsorType;
	private String llpProjectType;
	private Double llpGrantAmount;
	private String llpProjectScope;
	private String llpRemarks;
	private Date llpDateAgreementSigned;
	private Date llpDateCompletedInspected;
	private Long llpLlscvId;
	private Date llpStatusChgDt;
	private Long llpLegacyProjectId;
	private Date llpCreateDate;
	private String llpCreateDbuser;
	private String llpCreatePersonid;
	private Date llpModDate;
	private String llpModDbuser;
	private String llpModPersonid;

	// Constructors

	/** default constructor */
	public LndsLwcfProjects() {
	}

	/** minimal constructor */
	public LndsLwcfProjects(BigDecimal llpId, String llpProjectNumber,
			Long llpLlscvId) {
		this.llpId = llpId;
		this.llpProjectNumber = llpProjectNumber;
		this.llpLlscvId = llpLlscvId;
	}

	/** full constructor */
	public LndsLwcfProjects(BigDecimal llpId, String llpProjectNumber,
			String llpProjectTitle, String llpProjectSponsor,
			String llpSponsorType, String llpProjectType,
			Double llpGrantAmount, String llpProjectScope, String llpRemarks,
			Date llpDateAgreementSigned, Date llpDateCompletedInspected,
			Long llpLlscvId, Date llpStatusChgDt, Long llpLegacyProjectId,
			Date llpCreateDate, String llpCreateDbuser,
			String llpCreatePersonid, Date llpModDate, String llpModDbuser,
			String llpModPersonid) {
		this.llpId = llpId;
		this.llpProjectNumber = llpProjectNumber;
		this.llpProjectTitle = llpProjectTitle;
		this.llpProjectSponsor = llpProjectSponsor;
		this.llpSponsorType = llpSponsorType;
		this.llpProjectType = llpProjectType;
		this.llpGrantAmount = llpGrantAmount;
		this.llpProjectScope = llpProjectScope;
		this.llpRemarks = llpRemarks;
		this.llpDateAgreementSigned = llpDateAgreementSigned;
		this.llpDateCompletedInspected = llpDateCompletedInspected;
		this.llpLlscvId = llpLlscvId;
		this.llpStatusChgDt = llpStatusChgDt;
		this.llpLegacyProjectId = llpLegacyProjectId;
		this.llpCreateDate = llpCreateDate;
		this.llpCreateDbuser = llpCreateDbuser;
		this.llpCreatePersonid = llpCreatePersonid;
		this.llpModDate = llpModDate;
		this.llpModDbuser = llpModDbuser;
		this.llpModPersonid = llpModPersonid;
	}

	// Property accessors
	@Id
	@Column(name = "LLP_ID", unique = true, nullable = false, precision = 32, scale = 0)
	public BigDecimal getLlpId() {
		return this.llpId;
	}

	public void setLlpId(BigDecimal llpId) {
		this.llpId = llpId;
	}

	@Column(name = "LLP_PROJECT_NUMBER", unique = true, nullable = false, length = 10)
	public String getLlpProjectNumber() {
		return this.llpProjectNumber;
	}

	public void setLlpProjectNumber(String llpProjectNumber) {
		this.llpProjectNumber = llpProjectNumber;
	}

	@Column(name = "LLP_PROJECT_TITLE", length = 100)
	public String getLlpProjectTitle() {
		return this.llpProjectTitle;
	}

	public void setLlpProjectTitle(String llpProjectTitle) {
		this.llpProjectTitle = llpProjectTitle;
	}

	@Column(name = "LLP_PROJECT_SPONSOR", length = 50)
	public String getLlpProjectSponsor() {
		return this.llpProjectSponsor;
	}

	public void setLlpProjectSponsor(String llpProjectSponsor) {
		this.llpProjectSponsor = llpProjectSponsor;
	}

	@Column(name = "LLP_SPONSOR_TYPE", length = 25)
	public String getLlpSponsorType() {
		return this.llpSponsorType;
	}

	public void setLlpSponsorType(String llpSponsorType) {
		this.llpSponsorType = llpSponsorType;
	}

	@Column(name = "LLP_PROJECT_TYPE", length = 20)
	public String getLlpProjectType() {
		return this.llpProjectType;
	}

	public void setLlpProjectType(String llpProjectType) {
		this.llpProjectType = llpProjectType;
	}

	@Column(name = "LLP_GRANT_AMOUNT", precision = 12)
	public Double getLlpGrantAmount() {
		return this.llpGrantAmount;
	}

	public void setLlpGrantAmount(Double llpGrantAmount) {
		this.llpGrantAmount = llpGrantAmount;
	}

	@Column(name = "LLP_PROJECT_SCOPE", length = 500)
	public String getLlpProjectScope() {
		return this.llpProjectScope;
	}

	public void setLlpProjectScope(String llpProjectScope) {
		this.llpProjectScope = llpProjectScope;
	}

	@Column(name = "LLP_REMARKS", length = 500)
	public String getLlpRemarks() {
		return this.llpRemarks;
	}

	public void setLlpRemarks(String llpRemarks) {
		this.llpRemarks = llpRemarks;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LLP_DATE_AGREEMENT_SIGNED", length = 7)
	public Date getLlpDateAgreementSigned() {
		return this.llpDateAgreementSigned;
	}

	public void setLlpDateAgreementSigned(Date llpDateAgreementSigned) {
		this.llpDateAgreementSigned = llpDateAgreementSigned;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LLP_DATE_COMPLETED_INSPECTED", length = 7)
	public Date getLlpDateCompletedInspected() {
		return this.llpDateCompletedInspected;
	}

	public void setLlpDateCompletedInspected(Date llpDateCompletedInspected) {
		this.llpDateCompletedInspected = llpDateCompletedInspected;
	}

	@Column(name = "LLP_LLSCV_ID", nullable = false, precision = 10, scale = 0)
	public Long getLlpLlscvId() {
		return this.llpLlscvId;
	}

	public void setLlpLlscvId(Long llpLlscvId) {
		this.llpLlscvId = llpLlscvId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LLP_STATUS_CHG_DT", length = 7)
	public Date getLlpStatusChgDt() {
		return this.llpStatusChgDt;
	}

	public void setLlpStatusChgDt(Date llpStatusChgDt) {
		this.llpStatusChgDt = llpStatusChgDt;
	}

	@Column(name = "LLP_LEGACY_PROJECT_ID", precision = 10, scale = 0)
	public Long getLlpLegacyProjectId() {
		return this.llpLegacyProjectId;
	}

	public void setLlpLegacyProjectId(Long llpLegacyProjectId) {
		this.llpLegacyProjectId = llpLegacyProjectId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LLP_CREATE_DATE", length = 7)
	public Date getLlpCreateDate() {
		return this.llpCreateDate;
	}

	public void setLlpCreateDate(Date llpCreateDate) {
		this.llpCreateDate = llpCreateDate;
	}

	@Column(name = "LLP_CREATE_DBUSER", length = 50)
	public String getLlpCreateDbuser() {
		return this.llpCreateDbuser;
	}

	public void setLlpCreateDbuser(String llpCreateDbuser) {
		this.llpCreateDbuser = llpCreateDbuser;
	}

	@Column(name = "LLP_CREATE_PERSONID", length = 50)
	public String getLlpCreatePersonid() {
		return this.llpCreatePersonid;
	}

	public void setLlpCreatePersonid(String llpCreatePersonid) {
		this.llpCreatePersonid = llpCreatePersonid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LLP_MOD_DATE", length = 7)
	public Date getLlpModDate() {
		return this.llpModDate;
	}

	public void setLlpModDate(Date llpModDate) {
		this.llpModDate = llpModDate;
	}

	@Column(name = "LLP_MOD_DBUSER", length = 50)
	public String getLlpModDbuser() {
		return this.llpModDbuser;
	}

	public void setLlpModDbuser(String llpModDbuser) {
		this.llpModDbuser = llpModDbuser;
	}

	@Column(name = "LLP_MOD_PERSONID", length = 50)
	public String getLlpModPersonid() {
		return this.llpModPersonid;
	}

	public void setLlpModPersonid(String llpModPersonid) {
		this.llpModPersonid = llpModPersonid;
	}

}