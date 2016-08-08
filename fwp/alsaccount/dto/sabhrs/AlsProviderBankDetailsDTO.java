package fwp.alsaccount.dto.sabhrs;

import fwp.alsaccount.dao.sabhrs.AlsProviderBankDetails;

public class AlsProviderBankDetailsDTO extends AlsProviderBankDetails{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private Integer providerNo;
	private String providerName;
	private String bankName;
	
	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
	public Integer getProviderNo() {
		return providerNo;
	}
	public void setProviderNo(Integer providerNo) {
		this.providerNo = providerNo;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
