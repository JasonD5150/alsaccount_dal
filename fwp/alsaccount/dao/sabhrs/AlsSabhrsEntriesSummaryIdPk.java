package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsSabhrsEntriesSummaryIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsSabhrsEntriesSummaryIdPk  implements java.io.Serializable {


    // Fields    

     private Timestamp asesDateCreated;
     private Integer asesSeqNo;


    // Constructors

    /** default constructor */
    public AlsSabhrsEntriesSummaryIdPk() {
    }

    
    /** full constructor */
    public AlsSabhrsEntriesSummaryIdPk(Timestamp asesDateCreated, Integer asesSeqNo) {
        this.asesDateCreated = asesDateCreated;
        this.asesSeqNo = asesSeqNo;
    }

   
    // Property accessors

    @Column(name="ASES_DATE_CREATED", nullable=false, length=7)

    public Timestamp getAsesDateCreated() {
        return this.asesDateCreated;
    }
    
    public void setAsesDateCreated(Timestamp asesDateCreated) {
        this.asesDateCreated = asesDateCreated;
    }

    @Column(name="ASES_SEQ_NO", nullable=false, precision=12, scale=0)

    public Integer getAsesSeqNo() {
        return this.asesSeqNo;
    }
    
    public void setAsesSeqNo(Integer asesSeqNo) {
        this.asesSeqNo = asesSeqNo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsSabhrsEntriesSummaryIdPk) ) return false;
		 AlsSabhrsEntriesSummaryIdPk castOther = ( AlsSabhrsEntriesSummaryIdPk ) other; 
         
		 return ( (this.getAsesDateCreated()==castOther.getAsesDateCreated()) || ( this.getAsesDateCreated()!=null && castOther.getAsesDateCreated()!=null && this.getAsesDateCreated().equals(castOther.getAsesDateCreated()) ) )
 && ( (this.getAsesSeqNo()==castOther.getAsesSeqNo()) || ( this.getAsesSeqNo()!=null && castOther.getAsesSeqNo()!=null && this.getAsesSeqNo().equals(castOther.getAsesSeqNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAsesDateCreated() == null ? 0 : this.getAsesDateCreated().hashCode() );
         result = 37 * result + ( getAsesSeqNo() == null ? 0 : this.getAsesSeqNo().hashCode() );
         return result;
   }   





}