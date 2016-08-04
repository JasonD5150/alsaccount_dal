package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * AlsNonAlsTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_NON_ALS_TEMPLATE"
    ,schema="ALS"
, uniqueConstraints = @UniqueConstraint(columnNames={"ANAT_BUDGET_YEAR", "ANAT_DESC"})
)

public class AlsNonAlsTemplate  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlsNonAlsTemplateIdPk idPk;
     private String anatDesc;
     private String anatBusinessUnit;
     private String anatDrAccount;
     private String anatCrAccount;
     private String anatFund;
     private String anatDrOrg;
     private String anatCrOrg;
     private String anatDrSubclass;
     private String anatCrSubclass;
     private Integer anatProgramYear;
     private String anatDrProjectGrant;
     private String anatCrProjectGrant;
     private Integer anatDrJournalLineRefr;
     private Integer anatCrJournalLineRefr;
     private String anatDrLineDesc;
     private String anatCrLineDesc;
     private String anatWhoLog;
     private Timestamp anatWhenLog;


    // Constructors

    /** default constructor */
    public AlsNonAlsTemplate() {
    }

	/** minimal constructor */
    public AlsNonAlsTemplate(AlsNonAlsTemplateIdPk idPk, String anatWhoLog, Timestamp anatWhenLog) {
        this.idPk = idPk;
        this.anatWhoLog = anatWhoLog;
        this.anatWhenLog = anatWhenLog;
    }
    
    /** full constructor */
    public AlsNonAlsTemplate(AlsNonAlsTemplateIdPk idPk, String anatDesc, String anatBusinessUnit, String anatDrAccount, String anatCrAccount, String anatFund, String anatDrOrg, String anatCrOrg, String anatDrSubclass, String anatCrSubclass, Integer anatProgramYear, String anatDrProjectGrant, String anatCrProjectGrant, Integer anatDrJournalLineRefr, Integer anatCrJournalLineRefr, String anatDrLineDesc, String anatCrLineDesc, String anatWhoLog, Timestamp anatWhenLog) {
        this.idPk = idPk;
        this.anatDesc = anatDesc;
        this.anatBusinessUnit = anatBusinessUnit;
        this.anatDrAccount = anatDrAccount;
        this.anatCrAccount = anatCrAccount;
        this.anatFund = anatFund;
        this.anatDrOrg = anatDrOrg;
        this.anatCrOrg = anatCrOrg;
        this.anatDrSubclass = anatDrSubclass;
        this.anatCrSubclass = anatCrSubclass;
        this.anatProgramYear = anatProgramYear;
        this.anatDrProjectGrant = anatDrProjectGrant;
        this.anatCrProjectGrant = anatCrProjectGrant;
        this.anatDrJournalLineRefr = anatDrJournalLineRefr;
        this.anatCrJournalLineRefr = anatCrJournalLineRefr;
        this.anatDrLineDesc = anatDrLineDesc;
        this.anatCrLineDesc = anatCrLineDesc;
        this.anatWhoLog = anatWhoLog;
        this.anatWhenLog = anatWhenLog;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="anatBudgetYear", column=@Column(name="ANAT_BUDGET_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="anatCd", column=@Column(name="ANAT_CD", nullable=false, length=5) ) } )

    public AlsNonAlsTemplateIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsNonAlsTemplateIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="ANAT_DESC", length=30)

    public String getAnatDesc() {
        return this.anatDesc;
    }
    
    public void setAnatDesc(String anatDesc) {
        this.anatDesc = anatDesc;
    }
    
    @Column(name="ANAT_BUSINESS_UNIT", length=5)

    public String getAnatBusinessUnit() {
        return this.anatBusinessUnit;
    }
    
    public void setAnatBusinessUnit(String anatBusinessUnit) {
        this.anatBusinessUnit = anatBusinessUnit;
    }
    
    @Column(name="ANAT_DR_ACCOUNT", length=6)

    public String getAnatDrAccount() {
        return this.anatDrAccount;
    }
    
    public void setAnatDrAccount(String anatDrAccount) {
        this.anatDrAccount = anatDrAccount;
    }
    
    @Column(name="ANAT_CR_ACCOUNT", length=6)

    public String getAnatCrAccount() {
        return this.anatCrAccount;
    }
    
    public void setAnatCrAccount(String anatCrAccount) {
        this.anatCrAccount = anatCrAccount;
    }
    
    @Column(name="ANAT_FUND", length=6)

    public String getAnatFund() {
        return this.anatFund;
    }
    
    public void setAnatFund(String anatFund) {
        this.anatFund = anatFund;
    }
    
    @Column(name="ANAT_DR_ORG", length=6)

    public String getAnatDrOrg() {
        return this.anatDrOrg;
    }
    
    public void setAnatDrOrg(String anatDrOrg) {
        this.anatDrOrg = anatDrOrg;
    }
    
    @Column(name="ANAT_CR_ORG", length=6)

    public String getAnatCrOrg() {
        return this.anatCrOrg;
    }
    
    public void setAnatCrOrg(String anatCrOrg) {
        this.anatCrOrg = anatCrOrg;
    }
    
    @Column(name="ANAT_DR_SUBCLASS", length=5)

    public String getAnatDrSubclass() {
        return this.anatDrSubclass;
    }
    
    public void setAnatDrSubclass(String anatDrSubclass) {
        this.anatDrSubclass = anatDrSubclass;
    }
    
    @Column(name="ANAT_CR_SUBCLASS", length=5)

    public String getAnatCrSubclass() {
        return this.anatCrSubclass;
    }
    
    public void setAnatCrSubclass(String anatCrSubclass) {
        this.anatCrSubclass = anatCrSubclass;
    }
    
    @Column(name="ANAT_PROGRAM_YEAR", precision=4, scale=0)

    public Integer getAnatProgramYear() {
        return this.anatProgramYear;
    }
    
    public void setAnatProgramYear(Integer anatProgramYear) {
        this.anatProgramYear = anatProgramYear;
    }
    
    @Column(name="ANAT_DR_PROJECT_GRANT", length=15)

    public String getAnatDrProjectGrant() {
        return this.anatDrProjectGrant;
    }
    
    public void setAnatDrProjectGrant(String anatDrProjectGrant) {
        this.anatDrProjectGrant = anatDrProjectGrant;
    }
    
    @Column(name="ANAT_CR_PROJECT_GRANT", length=15)

    public String getAnatCrProjectGrant() {
        return this.anatCrProjectGrant;
    }
    
    public void setAnatCrProjectGrant(String anatCrProjectGrant) {
        this.anatCrProjectGrant = anatCrProjectGrant;
    }
    
    @Column(name="ANAT_DR_JOURNAL_LINE_REFR", precision=5, scale=0)

    public Integer getAnatDrJournalLineRefr() {
        return this.anatDrJournalLineRefr;
    }
    
    public void setAnatDrJournalLineRefr(Integer anatDrJournalLineRefr) {
        this.anatDrJournalLineRefr = anatDrJournalLineRefr;
    }
    
    @Column(name="ANAT_CR_JOURNAL_LINE_REFR", precision=5, scale=0)

    public Integer getAnatCrJournalLineRefr() {
        return this.anatCrJournalLineRefr;
    }
    
    public void setAnatCrJournalLineRefr(Integer anatCrJournalLineRefr) {
        this.anatCrJournalLineRefr = anatCrJournalLineRefr;
    }
    
    @Column(name="ANAT_DR_LINE_DESC", length=30)

    public String getAnatDrLineDesc() {
        return this.anatDrLineDesc;
    }
    
    public void setAnatDrLineDesc(String anatDrLineDesc) {
        this.anatDrLineDesc = anatDrLineDesc;
    }
    
    @Column(name="ANAT_CR_LINE_DESC", length=30)

    public String getAnatCrLineDesc() {
        return this.anatCrLineDesc;
    }
    
    public void setAnatCrLineDesc(String anatCrLineDesc) {
        this.anatCrLineDesc = anatCrLineDesc;
    }
    
    @Column(name="ANAT_WHO_LOG", nullable=false, length=15)

    public String getAnatWhoLog() {
        return this.anatWhoLog;
    }
    
    public void setAnatWhoLog(String anatWhoLog) {
        this.anatWhoLog = anatWhoLog;
    }
    
    @Column(name="ANAT_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAnatWhenLog() {
        return this.anatWhenLog;
    }
    
    public void setAnatWhenLog(Timestamp anatWhenLog) {
        this.anatWhenLog = anatWhenLog;
    }
   








}