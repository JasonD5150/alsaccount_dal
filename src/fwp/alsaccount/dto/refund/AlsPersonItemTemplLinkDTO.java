package fwp.alsaccount.dto.refund;

import fwp.alsaccount.dao.refund.AlsPersonItemTemplLink;

/**
 * @author jljdavidson on 12/15/16.
 */
public class AlsPersonItemTemplLinkDTO extends AlsPersonItemTemplLink {
	private String appTypeCodeDescription;
	private String itemTypeCodeDescription;

	public String getAppTypeCodeDescription() {
		return appTypeCodeDescription;
	}

	public void setAppTypeCodeDescription(String appTypeCodeDescription) {
		this.appTypeCodeDescription = appTypeCodeDescription;
	}

	public String getItemTypeCodeDescription() {
		return itemTypeCodeDescription;
	}

	public void setItemTypeCodeDescription(String itemTypeCodeDescription) {
		this.itemTypeCodeDescription = itemTypeCodeDescription;
	}
}
