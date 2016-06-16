package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * AlsSysActivityTypeCodes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_SYS_ACTIVITY_TYPE_CODES"
    ,schema="ALS"
)

public class AlsSysActivityTypeCodes  implements java.io.Serializable {


    // Fields    

     private String asacSystemActivityTypeCd;
     private String asatcDesc;
     private String asatcWhoLog;
     private Timestamp asatcWhenLog;
     private String asatcWhoModi;
     private Timestamp asatcWhenModi;


    // Constructors

    /** default constructor */
    public AlsSysActivityTypeCodes() {
    }

    
    /** full constructor */
    public AlsSysActivityTypeCodes(String asatcDesc, String asatcWhoLog, Timestamp asatcWhenLog, String asatcWhoModi, Timestamp asatcWhenModi) {
        this.asatcDesc = asatcDesc;
        this.asatcWhoLog = asatcWhoLog;
        this.asatcWhenLog = asatcWhenLog;
        this.asatcWhoModi = asatcWhoModi;
        this.asatcWhenModi = asatcWhenModi;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="ASAC_SYSTEM_ACTIVITY_TYPE_CD", unique=true, nullable=false, length=1)

    public String getAsacSystemActivityTypeCd() {
        return this.asacSystemActivityTypeCd;
    }
    
    public void setAsacSystemActivityTypeCd(String asacSystemActivityTypeCd) {
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
    }
    
    @Column(name="ASATC_DESC", length=2000)

    public String getAsatcDesc() {
        return this.asatcDesc;
    }
    
    public void setAsatcDesc(String asatcDesc) {
        this.asatcDesc = asatcDesc;
    }
    
    @Column(name="ASATC_WHO_LOG", length=15)

    public String getAsatcWhoLog() {
        return this.asatcWhoLog;
    }
    
    public void setAsatcWhoLog(String asatcWhoLog) {
        this.asatcWhoLog = asatcWhoLog;
    }
    
    @Column(name="ASATC_WHEN_LOG", length=7)

    public Timestamp getAsatcWhenLog() {
        return this.asatcWhenLog;
    }
    
    public void setAsatcWhenLog(Timestamp asatcWhenLog) {
        this.asatcWhenLog = asatcWhenLog;
    }
    
    @Column(name="ASATC_WHO_MODI", length=15)

    public String getAsatcWhoModi() {
        return this.asatcWhoModi;
    }
    
    public void setAsatcWhoModi(String asatcWhoModi) {
        this.asatcWhoModi = asatcWhoModi;
    }
    
    @Column(name="ASATC_WHEN_MODI", length=7)

    public Timestamp getAsatcWhenModi() {
        return this.asatcWhenModi;
    }
    
    public void setAsatcWhenModi(Timestamp asatcWhenModi) {
        this.asatcWhenModi = asatcWhenModi;
    }
   








}