package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsOrgControl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_ORG_CONTROL"
    ,schema="ALS"
)

public class AlsOrgControl  implements java.io.Serializable {


    // Fields    

     private AlsOrgControlIdPk idPk;
     private String aocOrg;
     private String aocWhoLog;
     private Timestamp aocWhenLog;


    // Constructors

    /** default constructor */
    public AlsOrgControl() {
    }

    
    /** full constructor */
    public AlsOrgControl(AlsOrgControlIdPk idPk, String aocOrg, String aocWhoLog, Timestamp aocWhenLog) {
        this.idPk = idPk;
        this.aocOrg = aocOrg;
        this.aocWhoLog = aocWhoLog;
        this.aocWhenLog = aocWhenLog;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="asacBudgetYear", column=@Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="aaccAccCd", column=@Column(name="AACC_ACC_CD", nullable=false, length=3) ), 
        @AttributeOverride(name="apiProviderNo", column=@Column(name="API_PROVIDER_NO", nullable=false, precision=10, scale=0) ) } )

    public AlsOrgControlIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsOrgControlIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="AOC_ORG", nullable=false, length=6)

    public String getAocOrg() {
        return this.aocOrg;
    }
    
    public void setAocOrg(String aocOrg) {
        this.aocOrg = aocOrg;
    }
    
    @Column(name="AOC_WHO_LOG", nullable=false, length=15)

    public String getAocWhoLog() {
        return this.aocWhoLog;
    }
    
    public void setAocWhoLog(String aocWhoLog) {
        this.aocWhoLog = aocWhoLog;
    }
    
    @Column(name="AOC_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAocWhenLog() {
        return this.aocWhenLog;
    }
    
    public void setAocWhenLog(Timestamp aocWhenLog) {
        this.aocWhenLog = aocWhenLog;
    }
   








}