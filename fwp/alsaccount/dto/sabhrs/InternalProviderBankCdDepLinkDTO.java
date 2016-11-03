package fwp.alsaccount.dto.sabhrs;

import java.util.Date;

import fwp.alsaccount.dao.sabhrs.AlsProviderBankDetails;

public class InternalProviderBankCdDepLinkDTO extends AlsProviderBankDetails{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String bankName;
	private Date   deadlineDate;
	private Double amtDue;
	private Date apbdBillingTo;
	private Date billingFrom;
	private Date depositDate;
	private Boolean hasDepositSlip;
	
	
	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Double getAmtDue() {
		return amtDue;
	}
	public void setAmtDue(Double amtDue) {
		this.amtDue = amtDue;
	}
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public Date getApbdBillingTo() {
		return apbdBillingTo;
	}
	public void setApbdBillingTo(Date apbdBillingTo) {
		this.apbdBillingTo = apbdBillingTo;
	}
	public Date getBillingFrom() {
		return billingFrom;
	}
	public void setBillingFrom(Date billingFrom) {
		this.billingFrom = billingFrom;
	}
	public Date getDepositDate() {
		return depositDate;
	}
	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}
	public Boolean getHasDepositSlip() {
		return hasDepositSlip;
	}
	public void setHasDepositSlip(Boolean hasDepositSlip) {
		this.hasDepositSlip = hasDepositSlip;
	}

}
