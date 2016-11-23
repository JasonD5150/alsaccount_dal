package fwp.alsaccount.dao.refund;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * AlsWarrantStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_WARRANT_STATUS"
    ,schema="ALS"
)

public class AlsWarrantStatus  implements java.io.Serializable {


    // Fields    

     private Integer awsId;
     private String awsRsamCode;
     private String awsWarrantType;
     private String awsPaymentId;
     private String awsPaymentStatus;
     private Timestamp awsPaymentDate;
     private String awsCancelAction;
     private String awsReconStatus;
     private Timestamp awsReconDate;
     private String awsStaledateStatus;
     private Timestamp awsStaledateDate;
     private Timestamp awsStaledateActDate;
     private Double awsPaidAmount;
     private String awsTransRefNo;
     private String awsPaymentMethod;
     private String awsVendorId;
     private Timestamp awsProcessDate;
     private String awsVoucherId;
     private String awsApBusinessUnit;
     private Double awsPaymentGrossAmount;
     private String awsPreviousPaymentId;
     private Timestamp awsProcessFromDate;
     private String awsComment;


    // Constructors

    /** default constructor */
    public AlsWarrantStatus() {
    }

	/** minimal constructor */
    public AlsWarrantStatus(String awsWarrantType, String awsPaymentStatus, Timestamp awsPaymentDate, Double awsPaidAmount, Timestamp awsProcessDate, String awsVoucherId, String awsApBusinessUnit, Double awsPaymentGrossAmount) {
        this.awsWarrantType = awsWarrantType;
        this.awsPaymentStatus = awsPaymentStatus;
        this.awsPaymentDate = awsPaymentDate;
        this.awsPaidAmount = awsPaidAmount;
        this.awsProcessDate = awsProcessDate;
        this.awsVoucherId = awsVoucherId;
        this.awsApBusinessUnit = awsApBusinessUnit;
        this.awsPaymentGrossAmount = awsPaymentGrossAmount;
    }
    
    /** full constructor */
    public AlsWarrantStatus(String awsRsamCode, String awsWarrantType, String awsPaymentId, String awsPaymentStatus, Timestamp awsPaymentDate, String awsCancelAction, String awsReconStatus, Timestamp awsReconDate, String awsStaledateStatus, Timestamp awsStaledateDate, Timestamp awsStaledateActDate, Double awsPaidAmount, String awsTransRefNo, String awsPaymentMethod, String awsVendorId, Timestamp awsProcessDate, String awsVoucherId, String awsApBusinessUnit, Double awsPaymentGrossAmount, String awsPreviousPaymentId, Timestamp awsProcessFromDate, String awsComment) {
        this.awsRsamCode = awsRsamCode;
        this.awsWarrantType = awsWarrantType;
        this.awsPaymentId = awsPaymentId;
        this.awsPaymentStatus = awsPaymentStatus;
        this.awsPaymentDate = awsPaymentDate;
        this.awsCancelAction = awsCancelAction;
        this.awsReconStatus = awsReconStatus;
        this.awsReconDate = awsReconDate;
        this.awsStaledateStatus = awsStaledateStatus;
        this.awsStaledateDate = awsStaledateDate;
        this.awsStaledateActDate = awsStaledateActDate;
        this.awsPaidAmount = awsPaidAmount;
        this.awsTransRefNo = awsTransRefNo;
        this.awsPaymentMethod = awsPaymentMethod;
        this.awsVendorId = awsVendorId;
        this.awsProcessDate = awsProcessDate;
        this.awsVoucherId = awsVoucherId;
        this.awsApBusinessUnit = awsApBusinessUnit;
        this.awsPaymentGrossAmount = awsPaymentGrossAmount;
        this.awsPreviousPaymentId = awsPreviousPaymentId;
        this.awsProcessFromDate = awsProcessFromDate;
        this.awsComment = awsComment;
    }

   
    // Property accessors
    @SequenceGenerator(name="generator", sequenceName="ALS.ALS_APP_SEQ")@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")
    
    @Column(name="AWS_ID", unique=true, nullable=false, precision=10, scale=0)

    public Integer getAwsId() {
        return this.awsId;
    }
    
    public void setAwsId(Integer awsId) {
        this.awsId = awsId;
    }
    
    @Column(name="AWS_RSAM_CODE", length=1)

    public String getAwsRsamCode() {
        return this.awsRsamCode;
    }
    
    public void setAwsRsamCode(String awsRsamCode) {
        this.awsRsamCode = awsRsamCode;
    }
    
    @Column(name="AWS_WARRANT_TYPE", nullable=false, length=3)

    public String getAwsWarrantType() {
        return this.awsWarrantType;
    }
    
    public void setAwsWarrantType(String awsWarrantType) {
        this.awsWarrantType = awsWarrantType;
    }
    
    @Column(name="AWS_PAYMENT_ID", length=10)

    public String getAwsPaymentId() {
        return this.awsPaymentId;
    }
    
    public void setAwsPaymentId(String awsPaymentId) {
        this.awsPaymentId = awsPaymentId;
    }
    
    @Column(name="AWS_PAYMENT_STATUS", nullable=false, length=1)

    public String getAwsPaymentStatus() {
        return this.awsPaymentStatus;
    }
    
    public void setAwsPaymentStatus(String awsPaymentStatus) {
        this.awsPaymentStatus = awsPaymentStatus;
    }
    
    @Column(name="AWS_PAYMENT_DATE", nullable=false, length=7)

