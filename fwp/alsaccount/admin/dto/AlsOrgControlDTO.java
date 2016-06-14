package fwp.alsaccount.admin.dto;

import fwp.alsaccount.hibernate.dao.AlsOrgControl;

public class AlsOrgControlDTO extends AlsOrgControl {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String provRegion;
	private String provName;

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
	public String getProvRegion() {
		return provRegion;
	}
	public void setProvRegion(String provRegion) {
		this.provRegion = provRegion;
	}
	public String getProvName() {
		return provName;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}

}
