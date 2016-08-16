package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AlsItemCategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ALS_ITEM_CATEGORY"
    ,schema="ALS"
)

public class AlsItemCategory  implements java.io.Serializable {


    // Fields    

     private AlsItemCategoryIdPk idPk;
     private String aicCategoryDesc;
     private String aicWhoLog;
     private Timestamp aicWhenLog;
     private String aicWebDescHtml;
     private String aicAlxDescText;


    // Constructors

    /** default constructor */
    public AlsItemCategory() {
    }

	/** minimal constructor */
    public AlsItemCategory(AlsItemCategoryIdPk idPk, String aicCategoryDesc, String aicWhoLog, Timestamp aicWhenLog) {
        this.idPk = idPk;
        this.aicCategoryDesc = aicCategoryDesc;
        this.aicWhoLog = aicWhoLog;
        this.aicWhenLog = aicWhenLog;
    }
    
    /** full constructor */
    public AlsItemCategory(AlsItemCategoryIdPk idPk, String aicCategoryDesc, String aicWhoLog, Timestamp aicWhenLog, String aicWebDescHtml, String aicAlxDescText) {
        this.idPk = idPk;
        this.aicCategoryDesc = aicCategoryDesc;
        this.aicWhoLog = aicWhoLog;
        this.aicWhenLog = aicWhenLog;
        this.aicWebDescHtml = aicWebDescHtml;
        this.aicAlxDescText = aicAlxDescText;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="aiItemId", column=@Column(name="AI_ITEM_ID", nullable=false, length=2) ), 
        @AttributeOverride(name="aicCategoryId", column=@Column(name="AIC_CATEGORY_ID", nullable=false, length=2) ) } )

    public AlsItemCategoryIdPk getIdPk() {
        return this.idPk;
    }
    
    public void setIdPk(AlsItemCategoryIdPk idPk) {
        this.idPk = idPk;
    }
    
    @Column(name="AIC_CATEGORY_DESC", nullable=false, length=200)

    public String getAicCategoryDesc() {
        return this.aicCategoryDesc;
    }
    
    public void setAicCategoryDesc(String aicCategoryDesc) {
        this.aicCategoryDesc = aicCategoryDesc;
    }
    
    @Column(name="AIC_WHO_LOG", nullable=false, length=15)

    public String getAicWhoLog() {
        return this.aicWhoLog;
    }
    
    public void setAicWhoLog(String aicWhoLog) {
        this.aicWhoLog = aicWhoLog;
    }
    
    @Column(name="AIC_WHEN_LOG", nullable=false, length=7)

    public Timestamp getAicWhenLog() {
        return this.aicWhenLog;
    }
    
    public void setAicWhenLog(Timestamp aicWhenLog) {
        this.aicWhenLog = aicWhenLog;
    }
    
    @Column(name="AIC_WEB_DESC_HTML", length=2000)

    public String getAicWebDescHtml() {
        return this.aicWebDescHtml;
    }
    
    public void setAicWebDescHtml(String aicWebDescHtml) {
        this.aicWebDescHtml = aicWebDescHtml;
    }
    
    @Column(name="AIC_ALX_DESC_TEXT", length=2000)

    public String getAicAlxDescText() {
        return this.aicAlxDescText;
    }
    
    public void setAicAlxDescText(String aicAlxDescText) {
        this.aicAlxDescText = aicAlxDescText;
    }
   








}