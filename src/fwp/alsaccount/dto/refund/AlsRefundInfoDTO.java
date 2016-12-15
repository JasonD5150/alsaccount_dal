package fwp.alsaccount.dto.refund;

import java.util.Date;

import fwp.als.hibernate.admin.dao.AlsRefundInfo;
import fwp.als.hibernate.admin.dao.AlsSessionTransIdPk;

public class AlsRefundInfoDTO extends AlsRefundInfo {
	
	private static final long serialVersionUID = -9176775350279011645L;
	private String gridKey;

	private Double refundFeeModified;
	private Integer providerNo;
	private String transactionStatus;
	private String processTypeCd;

	private String refundeeName;
	private Date usagePeriodFrom;
	private Date usagePeriodTo;
	private String itemTypeCd;
	private String itemTypeDesc;
	private Integer itemIndCd;
	private String itemIndDesc;
	private String reasonDesc;
	private Integer batchNo;
	private Integer subBatchNo;
	private String appType;
	private Date refundRequestDt;
	private Date designatedRefundeeDob;
	private Date refundProcessDt;
	private Date downloadDate;
	private String aiiItemTxnInd;
	private Integer aiiSeqNo;
	private String appIdNo;
	
	public String getGridKey() {
		return gridKey;
	}

	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}

	public Double getRefundFeeModified() {
		return refundFeeModified;
	}

	public void setRefundFeeModified(Double refundFeeModified) {
		this.refundFeeModified = refundFeeModified;
	}

	public Integer getProviderNo() {
		return providerNo;
	}

	public void setProviderNo(Integer providerNo) {
		this.providerNo = providerNo;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getProcessTypeCd() {
		return processTypeCd;
	}

	public void setProcessTypeCd(String processTypeCd) {
		this.processTypeCd = processTypeCd;
	}

	public String getRefundeeName() {
		return refundeeName;
	}

	public void setRefundeeName(String refundeeName) {
		this.refundeeName = refundeeName;
	}

	public Date getUsagePeriodFrom() {
		return usagePeriodFrom;
	}

	public void setUsagePeriodFrom(Date usagePeriodFrom) {
		this.usagePeriodFrom = usagePeriodFrom;
	}

	public Date getUsagePeriodTo() {
		return usagePeriodTo;
	}

	public void setUsagePeriodTo(Date usagePeriodTo) {
		this.usagePeriodTo = usagePeriodTo;
	}

	public String getItemTypeCd() {
		return itemTypeCd;
	}

	public void setItemTypeCd(String itemTypeCd) {
		this.itemTypeCd = itemTypeCd;
	}

	public String getItemTypeDesc() {
		return itemTypeDesc;
	}

	public void setItemTypeDesc(String itemTypeDesc) {
		this.itemTypeDesc = itemTypeDesc;
	}

	public Integer getItemIndCd() {
		return itemIndCd;
	}

	public void setItemIndCd(Integer itemIndCd) {
		this.itemIndCd = itemIndCd;
	}

	public String getItemIndDesc() {
		return itemIndDesc;
	}

	public void setItemIndDesc(String itemIndDesc) {
		this.itemIndDesc = itemIndDesc;
	}

	public String getReasonDesc() {
		return reasonDesc;
	}

	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	public Integer getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(Integer batchNo) {
		this.batchNo = batchNo;
	}

	public Integer getSubBatchNo() {
		return subBatchNo;
	}

	public void setSubBatchNo(Integer subBatchNo) {
		this.subBatchNo = subBatchNo;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public Date getRefundRequestDt() {
		return refundRequestDt;
	}

	public void setRefundRequestDt(Date refundRequestDt) {
		this.refundRequestDt = refundRequestDt;
	}

	public Date getDesignatedRefundeeDob() {
		return designatedRefundeeDob;
	}

	public void setDesignatedRefundeeDob(Date designatedRefundeeDob) {
		this.designatedRefundeeDob = designatedRefundeeDob;
	}

	public Date getRefundProcessDt() {
		return refundProcessDt;
	}

	public void setRefundProcessDt(Date refundProcessDt) {
		this.refundProcessDt = refundProcessDt;
	}

	public Date getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
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

	public String getAppIdNo() {
		return appIdNo;
	}

	public void setAppIdNo(String appIdNo) {
		this.appIdNo = appIdNo;
	}

	public AlsSessionTransIdPk getAstIdPk() {
		return astIdPk;
	}

	public void setAstIdPk(AlsSessionTransIdPk astIdPk) {
		this.astIdPk = astIdPk;
	}

	private AlsSessionTransIdPk astIdPk;
	

	
}
