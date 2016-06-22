package fwp.alsaccount.dao.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsNonAlsTemplateIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsNonAlsTemplateIdPk  implements java.io.Serializable {


    // Fields    

     private Integer anatBudgetYear;
     private String anatCd;


    // Constructors

    /** default constructor */
    public AlsNonAlsTemplateIdPk() {
    }

    
    /** full constructor */
    public AlsNonAlsTemplateIdPk(Integer anatBudgetYear, String anatCd) {
        this.anatBudgetYear = anatBudgetYear;
        this.anatCd = anatCd;
    }

   
    // Property accessors

    @Column(name="ANAT_BUDGET_YEAR", nullable=false, precision=4, scale=0)

    public Integer getAnatBudgetYear() {
        return this.anatBudgetYear;
    }
    
    public void setAnatBudgetYear(Integer anatBudgetYear) {
        this.anatBudgetYear = anatBudgetYear;
    }

    @Column(name="ANAT_CD", nullable=false, length=5)

    public String getAnatCd() {
        return this.anatCd;
    }
    
    public void setAnatCd(String anatCd) {
        this.anatCd = anatCd;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsNonAlsTemplateIdPk) ) return false;
		 AlsNonAlsTemplateIdPk castOther = ( AlsNonAlsTemplateIdPk ) other; 
         
		 return ( (this.getAnatBudgetYear()==castOther.getAnatBudgetYear()) || ( this.getAnatBudgetYear()!=null && castOther.getAnatBudgetYear()!=null && this.getAnatBudgetYear().equals(castOther.getAnatBudgetYear()) ) )
 && ( (this.getAnatCd()==castOther.getAnatCd()) || ( this.getAnatCd()!=null && castOther.getAnatCd()!=null && this.getAnatCd().equals(castOther.getAnatCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAnatBudgetYear() == null ? 0 : this.getAnatBudgetYear().hashCode() );
         result = 37 * result + ( getAnatCd() == null ? 0 : this.getAnatCd().hashCode() );
         return result;
   }   





}