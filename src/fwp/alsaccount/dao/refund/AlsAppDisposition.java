package fwp.alsaccount.dao.refund;
// Generated Dec 20, 2016 4:04:41 PM by Hibernate Tools 5.2.0.Alpha3


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AlsAppDisposition generated by hbm2java
 */
@Entity
@Table(name="ALS_APP_DISPOSITION"
    ,schema="ALS"
)
public class AlsAppDisposition  implements java.io.Serializable {


     private AlsAppDispositionIdPk idPk;
     private Integer aaiDispositionCd;
     private String aadWhoLog;
     private Date aadWhenLog;

    public AlsAppDisposition() {
    }

	
    public AlsAppDisposition(AlsAppDispositionIdPk idPk, String aadWhoLog, Date aadWhenLog) {
        this.idPk = idPk;
        this.aadWhoLog = aadWhoLog;
        this.aadWhenLog = aadWhenLog;
    }
    public AlsAppDisposition(AlsAppDispositionIdPk idPk, Integer aaiDispositionCd, String aadWhoLog, Date aadWhenLog) {
       this.idPk = idPk;
       this.aaiDispositionCd = aaiDispositionCd;
       this.aadWhoLog = aadWhoLog;
       this.aadWhenLog = aadWhenLog;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="aaiAppIdentificationNo", column=@Column(name="AAI_APP_IDENTIFICATION_NO", nullable=false, length=20) ), 
        @AttributeOverride(name="aadSeqNo", column=@Column(name="AAD_SEQ_NO", nullable=false, precision=6, scale=0) ) } )
    public AlsAppDispositionIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsAppDispositionIdPk idPk) {
        this.idPk = idPk;
    }

    
    @Column(name="AAI_DISPOSITION_CD", precision=2, scale=0)
    public Integer getAaiDispositionCd() {
        return this.aaiDispositionCd;
    }
    
    public void setAaiDispositionCd(Integer aaiDispositionCd) {
        this.aaiDispositionCd = aaiDispositionCd;
    }

    
    @Column(name="AAD_WHO_LOG", nullable=false, length=15)
    public String getAadWhoLog() {
        return this.aadWhoLog;
    }
    
    public void setAadWhoLog(String aadWhoLog) {
        this.aadWhoLog = aadWhoLog;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="AAD_WHEN_LOG", nullable=false, length=7)
    public Date getAadWhenLog() {
        return this.aadWhenLog;
    }
    
    public void setAadWhenLog(Date aadWhenLog) {
        this.aadWhenLog = aadWhenLog;
    }




}


