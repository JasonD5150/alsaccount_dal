package fwp.alsaccount.dao.refund;
// Generated Dec 20, 2016 4:13:42 PM by Hibernate Tools 5.2.0.Alpha3


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AlsSmithRiverAppsIdPk generated by hbm2java
 */
@Embeddable
public class AlsSmithRiverAppsIdPk  implements java.io.Serializable {


     private Date apiDob;
     private Integer apiAlsNo;
     private Integer asraSeqNo;

    public AlsSmithRiverAppsIdPk() {
    }

    public AlsSmithRiverAppsIdPk(Date apiDob, Integer apiAlsNo, Integer asraSeqNo) {
       this.apiDob = apiDob;
       this.apiAlsNo = apiAlsNo;
       this.asraSeqNo = asraSeqNo;
    }
   


    @Column(name="API_DOB", nullable=false, length=7)
    public Date getApiDob() {
        return this.apiDob;
    }
    
    public void setApiDob(Date apiDob) {
        this.apiDob = apiDob;
    }


    @Column(name="API_ALS_NO", nullable=false, precision=8, scale=0)
    public Integer getApiAlsNo() {
        return this.apiAlsNo;
    }
    
    public void setApiAlsNo(Integer apiAlsNo) {
        this.apiAlsNo = apiAlsNo;
    }


    @Column(name="ASRA_SEQ_NO", nullable=false, precision=5, scale=0)
    public Integer getAsraSeqNo() {
        return this.asraSeqNo;
    }
    
    public void setAsraSeqNo(Integer asraSeqNo) {
        this.asraSeqNo = asraSeqNo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsSmithRiverAppsIdPk) ) return false;
		 AlsSmithRiverAppsIdPk castOther = ( AlsSmithRiverAppsIdPk ) other; 
         
		 return ( (this.getApiDob()==castOther.getApiDob()) || ( this.getApiDob()!=null && castOther.getApiDob()!=null && this.getApiDob().equals(castOther.getApiDob()) ) )
 && ( (this.getApiAlsNo()==castOther.getApiAlsNo()) || ( this.getApiAlsNo()!=null && castOther.getApiAlsNo()!=null && this.getApiAlsNo().equals(castOther.getApiAlsNo()) ) )
 && ( (this.getAsraSeqNo()==castOther.getAsraSeqNo()) || ( this.getAsraSeqNo()!=null && castOther.getAsraSeqNo()!=null && this.getAsraSeqNo().equals(castOther.getAsraSeqNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getApiDob() == null ? 0 : this.getApiDob().hashCode() );
         result = 37 * result + ( getApiAlsNo() == null ? 0 : this.getApiAlsNo().hashCode() );
         result = 37 * result + ( getAsraSeqNo() == null ? 0 : this.getAsraSeqNo().hashCode() );
         return result;
   }   


}

