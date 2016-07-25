package fwp.alsaccount.dao.sabhrs;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * sabhrsAlsTransactionGrpStatusIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsTransactionGrpStatusIdPk  implements java.io.Serializable {


    // Fields    

     private Integer atgTransactionCd;
     private String atgsGroupIdentifier;


    // Constructors

    /** default constructor */
    public AlsTransactionGrpStatusIdPk() {
    }

    
    /** full constructor */
    public AlsTransactionGrpStatusIdPk(Integer atgTransactionCd, String atgsGroupIdentifier) {
        this.atgTransactionCd = atgTransactionCd;
        this.atgsGroupIdentifier = atgsGroupIdentifier;
    }

   
    // Property accessors

    @Column(name="ATG_TRANSACTION_CD", nullable=false, precision=5, scale=0)

    public Integer getAtgTransactionCd() {
        return this.atgTransactionCd;
    }
    
    public void setAtgTransactionCd(Integer atgTransactionCd) {
        this.atgTransactionCd = atgTransactionCd;
    }

    @Column(name="ATGS_GROUP_IDENTIFIER", nullable=false, length=50)

    public String getAtgsGroupIdentifier() {
        return this.atgsGroupIdentifier;
    }
    
    public void setAtgsGroupIdentifier(String atgsGroupIdentifier) {
        this.atgsGroupIdentifier = atgsGroupIdentifier;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsTransactionGrpStatusIdPk) ) return false;
		 AlsTransactionGrpStatusIdPk castOther = ( AlsTransactionGrpStatusIdPk ) other; 
         
		 return ( (this.getAtgTransactionCd()==castOther.getAtgTransactionCd()) || ( this.getAtgTransactionCd()!=null && castOther.getAtgTransactionCd()!=null && this.getAtgTransactionCd().equals(castOther.getAtgTransactionCd()) ) )
 && ( (this.getAtgsGroupIdentifier()==castOther.getAtgsGroupIdentifier()) || ( this.getAtgsGroupIdentifier()!=null && castOther.getAtgsGroupIdentifier()!=null && this.getAtgsGroupIdentifier().equals(castOther.getAtgsGroupIdentifier()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAtgTransactionCd() == null ? 0 : this.getAtgTransactionCd().hashCode() );
         result = 37 * result + ( getAtgsGroupIdentifier() == null ? 0 : this.getAtgsGroupIdentifier().hashCode() );
         return result;
   }   





}