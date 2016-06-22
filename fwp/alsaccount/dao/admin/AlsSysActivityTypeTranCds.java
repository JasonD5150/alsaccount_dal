package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsSysActivityTypeTranCds entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_SYS_ACTIVITY_TYPE_TRAN_CDS"
    ,schema="ALS"
)

public class AlsSysActivityTypeTranCds  implements java.io.Serializable {


    // Fields    

     private AlsSysActivityTypeTranCdsIdPk idPk;
     private String asattcDesc;
     private String asattcWhoLog;
     private Timestamp asattcWhenLog;
     private String asattcWhoModi;
     private Timestamp asattcWhenModi;


    // Constructors

    /** default constructor */
    public AlsSysActivityTypeTranCds() {
    }

	/** minimal constructor */
    public AlsSysActivityTypeTranCds(AlsSysActivityTypeTranCdsIdPk idPk) {
        this.idPk = idPk;
    }
    
    /** full constructor */
    public AlsSysActivityTypeTranCds(AlsSysActivityTypeTranCdsIdPk idPk, String asattcDesc, String asattcWhoLog, Timestamp asattcWhenLog, String asattcWhoModi, Timestamp asattcWhenModi) {
        this.idPk = idPk;
        this.asattcDesc = asattcDesc;
        this.asattcWhoLog = asattcWhoLog;
        this.asattcWhenLog = asattcWhenLog;
        this.asattcWhoModi = asattcWhoModi;
        this.asattcWhenModi = asattcWhenModi;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="asacSystemActivityTypeCd", column=@Column(name="ASAC_SYSTEM_ACTIVITY_TYPE_CD", nullable=false, length=1) ), 
        @AttributeOverride(name="asacTxnCd", column=@Column(name="ASAC_TXN_CD", nullable=false, length=3) ) } )

    public AlsSysActivityTypeTranCdsIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsSysActivityTypeTranCdsIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="ASATTC_DESC", length=2000)

    public String getAsattcDesc() {
        return this.asattcDesc;
    }
    
    public void setAsattcDesc(String asattcDesc) {
        this.asattcDesc = asattcDesc;
    }
    
    @Column(name="ASATTC_WHO_LOG", length=15)

    public String getAsattcWhoLog() {
        return this.asattcWhoLog;
    }
    
    public void setAsattcWhoLog(String asattcWhoLog) {
        this.asattcWhoLog = asattcWhoLog;
    }
    
    @Column(name="ASATTC_WHEN_LOG", length=7)

    public Timestamp getAsattcWhenLog() {
        return this.asattcWhenLog;
    }
    
    public void setAsattcWhenLog(Timestamp asattcWhenLog) {
        this.asattcWhenLog = asattcWhenLog;
    }
    
    @Column(name="ASATTC_WHO_MODI", length=15)

    public String getAsattcWhoModi() {
        return this.asattcWhoModi;
    }
    
    public void setAsattcWhoModi(String asattcWhoModi) {
        this.asattcWhoModi = asattcWhoModi;
    }
    
    @Column(name="ASATTC_WHEN_MODI", length=7)

    public Timestamp getAsattcWhenModi() {
        return this.asattcWhenModi;
    }
    
    public void setAsattcWhenModi(Timestamp asattcWhenModi) {
        this.asattcWhenModi = asattcWhenModi;
    }
   








}