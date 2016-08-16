package fwp.alsaccount.dao.sabhrs;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsCostGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_COST_GROUP"
    ,schema="ALS"
)

public class AlsCostGroup  implements java.io.Serializable {


    // Fields    

     private AlsCostGroupIdPk idPk;
     private String acgSupplementCostGrpDesc;
     private Integer acgSupplementalPrntItemLmt;
     private String acgWhoLog;
     private Timestamp acgWhenLog;


    // Constructors

    /** default constructor */
    public AlsCostGroup() {
    }

	/** minimal constructor */
    public AlsCostGroup(AlsCostGroupIdPk idPk, String acgWhoLog, Timestamp acgWhenLog) {
        this.idPk = idPk;
        this.acgWhoLog = acgWhoLog;
        this.acgWhenLog = acgWhenLog;
    }
    
    /** full constructor */
    public AlsCostGroup(AlsCostGroupIdPk idPk, String acgSupplementCostGrpDesc, Integer acgSupplementalPrntItemLmt, String acgWhoLog, Timestamp acgWhenLog) {
        this.idPk = idPk;
        this.acgSupplementCostGrpDesc = acgSupplementCostGrpDesc;
        this.acgSupplementalPrntItemLmt = acgSupplementalPrntItemLmt;
        this.acgWhoLog = acgWhoLog;
        this.acgWhenLog = acgWhenLog;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="aictUsagePeriodFrom", column=@Column(name="AICT_USAGE_PERIOD_FROM", nullable=false, length=7) ), 
        @AttributeOverride(name="aictUsagePeriodTo", column=@Column(name="AICT_USAGE_PERIOD_TO", nullable=false, length=7) ), 
        @AttributeOverride(name="aictItemTypeCd", column=@Column(name="AICT_ITEM_TYPE_CD", nullable=false, length=7) ), 
        @AttributeOverride(name="airResidencyInd", column=@Column(name="AIR_RESIDENCY_IND", nullable=false, length=1) ), 
        @AttributeOverride(name="acgSeqNo", column=@Column(name="ACG_SEQ_NO", nullable=false, precision=4, scale=0) ) } )

    public AlsCostGroupIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsCostGroupIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="ACG_SUPPLEMENT_COST_GRP_DESC", length=200)

    public String getAcgSupplementCostGrpDesc() {
        return this.acgSupplementCostGrpDesc;
    }
    
    public void setAcgSupplementCostGrpDesc(String acgSupplementCostGrpDesc) {
        this.acgSupplementCostGrpDesc = acgSupplementCostGrpDesc;
    }
    
    @Column(name="ACG_SUPPLEMENTAL_PRNT_ITEM_LMT", precision=4, scale=0)

    public Integer getAcgSupplementalPrntItemLmt() {
        return this.acgSupplementalPrntItemLmt;
    }
    
    public void setAcgSupplementalPrntItemLmt(Integer acgSupplementalPrntItemLmt) {
        this.acgSupplementalPrntItemLmt = acgSupplementalPrntItemLmt;
    }
    
    @Column(name="ACG_WHO_LOG", nullable=false, length=15)

    public String getAcgWhoLog() {
        return this.acgWhoLog;
    }
    
    public void setAcgWhoLog(String acgWhoLog) {
        this.acgWhoLog = acgWhoLog;
    }
    
    @Column(name="ACG_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAcgWhenLog() {
        return this.acgWhenLog;
    }
    
    public void setAcgWhenLog(Timestamp acgWhenLog) {
        this.acgWhenLog = acgWhenLog;
    }
   








}