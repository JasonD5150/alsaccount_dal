package fwp.alsaccount.dto.admin;

import fwp.alsaccount.dao.admin.AlsNonAlsOrgControl;

public class AlsNonAlsOrgControlDTO extends AlsNonAlsOrgControl {
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String apiProviderName;
	
	public String getApiProviderName() {
		return apiProviderName;
	}
	public void setApiProviderName(String apiProviderName) {
		this.apiProviderName = apiProviderName;
	}
}
