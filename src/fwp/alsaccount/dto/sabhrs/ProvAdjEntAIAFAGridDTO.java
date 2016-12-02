package fwp.alsaccount.dto.sabhrs;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import fwp.als.hibernate.item.dao.AlsItemApplFeeAcctIdPk;

public class ProvAdjEntAIAFAGridDTO extends AlsItemApplFeeAcctIdPk implements Serializable{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private Date billingFrom;
	private Date billingTo;
	private Integer itemTypeCd;
	private String itemTypeDesc;
	private Date voidDt;
	private Double prevAmt;
	
	public Date getBillingFrom() {
		return billingFrom;
	}
	public void setBillingFrom(Date billingFrom) {
		this.billingFrom = billingFrom;
	}
	public Date getBillingTo() {
		return billingTo;
	}
	public void setBillingTo(Date billingTo) {
		this.billingTo = billingTo;
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
	public Date getVoidDt() {
		return voidDt;
	}
	public void setVoidDt(Date voidDt) {
		this.voidDt = voidDt;
	}
	public Double getPrevAmt() {
		return prevAmt;
	}
	public void setPrevAmt(Double prevAmt) {
		this.prevAmt = prevAmt;
	}
	
}
