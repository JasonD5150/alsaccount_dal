package fwp.alsaccount.dao.admin;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fwp.alsaccount.hibernate.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * AlsItemControlTable entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see fwp.alsaccount.dao.admin.AlsItemControlTable
 * @author MyEclipse Persistence Tools
 */
public class AlsItemControlTableDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AlsItemControlTableDAO.class);
	// property constants
	public static final String AICT_LICENSE_PERMIT_FLAG = "aictLicensePermitFlag";
	public static final String AICT_TAG_FLAG = "aictTagFlag";
	public static final String AICT_REPLACEMENT_LIMIT = "aictReplacementLimit";
	public static final String AICT_CLASSIFICATION_IND = "aictClassificationInd";
	public static final String AICT_RESIDENCY_IND = "aictResidencyInd";
	public static final String AICT_DISPLAY_OVERRIDE_IND = "aictDisplayOverrideInd";
	public static final String AICT_MAIL_EXT_PERIOD = "aictMailExtPeriod";
	public static final String AICT_PERSON_TYPE_CD = "aictPersonTypeCd";
	public static final String AICT_MAIL_LIST_EXCLUSION_IND = "aictMailListExclusionInd";
	public static final String AICT_ITEM_QUOTA_IND = "aictItemQuotaInd";
	public static final String AICT_COMBIN_ITM_QUT_RESI_IND = "aictCombinItmQutResiInd";
	public static final String AICT_DRAW_INTERIM_STATUS_IND = "aictDrawInterimStatusInd";
	public static final String AICT_PREPAY_APPL_FEE_IND = "aictPrepayApplFeeInd";
	public static final String AICT_DRAW_FEE = "aictDrawFee";
	public static final String AICT_CNTRL_FULFILLMENT_IND = "aictCntrlFulfillmentInd";
	public static final String AICT_CNTRL_FULFILLMENT_PROMPT = "aictCntrlFulfillmentPrompt";
	public static final String AICT_REVIEW_INTERIM_STATUS_IND = "aictReviewInterimStatusInd";
	public static final String AICT_REVIEW_PROGRAM_NM = "aictReviewProgramNm";
	public static final String AICT_REV_PREPAY_ITEM_FEE_IND = "aictRevPrepayItemFeeInd";
	public static final String AICT_POS_PRNT_TEMPL_CD = "aictPosPrntTemplCd";
	public static final String AICT_CENTRAL_PRNT_TEMPL_CD = "aictCentralPrntTemplCd";
	public static final String AICT_APP_RECEIPT_PRNT_TEMPL_CD = "aictAppReceiptPrntTemplCd";
	public static final String AICT_PRINTER_PRINT_IND = "aictPrinterPrintInd";
	public static final String AICT_SEPARATE_PRINT_IND = "aictSeparatePrintInd";
	public static final String AICT_NO_POUCH_TO_BE_HANDED_OUT = "aictNoPouchToBeHandedOut";
	public static final String AICT_PERSON_ID_TEMPLATE_CD = "aictPersonIdTemplateCd";
	public static final String AICT_COMMISSION = "aictCommission";
	public static final String AICT_REPLACEMENT_FEE_IND = "aictReplacementFeeInd";
	public static final String AICT_COMBINATION_REQUIRED_IND = "aictCombinationRequiredInd";
	public static final String AICT_OPP_TYPE_SP_DT_IND = "aictOppTypeSpDtInd";
	public static final String AICT_ITEM_TRIBAL_IND = "aictItemTribalInd";
	public static final String AICT_RESIDENCY_DECLARATION_IND = "aictResidencyDeclarationInd";
	public static final String AICT_EXEMPTION_IND = "aictExemptionInd";
	public static final String AICT_RESIDENCY_SUPP_MAT_IND = "aictResidencySuppMatInd";
	public static final String AICT_RECIPROCITY_IND = "aictReciprocityInd";
	public static final String AICT_VALID_AREA_OPP_TIND = "aictValidAreaOppTInd";
	public static final String AICT_OPP_TYPE_DISPLAY_PROMPT = "aictOppTypeDisplayPrompt";
	public static final String AICT_APP_NO_FROM_RANGE = "aictAppNoFromRange";
	public static final String AICT_APP_NO_TO_RANGE = "aictAppNoToRange";
	public static final String AICT_ITEM_OPP_NO_FROM_RANGE = "aictItemOppNoFromRange";
	public static final String AICT_ITEM_OPP_NO_TO_RANGE = "aictItemOppNoToRange";
	public static final String AICT_EXCHANGE_ALLOWED_FOR = "aictExchangeAllowedFor";
	public static final String AICT_WHO_LOG = "aictWhoLog";
	public static final String AICT_EXCLUSION_TIME_PERIOD = "aictExclusionTimePeriod";
	public static final String AICT_COMB_ITEM_QUOTA_ITEM_TYP = "aictCombItemQuotaItemTyp";
	public static final String AICT_APP_PARTY_IND = "aictAppPartyInd";
	public static final String AICT_APP_PARTY_LIMIT = "aictAppPartyLimit";
	public static final String AICT_BONUS_POINT_IND = "aictBonusPointInd";
	public static final String AICT_PREF_SPONSOR_IND = "aictPrefSponsorInd";
	public static final String AICT_DEER_ONLY_IND = "aictDeerOnlyInd";
	public static final String AICT_FEE_DONATION_IND = "aictFeeDonationInd";
	public static final String AICT_GROUP_LIMIT = "aictGroupLimit";
	public static final String AICT_APP_PARTY_CHOICE_IND = "aictAppPartyChoiceInd";
	public static final String AICT_SECONDARY_ITEM = "aictSecondaryItem";
	public static final String AICT_VIOLATION_EXCLUSION = "aictViolationExclusion";
	public static final String AICT_RENEWAL_ALLOWED = "aictRenewalAllowed";
	public static final String AICT_INTERNAL_REPL_LIMIT = "aictInternalReplLimit";
	public static final String AICT_REMARKS_IND = "aictRemarksInd";
	public static final String AICT_CENTRAL_PRINT_IND = "aictCentralPrintInd";
	public static final String AICT_DISABLED_QUOTA = "aictDisabledQuota";
	public static final String AICT_DONATION_IND = "aictDonationInd";
	public static final String AICT_MIN_DONATION_AMT = "aictMinDonationAmt";
	public static final String AICT_DISPLAY_OVERRIDE_TRN_IND = "aictDisplayOverrideTrnInd";
	public static final String AICT_NONTYPICAL_USAGE_LIC_YR = "aictNontypicalUsageLicYr";
	public static final String AICT_REFUND_DRAWING_ITEM_FEE = "aictRefundDrawingItemFee";
	public static final String AICT_MAX_COMM_ITEMS_PER_SESS = "aictMaxCommItemsPerSess";
	public static final String AICT_SPECIAL_PROCESS_IND = "aictSpecialProcessInd";
	public static final String AICT_FEATURED_ITEM_DESC = "aictFeaturedItemDesc";
	public static final String AICT_FEATURED_ITEM_ACTIVE = "aictFeaturedItemActive";
	public static final String AICT_DONATION_ITEM_TYPE_CD = "aictDonationItemTypeCd";
	public static final String AICT_MRKTG_QUESTION = "aictMrktgQuestion";
	public static final String AICT_DONATE_IND = "aictDonateInd";

	public void save(AlsItemControlTable transientInstance) {
		log.debug("saving AlsItemControlTable instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AlsItemControlTable persistentInstance) {
		log.debug("deleting AlsItemControlTable instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlsItemControlTable findById(
			fwp.alsaccount.dao.admin.AlsItemControlTableIdPk id) {
		log.debug("getting AlsItemControlTable instance with id: " + id);
		try {
			AlsItemControlTable instance = (AlsItemControlTable) getSession()
					.get("fwp.alsaccount.dao.admin.AlsItemControlTable", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<AlsItemControlTable> findByExample(AlsItemControlTable instance) {
		log.debug("finding AlsItemControlTable instance by example");
		try {
			List<AlsItemControlTable> results = (List<AlsItemControlTable>) getSession()
					.createCriteria(
							"fwp.alsaccount.dao.admin.AlsItemControlTable")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AlsItemControlTable instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AlsItemControlTable as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AlsItemControlTable> findByAictLicensePermitFlag(
			Object aictLicensePermitFlag) {
		return findByProperty(AICT_LICENSE_PERMIT_FLAG, aictLicensePermitFlag);
	}

	public List<AlsItemControlTable> findByAictTagFlag(Object aictTagFlag) {
		return findByProperty(AICT_TAG_FLAG, aictTagFlag);
	}

	public List<AlsItemControlTable> findByAictReplacementLimit(
			Object aictReplacementLimit) {
		return findByProperty(AICT_REPLACEMENT_LIMIT, aictReplacementLimit);
	}

	public List<AlsItemControlTable> findByAictClassificationInd(
			Object aictClassificationInd) {
		return findByProperty(AICT_CLASSIFICATION_IND, aictClassificationInd);
	}

	public List<AlsItemControlTable> findByAictResidencyInd(
			Object aictResidencyInd) {
		return findByProperty(AICT_RESIDENCY_IND, aictResidencyInd);
	}

	public List<AlsItemControlTable> findByAictDisplayOverrideInd(
			Object aictDisplayOverrideInd) {
		return findByProperty(AICT_DISPLAY_OVERRIDE_IND, aictDisplayOverrideInd);
	}

	public List<AlsItemControlTable> findByAictMailExtPeriod(
			Object aictMailExtPeriod) {
		return findByProperty(AICT_MAIL_EXT_PERIOD, aictMailExtPeriod);
	}

	public List<AlsItemControlTable> findByAictPersonTypeCd(
			Object aictPersonTypeCd) {
		return findByProperty(AICT_PERSON_TYPE_CD, aictPersonTypeCd);
	}

	public List<AlsItemControlTable> findByAictMailListExclusionInd(
			Object aictMailListExclusionInd) {
		return findByProperty(AICT_MAIL_LIST_EXCLUSION_IND,
				aictMailListExclusionInd);
	}

	public List<AlsItemControlTable> findByAictItemQuotaInd(
			Object aictItemQuotaInd) {
		return findByProperty(AICT_ITEM_QUOTA_IND, aictItemQuotaInd);
	}

	public List<AlsItemControlTable> findByAictCombinItmQutResiInd(
			Object aictCombinItmQutResiInd) {
		return findByProperty(AICT_COMBIN_ITM_QUT_RESI_IND,
				aictCombinItmQutResiInd);
	}

	public List<AlsItemControlTable> findByAictDrawInterimStatusInd(
			Object aictDrawInterimStatusInd) {
		return findByProperty(AICT_DRAW_INTERIM_STATUS_IND,
				aictDrawInterimStatusInd);
	}

	public List<AlsItemControlTable> findByAictPrepayApplFeeInd(
			Object aictPrepayApplFeeInd) {
		return findByProperty(AICT_PREPAY_APPL_FEE_IND, aictPrepayApplFeeInd);
	}

	public List<AlsItemControlTable> findByAictDrawFee(Object aictDrawFee) {
		return findByProperty(AICT_DRAW_FEE, aictDrawFee);
	}

	public List<AlsItemControlTable> findByAictCntrlFulfillmentInd(
			Object aictCntrlFulfillmentInd) {
		return findByProperty(AICT_CNTRL_FULFILLMENT_IND,
				aictCntrlFulfillmentInd);
	}

	public List<AlsItemControlTable> findByAictCntrlFulfillmentPrompt(
			Object aictCntrlFulfillmentPrompt) {
		return findByProperty(AICT_CNTRL_FULFILLMENT_PROMPT,
				aictCntrlFulfillmentPrompt);
	}

	public List<AlsItemControlTable> findByAictReviewInterimStatusInd(
			Object aictReviewInterimStatusInd) {
		return findByProperty(AICT_REVIEW_INTERIM_STATUS_IND,
				aictReviewInterimStatusInd);
	}

	public List<AlsItemControlTable> findByAictReviewProgramNm(
			Object aictReviewProgramNm) {
		return findByProperty(AICT_REVIEW_PROGRAM_NM, aictReviewProgramNm);
	}

	public List<AlsItemControlTable> findByAictRevPrepayItemFeeInd(
			Object aictRevPrepayItemFeeInd) {
		return findByProperty(AICT_REV_PREPAY_ITEM_FEE_IND,
				aictRevPrepayItemFeeInd);
	}

	public List<AlsItemControlTable> findByAictPosPrntTemplCd(
			Object aictPosPrntTemplCd) {
		return findByProperty(AICT_POS_PRNT_TEMPL_CD, aictPosPrntTemplCd);
	}

	public List<AlsItemControlTable> findByAictCentralPrntTemplCd(
			Object aictCentralPrntTemplCd) {
		return findByProperty(AICT_CENTRAL_PRNT_TEMPL_CD,
				aictCentralPrntTemplCd);
	}

	public List<AlsItemControlTable> findByAictAppReceiptPrntTemplCd(
			Object aictAppReceiptPrntTemplCd) {
		return findByProperty(AICT_APP_RECEIPT_PRNT_TEMPL_CD,
				aictAppReceiptPrntTemplCd);
	}

	public List<AlsItemControlTable> findByAictPrinterPrintInd(
			Object aictPrinterPrintInd) {
		return findByProperty(AICT_PRINTER_PRINT_IND, aictPrinterPrintInd);
	}

	public List<AlsItemControlTable> findByAictSeparatePrintInd(
			Object aictSeparatePrintInd) {
		return findByProperty(AICT_SEPARATE_PRINT_IND, aictSeparatePrintInd);
	}

	public List<AlsItemControlTable> findByAictNoPouchToBeHandedOut(
			Object aictNoPouchToBeHandedOut) {
		return findByProperty(AICT_NO_POUCH_TO_BE_HANDED_OUT,
				aictNoPouchToBeHandedOut);
	}

	public List<AlsItemControlTable> findByAictPersonIdTemplateCd(
			Object aictPersonIdTemplateCd) {
		return findByProperty(AICT_PERSON_ID_TEMPLATE_CD,
				aictPersonIdTemplateCd);
	}

	public List<AlsItemControlTable> findByAictCommission(Object aictCommission) {
		return findByProperty(AICT_COMMISSION, aictCommission);
	}

	public List<AlsItemControlTable> findByAictReplacementFeeInd(
			Object aictReplacementFeeInd) {
		return findByProperty(AICT_REPLACEMENT_FEE_IND, aictReplacementFeeInd);
	}

	public List<AlsItemControlTable> findByAictCombinationRequiredInd(
			Object aictCombinationRequiredInd) {
		return findByProperty(AICT_COMBINATION_REQUIRED_IND,
				aictCombinationRequiredInd);
	}

	public List<AlsItemControlTable> findByAictOppTypeSpDtInd(
			Object aictOppTypeSpDtInd) {
		return findByProperty(AICT_OPP_TYPE_SP_DT_IND, aictOppTypeSpDtInd);
	}

	public List<AlsItemControlTable> findByAictItemTribalInd(
			Object aictItemTribalInd) {
		return findByProperty(AICT_ITEM_TRIBAL_IND, aictItemTribalInd);
	}

	public List<AlsItemControlTable> findByAictResidencyDeclarationInd(
			Object aictResidencyDeclarationInd) {
		return findByProperty(AICT_RESIDENCY_DECLARATION_IND,
				aictResidencyDeclarationInd);
	}

	public List<AlsItemControlTable> findByAictExemptionInd(
			Object aictExemptionInd) {
		return findByProperty(AICT_EXEMPTION_IND, aictExemptionInd);
	}

	public List<AlsItemControlTable> findByAictResidencySuppMatInd(
			Object aictResidencySuppMatInd) {
		return findByProperty(AICT_RESIDENCY_SUPP_MAT_IND,
				aictResidencySuppMatInd);
	}

	public List<AlsItemControlTable> findByAictReciprocityInd(
			Object aictReciprocityInd) {
		return findByProperty(AICT_RECIPROCITY_IND, aictReciprocityInd);
	}

	public List<AlsItemControlTable> findByAictValidAreaOppTInd(
			Object aictValidAreaOppTInd) {
		return findByProperty(AICT_VALID_AREA_OPP_TIND, aictValidAreaOppTInd);
	}

	public List<AlsItemControlTable> findByAictOppTypeDisplayPrompt(
			Object aictOppTypeDisplayPrompt) {
		return findByProperty(AICT_OPP_TYPE_DISPLAY_PROMPT,
				aictOppTypeDisplayPrompt);
	}

	public List<AlsItemControlTable> findByAictAppNoFromRange(
			Object aictAppNoFromRange) {
		return findByProperty(AICT_APP_NO_FROM_RANGE, aictAppNoFromRange);
	}

	public List<AlsItemControlTable> findByAictAppNoToRange(
			Object aictAppNoToRange) {
		return findByProperty(AICT_APP_NO_TO_RANGE, aictAppNoToRange);
	}

	public List<AlsItemControlTable> findByAictItemOppNoFromRange(
			Object aictItemOppNoFromRange) {
		return findByProperty(AICT_ITEM_OPP_NO_FROM_RANGE,
				aictItemOppNoFromRange);
	}

	public List<AlsItemControlTable> findByAictItemOppNoToRange(
			Object aictItemOppNoToRange) {
		return findByProperty(AICT_ITEM_OPP_NO_TO_RANGE, aictItemOppNoToRange);
	}

	public List<AlsItemControlTable> findByAictExchangeAllowedFor(
			Object aictExchangeAllowedFor) {
		return findByProperty(AICT_EXCHANGE_ALLOWED_FOR, aictExchangeAllowedFor);
	}

	public List<AlsItemControlTable> findByAictWhoLog(Object aictWhoLog) {
		return findByProperty(AICT_WHO_LOG, aictWhoLog);
	}

	public List<AlsItemControlTable> findByAictExclusionTimePeriod(
			Object aictExclusionTimePeriod) {
		return findByProperty(AICT_EXCLUSION_TIME_PERIOD,
				aictExclusionTimePeriod);
	}

	public List<AlsItemControlTable> findByAictCombItemQuotaItemTyp(
			Object aictCombItemQuotaItemTyp) {
		return findByProperty(AICT_COMB_ITEM_QUOTA_ITEM_TYP,
				aictCombItemQuotaItemTyp);
	}

	public List<AlsItemControlTable> findByAictAppPartyInd(
			Object aictAppPartyInd) {
		return findByProperty(AICT_APP_PARTY_IND, aictAppPartyInd);
	}

	public List<AlsItemControlTable> findByAictAppPartyLimit(
			Object aictAppPartyLimit) {
		return findByProperty(AICT_APP_PARTY_LIMIT, aictAppPartyLimit);
	}

	public List<AlsItemControlTable> findByAictBonusPointInd(
			Object aictBonusPointInd) {
		return findByProperty(AICT_BONUS_POINT_IND, aictBonusPointInd);
	}

	public List<AlsItemControlTable> findByAictPrefSponsorInd(
			Object aictPrefSponsorInd) {
		return findByProperty(AICT_PREF_SPONSOR_IND, aictPrefSponsorInd);
	}

	public List<AlsItemControlTable> findByAictDeerOnlyInd(
			Object aictDeerOnlyInd) {
		return findByProperty(AICT_DEER_ONLY_IND, aictDeerOnlyInd);
	}

	public List<AlsItemControlTable> findByAictFeeDonationInd(
			Object aictFeeDonationInd) {
		return findByProperty(AICT_FEE_DONATION_IND, aictFeeDonationInd);
	}

	public List<AlsItemControlTable> findByAictGroupLimit(Object aictGroupLimit) {
		return findByProperty(AICT_GROUP_LIMIT, aictGroupLimit);
	}

	public List<AlsItemControlTable> findByAictAppPartyChoiceInd(
			Object aictAppPartyChoiceInd) {
		return findByProperty(AICT_APP_PARTY_CHOICE_IND, aictAppPartyChoiceInd);
	}

	public List<AlsItemControlTable> findByAictSecondaryItem(
			Object aictSecondaryItem) {
		return findByProperty(AICT_SECONDARY_ITEM, aictSecondaryItem);
	}

	public List<AlsItemControlTable> findByAictViolationExclusion(
			Object aictViolationExclusion) {
		return findByProperty(AICT_VIOLATION_EXCLUSION, aictViolationExclusion);
	}

	public List<AlsItemControlTable> findByAictRenewalAllowed(
			Object aictRenewalAllowed) {
		return findByProperty(AICT_RENEWAL_ALLOWED, aictRenewalAllowed);
	}

	public List<AlsItemControlTable> findByAictInternalReplLimit(
			Object aictInternalReplLimit) {
		return findByProperty(AICT_INTERNAL_REPL_LIMIT, aictInternalReplLimit);
	}

	public List<AlsItemControlTable> findByAictRemarksInd(Object aictRemarksInd) {
		return findByProperty(AICT_REMARKS_IND, aictRemarksInd);
	}

	public List<AlsItemControlTable> findByAictCentralPrintInd(
			Object aictCentralPrintInd) {
		return findByProperty(AICT_CENTRAL_PRINT_IND, aictCentralPrintInd);
	}

	public List<AlsItemControlTable> findByAictDisabledQuota(
			Object aictDisabledQuota) {
		return findByProperty(AICT_DISABLED_QUOTA, aictDisabledQuota);
	}

	public List<AlsItemControlTable> findByAictDonationInd(
			Object aictDonationInd) {
		return findByProperty(AICT_DONATION_IND, aictDonationInd);
	}

	public List<AlsItemControlTable> findByAictMinDonationAmt(
			Object aictMinDonationAmt) {
		return findByProperty(AICT_MIN_DONATION_AMT, aictMinDonationAmt);
	}

	public List<AlsItemControlTable> findByAictDisplayOverrideTrnInd(
			Object aictDisplayOverrideTrnInd) {
		return findByProperty(AICT_DISPLAY_OVERRIDE_TRN_IND,
				aictDisplayOverrideTrnInd);
	}

	public List<AlsItemControlTable> findByAictNontypicalUsageLicYr(
			Object aictNontypicalUsageLicYr) {
		return findByProperty(AICT_NONTYPICAL_USAGE_LIC_YR,
				aictNontypicalUsageLicYr);
	}

	public List<AlsItemControlTable> findByAictRefundDrawingItemFee(
			Object aictRefundDrawingItemFee) {
		return findByProperty(AICT_REFUND_DRAWING_ITEM_FEE,
				aictRefundDrawingItemFee);
	}

	public List<AlsItemControlTable> findByAictMaxCommItemsPerSess(
			Object aictMaxCommItemsPerSess) {
		return findByProperty(AICT_MAX_COMM_ITEMS_PER_SESS,
				aictMaxCommItemsPerSess);
	}

	public List<AlsItemControlTable> findByAictSpecialProcessInd(
			Object aictSpecialProcessInd) {
		return findByProperty(AICT_SPECIAL_PROCESS_IND, aictSpecialProcessInd);
	}

	public List<AlsItemControlTable> findByAictFeaturedItemDesc(
			Object aictFeaturedItemDesc) {
		return findByProperty(AICT_FEATURED_ITEM_DESC, aictFeaturedItemDesc);
	}

	public List<AlsItemControlTable> findByAictFeaturedItemActive(
			Object aictFeaturedItemActive) {
		return findByProperty(AICT_FEATURED_ITEM_ACTIVE, aictFeaturedItemActive);
	}

	public List<AlsItemControlTable> findByAictDonationItemTypeCd(
			Object aictDonationItemTypeCd) {
		return findByProperty(AICT_DONATION_ITEM_TYPE_CD,
				aictDonationItemTypeCd);
	}

	public List<AlsItemControlTable> findByAictMrktgQuestion(
			Object aictMrktgQuestion) {
		return findByProperty(AICT_MRKTG_QUESTION, aictMrktgQuestion);
	}

	public List<AlsItemControlTable> findByAictDonateInd(Object aictDonateInd) {
		return findByProperty(AICT_DONATE_IND, aictDonateInd);
	}

	public List findAll() {
		log.debug("finding all AlsItemControlTable instances");
		try {
			String queryString = "from AlsItemControlTable";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AlsItemControlTable merge(AlsItemControlTable detachedInstance) {
		log.debug("merging AlsItemControlTable instance");
		try {
			AlsItemControlTable result = (AlsItemControlTable) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AlsItemControlTable instance) {
		log.debug("attaching dirty AlsItemControlTable instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlsItemControlTable instance) {
		log.debug("attaching clean AlsItemControlTable instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}