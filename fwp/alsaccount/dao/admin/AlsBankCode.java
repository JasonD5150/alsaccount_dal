package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * AlsBankCode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_BANK_CODE"
    ,schema="ALS"
)

public class AlsBankCode  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String abcBankCd;
     private String abcAccountNo;
     private String abcCompanyId;
     private String abcBankNm;
     private String azcZipCd;
     private String azcCityNm;
     private String abcWhoLog;
     private Timestamp abcWhenLog;
     private String abcCreatePersonid;
     private String abcActive;
     private String abcAvblToAllProv;


    // Constructors

    /** default constructor */
    public AlsBankCode() {
    }

	/** minimal constructor */
    public AlsBankCode(String abcBankCd, String abcAccountNo, String abcBankNm, String azcZipCd, String azcCityNm, String abcWhoLog, Timestamp abcWhenLog, String abcActive) {
        this.abcBankCd = abcBankCd;
        this.abcAccountNo = abcAccountNo;
        this.abcBankNm = abcBankNm;
        this.azcZipCd = azcZipCd;
        this.azcCityNm = azcCityNm;
        this.abcWhoLog = abcWhoLog;
        this.abcWhenLog = abcWhenLog;
        this.abcActive = abcActive;
    }
    
    /** full constructor */
    public AlsBankCode(String abcBankCd, String abcAccountNo, String abcCompanyId, String abcBankNm, String azcZipCd, String azcCityNm, String abcWhoLog, Timestamp abcWhenLog, String abcCreatePersonid, String abcActive, String abcAvblToAllProv) {
        this.abcBankCd = abcBankCd;
        this.abcAccountNo = abcAccountNo;
        this.abcCompanyId = abcCompanyId;
        this.abcBankNm = abcBankNm;
        this.azcZipCd = azcZipCd;
        this.azcCityNm = azcCityNm;
        this.abcWhoLog = abcWhoLog;
        this.abcWhenLog = abcWhenLog;
        this.abcCreatePersonid = abcCreatePersonid;
        this.abcActive = abcActive;
        this.abcAvblToAllProv = abcAvblToAllProv;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="ABC_BANK_CD", unique=true, nullable=false, length=3)

    public String getAbcBankCd() {
        return this.abcBankCd;
    }
    
    public void setAbcBankCd(String abcBankCd) {
        this.abcBankCd = abcBankCd;
    }
    
    @Column(name="ABC_ACCOUNT_NO", nullable=false, length=17)

    public String getAbcAccountNo() {
        return this.abcAccountNo;
    }
    
    public void setAbcAccountNo(String abcAccountNo) {
        this.abcAccountNo = abcAccountNo;
    }
    
    @Column(name="ABC_COMPANY_ID", length=10)

    public String getAbcCompanyId() {
        return this.abcCompanyId;
    }
    
    public void setAbcCompanyId(String abcCompanyId) {
        this.abcCompanyId = abcCompanyId;
    }
    
    @Column(name="ABC_BANK_NM", nullable=false, length=25)

    public String getAbcBankNm() {
        return this.abcBankNm;
    }
    
    public void setAbcBankNm(String abcBankNm) {
        this.abcBankNm = abcBankNm;
    }
    
    @Column(name="AZC_ZIP_CD", nullable=false, length=5)

    public String getAzcZipCd() {
        return this.azcZipCd;
    }
    
    public void setAzcZipCd(String azcZipCd) {
        this.azcZipCd = azcZipCd;
    }
    
    @Column(name="AZC_CITY_NM", nullable=false, length=28)

    public String getAzcCityNm() {
        return this.azcCityNm;
    }
    
    public void setAzcCityNm(String azcCityNm) {
        this.azcCityNm = azcCityNm;
    }
    
    @Column(name="ABC_WHO_LOG", nullable=false, length=15)

    public String getAbcWhoLog() {
        return this.abcWhoLog;
    }
    
    public void setAbcWhoLog(String abcWhoLog) {
        this.abcWhoLog = abcWhoLog;
    }
    
    @Column(name="ABC_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAbcWhenLog() {
        return this.abcWhenLog;
    }
    
    public void setAbcWhenLog(Timestamp abcWhenLog) {
        this.abcWhenLog = abcWhenLog;
    }
    
    @Column(name="ABC_CREATE_PERSONID", length=50)

    public String getAbcCreatePersonid() {
        return this.abcCreatePersonid;
    }
    
    public void setAbcCreatePersonid(String abcCreatePersonid) {
        this.abcCreatePersonid = abcCreatePersonid;
    }
    
    @Column(name="ABC_ACTIVE", nullable=false, length=1)

    public String getAbcActive() {
        return this.abcActive;
    }
    
    public void setAbcActive(String abcActive) {
        this.abcActive = abcActive;
    }
    
    @Column(name="ABC_AVBL_TO_ALL_PROV", length=1)

    public String getAbcAvblToAllProv() {
        return this.abcAvblToAllProv;
    }
    
    public void setAbcAvblToAllProv(String abcAvblToAllProv) {
        this.abcAvblToAllProv = abcAvblToAllProv;
    }
   








}