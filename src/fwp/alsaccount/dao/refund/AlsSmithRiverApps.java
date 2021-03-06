package fwp.alsaccount.dao.refund;
// Generated Dec 20, 2016 4:13:42 PM by Hibernate Tools 5.2.0.Alpha3


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
 * AlsSmithRiverApps generated by hbm2java
 */
@Entity
@Table(name="ALS_SMITH_RIVER_APPS"
    ,schema="ALS"
)
public class AlsSmithRiverApps  implements java.io.Serializable {


     private AlsSmithRiverAppsIdPk idPk;
     private Date aictUsagePeriodFrom;
     private Date aictUsagePeriodTo;
     private String aictItemTypeCd;
     private String aiiItemTxnInd;
     private Integer aiiSeqNo;
     private String aaiAppIdentificationNo;
     private String asraApplicationNo;
     private String asraItemResidencyInd;
     private Integer abiLicenseYr;
     private Integer abiBatchNo;
     private Integer asiSubbatchNo;
     private Integer apcPrerequisiteCostCd;
     private Double asraAppsCost;
     private String asraAppStatus;
     private Integer asraIssueProvider;
     private String asraCheckNo;
     private String asraCheckWriter;
     private Integer asraRefundReason;
     private String asraNotes;
     private Integer asraDrawingNo;
     private String asraOutfitterInd;
     private String asraFeeStatus;
     private String asraFloatStatus;
     private String asraFirstTimeInd;
     private Integer asraNumberNres;
     private Integer asraNumberRes;
     private Date asraDateAppRecd;
     private Integer asraDataEntryProvider;
     private String asraWhoLog;
     private Date asraWhenLog;
     private Integer asraNoClients;
     private Integer asraNoStaff;
     private String asraPosted;
     private Integer acgCostGroupSeqNo;
     private Date asraSuccessLaunchDt;
     private Integer asraRefSeqNo;
     private Double asraAdditionalFees;
     private Date createDate;
     private String createDbuser;
     private Integer createPersonid;
     private Date modDate;
     private String modDbuser;
     private Integer modPersonid;

