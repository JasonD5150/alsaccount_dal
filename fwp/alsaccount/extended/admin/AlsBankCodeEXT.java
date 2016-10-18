package fwp.alsaccount.extended.admin;

import fwp.alsaccount.dao.admin.AlsBankCode;



public class AlsBankCodeEXT extends AlsBankCode{
	/**
	 * Used to display username from id
	 */
	private static final long serialVersionUID = 9008355421376273281L;
	private String updatedUsername;

	public String getUpdatedUsername() {
		return updatedUsername;
	}

	public void setUpdatedUsername(String updatedUsername) {
		this.updatedUsername = updatedUsername;
	}
	
	

}
