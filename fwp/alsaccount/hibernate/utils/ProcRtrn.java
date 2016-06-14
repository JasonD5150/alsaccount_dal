package fwp.alsaccount.hibernate.utils;

import java.io.Serializable;
import java.util.List;


public class ProcRtrn implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String procStatus;
    private String procMsg;
    private String fieldName;
    private String newInd="N";
	/* This field is used to identify the field name to use in a warning-confirmation scenario.  For example,
		a form may validate that the city, state, and zip combination is valid in the ALS_ZIP_CODES table.  If the
		combination is not valid, the use is warned.  If the user accepts the warning, the confirmedFieldName will
		contain the form field that captured the acceptance.
	 */
	private String confirmedFieldName;
    
    private List<ProcRtrn> procRtrnList;
    
    public ProcRtrn() {
    }

       public ProcRtrn(String procStatus, String procMsg) {
              this.procStatus = procStatus;
              this.procMsg = procMsg;
       }

	/**
	 * @return the procStatus
	 */
	public String getProcStatus() {
		return procStatus;
	}

	/**
	 * @param procStatus the procStatus to set
	 */
	public void setProcStatus(String procStatus) {
		this.procStatus = procStatus;
	}

	/**
	 * @return the procMsg
	 */
	public String getProcMsg() {
		return procMsg;
	}

	/**
	 * @param procMsg the procMsg to set
	 */
	public void setProcMsg(String procMsg) {
		this.procMsg = procMsg;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public List<ProcRtrn> getProcRtrnList() {
		return procRtrnList;
	}

	public void setProcRtrnList(List<ProcRtrn> procRtrnList) {
		this.procRtrnList = procRtrnList;
	}

	public String getNewInd() {
		return newInd;
	}

	public void setNewInd(String newInd) {
		this.newInd = newInd;
	}

	public String getConfirmedFieldName() {
		return confirmedFieldName;
	}

	public void setConfirmedFieldName(String confirmedFieldName) {
		this.confirmedFieldName = confirmedFieldName;
	}
}
