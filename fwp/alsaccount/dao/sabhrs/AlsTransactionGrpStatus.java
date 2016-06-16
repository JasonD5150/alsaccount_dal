package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * sabhrsAlsTransactionGrpStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_TRANSACTION_GRP_STATUS"
    ,schema="ALS"
)

public class AlsTransactionGrpStatus  implements java.io.Serializable {


    // Fields    

     private AlsTransactionGrpStatusIdPk idPk;
     private String atgsSummaryStatus;
     private String atgsInterfaceStatus;
     private Timestamp atgsSummaryDt;
     private Timestamp atgsInterfaceDt;
     private String atgsSummaryApprovedBy;
     private String atgsInterfaceApprovedBy;
     private Timestamp atgsWhenUploadToSummary;
     private String atgsFileName;
     private String atgsRemarks;
     private String abcBankCd;
     private Timestamp atgsAccountingDt;
     private Double atgsNetDrCr;
     private String atgsNonAlsFlag;
     private Timestamp atgsWhenUploadedToSabhrs;
     private String atgsDepositId;
     private Timestamp atgsWhenCreated;
     private String atgsWhoCreated;
     private Timestamp atgsWhenModi;
     private String atgsWhoModi;
     private String atgsArGlFlag;
     private Timestamp atgsFileCreationDt;
     private String atgsBankReferenceNo;
     private Integer atgsFyePriorProgram;
     private Integer atgsFyeOverrideProgram;
     private Timestamp atgsFyeOverrideAcctDt;


    // Constructors

    /** default constructor */
    public AlsTransactionGrpStatus() {
    }

	/** minimal constructor */
    public AlsTransactionGrpStatus(AlsTransactionGrpStatusIdPk idPk, Timestamp atgsWhenCreated, String atgsWhoCreated) {
        this.idPk = idPk;
        this.atgsWhenCreated = atgsWhenCreated;
        this.atgsWhoCreated = atgsWhoCreated;
    }
    
