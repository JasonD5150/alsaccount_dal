package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * AlsProviderInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_PROVIDER_INFO"
    ,schema="ALS"
)

public class AlsProviderInfo  implements java.io.Serializable {


    // Fields    

	 private static final long serialVersionUID = -9156672574484062876L;
	 private Integer apiProviderNo;
     private String apiProviderCat;
     private String apiProviderClass;
     private String apiSecurityReqMet;
     private String apiApplicantLastNm;
     private String apiApplicantFirstNm;
     private String apiApplicantMidInit;
     private String apiBusinessNm;
     private String apiBusinessAddress;
     private String apiBusinessCity;
     private String acBusinessCounty;
     private String arBusinessRegion;
     private String azcBusinessZipcode;
     private String apiBusinessState;
     private String apiBusinessType;
     private String apiMerchandiseType;
     private String apiBusinessEin;
     private String apiBusinessPhone;
     private String apiBusinessFax;
     private String apiBusinessEmail;
     private String apiApplicantHomephone;
     private Integer apiPersonsTraining;
     private String apiOpenHolidays;
     private String apiOpenMonths;
     private String apiApplicantSsn;
     private String apiBankruptcyFiled;
     private Integer apiTimeCurrbusiYrs;
     private Integer apiTimeCurrbusiMnths;
     private Timestamp apiWardenRdate;
     private Timestamp apiRegionalRdate;
     private String apiSecoffLastNm;
     private String apiSecoffFirstNm;
     private String apiSecoffMidInit;
     private Integer acdCcNo;
     private Integer apiDesiredNodevices;
     private Integer apiDevicesApproved;
     private Integer apiFeeExempted;
     private String apiCommissionYn;
     private Timestamp apiDesiredStartdate;
     private Timestamp apiStartdate;
     private String apiSecurityRequired;
     private String apiDesig;
     private String apiAllowSecProv;
     private String apiWhoLog;
     private Timestamp apiWhenLog;
     private String apiCommissionSi;
     private Double apiSessCommAmount;
     private String apiSslFlag;
     private String atiTribeCd;
     private Double apiMixSessCommAmt;
     private Double apiSpSessCommAmt;
     private String apiAlxProvInd;
     private Integer apiPrimaryProviderNo;
     private String apiSpecDevConfig;
     private String apiSpecConfigInd;


    // Constructors

    /** default constructor */
    public AlsProviderInfo() {
    }

	/** minimal constructor */
    public AlsProviderInfo(String apiProviderCat, String apiProviderClass, String apiSecurityReqMet, String apiApplicantLastNm, String apiApplicantFirstNm, String apiBusinessNm, String apiBusinessAddress, String apiBusinessCity, String acBusinessCounty, String arBusinessRegion, String azcBusinessZipcode, String apiBusinessState, String apiBusinessType, String apiMerchandiseType, String apiBusinessPhone, String apiOpenMonths, String apiBankruptcyFiled, Integer apiTimeCurrbusiYrs, Integer apiTimeCurrbusiMnths, String apiSecoffLastNm, String apiSecoffFirstNm, String apiCommissionYn, String apiSecurityRequired, String apiDesig, String apiAllowSecProv, String apiWhoLog, Timestamp apiWhenLog) {
        this.apiProviderCat = apiProviderCat;
        this.apiProviderClass = apiProviderClass;
        this.apiSecurityReqMet = apiSecurityReqMet;
        this.apiApplicantLastNm = apiApplicantLastNm;
        this.apiApplicantFirstNm = apiApplicantFirstNm;
        this.apiBusinessNm = apiBusinessNm;
        this.apiBusinessAddress = apiBusinessAddress;
        this.apiBusinessCity = apiBusinessCity;
        this.acBusinessCounty = acBusinessCounty;
        this.arBusinessRegion = arBusinessRegion;
        this.azcBusinessZipcode = azcBusinessZipcode;
        this.apiBusinessState = apiBusinessState;
        this.apiBusinessType = apiBusinessType;
        this.apiMerchandiseType = apiMerchandiseType;
        this.apiBusinessPhone = apiBusinessPhone;
        this.apiOpenMonths = apiOpenMonths;
        this.apiBankruptcyFiled = apiBankruptcyFiled;
        this.apiTimeCurrbusiYrs = apiTimeCurrbusiYrs;
        this.apiTimeCurrbusiMnths = apiTimeCurrbusiMnths;
        this.apiSecoffLastNm = apiSecoffLastNm;
        this.apiSecoffFirstNm = apiSecoffFirstNm;
        this.apiCommissionYn = apiCommissionYn;
        this.apiSecurityRequired = apiSecurityRequired;
        this.apiDesig = apiDesig;
        this.apiAllowSecProv = apiAllowSecProv;
        this.apiWhoLog = apiWhoLog;
        this.apiWhenLog = apiWhenLog;
    }
    
