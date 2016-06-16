package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsAccountMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_ACCOUNT_MASTER"
    ,schema="ALS"
)

public class AlsAccountMaster  implements java.io.Serializable {


    // Fields    

	 private static final long serialVersionUID = -8320399904452311425L;
	 private AlsAccountMasterIdPk idPk;
     private String aamAccountDesc;
     private String aamWhoLog;
     private Timestamp aamWhenLog;


    // Constructors

    /** default constructor */
    public AlsAccountMaster() {
    }

	/** minimal constructor */
    public AlsAccountMaster(AlsAccountMasterIdPk idPk, String aamWhoLog, Timestamp aamWhenLog) {
        this.idPk = idPk;
        this.aamWhoLog = aamWhoLog;
        this.aamWhenLog = aamWhenLog;
    }
    
    /** full constructor */
    public AlsAccountMaster(AlsAccountMasterIdPk idPk, String aamAccountDesc, String aamWhoLog, Timestamp aamWhenLog) {
        this.idPk = idPk;
        this.aamAccountDesc = aamAccountDesc;
        this.aamWhoLog = aamWhoLog;
        this.aamWhenLog = aamWhenLog;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="asacBudgetYear", column=@Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="aamAccount", column=@Column(name="AAM_ACCOUNT", nullable=false, length=6) ) } )

    public AlsAccountMasterIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsAccountMasterIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="AAM_ACCOUNT_DESC", length=200)

    public String getAamAccountDesc() {
        return this.aamAccountDesc;
    }
    
    public void setAamAccountDesc(String aamAccountDesc) {
        this.aamAccountDesc = aamAccountDesc;
    }
    
    @Column(name="AAM_WHO_LOG", nullable=false, length=15)

    public String getAamWhoLog() {
        return this.aamWhoLog;
    }
    
    public void setAamWhoLog(String aamWhoLog) {
        this.aamWhoLog = aamWhoLog;
    }
    
    @Column(name="AAM_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAamWhenLog() {
        return this.aamWhenLog;
    }
    
    public void setAamWhenLog(Timestamp aamWhenLog) {
        this.aamWhenLog = aamWhenLog;
    }
   








}