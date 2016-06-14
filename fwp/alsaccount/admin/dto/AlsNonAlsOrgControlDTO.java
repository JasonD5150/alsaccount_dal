package fwp.alsaccount.admin.dto;

import fwp.alsaccount.hibernate.dao.AlsNonAlsOrgControl;

public class AlsNonAlsOrgControlDTO extends AlsNonAlsOrgControl {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String apiProviderName;
	
	/**
	 * @return the apiProviderName
	 */
	public String getApiProviderName() {
		return apiProviderName;
	}
	/**
	 * @param apiProviderName the apiProviderName to set
	 */
	public void setApiProviderName(String apiProviderName) {
		this.apiProviderName = apiProviderName;
	}


}
