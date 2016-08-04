package fwp.alsaccount.dao.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AlsItemTypeIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class AlsItemTypeIdPk implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String aiItemId;
	private String aicCategoryId;
	private String aitTypeId;

	// Constructors

	/** default constructor */
	public AlsItemTypeIdPk() {
	}

	/** full constructor */
	public AlsItemTypeIdPk(String aiItemId, String aicCategoryId,
			String aitTypeId) {
		this.aiItemId = aiItemId;
		this.aicCategoryId = aicCategoryId;
		this.aitTypeId = aitTypeId;
	}

	// Property accessors

	@Column(name = "AI_ITEM_ID", nullable = false, length = 2)
	public String getAiItemId() {
		return this.aiItemId;
	}

	public void setAiItemId(String aiItemId) {
		this.aiItemId = aiItemId;
	}

	@Column(name = "AIC_CATEGORY_ID", nullable = false, length = 2)
	public String getAicCategoryId() {
		return this.aicCategoryId;
	}

	public void setAicCategoryId(String aicCategoryId) {
		this.aicCategoryId = aicCategoryId;
	}

	@Column(name = "AIT_TYPE_ID", nullable = false, length = 3)
	public String getAitTypeId() {
		return this.aitTypeId;
	}

	public void setAitTypeId(String aitTypeId) {
		this.aitTypeId = aitTypeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AlsItemTypeIdPk))
			return false;
		AlsItemTypeIdPk castOther = (AlsItemTypeIdPk) other;

		return ((this.getAiItemId() == castOther.getAiItemId()) || (this
				.getAiItemId() != null && castOther.getAiItemId() != null && this
				.getAiItemId().equals(castOther.getAiItemId())))
				&& ((this.getAicCategoryId() == castOther.getAicCategoryId()) || (this
						.getAicCategoryId() != null
						&& castOther.getAicCategoryId() != null && this
						.getAicCategoryId()
						.equals(castOther.getAicCategoryId())))
				&& ((this.getAitTypeId() == castOther.getAitTypeId()) || (this
						.getAitTypeId() != null
						&& castOther.getAitTypeId() != null && this
						.getAitTypeId().equals(castOther.getAitTypeId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAiItemId() == null ? 0 : this.getAiItemId().hashCode());
		result = 37
				* result
				+ (getAicCategoryId() == null ? 0 : this.getAicCategoryId()
						.hashCode());
		result = 37 * result
				+ (getAitTypeId() == null ? 0 : this.getAitTypeId().hashCode());
		return result;
	}

}