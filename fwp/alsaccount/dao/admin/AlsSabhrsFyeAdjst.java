package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * AlsSabhrsFyeAdjst entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_SABHRS_FYE_ADJST"
    ,schema="ALS"
)

public class AlsSabhrsFyeAdjst  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer asfaBudgetYear;
     private String asfaFyeGroupIdentifier;
     private String asfaNfyGroupIdentifier;
     private Timestamp asfaFyEndDt;
     private Timestamp asfaFyBegDt;
     private Timestamp asfaBillPrdEndDt;


    // Constructors

    /** default constructor */
    public AlsSabhrsFyeAdjst() {
    }

	/** minimal constructor */
    public AlsSabhrsFyeAdjst(Integer asfaBudgetYear, Timestamp asfaFyEndDt, Timestamp asfaFyBegDt, Timestamp asfaBillPrdEndDt) {
        this.asfaBudgetYear = asfaBudgetYear;
        this.asfaFyEndDt = asfaFyEndDt;
        this.asfaFyBegDt = asfaFyBegDt;
        this.asfaBillPrdEndDt = asfaBillPrdEndDt;
    }
    
    /** full constructor */
    public AlsSabhrsFyeAdjst(Integer asfaBudgetYear, String asfaFyeGroupIdentifier, String asfaNfyGroupIdentifier, Timestamp asfaFyEndDt, Timestamp asfaFyBegDt, Timestamp asfaBillPrdEndDt) {
        this.asfaBudgetYear = asfaBudgetYear;
        this.asfaFyeGroupIdentifier = asfaFyeGroupIdentifier;
        this.asfaNfyGroupIdentifier = asfaNfyGroupIdentifier;
        this.asfaFyEndDt = asfaFyEndDt;
        this.asfaFyBegDt = asfaFyBegDt;
        this.asfaBillPrdEndDt = asfaBillPrdEndDt;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="ASFA_BUDGET_YEAR", unique=true, nullable=false, precision=4, scale=0)

    public Integer getAsfaBudgetYear() {
        return this.asfaBudgetYear;
    }
    
    public void setAsfaBudgetYear(Integer asfaBudgetYear) {
        this.asfaBudgetYear = asfaBudgetYear;
    }
    
    @Column(name="ASFA_FYE_GROUP_IDENTIFIER", length=50)

    public String getAsfaFyeGroupIdentifier() {
        return this.asfaFyeGroupIdentifier;
    }
    
    public void setAsfaFyeGroupIdentifier(String asfaFyeGroupIdentifier) {
        this.asfaFyeGroupIdentifier = asfaFyeGroupIdentifier;
    }
    
    @Column(name="ASFA_NFY_GROUP_IDENTIFIER", length=50)

    public String getAsfaNfyGroupIdentifier() {
        return this.asfaNfyGroupIdentifier;
    }
    
    public void setAsfaNfyGroupIdentifier(String asfaNfyGroupIdentifier) {
        this.asfaNfyGroupIdentifier = asfaNfyGroupIdentifier;
    }
    
    @Column(name="ASFA_FY_END_DT", nullable=false, length=7)

    public Timestamp getAsfaFyEndDt() {
        return this.asfaFyEndDt;
    }
    
    public void setAsfaFyEndDt(Timestamp asfaFyEndDt) {
        this.asfaFyEndDt = asfaFyEndDt;
    }
    
    @Column(name="ASFA_FY_BEG_DT", nullable=false, length=7)

    public Timestamp getAsfaFyBegDt() {
        return this.asfaFyBegDt;
    }
    
    public void setAsfaFyBegDt(Timestamp asfaFyBegDt) {
        this.asfaFyBegDt = asfaFyBegDt;
    }
    
    @Column(name="ASFA_BILL_PRD_END_DT", nullable=false, length=7)

    public Timestamp getAsfaBillPrdEndDt() {
        return this.asfaBillPrdEndDt;
    }
    
    public void setAsfaBillPrdEndDt(Timestamp asfaBillPrdEndDt) {
        this.asfaBillPrdEndDt = asfaBillPrdEndDt;
    }
   








}