package fwp.alsaccount.appservice.admin;





import fwp.alsaccount.dao.admin.AlsBankCode;
import fwp.alsaccount.extended.admin.AlsBankCodeEXT;


public class AlsBankCodeExtAS {
	
	/**
	 * Converts an AlsBankCode to an AlsBankCodeEXT
	 * @param toConvert
	 * @return
	 */
	public AlsBankCodeEXT convertAlsBankCode(AlsBankCode toConvert) {
		
		AlsBankCodeEXT toReturn = new AlsBankCodeEXT();
		toReturn.setAbcAccountNo(toConvert.getAbcAccountNo());
		toReturn.setAbcActive(toConvert.getAbcActive());
		toReturn.setAbcAvblToAllProv(toConvert.getAbcAvblToAllProv());
		toReturn.setAbcBankCd(toConvert.getAbcBankCd());
		toReturn.setAbcBankNm(toConvert.getAbcBankNm());
		toReturn.setAbcCompanyId(toConvert.getAbcCompanyId());
		toReturn.setAbcCreatePersonid(toConvert.getAbcCreatePersonid());
		toReturn.setAbcWhenLog(toConvert.getAbcWhenLog());
		toReturn.setAbcWhoLog(toConvert.getAbcWhoLog());
		toReturn.setAzcCityNm(toConvert.getAzcCityNm());
		toReturn.setAzcZipCd(toConvert.getAzcZipCd());
		
		return toReturn;
}
}
