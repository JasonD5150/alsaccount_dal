package fwp.alsaccount.dto.admin;

import fwp.als.hibernate.admin.dao.AlsSysActivityTypeTranCds;

public class AlsSysActivityTypeTranCdsDTO extends AlsSysActivityTypeTranCds {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;

	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
}
