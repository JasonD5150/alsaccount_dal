package fwp.alsaccount.dto.admin;

import fwp.als.hibernate.admin.dao.AlsActivityAccountLinkage;

public class AlsActivityAccountLinkageDTO extends AlsActivityAccountLinkage {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String sysActTypeTransCd;

	public String getGridKey() {
		return gridKey;
	}
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
