package fwp.alsaccount.hibernate.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsAccCdControlIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsAccCdControlIdPk  implements java.io.Serializable {


    // Fields    

	 private static final long serialVersionUID = 3744431405826024867L;
	 private Integer asacBudgetYear;
     private String aaccAccCd;
     private Integer aaccSeqNo;


    // Constructors

    /** default constructor */
    public AlsAccCdControlIdPk() {
    }

    
    /** full constructor */
    public AlsAccCdControlIdPk(Integer asacBudgetYear, String aaccAccCd, Integer aaccSeqNo) {
        this.asacBudgetYear = asacBudgetYear;
        this.aaccAccCd = aaccAccCd;
        this.aaccSeqNo = aaccSeqNo;
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

    @Column(name="AACC_SEQ_NO", nullable=false, precision=3, scale=0)

    public Integer getAaccSeqNo() {
        return this.aaccSeqNo;
    }
    
    public void setAaccSeqNo(Integer aaccSeqNo) {
        this.aaccSeqNo = aaccSeqNo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsAccCdControlIdPk) ) return false;
		 AlsAccCdControlIdPk castOther = ( AlsAccCdControlIdPk ) other; 
         
		 return ( (this.getAsacBudgetYear()==castOther.getAsacBudgetYear()) || ( this.getAsacBudgetYear()!=null && castOther.getAsacBudgetYear()!=null && this.getAsacBudgetYear().equals(castOther.getAsacBudgetYear()) ) )
 && ( (this.getAaccAccCd()==castOther.getAaccAccCd()) || ( this.getAaccAccCd()!=null && castOther.getAaccAccCd()!=null && this.getAaccAccCd().equals(castOther.getAaccAccCd()) ) )
 && ( (this.getAaccSeqNo()==castOther.getAaccSeqNo()) || ( this.getAaccSeqNo()!=null && castOther.getAaccSeqNo()!=null && this.getAaccSeqNo().equals(castOther.getAaccSeqNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAsacBudgetYear() == null ? 0 : this.getAsacBudgetYear().hashCode() );
         result = 37 * result + ( getAaccAccCd() == null ? 0 : this.getAaccAccCd().hashCode() );
         result = 37 * result + ( getAaccSeqNo() == null ? 0 : this.getAaccSeqNo().hashCode() );
         return result;
   }   





}