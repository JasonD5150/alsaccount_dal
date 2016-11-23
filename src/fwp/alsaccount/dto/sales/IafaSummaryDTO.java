package fwp.alsaccount.dto.sales;

import java.io.Serializable;
import java.util.Date;

public class IafaSummaryDTO implements Serializable{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private Integer provNo;
	private Integer itemTypeCd;
	private String itemTypeDesc;
	private Integer amtType;
	private String amtTypeDesc;
	private Double amount;
	private Date upFromDt;
	private Date upToDt;
	private String resStatus;
	private Integer processTypeCd;
	private String processTypeDesc;
	private Integer procCatCd;
	private String procCatDesc;
	private String appTypeCd;
	private String provNm;
	private Integer count;
	
	
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
	public Integer getProcessTypeCd() {
		return processTypeCd;
	}
	public void setProcessTypeCd(Integer processTypeCd) {
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
	public String getAppTypeCd() {
		return appTypeCd;
	}
	public void setAppTypeCd(String appTypeCd) {
		this.appTypeCd = appTypeCd;
	}
	public String getAmtTypeDesc() {
		return amtTypeDesc;
	}
	public void setAmtTypeDesc(String amtTypeDesc) {
		this.amtTypeDesc = amtTypeDesc;
	}
	public String getProcessTypeDesc() {
		return processTypeDesc;
	}
	public void setProcessTypeDesc(String processTypeDesc) {
		this.processTypeDesc = processTypeDesc;
	}
	
}
