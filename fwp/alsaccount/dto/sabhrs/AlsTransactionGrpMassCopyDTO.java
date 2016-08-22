package fwp.alsaccount.dto.sabhrs;
import java.io.Serializable;
import java.sql.Date;

public class AlsTransactionGrpMassCopyDTO implements Serializable{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private Integer providerNo;
	private String providerName;
	private Date bpe;
	private Double atgsNetDrCr;
	private String remPerStat;

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
	public Date getBpe() {
		return bpe;
	}
	public void setBpe(Date bpe) {
		this.bpe = bpe;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Double getAtgsNetDrCr() {
		return atgsNetDrCr;
	}
	public void setAtgsNetDrCr(Double atgsNetDrCr) {
		this.atgsNetDrCr = atgsNetDrCr;
	}
	public String getRemPerStat() {
		return remPerStat;
	}
	public void setRemPerStat(String remPerStat) {
		this.remPerStat = remPerStat;
	}
}
