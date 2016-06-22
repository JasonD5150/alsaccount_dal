package fwp.alsaccount.dao.admin;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsSabhrsFyeAdjstDtl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_SABHRS_FYE_ADJST_DTL"
    ,schema="ALS"
)

public class AlsSabhrsFyeAdjstDtl  implements java.io.Serializable {


    // Fields    

     private AlsSabhrsFyeAdjstDtlIdPk idPk;


    // Constructors

    /** default constructor */
    public AlsSabhrsFyeAdjstDtl() {
    }

    
    /** full constructor */
    public AlsSabhrsFyeAdjstDtl(AlsSabhrsFyeAdjstDtlIdPk idPk) {
        this.idPk = idPk;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="asfaBudgetYear", column=@Column(name="ASFA_BUDGET_YEAR", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="asfadAdjstDt", column=@Column(name="ASFAD_ADJST_DT", nullable=false, length=7) ) } )

    public AlsSabhrsFyeAdjstDtlIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsSabhrsFyeAdjstDtlIdPk idPk) {
        this.idPk = idPk;
    }
   








}