    /** full constructor */
    public AlsTransactionGrpStatus(AlsTransactionGrpStatusIdPk idPk, String atgsSummaryStatus, String atgsInterfaceStatus, Timestamp atgsSummaryDt, Timestamp atgsInterfaceDt, String atgsSummaryApprovedBy, String atgsInterfaceApprovedBy, Timestamp atgsWhenUploadToSummary, String atgsFileName, String atgsRemarks, String abcBankCd, Timestamp atgsAccountingDt, Double atgsNetDrCr, String atgsNonAlsFlag, Timestamp atgsWhenUploadedToSabhrs, String atgsDepositId, Timestamp atgsWhenCreated, String atgsWhoCreated, Timestamp atgsWhenModi, String atgsWhoModi, String atgsArGlFlag, Timestamp atgsFileCreationDt, String atgsBankReferenceNo, Integer atgsFyePriorProgram, Integer atgsFyeOverrideProgram, Timestamp atgsFyeOverrideAcctDt) {
        this.idPk = idPk;
        this.atgsSummaryStatus = atgsSummaryStatus;
        this.atgsInterfaceStatus = atgsInterfaceStatus;
        this.atgsSummaryDt = atgsSummaryDt;
        this.atgsInterfaceDt = atgsInterfaceDt;
        this.atgsSummaryApprovedBy = atgsSummaryApprovedBy;
        this.atgsInterfaceApprovedBy = atgsInterfaceApprovedBy;
        this.atgsWhenUploadToSummary = atgsWhenUploadToSummary;
        this.atgsFileName = atgsFileName;
        this.atgsRemarks = atgsRemarks;
        this.abcBankCd = abcBankCd;
        this.atgsAccountingDt = atgsAccountingDt;
        this.atgsNetDrCr = atgsNetDrCr;
        this.atgsNonAlsFlag = atgsNonAlsFlag;
        this.atgsWhenUploadedToSabhrs = atgsWhenUploadedToSabhrs;
        this.atgsDepositId = atgsDepositId;
        this.atgsWhenCreated = atgsWhenCreated;
        this.atgsWhoCreated = atgsWhoCreated;
        this.atgsWhenModi = atgsWhenModi;
        this.atgsWhoModi = atgsWhoModi;
        this.atgsArGlFlag = atgsArGlFlag;
        this.atgsFileCreationDt = atgsFileCreationDt;
        this.atgsBankReferenceNo = atgsBankReferenceNo;
        this.atgsFyePriorProgram = atgsFyePriorProgram;
        this.atgsFyeOverrideProgram = atgsFyeOverrideProgram;
        this.atgsFyeOverrideAcctDt = atgsFyeOverrideAcctDt;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="atgTransactionCd", column=@Column(name="ATG_TRANSACTION_CD", nullable=false, precision=5, scale=0) ), 
        @AttributeOverride(name="atgsGroupIdentifier", column=@Column(name="ATGS_GROUP_IDENTIFIER", nullable=false, length=50) ) } )

    public AlsTransactionGrpStatusIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsTransactionGrpStatusIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="ATGS_SUMMARY_STATUS", length=1)

    public String getAtgsSummaryStatus() {
        return this.atgsSummaryStatus;
    }
    
    public void setAtgsSummaryStatus(String atgsSummaryStatus) {
        this.atgsSummaryStatus = atgsSummaryStatus;
    }
    
    @Column(name="ATGS_INTERFACE_STATUS", length=1)

    public String getAtgsInterfaceStatus() {
        return this.atgsInterfaceStatus;
    }
    
    public void setAtgsInterfaceStatus(String atgsInterfaceStatus) {
        this.atgsInterfaceStatus = atgsInterfaceStatus;
    }
    
    @Column(name="ATGS_SUMMARY_DT", length=7)

    public Timestamp getAtgsSummaryDt() {
        return this.atgsSummaryDt;
    }
    
    public void setAtgsSummaryDt(Timestamp atgsSummaryDt) {
        this.atgsSummaryDt = atgsSummaryDt;
    }
    
    @Column(name="ATGS_INTERFACE_DT", length=7)

    public Timestamp getAtgsInterfaceDt() {
        return this.atgsInterfaceDt;
    }
    
    public void setAtgsInterfaceDt(Timestamp atgsInterfaceDt) {
        this.atgsInterfaceDt = atgsInterfaceDt;
    }
    
    @Column(name="ATGS_SUMMARY_APPROVED_BY", length=15)

    public String getAtgsSummaryApprovedBy() {
        return this.atgsSummaryApprovedBy;
    }
    
    public void setAtgsSummaryApprovedBy(String atgsSummaryApprovedBy) {
        this.atgsSummaryApprovedBy = atgsSummaryApprovedBy;
    }
    
    @Column(name="ATGS_INTERFACE_APPROVED_BY", length=15)

    public String getAtgsInterfaceApprovedBy() {
        return this.atgsInterfaceApprovedBy;
    }
    
    public void setAtgsInterfaceApprovedBy(String atgsInterfaceApprovedBy) {
        this.atgsInterfaceApprovedBy = atgsInterfaceApprovedBy;
    }
    
    @Column(name="ATGS_WHEN_UPLOAD_TO_SUMMARY", length=7)

    public Timestamp getAtgsWhenUploadToSummary() {
        return this.atgsWhenUploadToSummary;
    }
    
    public void setAtgsWhenUploadToSummary(Timestamp atgsWhenUploadToSummary) {
        this.atgsWhenUploadToSummary = atgsWhenUploadToSummary;
    }
    
    @Column(name="ATGS_FILE_NAME", length=200)

    public String getAtgsFileName() {
        return this.atgsFileName;
    }
    
    public void setAtgsFileName(String atgsFileName) {
        this.atgsFileName = atgsFileName;
    }
    
    @Column(name="ATGS_REMARKS", length=2000)

    public String getAtgsRemarks() {
        return this.atgsRemarks;
    }
    
    public void setAtgsRemarks(String atgsRemarks) {
        this.atgsRemarks = atgsRemarks;
    }
    
    @Column(name="ABC_BANK_CD", length=3)

    public String getAbcBankCd() {
        return this.abcBankCd;
    }
    
    public void setAbcBankCd(String abcBankCd) {
        this.abcBankCd = abcBankCd;
    }
    
    @Column(name="ATGS_ACCOUNTING_DT", length=7)

    public Timestamp getAtgsAccountingDt() {
        return this.atgsAccountingDt;
    }
    
    public void setAtgsAccountingDt(Timestamp atgsAccountingDt) {
        this.atgsAccountingDt = atgsAccountingDt;
    }
    
    @Column(name="ATGS_NET_DR_CR", precision=10)

    public Double getAtgsNetDrCr() {
        return this.atgsNetDrCr;
    }
    
    public void setAtgsNetDrCr(Double atgsNetDrCr) {
        this.atgsNetDrCr = atgsNetDrCr;
    }
    
    @Column(name="ATGS_NON_ALS_FLAG", length=1)

    public String getAtgsNonAlsFlag() {
        return this.atgsNonAlsFlag;
    }
    
    public void setAtgsNonAlsFlag(String atgsNonAlsFlag) {
        this.atgsNonAlsFlag = atgsNonAlsFlag;
    }
    
    @Column(name="ATGS_WHEN_UPLOADED_TO_SABHRS", length=7)

    public Timestamp getAtgsWhenUploadedToSabhrs() {
        return this.atgsWhenUploadedToSabhrs;
    }
    
    public void setAtgsWhenUploadedToSabhrs(Timestamp atgsWhenUploadedToSabhrs) {
        this.atgsWhenUploadedToSabhrs = atgsWhenUploadedToSabhrs;
    }
    
    @Column(name="ATGS_DEPOSIT_ID", length=15)

    public String getAtgsDepositId() {
        return this.atgsDepositId;
    }
    
    public void setAtgsDepositId(String atgsDepositId) {
        this.atgsDepositId = atgsDepositId;
    }
    
    @Column(name="ATGS_WHEN_CREATED", nullable=false, length=7)

    public Timestamp getAtgsWhenCreated() {
        return this.atgsWhenCreated;
    }
    
    public void setAtgsWhenCreated(Timestamp atgsWhenCreated) {
        this.atgsWhenCreated = atgsWhenCreated;
    }
    
    @Column(name="ATGS_WHO_CREATED", nullable=false, length=15)

    public String getAtgsWhoCreated() {
        return this.atgsWhoCreated;
    }
    
    public void setAtgsWhoCreated(String atgsWhoCreated) {
        this.atgsWhoCreated = atgsWhoCreated;
    }
    
    @Column(name="ATGS_WHEN_MODI", length=7)

    public Timestamp getAtgsWhenModi() {
        return this.atgsWhenModi;
    }
    
    public void setAtgsWhenModi(Timestamp atgsWhenModi) {
        this.atgsWhenModi = atgsWhenModi;
    }
    
    @Column(name="ATGS_WHO_MODI", length=15)

    public String getAtgsWhoModi() {
        return this.atgsWhoModi;
    }
    
    public void setAtgsWhoModi(String atgsWhoModi) {
        this.atgsWhoModi = atgsWhoModi;
    }
    
    @Column(name="ATGS_AR_GL_FLAG", length=2)

    public String getAtgsArGlFlag() {
        return this.atgsArGlFlag;
    }
    
    public void setAtgsArGlFlag(String atgsArGlFlag) {
        this.atgsArGlFlag = atgsArGlFlag;
    }
    
    @Column(name="ATGS_FILE_CREATION_DT", length=7)

    public Timestamp getAtgsFileCreationDt() {
        return this.atgsFileCreationDt;
    }
    
    public void setAtgsFileCreationDt(Timestamp atgsFileCreationDt) {
        this.atgsFileCreationDt = atgsFileCreationDt;
    }
    
    @Column(name="ATGS_BANK_REFERENCE_NO", length=30)

    public String getAtgsBankReferenceNo() {
        return this.atgsBankReferenceNo;
    }
    
    public void setAtgsBankReferenceNo(String atgsBankReferenceNo) {
        this.atgsBankReferenceNo = atgsBankReferenceNo;
    }
    
    @Column(name="ATGS_FYE_PRIOR_PROGRAM", precision=4, scale=0)

    public Integer getAtgsFyePriorProgram() {
        return this.atgsFyePriorProgram;
    }
    
    public void setAtgsFyePriorProgram(Integer atgsFyePriorProgram) {
        this.atgsFyePriorProgram = atgsFyePriorProgram;
    }
    
    @Column(name="ATGS_FYE_OVERRIDE_PROGRAM", precision=4, scale=0)

    public Integer getAtgsFyeOverrideProgram() {
        return this.atgsFyeOverrideProgram;
    }
    
    public void setAtgsFyeOverrideProgram(Integer atgsFyeOverrideProgram) {
        this.atgsFyeOverrideProgram = atgsFyeOverrideProgram;
    }
    
    @Column(name="ATGS_FYE_OVERRIDE_ACCT_DT", length=7)

    public Timestamp getAtgsFyeOverrideAcctDt() {
        return this.atgsFyeOverrideAcctDt;
    }
    
    public void setAtgsFyeOverrideAcctDt(Timestamp atgsFyeOverrideAcctDt) {
        this.atgsFyeOverrideAcctDt = atgsFyeOverrideAcctDt;
    }
   








}