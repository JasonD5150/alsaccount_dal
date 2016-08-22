package fwp.alsaccount.dto.sabhrs;

import java.util.Date;

public class InternalProviderTdtDTO {
	
	private Date bpe;
	private Integer provNo;
	private Integer bankCd;
	private String depId;
	private Date depDt;
	private Double depAmt;
	private String bankNm;
	private String businessNm;
	private String businessUnit;
	
	public Date getBpe() {
		return bpe;
	}
	public void setBpe(Date bpe) {
		this.bpe = bpe;
	}
	public Integer getProvNo() {
		return provNo;
	}
	public void setProvNo(Integer provNo) {
		this.provNo = provNo;
	}
	public Integer getBankCd() {
		return bankCd;
	}
	public void setBankCd(Integer bankCd) {
		this.bankCd = bankCd;
	}
	public Date getDepDt() {
		return depDt;
	}
	public void setDepDt(Date depDt) {
		this.depDt = depDt;
	}
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public Double getDepAmt() {
		return depAmt;
	}
	public void setDepAmt(Double depAmt) {
		this.depAmt = depAmt;
	}
	public String getBankNm() {
		return bankNm;
	}
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	public String getBusinessNm() {
		return businessNm;
	}
	public void setBusinessNm(String businessNm) {
		this.businessNm = businessNm;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
}
