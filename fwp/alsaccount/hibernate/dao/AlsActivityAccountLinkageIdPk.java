package fwp.alsaccount.hibernate.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsActivityAccountLinkageIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsActivityAccountLinkageIdPk  implements java.io.Serializable {


    // Fields    

     private Integer asacBudgetYear;
     private String asacSystemActivityTypeCd;
     private String asacTxnCd;
     private String aaalDrCrCd;


    // Constructors

    /** default constructor */
    public AlsActivityAccountLinkageIdPk() {
    }

    
    /** full constructor */
    public AlsActivityAccountLinkageIdPk(Integer asacBudgetYear, String asacSystemActivityTypeCd, String asacTxnCd, String aaalDrCrCd) {
        this.asacBudgetYear = asacBudgetYear;
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
        this.asacTxnCd = asacTxnCd;
        this.aaalDrCrCd = aaalDrCrCd;
    }

   
    // Property accessors

    @Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0)

    public Integer getAsacBudgetYear() {
        return this.asacBudgetYear;
    }
    
    public void setAsacBudgetYear(Integer asacBudgetYear) {
        this.asacBudgetYear = asacBudgetYear;
    }

    @Column(name="ASAC_SYSTEM_ACTIVITY_TYPE_CD", nullable=false, length=1)

    public String getAsacSystemActivityTypeCd() {
        return this.asacSystemActivityTypeCd;
    }
    
    public void setAsacSystemActivityTypeCd(String asacSystemActivityTypeCd) {
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
    }

    @Column(name="ASAC_TXN_CD", nullable=false, length=3)

    public String getAsacTxnCd() {
        return this.asacTxnCd;
    }
    
    public void setAsacTxnCd(String asacTxnCd) {
        this.asacTxnCd = asacTxnCd;
    }

    @Column(name="AAAL_DR_CR_CD", nullable=false, length=1)

    public String getAaalDrCrCd() {
        return this.aaalDrCrCd;
    }
    
    public void setAaalDrCrCd(String aaalDrCrCd) {
        this.aaalDrCrCd = aaalDrCrCd;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsActivityAccountLinkageIdPk) ) return false;
		 AlsActivityAccountLinkageIdPk castOther = ( AlsActivityAccountLinkageIdPk ) other; 
         
		 return ( (this.getAsacBudgetYear()==castOther.getAsacBudgetYear()) || ( this.getAsacBudgetYear()!=null && castOther.getAsacBudgetYear()!=null && this.getAsacBudgetYear().equals(castOther.getAsacBudgetYear()) ) )
 && ( (this.getAsacSystemActivityTypeCd()==castOther.getAsacSystemActivityTypeCd()) || ( this.getAsacSystemActivityTypeCd()!=null && castOther.getAsacSystemActivityTypeCd()!=null && this.getAsacSystemActivityTypeCd().equals(castOther.getAsacSystemActivityTypeCd()) ) )
 && ( (this.getAsacTxnCd()==castOther.getAsacTxnCd()) || ( this.getAsacTxnCd()!=null && castOther.getAsacTxnCd()!=null && this.getAsacTxnCd().equals(castOther.getAsacTxnCd()) ) )
 && ( (this.getAaalDrCrCd()==castOther.getAaalDrCrCd()) || ( this.getAaalDrCrCd()!=null && castOther.getAaalDrCrCd()!=null && this.getAaalDrCrCd().equals(castOther.getAaalDrCrCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAsacBudgetYear() == null ? 0 : this.getAsacBudgetYear().hashCode() );
         result = 37 * result + ( getAsacSystemActivityTypeCd() == null ? 0 : this.getAsacSystemActivityTypeCd().hashCode() );
         result = 37 * result + ( getAsacTxnCd() == null ? 0 : this.getAsacTxnCd().hashCode() );
         result = 37 * result + ( getAaalDrCrCd() == null ? 0 : this.getAaalDrCrCd().hashCode() );
         return result;
   }   





}