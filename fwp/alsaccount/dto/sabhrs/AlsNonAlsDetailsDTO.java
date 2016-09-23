package fwp.alsaccount.dto.sabhrs;

import fwp.als.hibernate.inventory.dao.AlsNonAlsDetails;

public class AlsNonAlsDetailsDTO extends AlsNonAlsDetails {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;

	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
}
