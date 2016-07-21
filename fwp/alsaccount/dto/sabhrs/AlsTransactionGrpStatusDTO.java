package fwp.alsaccount.dto.sabhrs;

import fwp.alsaccount.dao.sabhrs.AlsTransactionGrpStatus;

public class AlsTransactionGrpStatusDTO extends AlsTransactionGrpStatus {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String desc;
	private Integer createYear;
	private Integer programYear;
	private Integer budgYear;


	public String getGridKey() {
		return gridKey;
	}

	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getCreateYear() {
		return createYear;
	}

	public void setCreateYear(Integer createYear) {
		this.createYear = createYear;
	}

	public Integer getProgramYear() {
		return programYear;
	}
	
	public void setProgramYear(Integer programYear) {
		this.programYear = programYear;
	}
	
	public Integer getBudgYear() {
		return budgYear;
	}
	
	public void setBudgYear(Integer budgYear) {
		this.budgYear = budgYear;
	}

}
