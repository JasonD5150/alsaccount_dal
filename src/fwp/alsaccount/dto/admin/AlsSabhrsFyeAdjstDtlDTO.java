package fwp.alsaccount.dto.admin;

import fwp.alsaccount.dao.admin.AlsSabhrsFyeAdjstDtl;

public class AlsSabhrsFyeAdjstDtlDTO extends AlsSabhrsFyeAdjstDtl {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;

	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
}
