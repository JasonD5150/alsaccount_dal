package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsSysActivityControl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_SYS_ACTIVITY_CONTROL"
    ,schema="ALS"
)

public class AlsSysActivityControl  implements java.io.Serializable {


    // Fields    

     private AlsSysActivityControlIdPk idPk;
     private String asacSysActivityTypeCdDesc;
     private Integer asacProgram;
     private String asacProjectGrant;
     private String asacWhoLog;
     private Timestamp asacWhenLog;


    // Constructors

    /** default constructor */
    public AlsSysActivityControl() {
    }

	/** minimal constructor */
    public AlsSysActivityControl(AlsSysActivityControlIdPk idPk, String asacWhoLog, Timestamp asacWhenLog) {
        this.idPk = idPk;
        this.asacWhoLog = asacWhoLog;
        this.asacWhenLog = asacWhenLog;
    }
    
    /** full constructor */
    public AlsSysActivityControl(AlsSysActivityControlIdPk idPk, String asacSysActivityTypeCdDesc, Integer asacProgram, String asacProjectGrant, String asacWhoLog, Timestamp asacWhenLog) {
        this.idPk = idPk;
        this.asacSysActivityTypeCdDesc = asacSysActivityTypeCdDesc;
        this.asacProgram = asacProgram;
        this.asacProjectGrant = asacProjectGrant;
        this.asacWhoLog = asacWhoLog;
        this.asacWhenLog = asacWhenLog;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="asacBudgetYear", column=@Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="asacSystemActivityTypeCd", column=@Column(name="ASAC_SYSTEM_ACTIVITY_TYPE_CD", nullable=false, length=1) ), 
        @AttributeOverride(name="asacTxnCd", column=@Column(name="ASAC_TXN_CD", nullable=false, length=3) ) } )

    public AlsSysActivityControlIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsSysActivityControlIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="ASAC_SYS_ACTIVITY_TYPE_CD_DESC", length=200)

    public String getAsacSysActivityTypeCdDesc() {
        return this.asacSysActivityTypeCdDesc;
    }
    
    public void setAsacSysActivityTypeCdDesc(String asacSysActivityTypeCdDesc) {
        this.asacSysActivityTypeCdDesc = asacSysActivityTypeCdDesc;
    }
    
    @Column(name="ASAC_PROGRAM", precision=4, scale=0)

    public Integer getAsacProgram() {
        return this.asacProgram;
    }
    
    public void setAsacProgram(Integer asacProgram) {
        this.asacProgram = asacProgram;
    }
    
    @Column(name="ASAC_PROJECT_GRANT", length=15)

    public String getAsacProjectGrant() {
        return this.asacProjectGrant;
    }
    
    public void setAsacProjectGrant(String asacProjectGrant) {
        this.asacProjectGrant = asacProjectGrant;
    }
    
    @Column(name="ASAC_WHO_LOG", nullable=false, length=15)

    public String getAsacWhoLog() {
        return this.asacWhoLog;
    }
    
    public void setAsacWhoLog(String asacWhoLog) {
        this.asacWhoLog = asacWhoLog;
    }
    
    @Column(name="ASAC_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAsacWhenLog() {
        return this.asacWhenLog;
    }
    
    public void setAsacWhenLog(Timestamp asacWhenLog) {
        this.asacWhenLog = asacWhenLog;
    }
   








}