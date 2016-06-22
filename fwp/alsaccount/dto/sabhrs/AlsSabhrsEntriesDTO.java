package fwp.alsaccount.dto.sabhrs;

import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries;

public class AlsSabhrsEntriesDTO extends AlsSabhrsEntries{
	
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
