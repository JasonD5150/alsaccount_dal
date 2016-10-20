package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * AlsProviderBankDepositSlip entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_PROVIDER_BANK_DEPOSIT_SLIP"
    ,schema="ALS"
)

public class AlsProviderBankDepositSlip  implements java.io.Serializable {


    // Fields    

     private Integer apbdsId;
     private Integer apiProviderNo;
     private Timestamp apbdBillingTo;
     private Integer apbdSeqNo;
     private String apbdsFileName;
     private String apbdsFileType;
     private byte[] apbdsData;
     private Timestamp apbdsCreateDate;
     private String apbdsCreateDbuser;
     private Integer apbdsCreatePersonId;
     private Timestamp apbdsModDate;
     private String apbdsModDbuser;
     private Integer apbdsModPersonid;


    // Constructors

    /** default constructor */
    public AlsProviderBankDepositSlip() {
    }

	/** minimal constructor */
    public AlsProviderBankDepositSlip(Integer apbdsId, Integer apiProviderNo, Timestamp apbdBillingTo, Integer apbdSeqNo, String apbdsFileName, String apbdsFileType, byte[] apbdsData, Timestamp apbdsCreateDate, String apbdsCreateDbuser, Integer apbdsCreatePersonId) {
        this.apbdsId = apbdsId;
        this.apiProviderNo = apiProviderNo;
        this.apbdBillingTo = apbdBillingTo;
        this.apbdSeqNo = apbdSeqNo;
        this.apbdsFileName = apbdsFileName;
        this.apbdsFileType = apbdsFileType;
        this.apbdsData = apbdsData;
        this.apbdsCreateDate = apbdsCreateDate;
        this.apbdsCreateDbuser = apbdsCreateDbuser;
        this.apbdsCreatePersonId = apbdsCreatePersonId;
    }
    
    /** full constructor */
    public AlsProviderBankDepositSlip(Integer apbdsId, Integer apiProviderNo, Timestamp apbdBillingTo, Integer apbdSeqNo, String apbdsFileName, String apbdsFileType, byte[] apbdsData, Timestamp apbdsCreateDate, String apbdsCreateDbuser, Integer apbdsCreatePersonId, Timestamp apbdsModDate, String apbdsModDbuser, Integer apbdsModPersonid) {
        this.apbdsId = apbdsId;
        this.apiProviderNo = apiProviderNo;
        this.apbdBillingTo = apbdBillingTo;
        this.apbdSeqNo = apbdSeqNo;
        this.apbdsFileName = apbdsFileName;
        this.apbdsFileType = apbdsFileType;
        this.apbdsData = apbdsData;
        this.apbdsCreateDate = apbdsCreateDate;
        this.apbdsCreateDbuser = apbdsCreateDbuser;
        this.apbdsCreatePersonId = apbdsCreatePersonId;
        this.apbdsModDate = apbdsModDate;
        this.apbdsModDbuser = apbdsModDbuser;
        this.apbdsModPersonid = apbdsModPersonid;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="APBDS_ID", unique=true, nullable=false, precision=10, scale=0)

    public Integer getApbdsId() {
        return this.apbdsId;
    }
    
    public void setApbdsId(Integer apbdsId) {
        this.apbdsId = apbdsId;
    }
    
    @Column(name="API_PROVIDER_NO", nullable=false, precision=10, scale=0)

    public Integer getApiProviderNo() {
        return this.apiProviderNo;
    }
    
    public void setApiProviderNo(Integer apiProviderNo) {
        this.apiProviderNo = apiProviderNo;
    }
    
    @Column(name="APBD_BILLING_TO", nullable=false, length=7)

    public Timestamp getApbdBillingTo() {
        return this.apbdBillingTo;
    }
    
    public void setApbdBillingTo(Timestamp apbdBillingTo) {
        this.apbdBillingTo = apbdBillingTo;
    }
    
    @Column(name="APBD_SEQ_NO", nullable=false, precision=2, scale=0)

    public Integer getApbdSeqNo() {
        return this.apbdSeqNo;
    }
    
    public void setApbdSeqNo(Integer apbdSeqNo) {
        this.apbdSeqNo = apbdSeqNo;
    }
    
    @Column(name="APBDS_FILE_NAME", nullable=false, length=100)

    public String getApbdsFileName() {
        return this.apbdsFileName;
    }
    
    public void setApbdsFileName(String apbdsFileName) {
        this.apbdsFileName = apbdsFileName;
    }
    
    @Column(name="APBDS_FILE_TYPE", nullable=false, length=100)

    public String getApbdsFileType() {
        return this.apbdsFileType;
    }
    
    public void setApbdsFileType(String apbdsFileType) {
        this.apbdsFileType = apbdsFileType;
    }
    @Lob
    @Column(name="APBDS_DATA", nullable=false)

    public byte[] getApbdsData() {
        return this.apbdsData;
    }
    
    public void setApbdsData(byte[] apbdsData) {
        this.apbdsData = apbdsData;
    }
    
    @Column(name="APBDS_CREATE_DATE", nullable=false, length=7)

    public Timestamp getApbdsCreateDate() {
        return this.apbdsCreateDate;
    }
    
    public void setApbdsCreateDate(Timestamp apbdsCreateDate) {
        this.apbdsCreateDate = apbdsCreateDate;
    }
    
    @Column(name="APBDS_CREATE_DBUSER", nullable=false, length=30)

    public String getApbdsCreateDbuser() {
        return this.apbdsCreateDbuser;
    }
    
    public void setApbdsCreateDbuser(String apbdsCreateDbuser) {
        this.apbdsCreateDbuser = apbdsCreateDbuser;
    }
    
    @Column(name="APBDS_CREATE_PERSON_ID", nullable=false, precision=10, scale=0)

    public Integer getApbdsCreatePersonId() {
        return this.apbdsCreatePersonId;
    }
    
    public void setApbdsCreatePersonId(Integer apbdsCreatePersonId) {
        this.apbdsCreatePersonId = apbdsCreatePersonId;
    }
    
    @Column(name="APBDS_MOD_DATE", length=7)

    public Timestamp getApbdsModDate() {
        return this.apbdsModDate;
    }
    
    public void setApbdsModDate(Timestamp apbdsModDate) {
        this.apbdsModDate = apbdsModDate;
    }
    
    @Column(name="APBDS_MOD_DBUSER", length=30)

    public String getApbdsModDbuser() {
        return this.apbdsModDbuser;
    }
    
    public void setApbdsModDbuser(String apbdsModDbuser) {
        this.apbdsModDbuser = apbdsModDbuser;
    }
    
    @Column(name="APBDS_MOD_PERSONID", precision=10, scale=0)

    public Integer getApbdsModPersonid() {
        return this.apbdsModPersonid;
    }
    
    public void setApbdsModPersonid(Integer apbdsModPersonid) {
        this.apbdsModPersonid = apbdsModPersonid;
    }
   








}