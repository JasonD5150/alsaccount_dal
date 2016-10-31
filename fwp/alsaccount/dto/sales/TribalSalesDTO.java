package fwp.alsaccount.dto.sales;

import java.io.Serializable;
import java.util.Date;

public class TribalSalesDTO implements Serializable{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String tribeCd;
	private String tribeNm;
	private Date eftDepDeadline;
	private String dueTo;
	private Date bpEndDt;
	private Integer provNo;
	private String provNm;
	private Integer itemTypeCd;
	private String itemTypeDesc;
	private Integer salesCount;
	private Double salesAmt;
	private Double adjEntries;
	private Double netAmt;
	
	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
	public String getTribeCd() {
		return tribeCd;
	}
	public void setTribeCd(String tribeCd) {
		this.tribeCd = tribeCd;
	}
	public String getTribeNm() {
		return tribeNm;
	}
	public void setTribeNm(String tribeNm) {
		this.tribeNm = tribeNm;
	}
	public Date getEftDepDeadline() {
		return eftDepDeadline;
	}
	public void setEftDepDeadline(Date eftDepDeadline) {
		this.eftDepDeadline = eftDepDeadline;
	}
	public String getDueTo() {
		return dueTo;
	}
	public void setDueTo(String dueTo) {
		this.dueTo = dueTo;
	}
	public Date getBpEndDt() {
		return bpEndDt;
	}
	public void setBpEndDt(Date bpEndDt) {
		this.bpEndDt = bpEndDt;
	}
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
	public Integer getSalesCount() {
		return salesCount;
	}
	public void setSalesCount(Integer salesCount) {
		this.salesCount = salesCount;
	}
	public Double getSalesAmt() {
		return salesAmt;
	}
	public void setSalesAmt(Double salesAmt) {
		this.salesAmt = salesAmt;
	}
	public Double getAdjEntries() {
		return adjEntries;
	}
	public void setAdjEntries(Double adjEntries) {
		this.adjEntries = adjEntries;
	}
	public Double getNetAmt() {
		return netAmt;
	}
	public void setNetAmt(Double netAmt) {
		this.netAmt = netAmt;
	}
}
