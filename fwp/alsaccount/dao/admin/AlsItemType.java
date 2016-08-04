package fwp.alsaccount.dao.admin;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AlsItemType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ALS_ITEM_TYPE", schema = "ALS")
public class AlsItemType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlsItemTypeIdPk idPk;
	private String aitTypeDesc;
	private String aitWhoLog;
	private Timestamp aitWhenLog;

	// Constructors

	/** default constructor */
	public AlsItemType() {
	}

	/** full constructor */
	public AlsItemType(AlsItemTypeIdPk idPk, String aitTypeDesc,
			String aitWhoLog, Timestamp aitWhenLog) {
		this.idPk = idPk;
		this.aitTypeDesc = aitTypeDesc;
		this.aitWhoLog = aitWhoLog;
		this.aitWhenLog = aitWhenLog;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "aiItemId", column = @Column(name = "AI_ITEM_ID", nullable = false, length = 2)),
			@AttributeOverride(name = "aicCategoryId", column = @Column(name = "AIC_CATEGORY_ID", nullable = false, length = 2)),
			@AttributeOverride(name = "aitTypeId", column = @Column(name = "AIT_TYPE_ID", nullable = false, length = 3)) })
	public AlsItemTypeIdPk getIdPk() {
		return this.idPk;
	}

	public void setIdPk(AlsItemTypeIdPk idPk) {
		this.idPk = idPk;
	}

	@Column(name = "AIT_TYPE_DESC", nullable = false, length = 200)
	public String getAitTypeDesc() {
		return this.aitTypeDesc;
	}

	public void setAitTypeDesc(String aitTypeDesc) {
		this.aitTypeDesc = aitTypeDesc;
	}

	@Column(name = "AIT_WHO_LOG", nullable = false, length = 15)
	public String getAitWhoLog() {
		return this.aitWhoLog;
	}

	public void setAitWhoLog(String aitWhoLog) {
		this.aitWhoLog = aitWhoLog;
	}

	@Column(name = "AIT_WHEN_LOG", nullable = false, length = 7)
	public Timestamp getAitWhenLog() {
		return this.aitWhenLog;
	}

	public void setAitWhenLog(Timestamp aitWhenLog) {
		this.aitWhenLog = aitWhenLog;
	}

}