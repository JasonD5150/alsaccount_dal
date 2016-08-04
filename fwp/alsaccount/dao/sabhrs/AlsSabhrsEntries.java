package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * sabhrsAlsSabhrsEntries entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_SABHRS_ENTRIES"
    ,schema="ALS"
)

public class AlsSabhrsEntries  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlsSabhrsEntriesIdPk idPk;
     private Integer asacBudgetYear;
     private String asacSystemActivityTypeCd;
     private String asacTxnCd;
     private String aamAccount;
     private String aamBusinessUnit;
     private String aamFund;
     private String aocOrg;
     private Integer asacProgram;
     private String asacSubclass;
     private String asacProjectGrant;
     private Integer asacReference;
     private Double aseAmt;
     private String aseAllowUploadToSummary;
     private Timestamp aseWhenUploadedToSummary;
     private Integer asesSeqNo;
     private Integer apiProviderNo;
     private Timestamp aprBillingFrom;
     private Timestamp aprBillingTo;
     private Integer aiafaSeqNo;
     private String aseWhoLog;
     private Timestamp aseWhenLog;
     private Timestamp aseWhenUploadedToSumm;
     private Integer atgTransactionCd;
     private String atgsGroupIdentifier;
     private String aseNonAlsFlag;
     private String aseLineDescription;
     private String atiTribeCd;
     private String anatCd;


    // Constructors

    /** default constructor */
    public AlsSabhrsEntries() {
    }

	/** minimal constructor */
    public AlsSabhrsEntries(AlsSabhrsEntriesIdPk idPk, Integer asacBudgetYear, String asacSystemActivityTypeCd, String asacTxnCd, String aamAccount, String aamBusinessUnit, String aseWhoLog, Timestamp aseWhenLog) {
        this.idPk = idPk;
        this.asacBudgetYear = asacBudgetYear;
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
        this.asacTxnCd = asacTxnCd;
        this.aamAccount = aamAccount;
        this.aamBusinessUnit = aamBusinessUnit;
        this.aseWhoLog = aseWhoLog;
        this.aseWhenLog = aseWhenLog;
    }
    
    /** full constructor */
    public AlsSabhrsEntries(AlsSabhrsEntriesIdPk idPk, Integer asacBudgetYear, String asacSystemActivityTypeCd, String asacTxnCd, String aamAccount, String aamBusinessUnit, String aamFund, String aocOrg, Integer asacProgram, String asacSubclass, String asacProjectGrant, Integer asacReference, Double aseAmt, String aseAllowUploadToSummary, Timestamp aseWhenUploadedToSummary, Integer asesSeqNo, Integer apiProviderNo, Timestamp aprBillingFrom, Timestamp aprBillingTo, Integer aiafaSeqNo, String aseWhoLog, Timestamp aseWhenLog, Timestamp aseWhenUploadedToSumm, Integer atgTransactionCd, String atgsGroupIdentifier, String aseNonAlsFlag, String aseLineDescription, String atiTribeCd, String anatCd) {
        this.idPk = idPk;
        this.asacBudgetYear = asacBudgetYear;
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
        this.asacTxnCd = asacTxnCd;
        this.aamAccount = aamAccount;
        this.aamBusinessUnit = aamBusinessUnit;
        this.aamFund = aamFund;
        this.aocOrg = aocOrg;
        this.asacProgram = asacProgram;
        this.asacSubclass = asacSubclass;
        this.asacProjectGrant = asacProjectGrant;
        this.asacReference = asacReference;
        this.aseAmt = aseAmt;
        this.aseAllowUploadToSummary = aseAllowUploadToSummary;
        this.aseWhenUploadedToSummary = aseWhenUploadedToSummary;
        this.asesSeqNo = asesSeqNo;
        this.apiProviderNo = apiProviderNo;
        this.aprBillingFrom = aprBillingFrom;
        this.aprBillingTo = aprBillingTo;
        this.aiafaSeqNo = aiafaSeqNo;
        this.aseWhoLog = aseWhoLog;
        this.aseWhenLog = aseWhenLog;
        this.aseWhenUploadedToSumm = aseWhenUploadedToSumm;
        this.atgTransactionCd = atgTransactionCd;
        this.atgsGroupIdentifier = atgsGroupIdentifier;
        this.aseNonAlsFlag = aseNonAlsFlag;
        this.aseLineDescription = aseLineDescription;
        this.atiTribeCd = atiTribeCd;
        this.anatCd = anatCd;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="aseWhenEntryPosted", column=@Column(name="ASE_WHEN_ENTRY_POSTED", nullable=false, length=7) ), 
        @AttributeOverride(name="aseSeqNo", column=@Column(name="ASE_SEQ_NO", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="aseDrCrCd", column=@Column(name="ASE_DR_CR_CD", nullable=false, length=1) ), 
        @AttributeOverride(name="aseTxnCdSeqNo", column=@Column(name="ASE_TXN_CD_SEQ_NO", nullable=false, precision=4, scale=0) ) } )

    public AlsSabhrsEntriesIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsSabhrsEntriesIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0)

    public Integer getAsacBudgetYear() {
        return this.asacBudgetYear;
    }
    
    public void setAsacBudgetYear(Integer asacBudgetYear) {
        this.asacBudgetYear = asacBudgetYear;
    }
    
    @Column(name="ASAC_SYSTEM_ACTIVITY_TYPE_CD", nullable=false, length=1)

    public String getAsacSystemActivityTypeCd() {
        return this.asacSystemActivityTypeCd;
    }
    
    public void setAsacSystemActivityTypeCd(String asacSystemActivityTypeCd) {
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
    }
    
    @Column(name="ASAC_TXN_CD", nullable=false, length=3)

    public String getAsacTxnCd() {
        return this.asacTxnCd;
    }
    
    public void setAsacTxnCd(String asacTxnCd) {
        this.asacTxnCd = asacTxnCd;
    }
    
    @Column(name="AAM_ACCOUNT", nullable=false, length=6)

    public String getAamAccount() {
        return this.aamAccount;
    }
    
    public void setAamAccount(String aamAccount) {
        this.aamAccount = aamAccount;
    }
    
    @Column(name="AAM_BUSINESS_UNIT", nullable=false, length=5)

    public String getAamBusinessUnit() {
        return this.aamBusinessUnit;
    }
    
    public void setAamBusinessUnit(String aamBusinessUnit) {
        this.aamBusinessUnit = aamBusinessUnit;
    }
    
    @Column(name="AAM_FUND", length=6)

    public String getAamFund() {
        return this.aamFund;
    }
    
    public void setAamFund(String aamFund) {
        this.aamFund = aamFund;
    }
    
    @Column(name="AOC_ORG", length=6)

    public String getAocOrg() {
        return this.aocOrg;
    }
    
    public void setAocOrg(String aocOrg) {
        this.aocOrg = aocOrg;
    }
    
    @Column(name="ASAC_PROGRAM", precision=4, scale=0)

    public Integer getAsacProgram() {
        return this.asacProgram;
    }
    
    public void setAsacProgram(Integer asacProgram) {
        this.asacProgram = asacProgram;
    }
    
    @Column(name="ASAC_SUBCLASS", length=5)

    public String getAsacSubclass() {
        return this.asacSubclass;
    }
    
    public void setAsacSubclass(String asacSubclass) {
        this.asacSubclass = asacSubclass;
    }
    
    @Column(name="ASAC_PROJECT_GRANT", length=15)

    public String getAsacProjectGrant() {
        return this.asacProjectGrant;
    }
    
    public void setAsacProjectGrant(String asacProjectGrant) {
        this.asacProjectGrant = asacProjectGrant;
    }
    
    @Column(name="ASAC_REFERENCE", precision=5, scale=0)

    public Integer getAsacReference() {
        return this.asacReference;
    }
    
    public void setAsacReference(Integer asacReference) {
        this.asacReference = asacReference;
    }
    
    @Column(name="ASE_AMT", precision=12)

    public Double getAseAmt() {
        return this.aseAmt;
    }
    
    public void setAseAmt(Double aseAmt) {
        this.aseAmt = aseAmt;
    }
    
    @Column(name="ASE_ALLOW_UPLOAD_TO_SUMMARY", length=1)

    public String getAseAllowUploadToSummary() {
        return this.aseAllowUploadToSummary;
    }
    
    public void setAseAllowUploadToSummary(String aseAllowUploadToSummary) {
        this.aseAllowUploadToSummary = aseAllowUploadToSummary;
    }
    
    @Column(name="ASE_WHEN_UPLOADED_TO_SUMMARY", length=7)

    public Timestamp getAseWhenUploadedToSummary() {
        return this.aseWhenUploadedToSummary;
    }
    
    public void setAseWhenUploadedToSummary(Timestamp aseWhenUploadedToSummary) {
        this.aseWhenUploadedToSummary = aseWhenUploadedToSummary;
    }
    
    @Column(name="ASES_SEQ_NO", precision=12, scale=0)

    public Integer getAsesSeqNo() {
        return this.asesSeqNo;
    }
    
    public void setAsesSeqNo(Integer asesSeqNo) {
        this.asesSeqNo = asesSeqNo;
    }
    
    @Column(name="API_PROVIDER_NO", precision=10, scale=0)

    public Integer getApiProviderNo() {
        return this.apiProviderNo;
    }
    
    public void setApiProviderNo(Integer apiProviderNo) {
        this.apiProviderNo = apiProviderNo;
    }
    
    @Column(name="APR_BILLING_FROM", length=7)

    public Timestamp getAprBillingFrom() {
        return this.aprBillingFrom;
    }
    
    public void setAprBillingFrom(Timestamp aprBillingFrom) {
        this.aprBillingFrom = aprBillingFrom;
    }
    
    @Column(name="APR_BILLING_TO", length=7)

    public Timestamp getAprBillingTo() {
        return this.aprBillingTo;
    }
    
    public void setAprBillingTo(Timestamp aprBillingTo) {
        this.aprBillingTo = aprBillingTo;
    }
    
    @Column(name="AIAFA_SEQ_NO", precision=6, scale=0)

    public Integer getAiafaSeqNo() {
        return this.aiafaSeqNo;
    }
    
    public void setAiafaSeqNo(Integer aiafaSeqNo) {
        this.aiafaSeqNo = aiafaSeqNo;
    }
    
    @Column(name="ASE_WHO_LOG", nullable=false, length=15)

    public String getAseWhoLog() {
        return this.aseWhoLog;
    }
    
    public void setAseWhoLog(String aseWhoLog) {
        this.aseWhoLog = aseWhoLog;
    }
    
    @Column(name="ASE_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAseWhenLog() {
        return this.aseWhenLog;
    }
    
    public void setAseWhenLog(Timestamp aseWhenLog) {
        this.aseWhenLog = aseWhenLog;
    }
    
    @Column(name="ASE_WHEN_UPLOADED_TO_SUMM", length=7)

    public Timestamp getAseWhenUploadedToSumm() {
        return this.aseWhenUploadedToSumm;
    }
    
    public void setAseWhenUploadedToSumm(Timestamp aseWhenUploadedToSumm) {
        this.aseWhenUploadedToSumm = aseWhenUploadedToSumm;
    }
    
    @Column(name="ATG_TRANSACTION_CD", precision=5, scale=0)

    public Integer getAtgTransactionCd() {
        return this.atgTransactionCd;
    }
    
    public void setAtgTransactionCd(Integer atgTransactionCd) {
        this.atgTransactionCd = atgTransactionCd;
    }
    
    @Column(name="ATGS_GROUP_IDENTIFIER", length=50)

    public String getAtgsGroupIdentifier() {
        return this.atgsGroupIdentifier;
    }
    
    public void setAtgsGroupIdentifier(String atgsGroupIdentifier) {
        this.atgsGroupIdentifier = atgsGroupIdentifier;
    }
    
    @Column(name="ASE_NON_ALS_FLAG", length=1)

    public String getAseNonAlsFlag() {
        return this.aseNonAlsFlag;
    }
    
    public void setAseNonAlsFlag(String aseNonAlsFlag) {
        this.aseNonAlsFlag = aseNonAlsFlag;
    }
    
    @Column(name="ASE_LINE_DESCRIPTION", length=30)

    public String getAseLineDescription() {
        return this.aseLineDescription;
    }
    
    public void setAseLineDescription(String aseLineDescription) {
        this.aseLineDescription = aseLineDescription;
    }
    
    @Column(name="ATI_TRIBE_CD", length=3)

    public String getAtiTribeCd() {
        return this.atiTribeCd;
    }
    
    public void setAtiTribeCd(String atiTribeCd) {
        this.atiTribeCd = atiTribeCd;
    }
    
    @Column(name="ANAT_CD", length=5)

    public String getAnatCd() {
        return this.anatCd;
    }
    
    public void setAnatCd(String anatCd) {
        this.anatCd = anatCd;
    }
   








}