    /** full constructor */
    public AlsProviderInfo(String apiProviderCat, String apiProviderClass, String apiSecurityReqMet, String apiApplicantLastNm, String apiApplicantFirstNm, String apiApplicantMidInit, String apiBusinessNm, String apiBusinessAddress, String apiBusinessCity, String acBusinessCounty, String arBusinessRegion, String azcBusinessZipcode, String apiBusinessState, String apiBusinessType, String apiMerchandiseType, String apiBusinessEin, String apiBusinessPhone, String apiBusinessFax, String apiBusinessEmail, String apiApplicantHomephone, Integer apiPersonsTraining, String apiOpenHolidays, String apiOpenMonths, String apiApplicantSsn, String apiBankruptcyFiled, Integer apiTimeCurrbusiYrs, Integer apiTimeCurrbusiMnths, Timestamp apiWardenRdate, Timestamp apiRegionalRdate, String apiSecoffLastNm, String apiSecoffFirstNm, String apiSecoffMidInit, Integer acdCcNo, Integer apiDesiredNodevices, Integer apiDevicesApproved, Integer apiFeeExempted, String apiCommissionYn, Timestamp apiDesiredStartdate, Timestamp apiStartdate, String apiSecurityRequired, String apiDesig, String apiAllowSecProv, String apiWhoLog, Timestamp apiWhenLog, String apiCommissionSi, Double apiSessCommAmount, String apiSslFlag, String atiTribeCd, Double apiMixSessCommAmt, Double apiSpSessCommAmt, String apiAlxProvInd, Integer apiPrimaryProviderNo, String apiSpecDevConfig, String apiSpecConfigInd) {
        this.apiProviderCat = apiProviderCat;
        this.apiProviderClass = apiProviderClass;
        this.apiSecurityReqMet = apiSecurityReqMet;
        this.apiApplicantLastNm = apiApplicantLastNm;
        this.apiApplicantFirstNm = apiApplicantFirstNm;
        this.apiApplicantMidInit = apiApplicantMidInit;
        this.apiBusinessNm = apiBusinessNm;
        this.apiBusinessAddress = apiBusinessAddress;
        this.apiBusinessCity = apiBusinessCity;
        this.acBusinessCounty = acBusinessCounty;
        this.arBusinessRegion = arBusinessRegion;
        this.azcBusinessZipcode = azcBusinessZipcode;
        this.apiBusinessState = apiBusinessState;
        this.apiBusinessType = apiBusinessType;
        this.apiMerchandiseType = apiMerchandiseType;
        this.apiBusinessEin = apiBusinessEin;
        this.apiBusinessPhone = apiBusinessPhone;
        this.apiBusinessFax = apiBusinessFax;
        this.apiBusinessEmail = apiBusinessEmail;
        this.apiApplicantHomephone = apiApplicantHomephone;
        this.apiPersonsTraining = apiPersonsTraining;
        this.apiOpenHolidays = apiOpenHolidays;
        this.apiOpenMonths = apiOpenMonths;
        this.apiApplicantSsn = apiApplicantSsn;
        this.apiBankruptcyFiled = apiBankruptcyFiled;
        this.apiTimeCurrbusiYrs = apiTimeCurrbusiYrs;
        this.apiTimeCurrbusiMnths = apiTimeCurrbusiMnths;
        this.apiWardenRdate = apiWardenRdate;
        this.apiRegionalRdate = apiRegionalRdate;
        this.apiSecoffLastNm = apiSecoffLastNm;
        this.apiSecoffFirstNm = apiSecoffFirstNm;
        this.apiSecoffMidInit = apiSecoffMidInit;
        this.acdCcNo = acdCcNo;
        this.apiDesiredNodevices = apiDesiredNodevices;
        this.apiDevicesApproved = apiDevicesApproved;
        this.apiFeeExempted = apiFeeExempted;
        this.apiCommissionYn = apiCommissionYn;
        this.apiDesiredStartdate = apiDesiredStartdate;
        this.apiStartdate = apiStartdate;
        this.apiSecurityRequired = apiSecurityRequired;
        this.apiDesig = apiDesig;
        this.apiAllowSecProv = apiAllowSecProv;
        this.apiWhoLog = apiWhoLog;
        this.apiWhenLog = apiWhenLog;
        this.apiCommissionSi = apiCommissionSi;
        this.apiSessCommAmount = apiSessCommAmount;
        this.apiSslFlag = apiSslFlag;
        this.atiTribeCd = atiTribeCd;
        this.apiMixSessCommAmt = apiMixSessCommAmt;
        this.apiSpSessCommAmt = apiSpSessCommAmt;
        this.apiAlxProvInd = apiAlxProvInd;
        this.apiPrimaryProviderNo = apiPrimaryProviderNo;
        this.apiSpecDevConfig = apiSpecDevConfig;
        this.apiSpecConfigInd = apiSpecConfigInd;
    }

   
    // Property accessors
    @Id

