package fwp.alsaccount.admin.dto;

import fwp.alsaccount.hibernate.dao.AlsSysActivityControl;

public class AlsSysActivityControlDTO extends AlsSysActivityControl {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String sysActivityTypeDesc;
	private String sysTranCodeDesc;
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
	public String getSysActivityTypeDesc() {
		return sysActivityTypeDesc;
	}
	public void setSysActivityTypeDesc(String sysActivityTypeDesc) {
		this.sysActivityTypeDesc = sysActivityTypeDesc;
	}
	public String getSysTranCodeDesc() {
		return sysTranCodeDesc;
	}
	public void setSysTranCodeDesc(String sysTranCodeDesc) {
		this.sysTranCodeDesc = sysTranCodeDesc;
	}
	
	

}
