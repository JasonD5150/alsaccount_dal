package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * sabhrsAlsProviderRemittance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_PROVIDER_REMITTANCE"
    ,schema="ALS"
)

public class AlsProviderRemittance  implements java.io.Serializable {


    // Fields    

     private AlsProviderRemittanceIdPk idPk;
     private Double aprAmtReceived;
     private Double aprOldAmtReceived;
     private Double aprAmtDue;
     private String aprRemittPerStatus;
     private Timestamp aprEftDepositDeadlineDt;
     private Timestamp aprEftSweepDt;
     private Timestamp aprFundTransferDt;
     private String aprWhoLog;
     private Timestamp aprWhenLog;


    // Constructors

    /** default constructor */
    public AlsProviderRemittance() {
    }

	/** minimal constructor */
    public AlsProviderRemittance(AlsProviderRemittanceIdPk idPk, String aprWhoLog, Timestamp aprWhenLog) {
        this.idPk = idPk;
        this.aprWhoLog = aprWhoLog;
        this.aprWhenLog = aprWhenLog;
    }
    
    /** full constructor */
    public AlsProviderRemittance(AlsProviderRemittanceIdPk idPk, Double aprAmtReceived, Double aprOldAmtReceived, Double aprAmtDue, String aprRemittPerStatus, Timestamp aprEftDepositDeadlineDt, Timestamp aprEftSweepDt, Timestamp aprFundTransferDt, String aprWhoLog, Timestamp aprWhenLog) {
        this.idPk = idPk;
        this.aprAmtReceived = aprAmtReceived;
        this.aprOldAmtReceived = aprOldAmtReceived;
        this.aprAmtDue = aprAmtDue;
        this.aprRemittPerStatus = aprRemittPerStatus;
        this.aprEftDepositDeadlineDt = aprEftDepositDeadlineDt;
        this.aprEftSweepDt = aprEftSweepDt;
        this.aprFundTransferDt = aprFundTransferDt;
        this.aprWhoLog = aprWhoLog;
        this.aprWhenLog = aprWhenLog;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="apiProviderNo", column=@Column(name="API_PROVIDER_NO", nullable=false, precision=10, scale=0) ), 
        @AttributeOverride(name="aprBillingFrom", column=@Column(name="APR_BILLING_FROM", nullable=false, length=7) ), 
        @AttributeOverride(name="aprBillingTo", column=@Column(name="APR_BILLING_TO", nullable=false, length=7) ) } )

    public AlsProviderRemittanceIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsProviderRemittanceIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="APR_AMT_RECEIVED", precision=14)

    public Double getAprAmtReceived() {
        return this.aprAmtReceived;
    }
    
    public void setAprAmtReceived(Double aprAmtReceived) {
        this.aprAmtReceived = aprAmtReceived;
    }
    
    @Column(name="APR_OLD_AMT_RECEIVED", precision=14)

    public Double getAprOldAmtReceived() {
        return this.aprOldAmtReceived;
    }
    
    public void setAprOldAmtReceived(Double aprOldAmtReceived) {
        this.aprOldAmtReceived = aprOldAmtReceived;
    }
    
    @Column(name="APR_AMT_DUE", precision=14)

    public Double getAprAmtDue() {
        return this.aprAmtDue;
    }
    
    public void setAprAmtDue(Double aprAmtDue) {
        this.aprAmtDue = aprAmtDue;
    }
    
    @Column(name="APR_REMITT_PER_STATUS", length=2)

    public String getAprRemittPerStatus() {
        return this.aprRemittPerStatus;
    }
    
    public void setAprRemittPerStatus(String aprRemittPerStatus) {
        this.aprRemittPerStatus = aprRemittPerStatus;
    }
    
    @Column(name="APR_EFT_DEPOSIT_DEADLINE_DT", length=7)

    public Timestamp getAprEftDepositDeadlineDt() {
        return this.aprEftDepositDeadlineDt;
    }
    
    public void setAprEftDepositDeadlineDt(Timestamp aprEftDepositDeadlineDt) {
        this.aprEftDepositDeadlineDt = aprEftDepositDeadlineDt;
    }
    
    @Column(name="APR_EFT_SWEEP_DT", length=7)

    public Timestamp getAprEftSweepDt() {
        return this.aprEftSweepDt;
    }
    
    public void setAprEftSweepDt(Timestamp aprEftSweepDt) {
        this.aprEftSweepDt = aprEftSweepDt;
    }
    
    @Column(name="APR_FUND_TRANSFER_DT", length=7)

    public Timestamp getAprFundTransferDt() {
        return this.aprFundTransferDt;
    }
    
    public void setAprFundTransferDt(Timestamp aprFundTransferDt) {
        this.aprFundTransferDt = aprFundTransferDt;
    }
    
    @Column(name="APR_WHO_LOG", nullable=false, length=15)

    public String getAprWhoLog() {
        return this.aprWhoLog;
    }
    
    public void setAprWhoLog(String aprWhoLog) {
        this.aprWhoLog = aprWhoLog;
    }
    
    @Column(name="APR_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAprWhenLog() {
        return this.aprWhenLog;
    }
    
    public void setAprWhenLog(Timestamp aprWhenLog) {
        this.aprWhenLog = aprWhenLog;
    }
   
}