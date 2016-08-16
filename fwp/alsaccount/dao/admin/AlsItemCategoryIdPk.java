package fwp.alsaccount.dao.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AlsItemCategoryIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AlsItemCategoryIdPk  implements java.io.Serializable {


    // Fields    

     private String aiItemId;
     private String aicCategoryId;


    // Constructors

    /** default constructor */
    public AlsItemCategoryIdPk() {
    }

    
    /** full constructor */
    public AlsItemCategoryIdPk(String aiItemId, String aicCategoryId) {
        this.aiItemId = aiItemId;
        this.aicCategoryId = aicCategoryId;
    }

   
    // Property accessors

    @Column(name="AI_ITEM_ID", nullable=false, length=2)

    public String getAiItemId() {
        return this.aiItemId;
    }
    
    public void setAiItemId(String aiItemId) {
        this.aiItemId = aiItemId;
    }

    @Column(name="AIC_CATEGORY_ID", nullable=false, length=2)

    public String getAicCategoryId() {
        return this.aicCategoryId;
    }
    
    public void setAicCategoryId(String aicCategoryId) {
        this.aicCategoryId = aicCategoryId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlsItemCategoryIdPk) ) return false;
		 AlsItemCategoryIdPk castOther = ( AlsItemCategoryIdPk ) other; 
         
		 return ( (this.getAiItemId()==castOther.getAiItemId()) || ( this.getAiItemId()!=null && castOther.getAiItemId()!=null && this.getAiItemId().equals(castOther.getAiItemId()) ) )
 && ( (this.getAicCategoryId()==castOther.getAicCategoryId()) || ( this.getAicCategoryId()!=null && castOther.getAicCategoryId()!=null && this.getAicCategoryId().equals(castOther.getAicCategoryId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAiItemId() == null ? 0 : this.getAiItemId().hashCode() );
         result = 37 * result + ( getAicCategoryId() == null ? 0 : this.getAicCategoryId().hashCode() );
         return result;
   }   





}