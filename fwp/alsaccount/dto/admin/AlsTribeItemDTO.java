package fwp.alsaccount.dto.admin;

import java.sql.Date;

public class AlsTribeItemDTO {
	
	private String itemKey;
	private String aitTypeDesc;
	private Date aictUsagePeriodFrom;
	private Date aictUsagePeriodTo;
	private String aictItemTypeCd;
	
	public String getItemKey() {
		return itemKey;
	}
	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}
	public String getAitTypeDesc() {
		return aitTypeDesc;
	}
	public void setAitTypeDesc(String aitTypeDesc) {
		this.aitTypeDesc = aitTypeDesc;
	}
	public Date getAictUsagePeriodFrom() {
		return aictUsagePeriodFrom;
	}
	public void setAictUsagePeriodFrom(Date aictUsagePeriodFrom) {
		this.aictUsagePeriodFrom = aictUsagePeriodFrom;
	}
	public Date getAictUsagePeriodTo() {
		return aictUsagePeriodTo;
	}
	public void setAictUsagePeriodTo(Date aictUsagePeriodTo) {
		this.aictUsagePeriodTo = aictUsagePeriodTo;
	}
	public String getAictItemTypeCd() {
		return aictItemTypeCd;
	}
	public void setAictItemTypeCd(String aictItemTypeCd) {
		this.aictItemTypeCd = aictItemTypeCd;
	}
}
