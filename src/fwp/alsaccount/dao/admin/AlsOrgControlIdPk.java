package fwp.alsaccount.dao.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsOrgControlIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsOrgControlIdPk  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer asacBudgetYear;
     private String aaccAccCd;
     private Integer apiProviderNo;


    // Constructors

    /** default constructor */
    public AlsOrgControlIdPk() {
    }

    
    /** full constructor */
    public AlsOrgControlIdPk(Integer asacBudgetYear, String aaccAccCd, Integer apiProviderNo) {
        this.asacBudgetYear = asacBudgetYear;
        this.aaccAccCd = aaccAccCd;
        this.apiProviderNo = apiProviderNo;
    }

   
    // Property accessors

    @Column(name="ASAC_BUDGET_YEAR", nullable=false, precision=4, scale=0)

    public Integer getAsacBudgetYear() {
        return this.asacBudgetYear;
    }
    
    public void setAsacBudgetYear(Integer asacBudgetYear) {
        this.asacBudgetYear = asacBudgetYear;
    }

    @Column(name="AACC_ACC_CD", nullable=false, length=3)

    public String getAaccAccCd() {
        return this.aaccAccCd;
    }
    
    public void setAaccAccCd(String aaccAccCd) {
        this.aaccAccCd = aaccAccCd;
    }

    @Column(name="API_PROVIDER_NO", nullable=false, precision=10, scale=0)

    public Integer getApiProviderNo() {
        return this.apiProviderNo;
    }
    
    public void setApiProviderNo(Integer apiProviderNo) {
        this.apiProviderNo = apiProviderNo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsOrgControlIdPk) ) return false;
		 AlsOrgControlIdPk castOther = ( AlsOrgControlIdPk ) other; 
         
		 return ( (this.getAsacBudgetYear()==castOther.getAsacBudgetYear()) || ( this.getAsacBudgetYear()!=null && castOther.getAsacBudgetYear()!=null && this.getAsacBudgetYear().equals(castOther.getAsacBudgetYear()) ) )
 && ( (this.getAaccAccCd()==castOther.getAaccAccCd()) || ( this.getAaccAccCd()!=null && castOther.getAaccAccCd()!=null && this.getAaccAccCd().equals(castOther.getAaccAccCd()) ) )
 && ( (this.getApiProviderNo()==castOther.getApiProviderNo()) || ( this.getApiProviderNo()!=null && castOther.getApiProviderNo()!=null && this.getApiProviderNo().equals(castOther.getApiProviderNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAsacBudgetYear() == null ? 0 : this.getAsacBudgetYear().hashCode() );
         result = 37 * result + ( getAaccAccCd() == null ? 0 : this.getAaccAccCd().hashCode() );
         result = 37 * result + ( getApiProviderNo() == null ? 0 : this.getApiProviderNo().hashCode() );
         return result;
   }   





}