package fwp.alsaccount.dto.sabhrs;

import java.io.Serializable;
import java.util.Date;

public class IafaSummaryDTO implements Serializable{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private Integer itemTypeCd;
	private String itemTypeDesc;
	private String processTypeCd;
	private Integer count;
	private Double amount;
	private String costGrpDesc;
	private String prereqCostDesc;
	private Integer aiafaSeqNo;
	private Integer provNo;
	private String provNm;
	private Date bpFromDt;
	private Date bpToDt;
	private Date upFromDt;
	private Date upToDt;
	private Integer procCatCd;
	private String procCatDesc;
	private String deviceNo;
	private Integer amtType;
	private String resStatus;
	private String resCostGrpDesc;
	private String resPrereqCostDesc;
	private Integer resCount;
	private Double resAmount;
	private String nonResCostGrpDesc;
	private String nonResPrereqCostDesc;
	private Integer nonResCount;
	private Double nonResAmount;
	private Integer totalCount;
	private Double totalAmount;
	
	
	public Integer getProvNo() {
		return provNo;
	}
	public void setProvNo(Integer provNo) {
		this.provNo = provNo;
	}
	public String getProvNm() {
		return provNm;
	}
	public void setProvNm(String provNm) {
		this.provNm = provNm;
	}
	public Date getBpFromDt() {
		return bpFromDt;
	}
	public void setBpFromDt(Date bpFromDt) {
		this.bpFromDt = bpFromDt;
	}
	public Date getBpToDt() {
		return bpToDt;
	}
	public void setBpToDt(Date bpToDt) {
		this.bpToDt = bpToDt;
	}
	public Date getUpFromDt() {
		return upFromDt;
	}
	public void setUpFromDt(Date upFromDt) {
		this.upFromDt = upFromDt;
	}
	public Date getUpToDt() {
		return upToDt;
	}
	public void setUpToDt(Date upToDt) {
		this.upToDt = upToDt;
	}
	public Integer getProcCatCd() {
		return procCatCd;
	}
	public void setProcCatCd(Integer procCatCd) {
		this.procCatCd = procCatCd;
	}
	public String getProcCatDesc() {
		return procCatDesc;
	}
	public void setProcCatDesc(String procCatDesc) {
		this.procCatDesc = procCatDesc;
	}
	public String getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	public Integer getAmtType() {
		return amtType;
	}
	public void setAmtType(Integer amtType) {
		this.amtType = amtType;
	}
	public String getResStatus() {
		return resStatus;
	}
	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}
	public Integer getAiafaSeqNo() {
		return aiafaSeqNo;
	}
	public void setAiafaSeqNo(Integer aiafaSeqNo) {
		this.aiafaSeqNo = aiafaSeqNo;
	}
	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
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
	public String getProcessTypeCd() {
		return processTypeCd;
	}
	public void setProcessTypeCd(String processTypeCd) {
		this.processTypeCd = processTypeCd;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCostGrpDesc() {
		return costGrpDesc;
	}
	public void setCostGrpDesc(String costGrpDesc) {
		this.costGrpDesc = costGrpDesc;
	}
	public String getPrereqCostDesc() {
		return prereqCostDesc;
	}
	public void setPrereqCostDesc(String prereqCostDesc) {
		this.prereqCostDesc = prereqCostDesc;
	}
	public String getResCostGrpDesc() {
		return resCostGrpDesc;
	}
	public void setResCostGrpDesc(String resCostGrpDesc) {
		this.resCostGrpDesc = resCostGrpDesc;
	}
	public String getResPrereqCostDesc() {
		return resPrereqCostDesc;
	}
	public void setResPrereqCostDesc(String resPrereqCostDesc) {
		this.resPrereqCostDesc = resPrereqCostDesc;
	}
	public Integer getResCount() {
		return resCount;
	}
	public void setResCount(Integer resCount) {
		this.resCount = resCount;
	}
	public Double getResAmount() {
		return resAmount;
	}
	public void setResAmount(Double resAmount) {
		this.resAmount = resAmount;
	}
	public String getNonResCostGrpDesc() {
		return nonResCostGrpDesc;
	}
	public void setNonResCostGrpDesc(String nonResCostGrpDesc) {
		this.nonResCostGrpDesc = nonResCostGrpDesc;
	}
	public String getNonResPrereqCostDesc() {
		return nonResPrereqCostDesc;
	}
	public void setNonResPrereqCostDesc(String nonResPrereqCostDesc) {
		this.nonResPrereqCostDesc = nonResPrereqCostDesc;
	}
	public Integer getNonResCount() {
		return nonResCount;
	}
	public void setNonResCount(Integer nonResCount) {
		this.nonResCount = nonResCount;
	}
	public Double getNonResAmount() {
		return nonResAmount;
	}
	public void setNonResAmount(Double nonResAmount) {
		this.nonResAmount = nonResAmount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
