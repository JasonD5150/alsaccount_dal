package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * sabhrsAlsProviderBankDetailsIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsProviderBankDetailsIdPk  implements java.io.Serializable {


    // Fields    

     private Integer apiProviderNo;
     private Timestamp apbdBillingTo;
     private Integer apbdSeqNo;


    // Constructors

    /** default constructor */
    public AlsProviderBankDetailsIdPk() {
    }

    
    /** full constructor */
    public AlsProviderBankDetailsIdPk(Integer apiProviderNo, Timestamp apbdBillingTo, Integer apbdSeqNo) {
        this.apiProviderNo = apiProviderNo;
        this.apbdBillingTo = apbdBillingTo;
        this.apbdSeqNo = apbdSeqNo;
    }

   
    // Property accessors

    @Column(name="API_PROVIDER_NO", nullable=false, precision=10, scale=0)

    public Integer getApiProviderNo() {
        return this.apiProviderNo;
    }
    
    public void setApiProviderNo(Integer apiProviderNo) {
        this.apiProviderNo = apiProviderNo;
    }

    @Column(name="APBD_BILLING_TO", nullable=false, length=7)

    public Timestamp getApbdBillingTo() {
        return this.apbdBillingTo;
    }
    
    public void setApbdBillingTo(Timestamp apbdBillingTo) {
        this.apbdBillingTo = apbdBillingTo;
    }

    @Column(name="APBD_SEQ_NO", nullable=false, precision=2, scale=0)

    public Integer getApbdSeqNo() {
        return this.apbdSeqNo;
    }
    
    public void setApbdSeqNo(Integer apbdSeqNo) {
        this.apbdSeqNo = apbdSeqNo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsProviderBankDetailsIdPk) ) return false;
		 AlsProviderBankDetailsIdPk castOther = ( AlsProviderBankDetailsIdPk ) other; 
         
		 return ( (this.getApiProviderNo()==castOther.getApiProviderNo()) || ( this.getApiProviderNo()!=null && castOther.getApiProviderNo()!=null && this.getApiProviderNo().equals(castOther.getApiProviderNo()) ) )
 && ( (this.getApbdBillingTo()==castOther.getApbdBillingTo()) || ( this.getApbdBillingTo()!=null && castOther.getApbdBillingTo()!=null && this.getApbdBillingTo().equals(castOther.getApbdBillingTo()) ) )
 && ( (this.getApbdSeqNo()==castOther.getApbdSeqNo()) || ( this.getApbdSeqNo()!=null && castOther.getApbdSeqNo()!=null && this.getApbdSeqNo().equals(castOther.getApbdSeqNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getApiProviderNo() == null ? 0 : this.getApiProviderNo().hashCode() );
         result = 37 * result + ( getApbdBillingTo() == null ? 0 : this.getApbdBillingTo().hashCode() );
         result = 37 * result + ( getApbdSeqNo() == null ? 0 : this.getApbdSeqNo().hashCode() );
         return result;
   }   





}