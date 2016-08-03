package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AlsItemControlTable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ALS_ITEM_CONTROL_TABLE", schema = "ALS")
public class AlsItemControlTable implements java.io.Serializable {

	// Fields

	private AlsItemControlTableIdPk idPk;
	private String aictLicensePermitFlag;
	private String aictTagFlag;
	private Integer aictReplacementLimit;
	private String aictClassificationInd;
	private String aictResidencyInd;
	private String aictDisplayOverrideInd;
	private Timestamp aictSeasonFromDt;
	private Timestamp aictSeasonToDt;
	private Integer aictMailExtPeriod;
	private String aictPersonTypeCd;
	private String aictMailListExclusionInd;
	private Timestamp aictUsageDeadline;
	private String aictItemQuotaInd;
	private String aictCombinItmQutResiInd;
	private String aictDrawInterimStatusInd;
	private Timestamp aictApplProcTimeLnFromDt;
	private Timestamp aictApplProcTimeLnToDt;
	private String aictPrepayApplFeeInd;
	private Double aictDrawFee;
	private Timestamp aictApplNotificationDt;
	private Timestamp aictItemIssueTimeLnFrmDt;
	private Timestamp aictItemIssueTimeLnToDt;
	private String aictCntrlFulfillmentInd;
	private String aictCntrlFulfillmentPrompt;
	private String aictReviewInterimStatusInd;
	private String aictReviewProgramNm;
	private String aictRevPrepayItemFeeInd;
	private Timestamp aictItemExchangeDeadline;
	private Integer aictPosPrntTemplCd;
	private Integer aictCentralPrntTemplCd;
	private Integer aictAppReceiptPrntTemplCd;
	private Integer aictPrinterPrintInd;
	private String aictSeparatePrintInd;
	private Integer aictNoPouchToBeHandedOut;
	private Integer aictPersonIdTemplateCd;
	private Double aictCommission;
	private String aictReplacementFeeInd;
	private String aictCombinationRequiredInd;
	private String aictOppTypeSpDtInd;
	private String aictItemTribalInd;
	private String aictResidencyDeclarationInd;
	private String aictExemptionInd;
	private String aictResidencySuppMatInd;
	private String aictReciprocityInd;
	private String aictValidAreaOppTInd;
	private String aictOppTypeDisplayPrompt;
	private Integer aictAppNoFromRange;
	private Integer aictAppNoToRange;
	private Integer aictItemOppNoFromRange;
	private Integer aictItemOppNoToRange;
	private String aictExchangeAllowedFor;
	private String aictWhoLog;
	private Timestamp aictWhenLog;
	private Integer aictExclusionTimePeriod;
	private String aictCombItemQuotaItemTyp;
	private String aictAppPartyInd;
	private Integer aictAppPartyLimit;
	private String aictBonusPointInd;
	private String aictPrefSponsorInd;
	private String aictDeerOnlyInd;
	private String aictFeeDonationInd;
	private Integer aictGroupLimit;
	private String aictAppPartyChoiceInd;
	private String aictSecondaryItem;
	private String aictViolationExclusion;
	private String aictRenewalAllowed;
	private Integer aictInternalReplLimit;
	private String aictRemarksInd;
	private String aictCentralPrintInd;
	private Integer aictDisabledQuota;
	private String aictDonationInd;
	private Double aictMinDonationAmt;
	private String aictDisplayOverrideTrnInd;
	private Integer aictNontypicalUsageLicYr;
	private String aictRefundDrawingItemFee;
	private Integer aictMaxCommItemsPerSess;
	private Timestamp aictReplacementFromDt;
	private String aictSpecialProcessInd;
	private String aictFeaturedItemDesc;
	private String aictFeaturedItemActive;
	private String aictDonationItemTypeCd;
	private String aictMrktgQuestion;
	private String aictDonateInd;

	// Constructors

	/** default constructor */
	public AlsItemControlTable() {
	}

	/** minimal constructor */
	public AlsItemControlTable(AlsItemControlTableIdPk idPk,
			String aictTagFlag, String aictClassificationInd,
			String aictResidencyInd, String aictDisplayOverrideInd,
			Integer aictMailExtPeriod, String aictPersonTypeCd,
			String aictMailListExclusionInd, String aictCombinItmQutResiInd,
			String aictDrawInterimStatusInd,
			Timestamp aictItemIssueTimeLnFrmDt,
			Timestamp aictItemIssueTimeLnToDt,
			String aictReviewInterimStatusInd, String aictItemTribalInd,
			String aictResidencyDeclarationInd, String aictResidencySuppMatInd,
			String aictReciprocityInd, String aictWhoLog,
			Timestamp aictWhenLog, String aictDisplayOverrideTrnInd) {
		this.idPk = idPk;
		this.aictTagFlag = aictTagFlag;
		this.aictClassificationInd = aictClassificationInd;
		this.aictResidencyInd = aictResidencyInd;
		this.aictDisplayOverrideInd = aictDisplayOverrideInd;
		this.aictMailExtPeriod = aictMailExtPeriod;
		this.aictPersonTypeCd = aictPersonTypeCd;
		this.aictMailListExclusionInd = aictMailListExclusionInd;
		this.aictCombinItmQutResiInd = aictCombinItmQutResiInd;
		this.aictDrawInterimStatusInd = aictDrawInterimStatusInd;
		this.aictItemIssueTimeLnFrmDt = aictItemIssueTimeLnFrmDt;
		this.aictItemIssueTimeLnToDt = aictItemIssueTimeLnToDt;
		this.aictReviewInterimStatusInd = aictReviewInterimStatusInd;
		this.aictItemTribalInd = aictItemTribalInd;
		this.aictResidencyDeclarationInd = aictResidencyDeclarationInd;
		this.aictResidencySuppMatInd = aictResidencySuppMatInd;
		this.aictReciprocityInd = aictReciprocityInd;
		this.aictWhoLog = aictWhoLog;
		this.aictWhenLog = aictWhenLog;
		this.aictDisplayOverrideTrnInd = aictDisplayOverrideTrnInd;
	}

