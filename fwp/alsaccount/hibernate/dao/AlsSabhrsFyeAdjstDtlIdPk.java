package fwp.alsaccount.hibernate.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsSabhrsFyeAdjstDtlIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsSabhrsFyeAdjstDtlIdPk  implements java.io.Serializable {


    // Fields    

     private Integer asfaBudgetYear;
     private Timestamp asfadAdjstDt;


    // Constructors

    /** default constructor */
    public AlsSabhrsFyeAdjstDtlIdPk() {
    }

    
    /** full constructor */
    public AlsSabhrsFyeAdjstDtlIdPk(Integer asfaBudgetYear, Timestamp asfadAdjstDt) {
        this.asfaBudgetYear = asfaBudgetYear;
        this.asfadAdjstDt = asfadAdjstDt;
    }

   
    // Property accessors

    @Column(name="ASFA_BUDGET_YEAR", nullable=false, precision=4, scale=0)

    public Integer getAsfaBudgetYear() {
        return this.asfaBudgetYear;
    }
    
    public void setAsfaBudgetYear(Integer asfaBudgetYear) {
        this.asfaBudgetYear = asfaBudgetYear;
    }

    @Column(name="ASFAD_ADJST_DT", nullable=false, length=7)

    public Timestamp getAsfadAdjstDt() {
        return this.asfadAdjstDt;
    }
    
    public void setAsfadAdjstDt(Timestamp asfadAdjstDt) {
        this.asfadAdjstDt = asfadAdjstDt;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsSabhrsFyeAdjstDtlIdPk) ) return false;
		 AlsSabhrsFyeAdjstDtlIdPk castOther = ( AlsSabhrsFyeAdjstDtlIdPk ) other; 
         
		 return ( (this.getAsfaBudgetYear()==castOther.getAsfaBudgetYear()) || ( this.getAsfaBudgetYear()!=null && castOther.getAsfaBudgetYear()!=null && this.getAsfaBudgetYear().equals(castOther.getAsfaBudgetYear()) ) )
 && ( (this.getAsfadAdjstDt()==castOther.getAsfadAdjstDt()) || ( this.getAsfadAdjstDt()!=null && castOther.getAsfadAdjstDt()!=null && this.getAsfadAdjstDt().equals(castOther.getAsfadAdjstDt()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAsfaBudgetYear() == null ? 0 : this.getAsfaBudgetYear().hashCode() );
         result = 37 * result + ( getAsfadAdjstDt() == null ? 0 : this.getAsfadAdjstDt().hashCode() );
         return result;
   }   





}