package fwp.alsaccount.dto.admin;

import java.sql.Date;

import fwp.als.hibernate.admin.dao.AlsRefundInfo;
import fwp.als.hibernate.admin.dao.AlsSessionTransIdPk;

public class PersonRefundAppDTO extends AlsRefundInfo {
	
	private static final long serialVersionUID = -9176775350279011645L;
	private String gridKey;

	private String refundeeName;
	private Date usagePeriodFrom;
	private Date usagePeriodTo;
	private Integer itemTypeCd;
	private String itemTypeDesc;
	private String itemIndDesc;
	private String reasonDesc;
	private Integer batchNo;
	private Integer subBatchNo;
	private String appType;
	private Date refundRequestDt;
	

	private AlsSessionTransIdPk astIdPk;
	
	/**
	 * @return the gridKey
	 */
	public String getGridKey() {
		return gridKey;
	}
	
	/**
	 * @param gridKey the gridKey to set
	 */
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}

	public AlsSessionTransIdPk getAstIdPk() {
		return astIdPk;
	}

	public void setAstIdPk(AlsSessionTransIdPk astIdPk) {
		this.astIdPk = astIdPk;
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

	public Integer getItemTypeCd() {
		return itemTypeCd;
	}

	public void setItemTypeCd(Integer itemTypeCd) {
		this.itemTypeCd = itemTypeCd;
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

	public Date getRefundRequestDt() {
		return refundRequestDt;
	}

	public void setRefundRequestDt(Date refundRequestDt) {
		this.refundRequestDt = refundRequestDt;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}
	
	
}
