package fwp.alsaccount.hibernate.dao;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsActivityAccountLinkage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_ACTIVITY_ACCOUNT_LINKAGE"
    ,schema="ALS"
)

public class AlsActivityAccountLinkage  implements java.io.Serializable {


    // Fields    

     private AlsActivityAccountLinkageIdPk idPk;
     private String aamAccount;
     private String aaalAccountingCdFlag;
     private Integer aaalReference;
     private String aamFund;
     private String aocOrg;
     private String asacSubclass;
     private String aaalWhoLog;
     private Timestamp aaalWhenLog;


    // Constructors

    /** default constructor */
    public AlsActivityAccountLinkage() {
    }

	/** minimal constructor */
    public AlsActivityAccountLinkage(AlsActivityAccountLinkageIdPk idPk, String aaalWhoLog, Timestamp aaalWhenLog) {
        this.idPk = idPk;
        this.aaalWhoLog = aaalWhoLog;
        this.aaalWhenLog = aaalWhenLog;
    }
    
    /** full constructor */
    public AlsActivityAccountLinkage(AlsActivityAccountLinkageIdPk idPk, String aamAccount, String aaalAccountingCdFlag, Integer aaalReference, String aamFund, String aocOrg, String asacSubclass, String aaalWhoLog, Timestamp aaalWhenLog) {
        this.idPk = idPk;
        this.aamAccount = aamAccount;
        this.aaalAccountingCdFlag = aaalAccountingCdFlag;
        this.aaalReference = aaalReference;
        this.aamFund = aamFund;
        this.aocOrg = aocOrg;
        this.asacSubclass = asacSubclass;
        this.aaalWhoLog = aaalWhoLog;
        this.aaalWhenLog = aaalWhenLog;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="asacBudgetYear", column=@Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="asacSystemActivityTypeCd", column=@Column(name="ASAC_SYSTEM_ACTIVITY_TYPE_CD", nullable=false, length=1) ), 
        @AttributeOverride(name="asacTxnCd", column=@Column(name="ASAC_TXN_CD", nullable=false, length=3) ), 
        @AttributeOverride(name="aaalDrCrCd", column=@Column(name="AAAL_DR_CR_CD", nullable=false, length=1) ) } )

    public AlsActivityAccountLinkageIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsActivityAccountLinkageIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="AAM_ACCOUNT", length=6)

    public String getAamAccount() {
        return this.aamAccount;
    }
    
    public void setAamAccount(String aamAccount) {
        this.aamAccount = aamAccount;
    }
    
    @Column(name="AAAL_ACCOUNTING_CD_FLAG", length=1)

    public String getAaalAccountingCdFlag() {
        return this.aaalAccountingCdFlag;
    }
    
    public void setAaalAccountingCdFlag(String aaalAccountingCdFlag) {
        this.aaalAccountingCdFlag = aaalAccountingCdFlag;
    }
    
    @Column(name="AAAL_REFERENCE", precision=5, scale=0)

    public Integer getAaalReference() {
        return this.aaalReference;
    }
    
    public void setAaalReference(Integer aaalReference) {
        this.aaalReference = aaalReference;
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
    
    @Column(name="ASAC_SUBCLASS", length=5)

    public String getAsacSubclass() {
        return this.asacSubclass;
    }
    
    public void setAsacSubclass(String asacSubclass) {
        this.asacSubclass = asacSubclass;
    }
    
    @Column(name="AAAL_WHO_LOG", nullable=false, length=15)

    public String getAaalWhoLog() {
        return this.aaalWhoLog;
    }
    
    public void setAaalWhoLog(String aaalWhoLog) {
        this.aaalWhoLog = aaalWhoLog;
    }
    
    @Column(name="AAAL_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAaalWhenLog() {
        return this.aaalWhenLog;
    }
    
    public void setAaalWhenLog(Timestamp aaalWhenLog) {
        this.aaalWhenLog = aaalWhenLog;
    }
   








}