package fwp.alsaccount.dto.sales;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class IafaDetailsDTO implements Serializable{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private Integer apiProviderNo;
	private String apiBusinessNm;
	private String apiAlxProvInd;
	private Date aprBillingFrom;
	private Date aprBillingTo;
	private Integer aiafaSeqNo;
	private Integer asDataEntryProviderNo;
	private Date aictUsagePeriodFrom;
	private Date aictUsagePeriodTo;
	private Integer aictItemTypeCd;
	private Integer itemCatCd;
	private String aitTypeDesc;
	private String aiiItemTxnInd;
	private Integer aiiSeqNo;
	private Date dob;
	private Integer alsNo;
	private Integer aiinItemIndCd;
	private Integer aisItemStatusCd;
	private Integer aaiDispositionCd;
	private String aicCategoryDesc;
	private Integer apcPrerequisiteCostCd ;
	private String Residency;
	private String itemResidency ;
	private Integer acdCostGroupSeqNo ;
	private Integer aiafaAmtType;
	private Double aiafaAmt;
	private Double sumIafa;
	private Integer aiafaProcessCategoryCd;
	private Integer astProcessTypeCd;
	private Integer aiafaReasonCd;
	private String ahmType;
	private Integer ahmCd;
	private String aiafaStatus;
	private Timestamp asSessionDt;
	private Date sessionDt;
	private String sessionOrigin;
	private Date asSessionVoidDt; 
	private String abiBatchNO;
	private String asiSubatchNo;
	private Date aiafaRecordVoidDt; 
	private String aiafaRemarks;
	private Date abiReconciledOn;
	private Date aiafaWhenLog;
	private String asModePayment;
	private Integer asCheckNo;
	private String asCheckWriter;
	private String aaiBonusPointsInd;
	private String atiTribeCd;            
	private String atgsGroupIdentifier;    
	private String atgsSummaryStatus;   
	private String atgsInterfaceStatus;
	private String aiafaAppType;
	private String astNochargeReason;
	private String providerNm;
	private String itemTypeDesc;
	private String itemIndDesc;
	private String itemStatusDesc;
	private String appDispositionDesc;
	private String prereqDesc;
	private String itemCatDesc;
	private String amtTypeDesc;
	private String processCatDesc;
	private String processTypeDesc;
	private String reasonDesc;
	private String otherTxnGrp;
	private String costGrpDesc;
	private String reasonType;
	private Double sessionTotal;
	private Integer seqNoforPrintedItems;
	
	
	public Date getSessionDt() {
		return sessionDt;
	}
	public void setSessionDt(Date sessionDt) {
		this.sessionDt = sessionDt;
	}
	public Double getSessionTotal() {
		return sessionTotal;
	}
	public void setSessionTotal(Double sessionTotal) {
		this.sessionTotal = sessionTotal;
	}
	public String getReasonType() {
		return reasonType;
	}
	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}
	public String getCostGrpDesc() {
		return costGrpDesc;
	}
	public void setCostGrpDesc(String costGrpDesc) {
		this.costGrpDesc = costGrpDesc;
	}
	public String getOtherTxnGrp() {
		return otherTxnGrp;
	}
	public void setOtherTxnGrp(String otherTxnGrp) {
		this.otherTxnGrp = otherTxnGrp;
	}
	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
	public Integer getApiProviderNo() {
		return apiProviderNo;
	}
	public void setApiProviderNo(Integer apiProviderNo) {
		this.apiProviderNo = apiProviderNo;
	}
	public String getApiBusinessNm() {
		return apiBusinessNm;
	}
	public void setApiBusinessNm(String apiBusinessNm) {
		this.apiBusinessNm = apiBusinessNm;
	}
	public String getApiAlxProvInd() {
		return apiAlxProvInd;
	}
	public void setApiAlxProvInd(String apiAlxProvInd) {
		this.apiAlxProvInd = apiAlxProvInd;
	}
	public Date getAprBillingFrom() {
		return aprBillingFrom;
	}
	public void setAprBillingFrom(Date aprBillingFrom) {
		this.aprBillingFrom = aprBillingFrom;
	}
	public Date getAprBillingTo() {
		return aprBillingTo;
	}
	public void setAprBillingTo(Date aprBillingTo) {
		this.aprBillingTo = aprBillingTo;
	}
	public Integer getAiafaSeqNo() {
		return aiafaSeqNo;
	}
	public void setAiafaSeqNo(Integer aiafaSeqNo) {
		this.aiafaSeqNo = aiafaSeqNo;
	}
	public Integer getAsDataEntryProviderNo() {
		return asDataEntryProviderNo;
	}
	public void setAsDataEntryProviderNo(Integer asDataEntryProviderNo) {
		this.asDataEntryProviderNo = asDataEntryProviderNo;
	}
	public Date getAictUsagePeriodFrom() {
		return aictUsagePeriodFrom;
	}
	public void setAictUsagePeriodFrom(Date aictUsagePeriodFrom) {
		this.aictUsagePeriodFrom = aictUsagePeriodFrom;
	}
	public Date getAictUsagePeriodTo() {
		return aictUsagePeriodTo;
	}
	public void setAictUsagePeriodTo(Date aictUsagePeriodTo) {
		this.aictUsagePeriodTo = aictUsagePeriodTo;
	}
	public Integer getAictItemTypeCd() {
		return aictItemTypeCd;
	}
	public void setAictItemTypeCd(Integer aictItemTypeCd) {
		this.aictItemTypeCd = aictItemTypeCd;
	}
	public Integer getItemCatCd() {
		return itemCatCd;
	}
	public void setItemCatCd(Integer itemCatCd) {
		this.itemCatCd = itemCatCd;
	}
	public String getAitTypeDesc() {
		return aitTypeDesc;
	}
	public void setAitTypeDesc(String aitTypeDesc) {
		this.aitTypeDesc = aitTypeDesc;
	}
	public String getAiiItemTxnInd() {
		return aiiItemTxnInd;
	}
	public void setAiiItemTxnInd(String aiiItemTxnInd) {
		this.aiiItemTxnInd = aiiItemTxnInd;
	}
	public Integer getAiiSeqNo() {
		return aiiSeqNo;
	}
	public void setAiiSeqNo(Integer aiiSeqNo) {
		this.aiiSeqNo = aiiSeqNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Integer getAlsNo() {
		return alsNo;
	}
	public void setAlsNo(Integer alsNo) {
		this.alsNo = alsNo;
	}
	public Integer getAiinItemIndCd() {
		return aiinItemIndCd;
	}
	public void setAiinItemIndCd(Integer aiinItemIndCd) {
		this.aiinItemIndCd = aiinItemIndCd;
	}
	public Integer getAisItemStatusCd() {
		return aisItemStatusCd;
	}
	public void setAisItemStatusCd(Integer aisItemStatusCd) {
		this.aisItemStatusCd = aisItemStatusCd;
	}
	public Integer getAaiDispositionCd() {
		return aaiDispositionCd;
	}
	public void setAaiDispositionCd(Integer aaiDispositionCd) {
		this.aaiDispositionCd = aaiDispositionCd;
	}
	public String getAicCategoryDesc() {
		return aicCategoryDesc;
	}
	public void setAicCategoryDesc(String aicCategoryDesc) {
		this.aicCategoryDesc = aicCategoryDesc;
	}
	public Integer getApcPrerequisiteCostCd() {
		return apcPrerequisiteCostCd;
	}
	public void setApcPrerequisiteCostCd(Integer apcPrerequisiteCostCd) {
		this.apcPrerequisiteCostCd = apcPrerequisiteCostCd;
	}
	public String getResidency() {
		return Residency;
	}
	public void setResidency(String residency) {
		Residency = residency;
	}
	public String getItemResidency() {
		return itemResidency;
	}
	public void setItemResidency(String itemResidency) {
		this.itemResidency = itemResidency;
	}
	public Integer getAcdCostGroupSeqNo() {
		return acdCostGroupSeqNo;
	}
	public void setAcdCostGroupSeqNo(Integer acdCostGroupSeqNo) {
		this.acdCostGroupSeqNo = acdCostGroupSeqNo;
	}
	public Integer getAiafaAmtType() {
		return aiafaAmtType;
	}
	public void setAiafaAmtType(Integer aiafaAmtType) {
		this.aiafaAmtType = aiafaAmtType;
	}
	public Double getAiafaAmt() {
		return aiafaAmt;
	}
	public void setAiafaAmt(Double aiafaAmt) {
		this.aiafaAmt = aiafaAmt;
	}
	public Double getSumIafa() {
		return sumIafa;
	}
	public void setSumIafa(Double sumIafa) {
		this.sumIafa = sumIafa;
	}
	public Integer getAiafaProcessCategoryCd() {
		return aiafaProcessCategoryCd;
	}
	public void setAiafaProcessCategoryCd(Integer aiafaProcessCategoryCd) {
		this.aiafaProcessCategoryCd = aiafaProcessCategoryCd;
	}
	public Integer getAstProcessTypeCd() {
		return astProcessTypeCd;
	}
	public void setAstProcessTypeCd(Integer astProcessTypeCd) {
		this.astProcessTypeCd = astProcessTypeCd;
	}
	public Integer getAiafaReasonCd() {
		return aiafaReasonCd;
	}
	public void setAiafaReasonCd(Integer aiafaReasonCd) {
		this.aiafaReasonCd = aiafaReasonCd;
	}
	public String getAhmType() {
		return ahmType;
	}
	public void setAhmType(String ahmType) {
		this.ahmType = ahmType;
	}
	public Integer getAhmCd() {
		return ahmCd;
	}
	public void setAhmCd(Integer ahmCd) {
		this.ahmCd = ahmCd;
	}
	public String getAiafaStatus() {
		return aiafaStatus;
	}
	public void setAiafaStatus(String aiafaStatus) {
		this.aiafaStatus = aiafaStatus;
	}
	public Timestamp getAsSessionDt() {
		return asSessionDt;
	}
	public void setAsSessionDt(Timestamp asSessionDt) {
		this.asSessionDt = asSessionDt;
	}
	public String getSessionOrigin() {
		return sessionOrigin;
	}
	public void setSessionOrigin(String sessionOrigin) {
		this.sessionOrigin = sessionOrigin;
	}
	public Date getAsSessionVoidDt() {
		return asSessionVoidDt;
	}
	public void setAsSessionVoidDt(Date asSessionVoidDt) {
		this.asSessionVoidDt = asSessionVoidDt;
	}
	public String getAbiBatchNO() {
		return abiBatchNO;
	}
	public void setAbiBatchNO(String abiBatchNO) {
		this.abiBatchNO = abiBatchNO;
	}
	public String getAsiSubatchNo() {
		return asiSubatchNo;
	}
	public void setAsiSubatchNo(String asiSubatchNo) {
		this.asiSubatchNo = asiSubatchNo;
	}
	public Date getAiafaRecordVoidDt() {
		return aiafaRecordVoidDt;
	}
	public void setAiafaRecordVoidDt(Date aiafaRecordVoidDt) {
		this.aiafaRecordVoidDt = aiafaRecordVoidDt;
	}
	public String getAiafaRemarks() {
		return aiafaRemarks;
	}
	public void setAiafaRemarks(String aiafaRemarks) {
		this.aiafaRemarks = aiafaRemarks;
	}
	public Date getAbiReconciledOn() {
		return abiReconciledOn;
	}
	public void setAbiReconciledOn(Date abiReconciledOn) {
		this.abiReconciledOn = abiReconciledOn;
	}
	public Date getAiafaWhenLog() {
		return aiafaWhenLog;
	}
	public void setAiafaWhenLog(Date aiafaWhenLog) {
		this.aiafaWhenLog = aiafaWhenLog;
	}
	public String getAsModePayment() {
		return asModePayment;
	}
	public void setAsModePayment(String asModePayment) {
		this.asModePayment = asModePayment;
	}
	public Integer getAsCheckNo() {
		return asCheckNo;
	}
	public void setAsCheckNo(Integer asCheckNo) {
		this.asCheckNo = asCheckNo;
	}
	public String getAsCheckWriter() {
		return asCheckWriter;
	}
	public void setAsCheckWriter(String asCheckWriter) {
		this.asCheckWriter = asCheckWriter;
	}
	public String getAaiBonusPointsInd() {
		return aaiBonusPointsInd;
	}
	public void setAaiBonusPointsInd(String aaiBonusPointsInd) {
		this.aaiBonusPointsInd = aaiBonusPointsInd;
	}
	public String getAtiTribeCd() {
		return atiTribeCd;
	}
	public void setAtiTribeCd(String atiTribeCd) {
		this.atiTribeCd = atiTribeCd;
	}
	public String getAtgsGroupIdentifier() {
		return atgsGroupIdentifier;
	}
	public void setAtgsGroupIdentifier(String atgsGroupIdentifier) {
		this.atgsGroupIdentifier = atgsGroupIdentifier;
	}
	public String getAtgsSummaryStatus() {
		return atgsSummaryStatus;
	}
	public void setAtgsSummaryStatus(String atgsSummaryStatus) {
		this.atgsSummaryStatus = atgsSummaryStatus;
	}
	public String getAtgsInterfaceStatus() {
		return atgsInterfaceStatus;
	}
	public void setAtgsInterfaceStatus(String atgsInterfaceStatus) {
		this.atgsInterfaceStatus = atgsInterfaceStatus;
	}
	public String getAiafaAppType() {
		return aiafaAppType;
	}
	public void setAiafaAppType(String aiafaAppType) {
		this.aiafaAppType = aiafaAppType;
	}
	public String getAstNochargeReason() {
		return astNochargeReason;
	}
	public void setAstNochargeReason(String astNochargeReason) {
		this.astNochargeReason = astNochargeReason;
	}
	public String getProviderNm() {
		return providerNm;
	}
	public void setProviderNm(String providerNm) {
		this.providerNm = providerNm;
	}
	public String getItemTypeDesc() {
		return itemTypeDesc;
	}
	public void setItemTypeDesc(String itemTypeDesc) {
		this.itemTypeDesc = itemTypeDesc;
	}
	public String getItemIndDesc() {
		return itemIndDesc;
	}
	public void setItemIndDesc(String itemIndDesc) {
		this.itemIndDesc = itemIndDesc;
	}
	public String getItemStatusDesc() {
		return itemStatusDesc;
	}
	public void setItemStatusDesc(String itemStatusDesc) {
		this.itemStatusDesc = itemStatusDesc;
	}
	public String getAppDispositionDesc() {
		return appDispositionDesc;
	}
	public void setAppDispositionDesc(String appDispositionDesc) {
		this.appDispositionDesc = appDispositionDesc;
	}
	public String getPrereqDesc() {
		return prereqDesc;
	}
	public void setPrereqDesc(String prereqDesc) {
		this.prereqDesc = prereqDesc;
	}
	public String getItemCatDesc() {
		return itemCatDesc;
	}
	public void setItemCatDesc(String itemCatDesc) {
		this.itemCatDesc = itemCatDesc;
	}
	public String getAmtTypeDesc() {
		return amtTypeDesc;
	}
	public void setAmtTypeDesc(String amtTypeDesc) {
		this.amtTypeDesc = amtTypeDesc;
	}
	public String getProcessCatDesc() {
		return processCatDesc;
	}
	public void setProcessCatDesc(String processCatDesc) {
		this.processCatDesc = processCatDesc;
	}
	public String getProcessTypeDesc() {
		return processTypeDesc;
	}
	public void setProcessTypeDesc(String processTypeDesc) {
		this.processTypeDesc = processTypeDesc;
	}
	public String getReasonDesc() {
		return reasonDesc;
	}
	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}
	public Integer getSeqNoforPrintedItems() {
		return seqNoforPrintedItems;
	}
	public void setSeqNoforPrintedItems(Integer seqNoforPrintedItems) {
		this.seqNoforPrintedItems = seqNoforPrintedItems;
	}
}
