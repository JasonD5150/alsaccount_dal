package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsOverUnderSalesDets entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_OVER_UNDER_SALES_DETS"
    ,schema="ALS"
)

public class AlsOverUnderSalesDets  implements java.io.Serializable {


    // Fields    

     private AlsOverUnderSalesDetsIdPk idPk;
     private String aousdFlag;
     private String aousdDesc;
     private Double aousdAmount;
     private String aousdWhoLog;
     private Timestamp aousdWhenLog;
     private String aousdCreatePersonid;
     private String aousdCreateDbusers;
     private Timestamp aousdCreateDate;
     private String aousdLastModPersonid;
     private String aousdLastModDbusers;
     private Timestamp aousdLastModDate;


    // Constructors

    /** default constructor */
    public AlsOverUnderSalesDets() {
    }

	/** minimal constructor */
    public AlsOverUnderSalesDets(AlsOverUnderSalesDetsIdPk idPk, String aousdWhoLog, Timestamp aousdWhenLog) {
        this.idPk = idPk;
        this.aousdWhoLog = aousdWhoLog;
        this.aousdWhenLog = aousdWhenLog;
    }
    
    /** full constructor */
    public AlsOverUnderSalesDets(AlsOverUnderSalesDetsIdPk idPk, String aousdFlag, String aousdDesc, Double aousdAmount, String aousdWhoLog, Timestamp aousdWhenLog, String aousdCreatePersonid, String aousdCreateDbusers, Timestamp aousdCreateDate, String aousdLastModPersonid, String aousdLastModDbusers, Timestamp aousdLastModDate) {
        this.idPk = idPk;
        this.aousdFlag = aousdFlag;
        this.aousdDesc = aousdDesc;
        this.aousdAmount = aousdAmount;
        this.aousdWhoLog = aousdWhoLog;
        this.aousdWhenLog = aousdWhenLog;
        this.aousdCreatePersonid = aousdCreatePersonid;
        this.aousdCreateDbusers = aousdCreateDbusers;
        this.aousdCreateDate = aousdCreateDate;
        this.aousdLastModPersonid = aousdLastModPersonid;
        this.aousdLastModDbusers = aousdLastModDbusers;
        this.aousdLastModDate = aousdLastModDate;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="apiProviderNo", column=@Column(name="API_PROVIDER_NO", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="airBillingFrom", column=@Column(name="AIR_BILLING_FROM", nullable=false, length=7) ), 
        @AttributeOverride(name="airBillingTo", column=@Column(name="AIR_BILLING_TO", nullable=false, length=7) ), 
        @AttributeOverride(name="aousdSeqNo", column=@Column(name="AOUSD_SEQ_NO", nullable=false, precision=9, scale=0) ) } )

    public AlsOverUnderSalesDetsIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsOverUnderSalesDetsIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="AOUSD_FLAG", length=1)

    public String getAousdFlag() {
        return this.aousdFlag;
    }
    
    public void setAousdFlag(String aousdFlag) {
        this.aousdFlag = aousdFlag;
    }
    
    @Column(name="AOUSD_DESC", length=50)

    public String getAousdDesc() {
        return this.aousdDesc;
    }
    
    public void setAousdDesc(String aousdDesc) {
        this.aousdDesc = aousdDesc;
    }
    
    @Column(name="AOUSD_AMOUNT", precision=9)

    public Double getAousdAmount() {
        return this.aousdAmount;
    }
    
    public void setAousdAmount(Double aousdAmount) {
        this.aousdAmount = aousdAmount;
    }
    
    @Column(name="AOUSD_WHO_LOG", nullable=false, length=15)

    public String getAousdWhoLog() {
        return this.aousdWhoLog;
    }
    
    public void setAousdWhoLog(String aousdWhoLog) {
        this.aousdWhoLog = aousdWhoLog;
    }
    
    @Column(name="AOUSD_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAousdWhenLog() {
        return this.aousdWhenLog;
    }
    
    public void setAousdWhenLog(Timestamp aousdWhenLog) {
        this.aousdWhenLog = aousdWhenLog;
    }
    
    @Column(name="AOUSD_CREATE_PERSONID", length=50)

    public String getAousdCreatePersonid() {
        return this.aousdCreatePersonid;
    }
    
    public void setAousdCreatePersonid(String aousdCreatePersonid) {
        this.aousdCreatePersonid = aousdCreatePersonid;
    }
    
    @Column(name="AOUSD_CREATE_DBUSERS", length=50)

    public String getAousdCreateDbusers() {
        return this.aousdCreateDbusers;
    }
    
    public void setAousdCreateDbusers(String aousdCreateDbusers) {
        this.aousdCreateDbusers = aousdCreateDbusers;
    }
    
    @Column(name="AOUSD_CREATE_DATE", length=7)

    public Timestamp getAousdCreateDate() {
        return this.aousdCreateDate;
    }
    
    public void setAousdCreateDate(Timestamp aousdCreateDate) {
        this.aousdCreateDate = aousdCreateDate;
    }
    
    @Column(name="AOUSD_LAST_MOD_PERSONID", length=50)

    public String getAousdLastModPersonid() {
        return this.aousdLastModPersonid;
    }
    
    public void setAousdLastModPersonid(String aousdLastModPersonid) {
        this.aousdLastModPersonid = aousdLastModPersonid;
    }
    
    @Column(name="AOUSD_LAST_MOD_DBUSERS", length=50)

    public String getAousdLastModDbusers() {
        return this.aousdLastModDbusers;
    }
    
    public void setAousdLastModDbusers(String aousdLastModDbusers) {
        this.aousdLastModDbusers = aousdLastModDbusers;
    }
    
    @Column(name="AOUSD_LAST_MOD_DATE", length=7)

    public Timestamp getAousdLastModDate() {
        return this.aousdLastModDate;
    }
    
    public void setAousdLastModDate(Timestamp aousdLastModDate) {
        this.aousdLastModDate = aousdLastModDate;
    }
   








}