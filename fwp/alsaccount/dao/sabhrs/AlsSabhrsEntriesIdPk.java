package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * sabhrsAlsSabhrsEntriesIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsSabhrsEntriesIdPk  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timestamp aseWhenEntryPosted;
     private Integer aseSeqNo;
     private String aseDrCrCd;
     private Integer aseTxnCdSeqNo;


    // Constructors

    /** default constructor */
    public AlsSabhrsEntriesIdPk() {
    }

    
    /** full constructor */
    public AlsSabhrsEntriesIdPk(Timestamp aseWhenEntryPosted, Integer aseSeqNo, String aseDrCrCd, Integer aseTxnCdSeqNo) {
        this.aseWhenEntryPosted = aseWhenEntryPosted;
        this.aseSeqNo = aseSeqNo;
        this.aseDrCrCd = aseDrCrCd;
        this.aseTxnCdSeqNo = aseTxnCdSeqNo;
    }

   
    // Property accessors

    @Column(name="ASE_WHEN_ENTRY_POSTED", nullable=false, length=7)

    public Timestamp getAseWhenEntryPosted() {
        return this.aseWhenEntryPosted;
    }
    
    public void setAseWhenEntryPosted(Timestamp aseWhenEntryPosted) {
        this.aseWhenEntryPosted = aseWhenEntryPosted;
    }

    @Column(name="ASE_SEQ_NO", nullable=false, precision=10, scale=0)

    public Integer getAseSeqNo() {
        return this.aseSeqNo;
    }
    
    public void setAseSeqNo(Integer aseSeqNo) {
        this.aseSeqNo = aseSeqNo;
    }

    @Column(name="ASE_DR_CR_CD", nullable=false, length=1)

    public String getAseDrCrCd() {
        return this.aseDrCrCd;
    }
    
    public void setAseDrCrCd(String aseDrCrCd) {
        this.aseDrCrCd = aseDrCrCd;
    }

    @Column(name="ASE_TXN_CD_SEQ_NO", nullable=false, precision=4, scale=0)

    public Integer getAseTxnCdSeqNo() {
        return this.aseTxnCdSeqNo;
    }
    
    public void setAseTxnCdSeqNo(Integer aseTxnCdSeqNo) {
        this.aseTxnCdSeqNo = aseTxnCdSeqNo;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsSabhrsEntriesIdPk) ) return false;
		 AlsSabhrsEntriesIdPk castOther = ( AlsSabhrsEntriesIdPk ) other; 
         
		 return ( (this.getAseWhenEntryPosted()==castOther.getAseWhenEntryPosted()) || ( this.getAseWhenEntryPosted()!=null && castOther.getAseWhenEntryPosted()!=null && this.getAseWhenEntryPosted().equals(castOther.getAseWhenEntryPosted()) ) )
 && ( (this.getAseSeqNo()==castOther.getAseSeqNo()) || ( this.getAseSeqNo()!=null && castOther.getAseSeqNo()!=null && this.getAseSeqNo().equals(castOther.getAseSeqNo()) ) )
 && ( (this.getAseDrCrCd()==castOther.getAseDrCrCd()) || ( this.getAseDrCrCd()!=null && castOther.getAseDrCrCd()!=null && this.getAseDrCrCd().equals(castOther.getAseDrCrCd()) ) )
 && ( (this.getAseTxnCdSeqNo()==castOther.getAseTxnCdSeqNo()) || ( this.getAseTxnCdSeqNo()!=null && castOther.getAseTxnCdSeqNo()!=null && this.getAseTxnCdSeqNo().equals(castOther.getAseTxnCdSeqNo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAseWhenEntryPosted() == null ? 0 : this.getAseWhenEntryPosted().hashCode() );
         result = 37 * result + ( getAseSeqNo() == null ? 0 : this.getAseSeqNo().hashCode() );
         result = 37 * result + ( getAseDrCrCd() == null ? 0 : this.getAseDrCrCd().hashCode() );
         result = 37 * result + ( getAseTxnCdSeqNo() == null ? 0 : this.getAseTxnCdSeqNo().hashCode() );
         return result;
   }   





}