    public AlsSmithRiverApps() {
    }

	
    public AlsSmithRiverApps(AlsSmithRiverAppsIdPk idPk, Date aictUsagePeriodFrom, Date aictUsagePeriodTo, String aictItemTypeCd, String asraItemResidencyInd, String asraAppStatus, String asraFeeStatus, Date asraDateAppRecd, String asraWhoLog, Date asraWhenLog, Date createDate, String createDbuser) {
        this.idPk = idPk;
        this.aictUsagePeriodFrom = aictUsagePeriodFrom;
        this.aictUsagePeriodTo = aictUsagePeriodTo;
        this.aictItemTypeCd = aictItemTypeCd;
        this.asraItemResidencyInd = asraItemResidencyInd;
        this.asraAppStatus = asraAppStatus;
        this.asraFeeStatus = asraFeeStatus;
        this.asraDateAppRecd = asraDateAppRecd;
        this.asraWhoLog = asraWhoLog;
        this.asraWhenLog = asraWhenLog;
        this.createDate = createDate;
        this.createDbuser = createDbuser;
    }
    public AlsSmithRiverApps(AlsSmithRiverAppsIdPk idPk, Date aictUsagePeriodFrom, Date aictUsagePeriodTo, String aictItemTypeCd, String aiiItemTxnInd, Integer aiiSeqNo, String aaiAppIdentificationNo, String asraApplicationNo, String asraItemResidencyInd, Integer abiLicenseYr, Integer abiBatchNo, Integer asiSubbatchNo, Integer apcPrerequisiteCostCd, Double asraAppsCost, String asraAppStatus, Integer asraIssueProvider, String asraCheckNo, String asraCheckWriter, Integer asraRefundReason, String asraNotes, Integer asraDrawingNo, String asraOutfitterInd, String asraFeeStatus, String asraFloatStatus, String asraFirstTimeInd, Integer asraNumberNres, Integer asraNumberRes, Date asraDateAppRecd, Integer asraDataEntryProvider, String asraWhoLog, Date asraWhenLog, Integer asraNoClients, Integer asraNoStaff, String asraPosted, Integer acgCostGroupSeqNo, Date asraSuccessLaunchDt, Integer asraRefSeqNo, Double asraAdditionalFees, Date createDate, String createDbuser, Integer createPersonid, Date modDate, String modDbuser, Integer modPersonid) {
       this.idPk = idPk;
       this.aictUsagePeriodFrom = aictUsagePeriodFrom;
       this.aictUsagePeriodTo = aictUsagePeriodTo;
       this.aictItemTypeCd = aictItemTypeCd;
       this.aiiItemTxnInd = aiiItemTxnInd;
       this.aiiSeqNo = aiiSeqNo;
       this.aaiAppIdentificationNo = aaiAppIdentificationNo;
       this.asraApplicationNo = asraApplicationNo;
       this.asraItemResidencyInd = asraItemResidencyInd;
       this.abiLicenseYr = abiLicenseYr;
       this.abiBatchNo = abiBatchNo;
       this.asiSubbatchNo = asiSubbatchNo;
       this.apcPrerequisiteCostCd = apcPrerequisiteCostCd;
       this.asraAppsCost = asraAppsCost;
       this.asraAppStatus = asraAppStatus;
       this.asraIssueProvider = asraIssueProvider;
       this.asraCheckNo = asraCheckNo;
       this.asraCheckWriter = asraCheckWriter;
       this.asraRefundReason = asraRefundReason;
       this.asraNotes = asraNotes;
       this.asraDrawingNo = asraDrawingNo;
       this.asraOutfitterInd = asraOutfitterInd;
       this.asraFeeStatus = asraFeeStatus;
       this.asraFloatStatus = asraFloatStatus;
       this.asraFirstTimeInd = asraFirstTimeInd;
       this.asraNumberNres = asraNumberNres;
       this.asraNumberRes = asraNumberRes;
       this.asraDateAppRecd = asraDateAppRecd;
       this.asraDataEntryProvider = asraDataEntryProvider;
       this.asraWhoLog = asraWhoLog;
       this.asraWhenLog = asraWhenLog;
       this.asraNoClients = asraNoClients;
       this.asraNoStaff = asraNoStaff;
       this.asraPosted = asraPosted;
       this.acgCostGroupSeqNo = acgCostGroupSeqNo;
       this.asraSuccessLaunchDt = asraSuccessLaunchDt;
       this.asraRefSeqNo = asraRefSeqNo;
       this.asraAdditionalFees = asraAdditionalFees;
       this.createDate = createDate;
       this.createDbuser = createDbuser;
       this.createPersonid = createPersonid;
       this.modDate = modDate;
       this.modDbuser = modDbuser;
       this.modPersonid = modPersonid;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="apiDob", column=@Column(name="API_DOB", nullable=false, length=7) ), 
        @AttributeOverride(name="apiAlsNo", column=@Column(name="API_ALS_NO", nullable=false, precision=8, scale=0) ), 
        @AttributeOverride(name="asraSeqNo", column=@Column(name="ASRA_SEQ_NO", nullable=false, precision=5, scale=0) ) } )
    public AlsSmithRiverAppsIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsSmithRiverAppsIdPk idPk) {
        this.idPk = idPk;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="AICT_USAGE_PERIOD_FROM", nullable=false, length=7)
    public Date getAictUsagePeriodFrom() {
        return this.aictUsagePeriodFrom;
    }
    
    public void setAictUsagePeriodFrom(Date aictUsagePeriodFrom) {
        this.aictUsagePeriodFrom = aictUsagePeriodFrom;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="AICT_USAGE_PERIOD_TO", nullable=false, length=7)
    public Date getAictUsagePeriodTo() {
        return this.aictUsagePeriodTo;
    }
    
    public void setAictUsagePeriodTo(Date aictUsagePeriodTo) {
        this.aictUsagePeriodTo = aictUsagePeriodTo;
    }

    
    @Column(name="AICT_ITEM_TYPE_CD", nullable=false, length=7)
    public String getAictItemTypeCd() {
        return this.aictItemTypeCd;
    }
    
    public void setAictItemTypeCd(String aictItemTypeCd) {
        this.aictItemTypeCd = aictItemTypeCd;
    }

    
    @Column(name="AII_ITEM_TXN_IND", length=1)
    public String getAiiItemTxnInd() {
        return this.aiiItemTxnInd;
    }
    
    public void setAiiItemTxnInd(String aiiItemTxnInd) {
        this.aiiItemTxnInd = aiiItemTxnInd;
    }

    
    @Column(name="AII_SEQ_NO", precision=3, scale=0)
    public Integer getAiiSeqNo() {
        return this.aiiSeqNo;
    }
    
    public void setAiiSeqNo(Integer aiiSeqNo) {
        this.aiiSeqNo = aiiSeqNo;
    }

    
    @Column(name="AAI_APP_IDENTIFICATION_NO", length=20)
    public String getAaiAppIdentificationNo() {
        return this.aaiAppIdentificationNo;
    }
    
    public void setAaiAppIdentificationNo(String aaiAppIdentificationNo) {
        this.aaiAppIdentificationNo = aaiAppIdentificationNo;
    }

    
    @Column(name="ASRA_APPLICATION_NO", length=14)
    public String getAsraApplicationNo() {
        return this.asraApplicationNo;
    }
    
    public void setAsraApplicationNo(String asraApplicationNo) {
        this.asraApplicationNo = asraApplicationNo;
    }

    
    @Column(name="ASRA_ITEM_RESIDENCY_IND", nullable=false, length=1)
    public String getAsraItemResidencyInd() {
        return this.asraItemResidencyInd;
    }
    
    public void setAsraItemResidencyInd(String asraItemResidencyInd) {
        this.asraItemResidencyInd = asraItemResidencyInd;
    }

    
    @Column(name="ABI_LICENSE_YR", precision=4, scale=0)
    public Integer getAbiLicenseYr() {
        return this.abiLicenseYr;
    }
    
    public void setAbiLicenseYr(Integer abiLicenseYr) {
        this.abiLicenseYr = abiLicenseYr;
    }

    
    @Column(name="ABI_BATCH_NO", precision=7, scale=0)
    public Integer getAbiBatchNo() {
        return this.abiBatchNo;
    }
    
    public void setAbiBatchNo(Integer abiBatchNo) {
        this.abiBatchNo = abiBatchNo;
    }

    
    @Column(name="ASI_SUBBATCH_NO", precision=7, scale=0)
    public Integer getAsiSubbatchNo() {
        return this.asiSubbatchNo;
    }
    
    public void setAsiSubbatchNo(Integer asiSubbatchNo) {
        this.asiSubbatchNo = asiSubbatchNo;
    }

    
    @Column(name="APC_PREREQUISITE_COST_CD", precision=5, scale=0)
    public Integer getApcPrerequisiteCostCd() {
        return this.apcPrerequisiteCostCd;
    }
    
    public void setApcPrerequisiteCostCd(Integer apcPrerequisiteCostCd) {
        this.apcPrerequisiteCostCd = apcPrerequisiteCostCd;
    }

    
    @Column(name="ASRA_APPS_COST", precision=8)
    public Double getAsraAppsCost() {
        return this.asraAppsCost;
    }
    
    public void setAsraAppsCost(Double asraAppsCost) {
        this.asraAppsCost = asraAppsCost;
    }

    
    @Column(name="ASRA_APP_STATUS", nullable=false, length=1)
    public String getAsraAppStatus() {
        return this.asraAppStatus;
    }
    
    public void setAsraAppStatus(String asraAppStatus) {
        this.asraAppStatus = asraAppStatus;
    }

    
    @Column(name="ASRA_ISSUE_PROVIDER", precision=10, scale=0)
    public Integer getAsraIssueProvider() {
        return this.asraIssueProvider;
    }
    
    public void setAsraIssueProvider(Integer asraIssueProvider) {
        this.asraIssueProvider = asraIssueProvider;
    }

    
    @Column(name="ASRA_CHECK_NO", length=50)
    public String getAsraCheckNo() {
        return this.asraCheckNo;
    }
    
    public void setAsraCheckNo(String asraCheckNo) {
        this.asraCheckNo = asraCheckNo;
    }

    
    @Column(name="ASRA_CHECK_WRITER", length=1000)
    public String getAsraCheckWriter() {
        return this.asraCheckWriter;
    }
    
    public void setAsraCheckWriter(String asraCheckWriter) {
        this.asraCheckWriter = asraCheckWriter;
    }

    
    @Column(name="ASRA_REFUND_REASON", precision=3, scale=0)
    public Integer getAsraRefundReason() {
        return this.asraRefundReason;
    }
    
    public void setAsraRefundReason(Integer asraRefundReason) {
        this.asraRefundReason = asraRefundReason;
    }

    
    @Column(name="ASRA_NOTES", length=2000)
    public String getAsraNotes() {
        return this.asraNotes;
    }
    
    public void setAsraNotes(String asraNotes) {
        this.asraNotes = asraNotes;
    }

    
    @Column(name="ASRA_DRAWING_NO", precision=10, scale=0)
    public Integer getAsraDrawingNo() {
        return this.asraDrawingNo;
    }
    
    public void setAsraDrawingNo(Integer asraDrawingNo) {
        this.asraDrawingNo = asraDrawingNo;
    }

    
    @Column(name="ASRA_OUTFITTER_IND", length=1)
    public String getAsraOutfitterInd() {
        return this.asraOutfitterInd;
    }
    
    public void setAsraOutfitterInd(String asraOutfitterInd) {
        this.asraOutfitterInd = asraOutfitterInd;
    }

    
    @Column(name="ASRA_FEE_STATUS", nullable=false, length=2)
    public String getAsraFeeStatus() {
        return this.asraFeeStatus;
    }
    
    public void setAsraFeeStatus(String asraFeeStatus) {
        this.asraFeeStatus = asraFeeStatus;
    }

    
    @Column(name="ASRA_FLOAT_STATUS", length=1)
    public String getAsraFloatStatus() {
        return this.asraFloatStatus;
    }
    
    public void setAsraFloatStatus(String asraFloatStatus) {
        this.asraFloatStatus = asraFloatStatus;
    }

    
    @Column(name="ASRA_FIRST_TIME_IND", length=1)
    public String getAsraFirstTimeInd() {
        return this.asraFirstTimeInd;
    }
    
    public void setAsraFirstTimeInd(String asraFirstTimeInd) {
        this.asraFirstTimeInd = asraFirstTimeInd;
    }

    
    @Column(name="ASRA_NUMBER_NRES", precision=5, scale=0)
    public Integer getAsraNumberNres() {
        return this.asraNumberNres;
    }
    
    public void setAsraNumberNres(Integer asraNumberNres) {
        this.asraNumberNres = asraNumberNres;
    }

    
    @Column(name="ASRA_NUMBER_RES", precision=5, scale=0)
    public Integer getAsraNumberRes() {
        return this.asraNumberRes;
    }
    
    public void setAsraNumberRes(Integer asraNumberRes) {
        this.asraNumberRes = asraNumberRes;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ASRA_DATE_APP_RECD", nullable=false, length=7)
    public Date getAsraDateAppRecd() {
        return this.asraDateAppRecd;
    }
    
    public void setAsraDateAppRecd(Date asraDateAppRecd) {
        this.asraDateAppRecd = asraDateAppRecd;
    }

    
    @Column(name="ASRA_DATA_ENTRY_PROVIDER", precision=10, scale=0)
    public Integer getAsraDataEntryProvider() {
        return this.asraDataEntryProvider;
    }
    
    public void setAsraDataEntryProvider(Integer asraDataEntryProvider) {
        this.asraDataEntryProvider = asraDataEntryProvider;
    }

    
    @Column(name="ASRA_WHO_LOG", nullable=false, length=15)
    public String getAsraWhoLog() {
        return this.asraWhoLog;
    }
    
    public void setAsraWhoLog(String asraWhoLog) {
        this.asraWhoLog = asraWhoLog;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ASRA_WHEN_LOG", nullable=false, length=7)
    public Date getAsraWhenLog() {
        return this.asraWhenLog;
    }
    
    public void setAsraWhenLog(Date asraWhenLog) {
        this.asraWhenLog = asraWhenLog;
    }

    
    @Column(name="ASRA_NO_CLIENTS", precision=5, scale=0)
    public Integer getAsraNoClients() {
        return this.asraNoClients;
    }
    
    public void setAsraNoClients(Integer asraNoClients) {
        this.asraNoClients = asraNoClients;
    }

    
    @Column(name="ASRA_NO_STAFF", precision=5, scale=0)
    public Integer getAsraNoStaff() {
        return this.asraNoStaff;
    }
    
    public void setAsraNoStaff(Integer asraNoStaff) {
        this.asraNoStaff = asraNoStaff;
    }

    
    @Column(name="ASRA_POSTED", length=1)
    public String getAsraPosted() {
        return this.asraPosted;
    }
    
    public void setAsraPosted(String asraPosted) {
        this.asraPosted = asraPosted;
    }

    
    @Column(name="ACG_COST_GROUP_SEQ_NO", precision=4, scale=0)
    public Integer getAcgCostGroupSeqNo() {
        return this.acgCostGroupSeqNo;
    }
    
    public void setAcgCostGroupSeqNo(Integer acgCostGroupSeqNo) {
        this.acgCostGroupSeqNo = acgCostGroupSeqNo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ASRA_SUCCESS_LAUNCH_DT", length=7)
    public Date getAsraSuccessLaunchDt() {
        return this.asraSuccessLaunchDt;
    }
    
    public void setAsraSuccessLaunchDt(Date asraSuccessLaunchDt) {
        this.asraSuccessLaunchDt = asraSuccessLaunchDt;
    }

    
    @Column(name="ASRA_REF_SEQ_NO", precision=5, scale=0)
    public Integer getAsraRefSeqNo() {
        return this.asraRefSeqNo;
    }
    
    public void setAsraRefSeqNo(Integer asraRefSeqNo) {
        this.asraRefSeqNo = asraRefSeqNo;
    }

    
    @Column(name="ASRA_ADDITIONAL_FEES", precision=8)
    public Double getAsraAdditionalFees() {
        return this.asraAdditionalFees;
    }
    
    public void setAsraAdditionalFees(Double asraAdditionalFees) {
        this.asraAdditionalFees = asraAdditionalFees;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATE_DATE", nullable=false, length=7)
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    @Column(name="CREATE_DBUSER", nullable=false, length=30)
    public String getCreateDbuser() {
        return this.createDbuser;
    }
    
    public void setCreateDbuser(String createDbuser) {
        this.createDbuser = createDbuser;
    }

    
    @Column(name="CREATE_PERSONID", precision=10, scale=0)
    public Integer getCreatePersonid() {
        return this.createPersonid;
    }
    
    public void setCreatePersonid(Integer createPersonid) {
        this.createPersonid = createPersonid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="MOD_DATE", length=7)
    public Date getModDate() {
        return this.modDate;
    }
    
    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    
    @Column(name="MOD_DBUSER", length=30)
    public String getModDbuser() {
        return this.modDbuser;
    }
    
    public void setModDbuser(String modDbuser) {
        this.modDbuser = modDbuser;
    }

    
    @Column(name="MOD_PERSONID", precision=10, scale=0)
    public Integer getModPersonid() {
        return this.modPersonid;
    }
    
    public void setModPersonid(Integer modPersonid) {
        this.modPersonid = modPersonid;
    }




}