    @Column(name="API_PROVIDER_NO", unique=true, nullable=false, precision=10, scale=0)

    public Integer getApiProviderNo() {
        return this.apiProviderNo;
    }
    
    public void setApiProviderNo(Integer apiProviderNo) {
        this.apiProviderNo = apiProviderNo;
    }
    
    @Column(name="API_PROVIDER_CAT", nullable=false, length=1)

    public String getApiProviderCat() {
        return this.apiProviderCat;
    }
    
    public void setApiProviderCat(String apiProviderCat) {
        this.apiProviderCat = apiProviderCat;
    }
    
    @Column(name="API_PROVIDER_CLASS", nullable=false, length=1)

    public String getApiProviderClass() {
        return this.apiProviderClass;
    }
    
    public void setApiProviderClass(String apiProviderClass) {
        this.apiProviderClass = apiProviderClass;
    }
    
    @Column(name="API_SECURITY_REQ_MET", nullable=false, length=1)

    public String getApiSecurityReqMet() {
        return this.apiSecurityReqMet;
    }
    
    public void setApiSecurityReqMet(String apiSecurityReqMet) {
        this.apiSecurityReqMet = apiSecurityReqMet;
    }
    
    @Column(name="API_APPLICANT_LAST_NM", nullable=false, length=15)

    public String getApiApplicantLastNm() {
        return this.apiApplicantLastNm;
    }
    
    public void setApiApplicantLastNm(String apiApplicantLastNm) {
        this.apiApplicantLastNm = apiApplicantLastNm;
    }
    
    @Column(name="API_APPLICANT_FIRST_NM", nullable=false, length=15)

    public String getApiApplicantFirstNm() {
        return this.apiApplicantFirstNm;
    }
    
    public void setApiApplicantFirstNm(String apiApplicantFirstNm) {
        this.apiApplicantFirstNm = apiApplicantFirstNm;
    }
    
    @Column(name="API_APPLICANT_MID_INIT", length=1)

    public String getApiApplicantMidInit() {
        return this.apiApplicantMidInit;
    }
    
    public void setApiApplicantMidInit(String apiApplicantMidInit) {
        this.apiApplicantMidInit = apiApplicantMidInit;
    }
    
    @Column(name="API_BUSINESS_NM", nullable=false, length=35)

    public String getApiBusinessNm() {
        return this.apiBusinessNm;
    }
    
    public void setApiBusinessNm(String apiBusinessNm) {
        this.apiBusinessNm = apiBusinessNm;
    }
    
    @Column(name="API_BUSINESS_ADDRESS", nullable=false, length=35)

    public String getApiBusinessAddress() {
        return this.apiBusinessAddress;
    }
    
    public void setApiBusinessAddress(String apiBusinessAddress) {
        this.apiBusinessAddress = apiBusinessAddress;
    }
    
    @Column(name="API_BUSINESS_CITY", nullable=false, length=35)

    public String getApiBusinessCity() {
        return this.apiBusinessCity;
    }
    
    public void setApiBusinessCity(String apiBusinessCity) {
        this.apiBusinessCity = apiBusinessCity;
    }
    
    @Column(name="AC_BUSINESS_COUNTY", nullable=false, length=3)

    public String getAcBusinessCounty() {
        return this.acBusinessCounty;
    }
    
    public void setAcBusinessCounty(String acBusinessCounty) {
        this.acBusinessCounty = acBusinessCounty;
    }
    
    @Column(name="AR_BUSINESS_REGION", nullable=false, length=2)

    public String getArBusinessRegion() {
        return this.arBusinessRegion;
    }
    
    public void setArBusinessRegion(String arBusinessRegion) {
        this.arBusinessRegion = arBusinessRegion;
    }
    
