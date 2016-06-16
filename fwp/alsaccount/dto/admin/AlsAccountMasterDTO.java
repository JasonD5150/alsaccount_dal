package fwp.alsaccount.dto.admin;

import fwp.alsaccount.dao.admin.AlsAccountMaster;

public class AlsAccountMasterDTO extends AlsAccountMaster {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;

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

}
