package fwp.alsaccount.admin.dto;

import fwp.alsaccount.hibernate.dao.AlsSysActivityTypeTranCds;

public class AlsSysActivityTypeTranCdsDTO extends AlsSysActivityTypeTranCds {
	
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
