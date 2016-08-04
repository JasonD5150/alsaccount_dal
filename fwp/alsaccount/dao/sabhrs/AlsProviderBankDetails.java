package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * sabhrsAlsProviderBankDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_PROVIDER_BANK_DETAILS"
    ,schema="ALS"
)

public class AlsProviderBankDetails  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlsProviderBankDetailsIdPk idPk;
     private String abcBankCd;
     private Double apbdAmountDeposit;
     private Timestamp apbdDepositDate;
     private String apbdDepositId;
     private String atgsGroupIdentifier;
     private String apbdWhoLog;
     private Timestamp apbdWhenLog;
     private Integer atgTransactionCd;
     private Timestamp apbdBillingFrom;
     private Timestamp createDate;
     private String createDbuser;
     private Integer createPersonid;
     private Timestamp modDate;
     private String modDbuser;
     private Integer modPersonid;


    // Constructors

    /** default constructor */
    public AlsProviderBankDetails() {
    }

	/** minimal constructor */
    public AlsProviderBankDetails(AlsProviderBankDetailsIdPk idPk, String abcBankCd, Double apbdAmountDeposit, Timestamp apbdDepositDate, String apbdWhoLog, Timestamp apbdWhenLog, Timestamp createDate, String createDbuser) {
        this.idPk = idPk;
        this.abcBankCd = abcBankCd;
        this.apbdAmountDeposit = apbdAmountDeposit;
        this.apbdDepositDate = apbdDepositDate;
        this.apbdWhoLog = apbdWhoLog;
        this.apbdWhenLog = apbdWhenLog;
        this.createDate = createDate;
        this.createDbuser = createDbuser;
    }
    
    /** full constructor */
    public AlsProviderBankDetails(AlsProviderBankDetailsIdPk idPk, String abcBankCd, Double apbdAmountDeposit, Timestamp apbdDepositDate, String apbdDepositId, String atgsGroupIdentifier, String apbdWhoLog, Timestamp apbdWhenLog, Integer atgTransactionCd, Timestamp apbdBillingFrom, Timestamp createDate, String createDbuser, Integer createPersonid, Timestamp modDate, String modDbuser, Integer modPersonid) {
        this.idPk = idPk;
        this.abcBankCd = abcBankCd;
        this.apbdAmountDeposit = apbdAmountDeposit;
        this.apbdDepositDate = apbdDepositDate;
        this.apbdDepositId = apbdDepositId;
        this.atgsGroupIdentifier = atgsGroupIdentifier;
        this.apbdWhoLog = apbdWhoLog;
        this.apbdWhenLog = apbdWhenLog;
        this.atgTransactionCd = atgTransactionCd;
        this.apbdBillingFrom = apbdBillingFrom;
        this.createDate = createDate;
        this.createDbuser = createDbuser;
        this.createPersonid = createPersonid;
        this.modDate = modDate;
        this.modDbuser = modDbuser;
        this.modPersonid = modPersonid;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="apiProviderNo", column=@Column(name="API_PROVIDER_NO", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="apbdBillingTo", column=@Column(name="APBD_BILLING_TO", nullable=false, length=7) ), 
        @AttributeOverride(name="apbdSeqNo", column=@Column(name="APBD_SEQ_NO", nullable=false, precision=2, scale=0) ) } )

    public AlsProviderBankDetailsIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsProviderBankDetailsIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="ABC_BANK_CD", nullable=false, length=3)

    public String getAbcBankCd() {
        return this.abcBankCd;
    }
    
    public void setAbcBankCd(String abcBankCd) {
        this.abcBankCd = abcBankCd;
    }
    
    @Column(name="APBD_AMOUNT_DEPOSIT", nullable=false, precision=12)

    public Double getApbdAmountDeposit() {
        return this.apbdAmountDeposit;
    }
    
    public void setApbdAmountDeposit(Double apbdAmountDeposit) {
        this.apbdAmountDeposit = apbdAmountDeposit;
    }
    
    @Column(name="APBD_DEPOSIT_DATE", nullable=false, length=7)

    public Timestamp getApbdDepositDate() {
        return this.apbdDepositDate;
    }
    
    public void setApbdDepositDate(Timestamp apbdDepositDate) {
        this.apbdDepositDate = apbdDepositDate;
    }
    
    @Column(name="APBD_DEPOSIT_ID", length=15)

    public String getApbdDepositId() {
        return this.apbdDepositId;
    }
    
    public void setApbdDepositId(String apbdDepositId) {
        this.apbdDepositId = apbdDepositId;
    }
    
    @Column(name="ATGS_GROUP_IDENTIFIER", length=50)

    public String getAtgsGroupIdentifier() {
        return this.atgsGroupIdentifier;
    }
    
    public void setAtgsGroupIdentifier(String atgsGroupIdentifier) {
        this.atgsGroupIdentifier = atgsGroupIdentifier;
    }
    
    @Column(name="APBD_WHO_LOG", nullable=false, length=15)

    public String getApbdWhoLog() {
        return this.apbdWhoLog;
    }
    
    public void setApbdWhoLog(String apbdWhoLog) {
        this.apbdWhoLog = apbdWhoLog;
    }
    
    @Column(name="APBD_WHEN_LOG", nullable=false, length=7)

    public Timestamp getApbdWhenLog() {
        return this.apbdWhenLog;
    }
    
    public void setApbdWhenLog(Timestamp apbdWhenLog) {
        this.apbdWhenLog = apbdWhenLog;
    }
    
    @Column(name="ATG_TRANSACTION_CD", precision=5, scale=0)

    public Integer getAtgTransactionCd() {
        return this.atgTransactionCd;
    }
    
    public void setAtgTransactionCd(Integer atgTransactionCd) {
        this.atgTransactionCd = atgTransactionCd;
    }
    
    @Column(name="APBD_BILLING_FROM", length=7)

    public Timestamp getApbdBillingFrom() {
        return this.apbdBillingFrom;
    }
    
    public void setApbdBillingFrom(Timestamp apbdBillingFrom) {
        this.apbdBillingFrom = apbdBillingFrom;
    }
    
    @Column(name="CREATE_DATE", nullable=false, length=7)

    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    @Column(name="CREATE_DBUSER", nullable=false, length=30)

    public String getCreateDbuser() {
        return this.createDbuser;
    }
    
    public void setCreateDbuser(String createDbuser) {
        this.createDbuser = createDbuser;
    }
    
    @Column(name="CREATE_PERSONID", precision=10, scale=0)

    public Integer getCreatePersonid() {
        return this.createPersonid;
    }
    
    public void setCreatePersonid(Integer createPersonid) {
        this.createPersonid = createPersonid;
    }
    
    @Column(name="MOD_DATE", length=7)

    public Timestamp getModDate() {
        return this.modDate;
    }
    
    public void setModDate(Timestamp modDate) {
        this.modDate = modDate;
    }
    
    @Column(name="MOD_DBUSER", length=30)

    public String getModDbuser() {
        return this.modDbuser;
    }
    
    public void setModDbuser(String modDbuser) {
        this.modDbuser = modDbuser;
    }
    
    @Column(name="MOD_PERSONID", precision=10, scale=0)

    public Integer getModPersonid() {
        return this.modPersonid;
    }
    
    public void setModPersonid(Integer modPersonid) {
        this.modPersonid = modPersonid;
    }
   








}