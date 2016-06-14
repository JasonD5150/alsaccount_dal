package fwp.alsaccount.admin.dto;

import fwp.alsaccount.hibernate.dao.AlsNonAlsTemplate;

public class AlsNonAlsTemplateDTO extends AlsNonAlsTemplate {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private String anatCrJournalLineRefrDesc;
	private String anatDrJournalLineRefrDesc;

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
