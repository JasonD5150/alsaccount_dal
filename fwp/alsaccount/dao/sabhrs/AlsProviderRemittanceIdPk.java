package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * sabhrsAlsProviderRemittanceIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsProviderRemittanceIdPk  implements java.io.Serializable {


    // Fields    

     private Integer apiProviderNo;
     private Timestamp aprBillingFrom;
     private Timestamp aprBillingTo;


    // Constructors

    /** default constructor */
    public AlsProviderRemittanceIdPk() {
    }

    
    /** full constructor */
    public AlsProviderRemittanceIdPk(Integer apiProviderNo, Timestamp aprBillingFrom, Timestamp aprBillingTo) {
        this.apiProviderNo = apiProviderNo;
        this.aprBillingFrom = aprBillingFrom;
        this.aprBillingTo = aprBillingTo;
    }

   
    // Property accessors

    @Column(name="API_PROVIDER_NO", nullable=false, precision=10, scale=0)

    public Integer getApiProviderNo() {
        return this.apiProviderNo;
    }
    
    public void setApiProviderNo(Integer apiProviderNo) {
        this.apiProviderNo = apiProviderNo;
    }

    @Column(name="APR_BILLING_FROM", nullable=false, length=7)

    public Timestamp getAprBillingFrom() {
        return this.aprBillingFrom;
    }
    
    public void setAprBillingFrom(Timestamp aprBillingFrom) {
        this.aprBillingFrom = aprBillingFrom;
    }

    @Column(name="APR_BILLING_TO", nullable=false, length=7)

    public Timestamp getAprBillingTo() {
        return this.aprBillingTo;
    }
    
    public void setAprBillingTo(Timestamp aprBillingTo) {
        this.aprBillingTo = aprBillingTo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsProviderRemittanceIdPk) ) return false;
		 AlsProviderRemittanceIdPk castOther = ( AlsProviderRemittanceIdPk ) other; 
         
		 return ( (this.getApiProviderNo()==castOther.getApiProviderNo()) || ( this.getApiProviderNo()!=null && castOther.getApiProviderNo()!=null && this.getApiProviderNo().equals(castOther.getApiProviderNo()) ) )
 && ( (this.getAprBillingFrom()==castOther.getAprBillingFrom()) || ( this.getAprBillingFrom()!=null && castOther.getAprBillingFrom()!=null && this.getAprBillingFrom().equals(castOther.getAprBillingFrom()) ) )
 && ( (this.getAprBillingTo()==castOther.getAprBillingTo()) || ( this.getAprBillingTo()!=null && castOther.getAprBillingTo()!=null && this.getAprBillingTo().equals(castOther.getAprBillingTo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getApiProviderNo() == null ? 0 : this.getApiProviderNo().hashCode() );
         result = 37 * result + ( getAprBillingFrom() == null ? 0 : this.getAprBillingFrom().hashCode() );
         result = 37 * result + ( getAprBillingTo() == null ? 0 : this.getAprBillingTo().hashCode() );
         return result;
   }   





}