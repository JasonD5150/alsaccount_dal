package fwp.alsaccount.hibernate.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsAccountMasterIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsAccountMasterIdPk  implements java.io.Serializable {


    // Fields    

	 private static final long serialVersionUID = -4931506783897701837L;
	 private Integer asacBudgetYear;
     private String aamAccount;


    // Constructors

    /** default constructor */
    public AlsAccountMasterIdPk() {
    }

    
    /** full constructor */
    public AlsAccountMasterIdPk(Integer asacBudgetYear, String aamAccount) {
        this.asacBudgetYear = asacBudgetYear;
        this.aamAccount = aamAccount;
    }

   
    // Property accessors

    @Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0)

    public Integer getAsacBudgetYear() {
        return this.asacBudgetYear;
    }
    
    public void setAsacBudgetYear(Integer asacBudgetYear) {
        this.asacBudgetYear = asacBudgetYear;
    }

    @Column(name="AAM_ACCOUNT", nullable=false, length=6)

    public String getAamAccount() {
        return this.aamAccount;
    }
    
    public void setAamAccount(String aamAccount) {
        this.aamAccount = aamAccount;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsAccountMasterIdPk) ) return false;
		 AlsAccountMasterIdPk castOther = ( AlsAccountMasterIdPk ) other; 
         
		 return ( (this.getAsacBudgetYear()==castOther.getAsacBudgetYear()) || ( this.getAsacBudgetYear()!=null && castOther.getAsacBudgetYear()!=null && this.getAsacBudgetYear().equals(castOther.getAsacBudgetYear()) ) )
 && ( (this.getAamAccount()==castOther.getAamAccount()) || ( this.getAamAccount()!=null && castOther.getAamAccount()!=null && this.getAamAccount().equals(castOther.getAamAccount()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAsacBudgetYear() == null ? 0 : this.getAsacBudgetYear().hashCode() );
         result = 37 * result + ( getAamAccount() == null ? 0 : this.getAamAccount().hashCode() );
         return result;
   }   





}