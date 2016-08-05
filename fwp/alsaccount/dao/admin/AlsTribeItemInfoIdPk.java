package fwp.alsaccount.dao.admin;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AlsTribeItemInfoIdPk entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class AlsTribeItemInfoIdPk implements java.io.Serializable {

	// Fields

	private Date aictUsagePeriodFrom;
	private Date aictUsagePeriodTo;
	private String aictItemTypeCd;

	// Constructors

	/** default constructor */
	public AlsTribeItemInfoIdPk() {
	}

	/** full constructor */
	public AlsTribeItemInfoIdPk(Date aictUsagePeriodFrom,
			Date aictUsagePeriodTo, String aictItemTypeCd) {
		this.aictUsagePeriodFrom = aictUsagePeriodFrom;
		this.aictUsagePeriodTo = aictUsagePeriodTo;
		this.aictItemTypeCd = aictItemTypeCd;
	}

	// Property accessors

	@Column(name = "AICT_USAGE_PERIOD_FROM", nullable = false, length = 7)
	public Date getAictUsagePeriodFrom() {
		return this.aictUsagePeriodFrom;
	}

	public void setAictUsagePeriodFrom(Date aictUsagePeriodFrom) {
		this.aictUsagePeriodFrom = aictUsagePeriodFrom;
	}

	@Column(name = "AICT_USAGE_PERIOD_TO", nullable = false, length = 7)
	public Date getAictUsagePeriodTo() {
		return this.aictUsagePeriodTo;
	}

	public void setAictUsagePeriodTo(Date aictUsagePeriodTo) {
		this.aictUsagePeriodTo = aictUsagePeriodTo;
	}

	@Column(name = "AICT_ITEM_TYPE_CD", nullable = false, length = 7)
	public String getAictItemTypeCd() {
		return this.aictItemTypeCd;
	}

	public void setAictItemTypeCd(String aictItemTypeCd) {
		this.aictItemTypeCd = aictItemTypeCd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AlsTribeItemInfoIdPk))
			return false;
		AlsTribeItemInfoIdPk castOther = (AlsTribeItemInfoIdPk) other;

		return ((this.getAictUsagePeriodFrom() == castOther
				.getAictUsagePeriodFrom()) || (this.getAictUsagePeriodFrom() != null
				&& castOther.getAictUsagePeriodFrom() != null && this
				.getAictUsagePeriodFrom().equals(
						castOther.getAictUsagePeriodFrom())))
				&& ((this.getAictUsagePeriodTo() == castOther
						.getAictUsagePeriodTo()) || (this
						.getAictUsagePeriodTo() != null
						&& castOther.getAictUsagePeriodTo() != null && this
						.getAictUsagePeriodTo().equals(
								castOther.getAictUsagePeriodTo())))
				&& ((this.getAictItemTypeCd() == castOther.getAictItemTypeCd()) || (this
						.getAictItemTypeCd() != null
						&& castOther.getAictItemTypeCd() != null && this
						.getAictItemTypeCd().equals(
								castOther.getAictItemTypeCd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAictUsagePeriodFrom() == null ? 0 : this
						.getAictUsagePeriodFrom().hashCode());
		result = 37
				* result
				+ (getAictUsagePeriodTo() == null ? 0 : this
						.getAictUsagePeriodTo().hashCode());
		result = 37
				* result
				+ (getAictItemTypeCd() == null ? 0 : this.getAictItemTypeCd()
						.hashCode());
		return result;
	}

}