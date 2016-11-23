package fwp.alsaccount.dto.admin;

import fwp.alsaccount.dao.admin.AlsNonAlsTemplate;

public class AlsNonAlsTemplateDTO extends AlsNonAlsTemplate {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String anatCrJournalLineRefrDesc;
	private String anatDrJournalLineRefrDesc;

	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
	public String getAnatCrJournalLineRefrDesc() {
		return anatCrJournalLineRefrDesc;
	}
	public void setAnatCrJournalLineRefrDesc(String anatCrJournalLineRefrDesc) {
		this.anatCrJournalLineRefrDesc = anatCrJournalLineRefrDesc;
	}
	public String getAnatDrJournalLineRefrDesc() {
		return anatDrJournalLineRefrDesc;
	}
	public void setAnatDrJournalLineRefrDesc(String anatDrJournalLineRefrDesc) {
		this.anatDrJournalLineRefrDesc = anatDrJournalLineRefrDesc;
	}
}
