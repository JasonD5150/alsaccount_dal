package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * AlsNonAlsOrgControl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_NON_ALS_ORG_CONTROL"
    ,schema="ALS"
, uniqueConstraints = @UniqueConstraint(columnNames={"ANAT_BUDGET_YEAR", "ANAT_CD", "ANAOC_CR_DR_CD", "API_PROVIDER_NO"})
)

public class AlsNonAlsOrgControl  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer anaocId;
     private String anatCd;
     private String anaocCrDrCd;
     private String anaocOrg;
     private Integer apiProviderNo;
     private String anaocWhoLog;
     private Timestamp anaocWhenLog;
     private Integer anatBudgetYear;


    // Constructors

    /** default constructor */
    public AlsNonAlsOrgControl() {
    }

	/** minimal constructor */
    public AlsNonAlsOrgControl(Integer anaocId, String anatCd, String anaocCrDrCd, String anaocOrg, String anaocWhoLog, Integer anatBudgetYear) {
        this.anaocId = anaocId;
        this.anatCd = anatCd;
        this.anaocCrDrCd = anaocCrDrCd;
        this.anaocOrg = anaocOrg;
        this.anaocWhoLog = anaocWhoLog;
        this.anatBudgetYear = anatBudgetYear;
    }
    
    /** full constructor */
    public AlsNonAlsOrgControl(Integer anaocId, String anatCd, String anaocCrDrCd, String anaocOrg, Integer apiProviderNo, String anaocWhoLog, Timestamp anaocWhenLog, Integer anatBudgetYear) {
        this.anaocId = anaocId;
        this.anatCd = anatCd;
        this.anaocCrDrCd = anaocCrDrCd;
        this.anaocOrg = anaocOrg;
        this.apiProviderNo = apiProviderNo;
        this.anaocWhoLog = anaocWhoLog;
        this.anaocWhenLog = anaocWhenLog;
        this.anatBudgetYear = anatBudgetYear;
    }

   
    // Property accessors
    @Id 
    @Column(name="ANAOC_ID",unique=true, nullable = false)

    public Integer getAnaocId() {
        return this.anaocId;
    }
    
    public void setAnaocId(Integer anaocId) {
        this.anaocId = anaocId;
    }
    
    @Column(name="ANAT_CD", nullable=false, length=5)

    public String getAnatCd() {
        return this.anatCd;
    }
    
    public void setAnatCd(String anatCd) {
        this.anatCd = anatCd;
    }
    
    @Column(name="ANAOC_CR_DR_CD", nullable=false, length=1)

    public String getAnaocCrDrCd() {
        return this.anaocCrDrCd;
    }
    
    public void setAnaocCrDrCd(String anaocCrDrCd) {
        this.anaocCrDrCd = anaocCrDrCd;
    }
    
    @Column(name="ANAOC_ORG", nullable=false, length=6)

    public String getAnaocOrg() {
        return this.anaocOrg;
    }
    
    public void setAnaocOrg(String anaocOrg) {
        this.anaocOrg = anaocOrg;
    }
    
    @Column(name="API_PROVIDER_NO", precision=10, scale=0)

    public Integer getApiProviderNo() {
        return this.apiProviderNo;
    }
    
    public void setApiProviderNo(Integer apiProviderNo) {
        this.apiProviderNo = apiProviderNo;
    }
    
    @Column(name="ANAOC_WHO_LOG", nullable=false, length=15)

    public String getAnaocWhoLog() {
        return this.anaocWhoLog;
    }
    
    public void setAnaocWhoLog(String anaocWhoLog) {
        this.anaocWhoLog = anaocWhoLog;
    }
    
    @Column(name="ANAOC_WHEN_LOG", length=7)

    public Timestamp getAnaocWhenLog() {
        return this.anaocWhenLog;
    }
    
    public void setAnaocWhenLog(Timestamp anaocWhenLog) {
        this.anaocWhenLog = anaocWhenLog;
    }
    
    @Column(name="ANAT_BUDGET_YEAR", nullable=false, precision=4, scale=0)

    public Integer getAnatBudgetYear() {
        return this.anatBudgetYear;
    }
    
    public void setAnatBudgetYear(Integer anatBudgetYear) {
        this.anatBudgetYear = anatBudgetYear;
    }
   








}