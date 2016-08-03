package fwp.alsaccount.extended;






import fwp.alsaccount.dao.admin.AlsTribeItemInfo;




public class AlsItemControlTableExt extends AlsTribeItemInfo{
	

	private static final long serialVersionUID = 2645957328124022890L;
	private String aitTypeDesc;
	
	

	public AlsItemControlTableExt(){
		super();
		aitTypeDesc = null;
	}
	

	public AlsItemControlTableExt(String aitTypeDesc){
		super();
		this.aitTypeDesc = aitTypeDesc;
	}
	
	
	public String getAitTypeDesc() {
		return aitTypeDesc;
	}
	public void setAitTypeDesc(String aitTypeDesc) {
		this.aitTypeDesc = aitTypeDesc;
	}





}
