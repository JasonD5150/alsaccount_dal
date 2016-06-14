package fwp.alsaccount.admin.dto;

import fwp.alsaccount.hibernate.dao.AlsActivityAccountLinkage;


public class AlsActivityAccountLinkageDTO extends AlsActivityAccountLinkage {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String sysActTypeTransCd;
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
	public String getSysActTypeTransCd() {
		return sysActTypeTransCd;
	}
	public void setSysActTypeTransCd(String sysActTypeTransCd) {
		this.sysActTypeTransCd = sysActTypeTransCd;
	}
	

}
