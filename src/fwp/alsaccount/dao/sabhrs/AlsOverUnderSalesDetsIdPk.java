package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsOverUnderSalesDetsIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsOverUnderSalesDetsIdPk  implements java.io.Serializable {


    // Fields    

     private Integer apiProviderNo;
     private Timestamp airBillingFrom;
     private Timestamp airBillingTo;
     private Integer aousdSeqNo;


    // Constructors

    /** default constructor */
    public AlsOverUnderSalesDetsIdPk() {
    }

    
    /** full constructor */
    public AlsOverUnderSalesDetsIdPk(Integer apiProviderNo, Timestamp airBillingFrom, Timestamp airBillingTo, Integer aousdSeqNo) {
        this.apiProviderNo = apiProviderNo;
        this.airBillingFrom = airBillingFrom;
        this.airBillingTo = airBillingTo;
        this.aousdSeqNo = aousdSeqNo;
    }

   
    // Property accessors

    @Column(name="API_PROVIDER_NO", nullable=false, precision=10, scale=0)

    public Integer getApiProviderNo() {
        return this.apiProviderNo;
    }
    
    public void setApiProviderNo(Integer apiProviderNo) {
        this.apiProviderNo = apiProviderNo;
    }

    @Column(name="AIR_BILLING_FROM", nullable=false, length=7)

    public Timestamp getAirBillingFrom() {
        return this.airBillingFrom;
    }
    
    public void setAirBillingFrom(Timestamp airBillingFrom) {
        this.airBillingFrom = airBillingFrom;
    }

    @Column(name="AIR_BILLING_TO", nullable=false, length=7)

    public Timestamp getAirBillingTo() {
        return this.airBillingTo;
    }
    
    public void setAirBillingTo(Timestamp airBillingTo) {
        this.airBillingTo = airBillingTo;
    }

    @Column(name="AOUSD_SEQ_NO", nullable=false, precision=9, scale=0)

    public Integer getAousdSeqNo() {
        return this.aousdSeqNo;
    }
    
    public void setAousdSeqNo(Integer aousdSeqNo) {
        this.aousdSeqNo = aousdSeqNo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsOverUnderSalesDetsIdPk) ) return false;
		 AlsOverUnderSalesDetsIdPk castOther = ( AlsOverUnderSalesDetsIdPk ) other; 
         
		 return ( (this.getApiProviderNo()==castOther.getApiProviderNo()) || ( this.getApiProviderNo()!=null && castOther.getApiProviderNo()!=null && this.getApiProviderNo().equals(castOther.getApiProviderNo()) ) )
 && ( (this.getAirBillingFrom()==castOther.getAirBillingFrom()) || ( this.getAirBillingFrom()!=null && castOther.getAirBillingFrom()!=null && this.getAirBillingFrom().equals(castOther.getAirBillingFrom()) ) )
 && ( (this.getAirBillingTo()==castOther.getAirBillingTo()) || ( this.getAirBillingTo()!=null && castOther.getAirBillingTo()!=null && this.getAirBillingTo().equals(castOther.getAirBillingTo()) ) )
 && ( (this.getAousdSeqNo()==castOther.getAousdSeqNo()) || ( this.getAousdSeqNo()!=null && castOther.getAousdSeqNo()!=null && this.getAousdSeqNo().equals(castOther.getAousdSeqNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getApiProviderNo() == null ? 0 : this.getApiProviderNo().hashCode() );
         result = 37 * result + ( getAirBillingFrom() == null ? 0 : this.getAirBillingFrom().hashCode() );
         result = 37 * result + ( getAirBillingTo() == null ? 0 : this.getAirBillingTo().hashCode() );
         result = 37 * result + ( getAousdSeqNo() == null ? 0 : this.getAousdSeqNo().hashCode() );
         return result;
   }   





}