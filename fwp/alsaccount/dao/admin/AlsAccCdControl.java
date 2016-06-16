package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsAccCdControl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_ACC_CD_CONTROL"
    ,schema="ALS"
)

public class AlsAccCdControl  implements java.io.Serializable {


    // Fields    

	 private static final long serialVersionUID = -1234281836757042954L;
	 private AlsAccCdControlIdPk idPk;
     private String aamAccount;
     private String aocOrg;
     private String aaccOrgFlag;
     private String aaccFund;
     private Double aaccAllocatedAmt;
     private String aaccBalancingAmtFlag;
     private String asacSubclass;
     private String aaccWhoLog;
     private Timestamp aaccWhenLog;
     private String aaccRemarks;
     private String aaccJlrRequired;


    // Constructors

    /** default constructor */
    public AlsAccCdControl() {
    }

	/** minimal constructor */
    public AlsAccCdControl(AlsAccCdControlIdPk idPk, String aamAccount, String aaccFund, String aaccWhoLog, Timestamp aaccWhenLog) {
        this.idPk = idPk;
        this.aamAccount = aamAccount;
        this.aaccFund = aaccFund;
        this.aaccWhoLog = aaccWhoLog;
        this.aaccWhenLog = aaccWhenLog;
    }
    
    /** full constructor */
    public AlsAccCdControl(AlsAccCdControlIdPk idPk, String aamAccount, String aocOrg, String aaccOrgFlag, String aaccFund, Double aaccAllocatedAmt, String aaccBalancingAmtFlag, String asacSubclass, String aaccWhoLog, Timestamp aaccWhenLog, String aaccRemarks, String aaccJlrRequired) {
        this.idPk = idPk;
        this.aamAccount = aamAccount;
        this.aocOrg = aocOrg;
        this.aaccOrgFlag = aaccOrgFlag;
        this.aaccFund = aaccFund;
        this.aaccAllocatedAmt = aaccAllocatedAmt;
        this.aaccBalancingAmtFlag = aaccBalancingAmtFlag;
        this.asacSubclass = asacSubclass;
        this.aaccWhoLog = aaccWhoLog;
        this.aaccWhenLog = aaccWhenLog;
        this.aaccRemarks = aaccRemarks;
        this.aaccJlrRequired = aaccJlrRequired;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="asacBudgetYear", column=@Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="aaccAccCd", column=@Column(name="AACC_ACC_CD", nullable=false, length=3) ), 
        @AttributeOverride(name="aaccSeqNo", column=@Column(name="AACC_SEQ_NO", nullable=false, precision=3, scale=0) ) } )

    public AlsAccCdControlIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsAccCdControlIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="AAM_ACCOUNT", nullable=false, length=6)

    public String getAamAccount() {
        return this.aamAccount;
    }
    
    public void setAamAccount(String aamAccount) {
        this.aamAccount = aamAccount;
    }
    
    @Column(name="AOC_ORG", length=6)

    public String getAocOrg() {
        return this.aocOrg;
    }
    
    public void setAocOrg(String aocOrg) {
        this.aocOrg = aocOrg;
    }
    
    @Column(name="AACC_ORG_FLAG", length=1)

    public String getAaccOrgFlag() {
        return this.aaccOrgFlag;
    }
    
    public void setAaccOrgFlag(String aaccOrgFlag) {
        this.aaccOrgFlag = aaccOrgFlag;
    }
    
    @Column(name="AACC_FUND", nullable=false, length=6)

    public String getAaccFund() {
        return this.aaccFund;
    }
    
    public void setAaccFund(String aaccFund) {
        this.aaccFund = aaccFund;
    }
    
    @Column(name="AACC_ALLOCATED_AMT", precision=8)

    public Double getAaccAllocatedAmt() {
        return this.aaccAllocatedAmt;
    }
    
    public void setAaccAllocatedAmt(Double aaccAllocatedAmt) {
        this.aaccAllocatedAmt = aaccAllocatedAmt;
    }
    
    @Column(name="AACC_BALANCING_AMT_FLAG", length=1)

    public String getAaccBalancingAmtFlag() {
        return this.aaccBalancingAmtFlag;
    }
    
    public void setAaccBalancingAmtFlag(String aaccBalancingAmtFlag) {
        this.aaccBalancingAmtFlag = aaccBalancingAmtFlag;
    }
    
    @Column(name="ASAC_SUBCLASS", length=5)

    public String getAsacSubclass() {
        return this.asacSubclass;
    }
    
    public void setAsacSubclass(String asacSubclass) {
        this.asacSubclass = asacSubclass;
    }
    
    @Column(name="AACC_WHO_LOG", nullable=false, length=15)

    public String getAaccWhoLog() {
        return this.aaccWhoLog;
    }
    
    public void setAaccWhoLog(String aaccWhoLog) {
        this.aaccWhoLog = aaccWhoLog;
    }
    
    @Column(name="AACC_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAaccWhenLog() {
        return this.aaccWhenLog;
    }
    
    public void setAaccWhenLog(Timestamp aaccWhenLog) {
        this.aaccWhenLog = aaccWhenLog;
    }
    
    @Column(name="AACC_REMARKS", length=100)

    public String getAaccRemarks() {
        return this.aaccRemarks;
    }
    
    public void setAaccRemarks(String aaccRemarks) {
        this.aaccRemarks = aaccRemarks;
    }
    
    @Column(name="AACC_JLR_REQUIRED", length=1)

    public String getAaccJlrRequired() {
        return this.aaccJlrRequired;
    }
    
    public void setAaccJlrRequired(String aaccJlrRequired) {
        this.aaccJlrRequired = aaccJlrRequired;
    }
   








}