    @Column(name="AZC_BUSINESS_ZIPCODE", nullable=false, length=10)

    public String getAzcBusinessZipcode() {
        return this.azcBusinessZipcode;
    }
    
    public void setAzcBusinessZipcode(String azcBusinessZipcode) {
        this.azcBusinessZipcode = azcBusinessZipcode;
    }
    
    @Column(name="API_BUSINESS_STATE", nullable=false, length=2)

    public String getApiBusinessState() {
        return this.apiBusinessState;
    }
    
    public void setApiBusinessState(String apiBusinessState) {
        this.apiBusinessState = apiBusinessState;
    }
    
    @Column(name="API_BUSINESS_TYPE", nullable=false, length=1)

    public String getApiBusinessType() {
        return this.apiBusinessType;
    }
    
    public void setApiBusinessType(String apiBusinessType) {
        this.apiBusinessType = apiBusinessType;
    }
    
    @Column(name="API_MERCHANDISE_TYPE", nullable=false, length=1)

    public String getApiMerchandiseType() {
        return this.apiMerchandiseType;
    }
    
    public void setApiMerchandiseType(String apiMerchandiseType) {
        this.apiMerchandiseType = apiMerchandiseType;
    }
    
    @Column(name="API_BUSINESS_EIN", length=9)

    public String getApiBusinessEin() {
        return this.apiBusinessEin;
    }
    
    public void setApiBusinessEin(String apiBusinessEin) {
        this.apiBusinessEin = apiBusinessEin;
    }
    
    @Column(name="API_BUSINESS_PHONE", nullable=false, length=14)

    public String getApiBusinessPhone() {
        return this.apiBusinessPhone;
    }
    
    public void setApiBusinessPhone(String apiBusinessPhone) {
        this.apiBusinessPhone = apiBusinessPhone;
    }
    
    @Column(name="API_BUSINESS_FAX", length=14)

    public String getApiBusinessFax() {
        return this.apiBusinessFax;
    }
    
    public void setApiBusinessFax(String apiBusinessFax) {
        this.apiBusinessFax = apiBusinessFax;
    }
    
    @Column(name="API_BUSINESS_EMAIL", length=100)

    public String getApiBusinessEmail() {
        return this.apiBusinessEmail;
    }
    
    public void setApiBusinessEmail(String apiBusinessEmail) {
        this.apiBusinessEmail = apiBusinessEmail;
    }
    
    @Column(name="API_APPLICANT_HOMEPHONE", length=14)

    public String getApiApplicantHomephone() {
        return this.apiApplicantHomephone;
    }
    
    public void setApiApplicantHomephone(String apiApplicantHomephone) {
        this.apiApplicantHomephone = apiApplicantHomephone;
    }
    
    @Column(name="API_PERSONS_TRAINING", precision=3, scale=0)

    public Integer getApiPersonsTraining() {
        return this.apiPersonsTraining;
    }
    
    public void setApiPersonsTraining(Integer apiPersonsTraining) {
        this.apiPersonsTraining = apiPersonsTraining;
    }
    
    @Column(name="API_OPEN_HOLIDAYS", length=1)

    public String getApiOpenHolidays() {
        return this.apiOpenHolidays;
    }
    
    public void setApiOpenHolidays(String apiOpenHolidays) {
        this.apiOpenHolidays = apiOpenHolidays;
    }
    
    @Column(name="API_OPEN_MONTHS", nullable=false, length=12)

    public String getApiOpenMonths() {
        return this.apiOpenMonths;
    }
    
    public void setApiOpenMonths(String apiOpenMonths) {
        this.apiOpenMonths = apiOpenMonths;
    }
    
    @Column(name="API_APPLICANT_SSN", length=9)

    public String getApiApplicantSsn() {
        return this.apiApplicantSsn;
    }
    
    public void setApiApplicantSsn(String apiApplicantSsn) {
        this.apiApplicantSsn = apiApplicantSsn;
    }
    
    @Column(name="API_BANKRUPTCY_FILED", nullable=false, length=1)

    public String getApiBankruptcyFiled() {
        return this.apiBankruptcyFiled;
    }
    
    public void setApiBankruptcyFiled(String apiBankruptcyFiled) {
        this.apiBankruptcyFiled = apiBankruptcyFiled;
    }
    
    @Column(name="API_TIME_CURRBUSI_YRS", nullable=false, precision=3, scale=0)

