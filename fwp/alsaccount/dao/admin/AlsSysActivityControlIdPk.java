package fwp.alsaccount.dao.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsSysActivityControlIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsSysActivityControlIdPk  implements java.io.Serializable {


    // Fields    

     private Integer asacBudgetYear;
     private String asacSystemActivityTypeCd;
     private String asacTxnCd;


    // Constructors

    /** default constructor */
    public AlsSysActivityControlIdPk() {
    }

    
    /** full constructor */
    public AlsSysActivityControlIdPk(Integer asacBudgetYear, String asacSystemActivityTypeCd, String asacTxnCd) {
        this.asacBudgetYear = asacBudgetYear;
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
        this.asacTxnCd = asacTxnCd;
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
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsSysActivityControlIdPk) ) return false;
		 AlsSysActivityControlIdPk castOther = ( AlsSysActivityControlIdPk ) other; 
         
		 return ( (this.getAsacBudgetYear()==castOther.getAsacBudgetYear()) || ( this.getAsacBudgetYear()!=null && castOther.getAsacBudgetYear()!=null && this.getAsacBudgetYear().equals(castOther.getAsacBudgetYear()) ) )
 && ( (this.getAsacSystemActivityTypeCd()==castOther.getAsacSystemActivityTypeCd()) || ( this.getAsacSystemActivityTypeCd()!=null && castOther.getAsacSystemActivityTypeCd()!=null && this.getAsacSystemActivityTypeCd().equals(castOther.getAsacSystemActivityTypeCd()) ) )
 && ( (this.getAsacTxnCd()==castOther.getAsacTxnCd()) || ( this.getAsacTxnCd()!=null && castOther.getAsacTxnCd()!=null && this.getAsacTxnCd().equals(castOther.getAsacTxnCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAsacBudgetYear() == null ? 0 : this.getAsacBudgetYear().hashCode() );
         result = 37 * result + ( getAsacSystemActivityTypeCd() == null ? 0 : this.getAsacSystemActivityTypeCd().hashCode() );
         result = 37 * result + ( getAsacTxnCd() == null ? 0 : this.getAsacTxnCd().hashCode() );
         return result;
   }   





}