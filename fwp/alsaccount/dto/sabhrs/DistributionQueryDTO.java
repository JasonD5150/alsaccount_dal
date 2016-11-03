package fwp.alsaccount.dto.sabhrs;

import java.io.Serializable;
import java.sql.Date;

import fwp.alsaccount.dao.sabhrs.AlsSabhrsEntries;


public class DistributionQueryDTO extends AlsSabhrsEntries implements Serializable{
	
	private static final long serialVersionUID = 1570541485740048476L;
	private String gridKey;
	private Date asSessionDt;
	private Integer itemTypeCode;
	private String itemDesc;
	private Date upFrom;
	private Date upTo;
	private Date apiDob;
	private Integer apiAlsNo;
	private String apiResStatus;
	private String aiafaAppType;
	private String astRemarks;
	private Integer aiafaSeqNo;
	private String aseDrCrCd;
	private Integer aseSeqNo;
	
	public String getGridKey() {
		return gridKey;
	}
	public void setGridKey(String gridKey) {
		this.gridKey = gridKey;
	}
	public Date getAsSessionDt() {
		return asSessionDt;
	}
	public void setAsSessionDt(Date asSessionDt) {
		this.asSessionDt = asSessionDt;
	}
	public Integer getItemTypeCode() {
		return itemTypeCode;
	}
	public void setItemTypeCode(Integer itemTypeCode) {
		this.itemTypeCode = itemTypeCode;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public Date getUpFrom() {
		return upFrom;
	}
	public void setUpFrom(Date upFrom) {
		this.upFrom = upFrom;
	}
	public Date getUpTo() {
		return upTo;
	}
	public void setUpTo(Date upTo) {
		this.upTo = upTo;
	}
	public Date getApiDob() {
		return apiDob;
	}
	public void setApiDob(Date apiDob) {
		this.apiDob = apiDob;
	}
	public Integer getApiAlsNo() {
		return apiAlsNo;
	}
	public void setApiAlsNo(Integer apiAlsNo) {
		this.apiAlsNo = apiAlsNo;
	}
	public String getApiResStatus() {
		return apiResStatus;
	}
	public void setApiResStatus(String apiResStatus) {
		this.apiResStatus = apiResStatus;
	}
	public String getAiafaAppType() {
		return aiafaAppType;
	}
	public void setAiafaAppType(String aiafaAppType) {
		this.aiafaAppType = aiafaAppType;
	}
	public String getAstRemarks() {
		return astRemarks;
	}
	public void setAstRemarks(String astRemarks) {
		this.astRemarks = astRemarks;
	}
	public Integer getAiafaSeqNo() {
		return aiafaSeqNo;
	}
	public void setAiafaSeqNo(Integer aiafaSeqNo) {
		this.aiafaSeqNo = aiafaSeqNo;
	}
	public String getAseDrCrCd() {
		return aseDrCrCd;
	}
	public void setAseDrCrCd(String aseDrCrCd) {
		this.aseDrCrCd = aseDrCrCd;
	}
	public Integer getAseSeqNo() {
		return aseSeqNo;
	}
	public void setAseSeqNo(Integer aseSeqNo) {
		this.aseSeqNo = aseSeqNo;
	}
}
