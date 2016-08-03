package fwp.alsaccount.dao.admin;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AlsTribeItemInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ALS_TRIBE_ITEM_INFO", schema = "ALS")
public class AlsTribeItemInfo implements java.io.Serializable {

	// Fields

	private AlsTribeItemInfoIdPk idPk;
	private String atiTribeCd;
	private String atiiWhoLog;
	private Date atiiWhenLog;

	// Constructors

	/** default constructor */
	public AlsTribeItemInfo() {
	}

	/** full constructor */
	public AlsTribeItemInfo(AlsTribeItemInfoIdPk idPk, String atiTribeCd,
			String atiiWhoLog, Date atiiWhenLog) {
		this.idPk = idPk;
		this.atiTribeCd = atiTribeCd;
		this.atiiWhoLog = atiiWhoLog;
		this.atiiWhenLog = atiiWhenLog;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "aictUsagePeriodFrom", column = @Column(name = "AICT_USAGE_PERIOD_FROM", nullable = false, length = 7)),
			@AttributeOverride(name = "aictUsagePeriodTo", column = @Column(name = "AICT_USAGE_PERIOD_TO", nullable = false, length = 7)),
			@AttributeOverride(name = "aictItemTypeCd", column = @Column(name = "AICT_ITEM_TYPE_CD", nullable = false, length = 7)) })
	public AlsTribeItemInfoIdPk getIdPk() {
		return this.idPk;
	}

	public void setIdPk(AlsTribeItemInfoIdPk idPk) {
		this.idPk = idPk;
	}

	@Column(name = "ATI_TRIBE_CD", nullable = false, length = 5)
	public String getAtiTribeCd() {
		return this.atiTribeCd;
	}

	public void setAtiTribeCd(String atiTribeCd) {
		this.atiTribeCd = atiTribeCd;
	}

	@Column(name = "ATII_WHO_LOG", nullable = false, length = 15)
	public String getAtiiWhoLog() {
		return this.atiiWhoLog;
	}

	public void setAtiiWhoLog(String atiiWhoLog) {
		this.atiiWhoLog = atiiWhoLog;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ATII_WHEN_LOG", nullable = false, length = 7)
	public Date getAtiiWhenLog() {
		return this.atiiWhenLog;
	}

	public void setAtiiWhenLog(Date atiiWhenLog) {
		this.atiiWhenLog = atiiWhenLog;
	}

}