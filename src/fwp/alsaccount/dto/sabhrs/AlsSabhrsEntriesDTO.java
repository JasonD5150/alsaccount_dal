package fwp.alsaccount.dto.sabhrs;

import java.util.Date;

import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries;

public class AlsSabhrsEntriesDTO extends AlsSabhrsEntries{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private Date aseWhenEntryPosted;
	private Integer aseSeqNo;
	private String aseDrCrCd;
	private Integer aseTxnCdSeqNo;
	private String gridKey;
	private Date bpFromDt;
	private Date bpToDt;
	private Date upToSummDt;
	private String jlr;
	private String sumStat;
	private String intStat;

	public Date getUpToSummDt() {
		return upToSummDt;
	}
	public String getSumStat() {
		return sumStat;
	}
	public void setSumStat(String sumStat) {
		this.sumStat = sumStat;
	}
	public String getIntStat() {
		return intStat;
	}
	public void setIntStat(String intStat) {
		this.intStat = intStat;
	}
	public void setUpToSummDt(Date upToSummDt) {
		this.upToSummDt = upToSummDt;
	}
	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
	public Date getBpFromDt() {
		return bpFromDt;
	}
	public void setBpFromDt(Date bpFromDt) {
		this.bpFromDt = bpFromDt;
	}
	public Date getBpToDt() {
		return bpToDt;
	}
	public void setBpToDt(Date bpToDt) {
		this.bpToDt = bpToDt;
	}
	public String getJlr() {
		return jlr;
	}
	public void setJlr(String jlr) {
		this.jlr = jlr;
	}
	public Date getAseWhenEntryPosted() {
		return aseWhenEntryPosted;
	}
	public void setAseWhenEntryPosted(Date aseWhenEntryPosted) {
		this.aseWhenEntryPosted = aseWhenEntryPosted;
	}
	public Integer getAseSeqNo() {
		return aseSeqNo;
	}
	public void setAseSeqNo(Integer aseSeqNo) {
		this.aseSeqNo = aseSeqNo;
	}
	public String getAseDrCrCd() {
		return aseDrCrCd;
	}
	public void setAseDrCrCd(String aseDrCrCd) {
		this.aseDrCrCd = aseDrCrCd;
	}
	public Integer getAseTxnCdSeqNo() {
		return aseTxnCdSeqNo;
	}
	public void setAseTxnCdSeqNo(Integer aseTxnCdSeqNo) {
		this.aseTxnCdSeqNo = aseTxnCdSeqNo;
	}
}