    public Integer getApiTimeCurrbusiYrs() {
        return this.apiTimeCurrbusiYrs;
    }
    
    public void setApiTimeCurrbusiYrs(Integer apiTimeCurrbusiYrs) {
        this.apiTimeCurrbusiYrs = apiTimeCurrbusiYrs;
    }
    
    @Column(name="API_TIME_CURRBUSI_MNTHS", nullable=false, precision=3, scale=0)

    public Integer getApiTimeCurrbusiMnths() {
        return this.apiTimeCurrbusiMnths;
    }
    
    public void setApiTimeCurrbusiMnths(Integer apiTimeCurrbusiMnths) {
        this.apiTimeCurrbusiMnths = apiTimeCurrbusiMnths;
    }
    
    @Column(name="API_WARDEN_RDATE", length=7)

    public Timestamp getApiWardenRdate() {
        return this.apiWardenRdate;
    }
    
    public void setApiWardenRdate(Timestamp apiWardenRdate) {
        this.apiWardenRdate = apiWardenRdate;
    }
    
    @Column(name="API_REGIONAL_RDATE", length=7)

    public Timestamp getApiRegionalRdate() {
        return this.apiRegionalRdate;
    }
    
    public void setApiRegionalRdate(Timestamp apiRegionalRdate) {
        this.apiRegionalRdate = apiRegionalRdate;
    }
    
    @Column(name="API_SECOFF_LAST_NM", nullable=false, length=15)

    public String getApiSecoffLastNm() {
        return this.apiSecoffLastNm;
    }
    
    public void setApiSecoffLastNm(String apiSecoffLastNm) {
        this.apiSecoffLastNm = apiSecoffLastNm;
    }
    
    @Column(name="API_SECOFF_FIRST_NM", nullable=false, length=15)

    public String getApiSecoffFirstNm() {
        return this.apiSecoffFirstNm;
    }
    
    public void setApiSecoffFirstNm(String apiSecoffFirstNm) {
        this.apiSecoffFirstNm = apiSecoffFirstNm;
    }
    
    @Column(name="API_SECOFF_MID_INIT", length=1)

    public String getApiSecoffMidInit() {
        return this.apiSecoffMidInit;
    }
    
    public void setApiSecoffMidInit(String apiSecoffMidInit) {
        this.apiSecoffMidInit = apiSecoffMidInit;
    }
    
    @Column(name="ACD_CC_NO", precision=5, scale=0)

    public Integer getAcdCcNo() {
        return this.acdCcNo;
    }
    
    public void setAcdCcNo(Integer acdCcNo) {
        this.acdCcNo = acdCcNo;
    }
    
    @Column(name="API_DESIRED_NODEVICES", precision=2, scale=0)

    public Integer getApiDesiredNodevices() {
        return this.apiDesiredNodevices;
    }
    
    public void setApiDesiredNodevices(Integer apiDesiredNodevices) {
        this.apiDesiredNodevices = apiDesiredNodevices;
    }
    
    @Column(name="API_DEVICES_APPROVED", precision=2, scale=0)

    public Integer getApiDevicesApproved() {
        return this.apiDevicesApproved;
    }
    
    public void setApiDevicesApproved(Integer apiDevicesApproved) {
        this.apiDevicesApproved = apiDevicesApproved;
    }
    
    @Column(name="API_FEE_EXEMPTED", precision=2, scale=0)

    public Integer getApiFeeExempted() {
        return this.apiFeeExempted;
    }
    
    public void setApiFeeExempted(Integer apiFeeExempted) {
        this.apiFeeExempted = apiFeeExempted;
    }
    
    @Column(name="API_COMMISSION_YN", nullable=false, length=1)

    public String getApiCommissionYn() {
        return this.apiCommissionYn;
    }
    
    public void setApiCommissionYn(String apiCommissionYn) {
        this.apiCommissionYn = apiCommissionYn;
    }
    
    @Column(name="API_DESIRED_STARTDATE", length=7)

    public Timestamp getApiDesiredStartdate() {
        return this.apiDesiredStartdate;
    }
    
    public void setApiDesiredStartdate(Timestamp apiDesiredStartdate) {
        this.apiDesiredStartdate = apiDesiredStartdate;
    }
    
    @Column(name="API_STARTDATE", length=7)

    public Timestamp getApiStartdate() {
        return this.apiStartdate;
    }
    
    public void setApiStartdate(Timestamp apiStartdate) {
        this.apiStartdate = apiStartdate;
    }
    
    @Column(name="API_SECURITY_REQUIRED", nullable=false, length=1)

