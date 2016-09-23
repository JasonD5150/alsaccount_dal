package fwp.alsaccount.dto.sabhrs;

import fwp.alsaccount.dao.sabhrs.AlsOverUnderSalesDets;

public class AlsOverUnderSalesDetsDTO extends AlsOverUnderSalesDets {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;

	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
}
