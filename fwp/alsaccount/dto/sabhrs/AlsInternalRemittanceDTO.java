package fwp.alsaccount.dto.sabhrs;

import java.util.Date;

import fwp.als.hibernate.inventory.dao.AlsInternalRemittance;


public class AlsInternalRemittanceDTO extends AlsInternalRemittance{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;

	/*IDPK*/
	private Integer apiProviderNo;
	private Date   airBillingFrom;
	private Date   airBillingTo;
	
	private String provNm;
	private String intFileGenerated;
	private String billingBallanced;
	private Date   intFileCreateDt;
	private Double airTotSales;
	private Double totFundsRec;
	private Double airDifference;
	private Double amtDue;
	private Double amtRec;
	private Double totBankDep;
	private Double netOverShortOfSales;
	
	private Date eftddd;
	private Date completeProvider;
	private Date offlnPaymentAppDt;
	private Date bankDeptAppDt;
	private String bankDepEditOnly;
	
	public Integer getApiProviderNo() {
		return apiProviderNo;
	}
	public void setApiProviderNo(Integer apiProviderNo) {
		this.apiProviderNo = apiProviderNo;
	}
	public Date getAirBillingFrom() {
		return airBillingFrom;
	}
	public void setAirBillingFrom(Date airBillingFrom) {
		this.airBillingFrom = airBillingFrom;
	}
	public Date getAirBillingTo() {
		return airBillingTo;
	}
	public void setAirBillingTo(Date airBillingTo) {
		this.airBillingTo = airBillingTo;
	}
	public String getProvNm() {
		return provNm;
	}
	public void setProvNm(String provNm) {
		this.provNm = provNm;
	}
	public Date getEftddd() {
		return eftddd;
	}
	public void setEftddd(Date eftddd) {
		this.eftddd = eftddd;
	}
	public Date getCompleteProvider() {
		return completeProvider;
	}
	public void setCompleteProvider(Date completeProvider) {
		this.completeProvider = completeProvider;
	}
	public Date getOfflnPaymentAppDt() {
		return offlnPaymentAppDt;
	}
	public void setOfflnPaymentAppDt(Date offlnPaymentAppDt) {
		this.offlnPaymentAppDt = offlnPaymentAppDt;
	}
	public Date getBankDeptAppDt() {
		return bankDeptAppDt;
	}
	public void setBankDeptAppDt(Date bankDeptAppDt) {
		this.bankDeptAppDt = bankDeptAppDt;
	}
	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
	public Double getAmtDue() {
		return amtDue;
	}
	public void setAmtDue(Double amtDue) {
		this.amtDue = amtDue;
	}
	public Double getAmtRec() {
		return amtRec;
	}
	public void setAmtRec(Double amtRec) {
		this.amtRec = amtRec;
	}
	public Double getTotBankDep() {
		return totBankDep;
	}
	public void setTotBankDep(Double totBankDep) {
		this.totBankDep = totBankDep;
	}
	public Date getIntFileCreateDt() {
		return intFileCreateDt;
	}
	public void setIntFileCreateDt(Date intFileCreateDt) {
		this.intFileCreateDt = intFileCreateDt;
	}
	public String getBillingBallanced() {
		return billingBallanced;
	}
	public void setBillingBallanced(String billingBallanced) {
		this.billingBallanced = billingBallanced;
	}
	public Double getAirTotSales() {
		return airTotSales;
	}
	public void setAirTotSales(Double airTotSales) {
		this.airTotSales = airTotSales;
	}
	public Double getTotFundsRec() {
		return totFundsRec;
	}
	public void setTotFundsRec(Double totFundsRec) {
		this.totFundsRec = totFundsRec;
	}
	public Double getAirDifference() {
		return airDifference;
	}
	public void setAirDifference(Double airDifference) {
		this.airDifference = airDifference;
	}
	public Double getNetOverShortOfSales() {
		return netOverShortOfSales;
	}
	public void setNetOverShortOfSales(Double netOverShortOfSales) {
		this.netOverShortOfSales = netOverShortOfSales;
	}
	public String getIntFileGenerated() {
		return intFileGenerated;
	}
	public void setIntFileGenerated(String intFileGenerated) {
		this.intFileGenerated = intFileGenerated;
	}
	public String getBankDepEditOnly() {
		return bankDepEditOnly;
	}
	public void setBankDepEditOnly(String bankDepEditOnly) {
		this.bankDepEditOnly = bankDepEditOnly;
	}
	
}
