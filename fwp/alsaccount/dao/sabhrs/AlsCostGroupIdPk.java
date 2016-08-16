package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsCostGroupIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsCostGroupIdPk  implements java.io.Serializable {


    // Fields    

     private Timestamp aictUsagePeriodFrom;
     private Timestamp aictUsagePeriodTo;
     private String aictItemTypeCd;
     private String airResidencyInd;
     private Integer acgSeqNo;


    // Constructors

    /** default constructor */
    public AlsCostGroupIdPk() {
    }

    
    /** full constructor */
    public AlsCostGroupIdPk(Timestamp aictUsagePeriodFrom, Timestamp aictUsagePeriodTo, String aictItemTypeCd, String airResidencyInd, Integer acgSeqNo) {
        this.aictUsagePeriodFrom = aictUsagePeriodFrom;
        this.aictUsagePeriodTo = aictUsagePeriodTo;
        this.aictItemTypeCd = aictItemTypeCd;
        this.airResidencyInd = airResidencyInd;
        this.acgSeqNo = acgSeqNo;
    }

   
    // Property accessors

    @Column(name="AICT_USAGE_PERIOD_FROM", nullable=false, length=7)

    public Timestamp getAictUsagePeriodFrom() {
        return this.aictUsagePeriodFrom;
    }
    
    public void setAictUsagePeriodFrom(Timestamp aictUsagePeriodFrom) {
        this.aictUsagePeriodFrom = aictUsagePeriodFrom;
    }

    @Column(name="AICT_USAGE_PERIOD_TO", nullable=false, length=7)

    public Timestamp getAictUsagePeriodTo() {
        return this.aictUsagePeriodTo;
    }
    
    public void setAictUsagePeriodTo(Timestamp aictUsagePeriodTo) {
        this.aictUsagePeriodTo = aictUsagePeriodTo;
    }

    @Column(name="AICT_ITEM_TYPE_CD", nullable=false, length=7)

    public String getAictItemTypeCd() {
        return this.aictItemTypeCd;
    }
    
    public void setAictItemTypeCd(String aictItemTypeCd) {
        this.aictItemTypeCd = aictItemTypeCd;
    }

    @Column(name="AIR_RESIDENCY_IND", nullable=false, length=1)

    public String getAirResidencyInd() {
        return this.airResidencyInd;
    }
    
    public void setAirResidencyInd(String airResidencyInd) {
        this.airResidencyInd = airResidencyInd;
    }

    @Column(name="ACG_SEQ_NO", nullable=false, precision=4, scale=0)

    public Integer getAcgSeqNo() {
        return this.acgSeqNo;
    }
    
    public void setAcgSeqNo(Integer acgSeqNo) {
        this.acgSeqNo = acgSeqNo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsCostGroupIdPk) ) return false;
		 AlsCostGroupIdPk castOther = ( AlsCostGroupIdPk ) other; 
         
		 return ( (this.getAictUsagePeriodFrom()==castOther.getAictUsagePeriodFrom()) || ( this.getAictUsagePeriodFrom()!=null && castOther.getAictUsagePeriodFrom()!=null && this.getAictUsagePeriodFrom().equals(castOther.getAictUsagePeriodFrom()) ) )
 && ( (this.getAictUsagePeriodTo()==castOther.getAictUsagePeriodTo()) || ( this.getAictUsagePeriodTo()!=null && castOther.getAictUsagePeriodTo()!=null && this.getAictUsagePeriodTo().equals(castOther.getAictUsagePeriodTo()) ) )
 && ( (this.getAictItemTypeCd()==castOther.getAictItemTypeCd()) || ( this.getAictItemTypeCd()!=null && castOther.getAictItemTypeCd()!=null && this.getAictItemTypeCd().equals(castOther.getAictItemTypeCd()) ) )
 && ( (this.getAirResidencyInd()==castOther.getAirResidencyInd()) || ( this.getAirResidencyInd()!=null && castOther.getAirResidencyInd()!=null && this.getAirResidencyInd().equals(castOther.getAirResidencyInd()) ) )
 && ( (this.getAcgSeqNo()==castOther.getAcgSeqNo()) || ( this.getAcgSeqNo()!=null && castOther.getAcgSeqNo()!=null && this.getAcgSeqNo().equals(castOther.getAcgSeqNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAictUsagePeriodFrom() == null ? 0 : this.getAictUsagePeriodFrom().hashCode() );
         result = 37 * result + ( getAictUsagePeriodTo() == null ? 0 : this.getAictUsagePeriodTo().hashCode() );
         result = 37 * result + ( getAictItemTypeCd() == null ? 0 : this.getAictItemTypeCd().hashCode() );
         result = 37 * result + ( getAirResidencyInd() == null ? 0 : this.getAirResidencyInd().hashCode() );
         result = 37 * result + ( getAcgSeqNo() == null ? 0 : this.getAcgSeqNo().hashCode() );
         return result;
   }   





}