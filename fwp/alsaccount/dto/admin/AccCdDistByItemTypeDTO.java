package fwp.alsaccount.dto.admin;

import fwp.als.hibernate.item.dao.AlsItemAccountTable;

public class AccCdDistByItemTypeDTO extends AlsItemAccountTable{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String itemTypeCd;
	private String itemTypeDesc;
	private String upFromDt;
	private String upToDt;
	private Double itemCost;
	private Integer costPrereq;
	private String costPrereqDesc;
	private String residency;
	private Integer budgYear;
	private String partialCost;
	private String drawFee;
	private String accCd;
	private Integer account;
	private Integer fund;
	private String balancing;
	private Double dist;
	private String subclass;
	private String org;
	private String orgMult;
	
	
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
	public String getUpFromDt() {
		return upFromDt;
	}
	public void setUpFromDt(String upFromDt) {
		this.upFromDt = upFromDt;
	}
	public String getUpToDt() {
		return upToDt;
	}
	public void setUpToDt(String upToDt) {
		this.upToDt = upToDt;
	}
	public Double getItemCost() {
		return itemCost;
	}
	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}
	public Integer getCostPrereq() {
		return costPrereq;
	}
	public void setCostPrereq(Integer costPrereq) {
		this.costPrereq = costPrereq;
	}
	public String getCostPrereqDesc() {
		return costPrereqDesc;
	}
	public void setCostPrereqDesc(String costPrereqDesc) {
		this.costPrereqDesc = costPrereqDesc;
	}
	public String getResidency() {
		return residency;
	}
	public void setResidency(String residency) {
		this.residency = residency;
	}
	public Integer getBudgYear() {
		return budgYear;
	}
	public void setBudgYear(Integer budgYear) {
		this.budgYear = budgYear;
	}
	public String getPartialCost() {
		return partialCost;
	}
	public void setPartialCost(String partialCost) {
		this.partialCost = partialCost;
	}
	public String getDrawFee() {
		return drawFee;
	}
	public void setDrawFee(String drawFee) {
		this.drawFee = drawFee;
	}
	public String getAccCd() {
		return accCd;
	}
	public void setAccCd(String accCd) {
		this.accCd = accCd;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	public Integer getFund() {
		return fund;
	}
	public void setFund(Integer fund) {
		this.fund = fund;
	}
	public String getBalancing() {
		return balancing;
	}
	public void setBalancing(String balancing) {
		this.balancing = balancing;
	}
	public String getSubclass() {
		return subclass;
	}
	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getOrgMult() {
		return orgMult;
	}
	public void setOrgMult(String orgMult) {
		this.orgMult = orgMult;
	}
	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
	public Double getDist() {
		return dist;
	}
	public void setDist(Double dist) {
		this.dist = dist;
	}
	
}
