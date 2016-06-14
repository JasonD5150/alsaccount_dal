package fwp.alsaccount.hibernate.utils;

import java.io.Serializable;

public class ListComp implements Serializable {
    
	private static final long serialVersionUID = 187550980931005038L;

	private String itemVal;
    private String itemLabel;

    public ListComp() {
    }

       public ListComp(String itemVal, String itemLabel) {
              this.itemVal = itemVal;
              this.itemLabel = itemLabel;
       }

       /**
       * @param itemVal the listVal to set
       */
       public void setItemVal(String itemVal) {
              this.itemVal = itemVal;
       }

       public String getItemVal() {
              return itemVal;
       }

       /**
       * @param itemLabel the itemLabel to set
       */
       public void setItemLabel(String itemLabel) {
              this.itemLabel = itemLabel;
       }

       public String getItemLabel() {
              return itemLabel;
       }
}