    public String getApiSecurityRequired() {
        return this.apiSecurityRequired;
    }
    
    public void setApiSecurityRequired(String apiSecurityRequired) {
        this.apiSecurityRequired = apiSecurityRequired;
    }
    
    @Column(name="API_DESIG", nullable=false, length=1)

    public String getApiDesig() {
        return this.apiDesig;
    }
    
    public void setApiDesig(String apiDesig) {
        this.apiDesig = apiDesig;
    }
    
    @Column(name="API_ALLOW_SEC_PROV", nullable=false, length=1)

    public String getApiAllowSecProv() {
        return this.apiAllowSecProv;
    }
    
    public void setApiAllowSecProv(String apiAllowSecProv) {
        this.apiAllowSecProv = apiAllowSecProv;
    }
    
    @Column(name="API_WHO_LOG", nullable=false, length=15)

    public String getApiWhoLog() {
        return this.apiWhoLog;
    }
    
    public void setApiWhoLog(String apiWhoLog) {
        this.apiWhoLog = apiWhoLog;
    }
    
    @Column(name="API_WHEN_LOG", nullable=false, length=7)

    public Timestamp getApiWhenLog() {
        return this.apiWhenLog;
    }
    
    public void setApiWhenLog(Timestamp apiWhenLog) {
        this.apiWhenLog = apiWhenLog;
    }
    
    @Column(name="API_COMMISSION_SI", length=1)

    public String getApiCommissionSi() {
        return this.apiCommissionSi;
    }
    
    public void setApiCommissionSi(String apiCommissionSi) {
        this.apiCommissionSi = apiCommissionSi;
    }
    
    @Column(name="API_SESS_COMM_AMOUNT", precision=5)

    public Double getApiSessCommAmount() {
        return this.apiSessCommAmount;
    }
    
    public void setApiSessCommAmount(Double apiSessCommAmount) {
        this.apiSessCommAmount = apiSessCommAmount;
    }
    
    @Column(name="API_SSL_FLAG", length=1)

    public String getApiSslFlag() {
        return this.apiSslFlag;
    }
    
    public void setApiSslFlag(String apiSslFlag) {
        this.apiSslFlag = apiSslFlag;
    }
    
    @Column(name="ATI_TRIBE_CD", length=3)

    public String getAtiTribeCd() {
        return this.atiTribeCd;
    }
    
    public void setAtiTribeCd(String atiTribeCd) {
        this.atiTribeCd = atiTribeCd;
    }
    
    @Column(name="API_MIX_SESS_COMM_AMT", precision=5)

    public Double getApiMixSessCommAmt() {
        return this.apiMixSessCommAmt;
    }
    
    public void setApiMixSessCommAmt(Double apiMixSessCommAmt) {
        this.apiMixSessCommAmt = apiMixSessCommAmt;
    }
    
    @Column(name="API_SP_SESS_COMM_AMT", precision=5)

    public Double getApiSpSessCommAmt() {
        return this.apiSpSessCommAmt;
    }
    
    public void setApiSpSessCommAmt(Double apiSpSessCommAmt) {
        this.apiSpSessCommAmt = apiSpSessCommAmt;
    }
    
    @Column(name="API_ALX_PROV_IND", length=1)

    public String getApiAlxProvInd() {
        return this.apiAlxProvInd;
    }
    
    public void setApiAlxProvInd(String apiAlxProvInd) {
        this.apiAlxProvInd = apiAlxProvInd;
    }
    
    @Column(name="API_PRIMARY_PROVIDER_NO", precision=10, scale=0)

    public Integer getApiPrimaryProviderNo() {
        return this.apiPrimaryProviderNo;
    }
    
    public void setApiPrimaryProviderNo(Integer apiPrimaryProviderNo) {
        this.apiPrimaryProviderNo = apiPrimaryProviderNo;
    }
    
    @Column(name="API_SPEC_DEV_CONFIG", length=512)

    public String getApiSpecDevConfig() {
        return this.apiSpecDevConfig;
    }
    
    public void setApiSpecDevConfig(String apiSpecDevConfig) {
        this.apiSpecDevConfig = apiSpecDevConfig;
    }
    
    @Column(name="API_SPEC_CONFIG_IND", length=1)

    public String getApiSpecConfigInd() {
        return this.apiSpecConfigInd;
    }
    
    public void setApiSpecConfigInd(String apiSpecConfigInd) {
        this.apiSpecConfigInd = apiSpecConfigInd;
    }
   








}