package fwp.alsaccount.dto.sabhrs;

import fwp.alsaccount.dao.sabhrs.AlsTransactionGrpStatus;

public class AlsTransactionGrpStatusDTO extends AlsTransactionGrpStatus {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String desc;
	private Integer createYear;

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
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the createYear
	 */
	public Integer getCreateYear() {
		return createYear;
	}
	/**
	 * @param createYear the createYear to set
	 */
	public void setCreateYear(Integer createYear) {
		this.createYear = createYear;
	}

}