	/** full constructor */
	public AlsItemControlTable(AlsItemControlTableIdPk idPk,
			String aictLicensePermitFlag, String aictTagFlag,
			Integer aictReplacementLimit, String aictClassificationInd,
			String aictResidencyInd, String aictDisplayOverrideInd,
			Timestamp aictSeasonFromDt, Timestamp aictSeasonToDt,
			Integer aictMailExtPeriod, String aictPersonTypeCd,
			String aictMailListExclusionInd, Timestamp aictUsageDeadline,
			String aictItemQuotaInd, String aictCombinItmQutResiInd,
			String aictDrawInterimStatusInd,
			Timestamp aictApplProcTimeLnFromDt,
			Timestamp aictApplProcTimeLnToDt, String aictPrepayApplFeeInd,
			Double aictDrawFee, Timestamp aictApplNotificationDt,
			Timestamp aictItemIssueTimeLnFrmDt,
			Timestamp aictItemIssueTimeLnToDt, String aictCntrlFulfillmentInd,
			String aictCntrlFulfillmentPrompt,
			String aictReviewInterimStatusInd, String aictReviewProgramNm,
			String aictRevPrepayItemFeeInd, Timestamp aictItemExchangeDeadline,
			Integer aictPosPrntTemplCd, Integer aictCentralPrntTemplCd,
			Integer aictAppReceiptPrntTemplCd, Integer aictPrinterPrintInd,
			String aictSeparatePrintInd, Integer aictNoPouchToBeHandedOut,
			Integer aictPersonIdTemplateCd, Double aictCommission,
			String aictReplacementFeeInd, String aictCombinationRequiredInd,
			String aictOppTypeSpDtInd, String aictItemTribalInd,
			String aictResidencyDeclarationInd, String aictExemptionInd,
			String aictResidencySuppMatInd, String aictReciprocityInd,
			String aictValidAreaOppTInd, String aictOppTypeDisplayPrompt,
			Integer aictAppNoFromRange, Integer aictAppNoToRange,
			Integer aictItemOppNoFromRange, Integer aictItemOppNoToRange,
			String aictExchangeAllowedFor, String aictWhoLog,
			Timestamp aictWhenLog, Integer aictExclusionTimePeriod,
			String aictCombItemQuotaItemTyp, String aictAppPartyInd,
			Integer aictAppPartyLimit, String aictBonusPointInd,
			String aictPrefSponsorInd, String aictDeerOnlyInd,
			String aictFeeDonationInd, Integer aictGroupLimit,
			String aictAppPartyChoiceInd, String aictSecondaryItem,
			String aictViolationExclusion, String aictRenewalAllowed,
			Integer aictInternalReplLimit, String aictRemarksInd,
			String aictCentralPrintInd, Integer aictDisabledQuota,
			String aictDonationInd, Double aictMinDonationAmt,
			String aictDisplayOverrideTrnInd, Integer aictNontypicalUsageLicYr,
			String aictRefundDrawingItemFee, Integer aictMaxCommItemsPerSess,
			Timestamp aictReplacementFromDt, String aictSpecialProcessInd,
			String aictFeaturedItemDesc, String aictFeaturedItemActive,
			String aictDonationItemTypeCd, String aictMrktgQuestion,
			String aictDonateInd) {
		this.idPk = idPk;
		this.aictLicensePermitFlag = aictLicensePermitFlag;
		this.aictTagFlag = aictTagFlag;
		this.aictReplacementLimit = aictReplacementLimit;
		this.aictClassificationInd = aictClassificationInd;
		this.aictResidencyInd = aictResidencyInd;
		this.aictDisplayOverrideInd = aictDisplayOverrideInd;
		this.aictSeasonFromDt = aictSeasonFromDt;
		this.aictSeasonToDt = aictSeasonToDt;
		this.aictMailExtPeriod = aictMailExtPeriod;
		this.aictPersonTypeCd = aictPersonTypeCd;
		this.aictMailListExclusionInd = aictMailListExclusionInd;
		this.aictUsageDeadline = aictUsageDeadline;
		this.aictItemQuotaInd = aictItemQuotaInd;
		this.aictCombinItmQutResiInd = aictCombinItmQutResiInd;
		this.aictDrawInterimStatusInd = aictDrawInterimStatusInd;
		this.aictApplProcTimeLnFromDt = aictApplProcTimeLnFromDt;
		this.aictApplProcTimeLnToDt = aictApplProcTimeLnToDt;
		this.aictPrepayApplFeeInd = aictPrepayApplFeeInd;
		this.aictDrawFee = aictDrawFee;
		this.aictApplNotificationDt = aictApplNotificationDt;
		this.aictItemIssueTimeLnFrmDt = aictItemIssueTimeLnFrmDt;
		this.aictItemIssueTimeLnToDt = aictItemIssueTimeLnToDt;
		this.aictCntrlFulfillmentInd = aictCntrlFulfillmentInd;
		this.aictCntrlFulfillmentPrompt = aictCntrlFulfillmentPrompt;
		this.aictReviewInterimStatusInd = aictReviewInterimStatusInd;
		this.aictReviewProgramNm = aictReviewProgramNm;
		this.aictRevPrepayItemFeeInd = aictRevPrepayItemFeeInd;
		this.aictItemExchangeDeadline = aictItemExchangeDeadline;
		this.aictPosPrntTemplCd = aictPosPrntTemplCd;
		this.aictCentralPrntTemplCd = aictCentralPrntTemplCd;
		this.aictAppReceiptPrntTemplCd = aictAppReceiptPrntTemplCd;
		this.aictPrinterPrintInd = aictPrinterPrintInd;
		this.aictSeparatePrintInd = aictSeparatePrintInd;
		this.aictNoPouchToBeHandedOut = aictNoPouchToBeHandedOut;
		this.aictPersonIdTemplateCd = aictPersonIdTemplateCd;
		this.aictCommission = aictCommission;
		this.aictReplacementFeeInd = aictReplacementFeeInd;
		this.aictCombinationRequiredInd = aictCombinationRequiredInd;
		this.aictOppTypeSpDtInd = aictOppTypeSpDtInd;
		this.aictItemTribalInd = aictItemTribalInd;
		this.aictResidencyDeclarationInd = aictResidencyDeclarationInd;
		this.aictExemptionInd = aictExemptionInd;
		this.aictResidencySuppMatInd = aictResidencySuppMatInd;
		this.aictReciprocityInd = aictReciprocityInd;
		this.aictValidAreaOppTInd = aictValidAreaOppTInd;
		this.aictOppTypeDisplayPrompt = aictOppTypeDisplayPrompt;
		this.aictAppNoFromRange = aictAppNoFromRange;
		this.aictAppNoToRange = aictAppNoToRange;
		this.aictItemOppNoFromRange = aictItemOppNoFromRange;
		this.aictItemOppNoToRange = aictItemOppNoToRange;
		this.aictExchangeAllowedFor = aictExchangeAllowedFor;
		this.aictWhoLog = aictWhoLog;
		this.aictWhenLog = aictWhenLog;
		this.aictExclusionTimePeriod = aictExclusionTimePeriod;
		this.aictCombItemQuotaItemTyp = aictCombItemQuotaItemTyp;
		this.aictAppPartyInd = aictAppPartyInd;
		this.aictAppPartyLimit = aictAppPartyLimit;
		this.aictBonusPointInd = aictBonusPointInd;
		this.aictPrefSponsorInd = aictPrefSponsorInd;
		this.aictDeerOnlyInd = aictDeerOnlyInd;
		this.aictFeeDonationInd = aictFeeDonationInd;
		this.aictGroupLimit = aictGroupLimit;
		this.aictAppPartyChoiceInd = aictAppPartyChoiceInd;
		this.aictSecondaryItem = aictSecondaryItem;
		this.aictViolationExclusion = aictViolationExclusion;
		this.aictRenewalAllowed = aictRenewalAllowed;
		this.aictInternalReplLimit = aictInternalReplLimit;
		this.aictRemarksInd = aictRemarksInd;
		this.aictCentralPrintInd = aictCentralPrintInd;
		this.aictDisabledQuota = aictDisabledQuota;
		this.aictDonationInd = aictDonationInd;
		this.aictMinDonationAmt = aictMinDonationAmt;
		this.aictDisplayOverrideTrnInd = aictDisplayOverrideTrnInd;
		this.aictNontypicalUsageLicYr = aictNontypicalUsageLicYr;
		this.aictRefundDrawingItemFee = aictRefundDrawingItemFee;
		this.aictMaxCommItemsPerSess = aictMaxCommItemsPerSess;
		this.aictReplacementFromDt = aictReplacementFromDt;
		this.aictSpecialProcessInd = aictSpecialProcessInd;
		this.aictFeaturedItemDesc = aictFeaturedItemDesc;
		this.aictFeaturedItemActive = aictFeaturedItemActive;
		this.aictDonationItemTypeCd = aictDonationItemTypeCd;
		this.aictMrktgQuestion = aictMrktgQuestion;
		this.aictDonateInd = aictDonateInd;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "aictUsagePeriodFrom", column = @Column(name = "AICT_USAGE_PERIOD_FROM", nullable = false, length = 7)),
			@AttributeOverride(name = "aictUsagePeriodTo", column = @Column(name = "AICT_USAGE_PERIOD_TO", nullable = false, length = 7)),
			@AttributeOverride(name = "aictItemTypeCd", column = @Column(name = "AICT_ITEM_TYPE_CD", nullable = false, length = 7)) })
	public AlsItemControlTableIdPk getIdPk() {
		return this.idPk;
	}

	public void setIdPk(AlsItemControlTableIdPk idPk) {
		this.idPk = idPk;
	}

	@Column(name = "AICT_LICENSE_PERMIT_FLAG", length = 1)
	public String getAictLicensePermitFlag() {
		return this.aictLicensePermitFlag;
	}

	public void setAictLicensePermitFlag(String aictLicensePermitFlag) {
		this.aictLicensePermitFlag = aictLicensePermitFlag;
	}

	@Column(name = "AICT_TAG_FLAG", nullable = false, length = 1)
	public String getAictTagFlag() {
		return this.aictTagFlag;
	}

	public void setAictTagFlag(String aictTagFlag) {
		this.aictTagFlag = aictTagFlag;
	}

	@Column(name = "AICT_REPLACEMENT_LIMIT", precision = 3, scale = 0)
	public Integer getAictReplacementLimit() {
		return this.aictReplacementLimit;
	}

	public void setAictReplacementLimit(Integer aictReplacementLimit) {
		this.aictReplacementLimit = aictReplacementLimit;
	}

	@Column(name = "AICT_CLASSIFICATION_IND", nullable = false, length = 1)
	public String getAictClassificationInd() {
		return this.aictClassificationInd;
	}

	public void setAictClassificationInd(String aictClassificationInd) {
		this.aictClassificationInd = aictClassificationInd;
	}

	@Column(name = "AICT_RESIDENCY_IND", nullable = false, length = 1)
	public String getAictResidencyInd() {
		return this.aictResidencyInd;
	}

	public void setAictResidencyInd(String aictResidencyInd) {
		this.aictResidencyInd = aictResidencyInd;
	}

	@Column(name = "AICT_DISPLAY_OVERRIDE_IND", nullable = false, length = 1)
	public String getAictDisplayOverrideInd() {
		return this.aictDisplayOverrideInd;
	}

	public void setAictDisplayOverrideInd(String aictDisplayOverrideInd) {
		this.aictDisplayOverrideInd = aictDisplayOverrideInd;
	}

	@Column(name = "AICT_SEASON_FROM_DT", length = 7)
	public Timestamp getAictSeasonFromDt() {
		return this.aictSeasonFromDt;
	}

	public void setAictSeasonFromDt(Timestamp aictSeasonFromDt) {
		this.aictSeasonFromDt = aictSeasonFromDt;
	}

	@Column(name = "AICT_SEASON_TO_DT", length = 7)
	public Timestamp getAictSeasonToDt() {
		return this.aictSeasonToDt;
	}

	public void setAictSeasonToDt(Timestamp aictSeasonToDt) {
		this.aictSeasonToDt = aictSeasonToDt;
	}

	@Column(name = "AICT_MAIL_EXT_PERIOD", nullable = false, precision = 2, scale = 0)
	public Integer getAictMailExtPeriod() {
		return this.aictMailExtPeriod;
	}

	public void setAictMailExtPeriod(Integer aictMailExtPeriod) {
		this.aictMailExtPeriod = aictMailExtPeriod;
	}

	@Column(name = "AICT_PERSON_TYPE_CD", nullable = false, length = 1)
	public String getAictPersonTypeCd() {
		return this.aictPersonTypeCd;
	}

	public void setAictPersonTypeCd(String aictPersonTypeCd) {
		this.aictPersonTypeCd = aictPersonTypeCd;
	}

	@Column(name = "AICT_MAIL_LIST_EXCLUSION_IND", nullable = false, length = 1)
	public String getAictMailListExclusionInd() {
		return this.aictMailListExclusionInd;
	}

	public void setAictMailListExclusionInd(String aictMailListExclusionInd) {
		this.aictMailListExclusionInd = aictMailListExclusionInd;
	}

	@Column(name = "AICT_USAGE_DEADLINE", length = 7)
	public Timestamp getAictUsageDeadline() {
		return this.aictUsageDeadline;
	}

	public void setAictUsageDeadline(Timestamp aictUsageDeadline) {
		this.aictUsageDeadline = aictUsageDeadline;
	}

	@Column(name = "AICT_ITEM_QUOTA_IND", length = 1)
	public String getAictItemQuotaInd() {
		return this.aictItemQuotaInd;
	}

	public void setAictItemQuotaInd(String aictItemQuotaInd) {
		this.aictItemQuotaInd = aictItemQuotaInd;
	}

	@Column(name = "AICT_COMBIN_ITM_QUT_RESI_IND", nullable = false, length = 1)
	public String getAictCombinItmQutResiInd() {
		return this.aictCombinItmQutResiInd;
	}

	public void setAictCombinItmQutResiInd(String aictCombinItmQutResiInd) {
		this.aictCombinItmQutResiInd = aictCombinItmQutResiInd;
	}

	@Column(name = "AICT_DRAW_INTERIM_STATUS_IND", nullable = false, length = 1)
	public String getAictDrawInterimStatusInd() {
		return this.aictDrawInterimStatusInd;
	}

	public void setAictDrawInterimStatusInd(String aictDrawInterimStatusInd) {
		this.aictDrawInterimStatusInd = aictDrawInterimStatusInd;
	}

	@Column(name = "AICT_APPL_PROC_TIME_LN_FROM_DT", length = 7)
	public Timestamp getAictApplProcTimeLnFromDt() {
		return this.aictApplProcTimeLnFromDt;
	}

	public void setAictApplProcTimeLnFromDt(Timestamp aictApplProcTimeLnFromDt) {
		this.aictApplProcTimeLnFromDt = aictApplProcTimeLnFromDt;
	}

	@Column(name = "AICT_APPL_PROC_TIME_LN_TO_DT", length = 7)
	public Timestamp getAictApplProcTimeLnToDt() {
		return this.aictApplProcTimeLnToDt;
	}

	public void setAictApplProcTimeLnToDt(Timestamp aictApplProcTimeLnToDt) {
		this.aictApplProcTimeLnToDt = aictApplProcTimeLnToDt;
	}

	@Column(name = "AICT_PREPAY_APPL_FEE_IND", length = 1)
	public String getAictPrepayApplFeeInd() {
		return this.aictPrepayApplFeeInd;
	}

	public void setAictPrepayApplFeeInd(String aictPrepayApplFeeInd) {
		this.aictPrepayApplFeeInd = aictPrepayApplFeeInd;
	}

	@Column(name = "AICT_DRAW_FEE", precision = 10)
	public Double getAictDrawFee() {
		return this.aictDrawFee;
	}

	public void setAictDrawFee(Double aictDrawFee) {
		this.aictDrawFee = aictDrawFee;
	}

	@Column(name = "AICT_APPL_NOTIFICATION_DT", length = 7)
	public Timestamp getAictApplNotificationDt() {
		return this.aictApplNotificationDt;
	}

	public void setAictApplNotificationDt(Timestamp aictApplNotificationDt) {
		this.aictApplNotificationDt = aictApplNotificationDt;
	}

	@Column(name = "AICT_ITEM_ISSUE_TIME_LN_FRM_DT", nullable = false, length = 7)
	public Timestamp getAictItemIssueTimeLnFrmDt() {
		return this.aictItemIssueTimeLnFrmDt;
	}

	public void setAictItemIssueTimeLnFrmDt(Timestamp aictItemIssueTimeLnFrmDt) {
		this.aictItemIssueTimeLnFrmDt = aictItemIssueTimeLnFrmDt;
	}

	@Column(name = "AICT_ITEM_ISSUE_TIME_LN_TO_DT", nullable = false, length = 7)
	public Timestamp getAictItemIssueTimeLnToDt() {
		return this.aictItemIssueTimeLnToDt;
	}

	public void setAictItemIssueTimeLnToDt(Timestamp aictItemIssueTimeLnToDt) {
		this.aictItemIssueTimeLnToDt = aictItemIssueTimeLnToDt;
	}

	@Column(name = "AICT_CNTRL_FULFILLMENT_IND", length = 1)
	public String getAictCntrlFulfillmentInd() {
		return this.aictCntrlFulfillmentInd;
	}

	public void setAictCntrlFulfillmentInd(String aictCntrlFulfillmentInd) {
		this.aictCntrlFulfillmentInd = aictCntrlFulfillmentInd;
	}

	@Column(name = "AICT_CNTRL_FULFILLMENT_PROMPT", length = 500)
	public String getAictCntrlFulfillmentPrompt() {
		return this.aictCntrlFulfillmentPrompt;
	}

	public void setAictCntrlFulfillmentPrompt(String aictCntrlFulfillmentPrompt) {
		this.aictCntrlFulfillmentPrompt = aictCntrlFulfillmentPrompt;
	}

	@Column(name = "AICT_REVIEW_INTERIM_STATUS_IND", nullable = false, length = 1)
	public String getAictReviewInterimStatusInd() {
		return this.aictReviewInterimStatusInd;
	}

	public void setAictReviewInterimStatusInd(String aictReviewInterimStatusInd) {
		this.aictReviewInterimStatusInd = aictReviewInterimStatusInd;
	}

	@Column(name = "AICT_REVIEW_PROGRAM_NM", length = 20)
	public String getAictReviewProgramNm() {
		return this.aictReviewProgramNm;
	}

	public void setAictReviewProgramNm(String aictReviewProgramNm) {
		this.aictReviewProgramNm = aictReviewProgramNm;
	}

	@Column(name = "AICT_REV_PREPAY_ITEM_FEE_IND", length = 1)
	public String getAictRevPrepayItemFeeInd() {
		return this.aictRevPrepayItemFeeInd;
	}

	public void setAictRevPrepayItemFeeInd(String aictRevPrepayItemFeeInd) {
		this.aictRevPrepayItemFeeInd = aictRevPrepayItemFeeInd;
	}

	@Column(name = "AICT_ITEM_EXCHANGE_DEADLINE", length = 7)
	public Timestamp getAictItemExchangeDeadline() {
		return this.aictItemExchangeDeadline;
	}

	public void setAictItemExchangeDeadline(Timestamp aictItemExchangeDeadline) {
		this.aictItemExchangeDeadline = aictItemExchangeDeadline;
	}

	@Column(name = "AICT_POS_PRNT_TEMPL_CD", precision = 5, scale = 0)
	public Integer getAictPosPrntTemplCd() {
		return this.aictPosPrntTemplCd;
	}

	public void setAictPosPrntTemplCd(Integer aictPosPrntTemplCd) {
		this.aictPosPrntTemplCd = aictPosPrntTemplCd;
	}

	@Column(name = "AICT_CENTRAL_PRNT_TEMPL_CD", precision = 5, scale = 0)
	public Integer getAictCentralPrntTemplCd() {
		return this.aictCentralPrntTemplCd;
	}

	public void setAictCentralPrntTemplCd(Integer aictCentralPrntTemplCd) {
		this.aictCentralPrntTemplCd = aictCentralPrntTemplCd;
	}

	@Column(name = "AICT_APP_RECEIPT_PRNT_TEMPL_CD", precision = 5, scale = 0)
	public Integer getAictAppReceiptPrntTemplCd() {
		return this.aictAppReceiptPrntTemplCd;
	}

	public void setAictAppReceiptPrntTemplCd(Integer aictAppReceiptPrntTemplCd) {
		this.aictAppReceiptPrntTemplCd = aictAppReceiptPrntTemplCd;
	}

	@Column(name = "AICT_PRINTER_PRINT_IND", precision = 5, scale = 0)
	public Integer getAictPrinterPrintInd() {
		return this.aictPrinterPrintInd;
	}

	public void setAictPrinterPrintInd(Integer aictPrinterPrintInd) {
		this.aictPrinterPrintInd = aictPrinterPrintInd;
	}

	@Column(name = "AICT_SEPARATE_PRINT_IND", length = 1)
	public String getAictSeparatePrintInd() {
		return this.aictSeparatePrintInd;
	}

	public void setAictSeparatePrintInd(String aictSeparatePrintInd) {
		this.aictSeparatePrintInd = aictSeparatePrintInd;
	}

	@Column(name = "AICT_NO_POUCH_TO_BE_HANDED_OUT", precision = 2, scale = 0)
	public Integer getAictNoPouchToBeHandedOut() {
		return this.aictNoPouchToBeHandedOut;
	}

	public void setAictNoPouchToBeHandedOut(Integer aictNoPouchToBeHandedOut) {
		this.aictNoPouchToBeHandedOut = aictNoPouchToBeHandedOut;
	}

	@Column(name = "AICT_PERSON_ID_TEMPLATE_CD", precision = 5, scale = 0)
	public Integer getAictPersonIdTemplateCd() {
		return this.aictPersonIdTemplateCd;
	}

	public void setAictPersonIdTemplateCd(Integer aictPersonIdTemplateCd) {
		this.aictPersonIdTemplateCd = aictPersonIdTemplateCd;
	}

	@Column(name = "AICT_COMMISSION", precision = 5)
	public Double getAictCommission() {
		return this.aictCommission;
	}

	public void setAictCommission(Double aictCommission) {
		this.aictCommission = aictCommission;
	}

	@Column(name = "AICT_REPLACEMENT_FEE_IND", length = 1)
	public String getAictReplacementFeeInd() {
		return this.aictReplacementFeeInd;
	}

	public void setAictReplacementFeeInd(String aictReplacementFeeInd) {
		this.aictReplacementFeeInd = aictReplacementFeeInd;
	}

	@Column(name = "AICT_COMBINATION_REQUIRED_IND", length = 1)
	public String getAictCombinationRequiredInd() {
		return this.aictCombinationRequiredInd;
	}

	public void setAictCombinationRequiredInd(String aictCombinationRequiredInd) {
		this.aictCombinationRequiredInd = aictCombinationRequiredInd;
	}

	@Column(name = "AICT_OPP_TYPE_SP_DT_IND", length = 1)
	public String getAictOppTypeSpDtInd() {
		return this.aictOppTypeSpDtInd;
	}

	public void setAictOppTypeSpDtInd(String aictOppTypeSpDtInd) {
		this.aictOppTypeSpDtInd = aictOppTypeSpDtInd;
	}

	@Column(name = "AICT_ITEM_TRIBAL_IND", nullable = false, length = 1)
	public String getAictItemTribalInd() {
		return this.aictItemTribalInd;
	}

	public void setAictItemTribalInd(String aictItemTribalInd) {
		this.aictItemTribalInd = aictItemTribalInd;
	}

	@Column(name = "AICT_RESIDENCY_DECLARATION_IND", nullable = false, length = 1)
	public String getAictResidencyDeclarationInd() {
		return this.aictResidencyDeclarationInd;
	}

	public void setAictResidencyDeclarationInd(
			String aictResidencyDeclarationInd) {
		this.aictResidencyDeclarationInd = aictResidencyDeclarationInd;
	}

	@Column(name = "AICT_EXEMPTION_IND", length = 1)
	public String getAictExemptionInd() {
		return this.aictExemptionInd;
	}

	public void setAictExemptionInd(String aictExemptionInd) {
		this.aictExemptionInd = aictExemptionInd;
	}

	@Column(name = "AICT_RESIDENCY_SUPP_MAT_IND", nullable = false, length = 1)
	public String getAictResidencySuppMatInd() {
		return this.aictResidencySuppMatInd;
	}

	public void setAictResidencySuppMatInd(String aictResidencySuppMatInd) {
		this.aictResidencySuppMatInd = aictResidencySuppMatInd;
	}

	@Column(name = "AICT_RECIPROCITY_IND", nullable = false, length = 1)
	public String getAictReciprocityInd() {
		return this.aictReciprocityInd;
	}

	public void setAictReciprocityInd(String aictReciprocityInd) {
		this.aictReciprocityInd = aictReciprocityInd;
	}

	@Column(name = "AICT_VALID_AREA_OPP_T_IND", length = 1)
	public String getAictValidAreaOppTInd() {
		return this.aictValidAreaOppTInd;
	}

	public void setAictValidAreaOppTInd(String aictValidAreaOppTInd) {
		this.aictValidAreaOppTInd = aictValidAreaOppTInd;
	}

	@Column(name = "AICT_OPP_TYPE_DISPLAY_PROMPT", length = 200)
	public String getAictOppTypeDisplayPrompt() {
		return this.aictOppTypeDisplayPrompt;
	}

	public void setAictOppTypeDisplayPrompt(String aictOppTypeDisplayPrompt) {
		this.aictOppTypeDisplayPrompt = aictOppTypeDisplayPrompt;
	}

	@Column(name = "AICT_APP_NO_FROM_RANGE", precision = 3, scale = 0)
	public Integer getAictAppNoFromRange() {
		return this.aictAppNoFromRange;
	}

	public void setAictAppNoFromRange(Integer aictAppNoFromRange) {
		this.aictAppNoFromRange = aictAppNoFromRange;
	}

	@Column(name = "AICT_APP_NO_TO_RANGE", precision = 3, scale = 0)
	public Integer getAictAppNoToRange() {
		return this.aictAppNoToRange;
	}

	public void setAictAppNoToRange(Integer aictAppNoToRange) {
		this.aictAppNoToRange = aictAppNoToRange;
	}

	@Column(name = "AICT_ITEM_OPP_NO_FROM_RANGE", precision = 3, scale = 0)
	public Integer getAictItemOppNoFromRange() {
		return this.aictItemOppNoFromRange;
	}

	public void setAictItemOppNoFromRange(Integer aictItemOppNoFromRange) {
		this.aictItemOppNoFromRange = aictItemOppNoFromRange;
	}

	@Column(name = "AICT_ITEM_OPP_NO_TO_RANGE", precision = 3, scale = 0)
	public Integer getAictItemOppNoToRange() {
		return this.aictItemOppNoToRange;
	}

	public void setAictItemOppNoToRange(Integer aictItemOppNoToRange) {
		this.aictItemOppNoToRange = aictItemOppNoToRange;
	}

	@Column(name = "AICT_EXCHANGE_ALLOWED_FOR", length = 1)
	public String getAictExchangeAllowedFor() {
		return this.aictExchangeAllowedFor;
	}

	public void setAictExchangeAllowedFor(String aictExchangeAllowedFor) {
		this.aictExchangeAllowedFor = aictExchangeAllowedFor;
	}

	@Column(name = "AICT_WHO_LOG", nullable = false, length = 15)
	public String getAictWhoLog() {
		return this.aictWhoLog;
	}

	public void setAictWhoLog(String aictWhoLog) {
		this.aictWhoLog = aictWhoLog;
	}

	@Column(name = "AICT_WHEN_LOG", nullable = false, length = 7)
	public Timestamp getAictWhenLog() {
		return this.aictWhenLog;
	}

	public void setAictWhenLog(Timestamp aictWhenLog) {
		this.aictWhenLog = aictWhenLog;
	}

	@Column(name = "AICT_EXCLUSION_TIME_PERIOD", precision = 2, scale = 0)
	public Integer getAictExclusionTimePeriod() {
		return this.aictExclusionTimePeriod;
	}

	public void setAictExclusionTimePeriod(Integer aictExclusionTimePeriod) {
		this.aictExclusionTimePeriod = aictExclusionTimePeriod;
	}

	@Column(name = "AICT_COMB_ITEM_QUOTA_ITEM_TYP", length = 7)
	public String getAictCombItemQuotaItemTyp() {
		return this.aictCombItemQuotaItemTyp;
	}

	public void setAictCombItemQuotaItemTyp(String aictCombItemQuotaItemTyp) {
		this.aictCombItemQuotaItemTyp = aictCombItemQuotaItemTyp;
	}

	@Column(name = "AICT_APP_PARTY_IND", length = 1)
	public String getAictAppPartyInd() {
		return this.aictAppPartyInd;
	}

	public void setAictAppPartyInd(String aictAppPartyInd) {
		this.aictAppPartyInd = aictAppPartyInd;
	}

	@Column(name = "AICT_APP_PARTY_LIMIT", precision = 2, scale = 0)
	public Integer getAictAppPartyLimit() {
		return this.aictAppPartyLimit;
	}

	public void setAictAppPartyLimit(Integer aictAppPartyLimit) {
		this.aictAppPartyLimit = aictAppPartyLimit;
	}

	@Column(name = "AICT_BONUS_POINT_IND", length = 1)
	public String getAictBonusPointInd() {
		return this.aictBonusPointInd;
	}

	public void setAictBonusPointInd(String aictBonusPointInd) {
		this.aictBonusPointInd = aictBonusPointInd;
	}

	@Column(name = "AICT_PREF_SPONSOR_IND", length = 2)
	public String getAictPrefSponsorInd() {
		return this.aictPrefSponsorInd;
	}

	public void setAictPrefSponsorInd(String aictPrefSponsorInd) {
		this.aictPrefSponsorInd = aictPrefSponsorInd;
	}

	@Column(name = "AICT_DEER_ONLY_IND", length = 1)
	public String getAictDeerOnlyInd() {
		return this.aictDeerOnlyInd;
	}

	public void setAictDeerOnlyInd(String aictDeerOnlyInd) {
		this.aictDeerOnlyInd = aictDeerOnlyInd;
	}

	@Column(name = "AICT_FEE_DONATION_IND", length = 1)
	public String getAictFeeDonationInd() {
		return this.aictFeeDonationInd;
	}

	public void setAictFeeDonationInd(String aictFeeDonationInd) {
		this.aictFeeDonationInd = aictFeeDonationInd;
	}

	@Column(name = "AICT_GROUP_LIMIT", precision = 3, scale = 0)
	public Integer getAictGroupLimit() {
		return this.aictGroupLimit;
	}

	public void setAictGroupLimit(Integer aictGroupLimit) {
		this.aictGroupLimit = aictGroupLimit;
	}

	@Column(name = "AICT_APP_PARTY_CHOICE_IND", length = 1)
	public String getAictAppPartyChoiceInd() {
		return this.aictAppPartyChoiceInd;
	}

	public void setAictAppPartyChoiceInd(String aictAppPartyChoiceInd) {
		this.aictAppPartyChoiceInd = aictAppPartyChoiceInd;
	}

	@Column(name = "AICT_SECONDARY_ITEM", length = 1)
	public String getAictSecondaryItem() {
		return this.aictSecondaryItem;
	}

	public void setAictSecondaryItem(String aictSecondaryItem) {
		this.aictSecondaryItem = aictSecondaryItem;
	}

	@Column(name = "AICT_VIOLATION_EXCLUSION", length = 1)
	public String getAictViolationExclusion() {
		return this.aictViolationExclusion;
	}

	public void setAictViolationExclusion(String aictViolationExclusion) {
		this.aictViolationExclusion = aictViolationExclusion;
	}

	@Column(name = "AICT_RENEWAL_ALLOWED", length = 1)
	public String getAictRenewalAllowed() {
		return this.aictRenewalAllowed;
	}

	public void setAictRenewalAllowed(String aictRenewalAllowed) {
		this.aictRenewalAllowed = aictRenewalAllowed;
	}

	@Column(name = "AICT_INTERNAL_REPL_LIMIT", precision = 3, scale = 0)
	public Integer getAictInternalReplLimit() {
		return this.aictInternalReplLimit;
	}

	public void setAictInternalReplLimit(Integer aictInternalReplLimit) {
		this.aictInternalReplLimit = aictInternalReplLimit;
	}

	@Column(name = "AICT_REMARKS_IND", length = 1)
	public String getAictRemarksInd() {
		return this.aictRemarksInd;
	}

	public void setAictRemarksInd(String aictRemarksInd) {
		this.aictRemarksInd = aictRemarksInd;
	}

	@Column(name = "AICT_CENTRAL_PRINT_IND", length = 1)
	public String getAictCentralPrintInd() {
		return this.aictCentralPrintInd;
	}

	public void setAictCentralPrintInd(String aictCentralPrintInd) {
		this.aictCentralPrintInd = aictCentralPrintInd;
	}

	@Column(name = "AICT_DISABLED_QUOTA", precision = 12, scale = 0)
	public Integer getAictDisabledQuota() {
		return this.aictDisabledQuota;
	}

	public void setAictDisabledQuota(Integer aictDisabledQuota) {
		this.aictDisabledQuota = aictDisabledQuota;
	}

	@Column(name = "AICT_DONATION_IND", length = 1)
	public String getAictDonationInd() {
		return this.aictDonationInd;
	}

	public void setAictDonationInd(String aictDonationInd) {
		this.aictDonationInd = aictDonationInd;
	}

	@Column(name = "AICT_MIN_DONATION_AMT", precision = 8)
	public Double getAictMinDonationAmt() {
		return this.aictMinDonationAmt;
	}

	public void setAictMinDonationAmt(Double aictMinDonationAmt) {
		this.aictMinDonationAmt = aictMinDonationAmt;
	}

	@Column(name = "AICT_DISPLAY_OVERRIDE_TRN_IND", nullable = false, length = 1)
	public String getAictDisplayOverrideTrnInd() {
		return this.aictDisplayOverrideTrnInd;
	}

	public void setAictDisplayOverrideTrnInd(String aictDisplayOverrideTrnInd) {
		this.aictDisplayOverrideTrnInd = aictDisplayOverrideTrnInd;
	}

	@Column(name = "AICT_NONTYPICAL_USAGE_LIC_YR", precision = 4, scale = 0)
	public Integer getAictNontypicalUsageLicYr() {
		return this.aictNontypicalUsageLicYr;
	}

	public void setAictNontypicalUsageLicYr(Integer aictNontypicalUsageLicYr) {
		this.aictNontypicalUsageLicYr = aictNontypicalUsageLicYr;
	}

	@Column(name = "AICT_REFUND_DRAWING_ITEM_FEE", length = 1)
	public String getAictRefundDrawingItemFee() {
		return this.aictRefundDrawingItemFee;
	}

	public void setAictRefundDrawingItemFee(String aictRefundDrawingItemFee) {
		this.aictRefundDrawingItemFee = aictRefundDrawingItemFee;
	}

	@Column(name = "AICT_MAX_COMM_ITEMS_PER_SESS", precision = 5, scale = 0)
	public Integer getAictMaxCommItemsPerSess() {
		return this.aictMaxCommItemsPerSess;
	}

	public void setAictMaxCommItemsPerSess(Integer aictMaxCommItemsPerSess) {
		this.aictMaxCommItemsPerSess = aictMaxCommItemsPerSess;
	}

	@Column(name = "AICT_REPLACEMENT_FROM_DT", length = 7)
	public Timestamp getAictReplacementFromDt() {
		return this.aictReplacementFromDt;
	}

	public void setAictReplacementFromDt(Timestamp aictReplacementFromDt) {
		this.aictReplacementFromDt = aictReplacementFromDt;
	}

	@Column(name = "AICT_SPECIAL_PROCESS_IND", length = 1)
	public String getAictSpecialProcessInd() {
		return this.aictSpecialProcessInd;
	}

	public void setAictSpecialProcessInd(String aictSpecialProcessInd) {
		this.aictSpecialProcessInd = aictSpecialProcessInd;
	}

	@Column(name = "AICT_FEATURED_ITEM_DESC", length = 100)
	public String getAictFeaturedItemDesc() {
		return this.aictFeaturedItemDesc;
	}

	public void setAictFeaturedItemDesc(String aictFeaturedItemDesc) {
		this.aictFeaturedItemDesc = aictFeaturedItemDesc;
	}

	@Column(name = "AICT_FEATURED_ITEM_ACTIVE", length = 1)
	public String getAictFeaturedItemActive() {
		return this.aictFeaturedItemActive;
	}

	public void setAictFeaturedItemActive(String aictFeaturedItemActive) {
		this.aictFeaturedItemActive = aictFeaturedItemActive;
	}

	@Column(name = "AICT_DONATION_ITEM_TYPE_CD", length = 7)
	public String getAictDonationItemTypeCd() {
		return this.aictDonationItemTypeCd;
	}

	public void setAictDonationItemTypeCd(String aictDonationItemTypeCd) {
		this.aictDonationItemTypeCd = aictDonationItemTypeCd;
	}

	@Column(name = "AICT_MRKTG_QUESTION", length = 30)
	public String getAictMrktgQuestion() {
		return this.aictMrktgQuestion;
	}

	public void setAictMrktgQuestion(String aictMrktgQuestion) {
		this.aictMrktgQuestion = aictMrktgQuestion;
	}

	@Column(name = "AICT_DONATE_IND", length = 1)
	public String getAictDonateInd() {
		return this.aictDonateInd;
	}

	public void setAictDonateInd(String aictDonateInd) {
		this.aictDonateInd = aictDonateInd;
	}

}