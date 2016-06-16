package fwp.alsaccount.dao.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsSysActivityTypeTranCdsIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsSysActivityTypeTranCdsIdPk  implements java.io.Serializable {


    // Fields    

     private String asacSystemActivityTypeCd;
     private String asacTxnCd;


    // Constructors

    /** default constructor */
    public AlsSysActivityTypeTranCdsIdPk() {
    }

    
    /** full constructor */
    public AlsSysActivityTypeTranCdsIdPk(String asacSystemActivityTypeCd, String asacTxnCd) {
        this.asacSystemActivityTypeCd = asacSystemActivityTypeCd;
        this.asacTxnCd = asacTxnCd;
    }

   
    // Property accessors

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
		 if ( !(other instanceof AlsSysActivityTypeTranCdsIdPk) ) return false;
		 AlsSysActivityTypeTranCdsIdPk castOther = ( AlsSysActivityTypeTranCdsIdPk ) other; 
         
		 return ( (this.getAsacSystemActivityTypeCd()==castOther.getAsacSystemActivityTypeCd()) || ( this.getAsacSystemActivityTypeCd()!=null && castOther.getAsacSystemActivityTypeCd()!=null && this.getAsacSystemActivityTypeCd().equals(castOther.getAsacSystemActivityTypeCd()) ) )
 && ( (this.getAsacTxnCd()==castOther.getAsacTxnCd()) || ( this.getAsacTxnCd()!=null && castOther.getAsacTxnCd()!=null && this.getAsacTxnCd().equals(castOther.getAsacTxnCd()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAsacSystemActivityTypeCd() == null ? 0 : this.getAsacSystemActivityTypeCd().hashCode() );
         result = 37 * result + ( getAsacTxnCd() == null ? 0 : this.getAsacTxnCd().hashCode() );
         return result;
   }   





}