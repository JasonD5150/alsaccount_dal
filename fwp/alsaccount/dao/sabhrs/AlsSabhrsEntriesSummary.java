package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsSabhrsEntriesSummary entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_SABHRS_ENTRIES_SUMMARY"
    ,schema="ALS"
)

public class AlsSabhrsEntriesSummary  implements java.io.Serializable {


    // Fields    

     private AlsSabhrsEntriesSummaryIdPk idPk;
     private String aamBusinessUnit;
     private Integer asacReference;
     private String aamAccount;
     private String aamFund;
     private String aocOrg;
     private Integer asacProgram;
     private String asacSubclass;
     private Integer asacBudgetYear;
     private String asacProjectGrant;
     private Double aseAmt;
     private String asacSystemActivityTypeCd;
     private String asacTxnCd;
     private Timestamp asesWhenUploadedToSabhrs;
     private String asesWhoLog;
     private Timestamp asesWhenLog;
     private Integer atgTransactionCd;
     private String atgsGroupIdentifier;
     private String aseNonAlsFlag;
     private String aseLineDescription;
     private String atiTribeCd;


    // Constructors

    /** default constructor */
    public AlsSabhrsEntriesSummary() {
    }

	/** minimal constructor */
    public AlsSabhrsEntriesSummary(AlsSabhrsEntriesSummaryIdPk idPk, String aamBusinessUnit, String aamAccount, Integer asacBudgetYear, String asacSystemActivityTypeCd, String asacTxnCd, String asesWhoLog, Timestamp asesWhenLog) {
        this.idPk = idPk;
        this.aamBusinessUnit = aamBusinessUnit;
        this.aamAccount = aamAccount;
        this.asacBudgetYear = asacBudgetYear;
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
        this.asacTxnCd = asacTxnCd;
        this.asesWhoLog = asesWhoLog;
        this.asesWhenLog = asesWhenLog;
    }
    
    /** full constructor */
    public AlsSabhrsEntriesSummary(AlsSabhrsEntriesSummaryIdPk idPk, String aamBusinessUnit, Integer asacReference, String aamAccount, String aamFund, String aocOrg, Integer asacProgram, String asacSubclass, Integer asacBudgetYear, String asacProjectGrant, Double aseAmt, String asacSystemActivityTypeCd, String asacTxnCd, Timestamp asesWhenUploadedToSabhrs, String asesWhoLog, Timestamp asesWhenLog, Integer atgTransactionCd, String atgsGroupIdentifier, String aseNonAlsFlag, String aseLineDescription, String atiTribeCd) {
        this.idPk = idPk;
        this.aamBusinessUnit = aamBusinessUnit;
        this.asacReference = asacReference;
        this.aamAccount = aamAccount;
        this.aamFund = aamFund;
        this.aocOrg = aocOrg;
        this.asacProgram = asacProgram;
        this.asacSubclass = asacSubclass;
        this.asacBudgetYear = asacBudgetYear;
        this.asacProjectGrant = asacProjectGrant;
        this.aseAmt = aseAmt;
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
        this.asacTxnCd = asacTxnCd;
        this.asesWhenUploadedToSabhrs = asesWhenUploadedToSabhrs;
        this.asesWhoLog = asesWhoLog;
        this.asesWhenLog = asesWhenLog;
        this.atgTransactionCd = atgTransactionCd;
        this.atgsGroupIdentifier = atgsGroupIdentifier;
        this.aseNonAlsFlag = aseNonAlsFlag;
        this.aseLineDescription = aseLineDescription;
        this.atiTribeCd = atiTribeCd;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="asesDateCreated", column=@Column(name="ASES_DATE_CREATED", nullable=false, length=7) ), 
        @AttributeOverride(name="asesSeqNo", column=@Column(name="ASES_SEQ_NO", nullable=false, precision=12, scale=0) ) } )

    public AlsSabhrsEntriesSummaryIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsSabhrsEntriesSummaryIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="AAM_BUSINESS_UNIT", nullable=false, length=5)

    public String getAamBusinessUnit() {
        return this.aamBusinessUnit;
    }
    
    public void setAamBusinessUnit(String aamBusinessUnit) {
        this.aamBusinessUnit = aamBusinessUnit;
    }
    
    @Column(name="ASAC_REFERENCE", precision=5, scale=0)

    public Integer getAsacReference() {
        return this.asacReference;
    }
    
    public void setAsacReference(Integer asacReference) {
        this.asacReference = asacReference;
    }
    
    @Column(name="AAM_ACCOUNT", nullable=false, length=6)

    public String getAamAccount() {
        return this.aamAccount;
    }
    
    public void setAamAccount(String aamAccount) {
        this.aamAccount = aamAccount;
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
    
    @Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0)

    public Integer getAsacBudgetYear() {
        return this.asacBudgetYear;
    }
    
    public void setAsacBudgetYear(Integer asacBudgetYear) {
        this.asacBudgetYear = asacBudgetYear;
    }
    
    @Column(name="ASAC_PROJECT_GRANT", length=15)

    public String getAsacProjectGrant() {
        return this.asacProjectGrant;
    }
    
    public void setAsacProjectGrant(String asacProjectGrant) {
        this.asacProjectGrant = asacProjectGrant;
    }
    
    @Column(name="ASE_AMT", precision=12)

    public Double getAseAmt() {
        return this.aseAmt;
    }
    
    public void setAseAmt(Double aseAmt) {
        this.aseAmt = aseAmt;
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
    
    @Column(name="ASES_WHEN_UPLOADED_TO_SABHRS", length=7)

    public Timestamp getAsesWhenUploadedToSabhrs() {
        return this.asesWhenUploadedToSabhrs;
    }
    
    public void setAsesWhenUploadedToSabhrs(Timestamp asesWhenUploadedToSabhrs) {
        this.asesWhenUploadedToSabhrs = asesWhenUploadedToSabhrs;
    }
    
    @Column(name="ASES_WHO_LOG", nullable=false, length=15)

    public String getAsesWhoLog() {
        return this.asesWhoLog;
    }
    
    public void setAsesWhoLog(String asesWhoLog) {
        this.asesWhoLog = asesWhoLog;
    }
    
    @Column(name="ASES_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAsesWhenLog() {
        return this.asesWhenLog;
    }
    
    public void setAsesWhenLog(Timestamp asesWhenLog) {
        this.asesWhenLog = asesWhenLog;
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
   








}