    public Timestamp getAwsPaymentDate() {
        return this.awsPaymentDate;
    }
    
    public void setAwsPaymentDate(Timestamp awsPaymentDate) {
        this.awsPaymentDate = awsPaymentDate;
    }
    
    @Column(name="AWS_CANCEL_ACTION", length=1)

    public String getAwsCancelAction() {
        return this.awsCancelAction;
    }
    
    public void setAwsCancelAction(String awsCancelAction) {
        this.awsCancelAction = awsCancelAction;
    }
    
    @Column(name="AWS_RECON_STATUS", length=3)

    public String getAwsReconStatus() {
        return this.awsReconStatus;
    }
    
    public void setAwsReconStatus(String awsReconStatus) {
        this.awsReconStatus = awsReconStatus;
    }
    
    @Column(name="AWS_RECON_DATE", length=7)

    public Timestamp getAwsReconDate() {
        return this.awsReconDate;
    }
    
    public void setAwsReconDate(Timestamp awsReconDate) {
        this.awsReconDate = awsReconDate;
    }
    
    @Column(name="AWS_STALEDATE_STATUS", length=1)

    public String getAwsStaledateStatus() {
        return this.awsStaledateStatus;
    }
    
    public void setAwsStaledateStatus(String awsStaledateStatus) {
        this.awsStaledateStatus = awsStaledateStatus;
    }
    
    @Column(name="AWS_STALEDATE_DATE", length=7)

    public Timestamp getAwsStaledateDate() {
        return this.awsStaledateDate;
    }
    
    public void setAwsStaledateDate(Timestamp awsStaledateDate) {
        this.awsStaledateDate = awsStaledateDate;
    }
    
    @Column(name="AWS_STALEDATE_ACT_DATE", length=7)

    public Timestamp getAwsStaledateActDate() {
        return this.awsStaledateActDate;
    }
    
    public void setAwsStaledateActDate(Timestamp awsStaledateActDate) {
        this.awsStaledateActDate = awsStaledateActDate;
    }
    
    @Column(name="AWS_PAID_AMOUNT", nullable=false, precision=17)

    public Double getAwsPaidAmount() {
        return this.awsPaidAmount;
    }
    
    public void setAwsPaidAmount(Double awsPaidAmount) {
        this.awsPaidAmount = awsPaidAmount;
    }
    
    @Column(name="AWS_TRANS_REF_NO", length=30)

    public String getAwsTransRefNo() {
        return this.awsTransRefNo;
    }
    
    public void setAwsTransRefNo(String awsTransRefNo) {
        this.awsTransRefNo = awsTransRefNo;
    }
    
    @Column(name="AWS_PAYMENT_METHOD", length=3)

    public String getAwsPaymentMethod() {
        return this.awsPaymentMethod;
    }
    
    public void setAwsPaymentMethod(String awsPaymentMethod) {
        this.awsPaymentMethod = awsPaymentMethod;
    }
    
    @Column(name="AWS_VENDOR_ID", length=10)

    public String getAwsVendorId() {
        return this.awsVendorId;
    }
    
    public void setAwsVendorId(String awsVendorId) {
        this.awsVendorId = awsVendorId;
    }
    
    @Column(name="AWS_PROCESS_DATE", nullable=false, length=7)

    public Timestamp getAwsProcessDate() {
        return this.awsProcessDate;
    }
    
    public void setAwsProcessDate(Timestamp awsProcessDate) {
        this.awsProcessDate = awsProcessDate;
    }
    
    @Column(name="AWS_VOUCHER_ID", nullable=false, length=8)

    public String getAwsVoucherId() {
        return this.awsVoucherId;
    }
    
    public void setAwsVoucherId(String awsVoucherId) {
        this.awsVoucherId = awsVoucherId;
    }
    
    @Column(name="AWS_AP_BUSINESS_UNIT", nullable=false, length=5)

    public String getAwsApBusinessUnit() {
        return this.awsApBusinessUnit;
    }
    
    public void setAwsApBusinessUnit(String awsApBusinessUnit) {
        this.awsApBusinessUnit = awsApBusinessUnit;
    }
    
    @Column(name="AWS_PAYMENT_GROSS_AMOUNT", nullable=false, precision=17)

    public Double getAwsPaymentGrossAmount() {
        return this.awsPaymentGrossAmount;
    }
    
    public void setAwsPaymentGrossAmount(Double awsPaymentGrossAmount) {
        this.awsPaymentGrossAmount = awsPaymentGrossAmount;
    }
    
    @Column(name="AWS_PREVIOUS_PAYMENT_ID", length=10)

    public String getAwsPreviousPaymentId() {
        return this.awsPreviousPaymentId;
    }
    
    public void setAwsPreviousPaymentId(String awsPreviousPaymentId) {
        this.awsPreviousPaymentId = awsPreviousPaymentId;
    }
    
    @Column(name="AWS_PROCESS_FROM_DATE", length=7)

    public Timestamp getAwsProcessFromDate() {
        return this.awsProcessFromDate;
    }
    
    public void setAwsProcessFromDate(Timestamp awsProcessFromDate) {
        this.awsProcessFromDate = awsProcessFromDate;
    }
    
    @Column(name="AWS_COMMENT", length=254)

    public String getAwsComment() {
        return this.awsComment;
    }
    
    public void setAwsComment(String awsComment) {
        this.awsComment = awsComment;
    }
   








}